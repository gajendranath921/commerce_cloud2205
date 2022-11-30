/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.data;

import java.io.Serializable;
import java.util.List;
import ywebservicespackage.data.AddressData;


import java.util.Objects;
public  class UserData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserData.defaultBillingAddress</code> property defined at extension <code>ywebservices</code>. */
	
	private AddressData defaultBillingAddress;

	/** <i>Generated property</i> for <code>UserData.defaultShippingAddress</code> property defined at extension <code>ywebservices</code>. */
	
	private AddressData defaultShippingAddress;

	/** <i>Generated property</i> for <code>UserData.addresses</code> property defined at extension <code>ywebservices</code>. */
	
	private List<AddressData> addresses;

	/** <i>Generated property</i> for <code>UserData.description</code> property defined at extension <code>ywebservices</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>UserData.firstName</code> property defined at extension <code>ywebservices</code>. */
	
	private String firstName;

	/** <i>Generated property</i> for <code>UserData.lastName</code> property defined at extension <code>ywebservices</code>. */
	
	private String lastName;
	
	public UserData()
	{
		// default constructor
	}
	
	public void setDefaultBillingAddress(final AddressData defaultBillingAddress)
	{
		this.defaultBillingAddress = defaultBillingAddress;
	}

	public AddressData getDefaultBillingAddress() 
	{
		return defaultBillingAddress;
	}
	
	public void setDefaultShippingAddress(final AddressData defaultShippingAddress)
	{
		this.defaultShippingAddress = defaultShippingAddress;
	}

	public AddressData getDefaultShippingAddress() 
	{
		return defaultShippingAddress;
	}
	
	public void setAddresses(final List<AddressData> addresses)
	{
		this.addresses = addresses;
	}

	public List<AddressData> getAddresses() 
	{
		return addresses;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
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
	

}