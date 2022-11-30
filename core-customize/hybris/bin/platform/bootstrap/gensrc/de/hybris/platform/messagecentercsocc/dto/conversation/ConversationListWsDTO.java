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
import de.hybris.platform.messagecentercsocc.dto.conversation.ConversationWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Conversation list
 */
@ApiModel(value="conversationList", description="Conversation list")
public  class ConversationListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** conversation data<br/><br/><i>Generated property</i> for <code>ConversationListWsDTO.conversations</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="conversations", value="conversation data") 	
	private List<ConversationWsDTO> conversations;
	
	public ConversationListWsDTO()
	{
		// default constructor
	}
	
	public void setConversations(final List<ConversationWsDTO> conversations)
	{
		this.conversations = conversations;
	}

	public List<ConversationWsDTO> getConversations() 
	{
		return conversations;
	}
	

}