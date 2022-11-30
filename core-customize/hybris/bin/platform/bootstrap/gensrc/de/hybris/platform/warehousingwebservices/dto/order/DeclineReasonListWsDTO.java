/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.order;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class DeclineReasonListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DeclineReasonListWsDTO.reasons</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<String> reasons;
	
	public DeclineReasonListWsDTO()
	{
		// default constructor
	}
	
	public void setReasons(final List<String> reasons)
	{
		this.reasons = reasons;
	}

	public List<String> getReasons() 
	{
		return reasons;
	}
	

}