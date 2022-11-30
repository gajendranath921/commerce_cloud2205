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
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
@ApiModel(value="ProductSearchResultWsDTO")
public  class ProductSearchResultWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductSearchResultWsDTO.products</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="products") 	
	private List<ProductWsDTO> products;

	/** <i>Generated property</i> for <code>ProductSearchResultWsDTO.pagination</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="pagination") 	
	private PaginationWsDTO pagination;
	
	public ProductSearchResultWsDTO()
	{
		// default constructor
	}
	
	public void setProducts(final List<ProductWsDTO> products)
	{
		this.products = products;
	}

	public List<ProductWsDTO> getProducts() 
	{
		return products;
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