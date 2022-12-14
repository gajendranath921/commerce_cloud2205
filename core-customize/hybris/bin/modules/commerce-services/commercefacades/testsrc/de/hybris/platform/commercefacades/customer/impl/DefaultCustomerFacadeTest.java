/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.customer.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.commercefacades.storesession.StoreSessionFacade;
import de.hybris.platform.commercefacades.storesession.data.CurrencyData;
import de.hybris.platform.commercefacades.storesession.data.LanguageData;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.converters.populator.AddressReversePopulator;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.customer.PasswordMismatchException;
import de.hybris.platform.commerceservices.customer.TokenInvalidatedException;
import de.hybris.platform.commerceservices.event.LoginSuccessEvent;
import de.hybris.platform.commerceservices.model.process.ForgottenPasswordProcessModel;
import de.hybris.platform.commerceservices.order.CommerceCartService;
import de.hybris.platform.commerceservices.strategies.CartCleanStrategy;
import de.hybris.platform.commerceservices.strategies.CustomerNameStrategy;
import de.hybris.platform.commerceservices.strategies.impl.DefaultCustomerNameStrategy;
import de.hybris.platform.commerceservices.user.UserMatchingService;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.payment.CreditCardPaymentInfoModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.services.BaseStoreService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Test suite for {@link DefaultCustomerFacade}
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultCustomerFacadeTest
{
	private static final String TEST_DUMMY = "Dummy";
	private static final String TEST_OLD_PASS = "oldPass";
	private static final String TEST_NEW_PASS = "newPass";
	private static final String TEST_USER_UID = "testUid";
	private static final String TEST_CUSTOMER_ID = "6a2a41a3-c54c-4ce8-a2d2-0324e1c32a21";
	private static final String TEST_TOKEN = "token";
	private static final String PROCESS_DEFINITION_NAME = "forgottenPasswordProcess";
	private DefaultCustomerFacade defaultCustomerFacade;


	@Mock
	private UserService userService;
	@Mock(lenient = true)
	private UserMatchingService userMatchingService;
	@Mock
	private UserModel user;
	@Mock(lenient = true)
	private CustomerAccountService customerAccountService;
	@Mock
	private ModelService mockModelService;
	@Mock(lenient = true)
	private AbstractPopulatingConverter<AddressModel, AddressData> addressConverter;
	@Mock
	private AbstractPopulatingConverter<UserModel, CustomerData> customerConverter;
	@Mock
	private AddressReversePopulator addressReversePopulator;
	@Mock(lenient = true)
	private AbstractPopulatingConverter<CreditCardPaymentInfoModel, CCPaymentInfoData> creditCardPaymentInfoConverter;
	@Mock
	private CommonI18NService commonI18NService;
	@Mock(lenient = true)
	private StoreSessionFacade storeSessionFacade;
	@Mock
	private CartService cartService;
	@Mock
	private CommerceCartService commerceCartService;
	@Mock
	private UserFacade userFacade;
	@Mock
	private SessionService sessionService;
	@Mock
	private OrderFacade orderFacade;
	@Mock
	private CartCleanStrategy cartCleanStrategy;
	@Mock
	private EventService eventService;
	@Mock
	private BaseStoreService baseStoreService;
	@Mock
	private BaseSiteService baseSiteService;
	@Mock
	private BusinessProcessService businessProcessService;

	private CustomerModel customerModel;

	private CustomerModel guestCustomerModel;

	@Mock
	private ForgottenPasswordProcessModel forgottenPasswordProcessModel;

	@Mock
	private BaseSiteModel baseSiteModel;

	private AddressModel addressModel;

	private AddressModel addressModel2;

	private AddressData addressData;

	private CreditCardPaymentInfoModel creditCardPaymentInfoModel;

	private CCPaymentInfoData ccPaymentInfoData;

	private CustomerNameStrategy customerNameStrategy;

	private CurrencyData defaultCurrencyData;

	private LanguageData defaultLanguageData;

	@Before
	public void setUp()
	{
		defaultCustomerFacade = new DefaultCustomerFacade();
		defaultCustomerFacade.setUserService(userService);
		defaultCustomerFacade.setModelService(mockModelService);
		defaultCustomerFacade.setCustomerAccountService(customerAccountService);
		defaultCustomerFacade.setAddressConverter(addressConverter);
		defaultCustomerFacade.setCustomerConverter(customerConverter);
		defaultCustomerFacade.setAddressReversePopulator(addressReversePopulator);
		defaultCustomerFacade.setCreditCardPaymentInfoConverter(creditCardPaymentInfoConverter);
		defaultCustomerFacade.setCommonI18NService(commonI18NService);
		defaultCustomerFacade.setStoreSessionFacade(storeSessionFacade);
		defaultCustomerFacade.setCartService(cartService);
		defaultCustomerFacade.setCommerceCartService(commerceCartService);
		defaultCustomerFacade.setUserFacade(userFacade);
		defaultCustomerFacade.setSessionService(sessionService);
		defaultCustomerFacade.setOrderFacade(orderFacade);
		defaultCustomerFacade.setCartCleanStrategy(cartCleanStrategy);
		defaultCustomerFacade.setEventService(eventService);
		defaultCustomerFacade.setBaseSiteService(baseSiteService);
		defaultCustomerFacade.setBaseStoreService(baseStoreService);
		defaultCustomerFacade.setUserMatchingService(userMatchingService);
		defaultCustomerFacade.setBusinessProcessService(businessProcessService);

		customerNameStrategy = new DefaultCustomerNameStrategy();

		defaultCustomerFacade.setCustomerNameStrategy(customerNameStrategy);

		addressModel = new MockAddressModel(9999L);
		addressModel2 = new MockAddressModel(8888L);
		addressData = new AddressData();
		addressData.setId("9999");

		customerModel = new CustomerModel();
		customerModel.setDefaultShipmentAddress(addressModel2);

		creditCardPaymentInfoModel = new CreditCardPaymentInfoModel();
		final List<CreditCardPaymentInfoModel> creditCards = new ArrayList<CreditCardPaymentInfoModel>();
		creditCards.add(creditCardPaymentInfoModel);
		ccPaymentInfoData = new CCPaymentInfoData();

		guestCustomerModel = new CustomerModel();
		guestCustomerModel.setUid(TEST_USER_UID + "|" + TEST_DUMMY);
		guestCustomerModel.setDefaultShipmentAddress(addressModel);
		guestCustomerModel.setDefaultPaymentAddress(addressModel2);

		given(addressConverter.convert(addressModel)).willReturn(addressData);
		given(creditCardPaymentInfoConverter.convert(creditCardPaymentInfoModel)).willReturn(ccPaymentInfoData);
		given(userService.getCurrentUser()).willReturn(customerModel);
		given(customerAccountService.getAddressForCode(customerModel, "9999")).willReturn(addressModel);
		given(customerAccountService.getCreditCardPaymentInfos(customerModel, true)).willReturn(creditCards);
		given(customerAccountService.getCreditCardPaymentInfoForCode(customerModel, "code")).willReturn(creditCardPaymentInfoModel);
		given(mockModelService.create(CustomerModel.class)).willReturn(new CustomerModel());

		defaultCurrencyData = new CurrencyData();
		defaultCurrencyData.setIsocode("GBP");

		defaultLanguageData = new LanguageData();
		defaultLanguageData.setIsocode("en");

		given(storeSessionFacade.getDefaultCurrency()).willReturn(defaultCurrencyData);
		given(storeSessionFacade.getDefaultLanguage()).willReturn(defaultLanguageData);
	}

	@Test
	public void testGetCurrentUser()
	{
		final CustomerData customerData = mock(CustomerData.class);

		given(userService.getCurrentUser()).willReturn(customerModel);
		given(customerConverter.convert(customerModel)).willReturn(customerData);

		final CustomerData currentUser = defaultCustomerFacade.getCurrentCustomer();

		Assert.assertEquals(customerData, currentUser);
	}

	@Test
	public void testChangePassword() throws PasswordMismatchException
	{
		given(userService.getCurrentUser()).willReturn(user);
		defaultCustomerFacade.changePassword(TEST_OLD_PASS, TEST_NEW_PASS);
		verify(customerAccountService).changePassword(user, TEST_OLD_PASS, TEST_NEW_PASS);
	}

	@Test
	public void testSetPasswordForUid()
	{
		given(userMatchingService.getUserByProperty(TEST_USER_UID, UserModel.class)).willReturn(customerModel);
		defaultCustomerFacade.setPassword(TEST_USER_UID, TEST_NEW_PASS);
		verify(userService).setPassword(customerModel, TEST_NEW_PASS);
	}

	@Test
	public void testSetPasswordForCustomerId()
	{
		given(userMatchingService.getUserByProperty(TEST_CUSTOMER_ID, UserModel.class)).willReturn(customerModel);
		defaultCustomerFacade.setPassword(TEST_CUSTOMER_ID, TEST_NEW_PASS);
		verify(userService).setPassword(customerModel, TEST_NEW_PASS);
	}

	@Test(expected = de.hybris.platform.commercefacades.user.exceptions.PasswordMismatchException.class)
	public void testChangePasswordMismatchException() throws PasswordMismatchException
	{
		given(userService.getCurrentUser()).willReturn(user);
		doThrow(new PasswordMismatchException("")).when(customerAccountService).changePassword(user, TEST_OLD_PASS, TEST_NEW_PASS);
		defaultCustomerFacade.changePassword(TEST_OLD_PASS, TEST_NEW_PASS);
	}

	@Test
	public void testForgottenPasswordForUid()
	{
		given(userMatchingService.getUserByProperty(TEST_USER_UID.toLowerCase(), CustomerModel.class)).willReturn(customerModel);
		given(businessProcessService.createProcess(anyString(), anyString(), anyMapOf(String.class, Object.class)))
				.willReturn(forgottenPasswordProcessModel);
		given(baseSiteService.getCurrentBaseSite()).willReturn(baseSiteModel);
		defaultCustomerFacade.forgottenPassword(TEST_USER_UID);
		verify(businessProcessService)
				.createProcess(Mockito.matches("forgottenPassword-" + TEST_USER_UID + "-\\d{1,}"), eq(PROCESS_DEFINITION_NAME),
						Mockito.anyMapOf(String.class, Object.class));
		verify(businessProcessService).startProcess(forgottenPasswordProcessModel);
		verify(baseSiteService).getCurrentBaseSite();
		verify(commonI18NService).getCurrentLanguage();
		verify(commonI18NService).getCurrentCurrency();
	}

	@Test
	public void testForgottenPasswordForCustomerId()
	{
		given(userMatchingService.getUserByProperty(TEST_CUSTOMER_ID, CustomerModel.class)).willReturn(customerModel);
		given(businessProcessService.createProcess(anyString(), anyString(), anyMapOf(String.class, Object.class)))
				.willReturn(forgottenPasswordProcessModel);
		given(baseSiteService.getCurrentBaseSite()).willReturn(baseSiteModel);
		defaultCustomerFacade.forgottenPassword(TEST_CUSTOMER_ID);
		verify(businessProcessService)
				.createProcess(Mockito.matches("forgottenPassword-" + TEST_CUSTOMER_ID + "-\\d{1,}"), eq(PROCESS_DEFINITION_NAME),
						Mockito.anyMapOf(String.class, Object.class));
		verify(businessProcessService).startProcess(forgottenPasswordProcessModel);
		verify(baseSiteService).getCurrentBaseSite();
		verify(commonI18NService).getCurrentLanguage();
		verify(commonI18NService).getCurrentCurrency();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testForgottenPasswordForEmptyId()
	{
		defaultCustomerFacade.forgottenPassword("");
	}

	@Test
	public void testRegister() throws DuplicateUidException
	{
		final RegisterData registerData = createDummyRegisterData();
		final CustomerModel model = new CustomerModel();
		given(mockModelService.create(CustomerModel.class)).willReturn(model);
		defaultCustomerFacade.register(registerData);
		verify(customerAccountService).register(model, TEST_DUMMY);
	}

	private RegisterData createDummyRegisterData()
	{
		final RegisterData data = new RegisterData();
		data.setFirstName(TEST_DUMMY);
		data.setLastName(TEST_DUMMY);
		data.setLogin(TEST_USER_UID);
		data.setPassword(TEST_DUMMY);
		data.setTitleCode(TEST_DUMMY);
		return data;
	}

	@Test
	public void testNextDummyCustomerData()
	{
		final CustomerData customerData = createDummyCustomerData();
		given(customerConverter.convert(any(CustomerModel.class))).willReturn(customerData);

		final RegisterData registerData = createDummyRegisterData();
		final CustomerData dummyCustomerData = defaultCustomerFacade.nextDummyCustomerData(registerData);

		Assert.assertEquals(registerData.getLogin(), dummyCustomerData.getUid());
		Assert.assertEquals(registerData.getFirstName(), dummyCustomerData.getFirstName());
		Assert.assertEquals(registerData.getLastName(), dummyCustomerData.getLastName());
		Assert.assertEquals(registerData.getTitleCode(), dummyCustomerData.getTitleCode());
	}

	private CustomerData createDummyCustomerData()
	{
		final CustomerData customerData = new CustomerData();
		customerData.setUid(TEST_USER_UID);
		customerData.setFirstName(TEST_DUMMY);
		customerData.setLastName(TEST_DUMMY);
		customerData.setTitleCode(TEST_DUMMY);
		return customerData;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRegisterErr() throws DuplicateUidException
	{
		final RegisterData data = new RegisterData();
		defaultCustomerFacade.register(data);
	}

	@Test
	public void testRegisterGuest() throws DuplicateUidException
	{
		final String email = "test@test.com";
		final CustomerData guestCustomerData = new CustomerData();
		guestCustomerData.setCurrency(defaultCurrencyData);
		guestCustomerData.setLanguage(defaultLanguageData);
		final CustomerModel guestCustomer = new CustomerModel();
		final CartModel cartModel = mock(CartModel.class);
		given(mockModelService.create(CustomerModel.class)).willReturn(guestCustomer);
		given(customerConverter.convert(guestCustomer)).willReturn(guestCustomerData);
		given(Boolean.valueOf(cartService.hasSessionCart())).willReturn(Boolean.TRUE);
		given(cartService.getSessionCart()).willReturn(cartModel);
		defaultCustomerFacade.createGuestUserForAnonymousCheckout(email, "Guest");

		Assert.assertEquals(StringUtils.substringAfter(guestCustomer.getUid(), "|"), email);
	}

	@Test
	public void testCreateCustomerFromGuest() throws DuplicateUidException
	{
		customerModel.setUid(TEST_USER_UID + "|" + TEST_DUMMY);
		defaultCustomerFacade.changeGuestToCustomer(TEST_DUMMY, "10001");
		verify(customerAccountService).convertGuestToCustomer(TEST_DUMMY, "10001");
	}

	@Test
	public void testUpdateProfile() throws DuplicateUidException
	{
		final String titleCode = "titleCode";
		final String firstName = "firstName";
		final String lastName = "lastName";
		final String uid = "email";
		final CustomerData customerData = new CustomerData();
		customerData.setTitleCode(titleCode);
		customerData.setFirstName(firstName);
		customerData.setLastName(lastName);
		customerData.setUid(uid);
		given(userService.getCurrentUser()).willReturn(customerModel);
		final String name = customerNameStrategy.getName(firstName, lastName);
		defaultCustomerFacade.updateProfile(customerData);
		verify(customerAccountService).updateProfile(customerModel, titleCode, name, uid);
	}

	@Test
	public void testUpdatePassword() throws TokenInvalidatedException
	{
		defaultCustomerFacade.updatePassword(TEST_TOKEN, TEST_NEW_PASS);
		verify(customerAccountService).updatePassword(TEST_TOKEN, TEST_NEW_PASS);
	}

	@Test
	public void testLoginSuccess()
	{
		final CustomerData customerData = new CustomerData();
		final CurrencyData currencyData = new CurrencyData();
		currencyData.setIsocode("PLN");
		customerData.setCurrency(currencyData);
		final Collection<CurrencyData> currencies = new ArrayList<CurrencyData>();
		currencies.add(currencyData);

		final LanguageData languageData = new LanguageData();
		languageData.setIsocode("PL");
		customerData.setLanguage(languageData);
		final Collection<LanguageData> languages = new ArrayList<LanguageData>();
		languages.add(languageData);

		given(customerConverter.convert(customerModel)).willReturn(customerData);
		given(storeSessionFacade.getAllCurrencies()).willReturn(currencies);
		given(storeSessionFacade.getAllLanguages()).willReturn(languages);
		given(Boolean.valueOf(cartService.hasSessionCart())).willReturn(Boolean.TRUE);
		defaultCustomerFacade.loginSuccess();

		verify(storeSessionFacade).setCurrentCurrency(currencyData.getIsocode());
		verify(userFacade).syncSessionLanguage();
		verify(eventService, times(1)).publishEvent(any(LoginSuccessEvent.class));
	}

	@Test
	public void testLoginSuccessNoCurrencyAndLanguage()
	{
		final CustomerData customerData = new CustomerData();
		customerData.setCurrency(null);
		customerData.setLanguage(null);

		given(customerConverter.convert(customerModel)).willReturn(customerData);
		given(Boolean.valueOf(cartService.hasSessionCart())).willReturn(Boolean.TRUE);
		defaultCustomerFacade.loginSuccess();

		verify(storeSessionFacade).setCurrentCurrency(defaultCurrencyData.getIsocode());
		verify(userFacade).syncSessionLanguage();
	}

	@Test
	public void testLoginSuccessNoCart()
	{
		final CustomerData customerData = new CustomerData();
		customerData.setCurrency(null);
		customerData.setLanguage(null);
		given(customerConverter.convert(customerModel)).willReturn(customerData);
		given(Boolean.valueOf(cartService.hasSessionCart())).willReturn(Boolean.FALSE);
		defaultCustomerFacade.loginSuccess();
		verify(cartService, never()).changeCurrentCartUser(customerModel);
	}

	@Test
	public void testLoginSuccessNotSetCurrent()
	{
		final CustomerData customerData = new CustomerData();
		final CurrencyData userCurrencyData = new CurrencyData();
		userCurrencyData.setIsocode("PLN");
		customerData.setCurrency(userCurrencyData);
		final CurrencyData currencyData = new CurrencyData();
		currencyData.setIsocode("DE");
		final Collection<CurrencyData> currencies = new ArrayList<CurrencyData>();
		currencies.add(currencyData);

		final LanguageData userLanguageData = new LanguageData();
		userLanguageData.setIsocode("PL");
		customerData.setLanguage(userLanguageData);
		final LanguageData languageData = new LanguageData();
		languageData.setIsocode("DE");
		final Collection<LanguageData> languages = new ArrayList<LanguageData>();
		languages.add(languageData);

		given(customerConverter.convert(customerModel)).willReturn(customerData);
		given(storeSessionFacade.getAllCurrencies()).willReturn(currencies);
		given(storeSessionFacade.getAllLanguages()).willReturn(languages);
		given(Boolean.valueOf(cartService.hasSessionCart())).willReturn(Boolean.TRUE);
		defaultCustomerFacade.loginSuccess();

		verify(storeSessionFacade).setCurrentCurrency(defaultCurrencyData.getIsocode());
		verify(userFacade).syncSessionLanguage();
	}

	@Test
	public void testPublishLoginSuccessEventForCurrentCustomer()
	{
		given(userService.getCurrentUser()).willReturn(customerModel);
		defaultCustomerFacade.publishLoginSuccessEvent();
		verify(eventService, times(1)).publishEvent(any(LoginSuccessEvent.class));
	}

	@Test
	public void testPublishLoginSuccessEventForCurrentCustomerNotSentForAnonymous()
	{
		given(userService.getCurrentUser()).willReturn(customerModel);
		given(userService.isAnonymousUser(any(CustomerModel.class))).willReturn(true);
		defaultCustomerFacade.publishLoginSuccessEvent();
		verify(eventService, never()).publishEvent(any(LoginSuccessEvent.class));
	}

	@Test
	public void shouldCloseAccount()
	{
		// Given
		given(userService.getCurrentUser()).willReturn(new CustomerModel());

		// When
		defaultCustomerFacade.closeAccount();

		// Then
		verify(customerAccountService).closeAccount(Mockito.any(CustomerModel.class));
	}

	protected static class MockAddressModel extends AddressModel
	{
		private final long id;

		public MockAddressModel(final long id)
		{
			this.id = id;
		}

		@Override
		public PK getPk()
		{
			return de.hybris.platform.core.PK.fromLong(id);
		}
	}
}
