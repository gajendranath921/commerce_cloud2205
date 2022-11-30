/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
@ApiModel(value="MediaWsDTO")
public  class MediaWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaWsDTO.code</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>MediaWsDTO.catalogId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>MediaWsDTO.catalogVersion</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogVersion") 	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>MediaWsDTO.mime</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="mime") 	
	private String mime;

	/** <i>Generated property</i> for <code>MediaWsDTO.altText</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="altText") 	
	private String altText;

	/** <i>Generated property</i> for <code>MediaWsDTO.description</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="description") 	
	private String description;

	/** <i>Generated property</i> for <code>MediaWsDTO.url</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="url") 	
	private String url;

	/** <i>Generated property</i> for <code>MediaWsDTO.downloadUrl</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="downloadUrl") 	
	private String downloadUrl;
	
	public MediaWsDTO()
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
	
	public void setMime(final String mime)
	{
		this.mime = mime;
	}

	public String getMime() 
	{
		return mime;
	}
	
	public void setAltText(final String altText)
	{
		this.altText = altText;
	}

	public String getAltText() 
	{
		return altText;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	
	public void setDownloadUrl(final String downloadUrl)
	{
		this.downloadUrl = downloadUrl;
	}

	public String getDownloadUrl() 
	{
		return downloadUrl;
	}
	

}