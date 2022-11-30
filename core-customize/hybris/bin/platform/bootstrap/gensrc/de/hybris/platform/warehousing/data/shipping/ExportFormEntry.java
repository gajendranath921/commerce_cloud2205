/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.shipping;

import java.io.Serializable;
import de.hybris.platform.ordersplitting.model.ConsignmentEntryModel;
import java.math.BigDecimal;


import java.util.Objects;
public  class ExportFormEntry  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ExportFormEntry.consignmentEntry</code> property defined at extension <code>warehousing</code>. */
	
	private ConsignmentEntryModel consignmentEntry;

	/** <i>Generated property</i> for <code>ExportFormEntry.itemPrice</code> property defined at extension <code>warehousing</code>. */
	
	private BigDecimal itemPrice;

	/** <i>Generated property</i> for <code>ExportFormEntry.totalPrice</code> property defined at extension <code>warehousing</code>. */
	
	private BigDecimal totalPrice;
	
	public ExportFormEntry()
	{
		// default constructor
	}
	
	public void setConsignmentEntry(final ConsignmentEntryModel consignmentEntry)
	{
		this.consignmentEntry = consignmentEntry;
	}

	public ConsignmentEntryModel getConsignmentEntry() 
	{
		return consignmentEntry;
	}
	
	public void setItemPrice(final BigDecimal itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public BigDecimal getItemPrice() 
	{
		return itemPrice;
	}
	
	public void setTotalPrice(final BigDecimal totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalPrice() 
	{
		return totalPrice;
	}
	

}