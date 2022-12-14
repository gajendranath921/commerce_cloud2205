/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout.services;

import de.hybris.platform.b2b.punchout.util.CXmlDateUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Date;

import org.cxml.CXML;
import org.cxml.Response;
import org.cxml.Status;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CXMLBuilder
{
	private static final Logger LOG = LoggerFactory.getLogger(CXMLBuilder.class);

	private static final int RANDOM_INT_LIMIT = 10000;
	private static final int NUMBER_OF_RANDOM_BYTES = 20;

	private final CXmlDateUtil dateUtil = new CXmlDateUtil();

	private final CXML cXML;

	private final CXMLElementBrowser cxmlElementBrowser;

	private String responseMessage;

	private String responseCode;

	private CXMLBuilder()
	{
		cXML = createNewCXML();
		cxmlElementBrowser = new CXMLElementBrowser(cXML);
	}

	public static CXMLBuilder newInstance()
	{
		return new CXMLBuilder();
	}

	protected CXML createNewCXML()
	{
		final CXML instance = new CXML();

		instance.setTimestamp(dateUtil.formatDate(new Date()));
		instance.setPayloadID(generatePayload());
		// xml:lang is optional according to documentation and accepts default values, we set it
		// to en as default for now to simplify implementation
		instance.setXmlLang("en-US");
		return instance;
	}

	/**
	 * Generates a new payload ID in the required format: datetime.process id.random number@hostname. Note: Process ID is
	 * skipped as there's no easy way to get it.
	 *
	 * @return the payload ID
	 */
	protected String generatePayload()
	{
		final SecureRandom random = new SecureRandom();
		final byte[] bytes = new byte[NUMBER_OF_RANDOM_BYTES];
		random.nextBytes(bytes);
		return String.format("%s.%s@%s", Long.valueOf(new DateTime().getMillis()),
				Integer.valueOf(random.nextInt(RANDOM_INT_LIMIT)), findHostName());
	}

	/**
	 * @return the host name or just 'localhost' if not able to determine it
	 */
	protected String findHostName()
	{
		try
		{
			return InetAddress.getLocalHost().getHostName();
		}
		catch (final UnknownHostException e)
		{
			LOG.error("Failed to find host name.", e);
			return "localhost";
		}
	}

	/**
	 * @return the newly created {@link CXML} instance
	 */
	public CXML create()
	{
		if (responseCode != null || responseMessage != null)
		{
			final Status status = new Status();
			status.setCode(responseCode);
			status.setText(responseMessage);

			if (cxmlElementBrowser.hasResponse())
			{
				final Response response = cxmlElementBrowser.findResponse();
				response.setStatus(status);
			}
			else
			{
				final Response response = new Response();
				response.setStatus(status);
				cXML.getHeaderOrMessageOrRequestOrResponse().add(response);

			}
		}
		return cXML;
	}

	public CXMLBuilder withResponseCode(final String code)
	{
		this.responseCode = code;
		return this;
	}

	public CXMLBuilder withResponseMessage(final String message)
	{
		this.responseMessage = message;
		return this;
	}


}
