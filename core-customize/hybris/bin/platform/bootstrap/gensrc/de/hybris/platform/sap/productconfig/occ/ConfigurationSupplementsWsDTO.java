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
import de.hybris.platform.sap.productconfig.occ.CsticSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.PriceSummaryWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Enriches a product configuration with supplementary pricing data
 */
@ApiModel(value="CCPConfigurationPricing", description="Enriches a product configuration with supplementary pricing data")
public  class ConfigurationSupplementsWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Configuration Identifier. A randomly generated UUID owned by the product configurator<br/><br/><i>Generated property</i> for <code>ConfigurationSupplementsWsDTO.configId</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="configId", value="Configuration Identifier. A randomly generated UUID owned by the product configurator", example="ee520001-3e9a-4321-acc8-b92783c8ca4e") 	
	private String configId;

	/** Indicates that attribute surcharges are displayed relatively to the current attribute price<br/><br/><i>Generated property</i> for <code>ConfigurationSupplementsWsDTO.showDeltaPrices</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="showDeltaPrices", value="Indicates that attribute surcharges are displayed relatively to the current attribute price", example="true") 	
	private boolean showDeltaPrices;

	/** Indicates that pricing is currently not available<br/><br/><i>Generated property</i> for <code>ConfigurationSupplementsWsDTO.pricingError</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="pricingError", value="Indicates that pricing is currently not available", example="false") 	
	private boolean pricingError;

	/** List of supplementary data on attribute level<br/><br/><i>Generated property</i> for <code>ConfigurationSupplementsWsDTO.attributes</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="attributes", value="List of supplementary data on attribute level") 	
	private List<CsticSupplementsWsDTO> attributes;

	/** Price summary<br/><br/><i>Generated property</i> for <code>ConfigurationSupplementsWsDTO.priceSummary</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="priceSummary", value="Price summary") 	
	private PriceSummaryWsDTO priceSummary;
	
	public ConfigurationSupplementsWsDTO()
	{
		// default constructor
	}
	
	public void setConfigId(final String configId)
	{
		this.configId = configId;
	}

	public String getConfigId() 
	{
		return configId;
	}
	
	public void setShowDeltaPrices(final boolean showDeltaPrices)
	{
		this.showDeltaPrices = showDeltaPrices;
	}

	public boolean isShowDeltaPrices() 
	{
		return showDeltaPrices;
	}
	
	public void setPricingError(final boolean pricingError)
	{
		this.pricingError = pricingError;
	}

	public boolean isPricingError() 
	{
		return pricingError;
	}
	
	public void setAttributes(final List<CsticSupplementsWsDTO> attributes)
	{
		this.attributes = attributes;
	}

	public List<CsticSupplementsWsDTO> getAttributes() 
	{
		return attributes;
	}
	
	public void setPriceSummary(final PriceSummaryWsDTO priceSummary)
	{
		this.priceSummary = priceSummary;
	}

	public PriceSummaryWsDTO getPriceSummary() 
	{
		return priceSummary;
	}
	

}