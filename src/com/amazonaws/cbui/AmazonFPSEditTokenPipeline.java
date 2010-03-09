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

public class AmazonFPSEditTokenPipeline extends AmazonFPSCBUIPipeline {

    public AmazonFPSEditTokenPipeline(String accessKey, String secretKey) {
        super("EditToken", accessKey, secretKey);
    }

    /**
     * Set mandatory parameters required for edit token pipeline.
     */
    public void setMandatoryParameters(String callerReference, String returnUrl, String tokenId) {
        addParameter("callerReference", callerReference);
        addParameter("returnURL", returnUrl);
        addParameter("tokenId", tokenId);
    }

    @Override
    protected void validateParameters(Map<String, String> parameters) {
        //mandatory parameters for edit token pipeline
        if (!parameters.containsKey("tokenId")) {
            throw new RuntimeException("tokenId is missing in parameters.");
        }
    }

}
