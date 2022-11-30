/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.stocklevel;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class StockLevelAdjustmentReasonsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StockLevelAdjustmentReasonsWsDTO.reasons</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<String> reasons;
	
	public StockLevelAdjustmentReasonsWsDTO()
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