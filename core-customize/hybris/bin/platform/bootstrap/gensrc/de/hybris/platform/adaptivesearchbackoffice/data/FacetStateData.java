/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearch.data.AsFacetVisibility;


import java.util.Objects;
public  class FacetStateData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FacetStateData.facetVisibility</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AsFacetVisibility facetVisibility;
	
	public FacetStateData()
	{
		// default constructor
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