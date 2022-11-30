/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.runtime.mock;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.ConfigModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.InstanceModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;


/**
 * Interface for Configuration Mocks. There should be one implementation per KB.
 */
public interface ConfigMock
{
	ConfigModel createDefaultConfiguration();

	void checkModel(ConfigModel model);

	/**
	 * Allows to add attributes from product to the configurator mock model
	 *
	 * @param model
	 * @param productModel
	 */
	default void addProductAttributes(final ConfigModel model, final ProductModel productModel)
	{
		//nothing happens in default implementation
	}


	void checkInstance(ConfigModel model, InstanceModel instance);

	void checkCstic(ConfigModel model, InstanceModel instance, CsticModel cstic);

	void setConfigId(String nextConfigId);

	/**
	 * Tells if a mock represents a changeable variant
	 *
	 * @return true if and only if mock represents a variant which is changeable, i.e. does not fall back to the base
	 *         product in case changes are done to its attributes
	 * @deprecated since 22.05: use {@link #isChangeableVariant()} instead
	 */
	@Deprecated(since = "2205", forRemoval = true)
	default boolean isChangeabeleVariant()
	{
		return isChangeableVariant();
	}

	/**
	 * Tells if a mock represents a changeable variant
	 *
	 * @return true if and only if mock represents a variant which is changeable, i.e. does not fall back to the base
	 *         product in case changes are done to its attributes
	 *
	 */
	default boolean isChangeableVariant()
	{
		return false;
	}

	void setI18NService(CommonI18NService i18nService);

	void showDeltaPrices(boolean showDeltaPrices);

}
