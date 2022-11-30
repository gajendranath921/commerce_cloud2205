/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.order.data;

import java.io.Serializable;


import java.util.Objects;
public  class B2BPaymentTypeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BPaymentTypeData.code</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>B2BPaymentTypeData.displayName</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String displayName;
	
	public B2BPaymentTypeData()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setDisplayName(final String displayName)
	{
		this.displayName = displayName;
	}

	public String getDisplayName() 
	{
		return displayName;
	}
	

}