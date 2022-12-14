/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.converters.populator;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.classification.ClassificationService;
import de.hybris.platform.classification.features.Feature;
import de.hybris.platform.classification.features.FeatureList;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test suite for {@link ProductClassificationPopulator}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ProductClassificationPopulatorTest
{
	@Mock
	private ClassificationService classificationService;
	@Mock
	private Populator<FeatureList, ProductData> productFeatureListPopulator;
	@Mock
	private ModelService modelService;

	private ProductClassificationPopulator productClassificationPopulator;


	@Before
	public void setUp()
	{
		productClassificationPopulator = new ProductClassificationPopulator();
		productClassificationPopulator.setModelService(modelService);
		productClassificationPopulator.setClassificationService(classificationService);
		productClassificationPopulator.setProductFeatureListPopulator(productFeatureListPopulator);
	}


	@Test
	public void testPopulate()
	{
		final ProductModel source = mock(ProductModel.class);
		final FeatureList featureList = mock(FeatureList.class);
		final Feature feature1 = mock(Feature.class);
		final Feature feature2 = mock(Feature.class);
		final List<Feature> features = new ArrayList<Feature>();
		features.add(feature1);
		features.add(feature2);

		given(featureList.getFeatures()).willReturn(features);
		given(classificationService.getFeatures(source)).willReturn(featureList);

		final ProductData result = new ProductData();
		productClassificationPopulator.populate(source, result);

		verify(productFeatureListPopulator).populate(featureList, result);
	}
}
