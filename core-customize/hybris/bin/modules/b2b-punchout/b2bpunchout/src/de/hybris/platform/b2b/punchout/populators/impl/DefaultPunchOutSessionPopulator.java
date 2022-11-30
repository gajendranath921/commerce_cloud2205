/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.populators.impl;

import de.hybris.platform.b2b.punchout.Organization;
import de.hybris.platform.b2b.punchout.PunchOutException;
import de.hybris.platform.b2b.punchout.PunchOutResponseCode;
import de.hybris.platform.b2b.punchout.PunchOutSession;
import de.hybris.platform.b2b.punchout.services.CXMLElementBrowser;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.cxml.CXML;
import org.cxml.Credential;
import org.cxml.Header;
import org.cxml.PunchOutSetupRequest;
import org.cxml.SharedSecret;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Populator from {@link CXML} to {@link PunchOutSession}.
 */
public class DefaultPunchOutSessionPopulator implements Populator<CXML, PunchOutSession>
{
	private static final List<String> BROWSER_FROM_POST_URL_SCHEME_ALLOW_LIST = Arrays.asList("https", "http");
	private static final Logger LOG = LoggerFactory.getLogger(DefaultPunchOutSessionPopulator.class);

	@Override
	public void populate(final CXML source, final PunchOutSession target) throws ConversionException
	{

		final CXMLElementBrowser cXmlBrowser = new CXMLElementBrowser(source);

		final PunchOutSetupRequest request = cXmlBrowser.findRequestByType(PunchOutSetupRequest.class);
		target.setOperation(request.getOperation());
		populateBuyerCookie(target, request);
		populateBrowserFormPostUrl(target, request);
		populateOrganizationInfo(cXmlBrowser.findHeader(), target);

	}

	protected void populateBrowserFormPostUrl(final PunchOutSession target, final PunchOutSetupRequest request)
	{
		try
		{
			final URL url = new URL(request.getBrowserFormPost().getURL().getvalue());
			if (BROWSER_FROM_POST_URL_SCHEME_ALLOW_LIST.contains(url.getProtocol())) {
				target.setBrowserFormPostUrl(url.toString());
			} else {
				throw new MalformedURLException();
			}
		}
		catch (MalformedURLException e)
		{
			LOG.warn("Malformed BrowserFormPostUrl: {}", request.getBrowserFormPost().getURL().getvalue());
			throw new PunchOutException(PunchOutResponseCode.BAD_REQUEST, "Malformed value for BrowserFormPostUrl");
		}

	}

	protected void populateOrganizationInfo(final Header header, final PunchOutSession punchoutSession)
	{

		punchoutSession.setInitiatedBy(convertCredentialsToOrganizations(header.getFrom().getCredential()));
		punchoutSession.setTargetedTo(convertCredentialsToOrganizations(header.getTo().getCredential()));
		punchoutSession.setSentBy(convertCredentialsToOrganizations(header.getSender().getCredential()));
		punchoutSession.setSentByUserAgent(header.getSender().getUserAgent());
	}

	protected List<Organization> convertCredentialsToOrganizations(final List<Credential> credentials)
	{
		final List<Organization> organizationList = new ArrayList<>();

		for (final Credential credential : credentials)
		{

			final Organization organization = new Organization();
			organization.setDomain(credential.getDomain());
			organization.setIdentity(credential.getIdentity().getContent().get(0).toString());
			organization.setSharedsecret(getSharedSecret(credential));
			organizationList.add(organization);

		}

		return organizationList;
	}

	protected String getSharedSecret(final Credential credential)
	{
		if (CollectionUtils.isNotEmpty(credential.getSharedSecretOrDigitalSignatureOrCredentialMac()))
		{
			if (credential.getSharedSecretOrDigitalSignatureOrCredentialMac().get(0) instanceof SharedSecret)
			{
				final SharedSecret sharedSecret = (SharedSecret) credential.getSharedSecretOrDigitalSignatureOrCredentialMac().get(0);
				if (CollectionUtils.isNotEmpty(sharedSecret.getContent()))
				{
					return (String) sharedSecret.getContent().get(0);
				}
			}
			else
			{
				LOG.warn("The Shared Secret, Digital Signature or Credential Mac was not populated in the Organization details. Please verify your implementation");
			}

		}

		return null;
	}

	protected void populateBuyerCookie(final PunchOutSession output, final PunchOutSetupRequest request)
	{
		if (request.getBuyerCookie() != null)
		{
			final String buyerCookieId = (String) request.getBuyerCookie().getContent().iterator().next();

			output.setBuyerCookie(buyerCookieId);
		}
	}

}
