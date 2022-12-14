/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.validator.impl;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cmsfacades.validator.data.ValidationError;

import org.apache.commons.lang.SerializationException;
import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class DefaultValidationErrorsTest
{

	private static final String FIELD = "field";
	private static final String FIELD2 = "field2";
	private DefaultValidationErrors validationErrors = new DefaultValidationErrors();
	
	@Test
	public void testAddNewErrorWithNothingStacked_shouldHaveOneErrorInList()
	{
		final ValidationError validationError = new ValidationError();
		validationError.setField(FIELD);
		validationErrors.add(validationError);
		assertThat(validationErrors.getValidationErrors(), not(empty()));
		assertThat(validationErrors.getValidationErrors().get(0), is(validationError));
	}


	@Test
	public void testPushFieldNameInStack_shouldUpdateStack()
	{
		validationErrors.pushField(FIELD);
		assertThat(validationErrors.getFieldStack(), not(empty()));
		assertThat(validationErrors.getFieldStack().poll(), is(FIELD));
	}


	@Test
	public void testPopFieldNameInStack_shouldUpdateStack()
	{
		validationErrors.pushField(FIELD);
		assertThat(validationErrors.getFieldStack(), not(empty()));
		assertThat(validationErrors.getFieldStack().peek(), is(FIELD));
		validationErrors.popField();
		assertThat(validationErrors.getFieldStack(), empty());
	}



	@Test
	public void testAddNewErrorWithFIELDStacked_shouldHaveOneErrorInList()
	{
		validationErrors.pushField(FIELD);
		
		final ValidationError validationError = new ValidationError();
		validationError.setField(FIELD2);
		
		validationErrors.add(validationError);
		assertThat(validationErrors.getValidationErrors(), not(empty()));
		
		assertThat(validationErrors.getValidationErrors().get(0), is(validationError));
		
		assertThat(validationError.getField(), is(FIELD + DefaultValidationErrors.SEPARATOR + FIELD2));
	}

	@Test
	public void testDefaultValidationErrors_shouldBeSerializable()
	{
		// GIVEN
		DefaultValidationErrors errors = new DefaultValidationErrors();
		ValidationError validationError = new ValidationError();
		validationError.setErrorCode("fakeErrorCode");
		validationError.setLanguage("fakeLanguage");
		errors.add(validationError);
		boolean isSerialized = true;

		// WHEN
		try
		{
			SerializationUtils.serialize(errors);
		}
		catch (SerializationException e)
		{
			isSerialized = false;
		}

		// THEN
		assertTrue("DefaultValidationErrors should be serializable ", isSerialized);
	}
	
}
