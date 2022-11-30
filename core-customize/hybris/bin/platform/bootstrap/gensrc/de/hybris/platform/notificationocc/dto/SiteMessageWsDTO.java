/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.notificationocc.dto;

import java.io.Serializable;
import de.hybris.platform.notificationservices.enums.NotificationType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Site message
 */
@ApiModel(value="siteMessage", description="Site message")
public  class SiteMessageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** message uid<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.uid</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="uid", value="message uid") 	
	private String uid;

	/** message subject<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.subject</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="subject", value="message subject") 	
	private String subject;

	/** message body<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.body</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="body", value="message body") 	
	private String body;

	/** notification type used for this message<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.notificationType</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="notificationType", value="notification type used for this message") 	
	private NotificationType notificationType;

	/** sent date<br/><br/><i>Generated property</i> for <code>SiteMessageWsDTO.sentDate</code> property defined at extension <code>notificationocc</code>. */
@ApiModelProperty(name="sentDate", value="sent date") 	
	private Date sentDate;
	
	public SiteMessageWsDTO()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	
	public void setBody(final String body)
	{
		this.body = body;
	}

	public String getBody() 
	{
		return body;
	}
	
	public void setNotificationType(final NotificationType notificationType)
	{
		this.notificationType = notificationType;
	}

	public NotificationType getNotificationType() 
	{
		return notificationType;
	}
	
	public void setSentDate(final Date sentDate)
	{
		this.sentDate = sentDate;
	}

	public Date getSentDate() 
	{
		return sentDate;
	}
	

}