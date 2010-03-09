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
import com.amazonaws.fps.mock.AmazonFPSMock;
import com.amazonaws.utils.*;

/**
 *
 * Get Account Balance  Samples
 *
 *
 */
public class GetAccountBalanceSample {

    /**
     * Just add few required parameters, and try the service
     * Get Account Balance functionality
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
         ***********************************************************************/
        AmazonFPS service = new AmazonFPSClient(accessKeyId, secretAccessKey);
        
        /************************************************************************
         * Uncomment to try advanced configuration options. Available options are:
         *
         *  - Signature Version
         *  - Proxy Host and Proxy Port
         *  - Service URL
         *  - User Agent String to be sent to Amazon FPS   service
         *
         ***********************************************************************/
        // AmazonFPSConfig config = new AmazonFPSConfig();
        // config.setSignatureVersion("0");
        // AmazonFPS service = new AmazonFPSClient(accessKeyId, secretAccessKey, config);
 
        /************************************************************************
         * Uncomment to try out Mock Service that simulates Amazon FPS 
         * responses without calling Amazon FPS  service.
         *
         * Responses are loaded from local XML files. You can tweak XML files to
         * experiment with various outputs during development
         *
         * XML files available under com/amazonaws/fps/mock tree
         *
         ***********************************************************************/
        // AmazonFPS service = new AmazonFPSMock();

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out 
         * sample for Get Account Balance 
         ***********************************************************************/
         GetAccountBalanceRequest fpsRequest = new GetAccountBalanceRequest();
        
         // @TODO: set request parameters here

         // invokeGetAccountBalance(service, fpsRequest);

    }


                                        
    /**
     * Get Account Balance  request sample
     * 
     * Returns the account balance for an account in real time.
     *   
     * @param service instance of AmazonFPS service
     * @param request Action to invoke
     */
    public static void invokeGetAccountBalance(AmazonFPS service, GetAccountBalanceRequest fpsRequest) {
        try {
            
            GetAccountBalanceResponse fpsResponse = service.getAccountBalance(fpsRequest);

            
            System.out.println ("GetAccountBalance Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    GetAccountBalanceResponse");
            System.out.println();
            if (fpsResponse.isSetGetAccountBalanceResult()) {
                System.out.println("        GetAccountBalanceResult");
                System.out.println();
                GetAccountBalanceResult  getAccountBalanceResult = fpsResponse.getGetAccountBalanceResult();
                if (getAccountBalanceResult.isSetAccountBalance()) {
                    System.out.println("            AccountBalance");
                    System.out.println();
                    AccountBalance  accountBalance = getAccountBalanceResult.getAccountBalance();
                    if (accountBalance.isSetTotalBalance()) {
                        System.out.println("                TotalBalance");
                        System.out.println();
                        Amount  totalBalance = accountBalance.getTotalBalance();
                        if (totalBalance.isSetCurrencyCode()) {
                            System.out.println("                    CurrencyCode");
                            System.out.println();
                            System.out.println("                        " + totalBalance.getCurrencyCode().value());
                            System.out.println();
                        }
                        if (totalBalance.isSetValue()) {
                            System.out.println("                    Value");
                            System.out.println();
                            System.out.println("                        " + totalBalance.getValue());
                            System.out.println();
                        }
                    } 
                    if (accountBalance.isSetPendingInBalance()) {
                        System.out.println("                PendingInBalance");
                        System.out.println();
                        Amount  pendingInBalance = accountBalance.getPendingInBalance();
                        if (pendingInBalance.isSetCurrencyCode()) {
                            System.out.println("                    CurrencyCode");
                            System.out.println();
                            System.out.println("                        " + pendingInBalance.getCurrencyCode().value());
                            System.out.println();
                        }
                        if (pendingInBalance.isSetValue()) {
                            System.out.println("                    Value");
                            System.out.println();
                            System.out.println("                        " + pendingInBalance.getValue());
                            System.out.println();
                        }
                    } 
                    if (accountBalance.isSetPendingOutBalance()) {
                        System.out.println("                PendingOutBalance");
                        System.out.println();
                        Amount  pendingOutBalance = accountBalance.getPendingOutBalance();
                        if (pendingOutBalance.isSetCurrencyCode()) {
                            System.out.println("                    CurrencyCode");
                            System.out.println();
                            System.out.println("                        " + pendingOutBalance.getCurrencyCode().value());
                            System.out.println();
                        }
                        if (pendingOutBalance.isSetValue()) {
                            System.out.println("                    Value");
                            System.out.println();
                            System.out.println("                        " + pendingOutBalance.getValue());
                            System.out.println();
                        }
                    } 
                    if (accountBalance.isSetAvailableBalances()) {
                        System.out.println("                AvailableBalances");
                        System.out.println();
                        AvailableBalances  availableBalances = accountBalance.getAvailableBalances();
                        if (availableBalances.isSetDisburseBalance()) {
                            System.out.println("                    DisburseBalance");
                            System.out.println();
                            Amount  disburseBalance = availableBalances.getDisburseBalance();
                            if (disburseBalance.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + disburseBalance.getCurrencyCode().value());
                                System.out.println();
                            }
                            if (disburseBalance.isSetValue()) {
                                System.out.println("                        Value");
                                System.out.println();
                                System.out.println("                            " + disburseBalance.getValue());
                                System.out.println();
                            }
                        } 
                        if (availableBalances.isSetRefundBalance()) {
                            System.out.println("                    RefundBalance");
                            System.out.println();
                            Amount  refundBalance = availableBalances.getRefundBalance();
                            if (refundBalance.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + refundBalance.getCurrencyCode().value());
                                System.out.println();
                            }
                            if (refundBalance.isSetValue()) {
                                System.out.println("                        Value");
                                System.out.println();
                                System.out.println("                            " + refundBalance.getValue());
                                System.out.println();
                            }
                        } 
                    } 
                } 
            } 
            if (fpsResponse.isSetResponseMetadata()) {
                System.out.println("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = fpsResponse.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.println("            RequestId");
                    System.out.println();
                    System.out.println("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();

           
        } catch (AmazonFPSException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
        }
    }
                                                                                
}
