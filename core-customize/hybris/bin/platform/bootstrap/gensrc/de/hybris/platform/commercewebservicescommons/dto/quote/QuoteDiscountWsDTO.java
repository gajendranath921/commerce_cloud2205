/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.quote;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Discount applied to the quote
 */
@ApiModel(value="QuoteDiscount", description="Discount applied to the quote")
public  class QuoteDiscountWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Type of the discount - PERCENT for discount by percentage, ABSOLUTE for discount by amount, TARGET for discount by adjustment of the total value<br/><br/><i>Generated property</i> for <code>QuoteDiscountWsDTO.discountType</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="discountType", value="Type of the discount - PERCENT for discount by percentage, ABSOLUTE for discount by amount, TARGET for discount by adjustment of the total value", required=false, example="PERCENT") 	
	private String discountType;

	/** Value of the discount<br/><br/><i>Generated property</i> for <code>QuoteDiscountWsDTO.discountRate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="discountRate", value="Value of the discount", required=false, example="10") 	
	private Double discountRate;
	
	public QuoteDiscountWsDTO()
	{
		// default constructor
	}
	
	public void setDiscountType(final String discountType)
	{
		this.discountType = discountType;
	}

	public String getDiscountType() 
	{
		return discountType;
	}
	
	public void setDiscountRate(final Double discountRate)
	{
		this.discountRate = discountRate;
	}

	public Double getDiscountRate() 
	{
		return discountRate;
	}
	

}