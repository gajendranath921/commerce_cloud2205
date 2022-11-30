/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.sourcing;

import java.io.Serializable;
import de.hybris.platform.warehousing.data.sourcing.SourcingResult;
import java.util.Set;


import java.util.Objects;
public  class SourcingResults  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SourcingResults.results</code> property defined at extension <code>warehousing</code>. */
	
	private Set<SourcingResult> results;

	/** <i>Generated property</i> for <code>SourcingResults.complete</code> property defined at extension <code>warehousing</code>. */
	
	private boolean complete;
	
	public SourcingResults()
	{
		// default constructor
	}
	
	public void setResults(final Set<SourcingResult> results)
	{
		this.results = results;
	}

	public Set<SourcingResult> getResults() 
	{
		return results;
	}
	
	public void setComplete(final boolean complete)
	{
		this.complete = complete;
	}

	public boolean isComplete() 
	{
		return complete;
	}
	

}