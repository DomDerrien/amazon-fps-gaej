/******************************************************************************* 
 *  Copyright 2008 Amazon Technologies, Inc.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 *    __  _    _  ___ 
 *   (  )( \/\/ )/ __)
 *   /__\ \    / \__ \
 *  (_)(_) \/\/  (___/
 * 
 *  Amazon FPS Java Library
 *  API Version: 2008-09-17
 *  Generated: Tue Sep 29 03:25:00 PDT 2009 
 * 
 */

/******************************************************************************* 
 *  Adapted by Dom Derrien for the Java platform of Google App Engine
 *  Copyright 2010 Dom Derrien
 * *****************************************************************************
 *  Change scope:
 *  - Replace the call to the static method HttpURLConnection.getFollowRedirects()
 *    by an one related to a HttpURLConnection instance.
 */

package com.amazonaws.ipnreturnurlvalidation;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class SignatureUtilsForOutbound {

    public static final String SIGNATURE_KEYNAME = "signature";
    public static final String SIGNATURE_METHOD_KEYNAME = "signatureMethod";
    public static final String SIGNATURE_VERSION_KEYNAME = "signatureVersion";
    public static final String SIGNATURE_VERSION_2 = "2";
    public static final String RSA_SHA1_ALGORITHM = "SHA1withRSA";
    public static final String CERTIFICATE_URL_KEYNAME = "certificateUrl";
    
    private static final String EMPTY_STRING = "";
    private static Map<String, String> keyStore = new HashMap<String, String>();

    // Constants used when constructing the string to sign for v2
    private static final String NewLine = "\n";
    private static final String EmptyUriPath = "/";
    private static final String Equals = "=";
    private static final String And = "&";

    private static final String UTF_8_Encoding = "UTF-8";


    /**
     * Amazon Web Services Access Key ID.
     *
     * @var string|bool 20-character, alphanumeric string, or false if this is
     * an anonymous account
     */
    private String awsAccessKey;

    /**
     * Your 40 character aws secret key. Required only for ipn or return url verification signed using signature version1.
     */
    private String awsSecretKey;

    /**
     *  Use this for verifying IPNs or return urls signed using signature version 2.
     */
    public SignatureUtilsForOutbound() {}


    /**
     *  Use this for verifying IPNs or return urls signed using signature version 1.
     */
    public SignatureUtilsForOutbound(String awsAccessKey, String awsSecretKey) {
        this.awsAccessKey = awsAccessKey;
        this.awsSecretKey = awsSecretKey;
    }


    /**
     * Validates the request by checking the integrity of its parameters.
     * @param parameters - all the http parameters sent in IPNs or return urls. 
     * @param urlEndPoint should be the url which recieved this request. 
     * @param httpMethod should be either POST (IPNs) or GET (returnUrl redirections)
     */
    public boolean validateRequest(Map<String, String> parameters, String urlEndPoint, String httpMethod) throws SignatureException  {

        //This is present only in case of signature version 2. If this is not present we assume this is signature version 1. 
        String signatureVersion = parameters.get(SIGNATURE_VERSION_KEYNAME);
        if (SIGNATURE_VERSION_2.equals(signatureVersion)) {
            return validateSignatureV2(parameters, urlEndPoint, httpMethod);
        } else {
            return validateSignatureV1(parameters);
        }
    }


    private boolean validateSignatureV1(Map<String, String> parameters) throws SignatureException {
        
        if (this.awsSecretKey == null) {
            throw new SignatureException("Signature can not be verified without aws secret key.");
        }

        String stringToSign = calculateStringToSignV1(parameters);
        String signature = parameters.get(SIGNATURE_KEYNAME);

        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(this.awsSecretKey.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(stringToSign.getBytes("UTF-8"));
            result = new String(Base64.encodeBase64(rawHmac));
        } catch (NoSuchAlgorithmException e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        } catch (InvalidKeyException e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }

        return result.equals(signature);
    }

    /**
     * Verifies the signature using PKI.
     */
    private boolean validateSignatureV2(Map<String, String> parameters, 
            String urlEndPoint, String httpMethod) throws SignatureException {

        //1. input validation.
        String signature = parameters.get(SIGNATURE_KEYNAME);
        if (signature == null) {
            throw new SignatureException("'signature' is missing from the parameters.");
        }

        String signatureMethod = parameters.get(SIGNATURE_METHOD_KEYNAME);
        if (signatureMethod == null) {
            throw new SignatureException("'signatureMethod' is missing from the parameters.");
        }
        
        String signatureAlgorithm = getSignatureAlgorithm(signatureMethod);
        if (signatureAlgorithm == null) {
            throw new SignatureException("'signatureMethod' present in parameters is invalid. " +
            		"Valid signatureMethods are : 'RSA-SHA1'");
        }

        String certificateUrl = parameters.get(CERTIFICATE_URL_KEYNAME);
        if (certificateUrl == null) {
            throw new SignatureException("'certificateUrl' is missing from the parameters.");
        }
        
        String certificate = getPublicKeyCertificateAsString(certificateUrl);
        if (certificate == null) {
            throw new SignatureException("public key certificate could not fetched from url: " + certificateUrl);
        }

        //2. calculating the string to sign
        String stringToSign = EMPTY_STRING;
        try {
            URL url = new URL(urlEndPoint);
            String hostHeader = getHostHeader(url);
            String requestURI = getRequestURI(url);
            stringToSign = calculateStringToSignV2(parameters, httpMethod, hostHeader, requestURI);
        } catch (MalformedURLException e) {
            throw new SignatureException(e);
        }
        
        //3. verify signature 
        try {
            CertificateFactory factory = CertificateFactory.getInstance("X.509");
            X509Certificate x509Certificate = 
                (X509Certificate) factory.generateCertificate(new ByteArrayInputStream(certificate.getBytes()));
            Signature signatureInstance = Signature.getInstance(signatureAlgorithm);
            signatureInstance.initVerify(x509Certificate.getPublicKey());
            signatureInstance.update(stringToSign.getBytes(UTF_8_Encoding));
            return signatureInstance.verify(Base64.decodeBase64(signature.getBytes()));
        } catch (CertificateException e) {
            throw new SignatureException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new SignatureException(e);
        } catch (InvalidKeyException e) {
            throw new SignatureException(e);
        } catch (UnsupportedEncodingException e) {
            throw new SignatureException(e);
        }
    }


    /**
     * Calculate String to Sign for SignatureVersion 1
     * 
     * @param parameters
     *            request parameters
     * @return String to Sign
     */
    private String calculateStringToSignV1(Map<String, String> parameters) {
        StringBuilder data = new StringBuilder();
        Map<String, String> sorted = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        sorted.putAll(parameters);
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(SIGNATURE_KEYNAME))
                continue;
            data.append(entry.getKey());
            data.append(entry.getValue());
        }
        return data.toString();
    }


    /**
     * Calculate String to Sign for SignatureVersion 2
     * 
     * @param parameters
     * @param httpMethod
     *            - POST or GET
     * @param hostHeader
     *            - Service end point
     * @param requestURI
     *            - Path
     * @return
     * @throws SignatureException
     */
    private String calculateStringToSignV2(Map<String, String> parameters, 
            String httpMethod, String hostHeader, String requestURI) throws SignatureException {
        StringBuffer stringToSign = new StringBuffer("");
        if (httpMethod == null)
            throw new SignatureException("HttpMethod cannot be null");
        stringToSign.append(httpMethod);
        stringToSign.append(NewLine);

        // The host header - must eventually convert to lower case
        // Host header should not be null, but in Http 1.0, it can be, in that
        // case just append empty string ""
        if (hostHeader == null) {
            stringToSign.append("");
        } else {
            stringToSign.append(hostHeader.toLowerCase());
        } 
        stringToSign.append(NewLine);

        if (requestURI == null || requestURI.length() == 0) {
            stringToSign.append(EmptyUriPath);
        } else {
            stringToSign.append(urlEncode(requestURI, true));
        }
        stringToSign.append(NewLine);

        Map<String, String> sortedParamMap = new TreeMap<String, String>();
        sortedParamMap.putAll(parameters);
        Iterator<Map.Entry<String, String>> pairs = sortedParamMap.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            if (pair.getKey().equalsIgnoreCase(SIGNATURE_KEYNAME))
                continue;
            stringToSign.append(urlEncode(pair.getKey(), false));
            stringToSign.append(Equals);
            stringToSign.append(urlEncode(pair.getValue(), false));
            if (pairs.hasNext())
                stringToSign.append(And);
        }
        return stringToSign.toString();
    }


    private String getHostHeader(URL url) {
        int port = url.getPort();
        if (port != -1) {
            if ("HTTPS".equalsIgnoreCase(url.getProtocol()) && port == 443 || "HTTP".equalsIgnoreCase(url.getProtocol()) && port == 80)
                port = -1;
        }
        return url.getHost().toLowerCase() + (port != -1 ? ":" + port : "");
    }


    private String getRequestURI(URL url) {
        String requestURI = url.getPath();
        if (requestURI == null || requestURI.equals(EMPTY_STRING)) {
            requestURI = "/";
        } else {
            requestURI = urlDecode(requestURI);
        }
        return requestURI;
    }


    private String getSignatureAlgorithm(String signatureMethod) {
        if ("RSA-SHA1".equals(signatureMethod)) {
            return RSA_SHA1_ALGORITHM;
        }
        return null;
    }


    /**
     * Fetches the public key certificate from the given url and caches it in memory.
     */
    private String getPublicKeyCertificateAsString(String certificateUrl) throws SignatureException {
        //1. Try to fetch from the in-memory cache
        String certificate = keyStore.get(certificateUrl);
        if (certificate != null) return certificate;

        // Dom Derrien: update to not use the static function, forbidden in GAE Java environment
		//   Cf. http://code.google.com/p/googleappengine/issues/detail?id=1556
		//   Cf. http://code.google.com/appengine/docs/java/urlfetch/usingjavanet.html#Redirects
        try {
	        //2. If not found in cache, fetch it
	        // boolean followRedirects = HttpURLConnection.getFollowRedirects();
	        // HttpURLConnection.setFollowRedirects(false);
			URL url = new URL("http://aws.amazon.com/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			boolean followRedirects = connection.getInstanceFollowRedirects();
			connection.setInstanceFollowRedirects(false);
	        try {
	            certificate = URLReader.getUrlContents(certificateUrl);
	        } catch (IOException e) {
	            throw new SignatureException(e);
	        } finally {
	            HttpURLConnection.setFollowRedirects(followRedirects);
	        }
		}
		catch (MalformedURLException ex) {
			throw new SignatureException(ex);
		}
		catch (IOException ex) {
			throw new SignatureException(ex);
		}
        
        //3. populate newly fetched certificate in cache.
        keyStore.put(certificateUrl, certificate);
        
        return certificate;
    }


    private String urlEncode(String value, boolean path) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(value, UTF_8_Encoding).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
            if (path)
                encoded = encoded.replace("%2F", "/");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        return encoded;
    }


    private String urlDecode(String value) {
        String decoded = null;
        try {
            decoded = URLDecoder.decode(value, UTF_8_Encoding);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        return decoded;
    }
}


/**
 * Helps read content from a url. Maximum string length that can be read is 1MB.
 */
class URLReader {

    private static final int READ_THRESHOLD = 1024 * 1024; // 1MB
    private static final String NewLine = "\n";


    public static String getUrlContents(String urlString) throws IOException {
        URL url = new URL(urlString);
        if (url == null)
            return null;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder urlContents = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                urlContents.append(inputLine);
                urlContents.append(NewLine);
                if (urlContents.length() >= READ_THRESHOLD) {
                    throw new IOException("Size of the contents at the given url [" + url + "] exceeds threshold of [" + READ_THRESHOLD
                            + "]");
                }
            }
            return urlContents.toString();
        } finally {
            if (in != null)
                in.close();
        }
    }
}
