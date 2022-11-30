/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.occ;

import java.io.Serializable;
import de.hybris.platform.sap.productconfig.occ.GroupWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of a product configuration. Contains the entities that describe a complex product: attributes of different types, groups of attributes, hierarchies of groups, statuses and messages. The attributes are typically connected through dependencies
 */
@ApiModel(value="CCPConfiguration", description="Representation of a product configuration. Contains the entities that describe a complex product: attributes of different types, groups of attributes, hierarchies of groups, statuses and messages. The attributes are typically connected through dependencies")
public  class ConfigurationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Configuration Identifier. A randomly generated UUID owned by the product configurator<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.configId</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="configId", value="Configuration Identifier. A randomly generated UUID owned by the product configurator", example="ee520001-3e9a-4321-acc8-b92783c8ca4e") 	
	private String configId;

	/** Code of the configuration root product<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.rootProduct</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="rootProduct", value="Code of the configuration root product", example="CONF_LAPTOP") 	
	private String rootProduct;

	/** Configuration is consistent, meaning it contains no conflicts<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.consistent</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="consistent", value="Configuration is consistent, meaning it contains no conflicts", example="true") 	
	private boolean consistent;

	/** Configuration is complete, meaning each mandatory attribute has been specified<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.complete</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="complete", value="Configuration is complete, meaning each mandatory attribute has been specified", example="true") 	
	private boolean complete;

	/** Configuration quantity<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.quantity</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="quantity", value="Configuration quantity", example="1") 	
	private long quantity;

	/** Total number of issues: sum of number of conflicts and number of incomplete mandatory field<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.totalNumberOfIssues</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="totalNumberOfIssues", value="Total number of issues: sum of number of conflicts and number of incomplete mandatory field", example="1") 	
	private int totalNumberOfIssues;

	/** Attribute groups<br/><br/><i>Generated property</i> for <code>ConfigurationWsDTO.groups</code> property defined at extension <code>sapproductconfigocc</code>. */
@ApiModelProperty(name="groups", value="Attribute groups") 	
	private List<GroupWsDTO> groups;
	
	public ConfigurationWsDTO()
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
	
	public void setRootProduct(final String rootProduct)
	{
		this.rootProduct = rootProduct;
	}

	public String getRootProduct() 
	{
		return rootProduct;
	}
	
	public void setConsistent(final boolean consistent)
	{
		this.consistent = consistent;
	}

	public boolean isConsistent() 
	{
		return consistent;
	}
	
	public void setComplete(final boolean complete)
	{
		this.complete = complete;
	}

	public boolean isComplete() 
	{
		return complete;
	}
	
	public void setQuantity(final long quantity)
	{
		this.quantity = quantity;
	}

	public long getQuantity() 
	{
		return quantity;
	}
	
	public void setTotalNumberOfIssues(final int totalNumberOfIssues)
	{
		this.totalNumberOfIssues = totalNumberOfIssues;
	}

	public int getTotalNumberOfIssues() 
	{
		return totalNumberOfIssues;
	}
	
	public void setGroups(final List<GroupWsDTO> groups)
	{
		this.groups = groups;
	}

	public List<GroupWsDTO> getGroups() 
	{
		return groups;
	}
	

}