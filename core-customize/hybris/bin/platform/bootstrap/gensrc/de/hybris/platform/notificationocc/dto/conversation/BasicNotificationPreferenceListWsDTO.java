/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.notificationocc.dto.conversation;

import java.io.Serializable;
import de.hybris.platform.notificationocc.dto.conversation.BasicNotificationPreferenceWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Basic notification preference list
 */
@ApiModel(value="BasicnotificationPreferenceList", description="Basic notification preference list")
public  class BasicNotificationPreferenceListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Basic notification preferences<br/><br/><i>Generated property</i> for <code>BasicNotificationPreferenceListWsDTO.preferences</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="preferences", value="Basic notification preferences") 	
	private List<BasicNotificationPreferenceWsDTO> preferences;
	
	public BasicNotificationPreferenceListWsDTO()
	{
		// default constructor
	}
	
	public void setPreferences(final List<BasicNotificationPreferenceWsDTO> preferences)
	{
		this.preferences = preferences;
	}

	public List<BasicNotificationPreferenceWsDTO> getPreferences() 
	{
		return preferences;
	}
	

}