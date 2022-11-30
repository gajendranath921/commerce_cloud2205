/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.ConsignmentStatus;
import java.util.List;


import java.util.Objects;
public  class ConsignmentStatusDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsignmentStatusDataList.statuses</code> property defined at extension <code>warehousingfacades</code>. */
	
	private List<ConsignmentStatus> statuses;
	
	public ConsignmentStatusDataList()
	{
		// default constructor
	}
	
	public void setStatuses(final List<ConsignmentStatus> statuses)
	{
		this.statuses = statuses;
	}

	public List<ConsignmentStatus> getStatuses() 
	{
		return statuses;
	}
	

}