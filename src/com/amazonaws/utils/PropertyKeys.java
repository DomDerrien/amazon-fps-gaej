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




package com.amazonaws.utils;

/**
  * This class has key required to read values from config.properties 
  */
public enum PropertyKeys {
	AWS_ACCESS_KEY("AwsAccessKey"), 
	AWS_SECRET_KEY("AwsSecretKey"), 
	AWS_SERVICE_END_POINT("AwsServiceEndPoint"), 
	CBUI_SERVICE_END_POINT("CBUIServiceEndPoint"),
	PROXY_HOST("ProxyHost"), 
	PROXY_PORT("ProxyPort"),
	PROXY_USER_NAME("ProxyUserName"),
	PROXY_PASSWORD("ProxyPassword"),
	MAX_ERROR_RETRY("MaxErrorRetry"),
	MAX_CONNECTIONS("MaxConnections");

	private final String value;

	PropertyKeys(String v) {
		value = v;
	}

	public String value() {
		return value;
	}
};


