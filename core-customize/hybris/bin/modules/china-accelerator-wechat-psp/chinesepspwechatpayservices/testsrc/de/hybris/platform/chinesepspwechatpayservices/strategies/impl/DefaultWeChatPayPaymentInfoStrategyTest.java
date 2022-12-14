/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesepspwechatpayservices.strategies.impl;

import static org.junit.Assert.assertEquals;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.chinesepaymentservices.enums.ServiceType;
import de.hybris.platform.chinesepaymentservices.model.ChinesePaymentInfoModel;
import de.hybris.platform.core.enums.PaymentStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultWeChatPayPaymentInfoStrategyTest
{
	private static final String CUSTOMER_UID = "c000001";
	private DefaultWeChatPayPaymentInfoStrategy defaultWeChatPayPaymentInfoStrategy;

	@Mock
	private UserService userService;

	@Mock
	private ModelService modelService;

	@Before
	public void setUp() throws Exception
	{
		defaultWeChatPayPaymentInfoStrategy = Mockito.spy(new DefaultWeChatPayPaymentInfoStrategy());

		defaultWeChatPayPaymentInfoStrategy.setUserService(userService);
		defaultWeChatPayPaymentInfoStrategy.setModelService(modelService);
	}

	@Test
	public void testUpdatePaymentInfoForPayemntMethod()
	{
		final CustomerModel customerModel = new CustomerModel();
		customerModel.setUid(CUSTOMER_UID);

		Mockito.doReturn(customerModel).when(userService).getCurrentUser();


		final ChinesePaymentInfoModel paymentInfo = new ChinesePaymentInfoModel();
		defaultWeChatPayPaymentInfoStrategy.updatePaymentInfoForPayemntMethod(paymentInfo);

		assertEquals(ServiceType.OFFICIALACCOUNTPAY, paymentInfo.getServiceType());
		Mockito.verify(defaultWeChatPayPaymentInfoStrategy).getModelService();
		Mockito.verify(modelService, Mockito.times(1)).save(paymentInfo);
	}

	@Test
	public void testUpdatePaymentInfoForPlaceOrder()
	{
		final OrderModel order = new OrderModel();
		order.setCode(CUSTOMER_UID);

		final ChinesePaymentInfoModel paymentInfo = new ChinesePaymentInfoModel();
		order.setPaymentInfo(paymentInfo);

		defaultWeChatPayPaymentInfoStrategy.updatePaymentInfoForPlaceOrder(order);

		assertEquals(PaymentStatus.NOTPAID, order.getPaymentStatus());

		Mockito.verify(modelService, Mockito.times(1)).save(paymentInfo);
		Mockito.verify(modelService, Mockito.times(1)).save(order);
	}

}
