/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.admin.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.admin.data.LanguageDTO;
import de.hybris.platform.searchprovidercssearchservices.admin.data.QualifierTypeDTO;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import java.util.Objects;
public  class IndexConfigurationDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>IndexConfigurationDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>IndexConfigurationDTO.name</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Map<Locale,String> name;

	/** <i>Generated property</i> for <code>IndexConfigurationDTO.languages</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<LanguageDTO> languages;

	/** <i>Generated property</i> for <code>IndexConfigurationDTO.qualifierTypes</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<QualifierTypeDTO> qualifierTypes;

	/** <i>Generated property</i> for <code>IndexConfigurationDTO.synonymDictionaryIds</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<String> synonymDictionaryIds;
	
	public IndexConfigurationDTO()
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
	
	public void setLanguages(final List<LanguageDTO> languages)
	{
		this.languages = languages;
	}

	public List<LanguageDTO> getLanguages() 
	{
		return languages;
	}
	
	public void setQualifierTypes(final List<QualifierTypeDTO> qualifierTypes)
	{
		this.qualifierTypes = qualifierTypes;
	}

	public List<QualifierTypeDTO> getQualifierTypes() 
	{
		return qualifierTypes;
	}
	
	public void setSynonymDictionaryIds(final List<String> synonymDictionaryIds)
	{
		this.synonymDictionaryIds = synonymDictionaryIds;
	}

	public List<String> getSynonymDictionaryIds() 
	{
		return synonymDictionaryIds;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final IndexConfigurationDTO other = (IndexConfigurationDTO) o;
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