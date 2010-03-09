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

package com.amazonaws.cbui;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.amazonaws.utils.PropertyBundle;
import com.amazonaws.utils.PropertyKeys;

public abstract class AmazonFPSCBUIPipeline {

    protected static final String HTTP_GET_METHOD = "GET";
    protected static final String UTF_8_Encoding = "UTF-8";

    public static final String SIGNATURE_VERSION_KEYNAME = "signatureVersion"; 
    public static final String SIGNATURE_METHOD_KEYNAME = "signatureMethod"; 
    public static final String SIGNATURE_KEYNAME = "signature";
    
    public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    public static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    
    public static final String SIGNATURE_VERSION_1 = "2";
    public static final String SIGNATURE_VERSION_2 = "2";

    // Constants used when constructing the string to sign for v2
    public static final String NewLine = "\n";
    public static final String EmptyUriPath = "/";
    public static final String Equals = "=";
    public static final String And = "&"; 
    
    
    /**
     * Amazon Web Services Access Key ID.
     * 
     * @var string|bool 20-character, alphanumeric string, or false if this is an anonymous account
     */
    protected String awsAccessKey;

    /**
     * Amazon Web Services Secret Access Key.
     * 
     * @var string 40-character string
     */
    protected String awsSecretKey;

    /**
     * The default URL corresponds to production environment. Change the URL for sandbox
     */
    protected static String CBUI_URL = PropertyBundle.getProperty(PropertyKeys.CBUI_SERVICE_END_POINT);

    protected static String VERSION = "2009-01-09";

    protected static String SIGNATURE_VERSION = "2";
    
    protected static String SIGNATURE_METHOD = HMAC_SHA256_ALGORITHM;

    protected Map<String, String> parameters = new HashMap<String, String>();

    protected AmazonFPSCBUIPipeline(String pipelineName, String accessKey, String secretKey) {
        if (pipelineName == null || accessKey == null || secretKey == null) {
            throw new RuntimeException("PipelineName or AWSAccessKey or AWSSecretKey can not be empty.");
        }
        this.awsSecretKey = secretKey;
        this.awsAccessKey = accessKey;
        
        //Add default parameters
        addParameter("callerKey", this.awsAccessKey);
        addParameter("pipelineName", pipelineName);
        addParameter("version", VERSION);
        addParameter("signatureVersion", SIGNATURE_VERSION);
        addParameter("signatureMethod", SIGNATURE_METHOD);
    }

    /**
     * Add an optional parameter to pipeline request.
     * @param name - Name of the parameter to be added
     * @param value - value of the parameter to be added
     */
    public void addParameter(String name, String value) {
        parameters.put(name, value);
    }

    /**
     * Add a list of optional parameters to pipeline request.
     * @param params - name,value pairs of parameters.
     */
    public void addOptionalParameters(Map<String, String> params) {
        parameters.putAll(params);
    }

    /**
     * Construct the pipeline request url using given parameters. 
     * Computes signature and adds it as additional parameter.
     * @param parameters - Map of pipeline request parameters.
     * @return Returns the pipeline request url. 
     * @throws MalformedURLException
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    private String constructUrl(Map<String, String> parameters) throws MalformedURLException, SignatureException, UnsupportedEncodingException {

        if (parameters == null || parameters.isEmpty()) {
            throw new RuntimeException("Parameters can not be empty.");
        }

        String hostHeader = getHostHeader(CBUI_URL);
        String requestURI = getRequestURI(CBUI_URL);

        String signature = signParameters(parameters, HTTP_GET_METHOD, hostHeader, requestURI);
        parameters.put("signature", signature);

        String queryString = constructQueryString(parameters);
        
        return CBUI_URL + "?" + queryString;
    }


    private String constructQueryString(Map<String, String> parameters) throws UnsupportedEncodingException {
        StringBuilder queryStringBuilder = new StringBuilder();
        for (Entry<String, String> entry : parameters.entrySet()) {
            String key = URLEncoder.encode(entry.getKey(), UTF_8_Encoding);
            String value = URLEncoder.encode(entry.getValue(), UTF_8_Encoding);
            queryStringBuilder.append(key);
            queryStringBuilder.append("=");
            queryStringBuilder.append(value);
            queryStringBuilder.append("&");
        }
        
        String queryString = queryStringBuilder.toString();
        if (queryString.endsWith("&")) {
            queryString = queryString.substring(0, queryString.length() - 1);
        }
        return queryString;
    }


    private String getHostHeader(String urlEndPoint) throws MalformedURLException {
        URL url = new URL(urlEndPoint);
        int port = url.getPort();
        if (port != -1) {
            if ("HTTPS".equalsIgnoreCase(url.getProtocol()) && port == 443 || "HTTP".equalsIgnoreCase(url.getProtocol()) && port == 80)
                port = -1;
        }
        return url.getHost().toLowerCase() + (port != -1 ? ":" + port : "");
    }


    private String getRequestURI(String urlEndPoint) throws MalformedURLException {
        URL url = new URL(urlEndPoint);
        String requestURI = url.getPath();
        if (requestURI == null || requestURI.equals("")) {
            requestURI = "/";
        }
        return requestURI;
    }

    protected void validateCommonMandatoryParameters(Map<String, String> parameters) {
        if (!parameters.containsKey("pipelineName")) {
            throw new RuntimeException("pipelineName is missing in parameters.");
        }
        
        if (!parameters.containsKey("version")) {
            throw new RuntimeException("version is missing in parameters.");
        }

        if (!parameters.containsKey("returnURL")) {
            throw new RuntimeException("returnURL is missing in parameters.");
        }

        if (!parameters.containsKey("callerReference")) {
            throw new RuntimeException("callerReference is missing in parameters.");
        }
    }

    //Signature helper method
	/**
	 * Computes RFC 2104-compliant HMAC signature for request parameters
	 * This involves 2 steps - Calculate string-to-sign and then compute signature
	 *
	 * Step 1: Calculate string-to-sign
	 * If Signature Version is 1, it performs the following:
	 *
	 * Sorts all  parameters (including SignatureVersion and excluding Signature,
	 * the value of which is being created), ignoring case.
	 *
	 * Iterate over the sorted list and append the parameter name (in original case)
	 * and then its value. It will not URL-encode the parameter values before
	 * constructing this string. There are no separators.
	 *
	 * If Signature Version is 2, string to sign is based on following:
	 *
	 *    1. The HTTP Request Method (POST or GET) followed by an ASCII newline (%0A)
	 *    2. The HTTP Host header in the form of lowercase host, followed by an ASCII newline.
	 *    3. The URL encoded HTTP absolute path component of the URI
	 *       (up to but not including the query string parameters);
	 *       if this is empty use a forward '/'. This parameter is followed by an ASCII newline.
	 *    4. The concatenation of all query string components (names and values)
	 *       as UTF-8 characters which are URL encoded as per RFC 3986
	 *       (hex characters MUST be uppercase), sorted using lexicographic byte ordering.
	 *       Parameter names are separated from their values by the '=' character
	 *       (ASCII character 61), even if the value is empty.
	 *       Pairs of parameter and values are separated by the '&' character (ASCII code 38).
	 *       
	 * Step 2: Compute RFC 2104-compliant HMAC signature
	 */
	public String signParameters(Map<String, String> parameters, String httpMethod, 
			String host, String requestURI) throws SignatureException {
		String signatureVersion = parameters.get(SIGNATURE_VERSION_KEYNAME);
		String algorithm = HMAC_SHA1_ALGORITHM;
		String stringToSign = null;
		String signature = null;
		if (SIGNATURE_VERSION_2.equals(signatureVersion)) {
			//algorithm should be either HMAC_SHA256_ALGORITHM (preferred) or HMAC_SHA1_ALGORITHM
			algorithm = parameters.get(SIGNATURE_METHOD_KEYNAME);
			stringToSign = calculateStringToSignV2(parameters, httpMethod, host, requestURI);
		} else {
            stringToSign = calculateStringToSignV1(parameters);
		}
		signature = sign(stringToSign, this.awsSecretKey, algorithm);
		return signature;
	}

	/**
	 * Calculate String to Sign for SignatureVersion 1
	 * @param parameters request parameters
	 * @return String to Sign
	 * @throws java.security.SignatureException
	 */
	private static String calculateStringToSignV1(Map<String, String> parameters) {
		StringBuilder data = new StringBuilder();
		Map<String, String> sorted = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		sorted.putAll(parameters);
		Iterator<Map.Entry<String, String>> pairs = sorted.entrySet().iterator();
		while (pairs.hasNext()) {
			Map.Entry<String, String> pair = pairs.next();
			if (pair.getKey().equalsIgnoreCase(SIGNATURE_KEYNAME)) continue;
			data.append(pair.getKey());
			data.append(pair.getValue());
		}
		return data.toString();
	}

	/**
	 * Calculate String to Sign for SignatureVersion 2
	 * @param parameters
	 * @param httpMethod - POST or GET
	 * @param hostHeader - Service end point
	 * @param requestURI - Path
	 * @return
	 * @throws SignatureException
	 */
	private String calculateStringToSignV2(Map<String, String> parameters, 
	        String httpMethod, String hostHeader, String requestURI) throws SignatureException {
		StringBuffer stringToSign = new StringBuffer("");
		if (httpMethod == null) throw new SignatureException("HttpMethod cannot be null");
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
			if (pair.getKey().equalsIgnoreCase(SIGNATURE_KEYNAME)) continue;
			stringToSign.append(urlEncode(pair.getKey(), false));
			stringToSign.append(Equals);
			stringToSign.append(urlEncode(pair.getValue(), false));
			if (pairs.hasNext()) stringToSign.append(And);
		}
		return stringToSign.toString();
	}

	private static String urlEncode(String value, boolean path) {
		String encoded = null;
		try {
			encoded = URLEncoder.encode(value, UTF_8_Encoding).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
			if (path) encoded = encoded.replace("%2F", "/");
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException(ex);
		}
		return encoded;
	}

	/**
	 * Computes RFC 2104-compliant HMAC signature.
	 */
	private static String sign(String data, String key, String signatureMethod) throws SignatureException {
		String signature = "";
		try {
			Mac mac = Mac.getInstance(signatureMethod);
			mac.init(new SecretKeySpec(key.getBytes(), signatureMethod));
			signature = new String(Base64.encodeBase64(mac.doFinal(data.getBytes(UTF_8_Encoding))));
		} catch (Exception e) {
			throw new SignatureException("Failed to generate signature: " + e.getMessage(), e);
		}
		return signature;
	}

    protected abstract void validateParameters(Map<String, String> parameters);

    /**
     * @return Returns the url with all the mandatory and optoinal parameters as query string.
     * Also adds signature to the query string.
     * @throws MalformedURLException
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    public String getUrl() 
        throws MalformedURLException, SignatureException, UnsupportedEncodingException {
        validateCommonMandatoryParameters(parameters);
        validateParameters(parameters);
        return constructUrl(parameters);
    }
}
