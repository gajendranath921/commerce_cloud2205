/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum UsageChargeType declared at extension subscriptionservices.
 */
public enum UsageChargeType implements HybrisEnumValue
{
	/**
	 * Generated enum value for UsageChargeType.highest_applicable_tier declared at extension subscriptionservices.
	 */
	HIGHEST_APPLICABLE_TIER("highest_applicable_tier"),
	/**
	 * Generated enum value for UsageChargeType.each_respective_tier declared at extension subscriptionservices.
	 */
	EACH_RESPECTIVE_TIER("each_respective_tier");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "UsageChargeType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "UsageChargeType";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private UsageChargeType(final String code)
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
