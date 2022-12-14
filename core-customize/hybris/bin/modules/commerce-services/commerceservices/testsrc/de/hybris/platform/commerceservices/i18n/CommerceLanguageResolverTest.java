/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.i18n;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.i18n.impl.CommerceLanguageResolver;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class CommerceLanguageResolverTest
{

	private static final String COMMON_ISO = "commonOne";
	private static final String COMMERCE_ISO = "commerceOne";

	private final CommerceLanguageResolver resolver = new CommerceLanguageResolver();

	@Mock
	private CommerceCommonI18NService commerceCommonI18NService;

	@Mock
	private CommonI18NService commonI18NService;

	private final LanguageModel commerceOneLangauge = new LanguageModel();

	private final LanguageModel commonOneLangauge = new LanguageModel();

	@Before
	public void prepare()
	{
		resolver.setCommerceCommonI18NService(commerceCommonI18NService);
		resolver.setCommonI18NService(commonI18NService);

		commerceOneLangauge.setIsocode(COMMERCE_ISO);
		commonOneLangauge.setIsocode(COMMON_ISO);

		BDDMockito.when(commonI18NService.getAllLanguages()).thenReturn(Arrays.asList(commerceOneLangauge));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullCode()
	{
		resolver.getLanguage(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyCode()
	{
		resolver.getLanguage("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsoCodeNotExistsInCommerce()
	{
		resolver.getLanguage(COMMON_ISO);
	}

	@Test
	public void testIsoCodeExistsInCommon()
	{
		BDDMockito.when(commonI18NService.getAllLanguages()).thenReturn(Arrays.asList(commonOneLangauge));
		Assert.assertEquals(commonOneLangauge, resolver.getLanguage(COMMON_ISO));
	}


	@Test
	public void testIsoCodeExistsInCommerce()
	{
		Assert.assertEquals(commerceOneLangauge, resolver.getLanguage(COMMERCE_ISO));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsoCodeNotExists()
	{
		resolver.getLanguage("blup");
	}
}
