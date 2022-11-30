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
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.outboundsync.model.OutboundSyncStreamConfigurationContainerModel;
import de.hybris.platform.servicelayer.internal.model.ServicelayerJobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OutboundSyncJob first defined at extension outboundsync.
 */
@SuppressWarnings("all")
public class OutboundSyncJobModel extends ServicelayerJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OutboundSyncJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundSyncJob.streamConfigurationContainer</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String STREAMCONFIGURATIONCONTAINER = "streamConfigurationContainer";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OutboundSyncJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OutboundSyncJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _springId initial attribute declared by type <code>OutboundSyncJob</code> at extension <code>outboundsync</code>
	 * @param _streamConfigurationContainer initial attribute declared by type <code>OutboundSyncJob</code> at extension <code>outboundsync</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundSyncJobModel(final String _code, final String _springId, final OutboundSyncStreamConfigurationContainerModel _streamConfigurationContainer)
	{
		super();
		setCode(_code);
		setSpringId(_springId);
		setStreamConfigurationContainer(_streamConfigurationContainer);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _nodeID initial attribute declared by type <code>Job</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _springId initial attribute declared by type <code>OutboundSyncJob</code> at extension <code>outboundsync</code>
	 * @param _streamConfigurationContainer initial attribute declared by type <code>OutboundSyncJob</code> at extension <code>outboundsync</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundSyncJobModel(final String _code, final Integer _nodeID, final ItemModel _owner, final String _springId, final OutboundSyncStreamConfigurationContainerModel _streamConfigurationContainer)
	{
		super();
		setCode(_code);
		setNodeID(_nodeID);
		setOwner(_owner);
		setSpringId(_springId);
		setStreamConfigurationContainer(_streamConfigurationContainer);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundSyncJob.streamConfigurationContainer</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the streamConfigurationContainer
	 */
	@Accessor(qualifier = "streamConfigurationContainer", type = Accessor.Type.GETTER)
	public OutboundSyncStreamConfigurationContainerModel getStreamConfigurationContainer()
	{
		return getPersistenceContext().getPropertyValue(STREAMCONFIGURATIONCONTAINER);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>OutboundSyncJob.streamConfigurationContainer</code> attribute defined at extension <code>outboundsync</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the streamConfigurationContainer
	 */
	@Accessor(qualifier = "streamConfigurationContainer", type = Accessor.Type.SETTER)
	public void setStreamConfigurationContainer(final OutboundSyncStreamConfigurationContainerModel value)
	{
		getPersistenceContext().setPropertyValue(STREAMCONFIGURATIONCONTAINER, value);
	}
	
}
