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
package de.hybris.platform.ruleengineservices.jobs.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.jalo.CronJobProgressTracker;
import de.hybris.platform.ruleengineservices.jobs.RuleEngineJobExecutionSynchronizer;
import de.hybris.platform.ruleengineservices.maintenance.RuleCompilerPublisherResult;
import de.hybris.platform.ruleengineservices.maintenance.RuleMaintenanceService;
import de.hybris.platform.ruleengineservices.maintenance.impl.DefaultRuleCompilerPublisherResult;
import de.hybris.platform.ruleengineservices.model.RuleEngineCronJobModel;
import de.hybris.platform.ruleengineservices.model.SourceRuleModel;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class RuleEngineCompilePublishJobPerformableUnitTest
{
	private static final String MODULE_NAME = "test_module";

	@InjectMocks
	private RuleEngineCompilePublishJobPerformable jobPerformable;
	@Mock
	private RuleMaintenanceService ruleMaintenanceService;
	@Mock
	private RuleEngineCronJobModel ruleEngineCronJob;
	@Mock
	private CronJobProgressTracker cronJobProgressTracker;
	@Mock
	private ModelService modelService;
	@Mock
	private RuleEngineJobExecutionSynchronizer ruleEngineJobExecutionSynchronizer;

	private List<SourceRuleModel> sourceRules = newArrayList();

	@Before
	public void setUp()
	{
		jobPerformable = spy(jobPerformable);
		doReturn(cronJobProgressTracker).when(jobPerformable).createCronJobProgressTracker(ruleEngineCronJob);

		Mockito.lenient().when(ruleEngineCronJob.getSourceRules()).thenReturn(sourceRules);
		Mockito.lenient().when(ruleEngineCronJob.getEnableIncrementalUpdate()).thenReturn(Boolean.TRUE);
		Mockito.lenient().when(ruleEngineCronJob.getTargetModuleName()).thenReturn(MODULE_NAME);
	}

	@Test
	public void testPerformOk()
	{
		final RuleCompilerPublisherResult result = new DefaultRuleCompilerPublisherResult(RuleCompilerPublisherResult.Result.SUCCESS, newArrayList(), newArrayList());
		Mockito.lenient().when(ruleMaintenanceService.compileAndPublishRulesWithBlocking(sourceRules, MODULE_NAME, true, cronJobProgressTracker)).thenReturn(result);

		final PerformResult performResult = jobPerformable.perform(ruleEngineCronJob);
		assertThat(performResult.getResult()).isEqualTo(CronJobResult.SUCCESS);
	}

	@Test
	public void testPerformCompilerFailure()
	{
		final RuleCompilerPublisherResult result = new DefaultRuleCompilerPublisherResult(RuleCompilerPublisherResult.Result.COMPILER_ERROR, newArrayList(), newArrayList());
		Mockito.lenient().when(ruleMaintenanceService.compileAndPublishRulesWithBlocking(sourceRules, MODULE_NAME, true, cronJobProgressTracker)).thenReturn(result);

		final PerformResult performResult = jobPerformable.perform(ruleEngineCronJob);
		assertThat(performResult.getResult()).isEqualTo(CronJobResult.FAILURE);
	}

	@Test
	public void testPerformPublisherFailure()
	{
		final RuleCompilerPublisherResult result = new DefaultRuleCompilerPublisherResult(RuleCompilerPublisherResult.Result.PUBLISHER_ERROR, newArrayList(), newArrayList());
		Mockito.lenient().when(ruleMaintenanceService.compileAndPublishRulesWithBlocking(sourceRules, MODULE_NAME, true, cronJobProgressTracker)).thenReturn(result);

		final PerformResult performResult = jobPerformable.perform(ruleEngineCronJob);
		assertThat(performResult.getResult()).isEqualTo(CronJobResult.FAILURE);
	}

	@Test
	public void testPerformGenericOk()
	{ ;

		final PerformResult performResult = jobPerformable.perform(ruleEngineCronJob);
		assertThat(performResult.getResult()).isEqualTo(CronJobResult.SUCCESS);
	}


}
