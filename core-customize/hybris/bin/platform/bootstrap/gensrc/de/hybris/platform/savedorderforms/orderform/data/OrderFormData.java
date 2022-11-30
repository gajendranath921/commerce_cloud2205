/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.savedorderforms.orderform.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.storesession.data.CurrencyData;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import de.hybris.platform.savedorderforms.orderform.data.OrderFormEntryData;
import java.util.List;


import java.util.Objects;
public  class OrderFormData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderFormData.code</code> property defined at extension <code>savedorderforms</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>OrderFormData.description</code> property defined at extension <code>savedorderforms</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>OrderFormData.user</code> property defined at extension <code>savedorderforms</code>. */
	
	private PrincipalData user;

	/** <i>Generated property</i> for <code>OrderFormData.currency</code> property defined at extension <code>savedorderforms</code>. */
	
	private CurrencyData currency;

	/** <i>Generated property</i> for <code>OrderFormData.entries</code> property defined at extension <code>savedorderforms</code>. */
	
	private List<OrderFormEntryData> entries;
	
	public OrderFormData()
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
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setUser(final PrincipalData user)
	{
		this.user = user;
	}

	public PrincipalData getUser() 
	{
		return user;
	}
	
	public void setCurrency(final CurrencyData currency)
	{
		this.currency = currency;
	}

	public CurrencyData getCurrency() 
	{
		return currency;
	}
	
	public void setEntries(final List<OrderFormEntryData> entries)
	{
		this.entries = entries;
	}

	public List<OrderFormEntryData> getEntries() 
	{
		return entries;
	}
	

}