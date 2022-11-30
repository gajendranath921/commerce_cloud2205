/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractBucketsFacetRequestDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.BucketsSortDTO;
import java.util.List;


import java.util.Objects;
public  class TermBucketsFacetRequestDTO extends AbstractBucketsFacetRequestDTO 

{



	/** <i>Generated property</i> for <code>TermBucketsFacetRequestDTO.topBucketsSize</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer topBucketsSize;

	/** <i>Generated property</i> for <code>TermBucketsFacetRequestDTO.promotedBucketIds</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<String> promotedBucketIds;

	/** <i>Generated property</i> for <code>TermBucketsFacetRequestDTO.excludedBucketIds</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<String> excludedBucketIds;

	/** <i>Generated property</i> for <code>TermBucketsFacetRequestDTO.sort</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private BucketsSortDTO sort;
	
	public TermBucketsFacetRequestDTO()
	{
		// default constructor
	}
	
	public void setTopBucketsSize(final Integer topBucketsSize)
	{
		this.topBucketsSize = topBucketsSize;
	}

	public Integer getTopBucketsSize() 
	{
		return topBucketsSize;
	}
	
	public void setPromotedBucketIds(final List<String> promotedBucketIds)
	{
		this.promotedBucketIds = promotedBucketIds;
	}

	public List<String> getPromotedBucketIds() 
	{
		return promotedBucketIds;
	}
	
	public void setExcludedBucketIds(final List<String> excludedBucketIds)
	{
		this.excludedBucketIds = excludedBucketIds;
	}

	public List<String> getExcludedBucketIds() 
	{
		return excludedBucketIds;
	}
	
	public void setSort(final BucketsSortDTO sort)
	{
		this.sort = sort;
	}

	public BucketsSortDTO getSort() 
	{
		return sort;
	}
	

}