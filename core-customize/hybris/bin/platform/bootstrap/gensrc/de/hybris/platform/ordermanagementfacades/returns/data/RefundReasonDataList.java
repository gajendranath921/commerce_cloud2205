/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementfacades.returns.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.RefundReason;
import java.util.List;


import java.util.Objects;
public  class RefundReasonDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RefundReasonDataList.refundReasons</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private List<RefundReason> refundReasons;
	
	public RefundReasonDataList()
	{
		// default constructor
	}
	
	public void setRefundReasons(final List<RefundReason> refundReasons)
	{
		this.refundReasons = refundReasons;
	}

	public List<RefundReason> getRefundReasons() 
	{
		return refundReasons;
	}
	

}