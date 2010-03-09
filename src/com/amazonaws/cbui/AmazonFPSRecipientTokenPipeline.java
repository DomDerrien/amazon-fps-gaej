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

import java.util.Map;

public class AmazonFPSRecipientTokenPipeline extends AmazonFPSCBUIPipeline {

    public AmazonFPSRecipientTokenPipeline(String accessKey, String secretKey) {
        super("Recipient", accessKey, secretKey);
    }

    /**
     * Set mandatory parameters required for recipient token pipeline.
     */
    public void setMandatoryParameters(String callerReference, String returnUrl, 
            long maxFixedFee, long maxVariableFee, boolean recipientPaysFee) {
        addParameter("callerReference", callerReference);
        addParameter("returnURL", returnUrl);
        addParameter("maxFixedFee", Long.toString(maxFixedFee));
        addParameter("maxVariableFee", Long.toString(maxVariableFee));
        addParameter("recipientPaysFee", (recipientPaysFee ? "True" : "False"));
    }

    @Override
    protected void validateParameters(Map<String, String> parameters) {
        //mandatory parameters for recipient token pipeline
        if (!parameters.containsKey("maxFixedFee")) {
            throw new RuntimeException("maxFixedFee is missing in parameters.");
        }

        if (!parameters.containsKey("maxVariableFee")) {
            throw new RuntimeException("maxVariableFee is missing in parameters.");
        }

        if (!parameters.containsKey("recipientPaysFee")) {
            throw new RuntimeException("recipientPaysFee is missing in parameters.");
        }
    }

}
