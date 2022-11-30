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


import java.util.Objects;
public  class CertificateResponsePayload  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CertificateResponsePayload.crt</code> property defined at extension <code>kymaintegrationservices</code>. */
	
	private String crt;
	
	public CertificateResponsePayload()
	{
		// default constructor
	}
	
	public void setCrt(final String crt)
	{
		this.crt = crt;
	}

	public String getCrt() 
	{
		return crt;
	}
	

}