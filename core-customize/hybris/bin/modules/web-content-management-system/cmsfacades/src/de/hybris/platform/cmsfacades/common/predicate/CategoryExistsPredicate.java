/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.predicate;

import de.hybris.platform.cmsfacades.common.service.ProductCatalogItemModelFinder;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Required;


/**
 * Predicate to test if a collection of categoryCodes each individually map to a Category.
 * <p>
 * Returns <tt>TRUE</tt> if the restriction exists; <tt>FALSE</tt> otherwise.
 * </p>
 */
public class CategoryExistsPredicate implements Predicate<String>
{
	private ProductCatalogItemModelFinder productCatalogItemModelFinder;

	@Override
	public boolean test(final String compositeCategoryKey)
	{
		boolean result = true;
		try
		{
			getProductCatalogItemModelFinder().getCategoryForCompositeKey(compositeCategoryKey);
		}
		catch (final UnknownIdentifierException | ConversionException e)
		{
			result = false;
		}
		return result;
	}

	protected ProductCatalogItemModelFinder getProductCatalogItemModelFinder()
	{
		return productCatalogItemModelFinder;
	}

	@Required
	public void setProductCatalogItemModelFinder(final ProductCatalogItemModelFinder productCatalogItemModelFinder)
	{
		this.productCatalogItemModelFinder = productCatalogItemModelFinder;
	}

}
