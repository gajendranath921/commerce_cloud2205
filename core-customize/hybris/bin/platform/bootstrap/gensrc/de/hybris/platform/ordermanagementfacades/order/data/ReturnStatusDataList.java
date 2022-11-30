/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.ReturnStatus;
import java.util.List;


import java.util.Objects;
public  class ReturnStatusDataList  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnStatusDataList.statuses</code> property defined at extension <code>ordermanagementfacades</code>. */
	
	private List<ReturnStatus> statuses;
	
	public ReturnStatusDataList()
	{
		// default constructor
	}
	
	public void setStatuses(final List<ReturnStatus> statuses)
	{
		this.statuses = statuses;
	}

	public List<ReturnStatus> getStatuses() 
	{
		return statuses;
	}
	

}