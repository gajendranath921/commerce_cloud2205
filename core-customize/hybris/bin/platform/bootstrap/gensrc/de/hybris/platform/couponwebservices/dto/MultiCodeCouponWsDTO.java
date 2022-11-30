/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.couponwebservices.dto;

import de.hybris.platform.couponwebservices.dto.AbstractCouponWsDTO;
import de.hybris.platform.couponwebservices.dto.CouponGeneratedCodeWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Multi code coupon
 */
@ApiModel(value="multiCodeCoupon", description="Multi code coupon")
public  class MultiCodeCouponWsDTO extends AbstractCouponWsDTO 

{



	/** Mandatory field. Represents the name of the CodeGenerationConfiguration, available in the system<br/><br/><i>Generated property</i> for <code>MultiCodeCouponWsDTO.codeGenerationConfiguration</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="codeGenerationConfiguration", value="Mandatory field. Represents the name of the CodeGenerationConfiguration, available in the system") 	
	private String codeGenerationConfiguration;

	/** Mandatory field<br/><br/><i>Generated property</i> for <code>MultiCodeCouponWsDTO.couponCodeNumber</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="couponCodeNumber", value="Mandatory field") 	
	private Long couponCodeNumber;

	/** List of media codes containing the generated codes<br/><br/><i>Generated property</i> for <code>MultiCodeCouponWsDTO.generatedCodes</code> property defined at extension <code>couponwebservices</code>. */
@ApiModelProperty(name="generatedCodes", value="List of media codes containing the generated codes") 	
	private List<CouponGeneratedCodeWsDTO> generatedCodes;
	
	public MultiCodeCouponWsDTO()
	{
		// default constructor
	}
	
	public void setCodeGenerationConfiguration(final String codeGenerationConfiguration)
	{
		this.codeGenerationConfiguration = codeGenerationConfiguration;
	}

	public String getCodeGenerationConfiguration() 
	{
		return codeGenerationConfiguration;
	}
	
	public void setCouponCodeNumber(final Long couponCodeNumber)
	{
		this.couponCodeNumber = couponCodeNumber;
	}

	public Long getCouponCodeNumber() 
	{
		return couponCodeNumber;
	}
	
	public void setGeneratedCodes(final List<CouponGeneratedCodeWsDTO> generatedCodes)
	{
		this.generatedCodes = generatedCodes;
	}

	public List<CouponGeneratedCodeWsDTO> getGeneratedCodes() 
	{
		return generatedCodes;
	}
	

}