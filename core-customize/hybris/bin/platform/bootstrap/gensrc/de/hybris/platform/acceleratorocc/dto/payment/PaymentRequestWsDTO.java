/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorocc.dto.payment;

import java.io.Serializable;
import java.util.Map;


import java.util.Objects;
public  class PaymentRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PaymentRequestWsDTO.postUrl</code> property defined at extension <code>acceleratorocc</code>. */
	
	private String postUrl;

	/** <i>Generated property</i> for <code>PaymentRequestWsDTO.parameters</code> property defined at extension <code>acceleratorocc</code>. */
	
	private Map<String, String> parameters;

	/** <i>Generated property</i> for <code>PaymentRequestWsDTO.mappingLabels</code> property defined at extension <code>acceleratorocc</code>. */
	
	private Map<String, String> mappingLabels;
	
	public PaymentRequestWsDTO()
	{
		// default constructor
	}
	
	public void setPostUrl(final String postUrl)
	{
		this.postUrl = postUrl;
	}

	public String getPostUrl() 
	{
		return postUrl;
	}
	
	public void setParameters(final Map<String, String> parameters)
	{
		this.parameters = parameters;
	}

	public Map<String, String> getParameters() 
	{
		return parameters;
	}
	
	public void setMappingLabels(final Map<String, String> mappingLabels)
	{
		this.mappingLabels = mappingLabels;
	}

	public Map<String, String> getMappingLabels() 
	{
		return mappingLabels;
	}
	

}