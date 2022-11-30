/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.inbound;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.b2b.punchout.PunchOutResponseCode;
import de.hybris.platform.b2b.punchout.PunchOutResponseMessage;
import de.hybris.platform.b2b.punchout.PunchOutUtils;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;

import java.io.FileNotFoundException;

import org.cxml.CXML;
import org.cxml.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultPunchOutOrderRequestProcessorTest
{
	@InjectMocks
	private DefaultPunchOutOrderRequestProcessor punchOutOrderRequestProcessor;

	private CXML requestXML;
	private CartModel cartModel;

	@Mock
	private CartService cartService;
	@Mock
	private DefaultPunchOutAuthenticationVerifier punchoutAuthenticationVerifier;
	@Mock
	private PrepareCartPurchaseOrderProcessing prepareCartPurchaseOrderProcessing;
	@Mock
	private PopulateCartPurchaseOrderProcessing populateCartPurchaseOrderProcessing;
	@Mock
	private PlacePurchaseOrderProcessing placePurchaseOrderProcessing;

	@Before
	public void setUp() throws FileNotFoundException
	{
		requestXML = PunchOutUtils.unmarshallCXMLFromFile("b2bpunchout/test/sampleOrderRequest.xml");

		cartModel = new CartModel();
		when(cartService.getSessionCart()).thenReturn(cartModel);
	}

	@Test
	public void testGenerateCxmlResponse()
	{
		final CXML responseXML = punchOutOrderRequestProcessor.generatecXML(requestXML);

		assertThat(responseXML).isNotNull();

		verify(cartService).removeSessionCart();
		verify(cartService).getSessionCart();

		verify(punchoutAuthenticationVerifier).verify(requestXML);
		verify(populateCartPurchaseOrderProcessing).process(requestXML, cartModel);
		verify(prepareCartPurchaseOrderProcessing).process();
		verify(placePurchaseOrderProcessing).process();

		final Response response = (Response) responseXML.getHeaderOrMessageOrRequestOrResponse().get(0);
		assertThat(response).isNotNull()
							.hasFieldOrPropertyWithValue("status.code", PunchOutResponseCode.SUCCESS)
							.hasFieldOrPropertyWithValue("status.text", PunchOutResponseMessage.OK);
	}
}
