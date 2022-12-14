/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.runtime.interf;

/**
 * Checked exception for errors in the pricing runtime
 */
public class PricingEngineException extends Exception
{
	/**
	 * default constructor
	 */
	public PricingEngineException()
	{
		super();
	}


	/**
	 * Constructor with message and cause
	 *
	 * @param message
	 *           message of the exception
	 * @param cause
	 *           cause of the exception
	 */
	public PricingEngineException(final String message, final Throwable cause)
	{
		super(message, cause);
	}
}
