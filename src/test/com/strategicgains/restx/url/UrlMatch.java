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
package com.strategicgains.restx.url;

import java.util.HashMap;
import java.util.Map;

/**
 * @author toddf
 * @since Apr 29, 2010
 */
public class UrlMatch
{
	private Map<String, String>parameters = new HashMap<String, String>();
	
	public UrlMatch(Map<String, String> parameters)
	{
		super();
		this.parameters.putAll(parameters);
	}
	
	public String get(String name)
	{
		return parameters.get(name);
	}
}
