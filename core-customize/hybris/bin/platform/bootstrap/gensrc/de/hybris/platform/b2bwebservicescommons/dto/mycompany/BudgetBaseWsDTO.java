/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.mycompany;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.storesession.CurrencyWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on Budget data.
		This base bean has no relationship fields to other Org Unit WsDTOs
 */
@ApiModel(value="BudgetBase", description="Request body fields required and optional to operate on Budget data. This base bean has no relationship fields to other Org Unit WsDTOs")
public  class BudgetBaseWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Boolean flag of whether the Budget is active<br/><br/><i>Generated property</i> for <code>BudgetBaseWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="active", value="Boolean flag of whether the Budget is active") 	
	private Boolean active;

	/** Value of Budget<br/><br/><i>Generated property</i> for <code>BudgetBaseWsDTO.budget</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="budget", value="Value of Budget", example="50000") 	
	private BigDecimal budget;

	/** Code of the Budget<br/><br/><i>Generated property</i> for <code>BudgetBaseWsDTO.code</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="code", value="Code of the Budget", example="Monthly_50K_USD") 	
	private String code;

	/** The name of the Budget<br/><br/><i>Generated property</i> for <code>BudgetBaseWsDTO.name</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="name", value="The name of the Budget", example="Monthly 50K USD") 	
	private String name;

	/** Currency of the Budget<br/><br/><i>Generated property</i> for <code>BudgetBaseWsDTO.currency</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="currency", value="Currency of the Budget", example="USD") 	
	private CurrencyWsDTO currency;

	/** The start date of the Budget<br/><br/><i>Generated property</i> for <code>BudgetBaseWsDTO.startDate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="startDate", value="The start date of the Budget", example="2020-11-31T09:00:00+0000") 	
	private Date startDate;

	/** The end date of the Budget<br/><br/><i>Generated property</i> for <code>BudgetBaseWsDTO.endDate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="endDate", value="The end date of the Budget", example="2020-12-31T09:00:00+0000") 	
	private Date endDate;

	/** Boolean flag whether the budget is selected for a cost center<br/><br/><i>Generated property</i> for <code>BudgetBaseWsDTO.selected</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="selected", value="Boolean flag whether the budget is selected for a cost center", example="true") 	
	private Boolean selected;
	
	public BudgetBaseWsDTO()
	{
		// default constructor
	}
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

	public Boolean getActive() 
	{
		return active;
	}
	
	public void setBudget(final BigDecimal budget)
	{
		this.budget = budget;
	}

	public BigDecimal getBudget() 
	{
		return budget;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setCurrency(final CurrencyWsDTO currency)
	{
		this.currency = currency;
	}

	public CurrencyWsDTO getCurrency() 
	{
		return currency;
	}
	
	public void setStartDate(final Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	
	public void setEndDate(final Date endDate)
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	
	public void setSelected(final Boolean selected)
	{
		this.selected = selected;
	}

	public Boolean getSelected() 
	{
		return selected;
	}
	

}