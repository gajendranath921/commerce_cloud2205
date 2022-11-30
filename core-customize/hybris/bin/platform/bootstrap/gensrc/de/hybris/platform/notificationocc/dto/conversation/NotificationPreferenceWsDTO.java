/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
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
 * Notification preference
 */
@ApiModel(value="notificationPreference", description="Notification preference")
public  class NotificationPreferenceWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** preference channel<br/><br/><i>Generated property</i> for <code>NotificationPreferenceWsDTO.channel</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="channel", value="preference channel", example="email, sms, site_message") 	
	private String channel;

	/** the corresponding value of current channel, for example, for SMS it should be a mobile number; for email it should be an email address<br/><br/><i>Generated property</i> for <code>NotificationPreferenceWsDTO.value</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="value", value="the corresponding value of current channel, for example, for SMS it should be a mobile number; for email it should be an email address") 	
	private String value;

	/** if true, the channel is on; if false, the channel is off<br/><br/><i>Generated property</i> for <code>NotificationPreferenceWsDTO.enabled</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="enabled", value="if true, the channel is on; if false, the channel is off") 	
	private Boolean enabled;

	/** if true, the channel is visible; if false, the channel is invisible<br/><br/><i>Generated property</i> for <code>NotificationPreferenceWsDTO.visible</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="visible", value="if true, the channel is visible; if false, the channel is invisible") 	
	private Boolean visible;
	
	public NotificationPreferenceWsDTO()
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
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	
	public void setEnabled(final Boolean enabled)
	{
		this.enabled = enabled;
	}

	public Boolean getEnabled() 
	{
		return enabled;
	}
	
	public void setVisible(final Boolean visible)
	{
		this.visible = visible;
	}

	public Boolean getVisible() 
	{
		return visible;
	}
	

}