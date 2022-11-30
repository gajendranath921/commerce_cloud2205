/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
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
 * Specifies properties of the named query.
 */
@ApiModel(value="NamedQueryData<T>", description="Specifies properties of the named query.")
public  class NamedQueryData<T>  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NamedQueryData<T>.namedQuery</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="namedQuery", example="Adapter") 	
	private String namedQuery;

	/** <i>Generated property</i> for <code>NamedQueryData<T>.params</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="params") 	
	private String params;

	/** <i>Generated property</i> for <code>NamedQueryData<T>.sort</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="sort", example="Name") 	
	private String sort;

	/** <i>Generated property</i> for <code>NamedQueryData<T>.pageSize</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="pageSize", example="2") 	
	private String pageSize;

	/** <i>Generated property</i> for <code>NamedQueryData<T>.currentPage</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="currentPage", example="1") 	
	private String currentPage;

	/** <i>Generated property</i> for <code>NamedQueryData<T>.queryType</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="queryType") 	
	private Class<T> queryType;
	
	public NamedQueryData()
	{
		// default constructor
	}
	
	public void setNamedQuery(final String namedQuery)
	{
		this.namedQuery = namedQuery;
	}

	public String getNamedQuery() 
	{
		return namedQuery;
	}
	
	public void setParams(final String params)
	{
		this.params = params;
	}

	public String getParams() 
	{
		return params;
	}
	
	public void setSort(final String sort)
	{
		this.sort = sort;
	}

	public String getSort() 
	{
		return sort;
	}
	
	public void setPageSize(final String pageSize)
	{
		this.pageSize = pageSize;
	}

	public String getPageSize() 
	{
		return pageSize;
	}
	
	public void setCurrentPage(final String currentPage)
	{
		this.currentPage = currentPage;
	}

	public String getCurrentPage() 
	{
		return currentPage;
	}
	
	public void setQueryType(final Class<T> queryType)
	{
		this.queryType = queryType;
	}

	public Class<T> getQueryType() 
	{
		return queryType;
	}
	

}