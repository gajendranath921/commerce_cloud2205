/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.notificationocc.dto.conversation;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Basic notification preference
 */
@ApiModel(value="BasicnotificationPreference", description="Basic notification preference")
public  class BasicNotificationPreferenceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** preference channel<br/><br/><i>Generated property</i> for <code>BasicNotificationPreferenceWsDTO.channel</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="channel", value="preference channel", example="email, sms, site_message") 	
	private String channel;

	/** if true, the channel is on; if false, the channel is off<br/><br/><i>Generated property</i> for <code>BasicNotificationPreferenceWsDTO.enabled</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="enabled", value="if true, the channel is on; if false, the channel is off") 	
	private Boolean enabled;
	
	public BasicNotificationPreferenceWsDTO()
	{
		// default constructor
	}
	
	public void setChannel(final String channel)
	{
		this.channel = channel;
	}

	public String getChannel() 
	{
		return channel;
	}
	
	public void setEnabled(final Boolean enabled)
	{
		this.enabled = enabled;
	}

	public Boolean getEnabled() 
	{
		return enabled;
	}
	

}