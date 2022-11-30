/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;


import java.util.Objects;
public  class SearchContextData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchContextData.language</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String language;

	/** <i>Generated property</i> for <code>SearchContextData.currency</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String currency;
	
	public SearchContextData()
	{
		// default constructor
	}
	
	public void setLanguage(final String language)
	{
		this.language = language;
	}

	public String getLanguage() 
	{
		return language;
	}
	
	public void setCurrency(final String currency)
	{
		this.currency = currency;
	}

	public String getCurrency() 
	{
		return currency;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final SearchContextData other = (SearchContextData) o;
		return Objects.equals(getLanguage(), other.getLanguage())

			&& Objects.equals(getCurrency(), other.getCurrency());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = language;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = currency;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}