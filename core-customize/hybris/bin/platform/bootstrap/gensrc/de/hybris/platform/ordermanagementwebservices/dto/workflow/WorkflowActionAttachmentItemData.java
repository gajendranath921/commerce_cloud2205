/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.workflow;

import java.io.Serializable;


import java.util.Objects;
public  class WorkflowActionAttachmentItemData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WorkflowActionAttachmentItemData.code</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>WorkflowActionAttachmentItemData.orderCode</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String orderCode;
	
	public WorkflowActionAttachmentItemData()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setOrderCode(final String orderCode)
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	

}