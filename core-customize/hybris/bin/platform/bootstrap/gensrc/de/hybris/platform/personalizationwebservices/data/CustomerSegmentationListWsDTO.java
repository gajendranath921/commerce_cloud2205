/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.CustomerSegmentationData;
import de.hybris.platform.webservicescommons.dto.PaginationWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * List of customer segmentations
 */
@ApiModel(value="CustomerSegmentationList", description="List of customer segmentations")
public  class CustomerSegmentationListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Pagination details<br/><br/><i>Generated property</i> for <code>CustomerSegmentationListWsDTO.pagination</code> property defined at extension <code>personalizationwebservices</code>. */
@ApiModelProperty(name="pagination", value="Pagination details") 	
	private PaginationWsDTO pagination;

	/** List of customer segmentations<br/><br/><i>Generated property</i> for <code>CustomerSegmentationListWsDTO.customerSegmentations</code> property defined at extension <code>personalizationwebservices</code>. */
@ApiModelProperty(name="customerSegmentations", value="List of customer segmentations") 	
	private List<CustomerSegmentationData> customerSegmentations;
	
	public CustomerSegmentationListWsDTO()
	{
		// default constructor
	}
	
	public void setPagination(final PaginationWsDTO pagination)
	{
		this.pagination = pagination;
	}

	public PaginationWsDTO getPagination() 
	{
		return pagination;
	}
	
	public void setCustomerSegmentations(final List<CustomerSegmentationData> customerSegmentations)
	{
		this.customerSegmentations = customerSegmentations;
	}

	public List<CustomerSegmentationData> getCustomerSegmentations() 
	{
		return customerSegmentations;
	}
	

}