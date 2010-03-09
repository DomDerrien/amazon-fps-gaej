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

import java.util.List;
import java.util.Map;

public class AmazonFPSMultiUsePipeline extends AmazonFPSCBUIPipeline {

    public AmazonFPSMultiUsePipeline(String accessKey, String secretKey) {
        super("MultiUse", accessKey, secretKey);
    }

    /**
     * Set mandatory parameters required for multi use token pipeline.
     */
    public void setMandatoryParameters(String callerReference, String returnUrl, String globalAmountLimit) {
        addParameter("callerReference", callerReference);
        addParameter("returnURL", returnUrl);
        addParameter("globalAmountLimit", globalAmountLimit);
    }
    
    /**
     * Set usage limits for multi use token pipeline.
     */
    public void setUsageLimit1(String limitType, String limitValue, String limitPeriod) {
        addParameter("usageLimitType1", limitType);
        addParameter("usageLimitValue1", limitValue);
        if (limitPeriod != null) {
            addParameter("usageLimitPeriod1", limitPeriod);
        }
    }

    /**
     * Set usage limits for multi use token pipeline.
     */
    public void setUsageLimit2(String limitType, String limitValue, String limitPeriod) {
        addParameter("usageLimitType1", limitType);
        addParameter("usageLimitValue1", limitValue);
        if (limitPeriod != null) {
            addParameter("usageLimitPeriod1", limitPeriod);
        }
    }

    /**
     * Set recipient token list for multi use token pipeline.
     */
    public void setRecipientTokenList(boolean isRecipientCobranding, List<String> tokens) {
        addParameter("isRecipientCobranding", (isRecipientCobranding ? "True" : "False"));
        
        if (tokens == null || tokens.isEmpty()) return;
        
        StringBuilder tokenListBuilder = new StringBuilder();
        for (String token : tokens) {
            tokenListBuilder.append(token); tokenListBuilder.append(",");
        }
        
        String tokenList = tokenListBuilder.toString();
        tokenList = tokenList.substring(0, tokenList.length() - 1);
        
        addParameter("recipientTokenList", tokenList);
    }
    
    @Override
    protected void validateParameters(Map<String, String> parameters) {
        //mandatory parameters for multi use pipeline
        if (!parameters.containsKey("globalAmountLimit")) {
            throw new RuntimeException("globalAmountLimit is missing in parameters.");
        }
        
        //conditional parameters for multi use pipeline
        if (parameters.containsKey("isRecipientCobranding") && !parameters.containsKey("recipientTokenList")) {
            throw new RuntimeException("recipientTokenList is missing in parameters.");
        }

        if (parameters.containsKey("usageLimitType1") && !parameters.containsKey("usageLimitValue1")) {
            throw new RuntimeException("usageLimitValue1 is missing in parameters.");
        }

        if (parameters.containsKey("usageLimitType2") && !parameters.containsKey("usageLimitValue2")) {
            throw new RuntimeException("usageLimitValue2 is missing in parameters.");
        }
    }

}
