/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties for the category.
 */
@ApiModel(value="CategoryWsDTO", description="Specifies properties for the category.")
public  class CategoryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CategoryWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="code", example="ProductPage") 	
	private String code;

	/** <i>Generated property</i> for <code>CategoryWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="name") 	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>CategoryWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="description") 	
	private Map<String,String> description;

	/** <i>Generated property</i> for <code>CategoryWsDTO.thumbnailMediaCode</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="thumbnailMediaCode") 	
	private String thumbnailMediaCode;

	/** <i>Generated property</i> for <code>CategoryWsDTO.catalogId</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="catalogId", example="electronicsContentCatalog") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CategoryWsDTO.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="catalogVersion", example="Staged") 	
	private String catalogVersion;
	
	public CategoryWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

	public Map<String,String> getName() 
	{
		return name;
	}
	
	public void setDescription(final Map<String,String> description)
	{
		this.description = description;
	}

	public Map<String,String> getDescription() 
	{
		return description;
	}
	
	public void setThumbnailMediaCode(final String thumbnailMediaCode)
	{
		this.thumbnailMediaCode = thumbnailMediaCode;
	}

	public String getThumbnailMediaCode() 
	{
		return thumbnailMediaCode;
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	

}