/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.order.interceptors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.enums.QuoteState;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.keygenerator.KeyGenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Unit test of {@link DefaultQuotePrepareInterceptor}.
 */
@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultQuotePrepareInterceptorTest
{
	@Spy
	@InjectMocks
	private DefaultQuotePrepareInterceptor interceptor;

	@Mock
	private InterceptorContext mockInterceptorContext;

	@Mock
	private KeyGenerator mockKeyGenerator;

	private QuoteModel quote;

	@Before
	public void setUp() throws Exception
	{
		interceptor.setInitialVersion(Integer.valueOf(1));
		interceptor.setInitialState(QuoteState.CREATED);
		doReturn("Quote").when(interceptor).getLocalizedTypeName();

		quote = new QuoteModel();

		when(mockInterceptorContext.isNew(quote)).thenReturn(true);
		when(mockKeyGenerator.generate()).thenReturn("00000001");
	}

	@Test
	public void shouldSetInitialValues() throws InterceptorException
	{
		interceptor.onPrepare(quote, mockInterceptorContext);

		assertEquals("Unexpected code: ", "00000001", quote.getCode());
		assertEquals("Unexpected version: ", Integer.valueOf(1), quote.getVersion());
		assertEquals("Unexpected state: ", QuoteState.CREATED, quote.getState());
		assertEquals("Unexpected name: ", "Quote 00000001", quote.getName());
	}

}
