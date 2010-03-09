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
 * Get Account Activity  Samples
 *
 *
 */
public class GetAccountActivitySample {

    /**
     * Just add few required parameters, and try the service
     * Get Account Activity functionality
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
         * sample for Get Account Activity 
         ***********************************************************************/
         GetAccountActivityRequest fpsRequest = new GetAccountActivityRequest();
        
         // @TODO: set request parameters here

         // invokeGetAccountActivity(service, fpsRequest);

    }


                                    
    /**
     * Get Account Activity  request sample
     * 
     * Returns transactions for a given date range.
     *   
     * @param service instance of AmazonFPS service
     * @param request Action to invoke
     */
    public static void invokeGetAccountActivity(AmazonFPS service, GetAccountActivityRequest fpsRequest) {
        try {
            
            GetAccountActivityResponse fpsResponse = service.getAccountActivity(fpsRequest);

            
            System.out.println ("GetAccountActivity Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    GetAccountActivityResponse");
            System.out.println();
            if (fpsResponse.isSetGetAccountActivityResult()) {
                System.out.println("        GetAccountActivityResult");
                System.out.println();
                GetAccountActivityResult  getAccountActivityResult = fpsResponse.getGetAccountActivityResult();
                if (getAccountActivityResult.isSetBatchSize()) {
                    System.out.println("            BatchSize");
                    System.out.println();
                    System.out.println("                " + getAccountActivityResult.getBatchSize());
                    System.out.println();
                }
                java.util.List<Transaction> transactionList = getAccountActivityResult.getTransaction();
                for (Transaction transaction : transactionList) {
                    System.out.println("            Transaction");
                    System.out.println();
                    if (transaction.isSetTransactionId()) {
                        System.out.println("                TransactionId");
                        System.out.println();
                        System.out.println("                    " + transaction.getTransactionId());
                        System.out.println();
                    }
                    if (transaction.isSetCallerTransactionDate()) {
                        System.out.println("                CallerTransactionDate");
                        System.out.println();
                        System.out.println("                    " + transaction.getCallerTransactionDate());
                        System.out.println();
                    }
                    if (transaction.isSetDateReceived()) {
                        System.out.println("                DateReceived");
                        System.out.println();
                        System.out.println("                    " + transaction.getDateReceived());
                        System.out.println();
                    }
                    if (transaction.isSetDateCompleted()) {
                        System.out.println("                DateCompleted");
                        System.out.println();
                        System.out.println("                    " + transaction.getDateCompleted());
                        System.out.println();
                    }
                    if (transaction.isSetTransactionAmount()) {
                        System.out.println("                TransactionAmount");
                        System.out.println();
                        Amount  transactionAmount = transaction.getTransactionAmount();
                        if (transactionAmount.isSetCurrencyCode()) {
                            System.out.println("                    CurrencyCode");
                            System.out.println();
                            System.out.println("                        " + transactionAmount.getCurrencyCode().value());
                            System.out.println();
                        }
                        if (transactionAmount.isSetValue()) {
                            System.out.println("                    Value");
                            System.out.println();
                            System.out.println("                        " + transactionAmount.getValue());
                            System.out.println();
                        }
                    } 
                    if (transaction.isSetFPSOperation()) {
                        System.out.println("                FPSOperation");
                        System.out.println();
                        System.out.println("                    " + transaction.getFPSOperation().value());
                        System.out.println();
                    }
                    if (transaction.isSetTransactionStatus()) {
                        System.out.println("                TransactionStatus");
                        System.out.println();
                        System.out.println("                    " + transaction.getTransactionStatus().value());
                        System.out.println();
                    }
                    if (transaction.isSetStatusMessage()) {
                        System.out.println("                StatusMessage");
                        System.out.println();
                        System.out.println("                    " + transaction.getStatusMessage());
                        System.out.println();
                    }
                    if (transaction.isSetStatusCode()) {
                        System.out.println("                StatusCode");
                        System.out.println();
                        System.out.println("                    " + transaction.getStatusCode());
                        System.out.println();
                    }
                    if (transaction.isSetOriginalTransactionId()) {
                        System.out.println("                OriginalTransactionId");
                        System.out.println();
                        System.out.println("                    " + transaction.getOriginalTransactionId());
                        System.out.println();
                    }
                    java.util.List<TransactionPart> transactionPartList = transaction.getTransactionPart();
                    for (TransactionPart transactionPart : transactionPartList) {
                        System.out.println("                TransactionPart");
                        System.out.println();
                        if (transactionPart.isSetInstrumentId()) {
                            System.out.println("                    InstrumentId");
                            System.out.println();
                            System.out.println("                        " + transactionPart.getInstrumentId());
                            System.out.println();
                        }
                        if (transactionPart.isSetRole()) {
                            System.out.println("                    Role");
                            System.out.println();
                            System.out.println("                        " + transactionPart.getRole().value());
                            System.out.println();
                        }
                        if (transactionPart.isSetName()) {
                            System.out.println("                    Name");
                            System.out.println();
                            System.out.println("                        " + transactionPart.getName());
                            System.out.println();
                        }
                        if (transactionPart.isSetReference()) {
                            System.out.println("                    Reference");
                            System.out.println();
                            System.out.println("                        " + transactionPart.getReference());
                            System.out.println();
                        }
                        if (transactionPart.isSetDescription()) {
                            System.out.println("                    Description");
                            System.out.println();
                            System.out.println("                        " + transactionPart.getDescription());
                            System.out.println();
                        }
                        if (transactionPart.isSetFeesPaid()) {
                            System.out.println("                    FeesPaid");
                            System.out.println();
                            Amount  feesPaid = transactionPart.getFeesPaid();
                            if (feesPaid.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + feesPaid.getCurrencyCode().value());
                                System.out.println();
                            }
                            if (feesPaid.isSetValue()) {
                                System.out.println("                        Value");
                                System.out.println();
                                System.out.println("                            " + feesPaid.getValue());
                                System.out.println();
                            }
                        } 
                    }
                    if (transaction.isSetPaymentMethod()) {
                        System.out.println("                PaymentMethod");
                        System.out.println();
                        System.out.println("                    " + transaction.getPaymentMethod().value());
                        System.out.println();
                    }
                    if (transaction.isSetSenderName()) {
                        System.out.println("                SenderName");
                        System.out.println();
                        System.out.println("                    " + transaction.getSenderName());
                        System.out.println();
                    }
                    if (transaction.isSetCallerName()) {
                        System.out.println("                CallerName");
                        System.out.println();
                        System.out.println("                    " + transaction.getCallerName());
                        System.out.println();
                    }
                    if (transaction.isSetRecipientName()) {
                        System.out.println("                RecipientName");
                        System.out.println();
                        System.out.println("                    " + transaction.getRecipientName());
                        System.out.println();
                    }
                    if (transaction.isSetFPSFees()) {
                        System.out.println("                FPSFees");
                        System.out.println();
                        Amount  FPSFees = transaction.getFPSFees();
                        if (FPSFees.isSetCurrencyCode()) {
                            System.out.println("                    CurrencyCode");
                            System.out.println();
                            System.out.println("                        " + FPSFees.getCurrencyCode().value());
                            System.out.println();
                        }
                        if (FPSFees.isSetValue()) {
                            System.out.println("                    Value");
                            System.out.println();
                            System.out.println("                        " + FPSFees.getValue());
                            System.out.println();
                        }
                    } 
                    if (transaction.isSetBalance()) {
                        System.out.println("                Balance");
                        System.out.println();
                        Amount  balance = transaction.getBalance();
                        if (balance.isSetCurrencyCode()) {
                            System.out.println("                    CurrencyCode");
                            System.out.println();
                            System.out.println("                        " + balance.getCurrencyCode().value());
                            System.out.println();
                        }
                        if (balance.isSetValue()) {
                            System.out.println("                    Value");
                            System.out.println();
                            System.out.println("                        " + balance.getValue());
                            System.out.println();
                        }
                    } 
                    if (transaction.isSetSenderTokenId()) {
                        System.out.println("                SenderTokenId");
                        System.out.println();
                        System.out.println("                    " + transaction.getSenderTokenId());
                        System.out.println();
                    }
                    if (transaction.isSetRecipientTokenId()) {
                        System.out.println("                RecipientTokenId");
                        System.out.println();
                        System.out.println("                    " + transaction.getRecipientTokenId());
                        System.out.println();
                    }
                }
                if (getAccountActivityResult.isSetStartTimeForNextTransaction()) {
                    System.out.println("            StartTimeForNextTransaction");
                    System.out.println();
                    System.out.println("                " + getAccountActivityResult.getStartTimeForNextTransaction());
                    System.out.println();
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
