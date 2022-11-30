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
import de.hybris.deltadetection.model.StreamConfigurationContainerModel;
import de.hybris.deltadetection.model.StreamConfigurationModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.outboundsync.model.OutboundChannelConfigurationModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OutboundSyncStreamConfiguration first defined at extension outboundsync.
 */
@SuppressWarnings("all")
public class OutboundSyncStreamConfigurationModel extends StreamConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OutboundSyncStreamConfiguration";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundSyncStreamConfiguration.outboundChannelConfiguration</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String OUTBOUNDCHANNELCONFIGURATION = "outboundChannelConfiguration";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OutboundSyncStreamConfigurationModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OutboundSyncStreamConfigurationModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _container initial attribute declared by type <code>StreamConfiguration</code> at extension <code>deltadetection</code>
	 * @param _itemTypeForStream initial attribute declared by type <code>StreamConfiguration</code> at extension <code>deltadetection</code>
	 * @param _outboundChannelConfiguration initial attribute declared by type <code>OutboundSyncStreamConfiguration</code> at extension <code>outboundsync</code>
	 * @param _streamId initial attribute declared by type <code>StreamConfiguration</code> at extension <code>deltadetection</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundSyncStreamConfigurationModel(final StreamConfigurationContainerModel _container, final ComposedTypeModel _itemTypeForStream, final OutboundChannelConfigurationModel _outboundChannelConfiguration, final String _streamId)
	{
		super();
		setContainer(_container);
		setItemTypeForStream(_itemTypeForStream);
		setOutboundChannelConfiguration(_outboundChannelConfiguration);
		setStreamId(_streamId);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _container initial attribute declared by type <code>StreamConfiguration</code> at extension <code>deltadetection</code>
	 * @param _itemTypeForStream initial attribute declared by type <code>StreamConfiguration</code> at extension <code>deltadetection</code>
	 * @param _outboundChannelConfiguration initial attribute declared by type <code>OutboundSyncStreamConfiguration</code> at extension <code>outboundsync</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _streamId initial attribute declared by type <code>StreamConfiguration</code> at extension <code>deltadetection</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundSyncStreamConfigurationModel(final StreamConfigurationContainerModel _container, final ComposedTypeModel _itemTypeForStream, final OutboundChannelConfigurationModel _outboundChannelConfiguration, final ItemModel _owner, final String _streamId)
	{
		super();
		setContainer(_container);
		setItemTypeForStream(_itemTypeForStream);
		setOutboundChannelConfiguration(_outboundChannelConfiguration);
		setOwner(_owner);
		setStreamId(_streamId);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundSyncStreamConfiguration.outboundChannelConfiguration</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the outboundChannelConfiguration
	 */
	@Accessor(qualifier = "outboundChannelConfiguration", type = Accessor.Type.GETTER)
	public OutboundChannelConfigurationModel getOutboundChannelConfiguration()
	{
		return getPersistenceContext().getPropertyValue(OUTBOUNDCHANNELCONFIGURATION);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundSyncStreamConfiguration.outboundChannelConfiguration</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the outboundChannelConfiguration
	 */
	@Accessor(qualifier = "outboundChannelConfiguration", type = Accessor.Type.SETTER)
	public void setOutboundChannelConfiguration(final OutboundChannelConfigurationModel value)
	{
		getPersistenceContext().setPropertyValue(OUTBOUNDCHANNELCONFIGURATION, value);
	}
	
}
