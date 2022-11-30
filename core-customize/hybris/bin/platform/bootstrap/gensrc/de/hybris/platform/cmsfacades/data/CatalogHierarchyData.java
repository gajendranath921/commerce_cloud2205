/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.CatalogVersionData;
import de.hybris.platform.cmsfacades.data.SiteData;
import java.util.List;
import java.util.Map;


import java.util.Objects;
public  class CatalogHierarchyData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogHierarchyData.catalogId</code> property defined at extension <code>cmsfacades</code>. */
	
	private String catalogId;

	/** <i>Generated property</i> for <code>CatalogHierarchyData.catalogName</code> property defined at extension <code>cmsfacades</code>. */
	
	private Map<String, String> catalogName;

	/** <i>Generated property</i> for <code>CatalogHierarchyData.versions</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<CatalogVersionData> versions;

	/** <i>Generated property</i> for <code>CatalogHierarchyData.sites</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<SiteData> sites;
	
	public CatalogHierarchyData()
	{
		// default constructor
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setCatalogName(final Map<String, String> catalogName)
	{
		this.catalogName = catalogName;
	}

	public Map<String, String> getCatalogName() 
	{
		return catalogName;
	}
	
	public void setVersions(final List<CatalogVersionData> versions)
	{
		this.versions = versions;
	}

	public List<CatalogVersionData> getVersions() 
	{
		return versions;
	}
	
	public void setSites(final List<SiteData> sites)
	{
		this.sites = sites;
	}

	public List<SiteData> getSites() 
	{
		return sites;
	}
	

}