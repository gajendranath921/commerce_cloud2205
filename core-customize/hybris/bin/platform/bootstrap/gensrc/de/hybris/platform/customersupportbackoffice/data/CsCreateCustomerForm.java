/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customersupportbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.TitleModel;


import java.util.Objects;
public  class CsCreateCustomerForm  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CsCreateCustomerForm.title</code> property defined at extension <code>customersupportbackoffice</code>. */
	
	private TitleModel title;

	/** <i>Generated property</i> for <code>CsCreateCustomerForm.name</code> property defined at extension <code>customersupportbackoffice</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>CsCreateCustomerForm.email</code> property defined at extension <code>customersupportbackoffice</code>. */
	
	private String email;

	/** <i>Generated property</i> for <code>CsCreateCustomerForm.site</code> property defined at extension <code>customersupportbackoffice</code>. */
	
	private BaseSiteModel site;

	/** <i>Generated property</i> for <code>CsCreateCustomerForm.address</code> property defined at extension <code>customersupportbackoffice</code>. */
	
	private AddressModel address;
	
	public CsCreateCustomerForm()
	{
		// default constructor
	}
	
	public void setTitle(final TitleModel title)
	{
		this.title = title;
	}

	public TitleModel getTitle() 
	{
		return title;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setSite(final BaseSiteModel site)
	{
		this.site = site;
	}

	public BaseSiteModel getSite() 
	{
		return site;
	}
	
	public void setAddress(final AddressModel address)
	{
		this.address = address;
	}

	public AddressModel getAddress() 
	{
		return address;
	}
	

}