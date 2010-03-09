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

/**
 * Amazon FPS  Exception provides details of errors 
 * returned by Amazon FPS  service
 *
 */
public class AmazonFPSException extends Exception {
    
    private String message = null;
    private int statusCode = -1;
    private String errorCode = null;
    private String errorType = null;
    private String requestId = null;
    private String xml = null;
    
    
    /**
     * Constructs AmazonFPSException with message
     * @param message
     *          Overview of error
     */
    public AmazonFPSException(String message) {
        this.message = message;
    }
    
    /**
     * Constructs AmazonFPSException with message and status code
     * @param message
     *          Overview of error
     * @param statusCode
     *          HTTP status code for error response
     */
    public AmazonFPSException(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
    
    /**
     * Constructs AmazonFPSException with wrapped exception
     * @param t
     *          wrapped exception
     */
    public AmazonFPSException(Throwable t) {
        super(t);
        if (t instanceof AmazonFPSException) {
            AmazonFPSException ex = (AmazonFPSException)t;
            this.message = ex.getMessage();
            this.statusCode = ex.getStatusCode();
            this.errorCode = ex.getErrorCode();
            this.errorType = ex.getErrorType();
            this.requestId = ex.getRequestId();
            this.xml = ex.getXML();
        }
    }
    
    /**
     * Constructs AmazonFPSException with message and wrapped exception
     * @param message
     *          Overview of error
     * @param t
     *          wrapped exception
     */
    public AmazonFPSException(String message, Throwable t) {
        super(message, t);
        this.message = message;
    }
    
    
    /**
     * Constructs AmazonFPSException with information available from service
     * @param message
     *          Overview of error
     * @param statusCode
     *          HTTP status code for error response
     * @param errorCode
     *          Error Code returned by the service
     * @param errorType
     *          Error type. Possible types:  Sender, Receiver or Unknown
     * @param requestId
     *          Request ID returned by the service
     * @param xml
     *          Compete xml found in response
     */
    public AmazonFPSException(String message, int statusCode, String errorCode, String errorType, String requestId,  String xml) {
        
        this.message = message;
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.requestId = requestId;
        this.xml = xml;
    }
    
    /**
     * Gets error code returned by the service if available.
     *
     * @return Error Code returned by the service
     */
    public String getErrorCode(){
        return errorCode;
    }
    
    /**
     * Gets error type returned by the service if available.
     *
     * @return Error Type returned by the service
     */
    public String getErrorType(){
        return errorType;
    }
    
    /**
     * Gets error message
     *
     * @return Error message
     */
    @Override
    public String getMessage() {
        return message;
    }
    
    /**
     * Gets status code returned by the service if available. If status
     * code is set to -1, it means that status code was unavailable at the
     * time exception was thrown
     *
     * @return status code returned by the service
     */
    public int getStatusCode() {
        return statusCode;
    }
    
    /**
     * Gets XML returned by the service if available.
     *
     * @return XML returned by the service
     */
    public String getXML() {
        return xml;
    }
    
    /**
     * Gets Request ID returned by the service if available.
     *
     * @return Request ID returned by the service
     */
    public String getRequestId() {
        return requestId;
    }
}
