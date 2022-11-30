/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
@ApiModel(value="CMSPageOperationWsDTO")
public  class CMSPageOperationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSPageOperationWsDTO.operation</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="operation") 	
	private String operation;

	/** <i>Generated property</i> for <code>CMSPageOperationWsDTO.catalogId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CMSPageOperationWsDTO.sourceCatalogVersion</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="sourceCatalogVersion") 	
	private String sourceCatalogVersion;

	/** <i>Generated property</i> for <code>CMSPageOperationWsDTO.targetCatalogVersion</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="targetCatalogVersion") 	
	private String targetCatalogVersion;
	
	public CMSPageOperationWsDTO()
	{
		// default constructor
	}
	
	public void setOperation(final String operation)
	{
		this.operation = operation;
	}

	public String getOperation() 
	{
		return operation;
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setSourceCatalogVersion(final String sourceCatalogVersion)
	{
		this.sourceCatalogVersion = sourceCatalogVersion;
	}

	public String getSourceCatalogVersion() 
	{
		return sourceCatalogVersion;
	}
	
	public void setTargetCatalogVersion(final String targetCatalogVersion)
	{
		this.targetCatalogVersion = targetCatalogVersion;
	}

	public String getTargetCatalogVersion() 
	{
		return targetCatalogVersion;
	}
	

}