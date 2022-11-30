/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.allocation;

import java.io.Serializable;
import java.util.Collection;


import java.util.Objects;
public  class DeclineEntries  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DeclineEntries.entries</code> property defined at extension <code>warehousing</code>. */
	
	private Collection<DeclineEntry> entries;
	
	public DeclineEntries()
	{
		// default constructor
	}
	
	public void setEntries(final Collection<DeclineEntry> entries)
	{
		this.entries = entries;
	}

	public Collection<DeclineEntry> getEntries() 
	{
		return entries;
	}
	

}