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
public  class InfoData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>InfoData.title</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("title") 	
	private String title;

	/** <i>Generated property</i> for <code>InfoData.version</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("version") 	
	private String version;

	/** <i>Generated property</i> for <code>InfoData.description</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("description") 	
	private String description;
	
	public InfoData()
	{
		// default constructor
	}
	
@JsonProperty("title") 	public void setTitle(final String title)
	{
		this.title = title;
	}

@JsonProperty("title") 	public String getTitle() 
	{
		return title;
	}
	
@JsonProperty("version") 	public void setVersion(final String version)
	{
		this.version = version;
	}

@JsonProperty("version") 	public String getVersion() 
	{
		return version;
	}
	
@JsonProperty("description") 	public void setDescription(final String description)
	{
		this.description = description;
	}

@JsonProperty("description") 	public String getDescription() 
	{
		return description;
	}
	

}