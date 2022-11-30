/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.kymaintegrationservices.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Objects;
public  class KymaServicesUrls  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>KymaServicesUrls.eventsUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("eventsUrl") 	
	private String eventsUrl;

	/** <i>Generated property</i> for <code>KymaServicesUrls.metadataUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("metadataUrl") 	
	private String metadataUrl;

	/** <i>Generated property</i> for <code>KymaServicesUrls.renewCertUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("renewCertUrl") 	
	private String renewCertUrl;
	
	public KymaServicesUrls()
	{
		// default constructor
	}
	
@JsonProperty("eventsUrl") 	public void setEventsUrl(final String eventsUrl)
	{
		this.eventsUrl = eventsUrl;
	}

@JsonProperty("eventsUrl") 	public String getEventsUrl() 
	{
		return eventsUrl;
	}
	
@JsonProperty("metadataUrl") 	public void setMetadataUrl(final String metadataUrl)
	{
		this.metadataUrl = metadataUrl;
	}

@JsonProperty("metadataUrl") 	public String getMetadataUrl() 
	{
		return metadataUrl;
	}
	
@JsonProperty("renewCertUrl") 	public void setRenewCertUrl(final String renewCertUrl)
	{
		this.renewCertUrl = renewCertUrl;
	}

@JsonProperty("renewCertUrl") 	public String getRenewCertUrl() 
	{
		return renewCertUrl;
	}
	

}