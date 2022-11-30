/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.facades;

/**
 * Facade for Product Configuration.
 */
public interface ConfigurationFacade
{

	/**
	 * Get the default configuration for the given Knowledge Base. In case the product identified by the productCode of
	 * the KBkey is a varaint, the runtime configuration of the corresponding base product is instantiated.
	 *
	 * @param kbKey
	 *           key of the Knowledge Base
	 * @return default configuration
	 */
	ConfigurationData getConfiguration(KBKeyData kbKey);

	/**
	 * Update the configuration with the values provided
	 *
	 * @param configuration
	 *           actual configuration
	 */
	void updateConfiguration(ConfigurationData configuration);

	/**
	 * Read the actual configuration from the Backend. Current values in the model will be overwritten.
	 *
	 * @param configuration
	 *           configuration to be refreshed
	 * @return actual configuration
	 */
	ConfigurationData getConfiguration(ConfigurationData configuration);

	/**
	 * Get the number of errors (conflict, not filled mandatory fields), as it is set at the cart item
	 *
	 * @param configId
	 *           ID of the configuration
	 * @return Total number of errors
	 */
	int getNumberOfErrors(String configId);

	/**
	 * Get the number of incomplete characteristics (not filled mandatory fields)
	 *
	 * @param configId
	 *           Configuration ID
	 * @return Number of incomplete characteristics
	 */
	int getNumberOfIncompleteCstics(String configId);

	/**
	 * Get the number of solvable conflicts
	 *
	 * @param configId
	 *           Configuration ID
	 * @return Number of solvable conflicts
	 */
	int getNumberOfSolvableConflicts(String configId);

	/**
	 * Check if a given configId is known by the configuration engine.
	 *
	 * @param configId
	 *           ID of the configuration
	 * @return TRUE if the configuration exist, otherwise FALSE
	 */
	default boolean isConfigurationAvailable(final String configId)
	{
		throw new IllegalStateException("Not supported");
	}
}
