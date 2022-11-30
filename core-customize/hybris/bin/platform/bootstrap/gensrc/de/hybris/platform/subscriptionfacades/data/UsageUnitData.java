/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.subscriptionfacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class UsageUnitData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UsageUnitData.id</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>UsageUnitData.name</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>UsageUnitData.namePlural</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private String namePlural;

	/** <i>Generated property</i> for <code>UsageUnitData.accumulative</code> property defined at extension <code>subscriptionfacades</code>. */
	
	private boolean accumulative;
	
	public UsageUnitData()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setNamePlural(final String namePlural)
	{
		this.namePlural = namePlural;
	}

	public String getNamePlural() 
	{
		return namePlural;
	}
	
	public void setAccumulative(final boolean accumulative)
	{
		this.accumulative = accumulative;
	}

	public boolean isAccumulative() 
	{
		return accumulative;
	}
	

}