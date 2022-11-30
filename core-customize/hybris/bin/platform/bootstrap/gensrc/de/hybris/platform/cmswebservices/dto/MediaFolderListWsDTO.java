/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available media folders.
 */
@ApiModel(value="MediaFolderListWsDTO", description="Specifies a list of available media folders.")
public  class MediaFolderListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaFolderListWsDTO.mediaFolders</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="mediaFolders") 	
	private List<MediaFolderWsDTO> mediaFolders;

	/** <i>Generated property</i> for <code>MediaFolderListWsDTO.pagination</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="pagination", example="{\"count\" : \"0\", \"page\" : \"0\", \"totalCount\" : \"0\", \"totalPages\" : \"0\"}") 	
	private PaginationWsDTO pagination;
	
	public MediaFolderListWsDTO()
	{
		// default constructor
	}
	
	public void setMediaFolders(final List<MediaFolderWsDTO> mediaFolders)
	{
		this.mediaFolders = mediaFolders;
	}

	public List<MediaFolderWsDTO> getMediaFolders() 
	{
		return mediaFolders;
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