/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import de.hybris.platform.couponwebservices.dto.AbstractCouponWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Single code coupon
 */
@ApiModel(value="singleCodeCoupon", description="Single code coupon")
public  class SingleCodeCouponWsDTO extends AbstractCouponWsDTO 

{



	/** <i>Generated property</i> for <code>SingleCodeCouponWsDTO.maxRedemptionsPerCustomer</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="maxRedemptionsPerCustomer") 	
	private Integer maxRedemptionsPerCustomer;

	/** <i>Generated property</i> for <code>SingleCodeCouponWsDTO.maxTotalRedemptions</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="maxTotalRedemptions") 	
	private Integer maxTotalRedemptions;
	
	public SingleCodeCouponWsDTO()
	{
		// default constructor
	}
	
	public void setMaxRedemptionsPerCustomer(final Integer maxRedemptionsPerCustomer)
	{
		this.maxRedemptionsPerCustomer = maxRedemptionsPerCustomer;
	}

	public Integer getMaxRedemptionsPerCustomer() 
	{
		return maxRedemptionsPerCustomer;
	}
	
	public void setMaxTotalRedemptions(final Integer maxTotalRedemptions)
	{
		this.maxTotalRedemptions = maxTotalRedemptions;
	}

	public Integer getMaxTotalRedemptions() 
	{
		return maxTotalRedemptions;
	}
	

}