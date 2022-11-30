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
 * Prices on overall product configuration level
 */
@ApiModel(value="CCPConfigurationOverallPricing", description="Prices on overall product configuration level")
public  class PriceSummaryWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Base price<br/><br/><i>Generated property</i> for <code>PriceSummaryWsDTO.basePrice</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="basePrice", value="Base price") 	
	private PriceWsDTO basePrice;

	/** Summarized price of the selected options<br/><br/><i>Generated property</i> for <code>PriceSummaryWsDTO.selectedOptions</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="selectedOptions", value="Summarized price of the selected options") 	
	private PriceWsDTO selectedOptions;

	/** Total price<br/><br/><i>Generated property</i> for <code>PriceSummaryWsDTO.currentTotal</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="currentTotal", value="Total price") 	
	private PriceWsDTO currentTotal;

	/** Savings that occur because discounts have been applied to one or more attribute values of the configuration<br/><br/><i>Generated property</i> for <code>PriceSummaryWsDTO.currentTotalSavings</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="currentTotalSavings", value="Savings that occur because discounts have been applied to one or more attribute values of the configuration") 	
	private PriceWsDTO currentTotalSavings;
	
	public PriceSummaryWsDTO()
	{
		// default constructor
	}
	
	public void setBasePrice(final PriceWsDTO basePrice)
	{
		this.basePrice = basePrice;
	}

	public PriceWsDTO getBasePrice() 
	{
		return basePrice;
	}
	
	public void setSelectedOptions(final PriceWsDTO selectedOptions)
	{
		this.selectedOptions = selectedOptions;
	}

	public PriceWsDTO getSelectedOptions() 
	{
		return selectedOptions;
	}
	
	public void setCurrentTotal(final PriceWsDTO currentTotal)
	{
		this.currentTotal = currentTotal;
	}

	public PriceWsDTO getCurrentTotal() 
	{
		return currentTotal;
	}
	
	public void setCurrentTotalSavings(final PriceWsDTO currentTotalSavings)
	{
		this.currentTotalSavings = currentTotalSavings;
	}

	public PriceWsDTO getCurrentTotalSavings() 
	{
		return currentTotalSavings;
	}
	

}