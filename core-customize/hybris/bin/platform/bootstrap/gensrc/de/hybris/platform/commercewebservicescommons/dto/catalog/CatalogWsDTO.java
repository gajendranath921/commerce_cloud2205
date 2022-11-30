/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.catalog;

import de.hybris.platform.commercewebservicescommons.dto.catalog.AbstractCatalogItemWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.catalog.CatalogVersionWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;


import java.util.Objects;
/**
 * Representation of an Catalog
 */
@ApiModel(value="Catalog", description="Representation of an Catalog")
public  class CatalogWsDTO extends AbstractCatalogItemWsDTO 

{



	/** List of versions of catalog<br/><br/><i>Generated property</i> for <code>CatalogWsDTO.catalogVersions</code> property defined at extension <code>commercewebservicescommons</code>. */
@ApiModelProperty(name="catalogVersions", value="List of versions of catalog") 	
	private Collection<CatalogVersionWsDTO> catalogVersions;
	
	public CatalogWsDTO()
	{
		// default constructor
	}
	
	public void setCatalogVersions(final Collection<CatalogVersionWsDTO> catalogVersions)
	{
		this.catalogVersions = catalogVersions;
	}

	public Collection<CatalogVersionWsDTO> getCatalogVersions() 
	{
		return catalogVersions;
	}
	

}