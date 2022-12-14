/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.cockpitng.modules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.bootstrap.config.ExtensionInfo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.hybris.backoffice.constants.BackofficeConstants;
import com.hybris.cockpitng.testing.AbstractCockpitngUnitTest;
import com.hybris.cockpitng.testing.annotation.ExtensibleWidget;


@ExtensibleWidget(level = ExtensibleWidget.ALL)
@RunWith(MockitoJUnitRunner.class)
public class BackofficeModuleConnectorTest extends AbstractCockpitngUnitTest<BackofficeModuleConnector>
{

	@Spy
	@InjectMocks
	private BackofficeModuleConnector connector;

	@Test
	public void resolveParentModulesNoDependencies()
	{
		//given
		final ExtensionInfo info = mockExtensioninfo("root", true);
		Mockito.lenient().when(info.getRequiredExtensionInfos()).thenReturn(Collections.emptySet());

		//when
		final Collection<String> parentModules = connector.resolveParentModules(info);

		//then
		verify(info).getAllRequiredExtensionInfos();
		assertThat(parentModules).isEmpty();
	}

	@Test
	public void resolveParentModulesWithDependencies()
	{
		//given
		final ExtensionInfo info = mockExtensioninfo("root", true);
		final HashSet<ExtensionInfo> requiredModules = new HashSet<>();

		requiredModules.add(mockExtensioninfo("childOne", true));
		requiredModules.add(mockExtensioninfo("childTwo", true));
		requiredModules.add(mockExtensioninfo("childThree", false));

		when(info.getAllRequiredExtensionInfos()).thenReturn(requiredModules);

		//when
		final Collection<String> parentModules = connector.resolveParentModules(info);

		//then
		verify(info).getAllRequiredExtensionInfos();
		assertThat(parentModules).hasSize(2);
		assertThat(parentModules).containsOnly("extension://childOne", "extension://childTwo");
	}

	protected ExtensionInfo mockExtensioninfo(final String name, final boolean backofficeNature)
	{
		final ExtensionInfo info = mock(ExtensionInfo.class);
		when(info.getName()).thenReturn(name);
		when(info.getMeta(BackofficeConstants.BACKOFFICE_MODULE_META_KEY)).thenReturn(Boolean.toString(backofficeNature));
		return info;
	}

}
