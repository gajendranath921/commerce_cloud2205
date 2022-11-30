/*
* ----------------------------------------------------------------
* --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
* --- Generated at 30-Nov-2022, 4:57:11 pm
* ----------------------------------------------------------------
*
* Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
*/
package de.hybris.platform.ruleengineservices.rao;

import java.io.Serializable;
import java.util.Objects;
import de.hybris.platform.ruleengineservices.enums.FixedDiscountDistributeStrategy;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;
import java.math.BigDecimal;
import java.util.List;

public  class EntriesDiscountDistributeStrategyRPD  implements Serializable 

{

/** <i>Generated property</i> for <code>EntriesDiscountDistributeStrategyRPD.orderEntries</code> property defined at extension <code>ruleengineservices</code>. */
	private List<OrderEntryRAO> orderEntries;
/** <i>Generated property</i> for <code>EntriesDiscountDistributeStrategyRPD.totalDiscount</code> property defined at extension <code>ruleengineservices</code>. */
	private BigDecimal totalDiscount;
/** <i>Generated property</i> for <code>EntriesDiscountDistributeStrategyRPD.currencyIsoCode</code> property defined at extension <code>ruleengineservices</code>. */
	private String currencyIsoCode;
/** <i>Generated property</i> for <code>EntriesDiscountDistributeStrategyRPD.fixDiscount</code> property defined at extension <code>ruleengineservices</code>. */
	private boolean fixDiscount;
/** <i>Generated property</i> for <code>EntriesDiscountDistributeStrategyRPD.fixedDiscountDistributeStrategy</code> property defined at extension <code>ruleengineservices</code>. */
	private FixedDiscountDistributeStrategy fixedDiscountDistributeStrategy;
	
	public EntriesDiscountDistributeStrategyRPD()
	{
		// default constructor
	}
	
	public void setOrderEntries(final List<OrderEntryRAO> orderEntries)
	{
		this.orderEntries = orderEntries;
	}
	public List<OrderEntryRAO> getOrderEntries() 
	{
		return orderEntries;
	}
	
	public void setTotalDiscount(final BigDecimal totalDiscount)
	{
		this.totalDiscount = totalDiscount;
	}
	public BigDecimal getTotalDiscount() 
	{
		return totalDiscount;
	}
	
	public void setCurrencyIsoCode(final String currencyIsoCode)
	{
		this.currencyIsoCode = currencyIsoCode;
	}
	public String getCurrencyIsoCode() 
	{
		return currencyIsoCode;
	}
	
	public void setFixDiscount(final boolean fixDiscount)
	{
		this.fixDiscount = fixDiscount;
	}
	public boolean isFixDiscount() 
	{
		return fixDiscount;
	}
	
	public void setFixedDiscountDistributeStrategy(final FixedDiscountDistributeStrategy fixedDiscountDistributeStrategy)
	{
		this.fixedDiscountDistributeStrategy = fixedDiscountDistributeStrategy;
	}
	public FixedDiscountDistributeStrategy getFixedDiscountDistributeStrategy() 
	{
		return fixedDiscountDistributeStrategy;
	}
	

	@Override
	public boolean equals(final Object o)
	{

		if (o == null) return false;
		if (o == this) return true;

		if (getClass() != o.getClass()) return false;

		final EntriesDiscountDistributeStrategyRPD other = (EntriesDiscountDistributeStrategyRPD) o;
		return				Objects.equals(getOrderEntries(), other.getOrderEntries())
 &&  			Objects.equals(getTotalDiscount(), other.getTotalDiscount())
 &&  			Objects.equals(getCurrencyIsoCode(), other.getCurrencyIsoCode())
 &&  			Objects.equals(isFixDiscount(), other.isFixDiscount())
 &&  			Objects.equals(getFixedDiscountDistributeStrategy(), other.getFixedDiscountDistributeStrategy())
  ;
	}

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = orderEntries;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = totalDiscount;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = currencyIsoCode;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = fixDiscount;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = fixedDiscountDistributeStrategy;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}
