/*
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum ThumbnailSelectorOptions declared at extension cms2.
 */
public enum ThumbnailSelectorOptions implements HybrisEnumValue
{
	/**
	 * Generated enum value for ThumbnailSelectorOptions.NO_THUMBNAIL declared at extension cms2.
	 */
	NO_THUMBNAIL("NO_THUMBNAIL"),
	/**
	 * Generated enum value for ThumbnailSelectorOptions.UPLOAD_THUMBNAIL declared at extension cms2.
	 */
	UPLOAD_THUMBNAIL("UPLOAD_THUMBNAIL");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "ThumbnailSelectorOptions";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "ThumbnailSelectorOptions";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private ThumbnailSelectorOptions(final String code)
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
