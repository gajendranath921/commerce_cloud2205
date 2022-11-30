/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.patches.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum ExecutionStatus declared at extension patches.
 * <p/>
 * Statuses of PatchExecution and PatchExecutionUnit.
 */
public enum ExecutionStatus implements HybrisEnumValue
{
	/**
	 * Generated enum value for ExecutionStatus.UNKNOWN declared at extension patches.
	 */
	UNKNOWN("UNKNOWN"),
	/**
	 * Generated enum value for ExecutionStatus.ERROR declared at extension patches.
	 */
	ERROR("ERROR"),
	/**
	 * Generated enum value for ExecutionStatus.SUCCESS declared at extension patches.
	 */
	SUCCESS("SUCCESS");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "ExecutionStatus";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "ExecutionStatus";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private ExecutionStatus(final String code)
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
