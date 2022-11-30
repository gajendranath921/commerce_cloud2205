/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.rules.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum ProductConfigRuleMessageSeverity declared at extension sapproductconfigrules.
 */
public enum ProductConfigRuleMessageSeverity implements HybrisEnumValue
{
	/**
	 * Generated enum value for ProductConfigRuleMessageSeverity.WARNING declared at extension sapproductconfigrules.
	 */
	WARNING("WARNING"),
	/**
	 * Generated enum value for ProductConfigRuleMessageSeverity.INFO declared at extension sapproductconfigrules.
	 */
	INFO("INFO");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "ProductConfigRuleMessageSeverity";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "ProductConfigRuleMessageSeverity";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private ProductConfigRuleMessageSeverity(final String code)
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
