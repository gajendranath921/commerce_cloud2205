/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.predicates;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cmsfacades.constants.CmsfacadesConstants;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;



@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class ComposedTypeContainsLinkTogglePredicateTest
{
	@InjectMocks
	private ComposedTypeContainsLinkTogglePredicate predicate;

	@Mock
	private ComposedTypeModel composedTypeModel;

	@Mock
	private AttributeDescriptorModel descriptorModel1;
	@Mock
	private AttributeDescriptorModel descriptorModel2;
	@Mock
	private AttributeDescriptorModel descriptorModel3;

	@Test
	public void testWhenComposedTypeModelContainsUrlLinkAndExternalFields_shouldReturnTrue()
	{
		// GIVEN
		when(composedTypeModel.getDeclaredattributedescriptors()).thenReturn(Arrays.asList(descriptorModel1, descriptorModel2));
		when(composedTypeModel.getInheritedattributedescriptors()).thenReturn(Arrays.asList(descriptorModel3));
		when(descriptorModel1.getQualifier()).thenReturn(CmsfacadesConstants.FIELD_URL_LINK_NAME);
		when(descriptorModel2.getQualifier()).thenReturn(CmsfacadesConstants.FIELD_EXTERNAL_NAME);
		when(descriptorModel3.getQualifier()).thenReturn("fakeField");

		// WHEN
		boolean result = predicate.test(composedTypeModel);

		// THEN
		assertThat(result, is(true));
	}

	@Test
	public void testWhenComposedTypeModelContainsOneOfUrlLinkAndExternalFields_shouldReturnFalse()
	{
		// GIVEN
		when(composedTypeModel.getInheritedattributedescriptors()).thenReturn(Arrays.asList(descriptorModel1, descriptorModel2));
		when(composedTypeModel.getDeclaredattributedescriptors()).thenReturn(Arrays.asList(descriptorModel3));
		when(descriptorModel1.getQualifier()).thenReturn(CmsfacadesConstants.FIELD_URL_LINK_NAME);
		when(descriptorModel2.getQualifier()).thenReturn("fakeField1");
		when(descriptorModel3.getQualifier()).thenReturn("fakeFiel2");

		// WHEN
		boolean result = predicate.test(composedTypeModel);

		// THEN
		assertThat(result, is(false));
	}
}
