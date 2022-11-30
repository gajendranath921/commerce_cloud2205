/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.messagecentercsfacades.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import de.hybris.platform.messagecentercsfacades.data.ConversationMessageData;
import java.util.Date;


import java.util.Objects;
public  class ConversationData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConversationData.id</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private String id;

	/** <i>Generated property</i> for <code>ConversationData.status</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private String status;

	/** <i>Generated property</i> for <code>ConversationData.agent</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private PrincipalData agent;

	/** <i>Generated property</i> for <code>ConversationData.customer</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private PrincipalData customer;

	/** <i>Generated property</i> for <code>ConversationData.createDate</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private Date createDate;

	/** <i>Generated property</i> for <code>ConversationData.closeDate</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private Date closeDate;

	/** <i>Generated property</i> for <code>ConversationData.latestMessage</code> property defined at extension <code>messagecentercsfacades</code>. */
	
	private ConversationMessageData latestMessage;
	
	public ConversationData()
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
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	public void setAgent(final PrincipalData agent)
	{
		this.agent = agent;
	}

	public PrincipalData getAgent() 
	{
		return agent;
	}
	
	public void setCustomer(final PrincipalData customer)
	{
		this.customer = customer;
	}

	public PrincipalData getCustomer() 
	{
		return customer;
	}
	
	public void setCreateDate(final Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	
	public void setCloseDate(final Date closeDate)
	{
		this.closeDate = closeDate;
	}

	public Date getCloseDate() 
	{
		return closeDate;
	}
	
	public void setLatestMessage(final ConversationMessageData latestMessage)
	{
		this.latestMessage = latestMessage;
	}

	public ConversationMessageData getLatestMessage() 
	{
		return latestMessage;
	}
	

}