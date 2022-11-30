/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import java.util.Objects;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
			@JsonSubTypes({
				@JsonSubTypes.Type(value = de.hybris.platform.searchprovidercssearchservices.search.data.BucketsFacetFilterDTO.class, name = "buckets")
			})
public abstract  class AbstractFacetFilterDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractFacetFilterDTO.facetId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String facetId;
	
	public AbstractFacetFilterDTO()
	{
		// default constructor
	}
	
	public void setFacetId(final String facetId)
	{
		this.facetId = facetId;
	}

	public String getFacetId() 
	{
		return facetId;
	}
	

}