/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchprovidercssearchservices.indexer.data;

import java.io.Serializable;
import de.hybris.platform.searchprovidercssearchservices.indexer.data.IndexerOperationStatusDTO;
import de.hybris.platform.searchprovidercssearchservices.indexer.data.IndexerOperationTypeDTO;


import java.util.Objects;
public  class IndexerOperationDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>IndexerOperationDTO.id</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>IndexerOperationDTO.indexTypeId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String indexTypeId;

	/** <i>Generated property</i> for <code>IndexerOperationDTO.indexId</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private String indexId;

	/** <i>Generated property</i> for <code>IndexerOperationDTO.operationType</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private IndexerOperationTypeDTO operationType;

	/** <i>Generated property</i> for <code>IndexerOperationDTO.status</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private IndexerOperationStatusDTO status;

	/** <i>Generated property</i> for <code>IndexerOperationDTO.totalItems</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer totalItems;

	/** <i>Generated property</i> for <code>IndexerOperationDTO.processedItems</code> property defined at extension <code>searchprovidercssearchservices</code>. */
	
	private Integer processedItems;
	
	public IndexerOperationDTO()
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
	
	public void setIndexTypeId(final String indexTypeId)
	{
		this.indexTypeId = indexTypeId;
	}

	public String getIndexTypeId() 
	{
		return indexTypeId;
	}
	
	public void setIndexId(final String indexId)
	{
		this.indexId = indexId;
	}

	public String getIndexId() 
	{
		return indexId;
	}
	
	public void setOperationType(final IndexerOperationTypeDTO operationType)
	{
		this.operationType = operationType;
	}

	public IndexerOperationTypeDTO getOperationType() 
	{
		return operationType;
	}
	
	public void setStatus(final IndexerOperationStatusDTO status)
	{
		this.status = status;
	}

	public IndexerOperationStatusDTO getStatus() 
	{
		return status;
	}
	
	public void setTotalItems(final Integer totalItems)
	{
		this.totalItems = totalItems;
	}

	public Integer getTotalItems() 
	{
		return totalItems;
	}
	
	public void setProcessedItems(final Integer processedItems)
	{
		this.processedItems = processedItems;
	}

	public Integer getProcessedItems() 
	{
		return processedItems;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final IndexerOperationDTO other = (IndexerOperationDTO) o;
		return Objects.equals(getId(), other.getId())

			&& Objects.equals(getIndexTypeId(), other.getIndexTypeId())

			&& Objects.equals(getIndexId(), other.getIndexId())

			&& Objects.equals(getOperationType(), other.getOperationType())

			&& Objects.equals(getStatus(), other.getStatus())

			&& Objects.equals(getTotalItems(), other.getTotalItems())

			&& Objects.equals(getProcessedItems(), other.getProcessedItems());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = id;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = indexTypeId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = indexId;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = operationType;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = status;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = totalItems;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = processedItems;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}