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



package com.amazonaws.fps.samples;

import java.util.List;
import java.util.ArrayList;
import com.amazonaws.fps.*;
import com.amazonaws.fps.model.*;
import com.amazonaws.utils.*;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 *
 * Get Total Prepaid Liability  Samples
 *
 *
 */
public class GetTotalPrepaidLiabilityAsyncSample {

    /**
     * Just add few required parameters, and try the service
     * Get Total Prepaid Liability functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        
        /************************************************************************
         * Access Key ID and Secret Acess Key ID, obtained from:
         * http://aws.amazon.com
         ***********************************************************************/
         String accessKeyId = PropertyBundle.getProperty(PropertyKeys.AWS_ACCESS_KEY);
         String secretAccessKey = PropertyBundle.getProperty(PropertyKeys.AWS_SECRET_KEY);

        /************************************************************************
         * Instantiate Http Client Implementation of Amazon FPS 
         * 
         * Important! Number of threads in executor should match number of connections
         * for http client.
         *
         ***********************************************************************/

         AmazonFPSConfig config = new AmazonFPSConfig().withMaxConnections (100);
         ExecutorService executor = Executors.newFixedThreadPool(100);
         AmazonFPSAsync service = new AmazonFPSAsyncClient(accessKeyId, secretAccessKey, config, executor);

        /************************************************************************
         * Setup requests parameters and invoke parallel processing. Of course
         * in real world application, there will be much more than a couple of
         * requests to process.
         ***********************************************************************/
         GetTotalPrepaidLiabilityRequest requestOne = new GetTotalPrepaidLiabilityRequest();
         // @TODO: set request parameters here

         GetTotalPrepaidLiabilityRequest requestTwo = new GetTotalPrepaidLiabilityRequest();
         // @TODO: set second request parameters here

         List<GetTotalPrepaidLiabilityRequest> requests = new ArrayList<GetTotalPrepaidLiabilityRequest>();
         requests.add(requestOne);
         requests.add(requestTwo);

         invokeGetTotalPrepaidLiability(service, requests);

         executor.shutdown();

    }


                                                                        
    /**
     * Get Total Prepaid Liability request sample
     * 
     * Returns the total liability held by the given account corresponding to all the prepaid instruments owned by the account.
     *   
     * @param service instance of AmazonFPS service
     * @param requests list of requests to process
     */
    public static void invokeGetTotalPrepaidLiability(AmazonFPSAsync service, List<GetTotalPrepaidLiabilityRequest> requests) {
        List<Future<GetTotalPrepaidLiabilityResponse>> responses = new ArrayList<Future<GetTotalPrepaidLiabilityResponse>>();
        for (GetTotalPrepaidLiabilityRequest fpsRequest : requests) {
            responses.add(service.getTotalPrepaidLiabilityAsync(fpsRequest));
        }
        for (Future<GetTotalPrepaidLiabilityResponse> future : responses) {
            while (!future.isDone()) {
                Thread.yield();
            }
            try {
                GetTotalPrepaidLiabilityResponse fpsResponse = future.get();
                // Original request corresponding to this response, if needed:
                GetTotalPrepaidLiabilityRequest originalRequest = requests.get(responses.indexOf(future));
                System.out.println("Response request id: " + fpsResponse.getResponseMetadata().getRequestId());
            } catch (Exception e) {
                if (e.getCause() instanceof AmazonFPSException) {
                    AmazonFPSException exception = AmazonFPSException.class.cast(e.getCause());
                    System.out.println("Caught Exception: " + exception.getMessage());
                    System.out.println("Response Status Code: " + exception.getStatusCode());
                    System.out.println("Error Code: " + exception.getErrorCode());
                    System.out.println("Error Type: " + exception.getErrorType());
                    System.out.println("Request ID: " + exception.getRequestId());
                    System.out.print("XML: " + exception.getXML());
                } else {
                    e.printStackTrace();
                }
            }
        }
    }
                                                
}
