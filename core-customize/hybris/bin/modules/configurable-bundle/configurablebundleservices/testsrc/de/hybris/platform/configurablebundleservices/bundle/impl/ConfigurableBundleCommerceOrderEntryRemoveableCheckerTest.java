/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.configurablebundleservices.bundle.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.configurablebundleservices.bundle.BundleTemplateService;
import de.hybris.platform.configurablebundleservices.model.BundleSelectionCriteriaModel;
import de.hybris.platform.configurablebundleservices.model.BundleTemplateModel;
import de.hybris.platform.configurablebundleservices.model.PickExactlyNBundleSelectionCriteriaModel;
import de.hybris.platform.configurablebundleservices.model.PickNToMBundleSelectionCriteriaModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.order.EntryGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


/**
 * Test to see when an order entry can be deleted
 */
@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class ConfigurableBundleCommerceOrderEntryRemoveableCheckerTest
{

	@Mock
	private BundleTemplateService bundleTemplateService;
	@InjectMocks
	private final BundleCommerceOrderEntryRemoveableChecker checker = new BundleCommerceOrderEntryRemoveableChecker();

	private CartModel order;
	private CartEntryModel cartEntry;
	private EntryGroup entryGroup;
	private BundleTemplateModel bundleTemplate;

	@Before
	public void setUp()
	{
		order = new CartModel();
		cartEntry = new CartEntryModel();
		cartEntry.setOrder(order);
		cartEntry.setEntryGroupNumbers(new HashSet<>(Collections.singletonList(Integer.valueOf(5))));
		order.setEntries(new ArrayList<>());
		order.getEntries().add(cartEntry);
		bundleTemplate = new BundleTemplateModel();
		entryGroup = new EntryGroup();
		entryGroup.setGroupNumber(Integer.valueOf(5));
		entryGroup.setExternalReferenceId("bundleID");
		when(bundleTemplateService.getBundleTemplateForCode(eq("bundleID"))).thenReturn(bundleTemplate);
		when(bundleTemplateService.getBundleEntryGroup(any(AbstractOrderEntryModel.class))).thenReturn(entryGroup);
	}

	@Test
	public void shouldRemoveNonBundleEntry()
	{
		when(bundleTemplateService.getBundleEntryGroup(any(AbstractOrderEntryModel.class))).thenReturn(null);
		Assert.assertTrue(checker.canRemove(cartEntry));
	}

	@Test
	public void shouldNotDeleteItemsWhichDontSatisfyMinCondition()
	{
		final BundleSelectionCriteriaModel pickExactly6 = new PickExactlyNBundleSelectionCriteriaModel();
		((PickExactlyNBundleSelectionCriteriaModel) pickExactly6).setN(Integer.valueOf(6));
		bundleTemplate.setBundleSelectionCriteria(pickExactly6);
		final CartEntryModel cartEntryFromGroup1 = new CartEntryModel();
		cartEntryFromGroup1.setEntryGroupNumbers(new HashSet<>(Collections.singletonList(Integer.valueOf(5))));
		order.getEntries().add(cartEntryFromGroup1);

		Assert.assertFalse(checker.canRemove(cartEntry));
	}

	@Test
	public void shouldDeleteItemsWhichSatisfyMinCondition()
	{
		final BundleSelectionCriteriaModel pick2to4 = new PickNToMBundleSelectionCriteriaModel();
		((PickNToMBundleSelectionCriteriaModel) pick2to4).setN(Integer.valueOf(2));
		((PickNToMBundleSelectionCriteriaModel) pick2to4).setM(Integer.valueOf(4));
		bundleTemplate.setBundleSelectionCriteria(pick2to4);
		final CartEntryModel cartEntryFromGroup1 = new CartEntryModel();
		cartEntryFromGroup1.setEntryGroupNumbers(new HashSet<>(Collections.singletonList(Integer.valueOf(5))));
		order.getEntries().add(cartEntryFromGroup1);
		final CartEntryModel cartEntryFromGroup2 = new CartEntryModel();
		cartEntryFromGroup2.setEntryGroupNumbers(new HashSet<>(Collections.singletonList(Integer.valueOf(5))));
		order.getEntries().add(cartEntryFromGroup2);

		Assert.assertTrue(checker.canRemove(cartEntry));

	}

	@Test
	public void shouldDeleteItemWithNullSelectionCriteria()
	{
		bundleTemplate.setBundleSelectionCriteria(null);

		Assert.assertTrue(checker.canRemove(cartEntry));
	}

}
