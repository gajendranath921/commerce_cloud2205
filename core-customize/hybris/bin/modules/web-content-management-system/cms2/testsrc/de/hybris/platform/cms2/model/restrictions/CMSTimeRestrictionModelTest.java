/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2.model.restrictions;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;


@IntegrationTest
public class CMSTimeRestrictionModelTest extends ServicelayerBaseTest // NOPMD
{
	@Resource
	private ModelService modelService;
	@Resource
	private TypeService typeService;

	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test method for {@link de.hybris.platform.cms2.model.restrictions.CMSTimeRestrictionModel#getDescription()}.
	 */
	@Test
	public void shouldHaveDynamicAttributeDescriptor()
	{
		//given
		final ComposedTypeModel type = typeService.getComposedTypeForClass(CMSTimeRestrictionModel.class);

		//when
		final AttributeDescriptorModel attributeDescriptor = typeService.getAttributeDescriptor(type,
				CMSCategoryRestrictionModel.DESCRIPTION);

		//then
		assertThat(attributeDescriptor).isNotNull();
		assertThat(attributeDescriptor.getAttributeHandler()).isEqualTo("timeRestrictionDynamicDescription");
	}

	/**
	 * Test method for {@link de.hybris.platform.cms2.model.restrictions.CMSTimeRestrictionModel#getDescription()}.
	 *
	 * @throws ParseException
	 */
	@Test
	public void shouldReturnRestrictionDescription() throws ParseException
	{
		//given
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		final CMSTimeRestrictionModel restriction = modelService.create(CMSTimeRestrictionModel.class);
		restriction.setActiveFrom(dateFormat.parse("2011-01-01"));
		restriction.setActiveUntil(dateFormat.parse("2011-02-01"));

		//when
		final String description = restriction.getDescription();

		//then
		assertThat(description).isNotNull();
		assertThat(description).contains("1/1/11");
		assertThat(description).contains("2/1/11");
	}
}
