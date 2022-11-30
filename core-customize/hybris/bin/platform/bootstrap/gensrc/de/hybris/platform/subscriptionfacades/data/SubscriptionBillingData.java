/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class SubscriptionBillingData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SubscriptionBillingData.billingId</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String billingId;

	/** <i>Generated property</i> for <code>SubscriptionBillingData.billingPeriod</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String billingPeriod;

	/** <i>Generated property</i> for <code>SubscriptionBillingData.billingDate</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String billingDate;

	/** <i>Generated property</i> for <code>SubscriptionBillingData.paymentAmount</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String paymentAmount;

	/** <i>Generated property</i> for <code>SubscriptionBillingData.paymentStatus</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String paymentStatus;
	
	public SubscriptionBillingData()
	{
		// default constructor
	}
	
	public void setBillingId(final String billingId)
	{
		this.billingId = billingId;
	}

	public String getBillingId() 
	{
		return billingId;
	}
	
	public void setBillingPeriod(final String billingPeriod)
	{
		this.billingPeriod = billingPeriod;
	}

	public String getBillingPeriod() 
	{
		return billingPeriod;
	}
	
	public void setBillingDate(final String billingDate)
	{
		this.billingDate = billingDate;
	}

	public String getBillingDate() 
	{
		return billingDate;
	}
	
	public void setPaymentAmount(final String paymentAmount)
	{
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentAmount() 
	{
		return paymentAmount;
	}
	
	public void setPaymentStatus(final String paymentStatus)
	{
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatus() 
	{
		return paymentStatus;
	}
	

}