/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.media.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.util.config.ConfigIntf;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.ImmutableMap;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultMediaHeadersRegistryTest
{
	private static final String LEGACY_HEADER = "mediafilter.response.header.";
	private static final String HEADER = "media.header.";

	private DefaultMediaHeadersRegistry registry;
	@Mock
	private ConfigIntf config;
	private Map<String, String> params1;

	@Before
	public void setUp() throws Exception
	{
		registry = new DefaultMediaHeadersRegistry()
		{
			@Override
			ConfigIntf getConfig()
			{
				return config;
			}
		};

		params1 = ImmutableMap.<String, String>of(LEGACY_HEADER + "foo", "bar", LEGACY_HEADER + "baz", "boom", HEADER + "foo2",
				"bar1", HEADER + "baz1", "moo", "nonHeader.property", "someValue");
	}

	@Test
	public void shouldReturnAllConfiguredHttpHeaders()
	{
		// given
		given(config.getAllParameters()).willReturn(params1);
		registry.init();

		// when
		final Map<String, String> headers = registry.getHeaders();

		// then
		assertThat(headers).isNotNull().isNotEmpty();
		assertThat(headers).hasSize(4);
		assertThat(headers.get("foo")).isEqualTo("bar");
		assertThat(headers.get("baz")).isEqualTo("boom");
		assertThat(headers.get("foo2")).isEqualTo("bar1");
		assertThat(headers.get("baz1")).isEqualTo("moo");

	}


}
