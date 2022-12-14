/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.futurestock;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Service for 'Future Stock Management'.
 *
 * @spring.bean stockService
 */
public interface FutureStockService
{
	/**
	 * Gets the future product availability for the specified products, for each future date.
	 *
	 * @param products the list of products
	 * @return A map of quantity for each available date for each product in the list.
	 */
	Map<String, Map<Date, Integer>> getFutureAvailability(List<ProductModel> products);

}
