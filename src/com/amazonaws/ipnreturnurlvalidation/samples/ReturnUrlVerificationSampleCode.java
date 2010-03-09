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

public class ReturnUrlVerificationSampleCode {

    public static void main(String... args) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        
		//Parameters present in return url.
		params.put("expiry", "10/2013");
        params.put("tokenID", "Q5IG5ETFCEBU8KBLTI4JHINQVL6VAJVHICBRR49AKLPIEZH1KB1S8C7VHAJJMLJ3");
        params.put("status", "SC");
        params.put("callerReference", "1253247023946cMcrTRrjtLjNrZGNKchWfDtUEIGuJfiOBAAJYPjbytBV");
        params.put("signature", "IBUljqQYfKe4bdZU8YlCtcHmRBA=");
        params.put("signatureMethod", "RSA-SHA1");
        params.put("signatureVersion", "2");
        params.put("certificateUrl", "https://fps.amazonaws.com/certs/090909/PKICert.pem");
        params.put("signature", "H4NTAsp3YwAEiyQ86j5B53lksv2hwwEaEFxtdWFpy9xX764AZy/Dm0RLEykUUyPVLgqCOlMopay5"
                + "Qxr/VDwhdYAzgQzA8VCV8x9Mn0caKsJT2HCU6tSLNa6bLwzg/ildCm2lHDho1Xt2yaBHMt+/Cn4q"
                + "I5B+6PDrb8csuAWxW/mbUhk7AzazZMfQciJNjS5k+INlcvOOtQqoA/gVeBLsXK5jNsTh09cNa7pb"
                + "gAvey+0DEjYnIRX+beJV6EMCPZxnXDGo0fA1PENLWXIHtAoIJAfLYEkVbT2lva2tZ0KBBWENnSjf"
                + "26lMZVokypIo4huoGaZMp1IVkImFi3qC6ipCrw==");
        
        String urlEndPoint = "http://www.mysite.com/call_pay.jsp"; //Your return url end point. 
        System.out.println("Verifying return url signed using signature v2 ....");
        //return url is sent as a http GET request and hence we specify GET as the http method.
        //Signature verification does not require your secret key
        System.out.println("Is signature correct: " + (new SignatureUtilsForOutbound()).validateRequest(params, urlEndPoint, "GET"));
    }
}
