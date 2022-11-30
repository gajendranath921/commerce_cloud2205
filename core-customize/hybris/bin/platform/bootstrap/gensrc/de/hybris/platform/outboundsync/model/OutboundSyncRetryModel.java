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
import de.hybris.platform.outboundsync.model.OutboundChannelConfigurationModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type OutboundSyncRetry first defined at extension outboundsync.
 */
@SuppressWarnings("all")
public class OutboundSyncRetryModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "OutboundSyncRetry";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundSyncRetry.itemPk</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String ITEMPK = "itemPk";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundSyncRetry.channel</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String CHANNEL = "channel";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundSyncRetry.syncAttempts</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String SYNCATTEMPTS = "syncAttempts";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundSyncRetry.remainingSyncAttempts</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String REMAININGSYNCATTEMPTS = "remainingSyncAttempts";
	
	/** <i>Generated constant</i> - Attribute key of <code>OutboundSyncRetry.reachedMaxRetries</code> attribute defined at extension <code>outboundsync</code>. */
	public static final String REACHEDMAXRETRIES = "reachedMaxRetries";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public OutboundSyncRetryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public OutboundSyncRetryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _channel initial attribute declared by type <code>OutboundSyncRetry</code> at extension <code>outboundsync</code>
	 * @param _itemPk initial attribute declared by type <code>OutboundSyncRetry</code> at extension <code>outboundsync</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundSyncRetryModel(final OutboundChannelConfigurationModel _channel, final Long _itemPk)
	{
		super();
		setChannel(_channel);
		setItemPk(_itemPk);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _channel initial attribute declared by type <code>OutboundSyncRetry</code> at extension <code>outboundsync</code>
	 * @param _itemPk initial attribute declared by type <code>OutboundSyncRetry</code> at extension <code>outboundsync</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated(since = "4.1.1", forRemoval = true)
	public OutboundSyncRetryModel(final OutboundChannelConfigurationModel _channel, final Long _itemPk, final ItemModel _owner)
	{
		super();
		setChannel(_channel);
		setItemPk(_itemPk);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundSyncRetry.channel</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the channel - Channel with the configuration including the Integration Object and the Destination for
	 *                         the synchronization
	 */
	@Accessor(qualifier = "channel", type = Accessor.Type.GETTER)
	public OutboundChannelConfigurationModel getChannel()
	{
		return getPersistenceContext().getPropertyValue(CHANNEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundSyncRetry.itemPk</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the itemPk
	 */
	@Accessor(qualifier = "itemPk", type = Accessor.Type.GETTER)
	public Long getItemPk()
	{
		return getPersistenceContext().getPropertyValue(ITEMPK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundSyncRetry.reachedMaxRetries</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the reachedMaxRetries - Indicates this retry record has reached the maximum number of retries. Use
	 *                         remainingSyncAttempts after deprecation.
	 */
	@Accessor(qualifier = "reachedMaxRetries", type = Accessor.Type.GETTER)
	public Boolean getReachedMaxRetries()
	{
		return getPersistenceContext().getPropertyValue(REACHEDMAXRETRIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundSyncRetry.remainingSyncAttempts</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the remainingSyncAttempts - Number of outbound synchronization attempts remaining before giving up synchronization of the
	 *                         corresponding item.
	 *                         If 0 or negative, no more synchronization attempts will be made.
	 */
	@Accessor(qualifier = "remainingSyncAttempts", type = Accessor.Type.GETTER)
	public Integer getRemainingSyncAttempts()
	{
		return getPersistenceContext().getPropertyValue(REMAININGSYNCATTEMPTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundSyncRetry.syncAttempts</code> attribute defined at extension <code>outboundsync</code>. 
	 * @return the syncAttempts - Number of attempts to synchronize, that will allow us to keep track of the max number of
	 *                         attempts
	 *                         that we want to perform. This attempts number includes the original attempt as well as all
	 *                         subsequent retries.
	 *                         For example, when first item synchronization attempt fails, a new retry entity will be created
	 *                         and the
	 *                         {@code syncAttempts} are set to 1 although no retries have been attempted yet.
	 */
	@Accessor(qualifier = "syncAttempts", type = Accessor.Type.GETTER)
	public Integer getSyncAttempts()
	{
		return getPersistenceContext().getPropertyValue(SYNCATTEMPTS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundSyncRetry.channel</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the channel - Channel with the configuration including the Integration Object and the Destination for
	 *                         the synchronization
	 */
	@Accessor(qualifier = "channel", type = Accessor.Type.SETTER)
	public void setChannel(final OutboundChannelConfigurationModel value)
	{
		getPersistenceContext().setPropertyValue(CHANNEL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundSyncRetry.itemPk</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the itemPk
	 */
	@Accessor(qualifier = "itemPk", type = Accessor.Type.SETTER)
	public void setItemPk(final Long value)
	{
		getPersistenceContext().setPropertyValue(ITEMPK, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundSyncRetry.reachedMaxRetries</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the reachedMaxRetries - Indicates this retry record has reached the maximum number of retries. Use
	 *                         remainingSyncAttempts after deprecation.
	 */
	@Accessor(qualifier = "reachedMaxRetries", type = Accessor.Type.SETTER)
	public void setReachedMaxRetries(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(REACHEDMAXRETRIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundSyncRetry.remainingSyncAttempts</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the remainingSyncAttempts - Number of outbound synchronization attempts remaining before giving up synchronization of the
	 *                         corresponding item.
	 *                         If 0 or negative, no more synchronization attempts will be made.
	 */
	@Accessor(qualifier = "remainingSyncAttempts", type = Accessor.Type.SETTER)
	public void setRemainingSyncAttempts(final Integer value)
	{
		getPersistenceContext().setPropertyValue(REMAININGSYNCATTEMPTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>OutboundSyncRetry.syncAttempts</code> attribute defined at extension <code>outboundsync</code>. 
	 *  
	 * @param value the syncAttempts - Number of attempts to synchronize, that will allow us to keep track of the max number of
	 *                         attempts
	 *                         that we want to perform. This attempts number includes the original attempt as well as all
	 *                         subsequent retries.
	 *                         For example, when first item synchronization attempt fails, a new retry entity will be created
	 *                         and the
	 *                         {@code syncAttempts} are set to 1 although no retries have been attempted yet.
	 */
	@Accessor(qualifier = "syncAttempts", type = Accessor.Type.SETTER)
	public void setSyncAttempts(final Integer value)
	{
		getPersistenceContext().setPropertyValue(SYNCATTEMPTS, value);
	}
	
}
