/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;


import java.util.Objects;
public  class TierUsageChargeEntryData extends UsageChargeEntryData 

{



	/** <i>Generated property</i> for <code>TierUsageChargeEntryData.tierStart</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private int tierStart;

	/** <i>Generated property</i> for <code>TierUsageChargeEntryData.tierEnd</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private int tierEnd;
	
	public TierUsageChargeEntryData()
	{
		// default constructor
	}
	
	public void setTierStart(final int tierStart)
	{
		this.tierStart = tierStart;
	}

	public int getTierStart() 
	{
		return tierStart;
	}
	
	public void setTierEnd(final int tierEnd)
	{
		this.tierEnd = tierEnd;
	}

	public int getTierEnd() 
	{
		return tierEnd;
	}
	

}