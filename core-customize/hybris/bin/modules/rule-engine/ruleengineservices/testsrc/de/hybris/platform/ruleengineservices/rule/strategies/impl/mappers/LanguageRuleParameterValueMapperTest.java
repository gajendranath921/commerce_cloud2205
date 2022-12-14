/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.ruleengineservices.rule.strategies.impl.mappers;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.ruleengineservices.rule.strategies.RuleParameterValueMapperException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import org.junit.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class LanguageRuleParameterValueMapperTest
{
	private static final String ANY_STRING = "anyString";

	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Mock
	private CommonI18NService commonI18NService;

	@Mock
	private LanguageModel language;

	@InjectMocks
	private final LanguageRuleParameterValueMapper mapper = new LanguageRuleParameterValueMapper();



	@Test
	public void nullTestFromString()
	{
		//expect
		expectedException.expect(IllegalArgumentException.class);

		//when
		mapper.fromString(null);
	}

	@Test
	public void nullTestToString()
	{
		//expect
		expectedException.expect(IllegalArgumentException.class);

		//when
		mapper.toString(null);
	}

	@Test
	public void noLanguageFoundTest()
	{
		//given
		BDDMockito.given(commonI18NService.getLanguage(Mockito.anyString())).willReturn(null);

		//expect
		expectedException.expect(RuleParameterValueMapperException.class);

		//when
		mapper.fromString(ANY_STRING);
	}

	@Test
	public void mappedLanguageTest()
	{
		//given
		BDDMockito.given(commonI18NService.getLanguage(Mockito.anyString())).willReturn(language);

		//when
		final LanguageModel mappedLanguage = mapper.fromString(ANY_STRING);

		//then
		Assert.assertEquals(language, mappedLanguage);
	}

	@Test
	public void objectToStringTest()
	{
		//given
		givenStringRepresentationAttribute();

		//when
		final String stringRepresentation = mapper.toString(language);

		//then
		Assert.assertEquals(ANY_STRING, stringRepresentation);
	}

	private void givenStringRepresentationAttribute()
	{
		BDDMockito.given(language.getIsocode()).willReturn(ANY_STRING);
	}
}
