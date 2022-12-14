/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.navigations.service.functions;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.model.contents.CMSItemModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class DefaultNavigationEntryCmsItemModelIdConversionFunctionTest
{

	private static final java.lang.String UID = "uid";

	private final DefaultNavigationEntryCmsItemModelIdConversionFunction conversionFunction = new DefaultNavigationEntryCmsItemModelIdConversionFunction();

	@Test
	public void testConversionWithCMSItemModelClass()
	{
		final CMSItemModel itemModel = new CMSItemModel();
		itemModel.setUid(UID);
		final String uid = conversionFunction.apply(itemModel);
		Assert.assertThat(uid, is(UID));
	}

	@Test(expected = ConversionException.class)
	public void testConversionWithInvalidItemModelClass()
	{
		final ItemModel itemModel = new ItemModel();
		conversionFunction.apply(itemModel);
		fail();
	}
}
