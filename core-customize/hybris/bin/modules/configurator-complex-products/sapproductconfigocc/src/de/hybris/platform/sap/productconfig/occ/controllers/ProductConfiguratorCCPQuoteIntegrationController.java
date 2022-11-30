/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.occ.controllers;

import de.hybris.platform.sap.productconfig.facades.ConfigurationOverviewFacade;
import de.hybris.platform.sap.productconfig.facades.ConfigurationQuoteIntegrationFacade;
import de.hybris.platform.sap.productconfig.facades.overview.ConfigurationOverviewData;
import de.hybris.platform.sap.productconfig.occ.ConfigurationOverviewWsDTO;
import de.hybris.platform.webservicescommons.errors.exceptions.NotFoundException;
import de.hybris.platform.webservicescommons.mapping.DataMapper;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdAndUserIdParam;
import de.hybris.platform.webservicescommons.util.YSanitizer;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Controller
@Api(tags = "Product Configurator CCP Quote Integration")
@RequestMapping(value = "/{baseSiteId}/users/{userId}/quotes/{quoteId}")
public class ProductConfiguratorCCPQuoteIntegrationController
{

	private static final Logger LOG = Logger.getLogger(ProductConfiguratorCCPQuoteIntegrationController.class);

	@Resource(name = "sapProductConfigQuoteIntegrationFacade")
	private final ConfigurationQuoteIntegrationFacade configurationQuoteIntegrationFacade;
	@Resource(name = "sapProductConfigOverviewFacade")
	private final ConfigurationOverviewFacade configurationOverviewFacade;
	@Resource(name = "dataMapper")
	protected DataMapper dataMapper;

	public ProductConfiguratorCCPQuoteIntegrationController(
			final ConfigurationQuoteIntegrationFacade configurationQuoteIntegrationFacade,
			final ConfigurationOverviewFacade configurationOverviewFacade, final DataMapper dataMapper)
	{
		super();
		this.configurationQuoteIntegrationFacade = configurationQuoteIntegrationFacade;
		this.configurationOverviewFacade = configurationOverviewFacade;
		this.dataMapper = dataMapper;
	}


	@GetMapping(value = "/entries/{entryNumber}" + "/" + SapproductconfigoccControllerConstants.CONFIGURATOR_TYPE_FOR_OCC_EXPOSURE
			+ SapproductconfigoccControllerConstants.CONFIG_OVERVIEW)
	@ResponseBody
	@ApiOperation(nickname = "getConfigurationOverviewForQuote", value = "Gets a product configuration overview of an quote entry", notes = "Gets a configuration overview, a simplified, condensed read-only view on the product configuration of an quote entry. Only the selected attribute values are present here")
	@ApiBaseSiteIdAndUserIdParam
	public ConfigurationOverviewWsDTO getConfigurationOverviewForQuotes(//
			@ApiParam(required = true, value = "The quote id. Each quote has a unique identifier.") //
			@PathVariable("quoteId") final String quoteId, //
			@ApiParam(required = true, value = "The entry number. Each entry in a quote has an entry number. Quote entries are numbered in ascending order, starting with zero (0).") //
			@PathVariable("entryNumber") final int entryNumber) throws NotFoundException
	{
		final ConfigurationOverviewData readConfigurationOverview;
		try
		{
			readConfigurationOverview = readConfigurationOverview(quoteId, entryNumber);
		}
		catch (final IllegalArgumentException ex)
		{
			LOG.error("getConfigurationOverviewForQuoteEntry: cannot retrieve configuration information for '"
					+ logParam("quoteId", sanitize(quoteId)) + "," + logParam("entryNumber", String.valueOf(entryNumber)) + "'");
			throw new NotFoundException(
					"Cannot retrieve configuration information for quoteId=" + sanitize(quoteId) + ", entryNumber=" + entryNumber,
					ex.getMessage(), ex);
		}
		return dataMapper.map(readConfigurationOverview, ConfigurationOverviewWsDTO.class);
	}

	protected DataMapper getDataMapper()
	{
		return dataMapper;
	}

	protected ConfigurationOverviewData readConfigurationOverview(final String quoteId, final int entryNumber)
	{
		final ConfigurationOverviewData configuration = configurationQuoteIntegrationFacade.getConfiguration(quoteId, entryNumber);
		return configurationOverviewFacade.getOverviewForConfiguration(configuration.getId(), configuration);
	}

	protected static String logParam(final String paramName, final String paramValue)
	{
		return paramName + " = " + paramValue;
	}

	protected static String sanitize(final String input)
	{
		return YSanitizer.sanitize(input);
	}
}
