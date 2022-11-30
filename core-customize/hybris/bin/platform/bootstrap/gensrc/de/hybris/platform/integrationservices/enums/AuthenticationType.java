/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum AuthenticationType declared at extension integrationservices.
 */
public enum AuthenticationType implements HybrisEnumValue
{
	/**
	 * Generated enum value for AuthenticationType.BASIC declared at extension integrationservices.
	 */
	BASIC("BASIC"),
	/**
	 * Generated enum value for AuthenticationType.OAUTH declared at extension integrationservices.
	 */
	OAUTH("OAUTH");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "AuthenticationType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "AuthenticationType";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private AuthenticationType(final String code)
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
