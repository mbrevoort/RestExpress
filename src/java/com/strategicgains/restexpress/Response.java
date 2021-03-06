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

import static org.jboss.netty.handler.codec.http.HttpResponseStatus.OK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.netty.handler.codec.http.HttpResponseStatus;

/**
 * @author toddf
 * @since Nov 20, 2009
 */
public class Response
{
	// SECTION: INSTANCE VARIABLES

	private HttpResponseStatus responseCode = OK;
	private Throwable exception = null;
	private Object body;
	private Map<String, List<String>> headers = new HashMap<String, List<String>>();
	
	
	// SECTION: CONSTRUCTORS
	
	public Response(Request request)
	{
		super();
		initialize(request);
	}
	
	/**
     * @param request
     */
    private void initialize(Request request)
    {
    	// TODO: initilize the response from data in the request.
    }


	// SECTION: ACCESSORS/MUTATORS

	public Object getBody()
	{
		return body;
	}

	public boolean hasBody()
	{
		return (getBody() != null);
	}

	public void setBody(Object body)
	{
		this.body = body;
	}

	public void clearHeaders()
	{
		headers.clear();
	}

	public String getHeader(String name)
	{
		List<String> list = headers.get(name);

		if (list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}

	public List<String> getHeaders(String name)
	{
		return headers.get(name);
	}

	public boolean hasHeaders()
	{
		return !headers.isEmpty();
	}

	public Set<String> getHeaderNames()
	{
		return headers.keySet();
	}

	/**
	 * Add a header value to the response.
	 * 
	 * @param name
	 * @param value
	 */
	public void addHeader(String name, String value)
	{
		List<String> list = headers.get(name);
		
		if (list == null)
		{
			list = new ArrayList<String>();
			headers.put(name, list);
		}
		
		list.add(value);
	}

	/**
	 * Set the HTTP response status code.
	 * 
	 * @param value
	 */
	public void setResponseCode(int value)
	{
		setResponseStatus(HttpResponseStatus.valueOf(value));
	}
	
	/**
	 * Set the HTTP response status.
	 * 
	 * @param status
	 */
	public void setResponseStatus(HttpResponseStatus status)
	{
		this.responseCode = status;
	}
	
	/**
	 * Sets the HTTP response status code to 201 - created.
	 */
	public void setResponseCreated()
	{
		setResponseStatus(HttpResponseStatus.CREATED);
	}
	
	/**
	 * Sets the HTTP response status code to 204 - no content.
	 */
	public void setResponseNoContent()
	{
		setResponseStatus(HttpResponseStatus.NO_CONTENT);
	}
	
	/**
	 * Get the HTTP Response Status.
	 * 
	 * @return
	 */
	public HttpResponseStatus getStatus()
	{
		return responseCode;
	}
	
	/**
	 * Retrieve the exception, if any, that occurred during the request handling cycle.
	 * 
	 * @return
	 */
	public Throwable getException()
	{
		return exception;
	}
	
	/**
	 * Return whether an exception occurred during the request handling cycle.
	 * 
	 * @return
	 */
	public boolean hasException()
	{
		return (getException() != null);
	}

	public void setException(Throwable t)
	{
		this.exception = t;
	}
	
	public String getResponseMessage()
	{
		Throwable cause = getException();
		Throwable current = cause;

		while (current != null)
		{
			cause = current;
			current = current.getCause();
		}

		return cause.getMessage();
	}
}
