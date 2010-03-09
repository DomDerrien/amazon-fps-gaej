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



package com.amazonaws.fps.mock;

import com.amazonaws.fps.model.*;
import com.amazonaws.fps.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.InputSource;

/**
 *
 * AmazonFPSMock is the implementation of AmazonFPS based
 * on the pre-populated set of XML files that serve local data. It simulates
 * responses from Amazon FPS service.
 *
 * Use this to test your application without making a call to Amazon FPS 
 *
 * Note, current Mock Service implementation does not valiadate requests
 *
 */
public  class AmazonFPSMock implements AmazonFPS {

    private final Log log = LogFactory.getLog(AmazonFPSMock.class);
    private static JAXBContext  jaxbContext;
    private static ThreadLocal<Unmarshaller> unmarshaller;


    /** Initialize JAXBContext and  Unmarshaller **/
    static {
        try {
            jaxbContext = JAXBContext.newInstance("com.amazonaws.fps.model", AmazonFPS.class.getClassLoader());
        } catch (JAXBException ex) {
            throw new ExceptionInInitializerError(ex);
        }
        unmarshaller = new ThreadLocal<Unmarshaller>() {
            protected synchronized Unmarshaller initialValue() {
                try {
                    return jaxbContext.createUnmarshaller();
                } catch(JAXBException e) {
                    throw new ExceptionInInitializerError(e);
                }
            }
        };
    }

    // Public API ------------------------------------------------------------//

        
    /**
     * Cancel Token 
     *
     * 
     * Cancels any token installed by the calling application on its own account.
     * 
     * @param request
     *          CancelToken Action
     * @return
     *          CancelToken Response from the service
     *
     * @throws AmazonFPSException
     */
    public CancelTokenResponse cancelToken(CancelTokenRequest request)
        throws AmazonFPSException {
        CancelTokenResponse response;
        try {
            response = (CancelTokenResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("CancelTokenResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Cancel 
     *
     * 
     * Cancels an ongoing transaction and puts it in cancelled state.
     * 
     * @param request
     *          Cancel Action
     * @return
     *          Cancel Response from the service
     *
     * @throws AmazonFPSException
     */
    public CancelResponse cancel(CancelRequest request)
        throws AmazonFPSException {
        CancelResponse response;
        try {
            response = (CancelResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("CancelResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Fund Prepaid 
     *
     * 
     * Funds the prepaid balance on the given prepaid instrument.
     * 
     * @param request
     *          FundPrepaid Action
     * @return
     *          FundPrepaid Response from the service
     *
     * @throws AmazonFPSException
     */
    public FundPrepaidResponse fundPrepaid(FundPrepaidRequest request)
        throws AmazonFPSException {
        FundPrepaidResponse response;
        try {
            response = (FundPrepaidResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("FundPrepaidResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Account Activity 
     *
     * 
     * Returns transactions for a given date range.
     * 
     * @param request
     *          GetAccountActivity Action
     * @return
     *          GetAccountActivity Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetAccountActivityResponse getAccountActivity(GetAccountActivityRequest request)
        throws AmazonFPSException {
        GetAccountActivityResponse response;
        try {
            response = (GetAccountActivityResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetAccountActivityResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Account Balance 
     *
     * 
     * Returns the account balance for an account in real time.
     * 
     * @param request
     *          GetAccountBalance Action
     * @return
     *          GetAccountBalance Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetAccountBalanceResponse getAccountBalance(GetAccountBalanceRequest request)
        throws AmazonFPSException {
        GetAccountBalanceResponse response;
        try {
            response = (GetAccountBalanceResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetAccountBalanceResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Debt Balance 
     *
     * 
     * Returns the balance corresponding to the given credit instrument.
     * 
     * @param request
     *          GetDebtBalance Action
     * @return
     *          GetDebtBalance Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetDebtBalanceResponse getDebtBalance(GetDebtBalanceRequest request)
        throws AmazonFPSException {
        GetDebtBalanceResponse response;
        try {
            response = (GetDebtBalanceResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetDebtBalanceResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Outstanding Debt Balance 
     *
     * 
     * Returns the total outstanding balance for all the credit instruments for the given creditor account.
     * 
     * @param request
     *          GetOutstandingDebtBalance Action
     * @return
     *          GetOutstandingDebtBalance Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetOutstandingDebtBalanceResponse getOutstandingDebtBalance(GetOutstandingDebtBalanceRequest request)
        throws AmazonFPSException {
        GetOutstandingDebtBalanceResponse response;
        try {
            response = (GetOutstandingDebtBalanceResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetOutstandingDebtBalanceResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Prepaid Balance 
     *
     * 
     * Returns the balance available on the given prepaid instrument.
     * 
     * @param request
     *          GetPrepaidBalance Action
     * @return
     *          GetPrepaidBalance Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetPrepaidBalanceResponse getPrepaidBalance(GetPrepaidBalanceRequest request)
        throws AmazonFPSException {
        GetPrepaidBalanceResponse response;
        try {
            response = (GetPrepaidBalanceResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetPrepaidBalanceResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Token By Caller 
     *
     * 
     * Returns the details of a particular token installed by this calling application using the subway co-branded UI.
     * 
     * @param request
     *          GetTokenByCaller Action
     * @return
     *          GetTokenByCaller Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetTokenByCallerResponse getTokenByCaller(GetTokenByCallerRequest request)
        throws AmazonFPSException {
        GetTokenByCallerResponse response;
        try {
            response = (GetTokenByCallerResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetTokenByCallerResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Cancel Subscription And Refund 
     *
     * 
     * Cancels a subscription.
     * 
     * @param request
     *          CancelSubscriptionAndRefund Action
     * @return
     *          CancelSubscriptionAndRefund Response from the service
     *
     * @throws AmazonFPSException
     */
    public CancelSubscriptionAndRefundResponse cancelSubscriptionAndRefund(CancelSubscriptionAndRefundRequest request)
        throws AmazonFPSException {
        CancelSubscriptionAndRefundResponse response;
        try {
            response = (CancelSubscriptionAndRefundResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("CancelSubscriptionAndRefundResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Token Usage 
     *
     * 
     * Returns the usage of a token.
     * 
     * @param request
     *          GetTokenUsage Action
     * @return
     *          GetTokenUsage Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetTokenUsageResponse getTokenUsage(GetTokenUsageRequest request)
        throws AmazonFPSException {
        GetTokenUsageResponse response;
        try {
            response = (GetTokenUsageResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetTokenUsageResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Tokens 
     *
     * 
     * Returns a list of tokens installed on the given account.
     * 
     * @param request
     *          GetTokens Action
     * @return
     *          GetTokens Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetTokensResponse getTokens(GetTokensRequest request)
        throws AmazonFPSException {
        GetTokensResponse response;
        try {
            response = (GetTokensResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetTokensResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Total Prepaid Liability 
     *
     * 
     * Returns the total liability held by the given account corresponding to all the prepaid instruments owned by the account.
     * 
     * @param request
     *          GetTotalPrepaidLiability Action
     * @return
     *          GetTotalPrepaidLiability Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetTotalPrepaidLiabilityResponse getTotalPrepaidLiability(GetTotalPrepaidLiabilityRequest request)
        throws AmazonFPSException {
        GetTotalPrepaidLiabilityResponse response;
        try {
            response = (GetTotalPrepaidLiabilityResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetTotalPrepaidLiabilityResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Transaction 
     *
     * 
     * Returns all details of a transaction.
     * 
     * @param request
     *          GetTransaction Action
     * @return
     *          GetTransaction Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetTransactionResponse getTransaction(GetTransactionRequest request)
        throws AmazonFPSException {
        GetTransactionResponse response;
        try {
            response = (GetTransactionResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetTransactionResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Transaction Status 
     *
     * 
     * Gets the latest status of a transaction.
     * 
     * @param request
     *          GetTransactionStatus Action
     * @return
     *          GetTransactionStatus Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetTransactionStatusResponse getTransactionStatus(GetTransactionStatusRequest request)
        throws AmazonFPSException {
        GetTransactionStatusResponse response;
        try {
            response = (GetTransactionStatusResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetTransactionStatusResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Get Payment Instruction 
     *
     * 
     * Gets the payment instruction of a token.
     * 
     * @param request
     *          GetPaymentInstruction Action
     * @return
     *          GetPaymentInstruction Response from the service
     *
     * @throws AmazonFPSException
     */
    public GetPaymentInstructionResponse getPaymentInstruction(GetPaymentInstructionRequest request)
        throws AmazonFPSException {
        GetPaymentInstructionResponse response;
        try {
            response = (GetPaymentInstructionResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("GetPaymentInstructionResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Install Payment Instruction 
     *
     * Installs a payment instruction for caller.
     * 
     * @param request
     *          InstallPaymentInstruction Action
     * @return
     *          InstallPaymentInstruction Response from the service
     *
     * @throws AmazonFPSException
     */
    public InstallPaymentInstructionResponse installPaymentInstruction(InstallPaymentInstructionRequest request)
        throws AmazonFPSException {
        InstallPaymentInstructionResponse response;
        try {
            response = (InstallPaymentInstructionResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("InstallPaymentInstructionResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Pay 
     *
     * 
     * Allows calling applications to move money from a sender to a recipient.
     * 
     * @param request
     *          Pay Action
     * @return
     *          Pay Response from the service
     *
     * @throws AmazonFPSException
     */
    public PayResponse pay(PayRequest request)
        throws AmazonFPSException {
        PayResponse response;
        try {
            response = (PayResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("PayResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Refund 
     *
     * 
     * Refunds a previously completed transaction.
     * 
     * @param request
     *          Refund Action
     * @return
     *          Refund Response from the service
     *
     * @throws AmazonFPSException
     */
    public RefundResponse refund(RefundRequest request)
        throws AmazonFPSException {
        RefundResponse response;
        try {
            response = (RefundResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("RefundResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Reserve 
     *
     * 
     * Reserve API is part of the Reserve and Settle API conjunction that serve the purpose of a pay where the authorization and settlement have a timing 				difference.
     * 
     * @param request
     *          Reserve Action
     * @return
     *          Reserve Response from the service
     *
     * @throws AmazonFPSException
     */
    public ReserveResponse reserve(ReserveRequest request)
        throws AmazonFPSException {
        ReserveResponse response;
        try {
            response = (ReserveResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("ReserveResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Settle 
     *
     * 
     * The Settle API is used in conjunction with the Reserve API and is used to settle previously reserved transaction.
     * 
     * @param request
     *          Settle Action
     * @return
     *          Settle Response from the service
     *
     * @throws AmazonFPSException
     */
    public SettleResponse settle(SettleRequest request)
        throws AmazonFPSException {
        SettleResponse response;
        try {
            response = (SettleResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("SettleResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Settle Debt 
     *
     * 
     * Allows a caller to initiate a transaction that atomically transfers money from a sender’s payment instrument to the recipient, while decreasing corresponding 				debt balance.
     * 
     * @param request
     *          SettleDebt Action
     * @return
     *          SettleDebt Response from the service
     *
     * @throws AmazonFPSException
     */
    public SettleDebtResponse settleDebt(SettleDebtRequest request)
        throws AmazonFPSException {
        SettleDebtResponse response;
        try {
            response = (SettleDebtResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("SettleDebtResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Write Off Debt 
     *
     * 
     * Allows a creditor to write off the debt balance accumulated partially or fully at any time.
     * 
     * @param request
     *          WriteOffDebt Action
     * @return
     *          WriteOffDebt Response from the service
     *
     * @throws AmazonFPSException
     */
    public WriteOffDebtResponse writeOffDebt(WriteOffDebtRequest request)
        throws AmazonFPSException {
        WriteOffDebtResponse response;
        try {
            response = (WriteOffDebtResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("WriteOffDebtResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }

        
    /**
     * Verify Signature 
     *
     * 
     * Verify the signature that FPS sent in IPN or callback urls.
     * 
     * @param request
     *          VerifySignature Action
     * @return
     *          VerifySignature Response from the service
     *
     * @throws AmazonFPSException
     */
    public VerifySignatureResponse verifySignature(VerifySignatureRequest request)
        throws AmazonFPSException {
        VerifySignatureResponse response;
        try {
            response = (VerifySignatureResponse)getUnmarshaller().unmarshal
                    (new InputSource(this.getClass().getResourceAsStream("VerifySignatureResponse.xml")));

            log.debug("Response from Mock Service: " + response.toXML());

        } catch (JAXBException jbe) {
            throw new AmazonFPSException("Unable to process mock response", jbe);
        }
        return response;
    }


    /**
     * Get unmarshaller for current thread
     */
    private Unmarshaller getUnmarshaller() {
        return unmarshaller.get();
    }
}