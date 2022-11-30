/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsFacetConfiguration;
import de.hybris.platform.adaptivesearch.data.AsFacetData;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractEditorData;


import java.util.Objects;
public abstract  class AbstractFacetConfigurationEditorData extends AbstractEditorData 

{



	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.indexProperty</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String indexProperty;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.priority</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private Integer priority;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.multiselect</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean multiselect;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.facetFiltersCount</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private Integer facetFiltersCount;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.facetConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AbstractAsFacetConfiguration facetConfiguration;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.facet</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AsFacetData facet;
	
	public AbstractFacetConfigurationEditorData()
	{
		// default constructor
	}
	
	public void setIndexProperty(final String indexProperty)
	{
		this.indexProperty = indexProperty;
	}

	public String getIndexProperty() 
	{
		return indexProperty;
	}
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

	public Integer getPriority() 
	{
		return priority;
	}
	
	public void setMultiselect(final boolean multiselect)
	{
		this.multiselect = multiselect;
	}

	public boolean isMultiselect() 
	{
		return multiselect;
	}
	
	public void setFacetFiltersCount(final Integer facetFiltersCount)
	{
		this.facetFiltersCount = facetFiltersCount;
	}

	public Integer getFacetFiltersCount() 
	{
		return facetFiltersCount;
	}
	
	public void setFacetConfiguration(final AbstractAsFacetConfiguration facetConfiguration)
	{
		this.facetConfiguration = facetConfiguration;
	}

	public AbstractAsFacetConfiguration getFacetConfiguration() 
	{
		return facetConfiguration;
	}
	
	public void setFacet(final AsFacetData facet)
	{
		this.facet = facet;
	}

	public AsFacetData getFacet() 
	{
		return facet;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final AbstractFacetConfigurationEditorData other = (AbstractFacetConfigurationEditorData) o;
		return Objects.equals(getIndexProperty(), other.getIndexProperty())

			&& Objects.equals(getPriority(), other.getPriority())

			&& Objects.equals(isMultiselect(), other.isMultiselect())

			&& Objects.equals(getFacetFiltersCount(), other.getFacetFiltersCount());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = indexProperty;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = priority;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = multiselect;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = facetFiltersCount;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}