/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PromotionResultData;
import de.hybris.platform.subscriptionfacades.data.BillingTimePriceData;
import java.util.List;


import java.util.Objects;
public  class OrderPriceData extends BillingTimePriceData 

{



	/** <i>Generated property</i> for <code>OrderPriceData.totalTax</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private PriceData totalTax;

	/** <i>Generated property</i> for <code>OrderPriceData.subTotal</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private PriceData subTotal;

	/** <i>Generated property</i> for <code>OrderPriceData.deliveryCost</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private PriceData deliveryCost;

	/** <i>Generated property</i> for <code>OrderPriceData.totalDiscounts</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private PriceData totalDiscounts;

	/** <i>Generated property</i> for <code>OrderPriceData.appliedProductPromotions</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private List<PromotionResultData> appliedProductPromotions;

	/** <i>Generated property</i> for <code>OrderPriceData.appliedOrderPromotions</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private List<PromotionResultData> appliedOrderPromotions;

	/** <i>Generated property</i> for <code>OrderPriceData.potentialProductPromotions</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private List<PromotionResultData> potentialProductPromotions;

	/** <i>Generated property</i> for <code>OrderPriceData.potentialOrderPromotions</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private List<PromotionResultData> potentialOrderPromotions;
	
	public OrderPriceData()
	{
		// default constructor
	}
	
	public void setTotalTax(final PriceData totalTax)
	{
		this.totalTax = totalTax;
	}

	public PriceData getTotalTax() 
	{
		return totalTax;
	}
	
	public void setSubTotal(final PriceData subTotal)
	{
		this.subTotal = subTotal;
	}

	public PriceData getSubTotal() 
	{
		return subTotal;
	}
	
	public void setDeliveryCost(final PriceData deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

	public PriceData getDeliveryCost() 
	{
		return deliveryCost;
	}
	
	public void setTotalDiscounts(final PriceData totalDiscounts)
	{
		this.totalDiscounts = totalDiscounts;
	}

	public PriceData getTotalDiscounts() 
	{
		return totalDiscounts;
	}
	
	public void setAppliedProductPromotions(final List<PromotionResultData> appliedProductPromotions)
	{
		this.appliedProductPromotions = appliedProductPromotions;
	}

	public List<PromotionResultData> getAppliedProductPromotions() 
	{
		return appliedProductPromotions;
	}
	
	public void setAppliedOrderPromotions(final List<PromotionResultData> appliedOrderPromotions)
	{
		this.appliedOrderPromotions = appliedOrderPromotions;
	}

	public List<PromotionResultData> getAppliedOrderPromotions() 
	{
		return appliedOrderPromotions;
	}
	
	public void setPotentialProductPromotions(final List<PromotionResultData> potentialProductPromotions)
	{
		this.potentialProductPromotions = potentialProductPromotions;
	}

	public List<PromotionResultData> getPotentialProductPromotions() 
	{
		return potentialProductPromotions;
	}
	
	public void setPotentialOrderPromotions(final List<PromotionResultData> potentialOrderPromotions)
	{
		this.potentialOrderPromotions = potentialOrderPromotions;
	}

	public List<PromotionResultData> getPotentialOrderPromotions() 
	{
		return potentialOrderPromotions;
	}
	

}