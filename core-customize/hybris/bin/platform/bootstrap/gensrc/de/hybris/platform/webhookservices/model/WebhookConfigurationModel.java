/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.webhookservices.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.apiregistryservices.model.ConsumedDestinationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type WebhookConfiguration first defined at extension webhookservices.
 * <p>
 * Configures how a webhook reacts to an event by specifying an event, an Integration Object to
 *                 transform the event to, and the destination to send the payload.
 */
@SuppressWarnings("all")
public class WebhookConfigurationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "WebhookConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>WebhookConfiguration.eventType</code> attribute defined at extension <code>webhookservices</code>. */
	public static final String EVENTTYPE = "eventType";
	
	/** <i>Generated constant</i> - Attribute key of <code>WebhookConfiguration.integrationObject</code> attribute defined at extension <code>webhookservices</code>. */
	public static final String INTEGRATIONOBJECT = "integrationObject";
	
	/** <i>Generated constant</i> - Attribute key of <code>WebhookConfiguration.destination</code> attribute defined at extension <code>webhookservices</code>. */
	public static final String DESTINATION = "destination";
	
	/** <i>Generated constant</i> - Attribute key of <code>WebhookConfiguration.filterLocation</code> attribute defined at extension <code>webhookservices</code>. */
	public static final String FILTERLOCATION = "filterLocation";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public WebhookConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public WebhookConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destination initial attribute declared by type <code>WebhookConfiguration</code> at extension <code>webhookservices</code>
	 * @param _integrationObject initial attribute declared by type <code>WebhookConfiguration</code> at extension <code>webhookservices</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public WebhookConfigurationModel(final ConsumedDestinationModel _destination, final IntegrationObjectModel _integrationObject)
	{
		super();
		setDestination(_destination);
		setIntegrationObject(_integrationObject);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _destination initial attribute declared by type <code>WebhookConfiguration</code> at extension <code>webhookservices</code>
	 * @param _integrationObject initial attribute declared by type <code>WebhookConfiguration</code> at extension <code>webhookservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public WebhookConfigurationModel(final ConsumedDestinationModel _destination, final IntegrationObjectModel _integrationObject, final ItemModel _owner)
	{
		super();
		setDestination(_destination);
		setIntegrationObject(_integrationObject);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>WebhookConfiguration.destination</code> attribute defined at extension <code>webhookservices</code>. 
	 * @return the destination - The destination this WebhookConfiguration is to send the payload
	 */
	@Accessor(qualifier = "destination", type = Accessor.Type.GETTER)
	public ConsumedDestinationModel getDestination()
	{
		return getPersistenceContext().getPropertyValue(DESTINATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>WebhookConfiguration.eventType</code> attribute defined at extension <code>webhookservices</code>. 
	 * @return the eventType - The event this WebhookConfiguration responds to
	 */
	@Accessor(qualifier = "eventType", type = Accessor.Type.GETTER)
	public String getEventType()
	{
		return getPersistenceContext().getPropertyValue(EVENTTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>WebhookConfiguration.filterLocation</code> attribute defined at extension <code>webhookservices</code>. 
	 * @return the filterLocation - Specifies the URI of the filter logic. For example, script://orderFilter.
	 */
	@Accessor(qualifier = "filterLocation", type = Accessor.Type.GETTER)
	public String getFilterLocation()
	{
		return getPersistenceContext().getPropertyValue(FILTERLOCATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>WebhookConfiguration.integrationObject</code> attribute defined at extension <code>webhookservices</code>. 
	 * @return the integrationObject - The IntegrationObject this WebhookConfiguration is to use when sending the payload
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.GETTER)
	public IntegrationObjectModel getIntegrationObject()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>WebhookConfiguration.destination</code> attribute defined at extension <code>webhookservices</code>. 
	 *  
	 * @param value the destination - The destination this WebhookConfiguration is to send the payload
	 */
	@Accessor(qualifier = "destination", type = Accessor.Type.SETTER)
	public void setDestination(final ConsumedDestinationModel value)
	{
		getPersistenceContext().setPropertyValue(DESTINATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>WebhookConfiguration.eventType</code> attribute defined at extension <code>webhookservices</code>. 
	 *  
	 * @param value the eventType - The event this WebhookConfiguration responds to
	 */
	@Accessor(qualifier = "eventType", type = Accessor.Type.SETTER)
	public void setEventType(final String value)
	{
		getPersistenceContext().setPropertyValue(EVENTTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>WebhookConfiguration.filterLocation</code> attribute defined at extension <code>webhookservices</code>. 
	 *  
	 * @param value the filterLocation - Specifies the URI of the filter logic. For example, script://orderFilter.
	 */
	@Accessor(qualifier = "filterLocation", type = Accessor.Type.SETTER)
	public void setFilterLocation(final String value)
	{
		getPersistenceContext().setPropertyValue(FILTERLOCATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>WebhookConfiguration.integrationObject</code> attribute defined at extension <code>webhookservices</code>. 
	 *  
	 * @param value the integrationObject - The IntegrationObject this WebhookConfiguration is to use when sending the payload
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.SETTER)
	public void setIntegrationObject(final IntegrationObjectModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECT, value);
	}
	
}
