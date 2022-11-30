/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.kymaintegrationservices.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Objects;
public  class EventsSpecificationData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>EventsSpecificationData.spec</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("spec") 	
	private SpecData spec;
	
	public EventsSpecificationData()
	{
		// default constructor
	}
	
@JsonProperty("spec") 	public void setSpec(final SpecData spec)
	{
		this.spec = spec;
	}

@JsonProperty("spec") 	public SpecData getSpec() 
	{
		return spec;
	}
	

}