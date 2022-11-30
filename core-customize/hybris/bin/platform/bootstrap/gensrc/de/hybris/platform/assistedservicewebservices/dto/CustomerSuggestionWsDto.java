/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedservicewebservices.dto;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class CustomerSuggestionWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDto.email</code> property defined at extension <code>assistedservicewebservices</code>. */
	
	private String email;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDto.fullName</code> property defined at extension <code>assistedservicewebservices</code>. */
	
	private String fullName;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDto.date</code> property defined at extension <code>assistedservicewebservices</code>. */
	
	private String date;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDto.card</code> property defined at extension <code>assistedservicewebservices</code>. */
	
	private String card;

	/** <i>Generated property</i> for <code>CustomerSuggestionWsDto.carts</code> property defined at extension <code>assistedservicewebservices</code>. */
	
	private List<String> carts;
	
	public CustomerSuggestionWsDto()
	{
		// default constructor
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setFullName(final String fullName)
	{
		this.fullName = fullName;
	}

	public String getFullName() 
	{
		return fullName;
	}
	
	public void setDate(final String date)
	{
		this.date = date;
	}

	public String getDate() 
	{
		return date;
	}
	
	public void setCard(final String card)
	{
		this.card = card;
	}

	public String getCard() 
	{
		return card;
	}
	
	public void setCarts(final List<String> carts)
	{
		this.carts = carts;
	}

	public List<String> getCarts() 
	{
		return carts;
	}
	

}