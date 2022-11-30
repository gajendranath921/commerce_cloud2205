/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.customercouponocc.dto;

import java.io.Serializable;
import de.hybris.platform.customercouponocc.dto.CustomerCouponWsDTO;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import de.hybris.platform.webservicescommons.dto.SortWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Customer coupon search result
 */
@ApiModel(value="CustomerCouponSearchResult", description="Customer coupon search result")
public  class CustomerCouponSearchResultWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of coupon<br/><br/><i>Generated property</i> for <code>CustomerCouponSearchResultWsDTO.coupons</code> property defined at extension <code>customercouponocc</code>. */
@ApiModelProperty(name="coupons", value="List of coupon") 	
	private List<CustomerCouponWsDTO> coupons;

	/** Sorting information<br/><br/><i>Generated property</i> for <code>CustomerCouponSearchResultWsDTO.sorts</code> property defined at extension <code>customercouponocc</code>. */
@ApiModelProperty(name="sorts", value="Sorting information") 	
	private List<SortWsDTO> sorts;

	/** Pagination information<br/><br/><i>Generated property</i> for <code>CustomerCouponSearchResultWsDTO.pagination</code> property defined at extension <code>customercouponocc</code>. */
@ApiModelProperty(name="pagination", value="Pagination information") 	
	private PaginationWsDTO pagination;
	
	public CustomerCouponSearchResultWsDTO()
	{
		// default constructor
	}
	
	public void setCoupons(final List<CustomerCouponWsDTO> coupons)
	{
		this.coupons = coupons;
	}

	public List<CustomerCouponWsDTO> getCoupons() 
	{
		return coupons;
	}
	
	public void setSorts(final List<SortWsDTO> sorts)
	{
		this.sorts = sorts;
	}

	public List<SortWsDTO> getSorts() 
	{
		return sorts;
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	

}