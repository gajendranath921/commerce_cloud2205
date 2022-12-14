/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.excel.validators;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.TypeModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.hybris.backoffice.excel.data.ImportParameters;
import com.hybris.backoffice.excel.translators.generic.RequiredAttribute;
import com.hybris.backoffice.excel.translators.generic.factory.RequiredAttributesFactory;
import com.hybris.backoffice.excel.validators.data.ExcelValidationResult;
import com.hybris.backoffice.excel.validators.data.ValidationMessage;


@RunWith(MockitoJUnitRunner.class)
public class CatalogVersionPermissionValidatorTest
{
	private static final Map<String, String> PARAMS = Map.of("Catalog.version", "version");
	@Mock
	private TypeService typeService;
	@Mock
	private UserService userService;
	@Mock
	private CatalogVersionService catalogVersionService;
	@Mock
	private RequiredAttributesFactory requiredAttributesFactory;
	@Spy
	@InjectMocks
	private CatalogVersionPermissionValidator validator;

	@Test
	public void shouldCheckAssignableFormOfAttributeDescriptor()
	{
		//given
		final String code = "CatalogVersion";
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);
		final TypeModel catalogVersionTypeModel = mock(TypeModel.class);

		given(attributeDescriptor.getAttributeType()).willReturn(catalogVersionTypeModel);
		given(catalogVersionTypeModel.getCode()).willReturn(code);

		//when
		validator.canHandle(mock(ImportParameters.class), attributeDescriptor);

		//then
		then(typeService).should().isAssignableFrom(code, CatalogVersionModel._TYPECODE);
	}

	@Test
	public void shouldInvokeValidateWhenCatalogVersionAndIdExist()
	{
		//given
		final Map<String, Object> context = null;
		final UserModel user = mock(UserModel.class);
		final CatalogVersionModel catalogVersion = mock(CatalogVersionModel.class);
		final ImportParameters importParameters = mock(ImportParameters.class);
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);
		final Map<String, String> testParams = Map.of("CatalogVersion.version", "version", "Catalog.id", "id");

		given(importParameters.getSingleValueParameters()).willReturn(testParams);
		given(catalogVersionService.getCatalogVersion("id", "version")).willReturn(catalogVersion);
		given(userService.getCurrentUser()).willReturn(user);
		given(userService.isAdmin(user)).willReturn(true);
		given(catalogVersionService.getAllCatalogVersions()).willReturn(List.of(catalogVersion));

		//when
		final ExcelValidationResult result = validator.validate(importParameters, attributeDescriptor, context);

		//then
		verify(validator, Mockito.times(1)).validateCatalogVersion(testParams, attributeDescriptor, catalogVersion);
		assertThat(result.getValidationErrors()).isEmpty();
	}

	@Test
	public void shouldSkipValidateWhenCatalogVersionIsNull()
	{
		//given
		final Map<String, Object> context = null;
		final ImportParameters importParameters = mock(ImportParameters.class);
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);
		final Map<String, String> testParams = Map.of("Catalog.id", "id");
		given(importParameters.getSingleValueParameters()).willReturn(testParams);

		//when
		final ExcelValidationResult result = validator.validate(importParameters, attributeDescriptor, context);

		//then
		verify(validator, Mockito.times(0)).validateCatalogVersion(Mockito.any(Map.class),
				Mockito.any(AttributeDescriptorModel.class), Mockito.any(CatalogVersionModel.class));
		assertThat(result.getValidationErrors()).isEmpty();
	}

	@Test
	public void shouldSkipValidateWhenCatalogIdIsNull()
	{
		//given
		final Map<String, Object> context = null;
		final ImportParameters importParameters = mock(ImportParameters.class);
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);
		final Map<String, String> testParams = Map.of("CatalogVersion.version", "version");
		given(importParameters.getSingleValueParameters()).willReturn(testParams);

		//when
		final ExcelValidationResult result = validator.validate(importParameters, attributeDescriptor, context);

		//then
		verify(validator, Mockito.times(0)).validateCatalogVersion(Mockito.any(Map.class),
				Mockito.any(AttributeDescriptorModel.class), Mockito.any(CatalogVersionModel.class));
		assertThat(result.getValidationErrors()).isEmpty();
	}

	@Test
	public void shouldNotCreateValidationMessageIfUserHasAccessToCatalogVersion()
	{
		//given
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);
		final CatalogVersionModel catalogVersion = mock(CatalogVersionModel.class);
		final UserModel user = mock(UserModel.class);

		given(userService.getCurrentUser()).willReturn(user);
		given(userService.isAdmin(user)).willReturn(false);
		given(catalogVersionService.getAllWritableCatalogVersions(user)).willReturn(List.of(catalogVersion));

		//when
		final Optional<ValidationMessage> validationMessage = validator.validateCatalogVersion(PARAMS, attributeDescriptor,
				catalogVersion);

		//then
		assertThat(validationMessage).isEmpty();
	}

	@Test
	public void shouldNotCreateValidationMessageForAdmin()
	{
		//given
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);
		final CatalogVersionModel catalogVersion = mock(CatalogVersionModel.class);
		final UserModel user = mock(UserModel.class);

		given(userService.getCurrentUser()).willReturn(user);
		given(userService.isAdmin(user)).willReturn(true);
		given(catalogVersionService.getAllCatalogVersions()).willReturn(List.of(catalogVersion));

		//when
		final Optional<ValidationMessage> validationMessage = validator.validateCatalogVersion(PARAMS, attributeDescriptor,
				catalogVersion);

		//then
		assertThat(validationMessage).isEmpty();
	}

	@Test
	public void shouldCreateValidationMessageIfUserHasNotAccessToCatalogVersion()
	{
		//given
		final AttributeDescriptorModel attributeDescriptor = mock(AttributeDescriptorModel.class);
		final CatalogVersionModel catalogVersion = mock(CatalogVersionModel.class);
		final UserModel user = mock(UserModel.class);
		final ValidationMessage validationMessage = new ValidationMessage("messageKey", "CatalogVersion", "params");
		final RequiredAttribute requiredAttribute = mock(RequiredAttribute.class);

		given(userService.getCurrentUser()).willReturn(user);
		given(userService.isAdmin(user)).willReturn(false);
		Mockito.lenient().when(catalogVersionService.getAllCatalogVersions()).thenReturn(List.of(mock(CatalogVersionModel.class)));
		given(requiredAttributesFactory.create(attributeDescriptor)).willReturn(requiredAttribute);
		doReturn(validationMessage).when(validator).prepareValidationMessage(requiredAttribute, PARAMS);


		//when
		final Optional<ValidationMessage> result = validator.validateCatalogVersion(PARAMS, attributeDescriptor, catalogVersion);

		//then
		assertThat(result).isPresent();
		assertThat(result.get()).isEqualTo(validationMessage);
	}
}
