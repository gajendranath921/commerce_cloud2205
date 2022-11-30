/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class ContentSlotTypeRestrictionsData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ContentSlotTypeRestrictionsData.contentSlotUid</code> property defined at extension <code>cmsfacades</code>. */
	
	private String contentSlotUid;

	/** <i>Generated property</i> for <code>ContentSlotTypeRestrictionsData.validComponentTypes</code> property defined at extension <code>cmsfacades</code>. */
	
	private List<String> validComponentTypes;
	
	public ContentSlotTypeRestrictionsData()
	{
		// default constructor
	}
	
	public void setContentSlotUid(final String contentSlotUid)
	{
		this.contentSlotUid = contentSlotUid;
	}

	public String getContentSlotUid() 
	{
		return contentSlotUid;
	}
	
	public void setValidComponentTypes(final List<String> validComponentTypes)
	{
		this.validComponentTypes = validComponentTypes;
	}

	public List<String> getValidComponentTypes() 
	{
		return validComponentTypes;
	}
	

}