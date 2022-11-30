/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.consignmenttrackingocc.dto.consignmenttracking;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Carrier
 */
@ApiModel(value="carrier", description="Carrier")
public  class CarrierWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Carrier code<br/><br/><i>Generated property</i> for <code>CarrierWsDTO.code</code> property defined at extension <code>consignmenttrackingocc</code>. */
@ApiModelProperty(name="code", value="Carrier code") 	
	private String code;

	/** Carrier name<br/><br/><i>Generated property</i> for <code>CarrierWsDTO.name</code> property defined at extension <code>consignmenttrackingocc</code>. */
@ApiModelProperty(name="name", value="Carrier name") 	
	private String name;
	
	public CarrierWsDTO()
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