/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.entitlementservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum EntitlementTimeUnit declared at extension entitlementservices.
 */
public enum EntitlementTimeUnit implements HybrisEnumValue
{
	/**
	 * Generated enum value for EntitlementTimeUnit.day declared at extension entitlementservices.
	 */
	DAY("day"),
	/**
	 * Generated enum value for EntitlementTimeUnit.month declared at extension entitlementservices.
	 */
	MONTH("month");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "EntitlementTimeUnit";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "EntitlementTimeUnit";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private EntitlementTimeUnit(final String code)
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
