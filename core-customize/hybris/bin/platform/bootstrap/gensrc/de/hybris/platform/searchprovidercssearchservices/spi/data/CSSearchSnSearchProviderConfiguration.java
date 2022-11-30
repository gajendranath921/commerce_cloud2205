/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.spi.data;

import de.hybris.platform.searchservices.spi.data.AbstractSnSearchProviderConfiguration;


import java.util.Objects;
public  class CSSearchSnSearchProviderConfiguration extends AbstractSnSearchProviderConfiguration 

{



	/** <i>Generated property</i> for <code>CSSearchSnSearchProviderConfiguration.destinationId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String destinationId;

	/** <i>Generated property</i> for <code>CSSearchSnSearchProviderConfiguration.destinationTargetId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String destinationTargetId;
	
	public CSSearchSnSearchProviderConfiguration()
	{
		// default constructor
	}
	
	public void setDestinationId(final String destinationId)
	{
		this.destinationId = destinationId;
	}

	public String getDestinationId() 
	{
		return destinationId;
	}
	
	public void setDestinationTargetId(final String destinationTargetId)
	{
		this.destinationTargetId = destinationTargetId;
	}

	public String getDestinationTargetId() 
	{
		return destinationTargetId;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final CSSearchSnSearchProviderConfiguration other = (CSSearchSnSearchProviderConfiguration) o;
		return Objects.equals(getDestinationId(), other.getDestinationId())

			&& Objects.equals(getDestinationTargetId(), other.getDestinationTargetId());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = destinationId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = destinationTargetId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}