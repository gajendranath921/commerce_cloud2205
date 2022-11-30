/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.messagecentercsocc.dto.conversation;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import de.hybris.platform.messagecentercsocc.dto.conversation.ConversationMessageWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Conversation
 */
@ApiModel(value="conversation", description="Conversation")
public  class ConversationWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** conversation identifier<br/><br/><i>Generated property</i> for <code>ConversationWsDTO.id</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="id", value="conversation identifier") 	
	private String id;

	/** conversation status<br/><br/><i>Generated property</i> for <code>ConversationWsDTO.status</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="status", value="conversation status") 	
	private String status;

	/** the agent of conversation<br/><br/><i>Generated property</i> for <code>ConversationWsDTO.agent</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="agent", value="the agent of conversation") 	
	private PrincipalWsDTO agent;

	/** the customer of conversation<br/><br/><i>Generated property</i> for <code>ConversationWsDTO.customer</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="customer", value="the customer of conversation") 	
	private PrincipalWsDTO customer;

	/** create date<br/><br/><i>Generated property</i> for <code>ConversationWsDTO.createDate</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="createDate", value="create date") 	
	private Date createDate;

	/** close date<br/><br/><i>Generated property</i> for <code>ConversationWsDTO.closeDate</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="closeDate", value="close date") 	
	private Date closeDate;

	/** the latest message of the conversation<br/><br/><i>Generated property</i> for <code>ConversationWsDTO.latestMessage</code> property defined at extension <code>messagecentercsocc</code>. */
@ApiModelProperty(name="latestMessage", value="the latest message of the conversation") 	
	private ConversationMessageWsDTO latestMessage;
	
	public ConversationWsDTO()
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
	
	public void setAgent(final PrincipalWsDTO agent)
	{
		this.agent = agent;
	}

	public PrincipalWsDTO getAgent() 
	{
		return agent;
	}
	
	public void setCustomer(final PrincipalWsDTO customer)
	{
		this.customer = customer;
	}

	public PrincipalWsDTO getCustomer() 
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
	
	public void setLatestMessage(final ConversationMessageWsDTO latestMessage)
	{
		this.latestMessage = latestMessage;
	}

	public ConversationMessageWsDTO getLatestMessage() 
	{
		return latestMessage;
	}
	

}