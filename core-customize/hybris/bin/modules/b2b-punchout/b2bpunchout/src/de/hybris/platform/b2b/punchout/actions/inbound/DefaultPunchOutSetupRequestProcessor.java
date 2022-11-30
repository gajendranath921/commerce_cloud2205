/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.actions.inbound;

import de.hybris.platform.b2b.punchout.PunchOutException;
import de.hybris.platform.b2b.punchout.PunchOutResponseCode;
import de.hybris.platform.b2b.punchout.PunchOutResponseMessage;
import de.hybris.platform.b2b.punchout.PunchOutUtils;
import de.hybris.platform.b2b.punchout.services.CXMLBuilder;
import de.hybris.platform.b2b.punchout.services.PunchOutService;
import de.hybris.platform.b2b.punchout.services.PunchOutSessionService;

import org.cxml.CXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default implementation of {@link PunchOutService}.
 */
public class DefaultPunchOutSetupRequestProcessor implements PunchOutInboundProcessor
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultPunchOutSetupRequestProcessor.class);

	private DefaultPunchOutAuthenticationVerifier punchoutAuthenticationVerifier;
	private PunchOutSetupRequestCartProcessing punchOutSetupRequestCartProcessing;
	private PopulateSetupResponsePunchOutProcessing populateSetupResponsePunchOutProcessing;
	private PunchOutSessionService punchoutSessionService;

	@Override
	public CXML generatecXML(final CXML request)
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug("CXML request {}", PunchOutUtils.marshallFromBeanTree(request));
		}
		final CXML response = CXMLBuilder.newInstance().withResponseCode(PunchOutResponseCode.SUCCESS)
				.withResponseMessage(PunchOutResponseMessage.SUCCESS).create();

		try
		{
			//Step through the process of setting up a request. This handles operations, create, edit.
			getPunchOutAuthenticationVerifier().verify(request);
			getPunchOutSessionService().initAndActivatePunchOutSession(request);
			getPunchOutSetupRequestCartProcessing().processCartData(request);
			getPunchOutSessionService().saveCurrentPunchoutSession();
			getPopulateSetupResponsePunchOutProcessing().populateResponse(response);
		}
		catch (final PunchOutException error)
		{
			final String message = String.format(
					"The request processing is canceled due to the following exception, the cxml error code is %s. This was written to the response.",
					error.getErrorCode());
			LOG.error(message, error);

			return CXMLBuilder.newInstance().withResponseCode(error.getErrorCode()).withResponseMessage(error.getMessage())
						.create();
		}
		if (LOG.isDebugEnabled())
		{
			LOG.debug("CXML response {}", PunchOutUtils.marshallFromBeanTree(response));
		}
		return response;
	}

	protected DefaultPunchOutAuthenticationVerifier getPunchOutAuthenticationVerifier()
	{
		return punchoutAuthenticationVerifier;
	}

	public void setPunchOutAuthenticationVerifier(final DefaultPunchOutAuthenticationVerifier punchoutAuthenticationVerifier)
	{
		this.punchoutAuthenticationVerifier = punchoutAuthenticationVerifier;
	}

	protected PunchOutSessionService getPunchOutSessionService()
	{
		return punchoutSessionService;
	}

	public void setPunchOutSessionService(final PunchOutSessionService punchoutSessionService)
	{
		this.punchoutSessionService = punchoutSessionService;
	}

	/**
	 * @return the punchOutSetupRequestCartProcessing
	 */
	protected PunchOutSetupRequestCartProcessing getPunchOutSetupRequestCartProcessing()
	{
		return punchOutSetupRequestCartProcessing;
	}

	/**
	 * @param punchOutSetupRequestCartProcessing
	 *           the punchOutSetupRequestCartProcessing to set
	 */
	public void setPunchOutSetupRequestCartProcessing(final PunchOutSetupRequestCartProcessing punchOutSetupRequestCartProcessing)
	{
		this.punchOutSetupRequestCartProcessing = punchOutSetupRequestCartProcessing;
	}

	/**
	 * @return the populateSetupResponsePunchOutProcessing
	 */
	protected PopulateSetupResponsePunchOutProcessing getPopulateSetupResponsePunchOutProcessing()
	{
		return populateSetupResponsePunchOutProcessing;
	}

	/**
	 * @param populateSetupResponsePunchOutProcessing
	 *           the populateSetupResponsePunchOutProcessing to set
	 */
	public void setPopulateSetupResponsePunchOutProcessing(
			final PopulateSetupResponsePunchOutProcessing populateSetupResponsePunchOutProcessing)
	{
		this.populateSetupResponsePunchOutProcessing = populateSetupResponsePunchOutProcessing;
	}
}
