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
import de.hybris.platform.searchprovidercssearchservices.admin.data.SearchToleranceDTO;
import de.hybris.platform.searchprovidercssearchservices.indexer.data.FieldTypeDTO;
import java.util.Locale;
import java.util.Map;


import java.util.Objects;
public  class FieldDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FieldDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>FieldDTO.name</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Map<Locale,String> name;

	/** <i>Generated property</i> for <code>FieldDTO.fieldType</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private FieldTypeDTO fieldType;

	/** <i>Generated property</i> for <code>FieldDTO.retrievable</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean retrievable;

	/** <i>Generated property</i> for <code>FieldDTO.searchable</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean searchable;

	/** <i>Generated property</i> for <code>FieldDTO.searchTolerance</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private SearchToleranceDTO searchTolerance;

	/** <i>Generated property</i> for <code>FieldDTO.localized</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean localized;

	/** <i>Generated property</i> for <code>FieldDTO.qualifierTypeId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String qualifierTypeId;

	/** <i>Generated property</i> for <code>FieldDTO.multiValued</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean multiValued;

	/** <i>Generated property</i> for <code>FieldDTO.useForSuggesting</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean useForSuggesting;

	/** <i>Generated property</i> for <code>FieldDTO.useForSpellchecking</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Boolean useForSpellchecking;

	/** <i>Generated property</i> for <code>FieldDTO.weight</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Float weight;
	
	public FieldDTO()
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
	
	public void setFieldType(final FieldTypeDTO fieldType)
	{
		this.fieldType = fieldType;
	}

	public FieldTypeDTO getFieldType() 
	{
		return fieldType;
	}
	
	public void setRetrievable(final Boolean retrievable)
	{
		this.retrievable = retrievable;
	}

	public Boolean getRetrievable() 
	{
		return retrievable;
	}
	
	public void setSearchable(final Boolean searchable)
	{
		this.searchable = searchable;
	}

	public Boolean getSearchable() 
	{
		return searchable;
	}
	
	public void setSearchTolerance(final SearchToleranceDTO searchTolerance)
	{
		this.searchTolerance = searchTolerance;
	}

	public SearchToleranceDTO getSearchTolerance() 
	{
		return searchTolerance;
	}
	
	public void setLocalized(final Boolean localized)
	{
		this.localized = localized;
	}

	public Boolean getLocalized() 
	{
		return localized;
	}
	
	public void setQualifierTypeId(final String qualifierTypeId)
	{
		this.qualifierTypeId = qualifierTypeId;
	}

	public String getQualifierTypeId() 
	{
		return qualifierTypeId;
	}
	
	public void setMultiValued(final Boolean multiValued)
	{
		this.multiValued = multiValued;
	}

	public Boolean getMultiValued() 
	{
		return multiValued;
	}
	
	public void setUseForSuggesting(final Boolean useForSuggesting)
	{
		this.useForSuggesting = useForSuggesting;
	}

	public Boolean getUseForSuggesting() 
	{
		return useForSuggesting;
	}
	
	public void setUseForSpellchecking(final Boolean useForSpellchecking)
	{
		this.useForSpellchecking = useForSpellchecking;
	}

	public Boolean getUseForSpellchecking() 
	{
		return useForSpellchecking;
	}
	
	public void setWeight(final Float weight)
	{
		this.weight = weight;
	}

	public Float getWeight() 
	{
		return weight;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final FieldDTO other = (FieldDTO) o;
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