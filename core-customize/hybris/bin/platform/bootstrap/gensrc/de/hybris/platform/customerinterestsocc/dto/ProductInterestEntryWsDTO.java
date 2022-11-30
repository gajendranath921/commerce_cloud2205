/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customerinterestsocc.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Product interest entry
 */
@ApiModel(value="productInterestEntry", description="Product interest entry")
public  class ProductInterestEntryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Product interest type<br/><br/><i>Generated property</i> for <code>ProductInterestEntryWsDTO.interestType</code> property defined at extension <code>customerinterestsocc</code>. */
@ApiModelProperty(name="interestType", value="Product interest type") 	
	private String interestType;

	/** Added date of product interest<br/><br/><i>Generated property</i> for <code>ProductInterestEntryWsDTO.dateAdded</code> property defined at extension <code>customerinterestsocc</code>. */
@ApiModelProperty(name="dateAdded", value="Added date of product interest") 	
	private Date dateAdded;

	/** Expiration date of product interest<br/><br/><i>Generated property</i> for <code>ProductInterestEntryWsDTO.expirationDate</code> property defined at extension <code>customerinterestsocc</code>. */
@ApiModelProperty(name="expirationDate", value="Expiration date of product interest") 	
	private Date expirationDate;
	
	public ProductInterestEntryWsDTO()
	{
		// default constructor
	}
	
	public void setInterestType(final String interestType)
	{
		this.interestType = interestType;
	}

	public String getInterestType() 
	{
		return interestType;
	}
	
	public void setDateAdded(final Date dateAdded)
	{
		this.dateAdded = dateAdded;
	}

	public Date getDateAdded() 
	{
		return dateAdded;
	}
	
	public void setExpirationDate(final Date expirationDate)
	{
		this.expirationDate = expirationDate;
	}

	public Date getExpirationDate() 
	{
		return expirationDate;
	}
	

}