/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.frontend.beforeview;

import de.hybris.platform.sap.productconfig.facades.ProductConfigBeforeViewExtender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;


/**
 * Provides default extender implementation
 */
public class ProductConfigDefaultBeforeViewExtender implements ProductConfigBeforeViewExtender
{
	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response, final ModelMap model,
			final String viewName)
	{
		return;
	}
}
