/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.entitlementfacades.data;

import java.io.Serializable;
import de.hybris.platform.entitlementfacades.enums.EntitlementStatus;
import de.hybris.platform.entitlementservices.enums.EntitlementTimeUnit;
import java.util.Collection;
import java.util.Date;


import java.util.Objects;
public  class EntitlementData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>EntitlementData.id</code> property defined at extension <code>entitlementfacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>EntitlementData.name</code> property defined at extension <code>entitlementfacades</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>EntitlementData.description</code> property defined at extension <code>entitlementfacades</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>EntitlementData.timeUnit</code> property defined at extension <code>entitlementfacades</code>. */
	
	private EntitlementTimeUnit timeUnit;

	/** <i>Generated property</i> for <code>EntitlementData.timeUnitStart</code> property defined at extension <code>entitlementfacades</code>. */
	
	private Integer timeUnitStart;

	/** <i>Generated property</i> for <code>EntitlementData.timeUnitDuration</code> property defined at extension <code>entitlementfacades</code>. */
	
	private Integer timeUnitDuration;

	/** <i>Generated property</i> for <code>EntitlementData.conditionString</code> property defined at extension <code>entitlementfacades</code>. */
	
	private String conditionString;

	/** <i>Generated property</i> for <code>EntitlementData.conditionPath</code> property defined at extension <code>entitlementfacades</code>. */
	
	private String conditionPath;

	/** <i>Generated property</i> for <code>EntitlementData.conditionGeo</code> property defined at extension <code>entitlementfacades</code>. */
	
	private Collection<String> conditionGeo;

	/** <i>Generated property</i> for <code>EntitlementData.quantity</code> property defined at extension <code>entitlementfacades</code>. */
	
	private int quantity;

	/** <i>Generated property</i> for <code>EntitlementData.startTime</code> property defined at extension <code>entitlementfacades</code>. */
	
	private Date startTime;

	/** <i>Generated property</i> for <code>EntitlementData.endTime</code> property defined at extension <code>entitlementfacades</code>. */
	
	private Date endTime;

	/** <i>Generated property</i> for <code>EntitlementData.grantTime</code> property defined at extension <code>entitlementfacades</code>. */
	
	private Date grantTime;

	/** <i>Generated property</i> for <code>EntitlementData.status</code> property defined at extension <code>entitlementfacades</code>. */
	
	private EntitlementStatus status;
	
	public EntitlementData()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setTimeUnit(final EntitlementTimeUnit timeUnit)
	{
		this.timeUnit = timeUnit;
	}

	public EntitlementTimeUnit getTimeUnit() 
	{
		return timeUnit;
	}
	
	public void setTimeUnitStart(final Integer timeUnitStart)
	{
		this.timeUnitStart = timeUnitStart;
	}

	public Integer getTimeUnitStart() 
	{
		return timeUnitStart;
	}
	
	public void setTimeUnitDuration(final Integer timeUnitDuration)
	{
		this.timeUnitDuration = timeUnitDuration;
	}

	public Integer getTimeUnitDuration() 
	{
		return timeUnitDuration;
	}
	
	public void setConditionString(final String conditionString)
	{
		this.conditionString = conditionString;
	}

	public String getConditionString() 
	{
		return conditionString;
	}
	
	public void setConditionPath(final String conditionPath)
	{
		this.conditionPath = conditionPath;
	}

	public String getConditionPath() 
	{
		return conditionPath;
	}
	
	public void setConditionGeo(final Collection<String> conditionGeo)
	{
		this.conditionGeo = conditionGeo;
	}

	public Collection<String> getConditionGeo() 
	{
		return conditionGeo;
	}
	
	public void setQuantity(final int quantity)
	{
		this.quantity = quantity;
	}

	public int getQuantity() 
	{
		return quantity;
	}
	
	public void setStartTime(final Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	
	public void setEndTime(final Date endTime)
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	
	public void setGrantTime(final Date grantTime)
	{
		this.grantTime = grantTime;
	}

	public Date getGrantTime() 
	{
		return grantTime;
	}
	
	public void setStatus(final EntitlementStatus status)
	{
		this.status = status;
	}

	public EntitlementStatus getStatus() 
	{
		return status;
	}
	

}