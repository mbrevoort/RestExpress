/*
    Copyright 2010, Strategic Gains, Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package com.strategicgains.restexpress.route;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.jboss.netty.handler.codec.http.HttpMethod;

import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;
import com.strategicgains.restexpress.exception.ServiceException;
import com.strategicgains.restexpress.url.UrlMatch;
import com.strategicgains.restexpress.url.UrlPattern;

/**
 * A Route is an immutable relationship between a URL pattern and a REST
 * service.
 * 
 * @author toddf
 * @since May 4, 2010
 */
public class Route
{
	// SECTION: INSTANCE VARIABLES

	private UrlPattern urlPattern;
	private Object controller;
	private Method action;
	private HttpMethod method;
	private boolean shouldSerializeResponse = true;
	private String name;

	// SECTION: CONSTRUCTORS

	/**
	 * @param urlPattern
	 * @param controller
	 */
	public Route(UrlPattern urlPattern, Object controller, Method action, HttpMethod method, boolean shouldSerializeResponse, String name)
	{
		super();
		this.urlPattern = urlPattern;
		this.controller = controller;
		this.action = action;
		this.method = method;
		this.shouldSerializeResponse = shouldSerializeResponse;
		this.name = name;
	}

	public Route(String urlPattern, Object controller, Method action, HttpMethod method, boolean shouldSerializeResponse, String name)
	{
		this(new UrlPattern(urlPattern), controller, action, method, shouldSerializeResponse, name);
	}
	
	public Method getAction()
	{
		return action;
	}
	
	public Object getController()
	{
		return controller;
	}
	
	public HttpMethod getMethod()
	{
		return method;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean hasName()
	{
		return (getName() != null && !getName().trim().isEmpty());
	}
	
	public String getUrlPattern()
	{
		return urlPattern.getNormalizedUrlPattern();
	}
	
	public boolean shouldSerializeResponse()
	{
		return shouldSerializeResponse;
	}

	public UrlMatch match(String url)
	{
		return urlPattern.match(url);
	}

	public Object invoke(Request request, Response response)
	{
		try
        {
	        return action.invoke(controller, request, response);
        }
		catch (InvocationTargetException e)
		{
			throw (RuntimeException) e.getCause();
		}
        catch (Exception e)
        {
        	throw new ServiceException(e);
        }
	}
}
