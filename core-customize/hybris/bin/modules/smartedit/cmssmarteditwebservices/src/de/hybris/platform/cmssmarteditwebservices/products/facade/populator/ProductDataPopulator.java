/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.products.facade.populator;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cmsfacades.data.ProductData;
import de.hybris.platform.cmsfacades.uniqueidentifier.UniqueItemIdentifierService;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.springframework.beans.factory.annotation.Required;

/**
 * Basic class for populating {@link de.hybris.platform.cmssmarteditwebservices.data.ProductData} from {@link ProductData} data.  
 */
public class ProductDataPopulator implements Populator<ProductData, de.hybris.platform.cmssmarteditwebservices.data.ProductData>
{
	
	private UniqueItemIdentifierService uniqueItemIdentifierService;
	private CatalogVersionService catalogVersionService;
	private ProductService productService;
	
	@Override
	public void populate(final ProductData source,
			final de.hybris.platform.cmssmarteditwebservices.data.ProductData target) throws ConversionException
	{
		final CatalogVersionModel catalogVersion = getCatalogVersionService().getCatalogVersion(source.getCatalogId(),
				source.getCatalogVersion());

		final ProductModel product = getProductService().getProductForCode(catalogVersion, source.getCode());
		
		getUniqueItemIdentifierService().getItemData(product).ifPresent(itemData -> target.setUid(itemData.getItemId()));

		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setCatalogId(source.getCatalogId());
		target.setCatalogVersion(source.getCatalogVersion());
	}

	protected UniqueItemIdentifierService getUniqueItemIdentifierService()
	{
		return uniqueItemIdentifierService;
	}

	@Required
	public void setUniqueItemIdentifierService(final UniqueItemIdentifierService uniqueItemIdentifierService)
	{
		this.uniqueItemIdentifierService = uniqueItemIdentifierService;
	}

	protected CatalogVersionService getCatalogVersionService()
	{
		return catalogVersionService;
	}

	@Required
	public void setCatalogVersionService(final CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
	}

	protected ProductService getProductService()
	{
		return productService;
	}

	@Required
	public void setProductService(final ProductService productService)
	{
		this.productService = productService;
	}
}
