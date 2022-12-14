/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.common.predicate;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.servicelayer.services.AttributeDescriptorModelHelperService;
import de.hybris.platform.cmsfacades.common.predicate.attributes.EnumTypeAttributePredicate;
import de.hybris.platform.core.HybrisEnumValue;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class EnumTypeAttributePredicateTest
{
	@Mock
	private AttributeDescriptorModelHelperService attributeDescriptorModelHelperService;
	@Mock
	private AttributeDescriptorModel attributeDescriptor;

	@InjectMocks
	private EnumTypeAttributePredicate predicate;


	public enum TestEnum implements HybrisEnumValue
	{
		;

		@Override
		public String getCode()
		{
			return null;
		}

		@Override
		public String getType()
		{
			return null;
		}


	}

	public static class TestDynamicEnum implements HybrisEnumValue
	{
		@Override
		public String getCode()
		{
			return null;
		}

		@Override
		public String getType()
		{
			return null;
		}
	}

	public static class NonEnum
	{

	}

	@Test
	public void givenAttributeDescriptorWhenNotEnumWillReturnFalse()
	{
		doReturn(String.class).when(attributeDescriptorModelHelperService).getAttributeClass(attributeDescriptor);

		assertThat(predicate.test(attributeDescriptor), is(false));
	}

	@Test
	public void givenAttributeDescriptorWhenEnumWillReturnTrue()
	{
		doReturn(TestEnum.class).when(attributeDescriptorModelHelperService).getAttributeClass(attributeDescriptor);

		assertThat(predicate.test(attributeDescriptor), is(true));
	}

	@Test
	public void givenAttributeDescriptorForRegularClass_WhenPredicateTested_ThenItReturnsFalse()
	{
		// GIVEN
		doReturn(NonEnum.class).when(attributeDescriptorModelHelperService).getAttributeClass(attributeDescriptor);

		// WHEN
		boolean result = predicate.test(attributeDescriptor);

		// THEN
		assertFalse(result);
	}

	@Test
	public void givenAttributeDescriptorForDynamicEnum_WhenPredicateTested_ThenItReturnsTrue()
	{
		// GIVEN
		doReturn(TestDynamicEnum.class).when(attributeDescriptorModelHelperService).getAttributeClass(attributeDescriptor);

		// WHEN
		boolean result = predicate.test(attributeDescriptor);

		// THEN
		assertTrue(result);
	}


}
