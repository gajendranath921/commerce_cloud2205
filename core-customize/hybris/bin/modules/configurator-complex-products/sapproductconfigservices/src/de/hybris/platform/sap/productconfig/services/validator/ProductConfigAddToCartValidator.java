/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.services.validator;

import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.commerceservices.order.validator.AddToCartValidator;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.sap.productconfig.services.impl.CPQConfigurableChecker;

public class ProductConfigAddToCartValidator implements AddToCartValidator
{

	private final CPQConfigurableChecker cpqChecker;

	public ProductConfigAddToCartValidator(final CPQConfigurableChecker cpqChecker)
	{
		super();
		this.cpqChecker = cpqChecker;
	}

	@Override
	public boolean supports(final CommerceCartParameter parameter)
	{
	 return cpqChecker.isCPQConfigurableProduct(parameter.getProduct());
	}

	@Override
	public void validate(final CommerceCartParameter parameter) throws CommerceCartModificationException
	{
		//we consider every configurable product valid

	}

}
