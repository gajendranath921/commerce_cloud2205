/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.order;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Representation of a Packaging Information
 */
@ApiModel(value="PackagingInfo", description="Representation of a Packaging Information")
public  class PackagingInfoWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PackagingInfoWsDTO.width</code> property defined at extension <code>warehousingwebservices</code>. */
@ApiModelProperty(name="width") 	
	private String width;

	/** <i>Generated property</i> for <code>PackagingInfoWsDTO.height</code> property defined at extension <code>warehousingwebservices</code>. */
@ApiModelProperty(name="height") 	
	private String height;

	/** <i>Generated property</i> for <code>PackagingInfoWsDTO.length</code> property defined at extension <code>warehousingwebservices</code>. */
@ApiModelProperty(name="length") 	
	private String length;

	/** <i>Generated property</i> for <code>PackagingInfoWsDTO.grossWeight</code> property defined at extension <code>warehousingwebservices</code>. */
@ApiModelProperty(name="grossWeight") 	
	private String grossWeight;

	/** <i>Generated property</i> for <code>PackagingInfoWsDTO.insuredValue</code> property defined at extension <code>warehousingwebservices</code>. */
@ApiModelProperty(name="insuredValue") 	
	private String insuredValue;

	/** <i>Generated property</i> for <code>PackagingInfoWsDTO.dimensionUnit</code> property defined at extension <code>warehousingwebservices</code>. */
@ApiModelProperty(name="dimensionUnit") 	
	private String dimensionUnit;

	/** <i>Generated property</i> for <code>PackagingInfoWsDTO.weightUnit</code> property defined at extension <code>warehousingwebservices</code>. */
@ApiModelProperty(name="weightUnit") 	
	private String weightUnit;
	
	public PackagingInfoWsDTO()
	{
		// default constructor
	}
	
	public void setWidth(final String width)
	{
		this.width = width;
	}

	public String getWidth() 
	{
		return width;
	}
	
	public void setHeight(final String height)
	{
		this.height = height;
	}

	public String getHeight() 
	{
		return height;
	}
	
	public void setLength(final String length)
	{
		this.length = length;
	}

	public String getLength() 
	{
		return length;
	}
	
	public void setGrossWeight(final String grossWeight)
	{
		this.grossWeight = grossWeight;
	}

	public String getGrossWeight() 
	{
		return grossWeight;
	}
	
	public void setInsuredValue(final String insuredValue)
	{
		this.insuredValue = insuredValue;
	}

	public String getInsuredValue() 
	{
		return insuredValue;
	}
	
	public void setDimensionUnit(final String dimensionUnit)
	{
		this.dimensionUnit = dimensionUnit;
	}

	public String getDimensionUnit() 
	{
		return dimensionUnit;
	}
	
	public void setWeightUnit(final String weightUnit)
	{
		this.weightUnit = weightUnit;
	}

	public String getWeightUnit() 
	{
		return weightUnit;
	}
	

}