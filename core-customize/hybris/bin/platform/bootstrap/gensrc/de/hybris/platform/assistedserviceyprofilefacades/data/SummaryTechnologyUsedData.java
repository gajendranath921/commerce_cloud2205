/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.assistedserviceyprofilefacades.data;

import java.io.Serializable;
import de.hybris.platform.assistedserviceyprofilefacades.data.TechnologyUsedData;
import java.util.List;


import java.util.Objects;
public  class SummaryTechnologyUsedData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SummaryTechnologyUsedData.name</code> property defined at extension <code>assistedserviceyprofilefacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>SummaryTechnologyUsedData.technologyUsedData</code> property defined at extension <code>assistedserviceyprofilefacades</code>. */
	
	private List<TechnologyUsedData> technologyUsedData;
	
	public SummaryTechnologyUsedData()
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
	
	public void setTechnologyUsedData(final List<TechnologyUsedData> technologyUsedData)
	{
		this.technologyUsedData = technologyUsedData;
	}

	public List<TechnologyUsedData> getTechnologyUsedData() 
	{
		return technologyUsedData;
	}
	

}