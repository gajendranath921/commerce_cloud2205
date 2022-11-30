/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.messagecentercsfacades.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import java.util.Date;


import java.util.Objects;
public  class ConversationMessageData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConversationMessageData.content</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private String content;

	/** <i>Generated property</i> for <code>ConversationMessageData.sentTime</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private Date sentTime;

	/** <i>Generated property</i> for <code>ConversationMessageData.sender</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private PrincipalData sender;
	
	public ConversationMessageData()
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
	
	public void setSender(final PrincipalData sender)
	{
		this.sender = sender;
	}

	public PrincipalData getSender() 
	{
		return sender;
	}
	

}