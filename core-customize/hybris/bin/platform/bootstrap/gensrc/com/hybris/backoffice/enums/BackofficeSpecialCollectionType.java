package com.hybris.backoffice.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum BackofficeSpecialCollectionType declared at extension backoffice.
 */
public enum BackofficeSpecialCollectionType implements HybrisEnumValue
{
	/**
	 * Generated enum value for BackofficeSpecialCollectionType.quicklist declared at extension backoffice.
	 */
	QUICKLIST("quicklist"),
	/**
	 * Generated enum value for BackofficeSpecialCollectionType.blockedlist declared at extension backoffice.
	 */
	BLOCKEDLIST("blockedlist");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "BackofficeSpecialCollectionType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "BackofficeSpecialCollectionType";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private BackofficeSpecialCollectionType(final String code)
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
