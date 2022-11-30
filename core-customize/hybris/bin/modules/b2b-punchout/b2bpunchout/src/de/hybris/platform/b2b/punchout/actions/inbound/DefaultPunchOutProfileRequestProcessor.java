/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.inbound;

import de.hybris.platform.b2b.punchout.PunchOutUtils;
import de.hybris.platform.b2b.punchout.services.CXMLBuilder;
import de.hybris.platform.b2b.punchout.services.PunchOutService;

import org.cxml.CXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default implementation of {@link PunchOutService}.
 */
public class DefaultPunchOutProfileRequestProcessor implements PunchOutInboundProcessor
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultPunchOutProfileRequestProcessor.class);

	private DefaultPunchOutAuthenticationVerifier punchOutAuthenticationVerifier;
	private DefaultPopulateProfileResponseProcessing populateProfileResponseProcessing;

	@Override
	public CXML generatecXML(final CXML request)
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug("CXML input:{}", PunchOutUtils.marshallFromBeanTree(request));
		}
		final CXML response = CXMLBuilder.newInstance().create();
		getPunchOutAuthenticationVerifier().verify(request);
		getPopulateProfileResponseProcessing().process(request, response);
		if (LOG.isDebugEnabled())
		{
			LOG.debug("CXML generated:{}", PunchOutUtils.marshallFromBeanTree(response));
		}
		return response;
	}

	/**
	 * @return the punchOutAuthenticationVerifier
	 */
	protected DefaultPunchOutAuthenticationVerifier getPunchOutAuthenticationVerifier()
	{
		return punchOutAuthenticationVerifier;
	}

	/**
	 * @param punchOutAuthenticationVerifier
	 *           the punchOutAuthenticationVerifier to set
	 */
	public void setPunchOutAuthenticationVerifier(final DefaultPunchOutAuthenticationVerifier punchOutAuthenticationVerifier)
	{
		this.punchOutAuthenticationVerifier = punchOutAuthenticationVerifier;
	}

	/**
	 * @return the populateProfileResponseProcessing
	 */
	protected DefaultPopulateProfileResponseProcessing getPopulateProfileResponseProcessing()
	{
		return populateProfileResponseProcessing;
	}

	/**
	 * @param populateProfileResponseProcessing
	 *           the populateProfileResponseProcessing to set
	 */
	public void setPopulateProfileResponseProcessing(final DefaultPopulateProfileResponseProcessing populateProfileResponseProcessing)
	{
		this.populateProfileResponseProcessing = populateProfileResponseProcessing;
	}

}
