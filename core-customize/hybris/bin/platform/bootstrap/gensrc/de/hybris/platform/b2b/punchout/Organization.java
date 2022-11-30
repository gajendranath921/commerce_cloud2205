/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout;

import java.io.Serializable;


import java.util.Objects;
public  class Organization  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>Organization.domain</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String domain;

	/** <i>Generated property</i> for <code>Organization.identity</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String identity;

	/** <i>Generated property</i> for <code>Organization.sharedsecret</code> property defined at extension <code>b2bpunchout</code>. */
	
	private String sharedsecret;
	
	public Organization()
	{
		// default constructor
	}
	
	public void setDomain(final String domain)
	{
		this.domain = domain;
	}

	public String getDomain() 
	{
		return domain;
	}
	
	public void setIdentity(final String identity)
	{
		this.identity = identity;
	}

	public String getIdentity() 
	{
		return identity;
	}
	
	public void setSharedsecret(final String sharedsecret)
	{
		this.sharedsecret = sharedsecret;
	}

	public String getSharedsecret() 
	{
		return sharedsecret;
	}
	

}