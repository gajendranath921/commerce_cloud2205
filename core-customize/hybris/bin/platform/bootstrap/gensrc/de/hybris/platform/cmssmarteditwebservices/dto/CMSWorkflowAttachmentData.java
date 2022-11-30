/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the CMS workflow attachment data.
 */
@ApiModel(value="CMSWorkflowAttachmentData", description="Specifies properties of the CMS workflow attachment data.")
public  class CMSWorkflowAttachmentData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.pageUid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="pageUid", example="homepage") 	
	private String pageUid;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.pageName</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="pageName", example="Homepage") 	
	private String pageName;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogId", example="electronicsContentCatalog") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogName</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogName", example="{\"en\": \"Electronics Content Catalog\", \"de\": \"Elektronikkatalog\"}") 	
	private Map<String,String> catalogName;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogVersion</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogVersion", example="Staged") 	
	private String catalogVersion;
	
	public CMSWorkflowAttachmentData()
	{
		// default constructor
	}
	
	public void setPageUid(final String pageUid)
	{
		this.pageUid = pageUid;
	}

	public String getPageUid() 
	{
		return pageUid;
	}
	
	public void setPageName(final String pageName)
	{
		this.pageName = pageName;
	}

	public String getPageName() 
	{
		return pageName;
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setCatalogName(final Map<String,String> catalogName)
	{
		this.catalogName = catalogName;
	}

	public Map<String,String> getCatalogName() 
	{
		return catalogName;
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