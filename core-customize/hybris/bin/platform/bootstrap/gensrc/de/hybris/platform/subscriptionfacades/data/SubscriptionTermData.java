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
public  class SubscriptionTermData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SubscriptionTermData.id</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>SubscriptionTermData.name</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>SubscriptionTermData.termOfServiceNumber</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private int termOfServiceNumber;

	/** <i>Generated property</i> for <code>SubscriptionTermData.cancellable</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private boolean cancellable;

	/** <i>Generated property</i> for <code>SubscriptionTermData.termOfServiceFrequency</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private TermOfServiceFrequencyData termOfServiceFrequency;

	/** <i>Generated property</i> for <code>SubscriptionTermData.termOfServiceRenewal</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private TermOfServiceRenewalData termOfServiceRenewal;

	/** <i>Generated property</i> for <code>SubscriptionTermData.billingPlan</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private BillingPlanData billingPlan;
	
	public SubscriptionTermData()
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
	
	public void setTermOfServiceNumber(final int termOfServiceNumber)
	{
		this.termOfServiceNumber = termOfServiceNumber;
	}

	public int getTermOfServiceNumber() 
	{
		return termOfServiceNumber;
	}
	
	public void setCancellable(final boolean cancellable)
	{
		this.cancellable = cancellable;
	}

	public boolean isCancellable() 
	{
		return cancellable;
	}
	
	public void setTermOfServiceFrequency(final TermOfServiceFrequencyData termOfServiceFrequency)
	{
		this.termOfServiceFrequency = termOfServiceFrequency;
	}

	public TermOfServiceFrequencyData getTermOfServiceFrequency() 
	{
		return termOfServiceFrequency;
	}
	
	public void setTermOfServiceRenewal(final TermOfServiceRenewalData termOfServiceRenewal)
	{
		this.termOfServiceRenewal = termOfServiceRenewal;
	}

	public TermOfServiceRenewalData getTermOfServiceRenewal() 
	{
		return termOfServiceRenewal;
	}
	
	public void setBillingPlan(final BillingPlanData billingPlan)
	{
		this.billingPlan = billingPlan;
	}

	public BillingPlanData getBillingPlan() 
	{
		return billingPlan;
	}
	

}