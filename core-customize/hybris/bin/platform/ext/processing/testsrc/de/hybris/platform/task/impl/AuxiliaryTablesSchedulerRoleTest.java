/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.task.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.task.TaskService;
import de.hybris.platform.task.impl.AuxiliaryTablesBasedTaskProvider.Params;
import de.hybris.platform.task.impl.gateways.BaseGateway;
import de.hybris.platform.task.impl.gateways.SchedulerStateGateway;
import de.hybris.platform.task.impl.gateways.TasksQueueGateway;
import de.hybris.platform.task.impl.gateways.WorkerStateGateway;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.Spy;
import org.mockito.quality.Strictness;
import org.springframework.jdbc.core.JdbcTemplate;

import com.codahale.metrics.MetricRegistry;

@IntegrationTest
public class AuxiliaryTablesSchedulerRoleTest extends ServicelayerBaseTest
{
	private static final Duration SCHEDULER_INTERVAL = Duration.ofMillis(10);

	private TimeZone defaultTimeZone;

	@Spy
	private MockRuntimeConfigHolder runtimeConfigHolder = new MockRuntimeConfigHolder();

	@Resource
	private AuxiliaryTablesGatewayFactory auxiliaryTablesGatewayFactory;
	@Resource
	private MetricRegistry metricRegistry;
	@Resource
	private TypeService typeService;
	@Resource
	private TaskService taskService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	private AuxiliaryTablesTaskProviderTestHelper testHelper;

	MockitoSession mockito;

	@Before
	public void setUp() throws Exception
	{
		mockito = Mockito.mockitoSession().initMocks(this).strictness(Strictness.LENIENT).startMocking();
		testHelper = new AuxiliaryTablesTaskProviderTestHelper(taskService, jdbcTemplate);
		testHelper.disableTaskEngine();

		defaultTimeZone = TimeZone.getDefault();

		recreateTables();
	}

	@After
	public void tearDown() throws Exception
	{
		mockito.finishMocking();
		if (defaultTimeZone != null)
		{
			TimeZone.setDefault(defaultTimeZone);
		}

		recreateTables();
		testHelper.enableTaskEngine();
	}

	@Test
	public void tryToPerformSchedulerJob() throws InterruptedException
	{
		final AuxiliaryTablesSchedulerRole schedulerRole = new AuxiliaryTablesSchedulerRole();
		final AuxiliaryTablesGatewayFactory spyGatewayFactory = spy(this.auxiliaryTablesGatewayFactory);

		final SchedulerStateGateway gateway = spy(this.auxiliaryTablesGatewayFactory.getSchedulerStateGateway());
		when(spyGatewayFactory.getSchedulerStateGateway()).thenReturn(gateway);

		schedulerRole.setGatewayFactory(spyGatewayFactory);
		schedulerRole.setMetricRegistry(metricRegistry);
		schedulerRole.setTypeService(typeService);
		schedulerRole.setWorkerHelper(new DefaultWorkerHelper());
		schedulerRole.afterPropertiesSet();

		Thread.sleep(100);

		final TaskEngineParameters.ParametersBuilder parametersBuilder = new TaskEngineParameters.ParametersBuilder();
		parametersBuilder.withClusterNodeID(500);

		schedulerRole.tryToPerformSchedulerJob(runtimeConfigHolder, parametersBuilder.build(), 10);
		final Instant now = gateway.getSchedulerTimestamp().get().getDbNow().minusSeconds(200);

		Thread.sleep(SCHEDULER_INTERVAL.multipliedBy(2).toMillis());

		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("America/Montreal")));
		schedulerRole.tryToPerformSchedulerJob(runtimeConfigHolder, parametersBuilder.build(), 10);

		final ArgumentCaptor<Duration> argCaptor = ArgumentCaptor.forClass(Duration.class);

		verify(gateway, times(2)).insertSchedulerRow(any(Instant.class), eq(AuxiliaryTablesBasedTaskProvider.VERSION));
		verify(gateway).updateSchedulerRow(argCaptor.capture());
		assertThat(argCaptor.getValue()).isEqualTo(runtimeConfigHolder.getProperty(Params.SCHEDULER_INTERVAL));
	}


	@Test
	public void shouldRecreateSchedulerTableAfterDeleteOfSchedulerRow() throws InterruptedException
	{
		//given
		final AuxiliaryTablesSchedulerRole schedulerRole = new AuxiliaryTablesSchedulerRole();
		final AuxiliaryTablesGatewayFactory spyGatewayFactory = spy(this.auxiliaryTablesGatewayFactory);
		final SchedulerStateGateway gateway = spy(this.auxiliaryTablesGatewayFactory.getSchedulerStateGateway());
		when(spyGatewayFactory.getSchedulerStateGateway()).thenReturn(gateway);

		prepareSchedulerRole(schedulerRole, spyGatewayFactory);
		Thread.sleep(100);

		schedulerRole.tryToPerformSchedulerJob(runtimeConfigHolder, createTaskEngineParameters(), 10);
		verify(gateway, times(2)).insertSchedulerRow( AuxiliaryTablesBasedTaskProvider.VERSION);
		verifyRecreationOfSchedulerTable(gateway, 1);

		//when
		spyGatewayFactory.getSchedulerStateGateway().deleteSchedulerRow();
		Thread.sleep(SCHEDULER_INTERVAL.multipliedBy(2).toMillis());
		schedulerRole.tryToPerformSchedulerJob(runtimeConfigHolder, createTaskEngineParameters(), 10);

		//then
		verify(gateway, times(4)).insertSchedulerRow( AuxiliaryTablesBasedTaskProvider.VERSION);
		verifyRecreationOfSchedulerTable(gateway, 2);
	}

	private TaskEngineParameters createTaskEngineParameters()
	{
		return new TaskEngineParameters.ParametersBuilder().withClusterNodeID(
				500).build();
	}

	private void prepareSchedulerRole(final AuxiliaryTablesSchedulerRole schedulerRole,
	                                  final AuxiliaryTablesGatewayFactory spyGatewayFactory)
	{
		schedulerRole.setGatewayFactory(spyGatewayFactory);
		schedulerRole.setMetricRegistry(metricRegistry);
		schedulerRole.setTypeService(typeService);
		schedulerRole.setWorkerHelper(new DefaultWorkerHelper());
		schedulerRole.afterPropertiesSet();
	}

	private void verifyRecreationOfSchedulerTable(final SchedulerStateGateway gateway, final int i)
	{
		verify(gateway, times(i)).dropTable();
		verify(gateway, times(i)).createTable();
	}

	private void recreateTables()
	{
		final TasksQueueGateway tasksQueueGateway = auxiliaryTablesGatewayFactory.getTasksQueueGateway();
		final WorkerStateGateway workerStateGateway = auxiliaryTablesGatewayFactory.getWorkerStateGateway();
		final SchedulerStateGateway schedulerStateGateway = auxiliaryTablesGatewayFactory.getSchedulerStateGateway();

		final List<BaseGateway> gateways = List.of(tasksQueueGateway, workerStateGateway, schedulerStateGateway);

		for (final BaseGateway gateway : gateways)
		{
			try
			{
				gateway.dropTable();
			}
			catch (final Exception ignored)
			{
			}
		}

		gateways.forEach(BaseGateway::createTable);

		gateways.forEach(gateway -> testHelper.assertTableExists(gateway.getTableName()));
	}

	public class MockRuntimeConfigHolder extends RuntimeConfigHolder
	{
		@Override
		public <T> T getProperty(final TaskEngineProperty<T> parameter)
		{
			if (Params.SCHEDULER_INTERVAL.equals(parameter))
			{
				return (T) SCHEDULER_INTERVAL;
			}
			if (Params.TASKS_RANGE_START.equals(parameter))
			{
				return (T) Integer.valueOf(0);
			}
			if (Params.TASKS_RANGE_END.equals(parameter))
			{
				return (T) Integer.valueOf(100);
			}
			if (Params.SCHEDULER_CLEAN_QUEUE_OLD_TASKS_THRESHOLD.equals(parameter))
			{
				return (T) Duration.ofSeconds(10);
			}

			return super.getProperty(parameter);
		}
	}
}
