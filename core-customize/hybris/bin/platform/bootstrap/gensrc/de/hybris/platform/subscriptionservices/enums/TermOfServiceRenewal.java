/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum TermOfServiceRenewal declared at extension subscriptionservices.
 */
public enum TermOfServiceRenewal implements HybrisEnumValue
{
	/**
	 * Generated enum value for TermOfServiceRenewal.non_renewing declared at extension subscriptionservices.
	 */
	NON_RENEWING("non_renewing"),
	/**
	 * Generated enum value for TermOfServiceRenewal.auto_renewing declared at extension subscriptionservices.
	 */
	AUTO_RENEWING("auto_renewing"),
	/**
	 * Generated enum value for TermOfServiceRenewal.renews_once declared at extension subscriptionservices.
	 */
	RENEWS_ONCE("renews_once"),
	/**
	 * Generated enum value for TermOfServiceRenewal.renews_twice declared at extension subscriptionservices.
	 */
	RENEWS_TWICE("renews_twice"),
	/**
	 * Generated enum value for TermOfServiceRenewal.renews_three_times declared at extension subscriptionservices.
	 */
	RENEWS_THREE_TIMES("renews_three_times");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "TermOfServiceRenewal";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "TermOfServiceRenewal";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private TermOfServiceRenewal(final String code)
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
