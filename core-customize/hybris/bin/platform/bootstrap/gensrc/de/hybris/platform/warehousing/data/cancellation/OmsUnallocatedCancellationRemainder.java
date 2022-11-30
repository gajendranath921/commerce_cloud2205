/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.data.cancellation;

import java.io.Serializable;
import de.hybris.platform.ordercancel.model.OrderEntryCancelRecordEntryModel;


import java.util.Objects;
public  class OmsUnallocatedCancellationRemainder  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OmsUnallocatedCancellationRemainder.orderEntryCancellationRecord</code> property defined at extension <code>warehousing</code>. */
	
	private OrderEntryCancelRecordEntryModel orderEntryCancellationRecord;

	/** <i>Generated property</i> for <code>OmsUnallocatedCancellationRemainder.remainingQuantity</code> property defined at extension <code>warehousing</code>. */
	
	private Integer remainingQuantity;
	
	public OmsUnallocatedCancellationRemainder()
	{
		// default constructor
	}
	
	public void setOrderEntryCancellationRecord(final OrderEntryCancelRecordEntryModel orderEntryCancellationRecord)
	{
		this.orderEntryCancellationRecord = orderEntryCancellationRecord;
	}

	public OrderEntryCancelRecordEntryModel getOrderEntryCancellationRecord() 
	{
		return orderEntryCancellationRecord;
	}
	
	public void setRemainingQuantity(final Integer remainingQuantity)
	{
		this.remainingQuantity = remainingQuantity;
	}

	public Integer getRemainingQuantity() 
	{
		return remainingQuantity;
	}
	

}