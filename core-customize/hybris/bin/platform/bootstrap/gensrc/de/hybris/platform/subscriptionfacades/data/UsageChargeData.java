/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import java.io.Serializable;
import de.hybris.platform.subscriptionfacades.data.UsageUnitData;
import java.util.List;


import java.util.Objects;
public  class UsageChargeData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UsageChargeData.name</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>UsageChargeData.usageUnit</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private UsageUnitData usageUnit;

	/** <i>Generated property</i> for <code>UsageChargeData.usageChargeEntries</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private List<UsageChargeEntryData> usageChargeEntries;
	
	public UsageChargeData()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setUsageUnit(final UsageUnitData usageUnit)
	{
		this.usageUnit = usageUnit;
	}

	public UsageUnitData getUsageUnit() 
	{
		return usageUnit;
	}
	
	public void setUsageChargeEntries(final List<UsageChargeEntryData> usageChargeEntries)
	{
		this.usageChargeEntries = usageChargeEntries;
	}

	public List<UsageChargeEntryData> getUsageChargeEntries() 
	{
		return usageChargeEntries;
	}
	

}