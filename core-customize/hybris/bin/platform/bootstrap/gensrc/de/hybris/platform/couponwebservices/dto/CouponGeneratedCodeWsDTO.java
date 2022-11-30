/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Coupon generated code
 */
@ApiModel(value="couponGeneratedCode", description="Coupon generated code")
public  class CouponGeneratedCodeWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CouponGeneratedCodeWsDTO.code</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>CouponGeneratedCodeWsDTO.link</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="link") 	
	private String link;
	
	public CouponGeneratedCodeWsDTO()
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
	
	public void setLink(final String link)
	{
		this.link = link;
	}

	public String getLink() 
	{
		return link;
	}
	

}