/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.admin.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.admin.data.SynonymEntryDTO;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import java.util.Objects;
public  class SynonymDictionaryDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SynonymDictionaryDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>SynonymDictionaryDTO.name</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Map<Locale,String> name;

	/** <i>Generated property</i> for <code>SynonymDictionaryDTO.languageIds</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<String> languageIds;

	/** <i>Generated property</i> for <code>SynonymDictionaryDTO.entries</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<SynonymEntryDTO> entries;
	
	public SynonymDictionaryDTO()
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
	
	public void setLanguageIds(final List<String> languageIds)
	{
		this.languageIds = languageIds;
	}

	public List<String> getLanguageIds() 
	{
		return languageIds;
	}
	
	public void setEntries(final List<SynonymEntryDTO> entries)
	{
		this.entries = entries;
	}

	public List<SynonymEntryDTO> getEntries() 
	{
		return entries;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final SynonymDictionaryDTO other = (SynonymDictionaryDTO) o;
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