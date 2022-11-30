/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousingwebservices.dto.asn;

import java.io.Serializable;
import de.hybris.platform.warehousingwebservices.dto.asn.AsnEntryWsDTO;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class AsnWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsnWsDTO.externalId</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String externalId;

	/** <i>Generated property</i> for <code>AsnWsDTO.warehouseCode</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String warehouseCode;

	/** <i>Generated property</i> for <code>AsnWsDTO.asnEntries</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private List<AsnEntryWsDTO> asnEntries;

	/** <i>Generated property</i> for <code>AsnWsDTO.pointOfServiceName</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String pointOfServiceName;

	/** <i>Generated property</i> for <code>AsnWsDTO.comment</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String comment;

	/** <i>Generated property</i> for <code>AsnWsDTO.releaseDate</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private Date releaseDate;

	/** <i>Generated property</i> for <code>AsnWsDTO.internalId</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String internalId;

	/** <i>Generated property</i> for <code>AsnWsDTO.status</code> property defined at extension <code>warehousingwebservices</code>. */
	
	private String status;
	
	public AsnWsDTO()
	{
		// default constructor
	}
	
	public void setExternalId(final String externalId)
	{
		this.externalId = externalId;
	}

	public String getExternalId() 
	{
		return externalId;
	}
	
	public void setWarehouseCode(final String warehouseCode)
	{
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseCode() 
	{
		return warehouseCode;
	}
	
	public void setAsnEntries(final List<AsnEntryWsDTO> asnEntries)
	{
		this.asnEntries = asnEntries;
	}

	public List<AsnEntryWsDTO> getAsnEntries() 
	{
		return asnEntries;
	}
	
	public void setPointOfServiceName(final String pointOfServiceName)
	{
		this.pointOfServiceName = pointOfServiceName;
	}

	public String getPointOfServiceName() 
	{
		return pointOfServiceName;
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}
	
	public void setReleaseDate(final Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public Date getReleaseDate() 
	{
		return releaseDate;
	}
	
	public void setInternalId(final String internalId)
	{
		this.internalId = internalId;
	}

	public String getInternalId() 
	{
		return internalId;
	}
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	

}