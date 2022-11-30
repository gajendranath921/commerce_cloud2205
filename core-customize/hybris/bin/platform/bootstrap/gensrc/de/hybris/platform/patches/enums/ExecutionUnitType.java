/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.patches.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum ExecutionUnitType declared at extension patches.
 * <p/>
 * Types of PatchExecutionUnit.
 */
public enum ExecutionUnitType implements HybrisEnumValue
{
	/**
	 * Generated enum value for ExecutionUnitType.IMPEX_IMPORT declared at extension patches.
	 */
	IMPEX_IMPORT("IMPEX_IMPORT"),
	/**
	 * Generated enum value for ExecutionUnitType.SQL_COMMAND declared at extension patches.
	 */
	SQL_COMMAND("SQL_COMMAND"),
	/**
	 * Generated enum value for ExecutionUnitType.ACTION declared at extension patches.
	 */
	ACTION("ACTION");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "ExecutionUnitType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "ExecutionUnitType";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private ExecutionUnitType(final String code)
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
