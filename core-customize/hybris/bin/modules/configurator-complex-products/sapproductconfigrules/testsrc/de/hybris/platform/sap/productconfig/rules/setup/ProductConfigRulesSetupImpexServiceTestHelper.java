/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.rules.setup;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;


/**
 * helper class to avoid partial mocking of super class method.
 */
public class ProductConfigRulesSetupImpexServiceTestHelper extends ProductConfigRulesSetupImpexService
{
	private String contentToBeImported;

	protected String getContentToBeImported()
	{
		return contentToBeImported;
	}

	@Override
	protected void importImpexFile(final String file, final InputStream stream, final boolean legacyMode)
	{
		try
		{
			contentToBeImported = IOUtils.toString(stream, StandardCharsets.UTF_8);
		}
		catch (final IOException e)
		{
			contentToBeImported = e.getMessage();
		}
	}

}
