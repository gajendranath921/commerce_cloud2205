/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.types.populator;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cmsfacades.data.ComponentTypeAttributeData;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class I18nComponentTypeAttributePopulatorTest
{
	private static final String QUALIFIER = "QUALIFIER";
	private static final String ITEM_TYPE = "ITEM-TYPE";
	private static final String PREFIX = "PREFIX";
	private static final String SUFFIX = "SUFFIX";

	@InjectMocks
	private I18nComponentTypeAttributePopulator i18nComponentTypeAttributePopulator;

	@Mock
	private AttributeDescriptorModel attribute;
	@Mock
	private ComposedTypeModel type;

	private ComponentTypeAttributeData attributeDto;

	@Before
	public void setUp()
	{
		i18nComponentTypeAttributePopulator.setPrefix(PREFIX);
		i18nComponentTypeAttributePopulator.setSuffix(SUFFIX);
		attributeDto = new ComponentTypeAttributeData();

		Mockito.when(attribute.getDeclaringEnclosingType()).thenReturn(type);
		Mockito.when(type.getCode()).thenReturn(ITEM_TYPE);
		Mockito.when(attribute.getQualifier()).thenReturn(QUALIFIER);
	}

	@Test
	public void shouldPopulateI18nKey()
	{
		i18nComponentTypeAttributePopulator.populate(attribute, attributeDto);

		final String value = PREFIX + "." + ITEM_TYPE.toLowerCase() + "." + QUALIFIER + "." + SUFFIX;
		Assert.assertEquals(value.toLowerCase(), attributeDto.getI18nKey());
	}

}
