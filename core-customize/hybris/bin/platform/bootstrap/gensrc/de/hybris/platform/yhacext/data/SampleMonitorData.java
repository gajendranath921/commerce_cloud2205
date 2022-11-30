/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.yhacext.data;

import java.io.Serializable;
import de.hybris.platform.yhacext.data.SampleMonitorResultData;
import java.util.List;


import java.util.Objects;
public  class SampleMonitorData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SampleMonitorData.results</code> property defined at extension <code>yhacext</code>. */
	
	private List<SampleMonitorResultData> results;
	
	public SampleMonitorData()
	{
		// default constructor
	}
	
	public void setResults(final List<SampleMonitorResultData> results)
	{
		this.results = results;
	}

	public List<SampleMonitorResultData> getResults() 
	{
		return results;
	}
	

}