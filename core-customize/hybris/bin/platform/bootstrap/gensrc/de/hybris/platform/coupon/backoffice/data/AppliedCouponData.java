/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.coupon.backoffice.data;

import java.io.Serializable;


import java.util.Objects;
public  class AppliedCouponData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AppliedCouponData.code</code> property defined at extension <code>couponbackoffice</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>AppliedCouponData.name</code> property defined at extension <code>couponbackoffice</code>. */
	
	private String name;
	
	public AppliedCouponData()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}