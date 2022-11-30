/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesecommercewebservicescommons.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * data type of delivery timeslot
 */
@ApiModel(value="DeliveryTimeSlot", description="data type of delivery timeslot")
public  class DeliveryTimeSlotWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** delivery timeslot code<br/><br/><i>Generated property</i> for <code>DeliveryTimeSlotWsDTO.code</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="code", value="delivery timeslot code") 	
	private String code;

	/** delivery timeslot name<br/><br/><i>Generated property</i> for <code>DeliveryTimeSlotWsDTO.name</code> property defined at extension <code>chinesecommercewebservicescommons</code>. */
@ApiModelProperty(name="name", value="delivery timeslot name") 	
	private String name;
	
	public DeliveryTimeSlotWsDTO()
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