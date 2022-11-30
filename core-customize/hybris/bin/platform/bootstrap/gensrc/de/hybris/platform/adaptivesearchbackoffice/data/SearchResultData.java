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
import de.hybris.platform.adaptivesearch.data.AsSearchResultData;
import de.hybris.platform.adaptivesearchbackoffice.data.NavigationContextData;
import de.hybris.platform.adaptivesearchbackoffice.data.SearchContextData;


import java.util.Objects;
public  class SearchResultData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchResultData.navigationContext</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private NavigationContextData navigationContext;

	/** <i>Generated property</i> for <code>SearchResultData.searchContext</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private SearchContextData searchContext;

	/** <i>Generated property</i> for <code>SearchResultData.asSearchResult</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AsSearchResultData asSearchResult;
	
	public SearchResultData()
	{
		// default constructor
	}
	
	public void setNavigationContext(final NavigationContextData navigationContext)
	{
		this.navigationContext = navigationContext;
	}

	public NavigationContextData getNavigationContext() 
	{
		return navigationContext;
	}
	
	public void setSearchContext(final SearchContextData searchContext)
	{
		this.searchContext = searchContext;
	}

	public SearchContextData getSearchContext() 
	{
		return searchContext;
	}
	
	public void setAsSearchResult(final AsSearchResultData asSearchResult)
	{
		this.asSearchResult = asSearchResult;
	}

	public AsSearchResultData getAsSearchResult() 
	{
		return asSearchResult;
	}
	

}