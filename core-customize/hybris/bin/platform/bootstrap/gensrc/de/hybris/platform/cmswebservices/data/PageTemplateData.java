/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Specifies properties of the page template.
 */
@ApiModel(value="PageTemplateData", description="Specifies properties of the page template.")
public  class PageTemplateData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTemplateData.uid</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="uid", example="ProductDetailsPageTemplate") 	
	private String uid;

	/** <i>Generated property</i> for <code>PageTemplateData.uuid</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="uuid") 	
	private String uuid;

	/** <i>Generated property</i> for <code>PageTemplateData.name</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="name", example="homepage") 	
	private String name;

	/** <i>Generated property</i> for <code>PageTemplateData.frontEndName</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="frontEndName", example="product/productLayout2Page") 	
	private String frontEndName;

	/** <i>Generated property</i> for <code>PageTemplateData.previewIcon</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="previewIcon") 	
	private String previewIcon;

	/** <i>Generated property</i> for <code>PageTemplateData.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="catalogVersion") 	
	private String catalogVersion;
	
	public PageTemplateData()
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
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid() 
	{
		return uuid;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setFrontEndName(final String frontEndName)
	{
		this.frontEndName = frontEndName;
	}

	public String getFrontEndName() 
	{
		return frontEndName;
	}
	
	public void setPreviewIcon(final String previewIcon)
	{
		this.previewIcon = previewIcon;
	}

	public String getPreviewIcon() 
	{
		return previewIcon;
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