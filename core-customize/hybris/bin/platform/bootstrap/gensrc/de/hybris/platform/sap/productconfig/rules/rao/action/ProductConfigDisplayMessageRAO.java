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
import de.hybris.platform.sap.productconfig.rules.enums.ProductConfigRuleMessageSeverity;
import de.hybris.platform.sap.productconfig.rules.rao.CsticValueRAO;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ProductConfigDisplayMessageRAO extends AbstractRuleActionRAO 
{

	/** <i>Generated property</i> for <code>ProductConfigDisplayMessageRAO.valueNameForMessage</code> property defined at extension <code>sapproductconfigrules</code>. */
	private CsticValueRAO valueNameForMessage;
	/** <i>Generated property</i> for <code>ProductConfigDisplayMessageRAO.message</code> property defined at extension <code>sapproductconfigrules</code>. */
	private String message;
	/** <i>Generated property</i> for <code>ProductConfigDisplayMessageRAO.messageSeverity</code> property defined at extension <code>sapproductconfigrules</code>. */
	private ProductConfigRuleMessageSeverity messageSeverity;
	
	public ProductConfigDisplayMessageRAO()
	{
		// default constructor
	}
	

	public void setValueNameForMessage(final CsticValueRAO valueNameForMessage)
	{
		this.valueNameForMessage = valueNameForMessage;
	}
	
	public CsticValueRAO getValueNameForMessage() 
	{
		return valueNameForMessage;
	}

	public void setMessage(final String message)
	{
		this.message = message;
	}
	
	public String getMessage() 
	{
		return message;
	}

	public void setMessageSeverity(final ProductConfigRuleMessageSeverity messageSeverity)
	{
		this.messageSeverity = messageSeverity;
	}
	
	public ProductConfigRuleMessageSeverity getMessageSeverity() 
	{
		return messageSeverity;
	}
	

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.append("valueNameForMessage", valueNameForMessage)
			.append("message", message)
			.append("messageSeverity", messageSeverity)
			.toString();
	}
}