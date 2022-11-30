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
import de.hybris.platform.apiregistryservices.model.ExposedDestinationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.enums.AuthenticationType;
import de.hybris.platform.integrationservices.model.IntegrationObjectModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type InboundChannelConfiguration first defined at extension integrationservices.
 * <p>
 * Relates an Integration Object to an Authentication Type.
 */
@SuppressWarnings("all")
public class InboundChannelConfigurationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "InboundChannelConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>InboundChannelConfiguration.integrationObject</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String INTEGRATIONOBJECT = "integrationObject";
	
	/** <i>Generated constant</i> - Attribute key of <code>InboundChannelConfiguration.authenticationType</code> attribute defined at extension <code>integrationservices</code>. */
	public static final String AUTHENTICATIONTYPE = "authenticationType";
	
	/** <i>Generated constant</i> - Attribute key of <code>InboundChannelConfiguration.exposedDestinations</code> attribute defined at extension <code>inboundservices</code>. */
	public static final String EXPOSEDDESTINATIONS = "exposedDestinations";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public InboundChannelConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public InboundChannelConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _integrationObject initial attribute declared by type <code>InboundChannelConfiguration</code> at extension <code>integrationservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public InboundChannelConfigurationModel(final IntegrationObjectModel _integrationObject)
	{
		super();
		setIntegrationObject(_integrationObject);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _integrationObject initial attribute declared by type <code>InboundChannelConfiguration</code> at extension <code>integrationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public InboundChannelConfigurationModel(final IntegrationObjectModel _integrationObject, final ItemModel _owner)
	{
		super();
		setIntegrationObject(_integrationObject);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InboundChannelConfiguration.authenticationType</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the authenticationType - Type of authentication for an integration object in an Inbound request, which can be of
	 *                         a type defined in the AuthenticationType Enum
	 */
	@Accessor(qualifier = "authenticationType", type = Accessor.Type.GETTER)
	public AuthenticationType getAuthenticationType()
	{
		return getPersistenceContext().getPropertyValue(AUTHENTICATIONTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InboundChannelConfiguration.exposedDestinations</code> attribute defined at extension <code>inboundservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the exposedDestinations
	 */
	@Accessor(qualifier = "exposedDestinations", type = Accessor.Type.GETTER)
	public List<ExposedDestinationModel> getExposedDestinations()
	{
		return getPersistenceContext().getPropertyValue(EXPOSEDDESTINATIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>InboundChannelConfiguration.integrationObject</code> attribute defined at extension <code>integrationservices</code>. 
	 * @return the integrationObject - Integration Object configured with authentication for an Inbound Request
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.GETTER)
	public IntegrationObjectModel getIntegrationObject()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>InboundChannelConfiguration.authenticationType</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the authenticationType - Type of authentication for an integration object in an Inbound request, which can be of
	 *                         a type defined in the AuthenticationType Enum
	 */
	@Accessor(qualifier = "authenticationType", type = Accessor.Type.SETTER)
	public void setAuthenticationType(final AuthenticationType value)
	{
		getPersistenceContext().setPropertyValue(AUTHENTICATIONTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>InboundChannelConfiguration.exposedDestinations</code> attribute defined at extension <code>inboundservices</code>. 
	 *  
	 * @param value the exposedDestinations
	 */
	@Accessor(qualifier = "exposedDestinations", type = Accessor.Type.SETTER)
	public void setExposedDestinations(final List<ExposedDestinationModel> value)
	{
		getPersistenceContext().setPropertyValue(EXPOSEDDESTINATIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>InboundChannelConfiguration.integrationObject</code> attribute defined at extension <code>integrationservices</code>. 
	 *  
	 * @param value the integrationObject - Integration Object configured with authentication for an Inbound Request
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.SETTER)
	public void setIntegrationObject(final IntegrationObjectModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECT, value);
	}
	
}
