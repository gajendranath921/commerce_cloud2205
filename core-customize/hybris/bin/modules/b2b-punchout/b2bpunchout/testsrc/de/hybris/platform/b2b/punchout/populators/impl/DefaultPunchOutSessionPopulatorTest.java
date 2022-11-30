/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.populators.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.b2b.punchout.PunchOutException;
import de.hybris.platform.b2b.punchout.PunchOutResponseCode;
import de.hybris.platform.b2b.punchout.PunchOutSession;
import de.hybris.platform.b2b.punchout.PunchOutUtils;
import de.hybris.platform.b2b.punchout.services.CXMLElementBrowser;

import java.io.FileNotFoundException;

import org.cxml.CXML;
import org.cxml.PunchOutSetupRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultPunchOutSessionPopulatorTest
{
	@InjectMocks
	private DefaultPunchOutSessionPopulator punchOutSessionPopulator;

	private PunchOutSession punchoutSession;
	private CXML source;
	private CXMLElementBrowser cXmlBrowser;
	private PunchOutSetupRequest request;

	private void processCXmlRequest(String cxmlFile) throws FileNotFoundException
	{
		source = PunchOutUtils.unmarshallCXMLFromFile(cxmlFile);

		cXmlBrowser = new CXMLElementBrowser(source);
		request = cXmlBrowser.findRequestByType(PunchOutSetupRequest.class);
		punchoutSession = new PunchOutSession();
	}

	@Test
	public void testPopulate() throws FileNotFoundException
	{
		processCXmlRequest("b2bpunchout/test/punchoutSetupRequest.xml");
		punchOutSessionPopulator.populate(source, punchoutSession);

		// check header value population
		assertThat(punchoutSession).hasFieldOrPropertyWithValue("operation", request.getOperation())
				.hasFieldOrPropertyWithValue("browserFormPostUrl", request.getBrowserFormPost().getURL().getvalue());

		// check OrganizationInfo population
		assertThat(punchoutSession.getInitiatedBy()).hasSize(cXmlBrowser.findHeader().getFrom().getCredential().size());
		assertThat(punchoutSession.getTargetedTo()).hasSize(cXmlBrowser.findHeader().getTo().getCredential().size());
		assertThat(punchoutSession.getSentBy()).hasSize(cXmlBrowser.findHeader().getSender().getCredential().size());
		assertThat(punchoutSession.getSentByUserAgent()).isEqualTo(cXmlBrowser.findHeader().getSender().getUserAgent());

		// check buyer cookie population
		assertThat(punchoutSession.getBuyerCookie()).isEqualTo(request.getBuyerCookie().getContent().iterator().next());
	}

	@Test
	public void testPopulateWithMalformedBrowserFormUrl() throws FileNotFoundException
	{
		processCXmlRequest("b2bpunchout/test/malformedPunchoutSetupRequest.xml");
		final PunchOutException punchOutException = assertThrows(
				PunchOutException.class,
				() -> punchOutSessionPopulator.populate(source, punchoutSession)
		);
		assertThat(punchOutException)
				.hasMessage("Malformed value for BrowserFormPostUrl")
				.hasFieldOrPropertyWithValue("errorCode", PunchOutResponseCode.BAD_REQUEST);
	}
}
