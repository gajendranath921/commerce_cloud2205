/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearchbackoffice.data.CatalogVersionData;
import de.hybris.platform.adaptivesearchbackoffice.data.CategoryData;
import java.util.List;


import java.util.Objects;
public  class NavigationContextData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationContextData.indexConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String indexConfiguration;

	/** <i>Generated property</i> for <code>NavigationContextData.indexType</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String indexType;

	/** <i>Generated property</i> for <code>NavigationContextData.catalogVersion</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private CatalogVersionData catalogVersion;

	/** <i>Generated property</i> for <code>NavigationContextData.category</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private CategoryData category;

	/** <i>Generated property</i> for <code>NavigationContextData.currentSearchProfile</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String currentSearchProfile;

	/** <i>Generated property</i> for <code>NavigationContextData.searchProfiles</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private List<String> searchProfiles;
	
	public NavigationContextData()
	{
		// default constructor
	}
	
	public void setIndexConfiguration(final String indexConfiguration)
	{
		this.indexConfiguration = indexConfiguration;
	}

	public String getIndexConfiguration() 
	{
		return indexConfiguration;
	}
	
	public void setIndexType(final String indexType)
	{
		this.indexType = indexType;
	}

	public String getIndexType() 
	{
		return indexType;
	}
	
	public void setCatalogVersion(final CatalogVersionData catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public CatalogVersionData getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setCategory(final CategoryData category)
	{
		this.category = category;
	}

	public CategoryData getCategory() 
	{
		return category;
	}
	
	public void setCurrentSearchProfile(final String currentSearchProfile)
	{
		this.currentSearchProfile = currentSearchProfile;
	}

	public String getCurrentSearchProfile() 
	{
		return currentSearchProfile;
	}
	
	public void setSearchProfiles(final List<String> searchProfiles)
	{
		this.searchProfiles = searchProfiles;
	}

	public List<String> getSearchProfiles() 
	{
		return searchProfiles;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final NavigationContextData other = (NavigationContextData) o;
		return Objects.equals(getIndexConfiguration(), other.getIndexConfiguration())

			&& Objects.equals(getIndexType(), other.getIndexType())

			&& Objects.equals(getCatalogVersion(), other.getCatalogVersion())

			&& Objects.equals(getCategory(), other.getCategory())

			&& Objects.equals(getSearchProfiles(), other.getSearchProfiles());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = indexConfiguration;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = indexType;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = catalogVersion;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = category;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = searchProfiles;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}