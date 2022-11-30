/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.datahubbackoffice.dataaccess.metadata.impl;

import com.hybris.cockpitng.dataaccess.facades.type.DataType;
import de.hybris.platform.datahubbackoffice.TestApplicationContext;
import de.hybris.platform.datahubbackoffice.dataaccess.metadata.DataHubTypeService;
import de.hybris.platform.datahubbackoffice.service.datahub.DataHubServer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CachingTypeServiceUnitTest
{
	@Rule
	public TestApplicationContext applicationContext = new TestApplicationContext();

	@Mock
	private DataHubTypeService delegate;
	@InjectMocks
	private CachingTypeService service;

	@Before
	public void setUp()
	{
		when(delegate.getAllTypeCodes()).thenReturn(Arrays.asList("type1", "type2"));
		final DataType dataType = dataType("type1");
		when(delegate.getType("type1")).thenReturn(dataType);
	}

	private DataType dataType(final String code)
	{
		final DataType type = mock(DataType.class);
		when(type.getCode()).thenReturn(code);
		return type;
	}

	@Test
	public void queriesTypesFromTheDelegateService()
	{
		final Collection<String> codes = service.getAllTypeCodes();

		assertThat(codes).containsExactlyInAnyOrder("type1", "type2");
	}

	@Test
	public void cachesAllTypes()
	{
		// service called multiple times
		service.getAllTypeCodes();
		service.getAllTypeCodes();
		service.getAllTypeCodes();

		// the delegate service called only once
		verify(delegate).getAllTypeCodes();
	}

	@Test
	public void verifiesExistenceOfATypeCode()
	{
		boolean res = service.exists("type1");
		assertThat(res).isTrue();

		res = service.exists("missing_type");
		assertThat(res).isFalse();
	}

	@Test
	public void queriesDataTypeFromTheDelegate()
	{
		service.getType("type1");

		verify(delegate).getType("type1");
	}

	@Test
	public void resetsCachedValues()
	{
		// service is called after resetting the DataHub instance
		service.getAllTypeCodes();
		service.setDataHubServer(mock(DataHubServer.class));
		service.getAllTypeCodes();

		// the delegate service is re-queried again
		verify(delegate, times(2)).getAllTypeCodes();
	}

	@Test
	public void usesDataHubTypeServiceFromTheAppContextIfItWasNotInjected()
	{
		applicationContext.addBean("dataHubTypeService", delegate);
		service.setDelegate(null);

		assertThat(service.getAllTypeCodes()).containsOnlyElementsOf(delegate.getAllTypeCodes());
	}
}
