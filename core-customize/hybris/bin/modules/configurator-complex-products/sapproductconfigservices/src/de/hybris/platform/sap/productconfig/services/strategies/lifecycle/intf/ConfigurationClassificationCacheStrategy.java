/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.services.strategies.lifecycle.intf;

import de.hybris.platform.sap.productconfig.runtime.interf.model.ConfigModel;
import de.hybris.platform.sap.productconfig.runtime.interf.services.impl.ClassificationSystemCPQAttributesContainer;

import java.util.Map;


/**
 * This strategy manages the caching of the classification data in context of product configuration.
 */
public interface ConfigurationClassificationCacheStrategy
{

	/**
	 * Retrieves a map of of names from the Hybris classification system by the configuration model
	 *
	 * @return Map of names from the Hybris classification system
	 */
	Map<String, ClassificationSystemCPQAttributesContainer> getCachedNameMap(ConfigModel config);

	/**
	 * Retrieves a map of of names from the Hybris classification system by the product code
	 *
	 * @return Map of names from the Hybris classification system
	 */
	Map<String, ClassificationSystemCPQAttributesContainer> getCachedNameMap(String productCode);
}
