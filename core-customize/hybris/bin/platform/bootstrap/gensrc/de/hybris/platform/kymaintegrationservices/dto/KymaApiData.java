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
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Objects;
public  class KymaApiData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>KymaApiData.infoUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("infoUrl") 	
	private String infoUrl;

	/** <i>Generated property</i> for <code>KymaApiData.metadataUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("metadataUrl") 	
	private String metadataUrl;

	/** <i>Generated property</i> for <code>KymaApiData.eventsUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("eventsUrl") 	
	private String eventsUrl;

	/** <i>Generated property</i> for <code>KymaApiData.certificatesUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("certificatesUrl") 	
	private String certificatesUrl;
	
	public KymaApiData()
	{
		// default constructor
	}
	
@JsonProperty("infoUrl") 	public void setInfoUrl(final String infoUrl)
	{
		this.infoUrl = infoUrl;
	}

@JsonProperty("infoUrl") 	public String getInfoUrl() 
	{
		return infoUrl;
	}
	
	/**
	 * @deprecated since 1905, no longer needed
	 */
	@Deprecated(since = "1905", forRemoval = true)
@JsonProperty("metadataUrl") 	public void setMetadataUrl(final String metadataUrl)
	{
		this.metadataUrl = metadataUrl;
	}

	/**
	 * @deprecated since 1905, no longer needed
	 */
	@Deprecated(since = "1905", forRemoval = true)
@JsonProperty("metadataUrl") 	public String getMetadataUrl() 
	{
		return metadataUrl;
	}
	
	/**
	 * @deprecated since 1905, no longer needed
	 */
	@Deprecated(since = "1905", forRemoval = true)
@JsonProperty("eventsUrl") 	public void setEventsUrl(final String eventsUrl)
	{
		this.eventsUrl = eventsUrl;
	}

	/**
	 * @deprecated since 1905, no longer needed
	 */
	@Deprecated(since = "1905", forRemoval = true)
@JsonProperty("eventsUrl") 	public String getEventsUrl() 
	{
		return eventsUrl;
	}
	
@JsonProperty("certificatesUrl") 	public void setCertificatesUrl(final String certificatesUrl)
	{
		this.certificatesUrl = certificatesUrl;
	}

@JsonProperty("certificatesUrl") 	public String getCertificatesUrl() 
	{
		return certificatesUrl;
	}
	

}