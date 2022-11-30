/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.occ.util.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.sap.productconfig.facades.ConfigurationData;
import de.hybris.platform.sap.productconfig.facades.CsticData;
import de.hybris.platform.sap.productconfig.facades.GroupType;
import de.hybris.platform.sap.productconfig.facades.PricingData;
import de.hybris.platform.sap.productconfig.facades.UiGroupData;
import de.hybris.platform.sap.productconfig.facades.UiType;
import de.hybris.platform.sap.productconfig.facades.UniqueUIKeyGenerator;
import de.hybris.platform.sap.productconfig.occ.ConfigurationSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticValueSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.PriceSummaryWsDTO;
import de.hybris.platform.sap.productconfig.occ.controllers.AbstractProductConfiguratorCCPControllerTCBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@UnitTest
public class CCPControllerHelperImplTest extends AbstractProductConfiguratorCCPControllerTCBase
{
	private static final String CONFIG_ID = "config id";
	private static final String SEPARATOR = "@";
	private static final String GROUP_ID = "2-CPQ_RECEIVER" + SEPARATOR + "_GEN";
	private static final String CSTIC_NAME_1 = "Cstic1";
	private static final String CSTIC_NAME_2 = "Cstic2";
	private static final String VALUE_NAME_1 = "Value1";

	private ConfigurationSupplementsWsDTO updatePricingInput;
	private PricingData priceSummary;

	private final List<CsticSupplementsWsDTO> cstics = new ArrayList<>();
	private final CsticSupplementsWsDTO cstic = new CsticSupplementsWsDTO();
	private final String csticUiKey = "1-GROUP-CSTIC";

	private final CsticSupplementsWsDTO csticResult = new CsticSupplementsWsDTO();
	private final ConfigurationData configurationData = new ConfigurationData();
	private final List<UiGroupData> uiGroups = new ArrayList<>();
	private final UiGroupData rootGroup = new UiGroupData();
	private final List<UiGroupData> subGroups = new ArrayList<>();
	private final UiGroupData subGroup = new UiGroupData();
	private final List<CsticData> characteristics = new ArrayList<>();
	private final CsticData firstCstic = new CsticData();
	private final CsticData secondCstic = new CsticData();
	private final List<String> valuePriceInput = new ArrayList<>();

	@Mock
	private UniqueUIKeyGenerator uniqueUIKeyGenerator;


	@InjectMocks
	CCPControllerHelperImpl classUnderTest;

	@Before
	public void initialize()
	{
		MockitoAnnotations.initMocks(this);

		priceSummary = new PricingData();
		priceSummary.setCurrentTotal(new PriceData());

		when(configurationFacade.getConfiguration(Mockito.any(ConfigurationData.class))).thenReturn(configurationData);
		when(dataMapper.map(priceSummary, PriceSummaryWsDTO.class)).thenReturn(new PriceSummaryWsDTO());
		when(dataMapper.map(priceValueUpdateData, CsticSupplementsWsDTO.class)).thenReturn(csticResult);
		when(uniqueUIKeyGenerator.getKeySeparator()).thenReturn(SEPARATOR);
		cstics.add(cstic);
		cstic.setCsticUiKey(csticUiKey);

		configurationData.setGroups(uiGroups);
		uiGroups.add(rootGroup);
		rootGroup.setSubGroups(subGroups);
		subGroups.add(subGroup);
		subGroup.setId(GROUP_ID);
		subGroup.setCstics(characteristics);
		characteristics.add(firstCstic);
		characteristics.add(secondCstic);
		firstCstic.setName(CSTIC_NAME_1);

		prepareValues();
		prepareImageLists();
		prepareUpdatedConfiguration();
		prepareBackendUpdatedConfigurationWithTwoGroups();
		prepareBackendUpdatedConfigurationWithTwoGroupsWsRepresentation();
		prepareGroupsAndCstics();

		priceValueUpdateData.setPrices(valuePrices);
		priceValueUpdateDataList.add(priceValueUpdateData);
		valuePrices.put(VALUE_KEY, valuePricePair);
		valuePricePair.setObsoletePriceValue(obsoletePriceValue);
		valuePricePair.setPriceValue(priceValue);
		priceValue.setValue(priceValueAsDecimal);
		priceWs.setValue(priceValueAsDecimal);
		initializeDataMapperMock();
	}

	@Test
	public void testCompileCsticKey()
	{
		assertEquals(GROUP_ID + SEPARATOR + CSTIC_NAME_1, classUnderTest.compileCsticKey(firstCstic, subGroup));
	}


	@Test
	public void testCompilePricingResult()
	{
		final ConfigurationSupplementsWsDTO pricingResult = classUnderTest.compilePricingResult(CONFIG_ID, priceSummary,
				priceValueUpdateDataList);
		assertNotNull(pricingResult);
		final List<CsticSupplementsWsDTO> resultCstics = pricingResult.getAttributes();
		assertNotNull(resultCstics);
		assertEquals(1, resultCstics.size());
		assertNotNull(resultCstics.get(0));
	}

	@Test
	public void testCompilePricingResultEmptyCsticList()
	{
		final ConfigurationSupplementsWsDTO pricingResult = classUnderTest.compilePricingResult(CONFIG_ID, priceSummary,
				Collections.emptyList());
		assertNotNull(pricingResult);
		final List<CsticSupplementsWsDTO> resultCstics = pricingResult.getAttributes();
		assertNotNull(resultCstics);
		assertTrue(resultCstics.isEmpty());
	}

	@Test
	public void testCompilePricingResultHeaderAttributes()
	{
		final ConfigurationSupplementsWsDTO pricingResult = classUnderTest.compilePricingResult(CONFIG_ID, priceSummary,
				Collections.emptyList());
		assertNotNull(pricingResult);
		assertFalse(pricingResult.isPricingError());
		assertEquals(CONFIG_ID, pricingResult.getConfigId());
	}



	@Test
	public void testGetUiGroup()
	{
		final UiGroupData uiGroup = classUnderTest.getUiGroup(CONFIG_ID, GROUP_ID);
		assertNotNull(uiGroup);
		assertEquals(GROUP_ID, uiGroup.getId());
	}

	@Test(expected = IllegalStateException.class)
	public void testGetUiGroupNothingFound()
	{
		classUnderTest.getUiGroup(CONFIG_ID, "Not existing");
	}

	@Test
	public void testGetFlattened()
	{
		final Stream<UiGroupData> flattened = classUnderTest.getFlattened(rootGroup);
		assertEquals(2, flattened.collect(Collectors.toList()).size());
	}

	@Test
	public void testGetFlattenedCanDealWithNullSubGroups()
	{
		final Stream<UiGroupData> flattened = classUnderTest.getFlattened(subGroup);
		assertEquals(1, flattened.collect(Collectors.toList()).size());
	}

	@Test
	public void testCompileValuePriceInputForGroup()
	{
		final List<String> valuePriceInput = classUnderTest.compileValuePriceInput(subGroup);
		assertNotNull(valuePriceInput);
		assertEquals(2, valuePriceInput.size());
		assertEquals(GROUP_ID + SEPARATOR + CSTIC_NAME_1, valuePriceInput.get(0));
	}

	@Test
	public void testCompileValuePriceInputCanDealWithNullCstics()
	{
		subGroup.setCstics(null);
		final List<String> valuePriceInput = classUnderTest.compileValuePriceInput(subGroup);
		assertNotNull(valuePriceInput);
		assertTrue(valuePriceInput.isEmpty());
	}

	@Test
	public void testFilterGroups()
	{
		final String requestedGroupId = GROUP2_ID;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(2, groups.size());
		assertEquals(0, groups.get(0).getCstics().size());
		assertEquals(1, groups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsRequestedGroupIdNull()
	{
		final String requestedGroupId = null;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(2, groups.size());
		assertEquals(1, groups.get(0).getCstics().size());
		assertEquals(1, groups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsWithListRequestedGroupIdNull()
	{
		final String requestedGroupId = null;
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		classUnderTest.filterGroups(groups, requestedGroupId);
		assertEquals(2, groups.size());
		assertEquals(1, groups.get(0).getCstics().size());
		assertEquals(1, groups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsWithConflict()
	{
		prepareBackendUpdatedConfigurationConflict();
		final String requestedGroupId = GROUP2_ID;
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		classUnderTest.filterGroups(groups, requestedGroupId);
		assertEquals(3, groups.size());
		final List<UiGroupData> subGroups = groups.get(0).getSubGroups();
		assertEquals(1, subGroups.size());
		assertEquals(1, subGroups.get(0).getCstics().size());
		assertEquals(0, groups.get(1).getCstics().size());
		assertEquals(1, groups.get(2).getCstics().size());
	}


	@Test
	public void testFilterGroupsMultilevelRequestedSubSubGroup()
	{
		prepareBackendUpdatedConfigurationMultiLevel();
		final String requestedGroupId = GROUP3_1_1_ID;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(3, groups.size());
		assertEquals(0, groups.get(0).getCstics().size());
		assertEquals(0, groups.get(1).getCstics().size());
		final List<UiGroupData> subGroups = groups.get(2).getSubGroups();
		assertEquals(2, subGroups.size());
		assertEquals(1, subGroups.get(0).getSubGroups().size());
		assertEquals(1, subGroups.get(0).getSubGroups().get(0).getCstics().size());
		assertEquals(0, subGroups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsMultilevelRequestedSubGroup()
	{
		prepareBackendUpdatedConfigurationMultiLevel();
		final String requestedGroupId = GROUP3_2_ID;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(3, groups.size());
		assertEquals(0, groups.get(0).getCstics().size());
		assertEquals(0, groups.get(1).getCstics().size());
		final List<UiGroupData> subGroups = groups.get(2).getSubGroups();
		assertEquals(2, subGroups.size());
		assertEquals(1, subGroups.get(0).getSubGroups().size());
		assertEquals(0, subGroups.get(0).getSubGroups().get(0).getCstics().size());
		assertEquals(1, subGroups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsMultilevelRequestedRootLevelGroup()
	{
		prepareBackendUpdatedConfigurationMultiLevel();
		final String requestedGroupId = GROUP2_ID;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(3, groups.size());
		assertEquals(0, groups.get(0).getCstics().size());
		assertEquals(1, groups.get(1).getCstics().size());
		final List<UiGroupData> subGroups = groups.get(2).getSubGroups();
		assertEquals(2, subGroups.size());
		assertEquals(1, subGroups.get(0).getSubGroups().size());
		assertEquals(0, subGroups.get(0).getSubGroups().get(0).getCstics().size());
		assertEquals(0, subGroups.get(1).getCstics().size());
	}

	@Test
	public void testHasSubGroups()
	{
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		final List<UiGroupData> subGroups = new ArrayList();
		instanceGroup.setSubGroups(subGroups);
		final UiGroupData subInstanceGroup = createInstanceGroup(GROUP3_1_ID);
		subGroups.add(subInstanceGroup);
		assertTrue(classUnderTest.hasSubGroups(instanceGroup));
	}

	@Test
	public void testHasSubGroupsEmpyList()
	{
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		final List<UiGroupData> subGroups = new ArrayList();
		instanceGroup.setSubGroups(subGroups);
		assertFalse(classUnderTest.hasSubGroups(instanceGroup));
	}

	@Test
	public void testHasSubGroupsFalse()
	{
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		assertFalse(classUnderTest.hasSubGroups(instanceGroup));
	}

	@Test
	public void testDeleteCstics()
	{
		final UiGroupData group = createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1");
		classUnderTest.deleteCstics(group);
		assertEquals(0, group.getCstics().size());
	}

	@Test
	public void testIsNotRequestedGroup()
	{
		final String requestedGroupId = GROUP2_ID;
		assertTrue(classUnderTest.isNotRequestedGroup(createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"), requestedGroupId));
	}

	@Test
	public void testIsNotRequestedGroupFalse()
	{
		final String requestedGroupId = GROUP1_ID;
		assertFalse(classUnderTest.isNotRequestedGroup(createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"), requestedGroupId));
	}

	@Test
	public void testIsNotRequestedGroupNull()
	{
		final String requestedGroupId = null;
		assertFalse(classUnderTest.isNotRequestedGroup(createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"), requestedGroupId));
	}

	@Test
	public void testDetermineFirstGroupIdWithEmptyGroups()
	{
		updatedConfigurationAsFacadeDTO.setGroups(Collections.emptyList());
		final String result = classUnderTest.determineFirstGroupId(updatedConfigurationAsFacadeDTO.getGroups());
		assertNull(result);
	}

	@Test
	public void testDetermineFirstGroupIdWithEmptySubGroups()
	{
		final List<UiGroupData> groups = new ArrayList<>();
		final UiGroupData group = new UiGroupData();
		group.setSubGroups(null);
		groups.add(group);
		updatedConfigurationAsFacadeDTO.setGroups(groups);
		final String result = classUnderTest.determineFirstGroupId(updatedConfigurationAsFacadeDTO.getGroups());
		assertNull(result);
	}

	@Test
	public void testDetermineFirstGroupIdWithSubGroups()
	{
		final List<UiGroupData> groups = new ArrayList<>();
		final UiGroupData group = new UiGroupData();
		final List<UiGroupData> subGroups = new ArrayList<>();
		final UiGroupData subGroup = new UiGroupData();
		final String subGroupId = "subGroup_1";
		subGroup.setId(subGroupId);
		final List<CsticData> cstics = new ArrayList<>();
		for (int i = 1; i <= 5; i++)
		{
			final CsticData cstic = new CsticData();
			cstic.setName("cstic_" + i);
			cstics.add(cstic);
		}
		subGroup.setCstics(cstics);
		subGroups.add(subGroup);
		group.setSubGroups(subGroups);
		groups.add(group);
		updatedConfigurationAsFacadeDTO.setGroups(groups);

		final String result = classUnderTest.determineFirstGroupId(updatedConfigurationAsFacadeDTO.getGroups());
		assertNotNull(result);
		assertEquals(subGroupId, result);
	}

	@Test
	public void testDetermineFirstGroupIdWithEmptyCstics()
	{
		final List<UiGroupData> groups = new ArrayList<>();
		final UiGroupData group = new UiGroupData();
		final List<UiGroupData> subGroups = new ArrayList<>();
		final UiGroupData subGroup = new UiGroupData();
		final String subGroupId = "subGroup_1";
		subGroup.setId(subGroupId);
		final List<CsticData> cstics = new ArrayList<>();
		subGroups.add(subGroup);
		group.setSubGroups(subGroups);
		groups.add(group);
		updatedConfigurationAsFacadeDTO.setGroups(groups);

		final String result = classUnderTest.determineFirstGroupId(updatedConfigurationAsFacadeDTO.getGroups());
		assertNull(result);
	}


	@Test
	public void testCreateAttributeSupplementDTO()
	{
		final CsticSupplementsWsDTO attributeSupplementDTO = classUnderTest.createAttributeSupplementDTO(priceValueUpdateData);
		assertNotNull(attributeSupplementDTO);
		final List<CsticValueSupplementsWsDTO> priceSupplements = attributeSupplementDTO.getPriceSupplements();
		assertNotNull(priceSupplements);
	}

	@Test
	public void testCreateAttributeSupplementDTOCoversNullPriceSupplements()
	{
		priceValueUpdateData.setPrices(null);
		final CsticSupplementsWsDTO attributeSupplementDTO = classUnderTest.createAttributeSupplementDTO(priceValueUpdateData);
		assertNotNull(attributeSupplementDTO);
		assertNotNull(attributeSupplementDTO.getPriceSupplements());
	}

	@Test
	public void testCreatePriceSupplements()
	{
		final List<CsticValueSupplementsWsDTO> priceSupplements = classUnderTest
				.createPriceSupplements(priceValueUpdateData.getPrices());
		assertNotNull(priceSupplements);
	}

	@Test
	public void testConvertEntrytoWsDTO()
	{
		final CsticValueSupplementsWsDTO valueSupplementsWsDTO = classUnderTest
				.convertEntrytoWsDTO(priceValueUpdateData.getPrices().entrySet().iterator().next());
		assertNotNull(valueSupplementsWsDTO);
		assertEquals(VALUE_KEY, valueSupplementsWsDTO.getAttributeValueKey());
		final PriceWsDTO priceWsDTO = valueSupplementsWsDTO.getPriceValue();
		assertNotNull(priceWsDTO);
		assertEquals(priceValueAsDecimal, priceWsDTO.getValue());
	}

	@Test(expected = NullPointerException.class)
	public void testConvertEntrytoWsDTONullNotAllowed()
	{
		classUnderTest.convertEntrytoWsDTO(null);
	}

	@Test
	public void testConvertEntrytoWsDTOObsoletePrice()
	{
		final CsticValueSupplementsWsDTO valueSupplementsWsDTO = classUnderTest
				.convertEntrytoWsDTO(priceValueUpdateData.getPrices().entrySet().iterator().next());
		assertEquals(priceValueAsDecimal, valueSupplementsWsDTO.getObsoletePriceValue().getValue());
	}

	@Test
	public void testIsStandardGroupCsticGroup()
	{
		final UiGroupData csticGroup = createGroupWithOneCstic(GROUP1_ID, CSTIC_NAME_1, VALUE_NAME_1);
		assertTrue(classUnderTest.isStandardGroup(csticGroup));
	}

	@Test
	public void testIsStandardGroupInstanceGroup()
	{
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		assertTrue(classUnderTest.isStandardGroup(instanceGroup));
	}

	@Test
	public void testIsStandardGroupConflictGroup()
	{
		final UiGroupData conflictGroup = createConflictGroup();
		assertFalse(classUnderTest.isStandardGroup(conflictGroup));
	}

	@Test
	public void testIsStandardGroupConflictHeader()
	{
		final UiGroupData conflictHeaderGroup = createConflictHeaderGroup();
		assertFalse(classUnderTest.isStandardGroup(conflictHeaderGroup));
	}


	private void prepareBackendUpdatedConfigurationMultiLevel()
	{
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		groups.add(instanceGroup);
		final List<UiGroupData> subGroups = new ArrayList();
		instanceGroup.setSubGroups(subGroups);
		final UiGroupData subInstanceGroup = createInstanceGroup(GROUP3_1_ID);
		subGroups.add(subInstanceGroup);
		subGroups.add(createGroupWithOneCstic(GROUP3_2_ID, "CSTIC3", "VALUE3"));
		final List<UiGroupData> subSubGroups = new ArrayList();
		subInstanceGroup.setSubGroups(subSubGroups);
		subSubGroups.add(createGroupWithOneCstic(GROUP3_1_1_ID, "CSTIC4", "VALUE4"));
	}


	private UiGroupData createInstanceGroup(final String groupId)
	{
		final UiGroupData group = new UiGroupData();
		group.setGroupType(GroupType.INSTANCE);
		group.setId(groupId);
		return group;
	}

	private UiGroupData createConflictHeaderGroup()
	{
		final UiGroupData group = new UiGroupData();
		group.setGroupType(GroupType.CONFLICT_HEADER);
		group.setId("CONFLICT_HEADER");
		final List<UiGroupData> subGroups = new ArrayList();
		group.setSubGroups(subGroups);
		final UiGroupData conflictGroup = createConflictGroup();
		subGroups.add(conflictGroup);
		return group;
	}

	private UiGroupData createConflictGroup()
	{
		final UiGroupData group = new UiGroupData();
		group.setGroupType(GroupType.CONFLICT);
		group.setId("CONFLICT123456");
		final List<CsticData> cstics = new ArrayList();
		cstics.add(createCsticData(CSTIC_NAME_1, UiType.RADIO_BUTTON, VALUE_NAME_1));
		group.setCstics(cstics);
		return group;
	}

	private void prepareBackendUpdatedConfigurationConflict()
	{
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		final UiGroupData conflictHeaderGroup = createConflictHeaderGroup();
		groups.add(0, conflictHeaderGroup);
	}
}
