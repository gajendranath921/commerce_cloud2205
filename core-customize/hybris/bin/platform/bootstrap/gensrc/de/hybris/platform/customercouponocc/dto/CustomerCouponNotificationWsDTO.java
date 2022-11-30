/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
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
 * Customer coupon notification
 */
@ApiModel(value="CustomerCouponNotification", description="Customer coupon notification")
public  class CustomerCouponNotificationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Customer coupon<br/><br/><i>Generated property</i> for <code>CustomerCouponNotificationWsDTO.coupon</code> property defined at extension <code>customercouponocc</code>. */
@ApiModelProperty(name="coupon", value="Customer coupon") 	
	private CustomerCouponWsDTO coupon;

	/** Customer<br/><br/><i>Generated property</i> for <code>CustomerCouponNotificationWsDTO.customer</code> property defined at extension <code>customercouponocc</code>. */
@ApiModelProperty(name="customer", value="Customer") 	
	private UserWsDTO customer;

	/** Notification status<br/><br/><i>Generated property</i> for <code>CustomerCouponNotificationWsDTO.status</code> property defined at extension <code>customercouponocc</code>. */
@ApiModelProperty(name="status", value="Notification status", example="EFFECTIVESENT") 	
	private String status;
	
	public CustomerCouponNotificationWsDTO()
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
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	

}