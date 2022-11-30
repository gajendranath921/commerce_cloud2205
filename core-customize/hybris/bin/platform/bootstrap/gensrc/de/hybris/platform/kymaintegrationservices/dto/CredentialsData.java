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
import de.hybris.platform.kymaintegrationservices.dto.BasicAuthData;
import de.hybris.platform.kymaintegrationservices.dto.OAuthData;


import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)
public  class CredentialsData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CredentialsData.oauth</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("oauth") 	
	private OAuthData oauth;

	/** <i>Generated property</i> for <code>CredentialsData.basic</code> property defined at extension <code>kymaintegrationservices</code>. */
@JsonProperty("basic") 	
	private BasicAuthData basic;
	
	public CredentialsData()
	{
		// default constructor
	}
	
@JsonProperty("oauth") 	public void setOauth(final OAuthData oauth)
	{
		this.oauth = oauth;
	}

@JsonProperty("oauth") 	public OAuthData getOauth() 
	{
		return oauth;
	}
	
@JsonProperty("basic") 	public void setBasic(final BasicAuthData basic)
	{
		this.basic = basic;
	}

@JsonProperty("basic") 	public BasicAuthData getBasic() 
	{
		return basic;
	}
	

}