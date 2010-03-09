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

package com.amazonaws.cbui.samples;

import com.amazonaws.cbui.AmazonFPSRecurringTokenPipeline;
import com.amazonaws.utils.PropertyBundle;
import com.amazonaws.utils.PropertyKeys;

public class CBUIRecurringTokenPipelineSample {

    public static void main(String[] args) throws Exception {
        String accessKey = PropertyBundle.getProperty(PropertyKeys.AWS_ACCESS_KEY);
        String secretKey = PropertyBundle.getProperty(PropertyKeys.AWS_SECRET_KEY);
        
        AmazonFPSRecurringTokenPipeline pipeline= new AmazonFPSRecurringTokenPipeline(accessKey, secretKey);

        pipeline.setMandatoryParameters("callerReferenceRecurring", "http://www.mysite.com/call_back.jsp", "5", "1 Month");
        
        //optional parameters
        pipeline.addParameter("paymentMethod", "CC"); //accept only credit card payments
        pipeline.addParameter("paymentReason", "Monthly subscription of Times magazine");
        
        //RecurringToken url
        System.out.println("Sample CBUI url for RecurringToken pipeline :" + pipeline.getUrl());
    }
}

