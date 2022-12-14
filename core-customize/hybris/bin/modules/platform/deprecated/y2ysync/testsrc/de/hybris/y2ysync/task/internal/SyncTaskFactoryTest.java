/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.y2ysync.task.internal;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.task.TaskConditionModel;
import de.hybris.platform.task.TaskModel;
import de.hybris.platform.task.TaskService;
import de.hybris.y2ysync.enums.Y2YSyncType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Lists;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class SyncTaskFactoryTest
{
	@InjectMocks
	private final SyncTaskFactory service = new SyncTaskFactory();
	@Mock
	private ModelService modelService;
	@Mock
	private TaskService taskService;
	@Mock
	private TaskModel task1, task2, mainTask;
	@Mock
	private TaskConditionModel condition1, condition2;
	@Mock
	private ComposedTypeModel composedType1, composedType2;

	@Before
	public void setUp() throws Exception
	{
		given(modelService.create(TaskModel.class)).willReturn(task1, task2, mainTask);
		given(modelService.create(TaskConditionModel.class)).willReturn(condition1, condition2);
		Mockito.lenient().when(composedType1.getCode()).thenReturn("Product");
		Mockito.lenient().when(composedType2.getCode()).thenReturn("Title");
	}


	@Test
	public void shouldRunChunkTasksForEachMediaPKPlusOneMainTaskWithConditions() throws Exception
	{
		// given
		final String syncExecutionID = "testSyncExecutionId";
		final PK productPk = PK.createFixedUUIDPK(100, 1);
		final PK titlePk = PK.createFixedUUIDPK(101, 1);

		final MediasForType mediasForType1 = MediasForType.builder()
		                                                  .withComposedTypeCode(composedType1.getCode())
		                                                  .withImpExHeader(";foo;bar;baz;")
		                                                  .withDataHubColumns(StringUtils.EMPTY)
		                                                  .withMediaPks(Lists.newArrayList(productPk))
		                                                  .withDataHubType("dataHubType")
		                                                  .build();
		final MediasForType mediasForType2 = MediasForType.builder()
		                                                  .withComposedTypeCode(composedType1.getCode())
		                                                  .withImpExHeader(";baz;boom;maz;")
		                                                  .withDataHubColumns(StringUtils.EMPTY)
		                                                  .withMediaPks(Lists.newArrayList(titlePk))
		                                                  .build();
		final ArrayList<MediasForType> mediasPerType = Lists.newArrayList(mediasForType1, mediasForType2);

		// when
		service.runSyncTasks(syncExecutionID, Y2YSyncType.ZIP, mediasPerType);

		// then
		verify(task1).setRunnerBean(SyncTaskFactory.CHUNK_TASK_RUNNER_BEAN_ID);
		verify(task2).setRunnerBean(SyncTaskFactory.CHUNK_TASK_RUNNER_BEAN_ID);
		verify(task1).setContext(service.getChunkTaskContext(syncExecutionID, Y2YSyncType.ZIP, productPk, mediasForType1));
		verify(task2).setContext(service.getChunkTaskContext(syncExecutionID, Y2YSyncType.ZIP, titlePk, mediasForType2));
		verify(task1).setExecutionDate(anyDate());
		verify(task2).setExecutionDate(anyDate());

		verify(condition1).setUniqueID(syncExecutionID + "_" + productPk);
		verify(condition2).setUniqueID(syncExecutionID + "_" + titlePk);

		verify(mainTask).setContext(service.getMainTaskContext(syncExecutionID));
		verify(mainTask).setConditions(exactConditions(condition1, condition2));

		verify(taskService).scheduleTask(task1);
		verify(taskService).scheduleTask(task2);
		verify(taskService).scheduleTask(mainTask);
	}

	private static <T> T anyDate()
	{
		return (T) argThat(new DateArgumentMatcher());
	}

	private static <T> T exactConditions(final TaskConditionModel... conditions)
	{
		return (T) argThat(new SetOfTaskConditions(conditions));
	}

	private static class DateArgumentMatcher implements ArgumentMatcher<Date>
	{
		@Override
		public boolean matches(final Date date)
		{
			return true;
		}
	}

	private static class SetOfTaskConditions implements ArgumentMatcher<Set<TaskConditionModel>>
	{
		private final List<TaskConditionModel> conditions;

		public SetOfTaskConditions(final TaskConditionModel... conditions)
		{
			this.conditions = Arrays.asList(conditions);
		}

		@Override
		public boolean matches(final Set<TaskConditionModel> taskConditionModels)
		{
			return taskConditionModels.containsAll(conditions);
		}
	}
}
