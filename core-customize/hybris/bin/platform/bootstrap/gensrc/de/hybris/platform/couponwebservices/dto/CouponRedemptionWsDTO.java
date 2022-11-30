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
 * Coupon redemption
 */
@ApiModel(value="couponRedemption", description="Coupon redemption")
public  class CouponRedemptionWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CouponRedemptionWsDTO.couponId</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="couponId") 	
	private String couponId;

	/** <i>Generated property</i> for <code>CouponRedemptionWsDTO.couponCode</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="couponCode") 	
	private String couponCode;

	/** <i>Generated property</i> for <code>CouponRedemptionWsDTO.orderCode</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="orderCode") 	
	private String orderCode;

	/** <i>Generated property</i> for <code>CouponRedemptionWsDTO.customerId</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="customerId") 	
	private String customerId;

	/** <i>Generated property</i> for <code>CouponRedemptionWsDTO.redemptionsPerCustomer</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="redemptionsPerCustomer") 	
	private Integer redemptionsPerCustomer;

	/** <i>Generated property</i> for <code>CouponRedemptionWsDTO.totalRedemptions </code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="totalRedemptions ") 	
	private Integer totalRedemptions ;

	/** <i>Generated property</i> for <code>CouponRedemptionWsDTO.maxRedemptionsLimitPerCustomer</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="maxRedemptionsLimitPerCustomer") 	
	private Integer maxRedemptionsLimitPerCustomer;

	/** <i>Generated property</i> for <code>CouponRedemptionWsDTO.maxTotalRedemptionsLimit </code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="maxTotalRedemptionsLimit ") 	
	private Integer maxTotalRedemptionsLimit ;
	
	public CouponRedemptionWsDTO()
	{
		// default constructor
	}
	
	public void setCouponId(final String couponId)
	{
		this.couponId = couponId;
	}

	public String getCouponId() 
	{
		return couponId;
	}
	
	public void setCouponCode(final String couponCode)
	{
		this.couponCode = couponCode;
	}

	public String getCouponCode() 
	{
		return couponCode;
	}
	
	public void setOrderCode(final String orderCode)
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	
	public void setCustomerId(final String customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerId() 
	{
		return customerId;
	}
	
	public void setRedemptionsPerCustomer(final Integer redemptionsPerCustomer)
	{
		this.redemptionsPerCustomer = redemptionsPerCustomer;
	}

	public Integer getRedemptionsPerCustomer() 
	{
		return redemptionsPerCustomer;
	}
	
	public void setTotalRedemptions (final Integer totalRedemptions )
	{
		this.totalRedemptions  = totalRedemptions ;
	}

	public Integer getTotalRedemptions () 
	{
		return totalRedemptions ;
	}
	
	public void setMaxRedemptionsLimitPerCustomer(final Integer maxRedemptionsLimitPerCustomer)
	{
		this.maxRedemptionsLimitPerCustomer = maxRedemptionsLimitPerCustomer;
	}

	public Integer getMaxRedemptionsLimitPerCustomer() 
	{
		return maxRedemptionsLimitPerCustomer;
	}
	
	public void setMaxTotalRedemptionsLimit (final Integer maxTotalRedemptionsLimit )
	{
		this.maxTotalRedemptionsLimit  = maxTotalRedemptionsLimit ;
	}

	public Integer getMaxTotalRedemptionsLimit () 
	{
		return maxTotalRedemptionsLimit ;
	}
	

}