/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.order;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Representation of a Trigger
 */
@ApiModel(value="Trigger", description="Representation of a Trigger")
public  class TriggerWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** The time the trigger will be activated<br/><br/><i>Generated property</i> for <code>TriggerWsDTO.activationTime</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="activationTime", value="The time the trigger will be activated", example="2020-12-31T09:00:00+0000") 	
	private Date activationTime;

	/** Description of when the trigger is being activated<br/><br/><i>Generated property</i> for <code>TriggerWsDTO.displayTimeTable</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="displayTimeTable", value="Description of when the trigger is being activated", example="Every Monday at 00:00:00") 	
	private String displayTimeTable;
	
	public TriggerWsDTO()
	{
		// default constructor
	}
	
	public void setActivationTime(final Date activationTime)
	{
		this.activationTime = activationTime;
	}

	public Date getActivationTime() 
	{
		return activationTime;
	}
	
	public void setDisplayTimeTable(final String displayTimeTable)
	{
		this.displayTimeTable = displayTimeTable;
	}

	public String getDisplayTimeTable() 
	{
		return displayTimeTable;
	}
	

}