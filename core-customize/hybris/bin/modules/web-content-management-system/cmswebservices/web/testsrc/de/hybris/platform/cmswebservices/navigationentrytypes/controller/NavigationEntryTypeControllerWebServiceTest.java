/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.navigationentrytypes.controller;

import static de.hybris.platform.webservicescommons.testsupport.client.WebservicesAssert.assertResponse;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cmswebservices.constants.CmswebservicesConstants;
import de.hybris.platform.cmswebservices.data.NavigationEntryTypeData;
import de.hybris.platform.cmswebservices.data.NavigationEntryTypeListData;
import de.hybris.platform.cmswebservices.util.ApiBaseIntegrationTest;
import de.hybris.platform.oauth2.constants.OAuth2Constants;
import de.hybris.platform.webservicescommons.testsupport.server.NeedsEmbeddedServer;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

@NeedsEmbeddedServer(webExtensions =
		{ CmswebservicesConstants.EXTENSIONNAME, OAuth2Constants.EXTENSIONNAME })
@IntegrationTest
public class NavigationEntryTypeControllerWebServiceTest extends ApiBaseIntegrationTest
{
	private static final String ENDPOINT = "/v1/navigationentrytypes";
	
	@Test
	public void testGetAllNavigationEntryTypes() throws CMSItemNotFoundException
	{
		final Response response = getCmsManagerWsSecuredRequestBuilder() //
			.path(ENDPOINT).build() //
			.accept(MediaType.APPLICATION_JSON) //
			.get();
		assertResponse(Response.Status.OK, response);
		final List<NavigationEntryTypeData> navigationEntryTypes = response.readEntity(NavigationEntryTypeListData.class)
				.getNavigationEntryTypes();
		assertThat(navigationEntryTypes.size(), is(3));
	}
}
