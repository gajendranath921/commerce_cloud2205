/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 */
package de.hybris.platform.warehousing.returns.strategy.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.enums.ReturnStatus;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.returns.ReturnService;
import de.hybris.platform.returns.model.ReturnEntryModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class WarehousingOrderEntryBasedReturnableCheckTest
{
	private final WarehousingOrderEntryBasedReturnableCheck check = new WarehousingOrderEntryBasedReturnableCheck();
	private final Set<ReturnStatus> invalidReturnStatusForIncompleteReturns = new HashSet<>();
	private OrderModel order;

	@Mock
	private OrderEntryModel orderEntryNotInOrder;
	@Mock
	private OrderEntryModel orderEntryInOrder;
	@Mock
	private ReturnService returnService;
	@Mock
	private ModelService modelService;



	@Before
	public void setUp()
	{
		check.setReturnService(returnService);
		check.setInvalidReturnStatusForIncompleteReturns(invalidReturnStatusForIncompleteReturns);
		check.setModelService(modelService);
		order = new OrderModel();
		order.setEntries(Arrays.asList(orderEntryInOrder));
		when(orderEntryInOrder.getQuantityShipped()).thenReturn(10L);
		when(modelService.isNew(orderEntryInOrder)).thenReturn(false);
		when(modelService.isNew(orderEntryNotInOrder)).thenReturn(false);
		invalidReturnStatusForIncompleteReturns.add(ReturnStatus.CANCELED);
		invalidReturnStatusForIncompleteReturns.add(ReturnStatus.COMPLETED);
	}

	@Test
	public void shouldGetFalseWhenReturnQtyBelowOne()
	{
		assertFalse(check.perform(order, orderEntryInOrder, 0));
	}

	@Test
	public void shouldGetFalseWhenOrderEntryNotInOrder()
	{
		Mockito.lenient().when(orderEntryNotInOrder.getQuantityShipped()).thenReturn(10L);
		assertFalse(check.perform(order, orderEntryNotInOrder, 5));
	}

	@Test
	public void shouldGetFalseWhenReturnQtyHigherThanOrderEntry()
	{
		assertFalse(check.perform(order, orderEntryInOrder, 11));
	}

	@Test
	public void shouldGetTrueWhenReturnQtyEqualOrderEntry()
	{
		assertTrue(check.perform(order, orderEntryInOrder, 10));
	}

	@Test
	public void shouldGetTrueWhenReturnQtyLowerThanOrderEntry()
	{
		assertTrue(check.perform(order, orderEntryInOrder, 5));
	}

	@Test
	public void shouldGetLowerQtyWhenIncompleteReturnExists()
	{
		final ReturnEntryModel entry = new ReturnEntryModel();
		entry.setExpectedQuantity(1L);
		entry.setStatus(ReturnStatus.WAIT);

		when(returnService.getReturnEntry(orderEntryInOrder)).thenReturn(Arrays.asList(entry));

		assertFalse(check.perform(order, orderEntryInOrder, 10));
		assertTrue(check.perform(order, orderEntryInOrder, 9));
	}

	@Test
	public void shouldGetLowerQtyWhenCompleteReturnExists()
	{
		when(orderEntryInOrder.getQuantityReturned()).thenReturn(1L);

		assertFalse(check.perform(order, orderEntryInOrder, 10));
		assertTrue(check.perform(order, orderEntryInOrder, 9));
	}

	@Test
	public void shouldGetSameQtyWhenCancelledReturnExists()
	{
		final ReturnEntryModel entry = new ReturnEntryModel();
		entry.setExpectedQuantity(1L);
		entry.setStatus(ReturnStatus.CANCELED);

		when(returnService.getReturnEntry(orderEntryInOrder)).thenReturn(Arrays.asList(entry));

		assertTrue(check.perform(order, orderEntryInOrder, 10));
	}
	
	@Test
	public void shouldGetFalseWhenOrderEntryNotPersisted()
	{	
		when(modelService.isNew(orderEntryInOrder)).thenReturn(true);
		assertFalse(check.perform(order, orderEntryInOrder, 1));		
	}
}
