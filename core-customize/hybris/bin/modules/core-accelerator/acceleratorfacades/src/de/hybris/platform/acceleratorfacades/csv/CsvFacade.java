/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorfacades.csv;

import de.hybris.platform.commercefacades.order.data.CartData;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Facade for generating CSV content.
 */
public interface CsvFacade
{
	/**
	 * Generate CSV content from CartData
	 *
	 * @param headers
	 *           : list of text which is used as csv header; e.g Code,Name,Price
	 * @param includeHeader
	 *           : flag to indicate whether header should be generated
	 * @param cartData
	 * 			 : object containing cart details
	 * @param writer
	 *           : CSV content generated is written to the (buffered) writer
	 * @throws IOException
	 * 			 : throws in case of IO errors.
	 */
	void generateCsvFromCart(final List<String> headers, final boolean includeHeader, final CartData cartData, final Writer writer)
			throws IOException;
}
