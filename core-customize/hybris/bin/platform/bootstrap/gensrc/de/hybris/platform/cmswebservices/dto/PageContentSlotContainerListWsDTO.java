/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.dto.PageContentSlotContainerWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available content slot containers.
 */
@ApiModel(value="PageContentSlotContainerListWsDTO", description="Specifies a list of available content slot containers.")
public  class PageContentSlotContainerListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotContainerListWsDTO.pageContentSlotContainerList</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="pageContentSlotContainerList") 	
	private List<PageContentSlotContainerWsDTO> pageContentSlotContainerList;
	
	public PageContentSlotContainerListWsDTO()
	{
		// default constructor
	}
	
	public void setPageContentSlotContainerList(final List<PageContentSlotContainerWsDTO> pageContentSlotContainerList)
	{
		this.pageContentSlotContainerList = pageContentSlotContainerList;
	}

	public List<PageContentSlotContainerWsDTO> getPageContentSlotContainerList() 
	{
		return pageContentSlotContainerList;
	}
	

}