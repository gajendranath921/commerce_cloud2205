/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.kymaintegrationservices.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Objects;
public  class ApiRegistrationResponseData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ApiRegistrationResponseData.id</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("id") 	
	private String id;
	
	public ApiRegistrationResponseData()
	{
		// default constructor
	}
	
@JsonProperty("id") 	public void setId(final String id)
	{
		this.id = id;
	}

@JsonProperty("id") 	public String getId() 
	{
		return id;
	}
	

}