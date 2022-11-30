/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.outboundservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.integrationservices.enums.HttpMethod;
import de.hybris.platform.integrationservices.enums.IntegrationRequestStatus;
import de.hybris.platform.integrationservices.model.MonitoredRequestModel;
import de.hybris.platform.outboundservices.enums.OutboundSource;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OutboundRequest first defined at extension outboundservices.
 */
@SuppressWarnings("all")
public class OutboundRequestModel extends MonitoredRequestModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OutboundRequest";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundRequest.destination</code> attribute defined at extension <code>outboundservices</code>. */
	public static final String DESTINATION = "destination";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundRequest.source</code> attribute defined at extension <code>outboundservices</code>. */
	public static final String SOURCE = "source";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundRequest.error</code> attribute defined at extension <code>outboundservices</code>. */
	public static final String ERROR = "error";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OutboundRequestModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OutboundRequestModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destination initial attribute declared by type <code>OutboundRequest</code> at extension <code>outboundservices</code>
	 * @param _status initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _type initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundRequestModel(final String _destination, final IntegrationRequestStatus _status, final String _type)
	{
		super();
		setDestination(_destination);
		setStatus(_status);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destination initial attribute declared by type <code>OutboundRequest</code> at extension <code>outboundservices</code>
	 * @param _httpMethod initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _sapPassport initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _status initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _type initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 * @param _user initial attribute declared by type <code>MonitoredRequest</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundRequestModel(final String _destination, final HttpMethod _httpMethod, final ItemModel _owner, final String _sapPassport, final IntegrationRequestStatus _status, final String _type, final UserModel _user)
	{
		super();
		setDestination(_destination);
		setHttpMethod(_httpMethod);
		setOwner(_owner);
		setSapPassport(_sapPassport);
		setStatus(_status);
		setType(_type);
		setUser(_user);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundRequest.destination</code> attribute defined at extension <code>outboundservices</code>. 
	 * @return the destination
	 */
	@Accessor(qualifier = "destination", type = Accessor.Type.GETTER)
	public String getDestination()
	{
		return getPersistenceContext().getPropertyValue(DESTINATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundRequest.error</code> attribute defined at extension <code>outboundservices</code>. 
	 * @return the error
	 */
	@Accessor(qualifier = "error", type = Accessor.Type.GETTER)
	public String getError()
	{
		return getPersistenceContext().getPropertyValue(ERROR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundRequest.source</code> attribute defined at extension <code>outboundservices</code>. 
	 * @return the source
	 */
	@Accessor(qualifier = "source", type = Accessor.Type.GETTER)
	public OutboundSource getSource()
	{
		return getPersistenceContext().getPropertyValue(SOURCE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundRequest.destination</code> attribute defined at extension <code>outboundservices</code>. 
	 *  
	 * @param value the destination
	 */
	@Accessor(qualifier = "destination", type = Accessor.Type.SETTER)
	public void setDestination(final String value)
	{
		getPersistenceContext().setPropertyValue(DESTINATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundRequest.error</code> attribute defined at extension <code>outboundservices</code>. 
	 *  
	 * @param value the error
	 */
	@Accessor(qualifier = "error", type = Accessor.Type.SETTER)
	public void setError(final String value)
	{
		getPersistenceContext().setPropertyValue(ERROR, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundRequest.source</code> attribute defined at extension <code>outboundservices</code>. 
	 *  
	 * @param value the source
	 */
	@Accessor(qualifier = "source", type = Accessor.Type.SETTER)
	public void setSource(final OutboundSource value)
	{
		getPersistenceContext().setPropertyValue(SOURCE, value);
	}
	
}
