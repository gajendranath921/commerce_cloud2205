/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.occ.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.sap.productconfig.facades.ConfigurationData;
import de.hybris.platform.sap.productconfig.facades.ConfigurationFacade;
import de.hybris.platform.sap.productconfig.facades.ConfigurationPricingFacade;
import de.hybris.platform.sap.productconfig.facades.CsticData;
import de.hybris.platform.sap.productconfig.facades.PriceDataPair;
import de.hybris.platform.sap.productconfig.facades.PriceValueUpdateData;
import de.hybris.platform.sap.productconfig.facades.PricingData;
import de.hybris.platform.sap.productconfig.facades.UiGroupData;
import de.hybris.platform.sap.productconfig.occ.ConfigurationSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.ConfigurationWsDTO;
import de.hybris.platform.sap.productconfig.occ.util.CCPControllerHelper;
import de.hybris.platform.sap.productconfig.occ.util.ImageHandler;
import de.hybris.platform.webservicescommons.mapping.DataMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@UnitTest
public class ProductConfiguratorCCPControllerTest
{
	private static final String CONFIG_ID = "config id";
	private static final String GROUP_ID = "group_id";
	protected final ConfigurationWsDTO updatedConfiguration = new ConfigurationWsDTO();
	protected final ConfigurationWsDTO backendUpdatedWsConfiguration = new ConfigurationWsDTO();
	@Mock
	protected ImageHandler imageHandler;

	@Mock
	protected CCPControllerHelper ccpControllerHelper;

	@Mock
	protected DataMapper dataMapper;

	@Mock
	protected ConfigurationFacade configurationFacade;

	@Mock
	private ConfigurationPricingFacade configPricingFacade;

	@InjectMocks
	ProductConfiguratorCCPController classUnderTest;
	private final ConfigurationData configurationData = new ConfigurationData();
	private final ConfigurationData updatedConfigurationData = new ConfigurationData();
	private ConfigurationSupplementsWsDTO configurationSupplement;
	private ConfigurationSupplementsWsDTO configurationSupplementNoGroup;
	private PricingData priceSummary;
	private List<PriceValueUpdateData> valuePrices;
	private List<PriceValueUpdateData> valuePricesNoGroup;
	private final PriceValueUpdateData valuePrice = new PriceValueUpdateData();
	private final UiGroupData subGroup = new UiGroupData();
	private final List<String> valuePriceInput = new ArrayList<>();

	@Before
	public void initialize()
	{
		configurationData.setGroups(Collections.emptyList());
		MockitoAnnotations.initMocks(this);
		when(dataMapper.map(updatedConfiguration, ConfigurationData.class)).thenReturn(configurationData);
		when(ccpControllerHelper.determineFirstGroupId(configurationData.getGroups())).thenReturn(GROUP_ID);
		when(configurationFacade.getConfiguration(configurationData)).thenReturn(updatedConfigurationData);
		when(ccpControllerHelper.mapDTOData(updatedConfigurationData)).thenReturn(backendUpdatedWsConfiguration);

		configurationSupplement = new ConfigurationSupplementsWsDTO();
		configurationSupplementNoGroup = new ConfigurationSupplementsWsDTO();
		configurationSupplement.setConfigId(CONFIG_ID);
		priceSummary = new PricingData();
		valuePrices = new ArrayList<>();
		valuePricesNoGroup = new ArrayList<>();
		valuePrices.add(valuePrice);
		valuePriceInput.add(GROUP_ID);
		when(configPricingFacade.getPriceSummary(CONFIG_ID)).thenReturn(priceSummary);
		when(ccpControllerHelper.getUiGroup(CONFIG_ID, GROUP_ID)).thenReturn(subGroup);
		when(ccpControllerHelper.compileValuePriceInput(subGroup)).thenReturn(valuePriceInput);
		when(configPricingFacade.getValuePrices(valuePriceInput, CONFIG_ID)).thenReturn(valuePrices);
		when(configPricingFacade.getValuePrices(Collections.emptyList(), CONFIG_ID)).thenReturn(valuePricesNoGroup);
		when(ccpControllerHelper.compilePricingResult(CONFIG_ID, priceSummary, valuePrices)).thenReturn(configurationSupplement);
		when(ccpControllerHelper.compilePricingResult(CONFIG_ID, priceSummary, valuePricesNoGroup))
				.thenReturn(configurationSupplementNoGroup);

	}

	@Test
	public void testUpdateConfiguration()
	{
		final ConfigurationWsDTO configurationAfterUpdate = classUnderTest.updateConfiguration(CONFIG_ID, updatedConfiguration);
		assertEquals(backendUpdatedWsConfiguration, configurationAfterUpdate);
	}


	@Test
	public void testPricing()
	{
		final ConfigurationSupplementsWsDTO supplementsWsDTO = classUnderTest.getPricing(CONFIG_ID, GROUP_ID);
		assertEquals(configurationSupplement, supplementsWsDTO);
	}

	@Test
	public void testPricingNoGroupSpecified()
	{
		final ConfigurationSupplementsWsDTO supplementsWsDTO = classUnderTest.getPricing(CONFIG_ID, null);
		assertEquals(configurationSupplementNoGroup, supplementsWsDTO);
	}

	@Test
	public void testDeprecatedMethods()
	{
		final CsticData cstic = new CsticData();
		final UiGroupData uiGroup = new UiGroupData();
		final Entry<String, PriceDataPair> entryPriceDataPair = null;
		final Map<String, PriceDataPair> mapStringPriceDataPair = null;
		final List<UiGroupData> uiGroupList = null;
		final String productCode = null;

		classUnderTest.compileCsticKey(cstic, uiGroup);
		Mockito.verify(ccpControllerHelper).compileCsticKey(cstic, uiGroup);

		classUnderTest.compilePricingResult(CONFIG_ID, priceSummary, valuePrices);
		Mockito.verify(ccpControllerHelper).compilePricingResult(CONFIG_ID, priceSummary, valuePrices);

		classUnderTest.compileValuePriceInput(uiGroup);
		Mockito.verify(ccpControllerHelper).compileValuePriceInput(uiGroup);

		classUnderTest.convertEntrytoWsDTO(entryPriceDataPair);
		Mockito.verify(ccpControllerHelper).convertEntrytoWsDTO(entryPriceDataPair);

		classUnderTest.createAttributeSupplementDTO(valuePrice);
		Mockito.verify(ccpControllerHelper).createAttributeSupplementDTO(valuePrice);

		classUnderTest.createPriceSupplements(mapStringPriceDataPair);
		Mockito.verify(ccpControllerHelper).createPriceSupplements(mapStringPriceDataPair);

		classUnderTest.deleteCstics(uiGroup);
		Mockito.verify(ccpControllerHelper).deleteCstics(uiGroup);

		classUnderTest.determineFirstGroupId(uiGroupList);
		Mockito.verify(ccpControllerHelper).determineFirstGroupId(uiGroupList);

		classUnderTest.filterGroups(configurationData, GROUP_ID);
		Mockito.verify(ccpControllerHelper).filterGroups(configurationData, GROUP_ID);

		classUnderTest.filterGroups(uiGroupList, GROUP_ID);
		Mockito.verify(ccpControllerHelper).filterGroups(uiGroupList, GROUP_ID);

		classUnderTest.getFlattened(uiGroup);
		Mockito.verify(ccpControllerHelper).getFlattened(uiGroup);

		classUnderTest.getImageHandler();
		Mockito.verify(ccpControllerHelper).getImageHandler();

		classUnderTest.getUiGroup(uiGroupList, GROUP_ID);
		Mockito.verify(ccpControllerHelper).getUiGroup(uiGroupList, GROUP_ID);

		classUnderTest.getUiGroup(CONFIG_ID, GROUP_ID);
		Mockito.verify(ccpControllerHelper).getUiGroup(CONFIG_ID, GROUP_ID);

		classUnderTest.getUniqueUIKeyGenerator();
		Mockito.verify(ccpControllerHelper).getUniqueUIKeyGenerator();

		classUnderTest.hasSubGroups(uiGroup);
		Mockito.verify(ccpControllerHelper).hasSubGroups(uiGroup);

		classUnderTest.isNotRequestedGroup(uiGroup, GROUP_ID);
		Mockito.verify(ccpControllerHelper).isNotRequestedGroup(uiGroup, GROUP_ID);

		classUnderTest.mapDTOData(configurationData);
		Mockito.verify(ccpControllerHelper).mapDTOData(configurationData);

		classUnderTest.readDefaultConfiguration(productCode);
		Mockito.verify(ccpControllerHelper).readDefaultConfiguration(productCode);
	}


}
