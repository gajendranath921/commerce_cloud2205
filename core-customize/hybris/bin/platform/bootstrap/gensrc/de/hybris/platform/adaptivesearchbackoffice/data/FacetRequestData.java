/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearch.data.AsFacetVisibility;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractSearchRequestData;


import java.util.Objects;
public  class FacetRequestData extends AbstractSearchRequestData 

{



	/** <i>Generated property</i> for <code>FacetRequestData.indexProperty</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String indexProperty;

	/** <i>Generated property</i> for <code>FacetRequestData.open</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean open;

	/** <i>Generated property</i> for <code>FacetRequestData.facetVisibility</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AsFacetVisibility facetVisibility;
	
	public FacetRequestData()
	{
		// default constructor
	}
	
	public void setIndexProperty(final String indexProperty)
	{
		this.indexProperty = indexProperty;
	}

	public String getIndexProperty() 
	{
		return indexProperty;
	}
	
	public void setOpen(final boolean open)
	{
		this.open = open;
	}

	public boolean isOpen() 
	{
		return open;
	}
	
	public void setFacetVisibility(final AsFacetVisibility facetVisibility)
	{
		this.facetVisibility = facetVisibility;
	}

	public AsFacetVisibility getFacetVisibility() 
	{
		return facetVisibility;
	}
	

}