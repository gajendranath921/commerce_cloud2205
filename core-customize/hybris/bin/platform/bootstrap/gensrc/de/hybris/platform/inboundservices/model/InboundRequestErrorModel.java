/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.inboundservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.inboundservices.model.InboundRequestModel;
import de.hybris.platform.integrationservices.model.MonitoredRequestErrorModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type InboundRequestError first defined at extension inboundservices.
 */
@SuppressWarnings("all")
public class InboundRequestErrorModel extends MonitoredRequestErrorModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "InboundRequestError";
	
	/**<i>Generated relation code constant for relation <code>InboundRequest2InboundRequestError</code> defining source attribute <code>inboundRequest</code> in extension <code>inboundservices</code>.</i>*/
	public static final String _INBOUNDREQUEST2INBOUNDREQUESTERROR = "InboundRequest2InboundRequestError";
	
	/** <i>Generated constant</i> - Attribute key of <code>InboundRequestError.inboundRequest</code> attribute defined at extension <code>inboundservices</code>. */
	public static final String INBOUNDREQUEST = "inboundRequest";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public InboundRequestErrorModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public InboundRequestErrorModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>MonitoredRequestError</code> at extension <code>integrationservices</code>
	 * @param _message initial attribute declared by type <code>MonitoredRequestError</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public InboundRequestErrorModel(final String _code, final String _message)
	{
		super();
		setCode(_code);
		setMessage(_message);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>MonitoredRequestError</code> at extension <code>integrationservices</code>
	 * @param _message initial attribute declared by type <code>MonitoredRequestError</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public InboundRequestErrorModel(final String _code, final String _message, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setMessage(_message);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InboundRequestError.inboundRequest</code> attribute defined at extension <code>inboundservices</code>. 
	 * @return the inboundRequest
	 */
	@Accessor(qualifier = "inboundRequest", type = Accessor.Type.GETTER)
	public InboundRequestModel getInboundRequest()
	{
		return getPersistenceContext().getPropertyValue(INBOUNDREQUEST);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>InboundRequestError.inboundRequest</code> attribute defined at extension <code>inboundservices</code>. 
	 *  
	 * @param value the inboundRequest
	 */
	@Accessor(qualifier = "inboundRequest", type = Accessor.Type.SETTER)
	public void setInboundRequest(final InboundRequestModel value)
	{
		getPersistenceContext().setPropertyValue(INBOUNDREQUEST, value);
	}
	
}
