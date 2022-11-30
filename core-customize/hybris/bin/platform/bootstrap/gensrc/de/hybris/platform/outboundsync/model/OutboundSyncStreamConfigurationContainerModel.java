/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Nov-2022, 4:57:05 pm                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.outboundsync.model;

import de.hybris.deltadetection.model.StreamConfigurationContainerModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OutboundSyncStreamConfigurationContainer first defined at extension outboundsync.
 */
@SuppressWarnings("all")
public class OutboundSyncStreamConfigurationContainerModel extends StreamConfigurationContainerModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OutboundSyncStreamConfigurationContainer";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OutboundSyncStreamConfigurationContainerModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OutboundSyncStreamConfigurationContainerModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>StreamConfigurationContainer</code> at extension <code>deltadetection</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundSyncStreamConfigurationContainerModel(final String _id)
	{
		super();
		setId(_id);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _id initial attribute declared by type <code>StreamConfigurationContainer</code> at extension <code>deltadetection</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundSyncStreamConfigurationContainerModel(final String _id, final ItemModel _owner)
	{
		super();
		setId(_id);
		setOwner(_owner);
	}
	
	
}
