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


import java.util.Objects;
public  class KymaRegistrationRequest  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>KymaRegistrationRequest.tokenUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
	
	private String tokenUrl;

	/** <i>Generated property</i> for <code>KymaRegistrationRequest.destinationTargetId</code> property defined at extension <code>kymaintegrationservices</code>. */
	
	private String destinationTargetId;

	/** <i>Generated property</i> for <code>KymaRegistrationRequest.servicesApiUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
	
	private String servicesApiUrl;

	/** <i>Generated property</i> for <code>KymaRegistrationRequest.templateDestinationTargetId</code> property defined at extension <code>kymaintegrationservices</code>. */
	
	private String templateDestinationTargetId;
	
	public KymaRegistrationRequest()
	{
		// default constructor
	}
	
	public void setTokenUrl(final String tokenUrl)
	{
		this.tokenUrl = tokenUrl;
	}

	public String getTokenUrl() 
	{
		return tokenUrl;
	}
	
	public void setDestinationTargetId(final String destinationTargetId)
	{
		this.destinationTargetId = destinationTargetId;
	}

	public String getDestinationTargetId() 
	{
		return destinationTargetId;
	}
	
	public void setServicesApiUrl(final String servicesApiUrl)
	{
		this.servicesApiUrl = servicesApiUrl;
	}

	public String getServicesApiUrl() 
	{
		return servicesApiUrl;
	}
	
	public void setTemplateDestinationTargetId(final String templateDestinationTargetId)
	{
		this.templateDestinationTargetId = templateDestinationTargetId;
	}

	public String getTemplateDestinationTargetId() 
	{
		return templateDestinationTargetId;
	}
	

}