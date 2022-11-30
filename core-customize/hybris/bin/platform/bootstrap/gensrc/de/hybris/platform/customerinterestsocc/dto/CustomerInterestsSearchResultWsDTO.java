/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerinterestsocc.dto;

import java.io.Serializable;
import de.hybris.platform.customerinterestsocc.dto.ProductInterestRelationWsDTO;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import de.hybris.platform.webservicescommons.dto.SortWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Customer interests search page
 */
@ApiModel(value="customerInterestsSearchPage", description="Customer interests search page")
public  class CustomerInterestsSearchResultWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of product interest relation<br/><br/><i>Generated property</i> for <code>CustomerInterestsSearchResultWsDTO.results</code> property defined at extension <code>customerinterestsocc</code>. */
@ApiModelProperty(name="results", value="List of product interest relation") 	
	private List<ProductInterestRelationWsDTO> results;

	/** Sorting information<br/><br/><i>Generated property</i> for <code>CustomerInterestsSearchResultWsDTO.sorts</code> property defined at extension <code>customerinterestsocc</code>. */
@ApiModelProperty(name="sorts", value="Sorting information") 	
	private List<SortWsDTO> sorts;

	/** Pagination information<br/><br/><i>Generated property</i> for <code>CustomerInterestsSearchResultWsDTO.pagination</code> property defined at extension <code>customerinterestsocc</code>. */
@ApiModelProperty(name="pagination", value="Pagination information") 	
	private PaginationWsDTO pagination;
	
	public CustomerInterestsSearchResultWsDTO()
	{
		// default constructor
	}
	
	public void setResults(final List<ProductInterestRelationWsDTO> results)
	{
		this.results = results;
	}

	public List<ProductInterestRelationWsDTO> getResults() 
	{
		return results;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
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