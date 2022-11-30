/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.document.data;

import java.io.Serializable;


import java.util.Objects;
public  class DocumentBatchOperationResponseDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DocumentBatchOperationResponseDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>DocumentBatchOperationResponseDTO.statusCode</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer statusCode;
	
	public DocumentBatchOperationResponseDTO()
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
	
	public void setStatusCode(final Integer statusCode)
	{
		this.statusCode = statusCode;
	}

	public Integer getStatusCode() 
	{
		return statusCode;
	}
	

}