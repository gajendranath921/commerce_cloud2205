/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:09 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.messagecentercsfacades.data;

import java.io.Serializable;
import de.hybris.platform.messagecentercsfacades.data.ConversationMessageData;
import java.util.List;


import java.util.Objects;
public  class ConversationMessageListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConversationMessageListData.conversationId</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private String conversationId;

	/** <i>Generated property</i> for <code>ConversationMessageListData.messages</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private List<ConversationMessageData> messages;
	
	public ConversationMessageListData()
	{
		// default constructor
	}
	
	public void setConversationId(final String conversationId)
	{
		this.conversationId = conversationId;
	}

	public String getConversationId() 
	{
		return conversationId;
	}
	
	public void setMessages(final List<ConversationMessageData> messages)
	{
		this.messages = messages;
	}

	public List<ConversationMessageData> getMessages() 
	{
		return messages;
	}
	

}