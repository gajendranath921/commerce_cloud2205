/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.cronjob.enums.DayOfWeek;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class TriggerData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TriggerData.weekInterval</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Integer weekInterval;

	/** <i>Generated property</i> for <code>TriggerData.day</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Integer day;

	/** <i>Generated property</i> for <code>TriggerData.daysOfWeek</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private List<DayOfWeek> daysOfWeek;

	/** <i>Generated property</i> for <code>TriggerData.relative</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Boolean relative;

	/** <i>Generated property</i> for <code>TriggerData.activationTime</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Date activationTime;

	/** <i>Generated property</i> for <code>TriggerData.month</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Integer month;

	/** <i>Generated property</i> for <code>TriggerData.displayTimeTable</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private String displayTimeTable;

	/** <i>Generated property</i> for <code>TriggerData.creationTime</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Date creationTime;

	/** <i>Generated property</i> for <code>TriggerData.hour</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Integer hour;

	/** <i>Generated property</i> for <code>TriggerData.minute</code> property defined at extension <code>b2bacceleratorfacades</code>. */
	
	private Integer minute;
	
	public TriggerData()
	{
		// default constructor
	}
	
	public void setWeekInterval(final Integer weekInterval)
	{
		this.weekInterval = weekInterval;
	}

	public Integer getWeekInterval() 
	{
		return weekInterval;
	}
	
	public void setDay(final Integer day)
	{
		this.day = day;
	}

	public Integer getDay() 
	{
		return day;
	}
	
	public void setDaysOfWeek(final List<DayOfWeek> daysOfWeek)
	{
		this.daysOfWeek = daysOfWeek;
	}

	public List<DayOfWeek> getDaysOfWeek() 
	{
		return daysOfWeek;
	}
	
	public void setRelative(final Boolean relative)
	{
		this.relative = relative;
	}

	public Boolean getRelative() 
	{
		return relative;
	}
	
	public void setActivationTime(final Date activationTime)
	{
		this.activationTime = activationTime;
	}

	public Date getActivationTime() 
	{
		return activationTime;
	}
	
	public void setMonth(final Integer month)
	{
		this.month = month;
	}

	public Integer getMonth() 
	{
		return month;
	}
	
	public void setDisplayTimeTable(final String displayTimeTable)
	{
		this.displayTimeTable = displayTimeTable;
	}

	public String getDisplayTimeTable() 
	{
		return displayTimeTable;
	}
	
	public void setCreationTime(final Date creationTime)
	{
		this.creationTime = creationTime;
	}

	public Date getCreationTime() 
	{
		return creationTime;
	}
	
	public void setHour(final Integer hour)
	{
		this.hour = hour;
	}

	public Integer getHour() 
	{
		return hour;
	}
	
	public void setMinute(final Integer minute)
	{
		this.minute = minute;
	}

	public Integer getMinute() 
	{
		return minute;
	}
	

}