/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.rendering.attributeconverters;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.model.contents.CMSItemModel;
import de.hybris.platform.cmsfacades.rendering.visibility.RenderingVisibilityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class CMSItemToDataContentConverterTest
{
	// --------------------------------------------------------------------------
	// Variables
	// --------------------------------------------------------------------------
	private final String CMS_ITEM_UID = "some_uid";

	@Mock
	private CMSItemModel cmsItemModel;
	@Mock
	private RenderingVisibilityService renderingVisibilityService;

	@InjectMocks
	private CMSItemToDataContentConverter cmsItemToDataContentConverter;

	// --------------------------------------------------------------------------
	// Tests Setup
	// --------------------------------------------------------------------------
	@Before
	public void setUp()
	{
		when(cmsItemModel.getUid()).thenReturn(CMS_ITEM_UID);
		when(renderingVisibilityService.isVisible(cmsItemModel)).thenReturn(true);
	}

	// --------------------------------------------------------------------------
	// Tests
	// --------------------------------------------------------------------------
	@Test
	public void givenSourceIsNull_WhenConvertIsCalled_ThenItReturnsNull()
	{
		// WHEN
		String result = cmsItemToDataContentConverter.convert(null);

		// THEN
		assertThat(result, nullValue());
	}

	@Test
	public void givenCmsItem_WhenConvertIsCalled_ThenItReturnsTheItemUid()
	{
		// WHEN
		String result = cmsItemToDataContentConverter.convert(cmsItemModel);

		// THEN
		assertThat(result, is(CMS_ITEM_UID));
	}
}
