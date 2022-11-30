/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.runtime.interf.event;

import de.hybris.platform.servicelayer.event.ClusterAwareEvent;
import de.hybris.platform.servicelayer.event.PublishEventContext;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import org.apache.log4j.Logger;


/**
 * Event indicates that the cached configuration state shall be discarded cluster wide.
 */
public class ProductConfigurationCacheInvalidationEvent extends AbstractEvent implements ClusterAwareEvent
{
	private static final Logger LOG = Logger.getLogger(ProductConfigurationCacheInvalidationEvent.class.getName());

	private final String configId;
	private final Map<String, String> contextAttributes;

	/**
	 * Default constructor.
	 *
	 * @param cacheKeyComponents
	 *           cache key components require to build a valid cache key
	 * @param configId
	 *           to be discarded
	 */
	public ProductConfigurationCacheInvalidationEvent(final String configid, final Map<String, String> contextAttributes)
	{
		super();
		this.configId = configid;
		this.contextAttributes = Collections.unmodifiableMap(contextAttributes);
	}

	/**
	 * Default constructor.
	 * 
	 * @param configId
	 *           to be discarded
	 */
	public ProductConfigurationCacheInvalidationEvent(final String configid)
	{
		super();
		this.configId = configid;
		this.contextAttributes = Collections.unmodifiableMap(Collections.emptyMap());
	}

	public String getConfigId()
	{
		return configId;
	}

	@Override
	public boolean canPublish(final PublishEventContext publishEventContext)
	{
		Objects.requireNonNull(publishEventContext, "publishEventContext is required");
		final boolean publish = publishEventContext.getSourceNodeId() != publishEventContext.getTargetNodeId();
		if (!publish && LOG.isDebugEnabled())
		{
			LOG.debug(
					"discarding cluster wide cache invalidation event received from this node for product configuration with configId="
							+ getConfigId());
		}
		return publish;
	}

	public Map<String, String> getContextAttributes()
	{
		return contextAttributes;
	}


}
