/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.converters.populator;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.data.BaseOptionData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.product.data.VariantOptionData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.variants.model.VariantProductModel;
import de.hybris.platform.variants.model.VariantTypeModel;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test suite for {@link VariantFullPopulator}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class VariantFullPopulatorTest
{
	@Mock
	private Converter<VariantProductModel, VariantOptionData> variantOptionDataConverter;
	@Mock
	private Converter<VariantProductModel, BaseOptionData> baseOptionDataConverter;

	private VariantFullPopulator variantFullPopulator;


	@Before
	public void setUp()
	{
		variantFullPopulator = new VariantFullPopulator();
		variantFullPopulator.setBaseOptionDataConverter(baseOptionDataConverter);
		variantFullPopulator.setVariantOptionDataConverter(variantOptionDataConverter);
	}


	@Test
	public void testPopulate()
	{
		final VariantProductModel source = mock(VariantProductModel.class);
		final ProductModel baseProduct = mock(ProductModel.class);
		final VariantOptionData baseVariantOptionData = mock(VariantOptionData.class);
		final VariantTypeModel variantTypeModel = mock(VariantTypeModel.class);
		final VariantProductModel variantProductModel = mock(VariantProductModel.class);
		final VariantOptionData variantOptionData = mock(VariantOptionData.class);
		final BaseOptionData baseOptionData = mock(BaseOptionData.class);

		given(source.getBaseProduct()).willReturn(baseProduct);
		given(baseProduct.getVariants()).willReturn(Collections.singleton(source));
		given(baseOptionDataConverter.convert(source)).willReturn(baseOptionData);
		given(source.getVariantType()).willReturn(variantTypeModel);
		given(variantOptionDataConverter.convert(variantProductModel)).willReturn(variantOptionData);
		given(variantOptionDataConverter.convert(source)).willReturn(baseVariantOptionData);
		given(source.getVariants()).willReturn(Collections.singleton(variantProductModel));

		final ProductData result = new ProductData();
		variantFullPopulator.populate(source, result);

		Assert.assertEquals(1, result.getVariantOptions().size());
		Assert.assertTrue(result.getVariantOptions().contains(variantOptionData));
		Assert.assertEquals(1, result.getBaseOptions().size());
		Assert.assertTrue(result.getBaseOptions().contains(baseOptionData));
	}
}
