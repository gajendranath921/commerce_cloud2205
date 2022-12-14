/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.converters.populator;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.enums.StockLevelStatus;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.product.data.StockData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test suite for {@link ProductStockPopulator}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ProductStockPopulatorTest
{
	private static final Long AVAILABLE_STOCK = Long.valueOf(99);

	@Mock
	private ModelService modelService;
	@Mock
	private Converter<ProductModel, StockData> stockConverter;

	private ProductStockPopulator<ProductModel, ProductData> productStockPopulator;

	@Before
	public void setUp()
	{
		productStockPopulator = new ProductStockPopulator<ProductModel, ProductData>();
		productStockPopulator.setModelService(modelService);
		productStockPopulator.setStockConverter(stockConverter);
	}


	@Test
	public void testPopulateNoStockSystem()
	{
		final ProductModel source = mock(ProductModel.class);
		final StockData stockData = mock(StockData.class);

		given(stockConverter.convert(source)).willReturn(stockData);
		given(stockData.getStockLevel()).willReturn(null);
		given(stockData.getStockLevelStatus()).willReturn(StockLevelStatus.INSTOCK);

		final ProductData result = new ProductData();
		productStockPopulator.populate(source, result);

		Assert.assertEquals(StockLevelStatus.INSTOCK, result.getStock().getStockLevelStatus());
		Assert.assertEquals(null, result.getStock().getStockLevel());
	}


	@Test
	public void testPopulateOutOfStock()
	{
		final ProductModel source = mock(ProductModel.class);
		final StockData stockData = mock(StockData.class);

		given(stockConverter.convert(source)).willReturn(stockData);
		given(stockData.getStockLevel()).willReturn(Long.valueOf(0));
		given(stockData.getStockLevelStatus()).willReturn(StockLevelStatus.OUTOFSTOCK);

		final ProductData result = new ProductData();
		productStockPopulator.populate(source, result);

		Assert.assertEquals(Long.valueOf(0), result.getStock().getStockLevel());
		Assert.assertEquals(StockLevelStatus.OUTOFSTOCK, result.getStock().getStockLevelStatus());
	}

	@Test
	public void testPopulateInStock()
	{
		final ProductModel source = mock(ProductModel.class);
		final StockData stockData = mock(StockData.class);

		given(stockConverter.convert(source)).willReturn(stockData);
		given(stockData.getStockLevel()).willReturn(AVAILABLE_STOCK);
		given(stockData.getStockLevelStatus()).willReturn(StockLevelStatus.INSTOCK);

		final ProductData result = new ProductData();
		productStockPopulator.populate(source, result);

		Assert.assertEquals(AVAILABLE_STOCK, result.getStock().getStockLevel());
		Assert.assertEquals(StockLevelStatus.INSTOCK, result.getStock().getStockLevelStatus());
	}
}
