/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.outboundsync.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.apiregistryservices.model.ConsumedDestinationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OutboundChannelConfiguration first defined at extension outboundsync.
 * <p>
 * Relates an Integration Object to a destination.
 */
@SuppressWarnings("all")
public class OutboundChannelConfigurationModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OutboundChannelConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundChannelConfiguration.code</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundChannelConfiguration.integrationObject</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String INTEGRATIONOBJECT = "integrationObject";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundChannelConfiguration.destination</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String DESTINATION = "destination";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundChannelConfiguration.autoGenerate</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String AUTOGENERATE = "autoGenerate";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundChannelConfiguration.synchronizeDelete</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String SYNCHRONIZEDELETE = "synchronizeDelete";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OutboundChannelConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OutboundChannelConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>OutboundChannelConfiguration</code> at extension <code>outboundsync</code>
	 * @param _destination initial attribute declared by type <code>OutboundChannelConfiguration</code> at extension <code>outboundsync</code>
	 * @param _integrationObject initial attribute declared by type <code>OutboundChannelConfiguration</code> at extension <code>outboundsync</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundChannelConfigurationModel(final String _code, final ConsumedDestinationModel _destination, final IntegrationObjectModel _integrationObject)
	{
		super();
		setCode(_code);
		setDestination(_destination);
		setIntegrationObject(_integrationObject);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>OutboundChannelConfiguration</code> at extension <code>outboundsync</code>
	 * @param _destination initial attribute declared by type <code>OutboundChannelConfiguration</code> at extension <code>outboundsync</code>
	 * @param _integrationObject initial attribute declared by type <code>OutboundChannelConfiguration</code> at extension <code>outboundsync</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundChannelConfigurationModel(final String _code, final ConsumedDestinationModel _destination, final IntegrationObjectModel _integrationObject, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setDestination(_destination);
		setIntegrationObject(_integrationObject);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundChannelConfiguration.autoGenerate</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the autoGenerate - Identifies whether or not additional outboundsync configuration will automatically generate when
	 *                         this
	 *                         {@code OutboundChannelConfiguration} is created.
	 */
	@Accessor(qualifier = "autoGenerate", type = Accessor.Type.GETTER)
	public Boolean getAutoGenerate()
	{
		return getPersistenceContext().getPropertyValue(AUTOGENERATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundChannelConfiguration.code</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the code - The unique value that represents this outbound scenario
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundChannelConfiguration.destination</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the destination - Destination where the Integration Object will be sent for this outbound scenario
	 */
	@Accessor(qualifier = "destination", type = Accessor.Type.GETTER)
	public ConsumedDestinationModel getDestination()
	{
		return getPersistenceContext().getPropertyValue(DESTINATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundChannelConfiguration.integrationObject</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the integrationObject - Integration Object to be sent for this outbound scenario
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.GETTER)
	public IntegrationObjectModel getIntegrationObject()
	{
		return getPersistenceContext().getPropertyValue(INTEGRATIONOBJECT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundChannelConfiguration.synchronizeDelete</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the synchronizeDelete - Determines whether deleted items will be synchronized through this channel. If value is true,
	 *                         deleted items will be sent to an external system as DELETE requests, otherwise item deletions
	 *                         will be ignored. Default value is false.
	 */
	@Accessor(qualifier = "synchronizeDelete", type = Accessor.Type.GETTER)
	public Boolean getSynchronizeDelete()
	{
		return getPersistenceContext().getPropertyValue(SYNCHRONIZEDELETE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundChannelConfiguration.autoGenerate</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the autoGenerate - Identifies whether or not additional outboundsync configuration will automatically generate when
	 *                         this
	 *                         {@code OutboundChannelConfiguration} is created.
	 */
	@Accessor(qualifier = "autoGenerate", type = Accessor.Type.SETTER)
	public void setAutoGenerate(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(AUTOGENERATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundChannelConfiguration.code</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the code - The unique value that represents this outbound scenario
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundChannelConfiguration.destination</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the destination - Destination where the Integration Object will be sent for this outbound scenario
	 */
	@Accessor(qualifier = "destination", type = Accessor.Type.SETTER)
	public void setDestination(final ConsumedDestinationModel value)
	{
		getPersistenceContext().setPropertyValue(DESTINATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundChannelConfiguration.integrationObject</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the integrationObject - Integration Object to be sent for this outbound scenario
	 */
	@Accessor(qualifier = "integrationObject", type = Accessor.Type.SETTER)
	public void setIntegrationObject(final IntegrationObjectModel value)
	{
		getPersistenceContext().setPropertyValue(INTEGRATIONOBJECT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundChannelConfiguration.synchronizeDelete</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the synchronizeDelete - Determines whether deleted items will be synchronized through this channel. If value is true,
	 *                         deleted items will be sent to an external system as DELETE requests, otherwise item deletions
	 *                         will be ignored. Default value is false.
	 */
	@Accessor(qualifier = "synchronizeDelete", type = Accessor.Type.SETTER)
	public void setSynchronizeDelete(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(SYNCHRONIZEDELETE, value);
	}
	
}
