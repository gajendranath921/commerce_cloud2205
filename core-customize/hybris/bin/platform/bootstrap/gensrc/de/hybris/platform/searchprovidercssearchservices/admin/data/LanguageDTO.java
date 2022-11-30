/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.admin.data;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;


import java.util.Objects;
public  class LanguageDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>LanguageDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>LanguageDTO.name</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Map<Locale,String> name;
	
	public LanguageDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setName(final Map<Locale,String> name)
	{
		this.name = name;
	}

	public Map<Locale,String> getName() 
	{
		return name;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final LanguageDTO other = (LanguageDTO) o;
		return Objects.equals(getName(), other.getName());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = name;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}