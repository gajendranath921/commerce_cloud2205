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
import java.util.List;


import java.util.Objects;
public  class ReturnActionListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnActionListWsDTO.returnActions</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<String> returnActions;
	
	public ReturnActionListWsDTO()
	{
		// default constructor
	}
	
	public void setReturnActions(final List<String> returnActions)
	{
		this.returnActions = returnActions;
	}

	public List<String> getReturnActions() 
	{
		return returnActions;
	}
	

}