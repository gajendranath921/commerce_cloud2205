/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.order.hook.impl;

import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.service.data.CommerceCartMetadataParameter;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultCommerceCartMetadataUpdateValidationHookTest
{
	private final DefaultCommerceCartMetadataUpdateValidationHook defaultCommerceCartMetadataUpdateValidationHook = new DefaultCommerceCartMetadataUpdateValidationHook();

	@Mock(lenient = true)
	private CommerceCartMetadataParameter metadataParameter;

	private static final String LONG_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor "
			+ "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
			+ "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum "
			+ "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia "
			+ "deserunt mollit anim id est laborum.";

	@Test(expected = IllegalArgumentException.class)
	public void shouldValidateNameLength()
	{
		given(metadataParameter.getName()).willReturn(Optional.of(LONG_TEXT));
		given(metadataParameter.getDescription()).willReturn(Optional.of("myQuoteDescription"));

		defaultCommerceCartMetadataUpdateValidationHook.beforeMetadataUpdate(metadataParameter);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldValidateDescriptionLength()
	{
		given(metadataParameter.getName()).willReturn(Optional.of("myQuoteName"));
		given(metadataParameter.getDescription()).willReturn(Optional.of(LONG_TEXT));

		defaultCommerceCartMetadataUpdateValidationHook.beforeMetadataUpdate(metadataParameter);
	}

	@Test
	public void shouldValidateIfNameDescriptionEmpty()
	{
		given(metadataParameter.getName()).willReturn(Optional.empty());
		given(metadataParameter.getDescription()).willReturn(Optional.empty());

		defaultCommerceCartMetadataUpdateValidationHook.beforeMetadataUpdate(metadataParameter);
	}

	@Test
	public void shouldValidateName()
	{
		given(metadataParameter.getName()).willReturn(Optional.of("myQuoteName"));
		given(metadataParameter.getDescription()).willReturn(Optional.empty());

		defaultCommerceCartMetadataUpdateValidationHook.beforeMetadataUpdate(metadataParameter);
	}

	@Test
	public void shouldValidateDescription()
	{
		given(metadataParameter.getName()).willReturn(Optional.empty());
		given(metadataParameter.getDescription()).willReturn(Optional.of("myQuoteDescription"));

		defaultCommerceCartMetadataUpdateValidationHook.beforeMetadataUpdate(metadataParameter);
	}

	@Test
	public void shouldValidateNameAndDescription()
	{
		given(metadataParameter.getName()).willReturn(Optional.of("myQuoteName"));
		given(metadataParameter.getDescription()).willReturn(Optional.of("myQuoteDescription"));

		defaultCommerceCartMetadataUpdateValidationHook.beforeMetadataUpdate(metadataParameter);
	}
}
