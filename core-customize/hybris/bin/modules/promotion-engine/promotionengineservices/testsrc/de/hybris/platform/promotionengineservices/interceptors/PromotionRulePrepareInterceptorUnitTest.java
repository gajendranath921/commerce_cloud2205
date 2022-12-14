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
package de.hybris.platform.promotionengineservices.interceptors;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.promotionengineservices.model.PromotionSourceRuleModel;
import de.hybris.platform.promotionengineservices.model.RuleBasedPromotionModel;
import de.hybris.platform.ruleengine.enums.RuleType;
import de.hybris.platform.ruleengine.model.AbstractRuleEngineRuleModel;
import de.hybris.platform.ruleengineservices.compiler.RuleCompilerContextFactory;
import de.hybris.platform.ruleengineservices.compiler.impl.DefaultRuleCompilerContext;
import de.hybris.platform.ruleengineservices.rule.dao.RuleDao;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import static java.lang.Long.valueOf;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class PromotionRulePrepareInterceptorUnitTest
{

	private static final String RULE_CODE = "RULE_CODE";
	private static final String RULE_NAME = "Rule name";
	private static final String RULE_DESCRIPTION = "Rule description";

	@InjectMocks
	private PromotionRulePrepareInterceptor prepareInterceptor;
	@Mock
	private ModelService modelService;
	@Mock
	private CommonI18NService commonI18NService;
	@Mock
	private RuleCompilerContextFactory<DefaultRuleCompilerContext> ruleCompilerContextFactory;
	@Mock
	private InterceptorContext context;
	@Mock
	private RuleDao ruleDao;
	@Mock
	private PromotionSourceRuleModel sourceRule;
	@Mock
	private Date startDate;
	@Mock
	private Date endDate;
	private AbstractRuleEngineRuleModel ruleModel;
	private RuleBasedPromotionModel ruleBasedPromotion;
	@Mock
	private LanguageModel languageModel;

	@Before
	public void setUp()
	{
		ruleModel = getRule();
		ruleModel.setRuleType(RuleType.PROMOTION);
		ruleBasedPromotion = new RuleBasedPromotionModel();

		Mockito.lenient().when(modelService.create(RuleBasedPromotionModel.class)).thenReturn(ruleBasedPromotion);
		Mockito.lenient().when(commonI18NService.getAllLanguages()).thenReturn(Collections.singletonList(languageModel));
		Mockito.lenient().when(commonI18NService.getLocaleForLanguage(languageModel)).thenReturn(Locale.ENGLISH);

		//when(ruleCompilerContextFactory.getContext()).thenReturn(null);
		Mockito.lenient().when(ruleDao.findRuleByCode(RULE_CODE)).thenReturn(null);
	}

	@Test
	public void testOnPrepareNotPromotionRuleType() throws InterceptorException
	{
		prepareInterceptor = spy(prepareInterceptor);

		ruleModel.setRuleType(RuleType.DEFAULT);
		prepareInterceptor.onPrepare(ruleModel, context);
		verify(prepareInterceptor, times(0)).doOnPrepare(Mockito.eq(ruleModel), Mockito.eq(context));
	}

	@Test
	public void testOnPreparePromotionNotSet() throws InterceptorException
	{
		ruleModel.setVersion(valueOf(0));
		prepareInterceptor.onPrepare(ruleModel, context);
		assertThat(ruleModel.getPromotion()).isNotNull();
		assertThat(ruleModel.getPromotion().getRuleVersion()).isEqualTo(0);
	}

	@Test
	public void testOnPreparePromotionExistsWithSameVersion() throws InterceptorException
	{
		prepareInterceptor = spy(prepareInterceptor);

		ruleModel.setVersion(valueOf(0));
		ruleBasedPromotion.setRuleVersion(valueOf(0));
		ruleModel.setPromotion(ruleBasedPromotion);
		prepareInterceptor.onPrepare(ruleModel, context);

		verify(prepareInterceptor, times(0)).createNewPromotionAndAddToRuleModel(Mockito.eq(ruleModel));
	}

	@Test
	public void testOnPreparePromotionExistsWithDifferentVersion() throws InterceptorException
	{
		prepareInterceptor = spy(prepareInterceptor);
		Mockito.lenient().when(modelService.create(RuleBasedPromotionModel.class)).thenReturn(new RuleBasedPromotionModel());

		ruleModel.setVersion(valueOf(1));
		ruleBasedPromotion.setRuleVersion(valueOf(0));
		ruleModel.setPromotion(ruleBasedPromotion);
		prepareInterceptor.onPrepare(ruleModel, context);

		verify(prepareInterceptor, times(1)).createNewPromotionAndAddToRuleModel(Mockito.eq(ruleModel));
		assertThat(ruleModel.getPromotion()).isNotEqualTo(ruleBasedPromotion);
		assertThat(ruleModel.getPromotion().getRuleVersion()).isEqualTo(1);
	}

	@Test
	public void testOnPreparePromotionUsingStartAndEndDateConstraints() throws InterceptorException
	{
		//given
		prepareInterceptor = spy(prepareInterceptor);

		ruleModel.setVersion(valueOf(1));
		ruleBasedPromotion.setRuleVersion(valueOf(0));
		ruleModel.setPromotion(ruleBasedPromotion);
		Mockito.lenient().when(sourceRule.getStartDate()).thenReturn(startDate);
		Mockito.lenient().when(sourceRule.getEndDate()).thenReturn(endDate);
		ruleModel.setSourceRule(sourceRule);
		Mockito.lenient().when(ruleDao.findRuleByCode(RULE_CODE)).thenReturn(sourceRule);
		//when
		prepareInterceptor.onPrepare(ruleModel, context);
		//then
		assertThat(ruleBasedPromotion.getStartDate()).isEqualTo(startDate);
		assertThat(ruleBasedPromotion.getEndDate()).isEqualTo(endDate);
	}

	@Test
	public void testOnPreparePromotionUsingNameAndDescription() throws InterceptorException
	{
		//given
		prepareInterceptor = spy(prepareInterceptor);

		ruleModel.setVersion(valueOf(1));
		ruleBasedPromotion.setRuleVersion(valueOf(0));
		ruleModel.setPromotion(ruleBasedPromotion);
		Mockito.lenient().when(sourceRule.getDescription(Locale.ENGLISH)).thenReturn(RULE_DESCRIPTION);
		Mockito.lenient().when(sourceRule.getName(Locale.ENGLISH)).thenReturn(RULE_NAME);
		ruleModel.setSourceRule(sourceRule);
		Mockito.lenient().when(ruleDao.findRuleByCode(RULE_CODE)).thenReturn(sourceRule);
		//when
		prepareInterceptor.onPrepare(ruleModel, context);
		//then
		assertThat(ruleBasedPromotion.getPromotionDescription(Locale.ENGLISH)).isEqualTo(RULE_DESCRIPTION);
		assertThat(ruleBasedPromotion.getName(Locale.ENGLISH)).isEqualTo(RULE_NAME);
	}

	private AbstractRuleEngineRuleModel getRule()
	{
		final AbstractRuleEngineRuleModel ruleModel = new AbstractRuleEngineRuleModel();
		ruleModel.setCode(RULE_CODE);
		return ruleModel;
	}
}
