/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customercouponocc.dto;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.UserWsDTO;
import de.hybris.platform.customercouponocc.dto.CustomerCouponWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Customer coupon for customer
 */
@ApiModel(value="CustomerCoupon2Customer", description="Customer coupon for customer")
public  class CustomerCoupon2CustomerWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Customer coupon<br/><br/><i>Generated property</i> for <code>CustomerCoupon2CustomerWsDTO.coupon</code> property defined at extension <code>customercouponocc</code>. */
@ApiModelProperty(name="coupon", value="Customer coupon") 	
	private CustomerCouponWsDTO coupon;

	/** Customer<br/><br/><i>Generated property</i> for <code>CustomerCoupon2CustomerWsDTO.customer</code> property defined at extension <code>customercouponocc</code>. */
@ApiModelProperty(name="customer", value="Customer") 	
	private UserWsDTO customer;
	
	public CustomerCoupon2CustomerWsDTO()
	{
		// default constructor
	}
	
	public void setCoupon(final CustomerCouponWsDTO coupon)
	{
		this.coupon = coupon;
	}

	public CustomerCouponWsDTO getCoupon() 
	{
		return coupon;
	}
	
	public void setCustomer(final UserWsDTO customer)
	{
		this.customer = customer;
	}

	public UserWsDTO getCustomer() 
	{
		return customer;
	}
	

}