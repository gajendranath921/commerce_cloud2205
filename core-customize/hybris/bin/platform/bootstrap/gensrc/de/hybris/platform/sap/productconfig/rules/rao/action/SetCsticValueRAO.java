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
package de.hybris.platform.sap.productconfig.rules.rao.action;

import de.hybris.platform.ruleengineservices.rao.AbstractRuleActionRAO;
import de.hybris.platform.sap.productconfig.rules.rao.CsticValueRAO;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SetCsticValueRAO extends AbstractRuleActionRAO 
{

	/** <i>Generated property</i> for <code>SetCsticValueRAO.valueNameToSet</code> property defined at extension <code>sapproductconfigrules</code>. */
	private CsticValueRAO valueNameToSet;
	
	public SetCsticValueRAO()
	{
		// default constructor
	}
	

	public void setValueNameToSet(final CsticValueRAO valueNameToSet)
	{
		this.valueNameToSet = valueNameToSet;
	}
	
	public CsticValueRAO getValueNameToSet() 
	{
		return valueNameToSet;
	}
	

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.append("valueNameToSet", valueNameToSet)
			.toString();
	}
}