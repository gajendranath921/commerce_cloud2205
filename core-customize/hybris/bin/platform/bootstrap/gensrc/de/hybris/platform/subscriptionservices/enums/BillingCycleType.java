/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum BillingCycleType declared at extension subscriptionservices.
 */
public enum BillingCycleType implements HybrisEnumValue
{
	/**
	 * Generated enum value for BillingCycleType.end_of_month declared at extension subscriptionservices.
	 */
	END_OF_MONTH("end_of_month"),
	/**
	 * Generated enum value for BillingCycleType.day_of_month declared at extension subscriptionservices.
	 */
	DAY_OF_MONTH("day_of_month"),
	/**
	 * Generated enum value for BillingCycleType.subscription_start declared at extension subscriptionservices.
	 */
	SUBSCRIPTION_START("subscription_start");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "BillingCycleType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "BillingCycleType";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private BillingCycleType(final String code)
	{
		this.code = code.intern();
	}
	
	
	/**
	 * Gets the code of this enum value.
	 *  
	 * @return code of value
	 */
	@Override
	public String getCode()
	{
		return this.code;
	}
	
	/**
	 * Gets the type this enum value belongs to.
	 *  
	 * @return code of type
	 */
	@Override
	public String getType()
	{
		return SIMPLE_CLASSNAME;
	}
	
}
