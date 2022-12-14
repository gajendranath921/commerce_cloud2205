/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.order.hook.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.catalog.enums.ConfiguratorType;
import de.hybris.platform.commerceservices.order.CommerceCartModification;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.commerceservices.order.ProductConfigurationHandler;
import de.hybris.platform.commerceservices.order.ProductConfigurationHandlerFactory;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.order.model.AbstractOrderEntryProductInfoModel;
import de.hybris.platform.product.ConfiguratorSettingsService;
import de.hybris.platform.product.model.AbstractConfiguratorSettingModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@UnitTest
public class ConfigurableProductAddToCartMethodHookTest
{
	private ConfigurableProductAddToCartMethodHook hook;
	private final ConfiguratorSettingsService configuratorSettingsService = mock(ConfiguratorSettingsService.class);
	private final ConfiguratorType configuratorType = mock(ConfiguratorType.class);

	@Before
	public void setup()
	{
		hook = new ConfigurableProductAddToCartMethodHook();
		final ProductConfigurationHandler handler = mock(ProductConfigurationHandler.class);
		final AbstractOrderEntryProductInfoModel orderedProductInfo = mock(AbstractOrderEntryProductInfoModel.class);
		when(orderedProductInfo.getConfiguratorType()).thenReturn(configuratorType);
		when(handler.createProductInfo(any(AbstractConfiguratorSettingModel.class)))
				.thenReturn(Collections.singletonList(orderedProductInfo));
		final ProductConfigurationHandlerFactory factory = mock(ProductConfigurationHandlerFactory.class);
		when(factory.handlerOf(any(ConfiguratorType.class))).thenReturn(handler);
		hook.setConfigurationFactory(factory);
		final ModelService modelService = mock(ModelService.class);
		hook.setModelService(modelService);
		hook.setConfiguratorSettingsService(configuratorSettingsService);
	}

	@Test
	public void shouldUpdateCartEntry() throws CommerceCartModificationException
	{
		final ProductModel product = new ProductModel();
		final AbstractConfiguratorSettingModel configuratorSettingModel = mock(AbstractConfiguratorSettingModel.class);
		when(configuratorSettingModel.getConfiguratorType()).thenReturn(configuratorType);
		when(configuratorSettingsService.getConfiguratorSettingsForProduct(product))
				.thenReturn(Collections.singletonList(configuratorSettingModel));
		final CartModel cart = new CartModel();
		cart.setEntries(Collections.singletonList(new CartEntryModel()));
		cart.getEntries().get(0).setEntryNumber(1);
		final CommerceCartParameter parameter = new CommerceCartParameter();
		parameter.setCart(cart);
		parameter.setEntryNumber(1);
		parameter.setProduct(product);
		final CommerceCartModification modification = new CommerceCartModification();
		modification.setEntry(cart.getEntries().get(0));
		modification.getEntry().setProduct(product);
		modification.setQuantityAdded(1L);

		hook.afterAddToCart(parameter, modification);

		assertNotNull(cart.getEntries().get(0).getProductInfos());
		assertFalse(cart.getEntries().get(0).getProductInfos().isEmpty());
	}
}
