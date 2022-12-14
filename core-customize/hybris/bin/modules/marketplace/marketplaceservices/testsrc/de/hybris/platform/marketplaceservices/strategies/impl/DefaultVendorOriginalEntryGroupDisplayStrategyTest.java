/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.marketplaceservices.strategies.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.marketplaceservices.strategies.impl.DefaultVendorOriginalEntryGroupDisplayStrategy;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import org.apache.commons.configuration.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultVendorOriginalEntryGroupDisplayStrategyTest
{
	private DefaultVendorOriginalEntryGroupDisplayStrategy vendorOriginalEntryGroupDisplayStrategy;
	private static final String TEST_DISPLAY_CONFIG = "test.should.display.original.entrygroup";
	private static final boolean TEST_DISPLAY_ORIGENTRYGROUP = false;
	@Mock
	private ConfigurationService configurationService;

	@Before
	public void setUp()
	{
		vendorOriginalEntryGroupDisplayStrategy = new DefaultVendorOriginalEntryGroupDisplayStrategy();
		vendorOriginalEntryGroupDisplayStrategy.setConfigurationService(configurationService);
	}

	@Test
	public void testGetMobilePhoneNumber()
	{
		final Configuration configuration = mock(Configuration.class);

		Mockito.lenient().when(configuration.getBoolean(TEST_DISPLAY_CONFIG, false)).thenReturn(TEST_DISPLAY_ORIGENTRYGROUP);
		given(configurationService.getConfiguration()).willReturn(configuration);

		assertEquals(TEST_DISPLAY_ORIGENTRYGROUP, vendorOriginalEntryGroupDisplayStrategy.shouldDisplayOriginalEntryGroup());
	}
}
