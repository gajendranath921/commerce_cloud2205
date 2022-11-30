/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.integrationservices.enums.HttpMethod;
import de.hybris.platform.integrationservices.enums.IntegrationRequestStatus;
import de.hybris.platform.integrationservices.model.IntegrationApiMediaModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type MonitoredRequest first defined at extension integrationservices.
 */
@SuppressWarnings("all")
public class MonitoredRequestModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "MonitoredRequest";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.status</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String STATUS = "status";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.integrationKey</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONKEY = "integrationKey";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.type</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.payload</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String PAYLOAD = "payload";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.messageId</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String MESSAGEID = "messageId";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.user</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String USER = "user";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.sapPassport</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String SAPPASSPORT = "sapPassport";
	
	/** <i>Generated constant</i> - Attribute key of <code>MonitoredRequest.httpMethod</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String HTTPMETHOD = "httpMethod";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public MonitoredRequestModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public MonitoredRequestModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _status initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _type initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MonitoredRequestModel(final IntegrationRequestStatus _status, final String _type)
	{
		super();
		setStatus(_status);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _httpMethod initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _sapPassport initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _status initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _type initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _user initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public MonitoredRequestModel(final HttpMethod _httpMethod, final ItemModel _owner, final String _sapPassport, final IntegrationRequestStatus _status, final String _type, final UserModel _user)
	{
		super();
		setHttpMethod(_httpMethod);
		setOwner(_owner);
		setSapPassport(_sapPassport);
		setStatus(_status);
		setType(_type);
		setUser(_user);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.httpMethod</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the httpMethod - Indicates what HTTP method was used for the request
	 */
	@Accessor(qualifier = "httpMethod", type = Accessor.Type.GETTER)
	public HttpMethod getHttpMethod()
	{
		return getPersistenceContext().getPropertyValue(HTTPMETHOD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.integrationKey</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationKey
	 */
	@Accessor(qualifier = "integrationKey", type = Accessor.Type.GETTER)
	public String getIntegrationKey()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONKEY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.messageId</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the messageId
	 */
	@Accessor(qualifier = "messageId", type = Accessor.Type.GETTER)
	public String getMessageId()
	{
		return getPersistenceContext().getPropertyValue(MESSAGEID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.payload</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the payload
	 */
	@Accessor(qualifier = "payload", type = Accessor.Type.GETTER)
	public IntegrationApiMediaModel getPayload()
	{
		return getPersistenceContext().getPropertyValue(PAYLOAD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.sapPassport</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the sapPassport
	 */
	@Accessor(qualifier = "sapPassport", type = Accessor.Type.GETTER)
	public String getSapPassport()
	{
		return getPersistenceContext().getPropertyValue(SAPPASSPORT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.status</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.GETTER)
	public IntegrationRequestStatus getStatus()
	{
		return getPersistenceContext().getPropertyValue(STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.type</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public String getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MonitoredRequest.user</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.GETTER)
	public UserModel getUser()
	{
		return getPersistenceContext().getPropertyValue(USER);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>MonitoredRequest.httpMethod</code> attribute defined at extension <code>integrationservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the httpMethod - Indicates what HTTP method was used for the request
	 */
	@Accessor(qualifier = "httpMethod", type = Accessor.Type.SETTER)
	public void setHttpMethod(final HttpMethod value)
	{
		getPersistenceContext().setPropertyValue(HTTPMETHOD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.integrationKey</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationKey
	 */
	@Accessor(qualifier = "integrationKey", type = Accessor.Type.SETTER)
	public void setIntegrationKey(final String value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONKEY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.messageId</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the messageId
	 */
	@Accessor(qualifier = "messageId", type = Accessor.Type.SETTER)
	public void setMessageId(final String value)
	{
		getPersistenceContext().setPropertyValue(MESSAGEID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.payload</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the payload
	 */
	@Accessor(qualifier = "payload", type = Accessor.Type.SETTER)
	public void setPayload(final IntegrationApiMediaModel value)
	{
		getPersistenceContext().setPropertyValue(PAYLOAD, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>MonitoredRequest.sapPassport</code> attribute defined at extension <code>integrationservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the sapPassport
	 */
	@Accessor(qualifier = "sapPassport", type = Accessor.Type.SETTER)
	public void setSapPassport(final String value)
	{
		getPersistenceContext().setPropertyValue(SAPPASSPORT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.status</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.SETTER)
	public void setStatus(final IntegrationRequestStatus value)
	{
		getPersistenceContext().setPropertyValue(STATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>MonitoredRequest.type</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final String value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>MonitoredRequest.user</code> attribute defined at extension <code>integrationservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.SETTER)
	public void setUser(final UserModel value)
	{
		getPersistenceContext().setPropertyValue(USER, value);
	}
	
}
