/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.occ.controllers;

import de.hybris.platform.catalog.enums.ConfiguratorType;


/**
 * Constants for OCC controllers
 */
public final class SapproductconfigoccControllerConstants
{
	/**
	 * Deviates from {@link ConfiguratorType} for CPQ, as we don't want to expose 'CPQ' to OCC. 'CPQ' should be
	 * externally reserved for ConfigurePriceQuote<br>
	 */
	public static final String CONFIGURATOR_TYPE_FOR_OCC_EXPOSURE = "ccpconfigurator";
	public static final String CONFIG_OVERVIEW = "/configurationOverview";
	public static final String BASE_SITE_ID_PART = "/{baseSiteId}/";
	public static final String GET_CONFIG_FOR_PRODUCT = BASE_SITE_ID_PART + "products/{productCode}/configurators/"
			+ CONFIGURATOR_TYPE_FOR_OCC_EXPOSURE;
	public static final String CONFIGURE_URL = BASE_SITE_ID_PART + CONFIGURATOR_TYPE_FOR_OCC_EXPOSURE + "/{configId}";
	public static final String GET_CONFIGURE_OVERVIEW_URL = BASE_SITE_ID_PART + CONFIGURATOR_TYPE_FOR_OCC_EXPOSURE + "/{configId}"
			+ CONFIG_OVERVIEW;
	public static final String GET_PRICING_URL = BASE_SITE_ID_PART + CONFIGURATOR_TYPE_FOR_OCC_EXPOSURE + "/{configId}/pricing";
	public static final String GET_VARIANTS_URL = BASE_SITE_ID_PART + CONFIGURATOR_TYPE_FOR_OCC_EXPOSURE + "/{configId}/variants";

	private SapproductconfigoccControllerConstants()
	{
	}
}
