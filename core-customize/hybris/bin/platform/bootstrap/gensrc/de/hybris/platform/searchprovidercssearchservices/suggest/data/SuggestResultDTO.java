/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.suggest.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.search.data.SuggestHitDTO;
import java.util.List;


import java.util.Objects;
public  class SuggestResultDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SuggestResultDTO.size</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer size;

	/** <i>Generated property</i> for <code>SuggestResultDTO.suggestHits</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<SuggestHitDTO> suggestHits;
	
	public SuggestResultDTO()
	{
		// default constructor
	}
	
	public void setSize(final Integer size)
	{
		this.size = size;
	}

	public Integer getSize() 
	{
		return size;
	}
	
	public void setSuggestHits(final List<SuggestHitDTO> suggestHits)
	{
		this.suggestHits = suggestHits;
	}

	public List<SuggestHitDTO> getSuggestHits() 
	{
		return suggestHits;
	}
	

}