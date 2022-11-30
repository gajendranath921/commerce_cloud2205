/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import ywebservicespackage.dto.AddressWsDTO;


import java.util.Objects;
/**
 * User DTO
 */
@ApiModel(value="user", description="User DTO")
public  class UserWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserWsDTO.addresses</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="addresses") 	
	private List<AddressWsDTO> addresses;

	/** First Name<br/><br/><i>Generated property</i> for <code>UserWsDTO.firstName</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="firstName", value="First Name", required=true) 	
	private String firstName;

	/** Last Name<br/><br/><i>Generated property</i> for <code>UserWsDTO.lastName</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="lastName", value="Last Name", required=true) 	
	private String lastName;

	/** <i>Generated property</i> for <code>UserWsDTO.info</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="info") 	
	private String info;

	/** Billing Address<br/><br/><i>Generated property</i> for <code>UserWsDTO.billingAddress</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="billingAddress", value="Billing Address") 	
	private AddressWsDTO billingAddress;

	/** Shipping Address<br/><br/><i>Generated property</i> for <code>UserWsDTO.shippingAddress</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="shippingAddress", value="Shipping Address") 	
	private AddressWsDTO shippingAddress;
	
	public UserWsDTO()
	{
		// default constructor
	}
	
	public void setAddresses(final List<AddressWsDTO> addresses)
	{
		this.addresses = addresses;
	}

	public List<AddressWsDTO> getAddresses() 
	{
		return addresses;
	}
	
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getLastName() 
	{
		return lastName;
	}
	
	public void setInfo(final String info)
	{
		this.info = info;
	}

	public String getInfo() 
	{
		return info;
	}
	
	public void setBillingAddress(final AddressWsDTO billingAddress)
	{
		this.billingAddress = billingAddress;
	}

	public AddressWsDTO getBillingAddress() 
	{
		return billingAddress;
	}
	
	public void setShippingAddress(final AddressWsDTO shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	public AddressWsDTO getShippingAddress() 
	{
		return shippingAddress;
	}
	

}