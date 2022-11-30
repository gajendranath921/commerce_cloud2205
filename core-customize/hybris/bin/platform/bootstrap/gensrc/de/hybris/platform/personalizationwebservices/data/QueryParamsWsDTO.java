/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Generic parameters for query endpoint
 */
@ApiModel(value="QueryParams", description="Generic parameters for query endpoint")
public  class QueryParamsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Parameters map<br/><br/><i>Generated property</i> for <code>QueryParamsWsDTO.params</code> property defined at extension <code>personalizationwebservices</code>. */
@ApiModelProperty(name="params", value="Parameters map", example="{\"entry\" : [{ \"key\" : \"key1\", \"value\" : \"value1\" },{ \"key\" : \"key2\", \"value\" : \"value2\" }]}") 	
	private Map<String,String> params;
	
	public QueryParamsWsDTO()
	{
		// default constructor
	}
	
	public void setParams(final Map<String,String> params)
	{
		this.params = params;
	}

	public Map<String,String> getParams() 
	{
		return params;
	}
	

}