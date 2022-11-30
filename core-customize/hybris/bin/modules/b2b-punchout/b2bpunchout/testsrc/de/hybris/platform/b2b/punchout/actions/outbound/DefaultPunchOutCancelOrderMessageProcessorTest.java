/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.outbound;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.order.CartService;

import org.cxml.CXML;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultPunchOutCancelOrderMessageProcessorTest
{
	@InjectMocks
	private final DefaultPunchOutCancelOrderMessageProcessor punchOutCancelOrderMesssageProcessor = new DefaultPunchOutCancelOrderMessageProcessor();

	@Mock
	private DefaultPunchOutOrderMessageProcessor punchOutOrderMesssageProcessor;
	@Mock
	private CartService cartService;
	@Mock
	private CXML cxml;

	@Before
	public void setUp()
	{
		doReturn(cxml).when(punchOutOrderMesssageProcessor).generatecXML();
	}

	@Test
	public void testGenerateCxmlResponse()
	{
		assertThat(punchOutCancelOrderMesssageProcessor.generatecXML()).isNotNull();

		verify(cartService).removeSessionCart();
		verify(cartService).getSessionCart();
		verify(punchOutOrderMesssageProcessor).generatecXML();
		final InOrder inOrder = inOrder(cartService, punchOutOrderMesssageProcessor);
		inOrder.verify(cartService).removeSessionCart();
		inOrder.verify(cartService).getSessionCart();
		inOrder.verify(punchOutOrderMesssageProcessor).generatecXML();
	}
}
