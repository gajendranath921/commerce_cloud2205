/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.messagecentercsocc.dto.conversation;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Conversation message
 */
@ApiModel(value="conversationMessage", description="Conversation message")
public  class ConversationMessageWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** message content<br/><br/><i>Generated property</i> for <code>ConversationMessageWsDTO.content</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="content", value="message content") 	
	private String content;

	/** sent time<br/><br/><i>Generated property</i> for <code>ConversationMessageWsDTO.sentTime</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="sentTime", value="sent time") 	
	private Date sentTime;

	/** the message sender<br/><br/><i>Generated property</i> for <code>ConversationMessageWsDTO.sender</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="sender", value="the message sender") 	
	private PrincipalWsDTO sender;
	
	public ConversationMessageWsDTO()
	{
		// default constructor
	}
	
	public void setContent(final String content)
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	
	public void setSentTime(final Date sentTime)
	{
		this.sentTime = sentTime;
	}

	public Date getSentTime() 
	{
		return sentTime;
	}
	
	public void setSender(final PrincipalWsDTO sender)
	{
		this.sender = sender;
	}

	public PrincipalWsDTO getSender() 
	{
		return sender;
	}
	

}