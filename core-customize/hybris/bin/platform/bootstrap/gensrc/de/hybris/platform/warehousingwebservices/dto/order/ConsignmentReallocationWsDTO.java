/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.order;

import java.io.Serializable;
import de.hybris.platform.warehousingwebservices.dto.order.DeclineEntryWsDTO;
import java.util.List;


import java.util.Objects;
public  class ConsignmentReallocationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsignmentReallocationWsDTO.declineEntries</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<DeclineEntryWsDTO> declineEntries;

	/** <i>Generated property</i> for <code>ConsignmentReallocationWsDTO.globalReallocationWarehouseCode</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String globalReallocationWarehouseCode;

	/** <i>Generated property</i> for <code>ConsignmentReallocationWsDTO.globalReason</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String globalReason;

	/** <i>Generated property</i> for <code>ConsignmentReallocationWsDTO.globalComment</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String globalComment;
	
	public ConsignmentReallocationWsDTO()
	{
		// default constructor
	}
	
	public void setDeclineEntries(final List<DeclineEntryWsDTO> declineEntries)
	{
		this.declineEntries = declineEntries;
	}

	public List<DeclineEntryWsDTO> getDeclineEntries() 
	{
		return declineEntries;
	}
	
	public void setGlobalReallocationWarehouseCode(final String globalReallocationWarehouseCode)
	{
		this.globalReallocationWarehouseCode = globalReallocationWarehouseCode;
	}

	public String getGlobalReallocationWarehouseCode() 
	{
		return globalReallocationWarehouseCode;
	}
	
	public void setGlobalReason(final String globalReason)
	{
		this.globalReason = globalReason;
	}

	public String getGlobalReason() 
	{
		return globalReason;
	}
	
	public void setGlobalComment(final String globalComment)
	{
		this.globalComment = globalComment;
	}

	public String getGlobalComment() 
	{
		return globalComment;
	}
	

}