/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.yhacext.data;

import java.io.Serializable;


import java.util.Objects;
public  class SampleMonitorResultData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SampleMonitorResultData.name</code> property defined at extension <code>yhacext</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>SampleMonitorResultData.duration</code> property defined at extension <code>yhacext</code>. */
	
	private Long duration;

	/** <i>Generated property</i> for <code>SampleMonitorResultData.message</code> property defined at extension <code>yhacext</code>. */
	
	private String message;
	
	public SampleMonitorResultData()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDuration(final Long duration)
	{
		this.duration = duration;
	}

	public Long getDuration() 
	{
		return duration;
	}
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
	

}