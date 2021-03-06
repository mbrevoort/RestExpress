/*
 * Copyright 2009, Strategic Gains, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.strategicgains.restexpress;

/**
 * @author toddf
 *
 */
public class RestExpress
{
	public static final String JSON_FORMAT = "json";
	public static final String TXT_FORMAT = "txt";
	public static final String XML_FORMAT = "xml";
	public static final String ENCODING = "UTF-8";
	

	// CONTENT TYPES

	public static final String CONTENT_TYPE_JSON = "application/json; charset=" + ENCODING;
	public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain; charset=" + ENCODING;
	public static final String CONTENT_TYPE_XML = "application/xml; charset=" + ENCODING;

	
	// CONSTRUCTOR - PRIVATE

	private RestExpress()
	{
		// prevents instantiation.
	}
}
