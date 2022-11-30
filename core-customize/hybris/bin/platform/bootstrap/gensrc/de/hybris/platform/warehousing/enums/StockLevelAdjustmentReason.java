/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.warehousing.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum StockLevelAdjustmentReason declared at extension warehousing.
 */
public enum StockLevelAdjustmentReason implements HybrisEnumValue
{
	/**
	 * Generated enum value for StockLevelAdjustmentReason.Wastage declared at extension warehousing.
	 */
	WASTAGE("Wastage"),
	/**
	 * Generated enum value for StockLevelAdjustmentReason.Shrinkage declared at extension warehousing.
	 */
	SHRINKAGE("Shrinkage"),
	/**
	 * Generated enum value for StockLevelAdjustmentReason.Increase declared at extension warehousing.
	 */
	INCREASE("Increase");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "StockLevelAdjustmentReason";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "StockLevelAdjustmentReason";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private StockLevelAdjustmentReason(final String code)
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
