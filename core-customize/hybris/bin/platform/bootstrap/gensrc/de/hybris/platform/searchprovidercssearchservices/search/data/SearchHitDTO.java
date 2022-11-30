/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.search.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.search.data.SearchHitDTO;
import java.util.List;
import java.util.Map;
import java.util.Set;


import java.util.Objects;
public  class SearchHitDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchHitDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>SearchHitDTO.score</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Float score;

	/** <i>Generated property</i> for <code>SearchHitDTO.fields</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Map<String,Object> fields;

	/** <i>Generated property</i> for <code>SearchHitDTO.tags</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Set<String> tags;

	/** <i>Generated property</i> for <code>SearchHitDTO.innerHits</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<SearchHitDTO> innerHits;
	
	public SearchHitDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setScore(final Float score)
	{
		this.score = score;
	}

	public Float getScore() 
	{
		return score;
	}
	
	public void setFields(final Map<String,Object> fields)
	{
		this.fields = fields;
	}

	public Map<String,Object> getFields() 
	{
		return fields;
	}
	
	public void setTags(final Set<String> tags)
	{
		this.tags = tags;
	}

	public Set<String> getTags() 
	{
		return tags;
	}
	
	public void setInnerHits(final List<SearchHitDTO> innerHits)
	{
		this.innerHits = innerHits;
	}

	public List<SearchHitDTO> getInnerHits() 
	{
		return innerHits;
	}
	

}