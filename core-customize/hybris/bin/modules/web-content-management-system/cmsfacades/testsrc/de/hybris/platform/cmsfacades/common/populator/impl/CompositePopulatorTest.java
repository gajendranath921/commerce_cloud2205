/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.populator.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import de.hybris.platform.cmsfacades.common.populator.impl.CompositePopulator;
import de.hybris.platform.cmsfacades.data.AbstractCMSComponentData;
import de.hybris.platform.converters.Populator;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class CompositePopulatorTest
{
	@Mock
	private Populator<AbstractCMSComponentData, AbstractCMSComponentModel> populator1;
	@Mock
	private Populator<AbstractCMSComponentData, AbstractCMSComponentModel> populator2;

	private final CompositePopulator<AbstractCMSComponentData, AbstractCMSComponentModel> populator = new CompositePopulator<>();
	private final AbstractCMSComponentData dto = new AbstractCMSComponentData();
	private final AbstractCMSComponentModel model = new AbstractCMSComponentModel();

	@Test
	public void shouldExecuteNoPopulators()
	{
		populator.setPopulators(Collections.emptyList());
		populator.populate(dto, model);
		verifyZeroInteractions(populator1);
		verifyZeroInteractions(populator2);
	}

	@Test
	public void shouldExecuteAllPopulators()
	{
		populator.setPopulators(Arrays.asList(populator1, populator2));
		populator.populate(dto, model);
		verify(populator1).populate(dto, model);
		verify(populator2).populate(dto, model);
	}
}
