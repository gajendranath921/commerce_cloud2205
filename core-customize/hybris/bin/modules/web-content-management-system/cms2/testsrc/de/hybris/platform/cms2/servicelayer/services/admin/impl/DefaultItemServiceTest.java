/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2.servicelayer.services.admin.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.exceptions.ItemNotFoundException;
import de.hybris.platform.cms2.items.service.impl.DefaultItemService;
import de.hybris.platform.cms2.servicelayer.daos.ItemDao;
import de.hybris.platform.core.model.ItemModel;

import java.util.HashMap;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.Silent.class)
@UnitTest
public class DefaultItemServiceTest
{
	@InjectMocks
	private DefaultItemService defaultItemService;

	@Mock
	private ItemDao itemDao;

	@Mock
	private ItemModel itemModel;

	@Test
	public void shouldReturnItemModelIfProperAttributesProvided() throws ItemNotFoundException
	{
		// GIVEN
		when(itemDao.getItemByUniqueAttributesValues(any(), any())).thenReturn(Optional.of(itemModel));

		// WHEN
		final ItemModel resultItemModel = defaultItemService.getItemByAttributeValues("any", new HashMap<>());

		// THEN
		assertThat(resultItemModel, is(itemModel));
	}

	@Test(expected = ItemNotFoundException.class)
	public void shouldThrowExceptionIfItemModelNotFound() throws ItemNotFoundException
	{
		// GIVEN
		when(itemDao.getItemByUniqueAttributesValues(any(), any())).thenReturn(Optional.empty());

		// WHEN
		defaultItemService.getItemByAttributeValues("any", new HashMap<>());
	}
}
