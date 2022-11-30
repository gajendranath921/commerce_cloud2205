/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Representation of a cost center. This base bean has no relationship fields to other Org Unit WsDTOs
 */
@ApiModel(value="B2BCostCenterBase", description="Representation of a cost center. This base bean has no relationship fields to other Org Unit WsDTOs")
public  class B2BCostCenterBaseWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The original code of the cost center. Deprecated since 2005.<br/><br/><i>Generated property</i> for <code>B2BCostCenterBaseWsDTO.originalCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="originalCode", value="The original code of the cost center. Deprecated since 2005.", example="Custom_Retail") 	
	private String originalCode;

	/** The name of the cost center<br/><br/><i>Generated property</i> for <code>B2BCostCenterBaseWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="name", value="The name of the cost center", example="Custom Retail") 	
	private String name;

	/** Indication of whether the cost center is active. Deprecated since 2005. Read-only, used for display purposes.<br/><br/><i>Generated property</i> for <code>B2BCostCenterBaseWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="active", value="Indication of whether the cost center is active. Deprecated since 2005. Read-only, used for display purposes.", example="true") 	
	private String active;

	/** Boolean flag of whether the cost center is active.<br/><br/><i>Generated property</i> for <code>B2BCostCenterBaseWsDTO.activeFlag</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="activeFlag", value="Boolean flag of whether the cost center is active.", example="true") 	
	private Boolean activeFlag;

	/** The code of the cost center<br/><br/><i>Generated property</i> for <code>B2BCostCenterBaseWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="code", value="The code of the cost center", example="Custom_Retail") 	
	private String code;

	/** The currency of the cost center<br/><br/><i>Generated property</i> for <code>B2BCostCenterBaseWsDTO.currency</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="currency", value="The currency of the cost center") 	
	private CurrencyWsDTO currency;
	
	public B2BCostCenterBaseWsDTO()
	{
		// default constructor
	}
	
	/**
	 * @deprecated since 2005, no longer needed
	 */
	@Deprecated(forRemoval = true)
	public void setOriginalCode(final String originalCode)
	{
		this.originalCode = originalCode;
	}

	/**
	 * @deprecated since 2005, no longer needed
	 */
	@Deprecated(forRemoval = true)
	public String getOriginalCode() 
	{
		return originalCode;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	/**
	 * @deprecated since 2005, read-only, used for display purposes
	 */
	@Deprecated(forRemoval = true)
	public void setActive(final String active)
	{
		this.active = active;
	}

	/**
	 * @deprecated since 2005, read-only, used for display purposes
	 */
	@Deprecated(forRemoval = true)
	public String getActive() 
	{
		return active;
	}
	
	public void setActiveFlag(final Boolean activeFlag)
	{
		this.activeFlag = activeFlag;
	}

	public Boolean getActiveFlag() 
	{
		return activeFlag;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setCurrency(final CurrencyWsDTO currency)
	{
		this.currency = currency;
	}

	public CurrencyWsDTO getCurrency() 
	{
		return currency;
	}
	

}