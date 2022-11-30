/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.user.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.user.data.AddressData;
import java.util.List;


import java.util.Objects;
public  class AddressDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressDataList.addresses</code> property defined at extension <code>commercewebservices</code>. */
	
	private List<AddressData> addresses;
	
	public AddressDataList()
	{
		// default constructor
	}
	
	public void setAddresses(final List<AddressData> addresses)
	{
		this.addresses = addresses;
	}

	public List<AddressData> getAddresses() 
	{
		return addresses;
	}
	

}