/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.converters.populator;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commerceservices.util.ConverterFactory;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.model.media.MediaFormatModel;
import de.hybris.platform.core.model.media.MediaModel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;



@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ImagePopulatorTest
{
	private static final String MEDIA_FORMAT_QUALIFIER = "mediaFormatQ";
	private static final String MEDIA_URL = "mediaURL";

	private final AbstractPopulatingConverter<MediaModel, ImageData> imageConverter = new ConverterFactory<MediaModel, ImageData, ImagePopulator>()
			.create(ImageData.class, new ImagePopulator());

	@Test
	public void testConvert()
	{
		final MediaModel source = mock(MediaModel.class);
		final MediaFormatModel mediaFormatModel = mock(MediaFormatModel.class);

		given(mediaFormatModel.getQualifier()).willReturn(MEDIA_FORMAT_QUALIFIER);
		given(source.getMediaFormat()).willReturn(mediaFormatModel);
		given(source.getURL()).willReturn(MEDIA_URL);

		final ImageData result = imageConverter.convert(source);

		Assert.assertEquals(MEDIA_FORMAT_QUALIFIER, result.getFormat());
		Assert.assertEquals(MEDIA_URL, result.getUrl());
	}

}
