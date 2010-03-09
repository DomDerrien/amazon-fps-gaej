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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**

This class reads configuration values from config.properties file.

*/
public class PropertyBundle {
	private static final String PROPERTY_FILE_NAME = "config.properties";
	private static Properties properties;
	static {
		properties = new Properties();
		try {
		    InputStream in = PropertyBundle.class.getResourceAsStream("/"+PROPERTY_FILE_NAME);
		    if (in == null) {
				throw new FileNotFoundException(PROPERTY_FILE_NAME+" not found");
		     }
		    properties.load(in);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + PROPERTY_FILE_NAME+ " not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException : Can't read " + PROPERTY_FILE_NAME);
			e.printStackTrace();
		}
	}

	public static String getProperty(PropertyKeys key) {
		return properties.getProperty(key.value());
	}

}

