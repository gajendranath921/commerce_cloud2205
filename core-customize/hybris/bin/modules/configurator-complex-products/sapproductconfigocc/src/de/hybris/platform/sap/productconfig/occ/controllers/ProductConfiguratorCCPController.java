/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.occ.controllers;

import de.hybris.platform.sap.productconfig.facades.ConfigurationData;
import de.hybris.platform.sap.productconfig.facades.ConfigurationFacade;
import de.hybris.platform.sap.productconfig.facades.ConfigurationOverviewFacade;
import de.hybris.platform.sap.productconfig.facades.ConfigurationPricingFacade;
import de.hybris.platform.sap.productconfig.facades.CsticData;
import de.hybris.platform.sap.productconfig.facades.PriceDataPair;
import de.hybris.platform.sap.productconfig.facades.PriceValueUpdateData;
import de.hybris.platform.sap.productconfig.facades.PricingData;
import de.hybris.platform.sap.productconfig.facades.UiGroupData;
import de.hybris.platform.sap.productconfig.facades.UniqueUIKeyGenerator;
import de.hybris.platform.sap.productconfig.facades.overview.ConfigurationOverviewData;
import de.hybris.platform.sap.productconfig.occ.ConfigurationOverviewWsDTO;
import de.hybris.platform.sap.productconfig.occ.ConfigurationSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.ConfigurationWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticValueSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.util.CCPControllerHelper;
import de.hybris.platform.sap.productconfig.occ.util.ImageHandler;
import de.hybris.platform.webservicescommons.mapping.DataMapper;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;
import de.hybris.platform.webservicescommons.util.YSanitizer;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * Web Services Controller to expose the functionality of the
 * {@link de.hybris.platform.sap.productconfig.facades.ConfigurationFacade}.
 */
@Controller
@Api(tags = "Product Configurator CCP")
public class ProductConfiguratorCCPController
{

	private static final Logger LOG = Logger.getLogger(ProductConfiguratorCCPController.class);
	@Resource(name = "sapProductConfigFacade")
	private ConfigurationFacade configFacade;
	@Resource(name = "sapProductConfigPricingFacade")
	private ConfigurationPricingFacade configPricingFacade;
	@Resource(name = "sapProductConfigOverviewFacade")
	private ConfigurationOverviewFacade configOverviewFacade;
	@Resource(name = "dataMapper")
	protected DataMapper dataMapper;
	@Resource(name = "sapProductConfigCCPControllerHelper")
	private CCPControllerHelper ccpControllerHelper;


	protected ConfigurationOverviewFacade getConfigOverviewFacade()
	{
		return configOverviewFacade;
	}

	protected void setConfigOverviewFacade(final ConfigurationOverviewFacade configOverviewFacade)
	{
		this.configOverviewFacade = configOverviewFacade;
	}

	protected ConfigurationFacade getConfigFacade()
	{
		return configFacade;
	}

	protected void setConfigFacade(final ConfigurationFacade configFacade)
	{
		this.configFacade = configFacade;
	}

	protected ConfigurationPricingFacade getConfigPricingFacade()
	{
		return configPricingFacade;
	}

	protected CCPControllerHelper getConfigurationHandler()
	{
		return ccpControllerHelper;
	}

	protected DataMapper getDataMapper()
	{
		return dataMapper;
	}

	protected static String sanitize(final String input)
	{
		return YSanitizer.sanitize(input);
	}


	@RequestMapping(value = SapproductconfigoccControllerConstants.GET_CONFIG_FOR_PRODUCT, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(nickname = "getDefaultProductConfiguration", value = "Gets the default product configuration for a complex product", notes = "Returns the default product configuration for a given complex product. This means that a new instance of the configuration runtime object is created that is equipped with the default values from the configuration model. This API always returns the _entire_ group hierarchy, whereas it's capable of both including all attributes or only those for the first group. This is controlled by query attribute provideAllAttributes")
	@ApiBaseSiteIdParam
	public ConfigurationWsDTO getDefaultConfiguration(//
			@ApiParam(value = "Product code", required = true) //
			@PathVariable
			final String productCode,
			@ApiParam(value = "If this parameter is provided and its value is true, attributes for all groups are returned. Otherwise, attributes only for the first group are considered.") //
			@RequestParam(defaultValue = "false", required = false)
			final boolean provideAllAttributes)
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug("getDefaultConfiguration: pCode=" + sanitize(productCode));
		}
		final ConfigurationData configData = getConfigurationHandler().readDefaultConfiguration(productCode);
		if (!provideAllAttributes)
		{
			final String firstGroupId = getConfigurationHandler().determineFirstGroupId(configData.getGroups());
			getConfigurationHandler().filterGroups(configData, firstGroupId);
		}
		return getConfigurationHandler().mapDTOData(configData);
	}

	@RequestMapping(value = SapproductconfigoccControllerConstants.CONFIGURE_URL, method = RequestMethod.PATCH)
	@ResponseBody
	@ApiOperation(nickname = "updateProductConfiguration", value = "Updates a product configuration", notes = "Updates a product configuration. It's possible to send only the changed parts of the configuration, for example a single value change for an attribute. These changes must include their entire path through the configuration (the group they belong to and its parent groups)")
	@ApiBaseSiteIdParam
	public ConfigurationWsDTO updateConfiguration(//
			@ApiParam(value = "Configuration identifier", required = true) //
			@PathVariable("configId")
			final String configId, //
			@RequestBody(required = true)
			final ConfigurationWsDTO updatedConfiguration)
	{
		final ConfigurationData configurationData = getDataMapper().map(updatedConfiguration, ConfigurationData.class);
		configurationData.setConfigId(configId);
		final String requestedGroupId = getConfigurationHandler().determineFirstGroupId(configurationData.getGroups());
		getConfigFacade().updateConfiguration(configurationData);
		final ConfigurationData updatedBackendConfiguration = getConfigFacade().getConfiguration(configurationData);
		getConfigurationHandler().filterGroups(updatedBackendConfiguration, requestedGroupId);

		return getConfigurationHandler().mapDTOData(updatedBackendConfiguration);
	}

	@RequestMapping(value = SapproductconfigoccControllerConstants.CONFIGURE_URL, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(nickname = "getProductConfiguration", value = "Gets a product configuration", notes = "Returns a product configuration, specified by its id. In case this call is done in the context of a logged-in session, the call ensures that the configuration is only returned if the user is authorized to view the configuration")
	@ApiBaseSiteIdParam
	public ConfigurationWsDTO getConfiguration(//
			@ApiParam(value = "Configuration identifier", required = true) //
			@PathVariable("configId")
			final String configId,
			@ApiParam(value = "If the parameter is provided only the attributes of the requested group are returned. If the parameter is not provided, attributes for all groups are returned.") //
			@RequestParam(required = false)
			final String groupId)
	{
		final ConfigurationData configurationData = new ConfigurationData();
		configurationData.setConfigId(configId);
		final ConfigurationData backendConfiguration = getConfigFacade().getConfiguration(configurationData);
		if (groupId != null && !groupId.isEmpty())
		{
			getConfigurationHandler().filterGroups(backendConfiguration, groupId);
		}
		return getConfigurationHandler().mapDTOData(backendConfiguration);
	}


	@RequestMapping(value = SapproductconfigoccControllerConstants.GET_CONFIGURE_OVERVIEW_URL, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(nickname = "getProductConfigurationOverview", value = "Gets a product configuration overview", notes = "Gets a configuration overview, a simplified, condensed read-only view on the product configuration. Only the selected attribute values are present here")
	@ApiBaseSiteIdParam
	public ConfigurationOverviewWsDTO getConfigurationOverview(//
			@ApiParam(value = "Configuration identifier", required = true) //
			@PathVariable("configId")
			final String configId)
	{
		final ConfigurationOverviewData overviewData = getConfigOverviewFacade().getOverviewForConfiguration(configId, null);

		final ConfigurationOverviewWsDTO configurationOverviewWs = getDataMapper().map(overviewData,
				ConfigurationOverviewWsDTO.class);
		configurationOverviewWs.setTotalNumberOfIssues(getConfigFacade().getNumberOfErrors(configId));
		configurationOverviewWs.setNumberOfIncompleteCharacteristics(getConfigFacade().getNumberOfIncompleteCstics(configId));
		configurationOverviewWs.setNumberOfConflicts(getConfigFacade().getNumberOfSolvableConflicts(configId));
		return configurationOverviewWs;
	}

	@RequestMapping(value = SapproductconfigoccControllerConstants.GET_PRICING_URL, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(nickname = "getProductConfigurationPricing", value = "Gets prices for a product configuration", notes = "Gets price elements on configuration level and on attribute value level if present. Those price elements include e.g. the configuration base price and the sum of selected options")
	@ApiBaseSiteIdParam
	public ConfigurationSupplementsWsDTO getPricing(//
			@ApiParam(value = "Configuration identifier", required = true) //
			@PathVariable("configId")
			final String configId, //
			@ApiParam(value = "Specifies the group for which the value prices are requested. In case not specified, no value prices are returned") //
			@RequestParam(required = false)
			final String groupId)
	{
		final PricingData priceSummary = getConfigPricingFacade().getPriceSummary(configId);

		final List<String> valuePricingInput = groupId != null
				? getConfigurationHandler().compileValuePriceInput(getConfigurationHandler().getUiGroup(configId, groupId))
				: Collections.emptyList();
		final List<PriceValueUpdateData> valuePrices = getConfigPricingFacade().getValuePrices(valuePricingInput, configId);

		return getConfigurationHandler().compilePricingResult(configId, priceSummary, valuePrices);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected String compileCsticKey(final CsticData cstic, final UiGroupData uiGroup)
	{
		return getConfigurationHandler().compileCsticKey(cstic, uiGroup);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected ConfigurationSupplementsWsDTO compilePricingResult(final String configId, final PricingData priceSummary,
			final List<PriceValueUpdateData> valuePrices)
	{
		return getConfigurationHandler().compilePricingResult(configId, priceSummary, valuePrices);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected List<String> compileValuePriceInput(final UiGroupData uiGroup)
	{
		return getConfigurationHandler().compileValuePriceInput(uiGroup);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected CsticValueSupplementsWsDTO convertEntrytoWsDTO(final Entry<String, PriceDataPair> entry)
	{
		return getConfigurationHandler().convertEntrytoWsDTO(entry);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected CsticSupplementsWsDTO createAttributeSupplementDTO(final PriceValueUpdateData valuePrice)
	{
		return getConfigurationHandler().createAttributeSupplementDTO(valuePrice);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected List<CsticValueSupplementsWsDTO> createPriceSupplements(final Map<String, PriceDataPair> prices)
	{
		return getConfigurationHandler().createPriceSupplements(prices);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected void deleteCstics(final UiGroupData group)
	{
		getConfigurationHandler().deleteCstics(group);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected String determineFirstGroupId(final List<UiGroupData> uiGroups)
	{
		return getConfigurationHandler().determineFirstGroupId(uiGroups);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected void filterGroups(final ConfigurationData configData, final String requestedGroupId)
	{
		getConfigurationHandler().filterGroups(configData, requestedGroupId);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected void filterGroups(final List<UiGroupData> groups, final String requestedGroupId)
	{
		getConfigurationHandler().filterGroups(groups, requestedGroupId);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected Stream<UiGroupData> getFlattened(final UiGroupData uiGroup)
	{
		return getConfigurationHandler().getFlattened(uiGroup);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected ImageHandler getImageHandler()
	{
		return getConfigurationHandler().getImageHandler();
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected UiGroupData getUiGroup(final String configId, final String groupId)
	{
		return getConfigurationHandler().getUiGroup(configId, groupId);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected UiGroupData getUiGroup(final List<UiGroupData> groupList, final String groupId)
	{
		return getConfigurationHandler().getUiGroup(groupList, groupId);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected UniqueUIKeyGenerator getUniqueUIKeyGenerator()
	{
		return getConfigurationHandler().getUniqueUIKeyGenerator();
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected boolean hasSubGroups(final UiGroupData group)
	{
		return getConfigurationHandler().hasSubGroups(group);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected boolean isNotRequestedGroup(final UiGroupData group, final String requestedGroupId)
	{
		return getConfigurationHandler().isNotRequestedGroup(group, requestedGroupId);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected ConfigurationWsDTO mapDTOData(final ConfigurationData configData)
	{
		return getConfigurationHandler().mapDTOData(configData);
	}

	/**
	 * @deprecated since 22.05 use {@link #getConfigurationHandler()} and delegate
	 */
	@Deprecated(since = "2205", forRemoval = true)
	protected ConfigurationData readDefaultConfiguration(final String productCode)
	{
		return getConfigurationHandler().readDefaultConfiguration(productCode);
	}
}
