/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.sourcing;

import java.io.Serializable;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.warehousing.data.sourcing.SourcingResults;
import java.util.Collection;


import java.util.Objects;
public  class SourcingContext  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SourcingContext.orderEntries</code> property defined at extension <code>warehousing</code>. */
	
	private Collection<AbstractOrderEntryModel> orderEntries;

	/** <i>Generated property</i> for <code>SourcingContext.sourcingLocations</code> property defined at extension <code>warehousing</code>. */
	
	private Collection<SourcingLocation> sourcingLocations;

	/** <i>Generated property</i> for <code>SourcingContext.result</code> property defined at extension <code>warehousing</code>. */
	
	private SourcingResults result;
	
	public SourcingContext()
	{
		// default constructor
	}
	
	public void setOrderEntries(final Collection<AbstractOrderEntryModel> orderEntries)
	{
		this.orderEntries = orderEntries;
	}

	public Collection<AbstractOrderEntryModel> getOrderEntries() 
	{
		return orderEntries;
	}
	
	public void setSourcingLocations(final Collection<SourcingLocation> sourcingLocations)
	{
		this.sourcingLocations = sourcingLocations;
	}

	public Collection<SourcingLocation> getSourcingLocations() 
	{
		return sourcingLocations;
	}
	
	public void setResult(final SourcingResults result)
	{
		this.result = result;
	}

	public SourcingResults getResult() 
	{
		return result;
	}
	

}