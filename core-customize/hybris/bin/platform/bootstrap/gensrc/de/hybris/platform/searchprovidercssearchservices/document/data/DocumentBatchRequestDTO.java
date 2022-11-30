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
import de.hybris.platform.searchprovidercssearchservices.document.data.DocumentBatchOperationRequestDTO;
import java.util.List;


import java.util.Objects;
public  class DocumentBatchRequestDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DocumentBatchRequestDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>DocumentBatchRequestDTO.indexerOperationId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String indexerOperationId;

	/** <i>Generated property</i> for <code>DocumentBatchRequestDTO.requests</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private List<DocumentBatchOperationRequestDTO> requests;
	
	public DocumentBatchRequestDTO()
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
	
	public void setIndexerOperationId(final String indexerOperationId)
	{
		this.indexerOperationId = indexerOperationId;
	}

	public String getIndexerOperationId() 
	{
		return indexerOperationId;
	}
	
	public void setRequests(final List<DocumentBatchOperationRequestDTO> requests)
	{
		this.requests = requests;
	}

	public List<DocumentBatchOperationRequestDTO> getRequests() 
	{
		return requests;
	}
	

}