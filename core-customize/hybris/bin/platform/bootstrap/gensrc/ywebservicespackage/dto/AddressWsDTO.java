/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Address DTO
 */
@ApiModel(value="address", description="Address DTO")
public  class AddressWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressWsDTO.street</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="street") 	
	private String street;

	/** <i>Generated property</i> for <code>AddressWsDTO.town</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="town") 	
	private String town;

	/** <i>Generated property</i> for <code>AddressWsDTO.streetNumber</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="streetNumber") 	
	private String streetNumber;
	
	public AddressWsDTO()
	{
		// default constructor
	}
	
	public void setStreet(final String street)
	{
		this.street = street;
	}

	public String getStreet() 
	{
		return street;
	}
	
	public void setTown(final String town)
	{
		this.town = town;
	}

	public String getTown() 
	{
		return town;
	}
	
	public void setStreetNumber(final String streetNumber)
	{
		this.streetNumber = streetNumber;
	}

	public String getStreetNumber() 
	{
		return streetNumber;
	}
	

}