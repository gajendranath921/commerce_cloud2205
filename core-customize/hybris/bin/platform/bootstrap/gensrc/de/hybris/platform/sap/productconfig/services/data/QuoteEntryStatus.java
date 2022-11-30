/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.services.data;

import java.io.Serializable;


import java.util.Objects;
public  class QuoteEntryStatus  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>QuoteEntryStatus.productCode</code> property defined at extension <code>sapproductconfigservices</code>. */
	
	private String productCode;

	/** <i>Generated property</i> for <code>QuoteEntryStatus.hasConfigurationIssue</code> property defined at extension <code>sapproductconfigservices</code>. */
	
	private Boolean hasConfigurationIssue;
	
	public QuoteEntryStatus()
	{
		// default constructor
	}
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setHasConfigurationIssue(final Boolean hasConfigurationIssue)
	{
		this.hasConfigurationIssue = hasConfigurationIssue;
	}

	public Boolean getHasConfigurationIssue() 
	{
		return hasConfigurationIssue;
	}
	

}