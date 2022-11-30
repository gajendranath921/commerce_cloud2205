/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsocc.data;

import java.io.Serializable;
import de.hybris.platform.cmsocc.data.CMSPageWsDTO;
import java.util.List;


import java.util.Objects;
public  class CMSPageListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSPageListWsDTO.page</code> property defined at extension <code>cmsocc</code>. */
	
	private List<CMSPageWsDTO> page;
	
	public CMSPageListWsDTO()
	{
		// default constructor
	}
	
	public void setPage(final List<CMSPageWsDTO> page)
	{
		this.page = page;
	}

	public List<CMSPageWsDTO> getPage() 
	{
		return page;
	}
	

}