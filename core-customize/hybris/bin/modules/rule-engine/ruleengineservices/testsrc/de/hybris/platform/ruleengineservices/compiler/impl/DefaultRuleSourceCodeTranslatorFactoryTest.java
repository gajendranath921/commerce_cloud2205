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
package de.hybris.platform.ruleengineservices.compiler.impl;

import static org.junit.Assert.assertSame;
import org.mockito.Mockito;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.ruleengineservices.compiler.RuleCompilerContext;
import de.hybris.platform.ruleengineservices.compiler.RuleSourceCodeTranslator;
import de.hybris.platform.ruleengineservices.model.SourceRuleModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultRuleSourceCodeTranslatorFactoryTest
{
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Mock
	private SourceRuleModel sourceRule;

	@Mock
	private RuleCompilerContext ruleCompilerContext;

	@Mock
	private RuleSourceCodeTranslator sourceRuleSourceCodeTranslator;

	private DefaultRuleSourceCodeTranslatorFactory ruleSourceCodeTranslatorFactory;

	@Before
	public void setUp()
	{

		ruleSourceCodeTranslatorFactory = new DefaultRuleSourceCodeTranslatorFactory();
		ruleSourceCodeTranslatorFactory.setSourceRuleSourceCodeTranslator(sourceRuleSourceCodeTranslator);
	}

	@Test
	public void testGetTranslator() throws Exception
	{
		// given
		Mockito.lenient().when(ruleCompilerContext.getRule()).thenReturn(sourceRule);

		// Mockito.lenient().when
		final RuleSourceCodeTranslator translator = ruleSourceCodeTranslatorFactory.getSourceCodeTranslator(ruleCompilerContext);

		// then
		assertSame(sourceRuleSourceCodeTranslator, translator);
	}
}
