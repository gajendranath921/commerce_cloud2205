/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.e2e.transport.cts;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.e2e.transport.cts.impl.SimpleCtsClient;

import java.io.File;
import java.io.FileOutputStream;
import java.net.Authenticator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.mockito.InOrder;

import com.sap.document.sap.soap.functions.mc_style.BasicAuthenticator;
import com.sap.document.sap.soap.functions.mc_style.CtsWsReply;
import com.sap.document.sap.soap.functions.mc_style.CtsWsRequest;
import com.sap.document.sap.soap.functions.mc_style.CtsWsRequestFilter;
import com.sap.document.sap.soap.functions.mc_style.CtsWsRequestResponse;
import com.sap.document.sap.soap.functions.mc_style.CtsWsResponse;
import com.sap.document.sap.soap.functions.mc_style.CtsWsTraResponse;
import com.sap.document.sap.soap.functions.mc_style.CtsWsTransportEntity;
import com.sap.document.sap.soap.functions.mc_style.CtsWsUploadResponse;


/**
 * CTS+ client test.
 *
 */

public class CtsClientUnitTest
{
	private static final String RESPONSE_NOT_NULL = "Response cannot be null";
	private CtsClient client;

	private CtsService service;

	@Before
	public void prepareTest()
	{
		final ConfigurationHolder holder = new TestConfigurationHolder();

		Authenticator.setDefault(new BasicAuthenticator(holder));

		service = mock(CtsService.class);

		final File testFile = new File("testChange.zip");
		final ZipEntry ze = new ZipEntry("testfile.txt");

		try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(testFile)); )
		{
			StringBuilder sb = new StringBuilder();
			sb.append("Test");
			out.putNextEntry(ze);

			byte[] data = sb.toString().getBytes();
			out.write(data, 0, data.length);

			out.closeEntry();
		}
		catch(Exception e)
		{
			fail("Test file cannot be created");
		}
		client = new SimpleCtsClient(holder, service, testFile.getAbsolutePath());
	}

	@Test
	public void testUploadFile()
	{
		testGetDefaltRequest();
		testUploadBytesIntoFile();
	}

	@Ignore("ignored")
	@Test
	public void testSequenceCall()
	{
		prepareContractForGetDefaultRequest();
		prepareContractForUploadBytesIntoFile();
		prepareContractForAttachToRequest();
		prepareContractForSubmitRequest();

		client.uploadFile();

		final InOrder inOrder = inOrder(service);
		inOrder.verify(service).getDefaultRequest(anyString(), anyString(), any(CtsWsRequestFilter.class));
		inOrder.verify(service).uploadBytesIntoFile(any(byte[].class), anyString());
		inOrder.verify(service).appendBytesIntoFile(any(byte[].class), anyString());
		inOrder.verify(service).attachToRequest(any(CtsWsTransportEntity.class), anyString());
		inOrder.verify(service).submitRequest(anyString());
	}

	public void testGetDefaltRequest()
	{
		prepareContractForGetDefaultRequest();
		final CtsWsRequestResponse response = client.getDefaultRequest();
		client.setRequestResponse(response);
		assertNotNull(RESPONSE_NOT_NULL, response);
	}

	/**
	 * Prepares Mockito's contract for get default request phase
	 */
	private void prepareContractForGetDefaultRequest()
	{
		final CtsWsRequestResponse ctsWsRequestResponse = new CtsWsRequestResponse();
		ctsWsRequestResponse.setRequest(new CtsWsRequest());
		final CtsWsResponse wsResponse = new CtsWsResponse();
		wsResponse.setReply(new CtsWsReply());
		ctsWsRequestResponse.setTraResponse(wsResponse);

		when(service.getDefaultRequest(anyString(), anyString(), any(CtsWsRequestFilter.class))).thenReturn(ctsWsRequestResponse);
	}

	public void testUploadBytesIntoFile()
	{
		prepareContractForUploadBytesIntoFile();

		final CtsWsUploadResponse uploadResponse = client.internalUploadFile();
		client.setUploadResponse(uploadResponse);

		assertNotNull(RESPONSE_NOT_NULL, uploadResponse);
	}

	/**
	 * Prepares Mockito's contract for upload phase
	 */
	private void prepareContractForUploadBytesIntoFile()
	{
		final CtsWsUploadResponse response = new CtsWsUploadResponse();
		response.setReply(new CtsWsReply());
		when(service.uploadBytesIntoFile(any(byte[].class), anyString())).thenReturn(response);
		when(service.appendBytesIntoFile(any(byte[].class), anyString())).thenReturn(response);
	}

	public void testAttachToRequest()
	{
		prepareContractForAttachToRequest();
		final CtsWsTraResponse traResponse = client.attachToRequest();

		assertNotNull(RESPONSE_NOT_NULL, traResponse);
	}

	/**
	 * Prepares Mockito's contract for attach to request phase
	 */
	private void prepareContractForAttachToRequest()
	{
		final CtsWsTraResponse response = new CtsWsTraResponse();
		response.setReply(new CtsWsReply());
		when(service.attachToRequest(any(CtsWsTransportEntity.class), anyString())).thenReturn(response);
	}

	public void testSubmitRequest()
	{
		prepareContractForSubmitRequest();

		final CtsWsTraResponse traResponse = client.submitRequest();
		assertNotNull(RESPONSE_NOT_NULL, traResponse);
	}

	/**
	 * Prepares Mockito's contract for submit request phase
	 */
	private void prepareContractForSubmitRequest()
	{
		final CtsWsTraResponse response = new CtsWsTraResponse();
		response.setReply(new CtsWsReply());

		when(service.submitRequest(anyString())).thenReturn(response);
	}
}
