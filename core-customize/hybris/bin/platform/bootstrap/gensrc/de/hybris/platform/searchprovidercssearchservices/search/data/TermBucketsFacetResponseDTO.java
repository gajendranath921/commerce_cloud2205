/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractBucketsFacetResponseDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.TermBucketResponseDTO;
import java.util.List;


import java.util.Objects;
public  class TermBucketsFacetResponseDTO extends AbstractBucketsFacetResponseDTO 

{



	/** <i>Generated property</i> for <code>TermBucketsFacetResponseDTO.buckets</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<TermBucketResponseDTO> buckets;

	/** <i>Generated property</i> for <code>TermBucketsFacetResponseDTO.topBuckets</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<TermBucketResponseDTO> topBuckets;

	/** <i>Generated property</i> for <code>TermBucketsFacetResponseDTO.selectedBuckets</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<TermBucketResponseDTO> selectedBuckets;
	
	public TermBucketsFacetResponseDTO()
	{
		// default constructor
	}
	
	public void setBuckets(final List<TermBucketResponseDTO> buckets)
	{
		this.buckets = buckets;
	}

	public List<TermBucketResponseDTO> getBuckets() 
	{
		return buckets;
	}
	
	public void setTopBuckets(final List<TermBucketResponseDTO> topBuckets)
	{
		this.topBuckets = topBuckets;
	}

	public List<TermBucketResponseDTO> getTopBuckets() 
	{
		return topBuckets;
	}
	
	public void setSelectedBuckets(final List<TermBucketResponseDTO> selectedBuckets)
	{
		this.selectedBuckets = selectedBuckets;
	}

	public List<TermBucketResponseDTO> getSelectedBuckets() 
	{
		return selectedBuckets;
	}
	

}