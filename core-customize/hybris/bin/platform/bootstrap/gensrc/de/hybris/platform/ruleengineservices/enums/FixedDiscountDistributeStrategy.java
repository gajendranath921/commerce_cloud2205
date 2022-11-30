/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ruleengineservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum FixedDiscountDistributeStrategy declared at extension ruleengineservices.
 */
public enum FixedDiscountDistributeStrategy implements HybrisEnumValue
{
	/**
	 * Generated enum value for FixedDiscountDistributeStrategy.UNIFORM declared at extension ruleengineservices.
	 */
	UNIFORM("UNIFORM");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "FixedDiscountDistributeStrategy";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "FixedDiscountDistributeStrategy";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private FixedDiscountDistributeStrategy(final String code)
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
