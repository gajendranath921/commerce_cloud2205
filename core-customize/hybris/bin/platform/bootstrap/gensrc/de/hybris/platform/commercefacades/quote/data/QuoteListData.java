/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.quote.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.quote.data.QuoteData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.search.pagedata.SortData;
import java.util.List;


import java.util.Objects;
public  class QuoteListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>QuoteListData.quotes</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private List<QuoteData> quotes;

	/** <i>Generated property</i> for <code>QuoteListData.sorts</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private List<SortData> sorts;

	/** <i>Generated property</i> for <code>QuoteListData.pagination</code> property defined at extension <code>b2bwebservicescommons</code>. */
	
	private PaginationData pagination;
	
	public QuoteListData()
	{
		// default constructor
	}
	
	public void setQuotes(final List<QuoteData> quotes)
	{
		this.quotes = quotes;
	}

	public List<QuoteData> getQuotes() 
	{
		return quotes;
	}
	
	public void setSorts(final List<SortData> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortData> getSorts() 
	{
		return sorts;
	}
	
	public void setPagination(final PaginationData pagination)
	{
		this.pagination = pagination;
	}

	public PaginationData getPagination() 
	{
		return pagination;
	}
	

}