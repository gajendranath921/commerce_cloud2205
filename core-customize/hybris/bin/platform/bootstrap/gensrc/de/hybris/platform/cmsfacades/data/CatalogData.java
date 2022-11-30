/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.CatalogHierarchyData;
import de.hybris.platform.cmsfacades.data.CatalogVersionData;
import de.hybris.platform.cmsfacades.data.SiteData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;


import java.util.Objects;
@ApiModel(value="CatalogData")
public  class CatalogData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogData.catalogId</code> property defined at extension <code>cmsfacades</code>. */
@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CatalogData.name</code> property defined at extension <code>cmsfacades</code>. */
@ApiModelProperty(name="name") 	
	private Map<String, String> name;

	/** <i>Generated property</i> for <code>CatalogData.sites</code> property defined at extension <code>cmsfacades</code>. */
@ApiModelProperty(name="sites") 	
	private List<SiteData> sites;

	/** <i>Generated property</i> for <code>CatalogData.versions</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="versions") 	
	private List<CatalogVersionData> versions;

	/** <i>Generated property</i> for <code>CatalogData.parents</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="parents") 	
	private List<CatalogHierarchyData> parents;
	
	public CatalogData()
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
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

	public Map<String, String> getName() 
	{
		return name;
	}
	
	public void setSites(final List<SiteData> sites)
	{
		this.sites = sites;
	}

	public List<SiteData> getSites() 
	{
		return sites;
	}
	
	public void setVersions(final List<CatalogVersionData> versions)
	{
		this.versions = versions;
	}

	public List<CatalogVersionData> getVersions() 
	{
		return versions;
	}
	
	public void setParents(final List<CatalogHierarchyData> parents)
	{
		this.parents = parents;
	}

	public List<CatalogHierarchyData> getParents() 
	{
		return parents;
	}
	

}