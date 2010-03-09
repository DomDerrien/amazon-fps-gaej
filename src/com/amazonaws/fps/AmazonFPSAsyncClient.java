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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


/**
 * 
 * Amazon Flexible Payments Service
 * 
 *
 */
public class AmazonFPSAsyncClient extends AmazonFPSClient implements AmazonFPSAsync {

    private ExecutorService executor;

    /**
     * Client to make asynchronous calls to the service. Please note, you should
     * configure executor with same number of concurrent threads as number of
     * http connections specified in AmazonFPSConfig. Default number of
     * max http connections is 100.
     *
     * @param awsAccessKeyId AWS Access Key Id
     * @param awsSecretAccessKey AWS Secret Key
     * @param config service configuration. Pass new AmazonFPSConfig() if you
     * plan to use defaults
     *
     * @param executor Executor service to manage asynchronous calls.
     *
     */
    public AmazonFPSAsyncClient(String awsAccessKeyId, String awsSecretAccessKey,
            AmazonFPSConfig config, ExecutorService executor) {
        super(awsAccessKeyId, awsSecretAccessKey, config);
        this.executor = executor;
    }

            

    /**
     * Non-blocking Cancel Token 
     * <p/>
     * Returns <code>future</code> pointer to CancelTokenResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return CancelTokenResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;CancelTokenResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;CancelTokenResponse&gt;&gt;();
     *  for (CancelTokenRequest request : requests) {
     *      responses.add(client.cancelTokenAsync(request));
     *  }
     *  for (Future&lt;CancelTokenResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          CancelTokenResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          CancelTokenRequest request
     * @return Future&lt;CancelTokenResponse&gt; future pointer to CancelTokenResponse
     * 
     */
    public Future<CancelTokenResponse> cancelTokenAsync(final CancelTokenRequest request) {
        Future<CancelTokenResponse> response = executor.submit(new Callable<CancelTokenResponse>() {

            public CancelTokenResponse call() throws AmazonFPSException {
                return cancelToken(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Cancel 
     * <p/>
     * Returns <code>future</code> pointer to CancelResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return CancelResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;CancelResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;CancelResponse&gt;&gt;();
     *  for (CancelRequest request : requests) {
     *      responses.add(client.cancelAsync(request));
     *  }
     *  for (Future&lt;CancelResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          CancelResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          CancelRequest request
     * @return Future&lt;CancelResponse&gt; future pointer to CancelResponse
     * 
     */
    public Future<CancelResponse> cancelAsync(final CancelRequest request) {
        Future<CancelResponse> response = executor.submit(new Callable<CancelResponse>() {

            public CancelResponse call() throws AmazonFPSException {
                return cancel(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Fund Prepaid 
     * <p/>
     * Returns <code>future</code> pointer to FundPrepaidResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return FundPrepaidResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;FundPrepaidResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;FundPrepaidResponse&gt;&gt;();
     *  for (FundPrepaidRequest request : requests) {
     *      responses.add(client.fundPrepaidAsync(request));
     *  }
     *  for (Future&lt;FundPrepaidResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          FundPrepaidResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          FundPrepaidRequest request
     * @return Future&lt;FundPrepaidResponse&gt; future pointer to FundPrepaidResponse
     * 
     */
    public Future<FundPrepaidResponse> fundPrepaidAsync(final FundPrepaidRequest request) {
        Future<FundPrepaidResponse> response = executor.submit(new Callable<FundPrepaidResponse>() {

            public FundPrepaidResponse call() throws AmazonFPSException {
                return fundPrepaid(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Account Activity 
     * <p/>
     * Returns <code>future</code> pointer to GetAccountActivityResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetAccountActivityResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetAccountActivityResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetAccountActivityResponse&gt;&gt;();
     *  for (GetAccountActivityRequest request : requests) {
     *      responses.add(client.getAccountActivityAsync(request));
     *  }
     *  for (Future&lt;GetAccountActivityResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetAccountActivityResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetAccountActivityRequest request
     * @return Future&lt;GetAccountActivityResponse&gt; future pointer to GetAccountActivityResponse
     * 
     */
    public Future<GetAccountActivityResponse> getAccountActivityAsync(final GetAccountActivityRequest request) {
        Future<GetAccountActivityResponse> response = executor.submit(new Callable<GetAccountActivityResponse>() {

            public GetAccountActivityResponse call() throws AmazonFPSException {
                return getAccountActivity(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Account Balance 
     * <p/>
     * Returns <code>future</code> pointer to GetAccountBalanceResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetAccountBalanceResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetAccountBalanceResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetAccountBalanceResponse&gt;&gt;();
     *  for (GetAccountBalanceRequest request : requests) {
     *      responses.add(client.getAccountBalanceAsync(request));
     *  }
     *  for (Future&lt;GetAccountBalanceResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetAccountBalanceResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetAccountBalanceRequest request
     * @return Future&lt;GetAccountBalanceResponse&gt; future pointer to GetAccountBalanceResponse
     * 
     */
    public Future<GetAccountBalanceResponse> getAccountBalanceAsync(final GetAccountBalanceRequest request) {
        Future<GetAccountBalanceResponse> response = executor.submit(new Callable<GetAccountBalanceResponse>() {

            public GetAccountBalanceResponse call() throws AmazonFPSException {
                return getAccountBalance(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Debt Balance 
     * <p/>
     * Returns <code>future</code> pointer to GetDebtBalanceResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetDebtBalanceResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetDebtBalanceResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetDebtBalanceResponse&gt;&gt;();
     *  for (GetDebtBalanceRequest request : requests) {
     *      responses.add(client.getDebtBalanceAsync(request));
     *  }
     *  for (Future&lt;GetDebtBalanceResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetDebtBalanceResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetDebtBalanceRequest request
     * @return Future&lt;GetDebtBalanceResponse&gt; future pointer to GetDebtBalanceResponse
     * 
     */
    public Future<GetDebtBalanceResponse> getDebtBalanceAsync(final GetDebtBalanceRequest request) {
        Future<GetDebtBalanceResponse> response = executor.submit(new Callable<GetDebtBalanceResponse>() {

            public GetDebtBalanceResponse call() throws AmazonFPSException {
                return getDebtBalance(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Outstanding Debt Balance 
     * <p/>
     * Returns <code>future</code> pointer to GetOutstandingDebtBalanceResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetOutstandingDebtBalanceResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetOutstandingDebtBalanceResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetOutstandingDebtBalanceResponse&gt;&gt;();
     *  for (GetOutstandingDebtBalanceRequest request : requests) {
     *      responses.add(client.getOutstandingDebtBalanceAsync(request));
     *  }
     *  for (Future&lt;GetOutstandingDebtBalanceResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetOutstandingDebtBalanceResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetOutstandingDebtBalanceRequest request
     * @return Future&lt;GetOutstandingDebtBalanceResponse&gt; future pointer to GetOutstandingDebtBalanceResponse
     * 
     */
    public Future<GetOutstandingDebtBalanceResponse> getOutstandingDebtBalanceAsync(final GetOutstandingDebtBalanceRequest request) {
        Future<GetOutstandingDebtBalanceResponse> response = executor.submit(new Callable<GetOutstandingDebtBalanceResponse>() {

            public GetOutstandingDebtBalanceResponse call() throws AmazonFPSException {
                return getOutstandingDebtBalance(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Prepaid Balance 
     * <p/>
     * Returns <code>future</code> pointer to GetPrepaidBalanceResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetPrepaidBalanceResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetPrepaidBalanceResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetPrepaidBalanceResponse&gt;&gt;();
     *  for (GetPrepaidBalanceRequest request : requests) {
     *      responses.add(client.getPrepaidBalanceAsync(request));
     *  }
     *  for (Future&lt;GetPrepaidBalanceResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetPrepaidBalanceResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetPrepaidBalanceRequest request
     * @return Future&lt;GetPrepaidBalanceResponse&gt; future pointer to GetPrepaidBalanceResponse
     * 
     */
    public Future<GetPrepaidBalanceResponse> getPrepaidBalanceAsync(final GetPrepaidBalanceRequest request) {
        Future<GetPrepaidBalanceResponse> response = executor.submit(new Callable<GetPrepaidBalanceResponse>() {

            public GetPrepaidBalanceResponse call() throws AmazonFPSException {
                return getPrepaidBalance(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Token By Caller 
     * <p/>
     * Returns <code>future</code> pointer to GetTokenByCallerResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetTokenByCallerResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetTokenByCallerResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetTokenByCallerResponse&gt;&gt;();
     *  for (GetTokenByCallerRequest request : requests) {
     *      responses.add(client.getTokenByCallerAsync(request));
     *  }
     *  for (Future&lt;GetTokenByCallerResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetTokenByCallerResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetTokenByCallerRequest request
     * @return Future&lt;GetTokenByCallerResponse&gt; future pointer to GetTokenByCallerResponse
     * 
     */
    public Future<GetTokenByCallerResponse> getTokenByCallerAsync(final GetTokenByCallerRequest request) {
        Future<GetTokenByCallerResponse> response = executor.submit(new Callable<GetTokenByCallerResponse>() {

            public GetTokenByCallerResponse call() throws AmazonFPSException {
                return getTokenByCaller(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Cancel Subscription And Refund 
     * <p/>
     * Returns <code>future</code> pointer to CancelSubscriptionAndRefundResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return CancelSubscriptionAndRefundResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;CancelSubscriptionAndRefundResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;CancelSubscriptionAndRefundResponse&gt;&gt;();
     *  for (CancelSubscriptionAndRefundRequest request : requests) {
     *      responses.add(client.cancelSubscriptionAndRefundAsync(request));
     *  }
     *  for (Future&lt;CancelSubscriptionAndRefundResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          CancelSubscriptionAndRefundResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          CancelSubscriptionAndRefundRequest request
     * @return Future&lt;CancelSubscriptionAndRefundResponse&gt; future pointer to CancelSubscriptionAndRefundResponse
     * 
     */
    public Future<CancelSubscriptionAndRefundResponse> cancelSubscriptionAndRefundAsync(final CancelSubscriptionAndRefundRequest request) {
        Future<CancelSubscriptionAndRefundResponse> response = executor.submit(new Callable<CancelSubscriptionAndRefundResponse>() {

            public CancelSubscriptionAndRefundResponse call() throws AmazonFPSException {
                return cancelSubscriptionAndRefund(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Token Usage 
     * <p/>
     * Returns <code>future</code> pointer to GetTokenUsageResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetTokenUsageResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetTokenUsageResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetTokenUsageResponse&gt;&gt;();
     *  for (GetTokenUsageRequest request : requests) {
     *      responses.add(client.getTokenUsageAsync(request));
     *  }
     *  for (Future&lt;GetTokenUsageResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetTokenUsageResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetTokenUsageRequest request
     * @return Future&lt;GetTokenUsageResponse&gt; future pointer to GetTokenUsageResponse
     * 
     */
    public Future<GetTokenUsageResponse> getTokenUsageAsync(final GetTokenUsageRequest request) {
        Future<GetTokenUsageResponse> response = executor.submit(new Callable<GetTokenUsageResponse>() {

            public GetTokenUsageResponse call() throws AmazonFPSException {
                return getTokenUsage(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Tokens 
     * <p/>
     * Returns <code>future</code> pointer to GetTokensResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetTokensResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetTokensResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetTokensResponse&gt;&gt;();
     *  for (GetTokensRequest request : requests) {
     *      responses.add(client.getTokensAsync(request));
     *  }
     *  for (Future&lt;GetTokensResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetTokensResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetTokensRequest request
     * @return Future&lt;GetTokensResponse&gt; future pointer to GetTokensResponse
     * 
     */
    public Future<GetTokensResponse> getTokensAsync(final GetTokensRequest request) {
        Future<GetTokensResponse> response = executor.submit(new Callable<GetTokensResponse>() {

            public GetTokensResponse call() throws AmazonFPSException {
                return getTokens(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Total Prepaid Liability 
     * <p/>
     * Returns <code>future</code> pointer to GetTotalPrepaidLiabilityResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetTotalPrepaidLiabilityResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetTotalPrepaidLiabilityResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetTotalPrepaidLiabilityResponse&gt;&gt;();
     *  for (GetTotalPrepaidLiabilityRequest request : requests) {
     *      responses.add(client.getTotalPrepaidLiabilityAsync(request));
     *  }
     *  for (Future&lt;GetTotalPrepaidLiabilityResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetTotalPrepaidLiabilityResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetTotalPrepaidLiabilityRequest request
     * @return Future&lt;GetTotalPrepaidLiabilityResponse&gt; future pointer to GetTotalPrepaidLiabilityResponse
     * 
     */
    public Future<GetTotalPrepaidLiabilityResponse> getTotalPrepaidLiabilityAsync(final GetTotalPrepaidLiabilityRequest request) {
        Future<GetTotalPrepaidLiabilityResponse> response = executor.submit(new Callable<GetTotalPrepaidLiabilityResponse>() {

            public GetTotalPrepaidLiabilityResponse call() throws AmazonFPSException {
                return getTotalPrepaidLiability(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Transaction 
     * <p/>
     * Returns <code>future</code> pointer to GetTransactionResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetTransactionResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetTransactionResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetTransactionResponse&gt;&gt;();
     *  for (GetTransactionRequest request : requests) {
     *      responses.add(client.getTransactionAsync(request));
     *  }
     *  for (Future&lt;GetTransactionResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetTransactionResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetTransactionRequest request
     * @return Future&lt;GetTransactionResponse&gt; future pointer to GetTransactionResponse
     * 
     */
    public Future<GetTransactionResponse> getTransactionAsync(final GetTransactionRequest request) {
        Future<GetTransactionResponse> response = executor.submit(new Callable<GetTransactionResponse>() {

            public GetTransactionResponse call() throws AmazonFPSException {
                return getTransaction(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Transaction Status 
     * <p/>
     * Returns <code>future</code> pointer to GetTransactionStatusResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetTransactionStatusResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetTransactionStatusResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetTransactionStatusResponse&gt;&gt;();
     *  for (GetTransactionStatusRequest request : requests) {
     *      responses.add(client.getTransactionStatusAsync(request));
     *  }
     *  for (Future&lt;GetTransactionStatusResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetTransactionStatusResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetTransactionStatusRequest request
     * @return Future&lt;GetTransactionStatusResponse&gt; future pointer to GetTransactionStatusResponse
     * 
     */
    public Future<GetTransactionStatusResponse> getTransactionStatusAsync(final GetTransactionStatusRequest request) {
        Future<GetTransactionStatusResponse> response = executor.submit(new Callable<GetTransactionStatusResponse>() {

            public GetTransactionStatusResponse call() throws AmazonFPSException {
                return getTransactionStatus(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Get Payment Instruction 
     * <p/>
     * Returns <code>future</code> pointer to GetPaymentInstructionResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return GetPaymentInstructionResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;GetPaymentInstructionResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;GetPaymentInstructionResponse&gt;&gt;();
     *  for (GetPaymentInstructionRequest request : requests) {
     *      responses.add(client.getPaymentInstructionAsync(request));
     *  }
     *  for (Future&lt;GetPaymentInstructionResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          GetPaymentInstructionResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          GetPaymentInstructionRequest request
     * @return Future&lt;GetPaymentInstructionResponse&gt; future pointer to GetPaymentInstructionResponse
     * 
     */
    public Future<GetPaymentInstructionResponse> getPaymentInstructionAsync(final GetPaymentInstructionRequest request) {
        Future<GetPaymentInstructionResponse> response = executor.submit(new Callable<GetPaymentInstructionResponse>() {

            public GetPaymentInstructionResponse call() throws AmazonFPSException {
                return getPaymentInstruction(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Install Payment Instruction 
     * <p/>
     * Returns <code>future</code> pointer to InstallPaymentInstructionResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return InstallPaymentInstructionResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;InstallPaymentInstructionResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;InstallPaymentInstructionResponse&gt;&gt;();
     *  for (InstallPaymentInstructionRequest request : requests) {
     *      responses.add(client.installPaymentInstructionAsync(request));
     *  }
     *  for (Future&lt;InstallPaymentInstructionResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          InstallPaymentInstructionResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          InstallPaymentInstructionRequest request
     * @return Future&lt;InstallPaymentInstructionResponse&gt; future pointer to InstallPaymentInstructionResponse
     * 
     */
    public Future<InstallPaymentInstructionResponse> installPaymentInstructionAsync(final InstallPaymentInstructionRequest request) {
        Future<InstallPaymentInstructionResponse> response = executor.submit(new Callable<InstallPaymentInstructionResponse>() {

            public InstallPaymentInstructionResponse call() throws AmazonFPSException {
                return installPaymentInstruction(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Pay 
     * <p/>
     * Returns <code>future</code> pointer to PayResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return PayResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;PayResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;PayResponse&gt;&gt;();
     *  for (PayRequest request : requests) {
     *      responses.add(client.payAsync(request));
     *  }
     *  for (Future&lt;PayResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          PayResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          PayRequest request
     * @return Future&lt;PayResponse&gt; future pointer to PayResponse
     * 
     */
    public Future<PayResponse> payAsync(final PayRequest request) {
        Future<PayResponse> response = executor.submit(new Callable<PayResponse>() {

            public PayResponse call() throws AmazonFPSException {
                return pay(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Refund 
     * <p/>
     * Returns <code>future</code> pointer to RefundResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return RefundResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;RefundResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;RefundResponse&gt;&gt;();
     *  for (RefundRequest request : requests) {
     *      responses.add(client.refundAsync(request));
     *  }
     *  for (Future&lt;RefundResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          RefundResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          RefundRequest request
     * @return Future&lt;RefundResponse&gt; future pointer to RefundResponse
     * 
     */
    public Future<RefundResponse> refundAsync(final RefundRequest request) {
        Future<RefundResponse> response = executor.submit(new Callable<RefundResponse>() {

            public RefundResponse call() throws AmazonFPSException {
                return refund(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Reserve 
     * <p/>
     * Returns <code>future</code> pointer to ReserveResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return ReserveResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;ReserveResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;ReserveResponse&gt;&gt;();
     *  for (ReserveRequest request : requests) {
     *      responses.add(client.reserveAsync(request));
     *  }
     *  for (Future&lt;ReserveResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          ReserveResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          ReserveRequest request
     * @return Future&lt;ReserveResponse&gt; future pointer to ReserveResponse
     * 
     */
    public Future<ReserveResponse> reserveAsync(final ReserveRequest request) {
        Future<ReserveResponse> response = executor.submit(new Callable<ReserveResponse>() {

            public ReserveResponse call() throws AmazonFPSException {
                return reserve(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Settle 
     * <p/>
     * Returns <code>future</code> pointer to SettleResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return SettleResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;SettleResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;SettleResponse&gt;&gt;();
     *  for (SettleRequest request : requests) {
     *      responses.add(client.settleAsync(request));
     *  }
     *  for (Future&lt;SettleResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          SettleResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          SettleRequest request
     * @return Future&lt;SettleResponse&gt; future pointer to SettleResponse
     * 
     */
    public Future<SettleResponse> settleAsync(final SettleRequest request) {
        Future<SettleResponse> response = executor.submit(new Callable<SettleResponse>() {

            public SettleResponse call() throws AmazonFPSException {
                return settle(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Settle Debt 
     * <p/>
     * Returns <code>future</code> pointer to SettleDebtResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return SettleDebtResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;SettleDebtResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;SettleDebtResponse&gt;&gt;();
     *  for (SettleDebtRequest request : requests) {
     *      responses.add(client.settleDebtAsync(request));
     *  }
     *  for (Future&lt;SettleDebtResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          SettleDebtResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          SettleDebtRequest request
     * @return Future&lt;SettleDebtResponse&gt; future pointer to SettleDebtResponse
     * 
     */
    public Future<SettleDebtResponse> settleDebtAsync(final SettleDebtRequest request) {
        Future<SettleDebtResponse> response = executor.submit(new Callable<SettleDebtResponse>() {

            public SettleDebtResponse call() throws AmazonFPSException {
                return settleDebt(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Write Off Debt 
     * <p/>
     * Returns <code>future</code> pointer to WriteOffDebtResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return WriteOffDebtResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;WriteOffDebtResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;WriteOffDebtResponse&gt;&gt;();
     *  for (WriteOffDebtRequest request : requests) {
     *      responses.add(client.writeOffDebtAsync(request));
     *  }
     *  for (Future&lt;WriteOffDebtResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          WriteOffDebtResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          WriteOffDebtRequest request
     * @return Future&lt;WriteOffDebtResponse&gt; future pointer to WriteOffDebtResponse
     * 
     */
    public Future<WriteOffDebtResponse> writeOffDebtAsync(final WriteOffDebtRequest request) {
        Future<WriteOffDebtResponse> response = executor.submit(new Callable<WriteOffDebtResponse>() {

            public WriteOffDebtResponse call() throws AmazonFPSException {
                return writeOffDebt(request);
            }
        });
        return response;
    }


            

    /**
     * Non-blocking Verify Signature 
     * <p/>
     * Returns <code>future</code> pointer to VerifySignatureResponse
     * <p/>
     * If response is ready, call to <code>future.get()</code> 
     * will return VerifySignatureResponse. 
     * <p/>
     * If response is not ready, call to <code>future.get()</code> will block the 
     * calling thread until response is returned. 
     * <p/>
     * Note, <code>future.get()</code> will throw wrapped runtime exception. 
     * <p/>
     * If service error has occured, AmazonFPSException can be extracted with
     * <code>exception.getCause()</code>
     * <p/>
     * Usage example for parallel processing:
     * <pre>
     *
     *  List&lt;Future&lt;VerifySignatureResponse&gt;&gt; responses = new ArrayList&lt;Future&lt;VerifySignatureResponse&gt;&gt;();
     *  for (VerifySignatureRequest request : requests) {
     *      responses.add(client.verifySignatureAsync(request));
     *  }
     *  for (Future&lt;VerifySignatureResponse&gt; future : responses) {
     *      while (!future.isDone()) {
     *          Thread.yield();
     *      }
     *      try {
     *          VerifySignatureResponse response = future.get();
     *      // use response
     *      } catch (Exception e) {
     *          if (e instanceof AmazonFPSException) {
     *              AmazonFPSException exception = AmazonFPSException.class.cast(e);
     *          // handle AmazonFPSException
     *          } else {
     *          // handle other exceptions
     *          }
     *      }
     *  }
     * </pre>
     *
     * @param request
     *          VerifySignatureRequest request
     * @return Future&lt;VerifySignatureResponse&gt; future pointer to VerifySignatureResponse
     * 
     */
    public Future<VerifySignatureResponse> verifySignatureAsync(final VerifySignatureRequest request) {
        Future<VerifySignatureResponse> response = executor.submit(new Callable<VerifySignatureResponse>() {

            public VerifySignatureResponse call() throws AmazonFPSException {
                return verifySignature(request);
            }
        });
        return response;
    }


}
