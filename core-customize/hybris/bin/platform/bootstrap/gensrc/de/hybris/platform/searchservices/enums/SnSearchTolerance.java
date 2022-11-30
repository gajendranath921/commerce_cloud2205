/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.searchservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum SnSearchTolerance declared at extension searchservices.
 */
public enum SnSearchTolerance implements HybrisEnumValue
{
	/**
	 * Generated enum value for SnSearchTolerance.BASIC declared at extension searchservices.
	 */
	BASIC("BASIC"),
	/**
	 * Generated enum value for SnSearchTolerance.MEDIUM declared at extension searchservices.
	 */
	MEDIUM("MEDIUM"),
	/**
	 * Generated enum value for SnSearchTolerance.RELAXED declared at extension searchservices.
	 */
	RELAXED("RELAXED");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "SnSearchTolerance";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "SnSearchTolerance";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private SnSearchTolerance(final String code)
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
