/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ruleengineservices.compiler;

import java.io.Serializable;
import java.util.Map;


import java.util.Objects;
public abstract  class RuleIrCondition  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RuleIrCondition.metadata</code> property defined at extension <code>ruleengineservices</code>. */
	
	private Map<String,Object> metadata;
	
	public RuleIrCondition()
	{
		// default constructor
	}
	
	public void setMetadata(final Map<String,Object> metadata)
	{
		this.metadata = metadata;
	}

	public Map<String,Object> getMetadata() 
	{
		return metadata;
	}
	

}