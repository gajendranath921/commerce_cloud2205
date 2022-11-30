/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import de.hybris.platform.b2bwebservicescommons.dto.order.TriggerWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.order.CartWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on Replenishment Order data.
 */
@ApiModel(value="ReplenishmentOrder", description="Request body fields required and optional to operate on Replenishment Order data.")
public  class ReplenishmentOrderWsDTO extends CartWsDTO 

{



	/** Is the Replenishment Order active<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderWsDTO.active</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="active", value="Is the Replenishment Order active", example="Boolean.FALSE") 	
	private Boolean active;

	/** Trigger for the replenishment order<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderWsDTO.trigger</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="trigger", value="Trigger for the replenishment order") 	
	private TriggerWsDTO trigger;

	/** First date of the replenishment order<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderWsDTO.firstDate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="firstDate", value="First date of the replenishment order", example="2020-12-31T09:00:00+0000") 	
	private Date firstDate;

	/** Unique code for the replenishment order<br/><br/><i>Generated property</i> for <code>ReplenishmentOrderWsDTO.replenishmentOrderCode</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="replenishmentOrderCode", value="Unique code for the replenishment order", required=true, example="502BJ") 	
	private String replenishmentOrderCode;
	
	public ReplenishmentOrderWsDTO()
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
	
	public void setTrigger(final TriggerWsDTO trigger)
	{
		this.trigger = trigger;
	}

	public TriggerWsDTO getTrigger() 
	{
		return trigger;
	}
	
	public void setFirstDate(final Date firstDate)
	{
		this.firstDate = firstDate;
	}

	public Date getFirstDate() 
	{
		return firstDate;
	}
	
	public void setReplenishmentOrderCode(final String replenishmentOrderCode)
	{
		this.replenishmentOrderCode = replenishmentOrderCode;
	}

	public String getReplenishmentOrderCode() 
	{
		return replenishmentOrderCode;
	}
	

}