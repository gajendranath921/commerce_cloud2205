/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.excel.template.populator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hybris.backoffice.excel.data.ExcelAttribute;
import com.hybris.backoffice.excel.data.ExcelClassificationAttribute;
import com.hybris.backoffice.excel.translators.ExcelAttributeTranslator;
import com.hybris.backoffice.excel.translators.ExcelAttributeTranslatorRegistry;


@RunWith(MockitoJUnitRunner.class)
public class ClassificationReferenceFormatPopulatorTest
{

	@Mock
	private ExcelAttributeTranslatorRegistry registry;
	private ClassificationReferenceFormatPopulator populator = new ClassificationReferenceFormatPopulator();

	@Before
	public void setUp()
	{
		populator.setRegistry(registry);
	}

	@Test
	public void shouldCorrectReferenceFormatBeReturned()
	{
		// given
		final ExcelAttributeTranslator<ExcelAttribute> translator = mock(ExcelAttributeTranslator.class);
		final String referenceFormat = "system:version";

		final ExcelClassificationAttribute attribute = mock(ExcelClassificationAttribute.class);
		final ExcelAttributeContext<ExcelClassificationAttribute> context = DefaultExcelAttributeContext
				.ofExcelAttribute(attribute);

		given(translator.referenceFormat(attribute)).willReturn(referenceFormat);
		given(registry.findTranslator(attribute)).willReturn(Optional.of(translator));

		// when
		final String populatedValue = populator.apply(context);

		// then
		assertThat(populatedValue).isEqualTo(referenceFormat);
	}
}
