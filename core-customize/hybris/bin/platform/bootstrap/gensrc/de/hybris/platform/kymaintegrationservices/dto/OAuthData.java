/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.kymaintegrationservices.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Objects;
public  class OAuthData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OAuthData.url</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("url") 	
	private String url;

	/** <i>Generated property</i> for <code>OAuthData.clientId</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("clientId") 	
	private String clientId;

	/** <i>Generated property</i> for <code>OAuthData.clientSecret</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("clientSecret") 	
	private String clientSecret;
	
	public OAuthData()
	{
		// default constructor
	}
	
@JsonProperty("url") 	public void setUrl(final String url)
	{
		this.url = url;
	}

@JsonProperty("url") 	public String getUrl() 
	{
		return url;
	}
	
@JsonProperty("clientId") 	public void setClientId(final String clientId)
	{
		this.clientId = clientId;
	}

@JsonProperty("clientId") 	public String getClientId() 
	{
		return clientId;
	}
	
@JsonProperty("clientSecret") 	public void setClientSecret(final String clientSecret)
	{
		this.clientSecret = clientSecret;
	}

@JsonProperty("clientSecret") 	public String getClientSecret() 
	{
		return clientSecret;
	}
	

}