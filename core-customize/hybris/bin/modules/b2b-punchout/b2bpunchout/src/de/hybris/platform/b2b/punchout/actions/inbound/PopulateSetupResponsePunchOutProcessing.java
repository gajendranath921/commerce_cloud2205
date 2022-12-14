/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.inbound;

import de.hybris.platform.b2b.punchout.services.CXMLElementBrowser;
import de.hybris.platform.b2b.punchout.services.PunchOutConfigurationService;

import org.cxml.CXML;
import org.cxml.PunchOutSetupResponse;
import org.cxml.Response;
import org.cxml.StartPage;
import org.cxml.URL;

public class PopulateSetupResponsePunchOutProcessing
{
	private PunchOutConfigurationService punchOutConfigurationService;

	public void populateResponse(final CXML output)
	{
		final StartPage startPage = new StartPage();
		final URL url = new URL();
		url.setvalue(getPunchOutConfigurationService().getPunchOutLoginUrl());
		startPage.setURL(url);

		final PunchOutSetupResponse punchoutSetupResponse = new PunchOutSetupResponse();
		punchoutSetupResponse.setStartPage(startPage);

		final CXMLElementBrowser cxmlBrowser = new CXMLElementBrowser(output);

		if (cxmlBrowser.hasResponse())
		{
			cxmlBrowser
					.findResponse()
					.getProfileResponseOrPunchOutSetupResponseOrProviderSetupResponseOrGetPendingResponseOrSubscriptionListResponseOrSubscriptionContentResponseOrSupplierListResponseOrSupplierDataResponseOrAuthResponseOrDataResponseOrOrganizationDataResponse()
					.add(punchoutSetupResponse);
		}
		else
		{
			final Response response = new Response();
			response
					.getProfileResponseOrPunchOutSetupResponseOrProviderSetupResponseOrGetPendingResponseOrSubscriptionListResponseOrSubscriptionContentResponseOrSupplierListResponseOrSupplierDataResponseOrAuthResponseOrDataResponseOrOrganizationDataResponse()
					.add(punchoutSetupResponse);

			output.getHeaderOrMessageOrRequestOrResponse().add(response);
		}
	}

	protected PunchOutConfigurationService getPunchOutConfigurationService()
	{
		return punchOutConfigurationService;
	}

	public void setPunchOutConfigurationService(final PunchOutConfigurationService punchOutConfigurationService)
	{
		this.punchOutConfigurationService = punchOutConfigurationService;
	}
}
