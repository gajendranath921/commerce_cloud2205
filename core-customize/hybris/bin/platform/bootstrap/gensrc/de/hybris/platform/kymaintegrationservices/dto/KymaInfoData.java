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
import de.hybris.platform.kymaintegrationservices.dto.KymaCertificateCreation;
import de.hybris.platform.kymaintegrationservices.dto.KymaClientIdentity;
import de.hybris.platform.kymaintegrationservices.dto.KymaServicesUrls;


import java.util.Objects;
public  class KymaInfoData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>KymaInfoData.clientIdentity</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("clientIdentity") 	
	private KymaClientIdentity clientIdentity;

	/** <i>Generated property</i> for <code>KymaInfoData.urls</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("urls") 	
	private KymaServicesUrls urls;

	/** <i>Generated property</i> for <code>KymaInfoData.certificate</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("certificate") 	
	private KymaCertificateCreation certificate;
	
	public KymaInfoData()
	{
		// default constructor
	}
	
@JsonProperty("clientIdentity") 	public void setClientIdentity(final KymaClientIdentity clientIdentity)
	{
		this.clientIdentity = clientIdentity;
	}

@JsonProperty("clientIdentity") 	public KymaClientIdentity getClientIdentity() 
	{
		return clientIdentity;
	}
	
@JsonProperty("urls") 	public void setUrls(final KymaServicesUrls urls)
	{
		this.urls = urls;
	}

@JsonProperty("urls") 	public KymaServicesUrls getUrls() 
	{
		return urls;
	}
	
@JsonProperty("certificate") 	public void setCertificate(final KymaCertificateCreation certificate)
	{
		this.certificate = certificate;
	}

@JsonProperty("certificate") 	public KymaCertificateCreation getCertificate() 
	{
		return certificate;
	}
	

}