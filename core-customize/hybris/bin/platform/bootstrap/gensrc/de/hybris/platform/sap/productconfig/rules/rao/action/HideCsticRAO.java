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

import org.apache.commons.lang.builder.ToStringBuilder;

public class HideCsticRAO extends AbstractRuleActionRAO 
{

	
	public HideCsticRAO()
	{
		// default constructor
	}
	
	

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.toString();
	}
}