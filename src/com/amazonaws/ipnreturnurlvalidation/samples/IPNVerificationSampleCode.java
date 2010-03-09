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

package com.amazonaws.ipnreturnurlvalidation.samples;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.ipnreturnurlvalidation.SignatureUtilsForOutbound;

public class IPNVerificationSampleCode {

    public static void main(String... args) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        
        //Parameters present in ipn.
        params.put("transactionId", "14DRG2JGR7LK4J54P544DKKNDLQFFZLE323");
        params.put("transactionDate", "1251832057");
        params.put("status", "INITIATED");
        params.put("notificationType", "TransactionStatus");
        params.put("callerReference", "callerReference=ReferenceStringJYI1251832057319108");
        params.put("operation", "PAY");
        params.put("transactionAmount", "USD 1.00");
        params.put("buyerName", "BuyerName-SsUo3oDjHx");
        params.put("paymentMethod", "CC");
        params.put("paymentReason", "DescriptionString-1251832057319108");
        params.put("recipientEmail", "recipientemail@amazon.com");
        params.put("signature", "VEAAvfPO2F0IGaDGXYemaQQfzkA=");
        params.put("signatureMethod", "RSA-SHA1");
        params.put("signatureVersion", "2");
        params.put("certificateUrl", "https://fps.amazonaws.com/certs/090909/PKICert.pem");
        params.put("signature", "vKXXCbtxvSkRR+Zn8YNW6DNGpbi474h2iM4L+xaOi16kYKdYpuGbvKyXQ36uTZTVHdUGAAcvpXFL"
                + "wDfnTcqcckr2IUElrVJKQeT0WeWR+IqmABwSRGo+YqjzPNISSNXNzg6LFhouhUvmmwY15X3YgXfc"
                + "ERN5IhPwv04YkyCLPCA9P0/QgD8Jum/hc9jj0HYjj3s3MuuQ3yoIhf2x+2CBZRm5lslRqnoF/8OJ"
                + "1ZHmAHt9VvQSZ+QC3fwJgeqzJPAvtuOm930BP6hPYZVhXE5w7ByLt0qLk1ZFE/vzQ4io4vOyie6W"
                + "bhp5+AuNyAs+QrGMYO8VZruZJfkZO4b6QOgV2A==");
        

        String urlEndPoint = "http://www.mysite.com/ipn.jsp"; //Your url end point receiving the ipn. 
        System.out.println("Verifying IPN signed using signature v2 ....");
        //IPN is sent as a http POST request and hence we specify POST as the http method.
        //Signature verification does not require your secret key
        System.out.println("Is signature correct: " + (new SignatureUtilsForOutbound()).validateRequest(params, urlEndPoint, "POST"));
    }
}
