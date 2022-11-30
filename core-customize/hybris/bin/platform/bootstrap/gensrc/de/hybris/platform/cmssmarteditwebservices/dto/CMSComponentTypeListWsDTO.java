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
import de.hybris.platform.cmssmarteditwebservices.data.ComponentTypeData;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
@ApiModel(value="CMSComponentTypeListWsDTO")
public  class CMSComponentTypeListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSComponentTypeListWsDTO.componentTypes</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="componentTypes") 	
	private List<ComponentTypeData> componentTypes;

	/** <i>Generated property</i> for <code>CMSComponentTypeListWsDTO.pagination</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="pagination") 	
	private PaginationWsDTO pagination;
	
	public CMSComponentTypeListWsDTO()
	{
		// default constructor
	}
	
	public void setComponentTypes(final List<ComponentTypeData> componentTypes)
	{
		this.componentTypes = componentTypes;
	}

	public List<ComponentTypeData> getComponentTypes() 
	{
		return componentTypes;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	

}