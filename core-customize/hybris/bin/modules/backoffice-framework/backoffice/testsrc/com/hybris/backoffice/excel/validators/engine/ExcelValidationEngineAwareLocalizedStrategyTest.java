/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.excel.validators.engine;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.validation.enums.Severity;
import de.hybris.platform.validation.exceptions.HybrisConstraintViolation;
import de.hybris.platform.validation.localized.LocalizedAttributeConstraint;
import de.hybris.platform.validation.localized.LocalizedConstraintsRegistry;
import de.hybris.platform.validation.services.ConstraintViolationFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import javax.validation.ConstraintViolation;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Sets;
import com.hybris.backoffice.excel.data.ExcelAttribute;
import com.hybris.backoffice.excel.data.ImportParameters;
import com.hybris.backoffice.excel.validators.data.ExcelValidationResult;


@RunWith(MockitoJUnitRunner.class)
public class ExcelValidationEngineAwareLocalizedStrategyTest extends AbstractValidationEngineAwareStrategyTest
{

	@Mock
	private ConstraintViolationFactory violationFactory;

	@Mock
	private LocalizedConstraintsRegistry localizedConstraintsRegistry;

	@Mock
	private ExcelLocalizedConstraintsProvider excelLocalizedConstraintsProvider;

	@Spy
	@InjectMocks
	private ExcelValidationEngineAwareLocalizedStrategy strategy;

	@Before
	public void setup()
	{
		super.setup();
		when(strategy.getConverterRegistry()).thenReturn(converterRegistry);
	}

	@Test
	public void shouldReturnValidationErrorWhenAttributeIsLocalizedAndSeveritiesAreEqualAndConstraintIsNotLocalized()
	{
		// given
		final String validationMessage = "Value cannot be empty";
		final LocalizedAttributeConstraint constraint = mockLocalizedConstraintsRegistry(Locale.ENGLISH);
		final ExcelAttribute excelAttribute = mock(ExcelAttribute.class);
		final ImportParameters importParameters = prepareImportParameters(StringUtils.EMPTY, Locale.ENGLISH.toString());
		final HybrisConstraintViolation constraintViolation = prepareLocalizedConstraintViolation(validationMessage, Severity.ERROR,
				Locale.ENGLISH);
		given(excelAttribute.getQualifier()).willReturn(ProductModel.CODE);
		given(constraint.matchesNonLocalizedViolation(constraintViolation)).willReturn(Boolean.FALSE);
		mockValidateValue(ProductModel.CODE, Sets.newHashSet(constraintViolation));
		strategy.setSeverities(Arrays.asList(Severity.ERROR));

		// when
		final ExcelValidationResult validationResult = strategy.validate(importParameters, excelAttribute);

		// then
		assertThat(validationResult.getValidationErrors()).hasSize(1);
		assertThat(validationResult.getValidationErrors().get(0).getMessageKey()).isEqualTo(validationMessage);
	}

	@Test
	public void shouldReturnValidationErrorWhenAttributeIsLocalizedAndSeveritiesAreEqualAndConstraintIsLocalizedForGivenLanguage()
	{
		// given
		final String localizedValidationMessage = "Value cannot be empty in [en]";
		final LocalizedAttributeConstraint constraint = mockLocalizedConstraintsRegistry(Locale.ENGLISH);
		final ExcelAttribute excelAttribute = mock(ExcelAttribute.class);
		final ImportParameters importParameters = prepareImportParameters(StringUtils.EMPTY, Locale.ENGLISH.toString());
		final HybrisConstraintViolation constraintViolation = prepareLocalizedConstraintViolation(localizedValidationMessage,
				Severity.ERROR, Locale.ENGLISH);
		final ConstraintViolation constraintViolationOfValidationError = mock(ConstraintViolation.class);
		given(excelAttribute.getQualifier()).willReturn(ProductModel.CODE);
		given(constraint.matchesNonLocalizedViolation(constraintViolation)).willReturn(Boolean.TRUE);
		given(constraintViolation.getConstraintViolation()).willReturn(constraintViolationOfValidationError);
		given(violationFactory.createLocalizedConstraintViolation(any(), eq(Locale.ENGLISH))).willReturn(constraintViolation);
		mockValidateValue(ProductModel.CODE, Sets.newHashSet(constraintViolation));
		strategy.setSeverities(Arrays.asList(Severity.ERROR));

		// when
		final ExcelValidationResult validationResult = strategy.validate(importParameters, excelAttribute);

		// then
		assertThat(validationResult.getValidationErrors()).hasSize(1);
		assertThat(validationResult.getValidationErrors().get(0).getMessageKey()).isEqualTo(localizedValidationMessage);
	}

	@Test
	public void shouldNotReturnValidationErrorWhenAttributeIsLocalizedAndSeveritiesAreEqualAndConstraintIsNotLocalizedForGivenLanguage()
	{
		// given
		final String localizedValidationMessage = "Value cannot be empty in [en]";
		final LocalizedAttributeConstraint constraint = mockLocalizedConstraintsRegistry(Locale.ENGLISH);
		final ExcelAttribute excelAttribute = mock(ExcelAttribute.class);
		final ImportParameters importParameters = prepareImportParameters(StringUtils.EMPTY, Locale.GERMANY.toString());
		final HybrisConstraintViolation constraintViolation = prepareLocalizedConstraintViolation(localizedValidationMessage,
				Severity.ERROR, Locale.ENGLISH);
		final ConstraintViolation constraintViolationOfValidationError = mock(ConstraintViolation.class);
		given(excelAttribute.getQualifier()).willReturn(ProductModel.CODE);
		given(constraint.matchesNonLocalizedViolation(constraintViolation)).willReturn(Boolean.TRUE);
		Mockito.lenient().when(constraintViolation.getConstraintViolation()).thenReturn(constraintViolationOfValidationError);
		Mockito.lenient().when(violationFactory.createLocalizedConstraintViolation(any(), eq(Locale.ENGLISH))).thenReturn(constraintViolation);
		mockValidateValue(ProductModel.CODE, Sets.newHashSet(constraintViolation));
		strategy.setSeverities(Arrays.asList(Severity.ERROR));

		// when
		final ExcelValidationResult validationResult = strategy.validate(importParameters, excelAttribute);

		// then
		assertThat(validationResult.getValidationErrors()).isEmpty();
	}

	private LocalizedAttributeConstraint mockLocalizedConstraintsRegistry(final Locale locale)
	{
		final LocalizedAttributeConstraint localizedConstraint = mock(LocalizedAttributeConstraint.class);
		given(localizedConstraint.getLanguages()).willReturn(Arrays.asList(locale));
		given(excelLocalizedConstraintsProvider.getLocalizedAttributeConstraints(any(), any()))
				.willReturn(Arrays.asList(localizedConstraint));
		return localizedConstraint;
	}

	private ImportParameters prepareImportParameters(final String cellValue, final String isoCode)
	{
		return new ImportParameters(ProductModel._TYPECODE, isoCode, cellValue, null, Collections.emptyList());
	}

}
