/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.populators;

import static de.hybris.platform.cmsfacades.cmsitems.populators.AbstractCMSComponentContentPopulator.POSITION;
import static de.hybris.platform.cmsfacades.cmsitems.populators.AbstractCMSComponentContentPopulator.SLOT_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import de.hybris.platform.cms2.model.contents.contentslot.ContentSlotModel;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.relateditems.RelatedItemsService;
import de.hybris.platform.cms2.servicelayer.services.RelationBetweenComponentsService;
import de.hybris.platform.cms2.servicelayer.services.admin.CMSAdminContentSlotService;
import de.hybris.platform.cmsfacades.common.validator.ValidationDtoFactory;
import de.hybris.platform.cmsfacades.dto.ComponentTypeAndContentSlotValidationDto;
import de.hybris.platform.cmsfacades.uniqueidentifier.UniqueItemIdentifierService;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class AbstractCMSComponentContentPopulatorTest
{
	private static final String VALID_SLOT_UUID = "slot-uuid";
	private static final String INVALID_SLOT_UUID = "invalid-slot-uuid";
	private static final String VALID_PAGE_UUID = "valid-page-id";
	private static final String INVALID_PAGE_UUID = "invalid-page-id";
	private static final String PAGE_ID = "pageId";

	@InjectMocks
	private AbstractCMSComponentContentPopulator populator;

	@Mock
	private CMSAdminContentSlotService contentSlotAdminService;

	@Mock
	private UniqueItemIdentifierService uniqueItemIdentifierService;
	@Mock
	private ContentSlotModel contentSlot;
	@Mock
	private AbstractPageModel pageModel;
	@Mock
	private ValidationDtoFactory validationDtoFactory;
	@Mock
	private Predicate<ComponentTypeAndContentSlotValidationDto> componentTypeAllowedForContentSlotPredicate;
	@Mock
	private ComponentTypeAndContentSlotValidationDto componentTypeAndContentSlotValidationDto;

	@Mock
	private RelationBetweenComponentsService relationBetweenComponentsService;
	
	@Before
	public void setup()
	{
		when(uniqueItemIdentifierService.getItemModel(VALID_SLOT_UUID, ContentSlotModel.class)).thenReturn(Optional.of(contentSlot));
		when(uniqueItemIdentifierService.getItemModel(INVALID_SLOT_UUID, ContentSlotModel.class)).thenReturn(Optional.empty());

		when(validationDtoFactory.buildComponentTypeAndContentSlotValidationDto(Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(componentTypeAndContentSlotValidationDto);

		when(uniqueItemIdentifierService.getItemModel(VALID_PAGE_UUID, AbstractPageModel.class)).thenReturn(Optional.of(pageModel));
		when(uniqueItemIdentifierService.getItemModel(INVALID_PAGE_UUID, AbstractPageModel.class)).thenReturn(Optional.empty());

	}
	
	@Test(expected = ConversionException.class)
	public void testWhenItemModelIsNull_should_ThrowException()
	{
		populator.populate(null, null);
	}


	@Test(expected = ConversionException.class)
	public void testWhenMapIsNull_should_ThrowException()
	{
		populator.populate(null, new ItemModel());
	}

	@Test
	public void testAssignComponentToSlot()
	{
		final AbstractCMSComponentModel component = new AbstractCMSComponentModel();
		final Map<String, Object> sourceMap = new HashMap<>();
		sourceMap.put(SLOT_ID, VALID_SLOT_UUID);
		sourceMap.put(POSITION, 1);
		populator.populate(sourceMap, component);
		verify(contentSlotAdminService).addCMSComponentToContentSlot(component, contentSlot, 1);
	}
	
	@Test(expected = ConversionException.class)
	public void testInvalidSlotUUID()
	{
		final AbstractCMSComponentModel component = new AbstractCMSComponentModel();
		final Map<String, Object> sourceMap = new HashMap<>();
		sourceMap.put(SLOT_ID, INVALID_SLOT_UUID);
		sourceMap.put(POSITION, 1);
		populator.populate(sourceMap, component);
		fail();
	}

	@Test(expected = ConversionException.class)
	public void testInvalidPositionAndSlotUUIDPremise()
	{
		final AbstractCMSComponentModel component = new AbstractCMSComponentModel();
		final Map<String, Object> sourceMap = new HashMap<>();
		sourceMap.put(SLOT_ID, VALID_SLOT_UUID);
		sourceMap.put(POSITION, null);
		populator.populate(sourceMap, component);
		fail();
	}


	@Test(expected = ConversionException.class)
	public void shouldFail_TypeNotAllowedInSlot()
	{
		final AbstractCMSComponentModel component = new AbstractCMSComponentModel();
		final Map<String, Object> sourceMap = new HashMap<>();
		sourceMap.put(SLOT_ID, VALID_SLOT_UUID);
		sourceMap.put(POSITION, 1);
		sourceMap.put(PAGE_ID, VALID_PAGE_UUID);
		doNothing().when(relationBetweenComponentsService).maintainRelationBetweenComponentsOnComponent(component);
		when(componentTypeAllowedForContentSlotPredicate.test(Mockito.any(ComponentTypeAndContentSlotValidationDto.class)))
				.thenReturn(Boolean.FALSE);

		populator.populate(sourceMap, component);
	}


	@Test
	public void shouldNotFail_TypeNotAllowedInSlot()
	{
		final AbstractCMSComponentModel component = new AbstractCMSComponentModel();
		final Map<String, Object> sourceMap = new HashMap<>();
		sourceMap.put(SLOT_ID, VALID_SLOT_UUID);
		sourceMap.put(POSITION, 1);
		sourceMap.put(PAGE_ID, VALID_PAGE_UUID);
		doNothing().when(relationBetweenComponentsService).maintainRelationBetweenComponentsOnComponent(component);
		when(componentTypeAllowedForContentSlotPredicate.test(Mockito.any(ComponentTypeAndContentSlotValidationDto.class)))
				.thenReturn(Boolean.TRUE);

		populator.populate(sourceMap, component);
	}
}
