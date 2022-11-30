/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.subscriptionfacades.data.BillingTimeData;


import java.util.Objects;
public  class BillingTimePriceData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BillingTimePriceData.totalPrice</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private PriceData totalPrice;

	/** <i>Generated property</i> for <code>BillingTimePriceData.billingTime</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private BillingTimeData billingTime;
	
	public BillingTimePriceData()
	{
		// default constructor
	}
	
	public void setTotalPrice(final PriceData totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public PriceData getTotalPrice() 
	{
		return totalPrice;
	}
	
	public void setBillingTime(final BillingTimeData billingTime)
	{
		this.billingTime = billingTime;
	}

	public BillingTimeData getBillingTime() 
	{
		return billingTime;
	}
	

}