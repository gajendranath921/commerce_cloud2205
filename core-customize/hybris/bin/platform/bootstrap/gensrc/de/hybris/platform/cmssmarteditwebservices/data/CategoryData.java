/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.MediaData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
@ApiModel(value="CategoryData")
public  class CategoryData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CategoryData.uid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="uid") 	
	private String uid;

	/** <i>Generated property</i> for <code>CategoryData.code</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>CategoryData.name</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="name") 	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>CategoryData.description</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="description") 	
	private Map<String,String> description;

	/** <i>Generated property</i> for <code>CategoryData.thumbnail</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="thumbnail") 	
	private MediaData thumbnail;

	/** <i>Generated property</i> for <code>CategoryData.catalogId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CategoryData.catalogVersion</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogVersion") 	
	private String catalogVersion;
	
	public CategoryData()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
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
	
	public void setThumbnail(final MediaData thumbnail)
	{
		this.thumbnail = thumbnail;
	}

	public MediaData getThumbnail() 
	{
		return thumbnail;
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