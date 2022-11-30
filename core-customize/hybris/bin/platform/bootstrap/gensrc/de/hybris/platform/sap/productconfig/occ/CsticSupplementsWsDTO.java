/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.sap.productconfig.occ.CsticValueSupplementsWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Enriches an attribute with supplementary pricing data
 */
@ApiModel(value="CCPAttributePricing", description="Enriches an attribute with supplementary pricing data")
public  class CsticSupplementsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Attribute key<br/><br/><i>Generated property</i> for <code>CsticSupplementsWsDTO.csticUiKey</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="csticUiKey", value="Attribute key", example="1-CONF_LAPTOP.AUDIO-ACCESSORY") 	
	private String csticUiKey;

	/** List of currently selected domain values<br/><br/><i>Generated property</i> for <code>CsticSupplementsWsDTO.selectedValues</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="selectedValues", value="List of currently selected domain values") 	
	private List<String> selectedValues;

	/** List of value price supplements<br/><br/><i>Generated property</i> for <code>CsticSupplementsWsDTO.priceSupplements</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="priceSupplements", value="List of value price supplements") 	
	private List<CsticValueSupplementsWsDTO> priceSupplements;
	
	public CsticSupplementsWsDTO()
	{
		// default constructor
	}
	
	public void setCsticUiKey(final String csticUiKey)
	{
		this.csticUiKey = csticUiKey;
	}

	public String getCsticUiKey() 
	{
		return csticUiKey;
	}
	
	public void setSelectedValues(final List<String> selectedValues)
	{
		this.selectedValues = selectedValues;
	}

	public List<String> getSelectedValues() 
	{
		return selectedValues;
	}
	
	public void setPriceSupplements(final List<CsticValueSupplementsWsDTO> priceSupplements)
	{
		this.priceSupplements = priceSupplements;
	}

	public List<CsticValueSupplementsWsDTO> getPriceSupplements() 
	{
		return priceSupplements;
	}
	

}