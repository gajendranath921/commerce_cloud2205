/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class TypeCodeExistsPredicateTest
{
	private static final String VALID_CODE_UID = "valid-code-uid";
	private static final String INVALID_CODE_UID = "invalid-code-uid";

	@InjectMocks
	private final Predicate<String> predicate = new TypeCodeExistsPredicate();

	@Mock
	private TypeService typeService;
	@Mock
	private ComposedTypeModel composedType;

	private String target;

	@Before
	public void setUp()
	{
		target = VALID_CODE_UID;
		when(typeService.getComposedTypeForCode(target)).thenReturn(composedType);
	}

	@Test
	public void shouldFail_TypeCodeNotFound()
	{
		target = INVALID_CODE_UID;
		when(typeService.getComposedTypeForCode(target)).thenThrow(new UnknownIdentifierException("exception"));

		final boolean result = predicate.test(target);
		assertFalse(result);
	}

	@Test
	public void shouldPass_TypeCodeExists()
	{
		final boolean result = predicate.test(target);
		assertTrue(result);
	}
}
