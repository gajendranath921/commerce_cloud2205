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
import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractFacetFilterDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractFacetRequestDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractRankRuleDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.FilterDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.GroupRequestDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.SortDTO;
import java.util.List;


import java.util.Objects;
public  class SearchQueryDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchQueryDTO.query</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String query;

	/** <i>Generated property</i> for <code>SearchQueryDTO.offset</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer offset;

	/** <i>Generated property</i> for <code>SearchQueryDTO.limit</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer limit;

	/** <i>Generated property</i> for <code>SearchQueryDTO.filters</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<FilterDTO> filters;

	/** <i>Generated property</i> for <code>SearchQueryDTO.facets</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<AbstractFacetRequestDTO> facets;

	/** <i>Generated property</i> for <code>SearchQueryDTO.facetFilters</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<AbstractFacetFilterDTO> facetFilters;

	/** <i>Generated property</i> for <code>SearchQueryDTO.rankRules</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<AbstractRankRuleDTO> rankRules;

	/** <i>Generated property</i> for <code>SearchQueryDTO.sort</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private SortDTO sort;

	/** <i>Generated property</i> for <code>SearchQueryDTO.availableSorts</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<SortDTO> availableSorts;

	/** <i>Generated property</i> for <code>SearchQueryDTO.group</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private GroupRequestDTO group;
	
	public SearchQueryDTO()
	{
		// default constructor
	}
	
	public void setQuery(final String query)
	{
		this.query = query;
	}

	public String getQuery() 
	{
		return query;
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
	
	public void setFilters(final List<FilterDTO> filters)
	{
		this.filters = filters;
	}

	public List<FilterDTO> getFilters() 
	{
		return filters;
	}
	
	public void setFacets(final List<AbstractFacetRequestDTO> facets)
	{
		this.facets = facets;
	}

	public List<AbstractFacetRequestDTO> getFacets() 
	{
		return facets;
	}
	
	public void setFacetFilters(final List<AbstractFacetFilterDTO> facetFilters)
	{
		this.facetFilters = facetFilters;
	}

	public List<AbstractFacetFilterDTO> getFacetFilters() 
	{
		return facetFilters;
	}
	
	public void setRankRules(final List<AbstractRankRuleDTO> rankRules)
	{
		this.rankRules = rankRules;
	}

	public List<AbstractRankRuleDTO> getRankRules() 
	{
		return rankRules;
	}
	
	public void setSort(final SortDTO sort)
	{
		this.sort = sort;
	}

	public SortDTO getSort() 
	{
		return sort;
	}
	
	public void setAvailableSorts(final List<SortDTO> availableSorts)
	{
		this.availableSorts = availableSorts;
	}

	public List<SortDTO> getAvailableSorts() 
	{
		return availableSorts;
	}
	
	public void setGroup(final GroupRequestDTO group)
	{
		this.group = group;
	}

	public GroupRequestDTO getGroup() 
	{
		return group;
	}
	

}