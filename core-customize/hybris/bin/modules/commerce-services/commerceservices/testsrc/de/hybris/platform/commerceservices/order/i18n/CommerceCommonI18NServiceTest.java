/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.order.i18n;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.i18n.CommerceCommonI18NService;
import de.hybris.platform.commerceservices.i18n.impl.DefaultCommerceCommonI18NService;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.store.services.BaseStoreService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;


/**
 * Unit test for {@link CommerceCommonI18NService}
 *
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class CommerceCommonI18NServiceTest
{
	@Mock
	private BaseStoreService baseStoreService;

	@Mock
	private CommonI18NService commonI18NService;


	@Mock
	private BaseSiteService baseSiteService;

	@Mock
	private BaseStoreModel baseStore;

	private DefaultCommerceCommonI18NService defaultCommerceCommonI18NService;

	private BaseSiteModel oneStoreSiteModel;

	private BaseSiteModel lotStoresSiteModel;

	private BaseStoreModel store;
	private List<CurrencyModel> currencies;

	@Before
	public void setUp()
	{
		defaultCommerceCommonI18NService = Mockito.spy(new DefaultCommerceCommonI18NService());
		defaultCommerceCommonI18NService.setBaseStoreService(baseStoreService);
		defaultCommerceCommonI18NService.setBaseSiteService(baseSiteService);
		defaultCommerceCommonI18NService.setCommonI18NService(commonI18NService);

		oneStoreSiteModel = new BaseSiteModel();
		lotStoresSiteModel = new BaseSiteModel();
		store = new BaseStoreModel();

		final CurrencyModel currency1 = new CurrencyModel();
		currency1.setIsocode("PL");
		currency1.setSymbol("PL");
		final CurrencyModel currency2 = new CurrencyModel();
		currency2.setIsocode("EUR");
		currency2.setSymbol("EUR");
		final CurrencyModel currency3 = new CurrencyModel();
		currency3.setIsocode("GBP");
		currency3.setSymbol("GBP");

		final Set<CurrencyModel> currencies1 = new HashSet<CurrencyModel>();
		currencies1.add(currency1);
		currencies1.add(currency2);

		final Set<CurrencyModel> currencies2 = new HashSet<CurrencyModel>();
		currencies2.add(currency1);
		currencies2.add(currency2);
		currencies2.add(currency3);

		final BaseStoreModel store1 = new BaseStoreModel();
		store1.setCurrencies(currencies1);

		store.setCurrencies(currencies1);
		currencies = new ArrayList(currencies2);

		oneStoreSiteModel.setStores(Arrays.asList(store1));

		final BaseStoreModel store2 = new BaseStoreModel();
		store2.setCurrencies(currencies1);
		final BaseStoreModel store3 = new BaseStoreModel();
		store2.setCurrencies(currencies2);
		final List<BaseStoreModel> allStoresList = new ArrayList<BaseStoreModel>();
		allStoresList.add(store1);
		allStoresList.add(store2);
		allStoresList.add(store3);
		lotStoresSiteModel.setStores(allStoresList);
	}

	@Test
	public void testGetAllSitesLanguagesWhenNullStore()
	{
		final List<LanguageModel> languages = new ArrayList<LanguageModel>();

		BDDMockito.given(commonI18NService.getAllLanguages()).willReturn(languages);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(null);

		Assert.assertEquals(languages, defaultCommerceCommonI18NService.getAllLanguages());

	}

	@Test
	public void testGetAllSitesLanguagesWhenStoreHasNoLang()
	{
		final List<LanguageModel> languages = new ArrayList<LanguageModel>();

		BDDMockito.given(commonI18NService.getAllLanguages()).willReturn(languages);
		BDDMockito.given(baseStore.getLanguages()).willReturn(null);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(baseStore);

		Assert.assertEquals(languages, defaultCommerceCommonI18NService.getAllLanguages());

	}

	@Test
	public void testGetAllSitesLanguagesWhenStoreHasSomeLangs()
	{
		final Set<LanguageModel> languages = new HashSet<LanguageModel>();

		BDDMockito.given(baseStore.getLanguages()).willReturn(languages);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(baseStore);

		Assert.assertSame(languages, defaultCommerceCommonI18NService.getAllLanguages());

	}

	@Test
	public void testGetDefaultSiteLanguageWhenNullStore()
	{
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(null);

		Assert.assertNull(defaultCommerceCommonI18NService.getDefaultLanguage());
	}

	@Test
	public void testGetDefaultSiteLanguageWhenNoDefaultLang()
	{
		BDDMockito.given(baseStore.getDefaultLanguage()).willReturn(null);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(baseStore);

		Assert.assertNull(defaultCommerceCommonI18NService.getDefaultLanguage());
	}

	@Test
	public void testGetDefaultSiteLanguageWhenDefaultLang()
	{
		final LanguageModel lang = Mockito.mock(LanguageModel.class);

		BDDMockito.given(baseStore.getDefaultLanguage()).willReturn(lang);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(baseStore);

		Assert.assertEquals(lang, defaultCommerceCommonI18NService.getDefaultLanguage());
	}

	@Test
	public void testGetDefaultSiteCurrencyWhenNullStore()
	{
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(null);

		Assert.assertNull(defaultCommerceCommonI18NService.getDefaultCurrency());
	}

	@Test
	public void testGetDefaultSiteCurrencyWhenNoDefaultCurrencyNullAllCurrencies()
	{
		BDDMockito.given(defaultCommerceCommonI18NService.getAllCurrencies()).willReturn(null);
		BDDMockito.given(baseStore.getDefaultCurrency()).willReturn(null);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(baseStore);

		Assert.assertNull(defaultCommerceCommonI18NService.getDefaultCurrency());
	}

	@Test
	public void testGetDefaultSiteCurrencyWhenNoDefaultCurrencyRetunsAllCurrenciesFirstEntry()
	{
		final CurrencyModel currencyOne = Mockito.mock(CurrencyModel.class);
		final CurrencyModel currencyTwo = Mockito.mock(CurrencyModel.class);

		//we record that defaultCommerceCommonI18NService.getDefaultCurrency relies on the getAllCurrencies
		Mockito.doReturn(Arrays.asList(currencyOne, currencyTwo)).when(defaultCommerceCommonI18NService).getAllCurrencies();

		BDDMockito.given(baseStore.getDefaultCurrency()).willReturn(null);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(baseStore);

		Assert.assertEquals(currencyOne, defaultCommerceCommonI18NService.getDefaultCurrency());
	}

	@Test
	public void testGetAllDeliveryCountriesNullStore()
	{
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(null);

		Assert.assertEquals(Collections.emptyList(), defaultCommerceCommonI18NService.getAllCountries());
	}

	@Test
	public void testGetAllDeliveryCountriesNullDeliveryCountries()
	{
		BDDMockito.given(baseStore.getDeliveryCountries()).willReturn(null);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(baseStore);

		Assert.assertEquals(Collections.emptyList(), defaultCommerceCommonI18NService.getAllCountries());
	}

	@Test
	public void testGetAllDeliveryCountriesFewDeliveryCountries()
	{
		final List<CountryModel> countries = new ArrayList<CountryModel>();

		BDDMockito.given(baseStore.getDeliveryCountries()).willReturn(countries);
		BDDMockito.given(baseStoreService.getCurrentBaseStore()).willReturn(baseStore);

		Assert.assertEquals(countries, defaultCommerceCommonI18NService.getAllCountries());
	}

	@Test
	public void testGetAllCurrenciesOneStore()
	{
		Mockito.when(baseStoreService.getCurrentBaseStore()).thenReturn(store);
		final List<CurrencyModel> list = defaultCommerceCommonI18NService.getAllCurrencies();
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void testGetAllCurrenciesMoreStores()
	{
		Mockito.when(commonI18NService.getAllCurrencies()).thenReturn(currencies);
		final List<CurrencyModel> list = defaultCommerceCommonI18NService.getAllCurrencies();
		Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());
	}

	@Test
	public void testGetAllCurrenciesStoreNull()
	{
		oneStoreSiteModel.setStores(null);
		lenient().when(baseSiteService.getCurrentBaseSite()).thenReturn(oneStoreSiteModel);
		final List<CurrencyModel> list = defaultCommerceCommonI18NService.getAllCurrencies();
		Assert.assertEquals(Boolean.TRUE, Boolean.valueOf(list.isEmpty()));
	}

	@Test
	public void testGetAllCurrenciesCurrencyNull()
	{
		oneStoreSiteModel.getStores().iterator().next().setCurrencies(null);
		lenient().when(baseSiteService.getCurrentBaseSite()).thenReturn(oneStoreSiteModel);
		final List<CurrencyModel> list = defaultCommerceCommonI18NService.getAllCurrencies();
		Assert.assertEquals(Boolean.TRUE, Boolean.valueOf(list.isEmpty()));
	}

	@Test
	public void testGetAllCurrenciesSiteNull()
	{
		oneStoreSiteModel.getStores().iterator().next().setCurrencies(null);
		lenient().when(baseSiteService.getCurrentBaseSite()).thenReturn(null);
		final List<CurrencyModel> list = defaultCommerceCommonI18NService.getAllCurrencies();
		Assert.assertEquals(Boolean.TRUE, Boolean.valueOf(list.isEmpty()));
	}

}
