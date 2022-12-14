/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.integrationservices.service;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectDescriptor;
import de.hybris.platform.integrationservices.populator.ItemToMapConversionContext;

import java.util.Map;

import javax.validation.constraints.NotNull;


/**
 * The service class that can convert any type system item into a Map which is representation of the Integration Object.
 */
public interface IntegrationObjectConversionService
{
	/**
	 * Convert the item model to a Map<String,Object> which is representation of the Integration Object.
	 *
	 * @param itemModel             the item model
	 * @param integrationObjectCode the integration object code
	 * @return a Map<String,Object> representation of the Integration Object.
	 */
	Map<String, Object> convert(ItemModel itemModel, String integrationObjectCode);

	/**
	 * Converts a context object to a {@code Map}.
	 *
	 * @param context a context containing the data item to convert and the integration object item model describing structure of
	 *                the conversion result.
	 * @return a Map<String,Object> representation of the data item.
	 */
	Map<String, Object> convert(ItemToMapConversionContext context);

	/**
	 * Converts an item model to a {@code Map}.
	 *
	 * @param itemModel    an item model to convert
	 * @param ioDescriptor an integration object descriptor
	 * @return a Map<String,Object> representation of the item model
	 */
	Map<String, Object> convert(@NotNull ItemModel itemModel, @NotNull IntegrationObjectDescriptor ioDescriptor);

}
