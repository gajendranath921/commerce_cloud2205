/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import de.hybris.platform.commercefacades.product.data.PriceData;
import java.util.List;


import java.util.Objects;
public  class SubscriptionPricePlanData extends PriceData 

{



	/** <i>Generated property</i> for <code>SubscriptionPricePlanData.name</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>SubscriptionPricePlanData.usageCharges</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private List<UsageChargeData> usageCharges;

	/** <i>Generated property</i> for <code>SubscriptionPricePlanData.oneTimeChargeEntries</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private List<OneTimeChargeEntryData> oneTimeChargeEntries;

	/** <i>Generated property</i> for <code>SubscriptionPricePlanData.recurringChargeEntries</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private List<RecurringChargeEntryData> recurringChargeEntries;
	
	public SubscriptionPricePlanData()
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
	
	public void setUsageCharges(final List<UsageChargeData> usageCharges)
	{
		this.usageCharges = usageCharges;
	}

	public List<UsageChargeData> getUsageCharges() 
	{
		return usageCharges;
	}
	
	public void setOneTimeChargeEntries(final List<OneTimeChargeEntryData> oneTimeChargeEntries)
	{
		this.oneTimeChargeEntries = oneTimeChargeEntries;
	}

	public List<OneTimeChargeEntryData> getOneTimeChargeEntries() 
	{
		return oneTimeChargeEntries;
	}
	
	public void setRecurringChargeEntries(final List<RecurringChargeEntryData> recurringChargeEntries)
	{
		this.recurringChargeEntries = recurringChargeEntries;
	}

	public List<RecurringChargeEntryData> getRecurringChargeEntries() 
	{
		return recurringChargeEntries;
	}
	

}