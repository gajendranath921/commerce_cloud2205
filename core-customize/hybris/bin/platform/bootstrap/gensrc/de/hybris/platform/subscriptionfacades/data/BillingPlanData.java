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


import java.util.Objects;
public  class BillingPlanData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BillingPlanData.id</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>BillingPlanData.name</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>BillingPlanData.billingCycleDay</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private Integer billingCycleDay;

	/** <i>Generated property</i> for <code>BillingPlanData.billingTime</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private BillingTimeData billingTime;

	/** <i>Generated property</i> for <code>BillingPlanData.billingCycleType</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private BillingCycleTypeData billingCycleType;
	
	public BillingPlanData()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setBillingCycleDay(final Integer billingCycleDay)
	{
		this.billingCycleDay = billingCycleDay;
	}

	public Integer getBillingCycleDay() 
	{
		return billingCycleDay;
	}
	
	public void setBillingTime(final BillingTimeData billingTime)
	{
		this.billingTime = billingTime;
	}

	public BillingTimeData getBillingTime() 
	{
		return billingTime;
	}
	
	public void setBillingCycleType(final BillingCycleTypeData billingCycleType)
	{
		this.billingCycleType = billingCycleType;
	}

	public BillingCycleTypeData getBillingCycleType() 
	{
		return billingCycleType;
	}
	

}