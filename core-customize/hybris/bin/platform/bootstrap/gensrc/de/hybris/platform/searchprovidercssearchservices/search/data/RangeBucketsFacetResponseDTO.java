/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import de.hybris.platform.searchprovidercssearchservices.search.data.AbstractBucketsFacetResponseDTO;
import de.hybris.platform.searchprovidercssearchservices.search.data.RangeBucketResponseDTO;
import java.util.List;


import java.util.Objects;
public  class RangeBucketsFacetResponseDTO extends AbstractBucketsFacetResponseDTO 

{



	/** <i>Generated property</i> for <code>RangeBucketsFacetResponseDTO.buckets</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<RangeBucketResponseDTO> buckets;

	/** <i>Generated property</i> for <code>RangeBucketsFacetResponseDTO.selectedBuckets</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<RangeBucketResponseDTO> selectedBuckets;
	
	public RangeBucketsFacetResponseDTO()
	{
		// default constructor
	}
	
	public void setBuckets(final List<RangeBucketResponseDTO> buckets)
	{
		this.buckets = buckets;
	}

	public List<RangeBucketResponseDTO> getBuckets() 
	{
		return buckets;
	}
	
	public void setSelectedBuckets(final List<RangeBucketResponseDTO> selectedBuckets)
	{
		this.selectedBuckets = selectedBuckets;
	}

	public List<RangeBucketResponseDTO> getSelectedBuckets() 
	{
		return selectedBuckets;
	}
	

}