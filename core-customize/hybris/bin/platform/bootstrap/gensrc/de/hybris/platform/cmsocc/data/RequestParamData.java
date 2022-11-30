/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsocc.data;

import java.io.Serializable;
import  java.util.List;
import java.util.Map;


import java.util.Objects;
public  class RequestParamData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RequestParamData.queryParameters</code> property defined at extension <code>cmsocc</code>. */
	
	private Map<String,List<String>> queryParameters;

	/** <i>Generated property</i> for <code>RequestParamData.pathParameters</code> property defined at extension <code>cmsocc</code>. */
	
	private Map<String, String> pathParameters;
	
	public RequestParamData()
	{
		// default constructor
	}
	
	public void setQueryParameters(final Map<String,List<String>> queryParameters)
	{
		this.queryParameters = queryParameters;
	}

	public Map<String,List<String>> getQueryParameters() 
	{
		return queryParameters;
	}
	
	public void setPathParameters(final Map<String, String> pathParameters)
	{
		this.pathParameters = pathParameters;
	}

	public Map<String, String> getPathParameters() 
	{
		return pathParameters;
	}
	

}