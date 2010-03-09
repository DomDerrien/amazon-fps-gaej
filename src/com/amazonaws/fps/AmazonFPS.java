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



package com.amazonaws.fps;

import com.amazonaws.fps.model.*;



/**
 * 
 * Amazon Flexible Payments Service
 * 
 * 
 */
public interface  AmazonFPS {
    

            
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
    public CancelTokenResponse cancelToken(CancelTokenRequest request) throws AmazonFPSException;


            
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
    public CancelResponse cancel(CancelRequest request) throws AmazonFPSException;


            
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
    public FundPrepaidResponse fundPrepaid(FundPrepaidRequest request) throws AmazonFPSException;


            
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
    public GetAccountActivityResponse getAccountActivity(GetAccountActivityRequest request) throws AmazonFPSException;


            
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
    public GetAccountBalanceResponse getAccountBalance(GetAccountBalanceRequest request) throws AmazonFPSException;


            
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
    public GetDebtBalanceResponse getDebtBalance(GetDebtBalanceRequest request) throws AmazonFPSException;


            
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
    public GetOutstandingDebtBalanceResponse getOutstandingDebtBalance(GetOutstandingDebtBalanceRequest request) throws AmazonFPSException;


            
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
    public GetPrepaidBalanceResponse getPrepaidBalance(GetPrepaidBalanceRequest request) throws AmazonFPSException;


            
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
    public GetTokenByCallerResponse getTokenByCaller(GetTokenByCallerRequest request) throws AmazonFPSException;


            
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
    public CancelSubscriptionAndRefundResponse cancelSubscriptionAndRefund(CancelSubscriptionAndRefundRequest request) throws AmazonFPSException;


            
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
    public GetTokenUsageResponse getTokenUsage(GetTokenUsageRequest request) throws AmazonFPSException;


            
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
    public GetTokensResponse getTokens(GetTokensRequest request) throws AmazonFPSException;


            
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
    public GetTotalPrepaidLiabilityResponse getTotalPrepaidLiability(GetTotalPrepaidLiabilityRequest request) throws AmazonFPSException;


            
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
    public GetTransactionResponse getTransaction(GetTransactionRequest request) throws AmazonFPSException;


            
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
    public GetTransactionStatusResponse getTransactionStatus(GetTransactionStatusRequest request) throws AmazonFPSException;


            
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
    public GetPaymentInstructionResponse getPaymentInstruction(GetPaymentInstructionRequest request) throws AmazonFPSException;


            
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
    public InstallPaymentInstructionResponse installPaymentInstruction(InstallPaymentInstructionRequest request) throws AmazonFPSException;


            
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
    public PayResponse pay(PayRequest request) throws AmazonFPSException;


            
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
    public RefundResponse refund(RefundRequest request) throws AmazonFPSException;


            
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
    public ReserveResponse reserve(ReserveRequest request) throws AmazonFPSException;


            
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
    public SettleResponse settle(SettleRequest request) throws AmazonFPSException;


            
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
    public SettleDebtResponse settleDebt(SettleDebtRequest request) throws AmazonFPSException;


            
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
    public WriteOffDebtResponse writeOffDebt(WriteOffDebtRequest request) throws AmazonFPSException;


            
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
    public VerifySignatureResponse verifySignature(VerifySignatureRequest request) throws AmazonFPSException;



}