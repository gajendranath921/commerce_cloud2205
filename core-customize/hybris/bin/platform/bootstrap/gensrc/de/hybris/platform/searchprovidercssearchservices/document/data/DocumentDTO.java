/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.document.data;

import java.io.Serializable;
import java.util.Map;


import java.util.Objects;
public  class DocumentDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DocumentDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>DocumentDTO.fields</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Map<String,Object> fields;
	
	public DocumentDTO()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setFields(final Map<String,Object> fields)
	{
		this.fields = fields;
	}

	public Map<String,Object> getFields() 
	{
		return fields;
	}
	

}