/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorfacades.component.synchronization.itemvisitors.impl;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.acceleratorcms.model.components.NavigationComponentModel;
import de.hybris.platform.cms2.model.navigation.CMSNavigationNodeModel;
import de.hybris.platform.core.model.ItemModel;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class NavigationComponentModelVisitorTest
{

	@Mock
	private NavigationComponentModel nc;
	@Mock
	private CMSNavigationNodeModel node;
	@InjectMocks
	private NavigationComponentModelVisitor visitor;

	@Before
	public void setUp()
	{
		when(nc.getNavigationNode()).thenReturn(node);
	}

	@Test
	public void willCollectTheNavigationNode()
	{
		final List<ItemModel> visit = visitor.visit(nc, null, null);

		assertThat(visit, containsInAnyOrder(node));
	}
}
