/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.CatalogVersionWsDTO;
import de.hybris.platform.cmssmarteditwebservices.dto.SiteWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;


import java.util.Objects;
@ApiModel(value="catalogHierarchy")
public  class CatalogHierarchyWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogHierarchyWsDTO.catalogId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CatalogHierarchyWsDTO.catalogName</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogName") 	
	private Map<String, String> catalogName;

	/** <i>Generated property</i> for <code>CatalogHierarchyWsDTO.versions</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="versions") 	
	private List<CatalogVersionWsDTO> versions;

	/** <i>Generated property</i> for <code>CatalogHierarchyWsDTO.sites</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="sites") 	
	private List<SiteWsDTO> sites;
	
	public CatalogHierarchyWsDTO()
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
	
	public void setVersions(final List<CatalogVersionWsDTO> versions)
	{
		this.versions = versions;
	}

	public List<CatalogVersionWsDTO> getVersions() 
	{
		return versions;
	}
	
	public void setSites(final List<SiteWsDTO> sites)
	{
		this.sites = sites;
	}

	public List<SiteWsDTO> getSites() 
	{
		return sites;
	}
	

}