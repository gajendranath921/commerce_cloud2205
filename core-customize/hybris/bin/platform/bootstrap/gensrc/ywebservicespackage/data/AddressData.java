/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.data;

import java.io.Serializable;


import java.util.Objects;
public  class AddressData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressData.streetname</code> property defined at extension <code>ywebservices</code>. */
	
	private String streetname;

	/** <i>Generated property</i> for <code>AddressData.streetnumber</code> property defined at extension <code>ywebservices</code>. */
	
	private String streetnumber;

	/** <i>Generated property</i> for <code>AddressData.town</code> property defined at extension <code>ywebservices</code>. */
	
	private String town;

	/** <i>Generated property</i> for <code>AddressData.shippingAddress</code> property defined at extension <code>ywebservices</code>. */
	
	private boolean shippingAddress;

	/** <i>Generated property</i> for <code>AddressData.billingAddress</code> property defined at extension <code>ywebservices</code>. */
	
	private boolean billingAddress;

	/** <i>Generated property</i> for <code>AddressData.defaultAddress</code> property defined at extension <code>ywebservices</code>. */
	
	private boolean defaultAddress;

	/** <i>Generated property</i> for <code>AddressData.formattedAddress</code> property defined at extension <code>ywebservices</code>. */
	
	private String formattedAddress;
	
	public AddressData()
	{
		// default constructor
	}
	
	public void setStreetname(final String streetname)
	{
		this.streetname = streetname;
	}

	public String getStreetname() 
	{
		return streetname;
	}
	
	public void setStreetnumber(final String streetnumber)
	{
		this.streetnumber = streetnumber;
	}

	public String getStreetnumber() 
	{
		return streetnumber;
	}
	
	public void setTown(final String town)
	{
		this.town = town;
	}

	public String getTown() 
	{
		return town;
	}
	
	public void setShippingAddress(final boolean shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	public boolean isShippingAddress() 
	{
		return shippingAddress;
	}
	
	public void setBillingAddress(final boolean billingAddress)
	{
		this.billingAddress = billingAddress;
	}

	public boolean isBillingAddress() 
	{
		return billingAddress;
	}
	
	public void setDefaultAddress(final boolean defaultAddress)
	{
		this.defaultAddress = defaultAddress;
	}

	public boolean isDefaultAddress() 
	{
		return defaultAddress;
	}
	
	public void setFormattedAddress(final String formattedAddress)
	{
		this.formattedAddress = formattedAddress;
	}

	public String getFormattedAddress() 
	{
		return formattedAddress;
	}
	

}