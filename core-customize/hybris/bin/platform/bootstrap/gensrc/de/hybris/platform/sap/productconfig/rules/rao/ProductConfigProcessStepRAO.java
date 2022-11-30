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

import de.hybris.platform.ruleengineservices.rao.AbstractRuleActionRAO;
import de.hybris.platform.ruleengineservices.rao.ProcessStep;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ProductConfigProcessStepRAO extends AbstractRuleActionRAO 
{

	/** <i>Generated property</i> for <code>ProductConfigProcessStepRAO.processStep</code> property defined at extension <code>sapproductconfigrules</code>. */
	private ProcessStep processStep;
	
	public ProductConfigProcessStepRAO()
	{
		// default constructor
	}
	

	public void setProcessStep(final ProcessStep processStep)
	{
		this.processStep = processStep;
	}
	
	public ProcessStep getProcessStep() 
	{
		return processStep;
	}
	

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.append("processStep", processStep)
			.toString();
	}
}