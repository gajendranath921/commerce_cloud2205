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
import de.hybris.platform.sap.productconfig.occ.GroupOverviewWsDTO;
import de.hybris.platform.sap.productconfig.occ.PriceSummaryWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a product configuration overview, a condensed read-only view of a product configuration. Contains only the selected values
 */
@ApiModel(value="CCPConfigurationOverview", description="Representation of a product configuration overview, a condensed read-only view of a product configuration. Contains only the selected values")
public  class ConfigurationOverviewWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Identifier of document that owns this configuration. Can be the ID of a saved cart, a quote or an order<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.sourceDocumentId</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="sourceDocumentId", value="Identifier of document that owns this configuration. Can be the ID of a saved cart, a quote or an order", example="0001012345") 	
	private String sourceDocumentId;

	/** Configuration Identifier. A randomly generated UUID owned by the product configurator<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.id</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="id", value="Configuration Identifier. A randomly generated UUID owned by the product configurator", example="ee520001-3e9a-4321-acc8-b92783c8ca4e") 	
	private String id;

	/** Product code of configuration's root product<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.productCode</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="productCode", value="Product code of configuration's root product", example="CONF_LAPTOP") 	
	private String productCode;

	/** Total number of issues: sum of number of conflicts and number of incomplete mandatory field<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.totalNumberOfIssues</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="totalNumberOfIssues", value="Total number of issues: sum of number of conflicts and number of incomplete mandatory field", example="1") 	
	private int totalNumberOfIssues;

	/** Total number of incomplete attributes<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.numberOfIncompleteCharacteristics</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="numberOfIncompleteCharacteristics", value="Total number of incomplete attributes", example="1") 	
	private int numberOfIncompleteCharacteristics;

	/** Total number of conflicts<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.numberOfConflicts</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="numberOfConflicts", value="Total number of conflicts", example="1") 	
	private int numberOfConflicts;

	/** Configuration overview groups<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.groups</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="groups", value="Configuration overview groups") 	
	private List<GroupOverviewWsDTO> groups;

	/** Price summary<br/><br/><i>Generated property</i> for <code>ConfigurationOverviewWsDTO.pricing</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="pricing", value="Price summary") 	
	private PriceSummaryWsDTO pricing;
	
	public ConfigurationOverviewWsDTO()
	{
		// default constructor
	}
	
	public void setSourceDocumentId(final String sourceDocumentId)
	{
		this.sourceDocumentId = sourceDocumentId;
	}

	public String getSourceDocumentId() 
	{
		return sourceDocumentId;
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setTotalNumberOfIssues(final int totalNumberOfIssues)
	{
		this.totalNumberOfIssues = totalNumberOfIssues;
	}

	public int getTotalNumberOfIssues() 
	{
		return totalNumberOfIssues;
	}
	
	public void setNumberOfIncompleteCharacteristics(final int numberOfIncompleteCharacteristics)
	{
		this.numberOfIncompleteCharacteristics = numberOfIncompleteCharacteristics;
	}

	public int getNumberOfIncompleteCharacteristics() 
	{
		return numberOfIncompleteCharacteristics;
	}
	
	public void setNumberOfConflicts(final int numberOfConflicts)
	{
		this.numberOfConflicts = numberOfConflicts;
	}

	public int getNumberOfConflicts() 
	{
		return numberOfConflicts;
	}
	
	public void setGroups(final List<GroupOverviewWsDTO> groups)
	{
		this.groups = groups;
	}

	public List<GroupOverviewWsDTO> getGroups() 
	{
		return groups;
	}
	
	public void setPricing(final PriceSummaryWsDTO pricing)
	{
		this.pricing = pricing;
	}

	public PriceSummaryWsDTO getPricing() 
	{
		return pricing;
	}
	

}