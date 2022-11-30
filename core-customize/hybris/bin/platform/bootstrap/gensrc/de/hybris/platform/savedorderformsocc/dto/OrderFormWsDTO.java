/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.savedorderformsocc.dto;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import de.hybris.platform.savedorderformsocc.dto.OrderFormEntryWsDTO;
import java.util.List;


import java.util.Objects;
public  class OrderFormWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderFormWsDTO.code</code> property defined at extension <code>savedorderformsocc</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>OrderFormWsDTO.description</code> property defined at extension <code>savedorderformsocc</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>OrderFormWsDTO.currency</code> property defined at extension <code>savedorderformsocc</code>. */
	
	private CurrencyWsDTO currency;

	/** <i>Generated property</i> for <code>OrderFormWsDTO.user</code> property defined at extension <code>savedorderformsocc</code>. */
	
	private PrincipalWsDTO user;

	/** <i>Generated property</i> for <code>OrderFormWsDTO.entries</code> property defined at extension <code>savedorderformsocc</code>. */
	
	private List<OrderFormEntryWsDTO> entries;
	
	public OrderFormWsDTO()
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
	
	public void setCurrency(final CurrencyWsDTO currency)
	{
		this.currency = currency;
	}

	public CurrencyWsDTO getCurrency() 
	{
		return currency;
	}
	
	public void setUser(final PrincipalWsDTO user)
	{
		this.user = user;
	}

	public PrincipalWsDTO getUser() 
	{
		return user;
	}
	
	public void setEntries(final List<OrderFormEntryWsDTO> entries)
	{
		this.entries = entries;
	}

	public List<OrderFormEntryWsDTO> getEntries() 
	{
		return entries;
	}
	

}