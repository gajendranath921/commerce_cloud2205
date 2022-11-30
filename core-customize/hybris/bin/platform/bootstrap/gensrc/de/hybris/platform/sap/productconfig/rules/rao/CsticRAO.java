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
import de.hybris.platform.sap.productconfig.rules.rao.CsticValueRAO;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CsticRAO extends AbstractActionedRAO 
{

	/** <i>Generated property</i> for <code>CsticRAO.csticName</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String csticName;
	/** <i>Generated property</i> for <code>CsticRAO.configId</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String configId;
	/** <i>Generated property</i> for <code>CsticRAO.assignedValues</code> property defined at extension <code>sapproductconfigrules</code>. */
	private List<CsticValueRAO> assignedValues;
	/** <i>Generated property</i> for <code>CsticRAO.assignableValues</code> property defined at extension <code>sapproductconfigrules</code>. */
	private List<CsticValueRAO> assignableValues;
	
	public CsticRAO()
	{
		// default constructor
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

	public void setAssignedValues(final List<CsticValueRAO> assignedValues)
	{
		this.assignedValues = assignedValues;
	}
	
	public List<CsticValueRAO> getAssignedValues() 
	{
		return assignedValues;
	}

	public void setAssignableValues(final List<CsticValueRAO> assignableValues)
	{
		this.assignableValues = assignableValues;
	}
	
	public List<CsticValueRAO> getAssignableValues() 
	{
		return assignableValues;
	}
	

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.append("csticName", csticName)
			.append("configId", configId)
			.append("assignedValues", assignedValues)
			.append("assignableValues", assignableValues)
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
      CsticRAO other = (CsticRAO)obj;
      return new EqualsBuilder()
			.append(csticName, other.csticName)
			.append(configId, other.configId)
         .isEquals();
   }
    	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder()
			.append(csticName)
			.append(configId)
			.toHashCode();
	}
}