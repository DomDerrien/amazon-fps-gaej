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
 * Get Transaction  Samples
 *
 *
 */
public class GetTransactionSample {

    /**
     * Just add few required parameters, and try the service
     * Get Transaction functionality
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
         * sample for Get Transaction 
         ***********************************************************************/
         GetTransactionRequest fpsRequest = new GetTransactionRequest();
        
         // @TODO: set request parameters here

         // invokeGetTransaction(service, fpsRequest);

    }


                                                                            
    /**
     * Get Transaction  request sample
     * 
     * Returns all details of a transaction.
     *   
     * @param service instance of AmazonFPS service
     * @param request Action to invoke
     */
    public static void invokeGetTransaction(AmazonFPS service, GetTransactionRequest fpsRequest) {
        try {
            
            GetTransactionResponse fpsResponse = service.getTransaction(fpsRequest);

            
            System.out.println ("GetTransaction Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    GetTransactionResponse");
            System.out.println();
            if (fpsResponse.isSetGetTransactionResult()) {
                System.out.println("        GetTransactionResult");
                System.out.println();
                GetTransactionResult  getTransactionResult = fpsResponse.getGetTransactionResult();
                if (getTransactionResult.isSetTransaction()) {
                    System.out.println("            Transaction");
                    System.out.println();
                    TransactionDetail  transaction = getTransactionResult.getTransaction();
                    if (transaction.isSetTransactionId()) {
                        System.out.println("                TransactionId");
                        System.out.println();
                        System.out.println("                    " + transaction.getTransactionId());
                        System.out.println();
                    }
                    if (transaction.isSetCallerReference()) {
                        System.out.println("                CallerReference");
                        System.out.println();
                        System.out.println("                    " + transaction.getCallerReference());
                        System.out.println();
                    }
                    if (transaction.isSetCallerDescription()) {
                        System.out.println("                CallerDescription");
                        System.out.println();
                        System.out.println("                    " + transaction.getCallerDescription());
                        System.out.println();
                    }
                    if (transaction.isSetSenderDescription()) {
                        System.out.println("                SenderDescription");
                        System.out.println();
                        System.out.println("                    " + transaction.getSenderDescription());
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
                    if (transaction.isSetMarketplaceFees()) {
                        System.out.println("                MarketplaceFees");
                        System.out.println();
                        Amount  marketplaceFees = transaction.getMarketplaceFees();
                        if (marketplaceFees.isSetCurrencyCode()) {
                            System.out.println("                    CurrencyCode");
                            System.out.println();
                            System.out.println("                        " + marketplaceFees.getCurrencyCode().value());
                            System.out.println();
                        }
                        if (marketplaceFees.isSetValue()) {
                            System.out.println("                    Value");
                            System.out.println();
                            System.out.println("                        " + marketplaceFees.getValue());
                            System.out.println();
                        }
                    } 
                    if (transaction.isSetFPSFeesPaidBy()) {
                        System.out.println("                FPSFeesPaidBy");
                        System.out.println();
                        System.out.println("                    " + transaction.getFPSFeesPaidBy().value());
                        System.out.println();
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
                    if (transaction.isSetPrepaidInstrumentId()) {
                        System.out.println("                PrepaidInstrumentId");
                        System.out.println();
                        System.out.println("                    " + transaction.getPrepaidInstrumentId());
                        System.out.println();
                    }
                    if (transaction.isSetCreditInstrumentId()) {
                        System.out.println("                CreditInstrumentId");
                        System.out.println();
                        System.out.println("                    " + transaction.getCreditInstrumentId());
                        System.out.println();
                    }
                    if (transaction.isSetFPSOperation()) {
                        System.out.println("                FPSOperation");
                        System.out.println();
                        System.out.println("                    " + transaction.getFPSOperation().value());
                        System.out.println();
                    }
                    if (transaction.isSetPaymentMethod()) {
                        System.out.println("                PaymentMethod");
                        System.out.println();
                        System.out.println("                    " + transaction.getPaymentMethod().value());
                        System.out.println();
                    }
                    if (transaction.isSetTransactionStatus()) {
                        System.out.println("                TransactionStatus");
                        System.out.println();
                        System.out.println("                    " + transaction.getTransactionStatus().value());
                        System.out.println();
                    }
                    if (transaction.isSetStatusCode()) {
                        System.out.println("                StatusCode");
                        System.out.println();
                        System.out.println("                    " + transaction.getStatusCode());
                        System.out.println();
                    }
                    if (transaction.isSetStatusMessage()) {
                        System.out.println("                StatusMessage");
                        System.out.println();
                        System.out.println("                    " + transaction.getStatusMessage());
                        System.out.println();
                    }
                    if (transaction.isSetSenderName()) {
                        System.out.println("                SenderName");
                        System.out.println();
                        System.out.println("                    " + transaction.getSenderName());
                        System.out.println();
                    }
                    if (transaction.isSetSenderEmail()) {
                        System.out.println("                SenderEmail");
                        System.out.println();
                        System.out.println("                    " + transaction.getSenderEmail());
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
                    if (transaction.isSetRecipientEmail()) {
                        System.out.println("                RecipientEmail");
                        System.out.println();
                        System.out.println("                    " + transaction.getRecipientEmail());
                        System.out.println();
                    }
                    java.util.List<RelatedTransaction> relatedTransactionList = transaction.getRelatedTransaction();
                    for (RelatedTransaction relatedTransaction : relatedTransactionList) {
                        System.out.println("                RelatedTransaction");
                        System.out.println();
                        if (relatedTransaction.isSetTransactionId()) {
                            System.out.println("                    TransactionId");
                            System.out.println();
                            System.out.println("                        " + relatedTransaction.getTransactionId());
                            System.out.println();
                        }
                        if (relatedTransaction.isSetRelationType()) {
                            System.out.println("                    RelationType");
                            System.out.println();
                            System.out.println("                        " + relatedTransaction.getRelationType().value());
                            System.out.println();
                        }
                    }
                    java.util.List<StatusHistory> statusHistoryList = transaction.getStatusHistory();
                    for (StatusHistory statusHistory : statusHistoryList) {
                        System.out.println("                StatusHistory");
                        System.out.println();
                        if (statusHistory.isSetDate()) {
                            System.out.println("                    Date");
                            System.out.println();
                            System.out.println("                        " + statusHistory.getDate());
                            System.out.println();
                        }
                        if (statusHistory.isSetTransactionStatus()) {
                            System.out.println("                    TransactionStatus");
                            System.out.println();
                            System.out.println("                        " + statusHistory.getTransactionStatus().value());
                            System.out.println();
                        }
                        if (statusHistory.isSetStatusCode()) {
                            System.out.println("                    StatusCode");
                            System.out.println();
                            System.out.println("                        " + statusHistory.getStatusCode());
                            System.out.println();
                        }
                        if (statusHistory.isSetAmount()) {
                            System.out.println("                    Amount");
                            System.out.println();
                            Amount  amount = statusHistory.getAmount();
                            if (amount.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + amount.getCurrencyCode().value());
                                System.out.println();
                            }
                            if (amount.isSetValue()) {
                                System.out.println("                        Value");
                                System.out.println();
                                System.out.println("                            " + amount.getValue());
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
