/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractFacetResponseDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.NamedSortDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.SearchHitDTO;
import java.util.List;


import java.util.Objects;
public  class SearchResultDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchResultDTO.offset</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer offset;

	/** <i>Generated property</i> for <code>SearchResultDTO.limit</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer limit;

	/** <i>Generated property</i> for <code>SearchResultDTO.size</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer size;

	/** <i>Generated property</i> for <code>SearchResultDTO.totalSize</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer totalSize;

	/** <i>Generated property</i> for <code>SearchResultDTO.searchHits</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<SearchHitDTO> searchHits;

	/** <i>Generated property</i> for <code>SearchResultDTO.facets</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<AbstractFacetResponseDTO> facets;

	/** <i>Generated property</i> for <code>SearchResultDTO.sort</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private NamedSortDTO sort;

	/** <i>Generated property</i> for <code>SearchResultDTO.availableSorts</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<NamedSortDTO> availableSorts;
	
	public SearchResultDTO()
	{
		// default constructor
	}
	
	public void setOffset(final Integer offset)
	{
		this.offset = offset;
	}

	public Integer getOffset() 
	{
		return offset;
	}
	
	public void setLimit(final Integer limit)
	{
		this.limit = limit;
	}

	public Integer getLimit() 
	{
		return limit;
	}
	
	public void setSize(final Integer size)
	{
		this.size = size;
	}

	public Integer getSize() 
	{
		return size;
	}
	
	public void setTotalSize(final Integer totalSize)
	{
		this.totalSize = totalSize;
	}

	public Integer getTotalSize() 
	{
		return totalSize;
	}
	
	public void setSearchHits(final List<SearchHitDTO> searchHits)
	{
		this.searchHits = searchHits;
	}

	public List<SearchHitDTO> getSearchHits() 
	{
		return searchHits;
	}
	
	public void setFacets(final List<AbstractFacetResponseDTO> facets)
	{
		this.facets = facets;
	}

	public List<AbstractFacetResponseDTO> getFacets() 
	{
		return facets;
	}
	
	public void setSort(final NamedSortDTO sort)
	{
		this.sort = sort;
	}

	public NamedSortDTO getSort() 
	{
		return sort;
	}
	
	public void setAvailableSorts(final List<NamedSortDTO> availableSorts)
	{
		this.availableSorts = availableSorts;
	}

	public List<NamedSortDTO> getAvailableSorts() 
	{
		return availableSorts;
	}
	

}