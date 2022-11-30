/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.kymaintegrationservices.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.hybris.platform.kymaintegrationservices.dto.PropertyData;
import java.util.List;
import java.util.Map;


import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)
public  class PayloadData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PayloadData.type</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("type") 	
	private String type;

	/** <i>Generated property</i> for <code>PayloadData.required</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("required") 	
	private List<String> required;

	/** <i>Generated property</i> for <code>PayloadData.properties</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("properties") 	
	private Map<String,PropertyData> properties;
	
	public PayloadData()
	{
		// default constructor
	}
	
@JsonProperty("type") 	public void setType(final String type)
	{
		this.type = type;
	}

@JsonProperty("type") 	public String getType() 
	{
		return type;
	}
	
@JsonProperty("required") 	public void setRequired(final List<String> required)
	{
		this.required = required;
	}

@JsonProperty("required") 	public List<String> getRequired() 
	{
		return required;
	}
	
@JsonProperty("properties") 	public void setProperties(final Map<String,PropertyData> properties)
	{
		this.properties = properties;
	}

@JsonProperty("properties") 	public Map<String,PropertyData> getProperties() 
	{
		return properties;
	}
	

}