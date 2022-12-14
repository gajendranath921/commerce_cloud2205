/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.excel.classification;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hybris.backoffice.excel.data.ExcelClassificationAttribute;
import com.hybris.backoffice.excel.template.populator.extractor.ClassificationFullNameExtractor;


@RunWith(MockitoJUnitRunner.class)
public class ExcelClassificationAttributeFactoryTest
{
	@Mock
	ClassificationFullNameExtractor mockedFullNameExtractor;

	@InjectMocks
	ExcelClassificationAttributeFactory attributeFactory;

	@Test
	public void shouldCreateExcelClassificationAttributeFromAssignmentWithIsoCode()
	{
		// given
		final ClassAttributeAssignmentModel classAttributeAssignmentModel = mock(ClassAttributeAssignmentModel.class);
		final String isoCode = "en";
		given(mockedFullNameExtractor.extract(any(ExcelClassificationAttribute.class))).willReturn("name");

		// when
		final ExcelClassificationAttribute attribute = attributeFactory.create(classAttributeAssignmentModel, isoCode);

		// then
		assertThat(attribute.getIsoCode()).isEqualTo(isoCode);
		assertThat(attribute.getAttributeAssignment()).isEqualTo(classAttributeAssignmentModel);
		assertThat(attribute.getName()).isEqualTo("name");
	}

	@Test
	public void shouldCreateExcelClassificationAttributeFromAssignment()
	{
		// given
		final ClassAttributeAssignmentModel classAttributeAssignmentModel = mock(ClassAttributeAssignmentModel.class);
		given(mockedFullNameExtractor.extract(any(ExcelClassificationAttribute.class))).willReturn("name");

		// when
		final ExcelClassificationAttribute attribute = attributeFactory.create(classAttributeAssignmentModel);

		// then
		assertThat(attribute.getIsoCode()).isNull();
		assertThat(attribute.getAttributeAssignment()).isEqualTo(classAttributeAssignmentModel);
		assertThat(attribute.getName()).isEqualTo("name");
	}
}
