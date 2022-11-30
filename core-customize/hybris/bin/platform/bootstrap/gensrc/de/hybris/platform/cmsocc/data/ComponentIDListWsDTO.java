/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsocc.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
/**
 * List of CMS component IDs
 */
public  class ComponentIDListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ComponentIDListWsDTO.idList</code> property defined at extension <code>cmsocc</code>. */
	
	private List<String> idList;
	
	public ComponentIDListWsDTO()
	{
		// default constructor
	}
	
	public void setIdList(final List<String> idList)
	{
		this.idList = idList;
	}

	public List<String> getIdList() 
	{
		return idList;
	}
	

}