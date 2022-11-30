/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.returns;

import java.io.Serializable;


import java.util.Objects;
public  class CancelReturnRequestWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CancelReturnRequestWsDTO.code</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>CancelReturnRequestWsDTO.cancelReason</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String cancelReason;

	/** <i>Generated property</i> for <code>CancelReturnRequestWsDTO.notes</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String notes;
	
	public CancelReturnRequestWsDTO()
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
	
	public void setCancelReason(final String cancelReason)
	{
		this.cancelReason = cancelReason;
	}

	public String getCancelReason() 
	{
		return cancelReason;
	}
	
	public void setNotes(final String notes)
	{
		this.notes = notes;
	}

	public String getNotes() 
	{
		return notes;
	}
	

}