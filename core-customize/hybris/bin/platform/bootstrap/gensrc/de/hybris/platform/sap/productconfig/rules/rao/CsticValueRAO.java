/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 */
package de.hybris.platform.sap.productconfig.rules.rao;

import de.hybris.platform.ruleengineservices.rao.AbstractActionedRAO;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CsticValueRAO extends AbstractActionedRAO 
{

	/** <i>Generated property</i> for <code>CsticValueRAO.csticValueName</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String csticValueName;
	/** <i>Generated property</i> for <code>CsticValueRAO.csticName</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String csticName;
	/** <i>Generated property</i> for <code>CsticValueRAO.configId</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String configId;
	
	public CsticValueRAO()
	{
		// default constructor
	}
	

	public void setCsticValueName(final String csticValueName)
	{
		this.csticValueName = csticValueName;
	}
	
	public String getCsticValueName() 
	{
		return csticValueName;
	}

	public void setCsticName(final String csticName)
	{
		this.csticName = csticName;
	}
	
	public String getCsticName() 
	{
		return csticName;
	}

	public void setConfigId(final String configId)
	{
		this.configId = configId;
	}
	
	public String getConfigId() 
	{
		return configId;
	}
	

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.append("csticValueName", csticValueName)
			.append("csticName", csticName)
			.append("configId", configId)
			.toString();
	}

 	@Override
   public boolean equals(Object obj)
	{
		if (obj == null || !this.getClass().equals(obj.getClass())) {
      	return false;
      } else if (obj == this) {
      	return true;
      }
      CsticValueRAO other = (CsticValueRAO)obj;
      return new EqualsBuilder()
			.append(csticValueName, other.csticValueName)
			.append(csticName, other.csticName)
			.append(configId, other.configId)
         .isEquals();
   }
    	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder()
			.append(csticValueName)
			.append(csticName)
			.append(configId)
			.toHashCode();
	}
}