/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.shipping;

import java.io.Serializable;
import de.hybris.platform.ordersplitting.model.ConsignmentEntryModel;


import java.util.Objects;
public  class ShippedEntry  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ShippedEntry.consignmentEntry</code> property defined at extension <code>warehousing</code>. */
	
	private ConsignmentEntryModel consignmentEntry;

	/** <i>Generated property</i> for <code>ShippedEntry.quantity</code> property defined at extension <code>warehousing</code>. */
	
	private Long quantity;
	
	public ShippedEntry()
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
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	

}