/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.messagecentercsservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.messagecentercsservices.enums.ConversationStatus;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type Conversation first defined at extension messagecentercsservices.
 */
@SuppressWarnings("all")
public class ConversationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Conversation";
	
	/** <i>Generated constant</i> - Attribute key of <code>Conversation.uid</code> attribute defined at extension <code>messagecentercsservices</code>. */
	public static final String UID = "uid";
	
	/** <i>Generated constant</i> - Attribute key of <code>Conversation.status</code> attribute defined at extension <code>messagecentercsservices</code>. */
	public static final String STATUS = "status";
	
	/** <i>Generated constant</i> - Attribute key of <code>Conversation.agent</code> attribute defined at extension <code>messagecentercsservices</code>. */
	public static final String AGENT = "agent";
	
	/** <i>Generated constant</i> - Attribute key of <code>Conversation.customer</code> attribute defined at extension <code>messagecentercsservices</code>. */
	public static final String CUSTOMER = "customer";
	
	/** <i>Generated constant</i> - Attribute key of <code>Conversation.closeTime</code> attribute defined at extension <code>messagecentercsservices</code>. */
	public static final String CLOSETIME = "closeTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>Conversation.messages</code> attribute defined at extension <code>messagecentercsservices</code>. */
	public static final String MESSAGES = "messages";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ConversationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ConversationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _customer initial attribute declared by type <code>Conversation</code> at extension <code>messagecentercsservices</code>
	 * @param _messages initial attribute declared by type <code>Conversation</code> at extension <code>messagecentercsservices</code>
	 * @param _uid initial attribute declared by type <code>Conversation</code> at extension <code>messagecentercsservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConversationModel(final CustomerModel _customer, final String _messages, final String _uid)
	{
		super();
		setCustomer(_customer);
		setMessages(_messages);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _customer initial attribute declared by type <code>Conversation</code> at extension <code>messagecentercsservices</code>
	 * @param _messages initial attribute declared by type <code>Conversation</code> at extension <code>messagecentercsservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Conversation</code> at extension <code>messagecentercsservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public ConversationModel(final CustomerModel _customer, final String _messages, final ItemModel _owner, final String _uid)
	{
		super();
		setCustomer(_customer);
		setMessages(_messages);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Conversation.agent</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 * @return the agent
	 */
	@Accessor(qualifier = "agent", type = Accessor.Type.GETTER)
	public EmployeeModel getAgent()
	{
		return getPersistenceContext().getPropertyValue(AGENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Conversation.closeTime</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 * @return the closeTime
	 */
	@Accessor(qualifier = "closeTime", type = Accessor.Type.GETTER)
	public Date getCloseTime()
	{
		return getPersistenceContext().getPropertyValue(CLOSETIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Conversation.customer</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 * @return the customer
	 */
	@Accessor(qualifier = "customer", type = Accessor.Type.GETTER)
	public CustomerModel getCustomer()
	{
		return getPersistenceContext().getPropertyValue(CUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Conversation.messages</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 * @return the messages
	 */
	@Accessor(qualifier = "messages", type = Accessor.Type.GETTER)
	public String getMessages()
	{
		return getPersistenceContext().getPropertyValue(MESSAGES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Conversation.status</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 * @return the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.GETTER)
	public ConversationStatus getStatus()
	{
		return getPersistenceContext().getPropertyValue(STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Conversation.uid</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 * @return the uid
	 */
	@Accessor(qualifier = "uid", type = Accessor.Type.GETTER)
	public String getUid()
	{
		return getPersistenceContext().getPropertyValue(UID);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Conversation.agent</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 *  
	 * @param value the agent
	 */
	@Accessor(qualifier = "agent", type = Accessor.Type.SETTER)
	public void setAgent(final EmployeeModel value)
	{
		getPersistenceContext().setPropertyValue(AGENT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Conversation.closeTime</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 *  
	 * @param value the closeTime
	 */
	@Accessor(qualifier = "closeTime", type = Accessor.Type.SETTER)
	public void setCloseTime(final Date value)
	{
		getPersistenceContext().setPropertyValue(CLOSETIME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Conversation.customer</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 *  
	 * @param value the customer
	 */
	@Accessor(qualifier = "customer", type = Accessor.Type.SETTER)
	public void setCustomer(final CustomerModel value)
	{
		getPersistenceContext().setPropertyValue(CUSTOMER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Conversation.messages</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 *  
	 * @param value the messages
	 */
	@Accessor(qualifier = "messages", type = Accessor.Type.SETTER)
	public void setMessages(final String value)
	{
		getPersistenceContext().setPropertyValue(MESSAGES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Conversation.status</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 *  
	 * @param value the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.SETTER)
	public void setStatus(final ConversationStatus value)
	{
		getPersistenceContext().setPropertyValue(STATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Conversation.uid</code> attribute defined at extension <code>messagecentercsservices</code>. 
	 *  
	 * @param value the uid
	 */
	@Accessor(qualifier = "uid", type = Accessor.Type.SETTER)
	public void setUid(final String value)
	{
		getPersistenceContext().setPropertyValue(UID, value);
	}
	
}
