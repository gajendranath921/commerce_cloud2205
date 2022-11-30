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
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Enriches an attribute value with supplementary pricing data
 */
@ApiModel(value="CCPAttributeValuePricing", description="Enriches an attribute value with supplementary pricing data")
public  class CsticValueSupplementsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Value key<br/><br/><i>Generated property</i> for <code>CsticValueSupplementsWsDTO.attributeValueKey</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="attributeValueKey", value="Value key", example="MET_BLUE") 	
	private String attributeValueKey;

	/** Price of attribute value<br/><br/><i>Generated property</i> for <code>CsticValueSupplementsWsDTO.priceValue</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="priceValue", value="Price of attribute value") 	
	private PriceWsDTO priceValue;

	/** Obsolete price that has been reduced as discounts have been applied<br/><br/><i>Generated property</i> for <code>CsticValueSupplementsWsDTO.obsoletePriceValue</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="obsoletePriceValue", value="Obsolete price that has been reduced as discounts have been applied") 	
	private PriceWsDTO obsoletePriceValue;
	
	public CsticValueSupplementsWsDTO()
	{
		// default constructor
	}
	
	public void setAttributeValueKey(final String attributeValueKey)
	{
		this.attributeValueKey = attributeValueKey;
	}

	public String getAttributeValueKey() 
	{
		return attributeValueKey;
	}
	
	public void setPriceValue(final PriceWsDTO priceValue)
	{
		this.priceValue = priceValue;
	}

	public PriceWsDTO getPriceValue() 
	{
		return priceValue;
	}
	
	public void setObsoletePriceValue(final PriceWsDTO obsoletePriceValue)
	{
		this.obsoletePriceValue = obsoletePriceValue;
	}

	public PriceWsDTO getObsoletePriceValue() 
	{
		return obsoletePriceValue;
	}
	

}