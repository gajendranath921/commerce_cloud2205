/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.document.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.document.data.DocumentDTO;


import java.util.Objects;
public  class DocumentBatchOperationRequestDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DocumentBatchOperationRequestDTO.method</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String method;

	/** <i>Generated property</i> for <code>DocumentBatchOperationRequestDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>DocumentBatchOperationRequestDTO.body</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private DocumentDTO body;
	
	public DocumentBatchOperationRequestDTO()
	{
		// default constructor
	}
	
	public void setMethod(final String method)
	{
		this.method = method;
	}

	public String getMethod() 
	{
		return method;
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setBody(final DocumentDTO body)
	{
		this.body = body;
	}

	public DocumentDTO getBody() 
	{
		return body;
	}
	

}