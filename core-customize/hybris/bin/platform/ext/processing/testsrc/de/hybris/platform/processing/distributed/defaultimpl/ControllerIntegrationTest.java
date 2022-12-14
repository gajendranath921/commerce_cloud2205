/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.processing.distributed.defaultimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.processing.distributed.ProcessCreationData;
import de.hybris.platform.processing.distributed.defaultimpl.DistributedProcessHandler.ModelWithDependencies;
import de.hybris.platform.processing.distributed.defaultimpl.DistributedProcessHandler.ProcessCreationContext;
import de.hybris.platform.processing.distributed.defaultimpl.DistributedProcessHandler.ProcessExecutionAnalysisContext;
import de.hybris.platform.processing.distributed.defaultimpl.DistributedProcessHandler.ProcessInitializationContext;
import de.hybris.platform.processing.enums.BatchType;
import de.hybris.platform.processing.enums.DistributedProcessState;
import de.hybris.platform.processing.model.BatchModel;
import de.hybris.platform.processing.model.DistributedProcessModel;
import de.hybris.platform.processing.model.DistributedProcessTransitionTaskModel;
import de.hybris.platform.processing.model.DistributedProcessWorkerTaskModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;

@IntegrationTest
public class ControllerIntegrationTest extends ServicelayerTransactionalBaseTest
{
	@Resource
	private ModelService modelService;
	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Resource
	private Scheduler distributedProcessScheduler;

	private MockitoSession mockito;

	@Mock
	private DistributedProcessHandler handler;

	@Mock
	private ProcessCreationContext creationCtx;
	@Mock
	private ProcessInitializationContext initializationCtx;
	@Mock
	private ProcessExecutionAnalysisContext analysisCtx;

	@Before
	public void setUp()
	{
		mockito = Mockito.mockitoSession().initMocks(this).startMocking();
	}

	@After
	public void tearDown()
	{
		mockito.finishMocking();
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenHandlerDoesntAssignCodeToNewProcess()
	{
		when(handler.createProcessCreationContext(any(ProcessCreationData.class))).thenReturn(creationCtx);
		when(creationCtx.createProcessModel()).then(m -> {
			final DistributedProcessModel process = modelService.create(DistributedProcessModel.class);
			process.setCode(null);
			return ModelWithDependencies.singleModel(process);
		});
		final Controller controller = givenController();
		final ProcessCreationData processData = mock(ProcessCreationData.class);

		try
		{
			controller.createProcess(processData);
		}
		catch (final IllegalStateException e)
		{
			assertThat(e).isNotNull().isExactlyInstanceOf(IllegalStateException.class).hasNoCause();
			assertThat(e.getMessage()).startsWith("Code ");
			return;
		}
		fail("IllegalStateException was expected but nothing has been thrown.");
	}

	@Test
	public void shouldCreateProcessInCreatedState()
	{
		when(handler.createProcessCreationContext(any(ProcessCreationData.class))).thenReturn(creationCtx);
		when(creationCtx.createProcessModel()).then(m -> {
			final DistributedProcessModel process = modelService.create(DistributedProcessModel.class);
			process.setCode("CODE");
			return ModelWithDependencies.singleModel(process);
		});
		when(creationCtx.initialBatches()).thenReturn(Stream.empty());
		final Controller controller = givenController();
		final ProcessCreationData processData = mock(ProcessCreationData.class);

		final DistributedProcessModel process = controller.createProcess(processData);

		assertThat(process).isNotNull();
		assertThat(process.getBatches()).isNotNull().isEmpty();
		assertThat(process.getCode()).isNotNull().isEqualTo("CODE");
		assertThat(process.getPk()).isNotNull();
		assertThat(process.getCurrentExecutionId()).isNotNull().isNotEmpty();
		assertThat(process.getState()).isEqualTo(DistributedProcessState.CREATED);
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenHandlerDoesntAssignIdToInitialBatch()
	{
		when(handler.createProcessCreationContext(any(ProcessCreationData.class))).thenReturn(creationCtx);
		when(creationCtx.createProcessModel()).then(m -> {
			final DistributedProcessModel process = modelService.create(DistributedProcessModel.class);
			process.setCode("CODE");
			return ModelWithDependencies.singleModel(process);
		});
		when(creationCtx.initialBatches()).then(m -> {
			final BatchModel batch = modelService.create(BatchModel.class);
			return Stream.of(ModelWithDependencies.singleModel(batch));
		});
		final Controller controller = givenController();
		final ProcessCreationData processData = mock(ProcessCreationData.class);

		try
		{
			controller.createProcess(processData);
		}
		catch (final IllegalStateException e)
		{
			assertThat(e).isNotNull().isExactlyInstanceOf(IllegalStateException.class).hasNoCause();
			assertThat(e.getMessage()).startsWith("Id ");
			return;
		}
		fail("IllegalStateException was expected but nothing has been thrown.");
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenHandlerDoesntSpecifyRemainingWorkLoadForInitialBatch()
	{
		when(handler.createProcessCreationContext(any(ProcessCreationData.class))).thenReturn(creationCtx);
		when(creationCtx.createProcessModel()).then(m -> {
			final DistributedProcessModel process = modelService.create(DistributedProcessModel.class);
			process.setCode("CODE");
			return ModelWithDependencies.singleModel(process);
		});
		when(creationCtx.initialBatches()).then(m -> {
			final BatchModel batch = modelService.create(BatchModel.class);
			batch.setId("B1");
			return Stream.of(ModelWithDependencies.singleModel(batch));
		});
		final Controller controller = givenController();
		final ProcessCreationData processData = mock(ProcessCreationData.class);

		try
		{
			controller.createProcess(processData);
		}
		catch (final IllegalStateException e)
		{
			assertThat(e).isNotNull().isExactlyInstanceOf(IllegalStateException.class).hasNoCause();
			assertThat(e.getMessage()).startsWith("Amount of work ");
			return;
		}
		fail("IllegalStateException was expected but nothing has been thrown.");
	}

	@Test
	public void shouldCreateInitialBatchProvidedByHandler()
	{
		when(handler.createProcessCreationContext(any(ProcessCreationData.class))).thenReturn(creationCtx);
		when(creationCtx.createProcessModel()).then(m -> {
			final DistributedProcessModel process = modelService.create(DistributedProcessModel.class);
			process.setCode("CODE");
			return ModelWithDependencies.singleModel(process);
		});
		when(creationCtx.initialBatches()).then(m -> {
			final BatchModel batch = modelService.create(BatchModel.class);
			batch.setId("B1");
			batch.setRemainingWorkLoad(123);
			return Stream.of(ModelWithDependencies.singleModel(batch));
		});
		final Controller controller = givenController();
		final ProcessCreationData processData = mock(ProcessCreationData.class);

		final DistributedProcessModel process = controller.createProcess(processData);

		assertThat(process.getBatches()).isNotNull().isNotEmpty().hasSize(1);
		final BatchModel batch = process.getBatches().iterator().next();
		assertThat(batch).isNotNull();
		assertThat(batch.getId()).isNotNull().isEqualTo("B1");
		assertThat(batch.getRemainingWorkLoad()).isEqualTo(123);
		assertThat(batch.getProcess()).isSameAs(process);
		assertThat(batch.getExecutionId()).isEqualTo(process.getCurrentExecutionId());
		assertThat(batch.getType()).isEqualTo(BatchType.INITIAL);
	}

	@Test
	public void shouldPersistAdditionalModelsProvidedByHandlerDuringCreation()
	{
		when(handler.createProcessCreationContext(any(ProcessCreationData.class))).thenReturn(creationCtx);

		final TitleModel t1 = modelService.create(TitleModel.class);
		t1.setCode("T1");
		final TitleModel t2 = modelService.create(TitleModel.class);
		t2.setCode("T2");
		when(creationCtx.createProcessModel()).then(m -> {
			final DistributedProcessModel process = modelService.create(DistributedProcessModel.class);
			process.setCode("CODE");
			return ModelWithDependencies.modelWithDependencies(process, t1);
		});
		when(creationCtx.initialBatches()).then(m -> {
			final BatchModel batch = modelService.create(BatchModel.class);
			batch.setId("B1");
			batch.setRemainingWorkLoad(123);
			return Stream.of(ModelWithDependencies.modelWithDependencies(batch, t2));
		});
		final Controller controller = givenController();
		final ProcessCreationData processData = mock(ProcessCreationData.class);

		controller.createProcess(processData);

		assertThat(t1.getPk()).isNotNull();
		assertThat(t2.getPk()).isNotNull();
	}

	@Test
	public void shouldBeAbleToPersist_10_000_OfBatches()
	{
		when(handler.createProcessCreationContext(any(ProcessCreationData.class))).thenReturn(creationCtx);

		final long numberOfElements = 10_000;
		final Stopwatch stopwatch = Stopwatch.createStarted();
		when(creationCtx.createProcessModel()).then(m -> {
			final DistributedProcessModel process = modelService.create(DistributedProcessModel.class);
			process.setCode("CODE");
			return ModelWithDependencies.singleModel(process);
		});
		when(creationCtx.initialBatches()).then(m -> LongStream.range(1, numberOfElements + 1).mapToObj(i -> {

			if (i % 1234 == 0 || i == numberOfElements)
			{
				Runtime.getRuntime().gc();
				Runtime.getRuntime().gc();
				Runtime.getRuntime().gc();
				final int total = (int) (Runtime.getRuntime().totalMemory() >> 20);
				final int free = (int) (Runtime.getRuntime().freeMemory() >> 20);
				final int used = total - free;
				final int progress = (int) ((i * 100) / numberOfElements);
				final String info = String.format("%d\tT: %d\tU: %d\tF: %d\tTIME: %s", progress,
						total, used, free,
						stopwatch);
				System.out.println(info);
			}

			final BatchModel batch = modelService.create(BatchModel.class);
			batch.setId("B" + i);
			batch.setRemainingWorkLoad(321);
			return ModelWithDependencies.singleModel(batch);
		}));
		final Controller controller = givenController();
		final ProcessCreationData processData = mock(ProcessCreationData.class);

		controller.createProcess(processData);
		System.out.println("FINISHED: " + stopwatch);
	}

	@Test
	public void shouldScheduleInitializationTaskWhenStartingProcess()
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.CREATED);
		final Controller controller = givenController();

		final DistributedProcessModel startedProcess = controller.startProcess(process);

		assertThat(startedProcess).isNotNull();
		assertThat(startedProcess.getState()).isEqualTo(DistributedProcessState.INITIALIZING);

		final DistributedProcessTransitionTaskModel task = expectedTransitionTask(process);
		assertThat(task.getPk()).isNotNull();
		assertThat(task.getState()).isEqualTo(DistributedProcessState.INITIALIZING);
	}

	@Test
	public void shouldInitializeProcessUsingHandler()
	{
		when(handler.createProcessInitializationContext(any(DistributedProcessModel.class))).thenReturn(initializationCtx);

		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.INITIALIZING);
		when(initializationCtx.initializeProcess()).thenReturn(ModelWithDependencies.singleModel(process));
		when(initializationCtx.firstExecutionInputBatches()).thenReturn(Stream.empty());
		final Controller controller = givenController();

		controller.initializeProcess(process);

		verify(initializationCtx).firstExecutionInputBatches();
		verify(initializationCtx).initializeProcess();
	}

	@Test
	public void shouldSucceedProcessWhenThereAreNoBatchesDuringInitialization()
	{
		when(handler.createProcessInitializationContext(any(DistributedProcessModel.class))).thenReturn(initializationCtx);

		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.INITIALIZING);
		when(initializationCtx.initializeProcess()).thenReturn(ModelWithDependencies.singleModel(process));
		when(initializationCtx.firstExecutionInputBatches()).thenReturn(Stream.empty());
		final Controller controller = givenController();

		controller.initializeProcess(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.SUCCEEDED);
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenHandlerDoesntAssignIdToInputBatch()
	{
		when(handler.createProcessInitializationContext(any(DistributedProcessModel.class))).thenReturn(initializationCtx);

		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.INITIALIZING);

		final BatchModel b1 = modelService.create(BatchModel.class);

		when(initializationCtx.initializeProcess()).thenReturn(ModelWithDependencies.singleModel(process));
		when(initializationCtx.firstExecutionInputBatches()).thenReturn(Stream.of(ModelWithDependencies.singleModel(b1)));
		final Controller controller = givenController();

		try
		{
			controller.initializeProcess(process);
		}
		catch (final IllegalStateException e)
		{
			assertThat(e).isNotNull().isExactlyInstanceOf(IllegalStateException.class).hasNoCause();
			assertThat(e.getMessage()).startsWith("Id ");
			return;
		}
		fail("IllegalStateException was expected but nothing has been thrown.");
	}

	@Test
	public void shouldThrowIllegalStateExceptionWhenHandlerDoesntSpecifyRemainingWorkLoadForInputBatch()
	{
		when(handler.createProcessInitializationContext(any(DistributedProcessModel.class))).thenReturn(initializationCtx);

		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.INITIALIZING);

		final BatchModel b1 = modelService.create(BatchModel.class);
		b1.setId("TT_ID");

		when(initializationCtx.initializeProcess()).thenReturn(ModelWithDependencies.singleModel(process));
		when(initializationCtx.firstExecutionInputBatches()).thenReturn(Stream.of(ModelWithDependencies.singleModel(b1)));
		final Controller controller = givenController();

		try
		{
			controller.initializeProcess(process);
		}
		catch (final IllegalStateException e)
		{
			assertThat(e).isNotNull().isExactlyInstanceOf(IllegalStateException.class).hasNoCause();
			assertThat(e.getMessage()).startsWith("Amount of work ");
			return;
		}
		fail("IllegalStateException was expected but nothing has been thrown.");
	}

	@Test
	public void shouldTransitAndCreateInputBatchesDuringInitialization()
	{
		when(handler.createProcessInitializationContext(any(DistributedProcessModel.class))).thenReturn(initializationCtx);

		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.INITIALIZING);

		final BatchModel b1 = modelService.create(BatchModel.class);
		b1.setId("b1");
		b1.setRemainingWorkLoad(123);

		when(initializationCtx.initializeProcess()).thenReturn(ModelWithDependencies.singleModel(process));
		when(initializationCtx.firstExecutionInputBatches()).thenReturn(Stream.of(ModelWithDependencies.singleModel(b1)));
		final Controller controller = givenController();

		controller.initializeProcess(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.SCHEDULING_EXECUTION);
		assertThat(b1.getType()).isEqualTo(BatchType.INPUT);
		assertThat(b1.getPk()).isNotNull();
		assertThat(b1.getProcess()).isSameAs(process);
	}

	@Test
	public void shouldScheduleWorkerTaskAndWithWaitTaskDuringScheduling()
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.SCHEDULING_EXECUTION);
		final BatchModel inputBatch = givenInputBatch(process);
		modelService.save(inputBatch);
		final Controller controller = givenController();

		controller.scheduleExecution(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.WAITING_FOR_EXECUTION);

		final DistributedProcessWorkerTaskModel workerTask = expectedWorkerTask(inputBatch);
		assertThat(workerTask.getConditionId()).isNotNull().contains(process.getCode()).contains(inputBatch.getExecutionId())
		                                       .contains(inputBatch.getId());

		final DistributedProcessTransitionTaskModel transitionTask = expectedTransitionTask(process);
		assertThat(transitionTask.getState()).isEqualTo(DistributedProcessState.WAITING_FOR_EXECUTION);
		assertThat(transitionTask.getConditions()).isNotNull().hasSize(1);
		assertThat(transitionTask.getConditions().iterator().next().getUniqueID()).isNotNull()
		                                                                          .isEqualTo(workerTask.getConditionId());
	}

	@Test
	public void shouldSucceedProcessIfHandlerReportsSuccess()
	{
		when(handler.createProcessExecutionAnalysisContext(any(DistributedProcessModel.class))).thenReturn(analysisCtx);

		when(analysisCtx.processSucceeded()).thenReturn(Boolean.TRUE);
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.WAITING_FOR_EXECUTION);
		final Controller controller = givenController();

		controller.analyseExecutionResults(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.SUCCEEDED);
	}

	@Test
	public void shouldFailProcessIfHandlerReportsFailure()
	{
		when(handler.createProcessExecutionAnalysisContext(any(DistributedProcessModel.class))).thenReturn(analysisCtx);

		when(analysisCtx.processFailed()).thenReturn(Boolean.TRUE);
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.WAITING_FOR_EXECUTION);
		final Controller controller = givenController();

		controller.analyseExecutionResults(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.FAILED);
	}

	@Test
	public void shouldFailWhenHandlerDoesntChangeExecutionId()
	{
		when(handler.createProcessExecutionAnalysisContext(any(DistributedProcessModel.class))).thenReturn(analysisCtx);

		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.WAITING_FOR_EXECUTION);
		final Controller controller = givenController();
		when(analysisCtx.prepareProcessForNextExecution()).thenReturn(ModelWithDependencies.singleModel(process));

		try
		{
			controller.analyseExecutionResults(process);
		}
		catch (final IllegalStateException e)
		{
			assertThat(e).isExactlyInstanceOf(IllegalStateException.class).hasNoCause();
			assertThat(e.getMessage()).isNotNull().startsWith("execution id ");
			return;
		}
		fail("IllegalStateException was expected but nothing has been thrown.");
	}

	@Test
	public void shouldSucceedProcessIfHandlerReportsNoInputBatches()
	{
		when(handler.createProcessExecutionAnalysisContext(any(DistributedProcessModel.class))).thenReturn(analysisCtx);

		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.WAITING_FOR_EXECUTION);
		final Controller controller = givenController();
		when(analysisCtx.prepareProcessForNextExecution()).then(m -> {
			process.setCurrentExecutionId("NEXT_EXECUTION_ID");
			return ModelWithDependencies.singleModel(process);
		});
		when(analysisCtx.nextExecutionInputBatches()).thenReturn(Stream.empty());

		controller.analyseExecutionResults(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.SUCCEEDED);
	}

	@Test
	public void shouldTransitToScheduleExecutionWhenThereIsAnyInputBatchReturnedByHandler()
	{
		when(handler.createProcessExecutionAnalysisContext(any(DistributedProcessModel.class))).thenReturn(analysisCtx);

		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.WAITING_FOR_EXECUTION);
		final Controller controller = givenController();
		when(analysisCtx.prepareProcessForNextExecution()).then(m -> {
			process.setCurrentExecutionId("NEXT_EXECUTION_ID");
			return ModelWithDependencies.singleModel(process);
		});
		when(analysisCtx.nextExecutionInputBatches()).then(m -> {
			final BatchModel batch = givenInputBatch(process);
			return Stream.of(ModelWithDependencies.singleModel(batch));
		});

		controller.analyseExecutionResults(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.SCHEDULING_EXECUTION);

		final DistributedProcessTransitionTaskModel task = expectedTransitionTask(process);
		assertThat(task.getPk()).isNotNull();
		assertThat(task.getState()).isEqualTo(DistributedProcessState.SCHEDULING_EXECUTION);
	}

	@Test
	public void shouldStopProcessImmediatelyWhenItsInCreatedState()
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.CREATED);
		final Controller controller = givenController();

		controller.requestToStopProcess(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.STOPPED);
	}

	@Test
	public void shouldMarkProcessToBeStoppedWhenItsRunning()
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.INITIALIZING);
		final Controller controller = givenController();

		controller.requestToStopProcess(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.INITIALIZING);
		assertThat(process.isStopRequested()).isTrue();
	}

	@Test
	public void shouldNotMarkProcessToBeStoppedWhenItsFinished()
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.SUCCEEDED);
		final Controller controller = givenController();

		controller.requestToStopProcess(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.SUCCEEDED);
		assertThat(process.isStopRequested()).isFalse();
	}

	@Test
	public void shouldStopProcessWhenItsRunning()
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.WAITING_FOR_EXECUTION);
		final Controller controller = givenController();

		controller.stopProcess(process);

		assertThat(process.getState()).isEqualTo(DistributedProcessState.STOPPED);
	}

	@Test
	public void shouldNotWaitForProcessIfItHasAlreadyFinished() throws InterruptedException
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.FAILED);
		final Controller controller = givenController();

		final Stopwatch sw = Stopwatch.createStarted();
		controller.waitForProcess(process, 5);

		assertThat(sw.elapsed(TimeUnit.SECONDS)).isZero();
		assertThat(process.getState()).isEqualTo(DistributedProcessState.FAILED);
	}

	@Test
	public void shouldWaitForProcessWhichIsRunning() throws InterruptedException
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.WAITING_FOR_EXECUTION);
		final Controller controller = givenController();

		final Stopwatch sw = Stopwatch.createStarted();
		controller.waitForProcess(process, 5);

		assertThat(sw.elapsed(TimeUnit.SECONDS)).isGreaterThan(4);
		assertThat(process.getState()).isEqualTo(DistributedProcessState.WAITING_FOR_EXECUTION);
	}

	@Test
	public void shouldWaitTillProcessIsFinished() throws InterruptedException
	{
		final DistributedProcessModel process = givenProcessInState(DistributedProcessState.WAITING_FOR_EXECUTION);
		final Controller controller = givenController();

		final Stopwatch sw = Stopwatch.createStarted();

		controller.waitForProcess(process, 10);
		assertThat(sw.elapsed(TimeUnit.SECONDS)).isGreaterThan(5);
		assertThat(process.getState()).isEqualTo(DistributedProcessState.WAITING_FOR_EXECUTION);

		controller.stopProcess(process);

		sw.reset().start();
		controller.waitForProcess(process, 10);
		assertThat(sw.elapsed(TimeUnit.SECONDS)).isLessThan(5);
		assertThat(process.getState()).isEqualTo(DistributedProcessState.STOPPED);
	}

	private DistributedProcessWorkerTaskModel expectedWorkerTask(final BatchModel batch)
	{
		final String query = "select {PK} from {" + DistributedProcessWorkerTaskModel._TYPECODE + "} where {"
				+ DistributedProcessWorkerTaskModel.CONTEXTITEM + "}=?batch";
		final Map<String, Object> params = ImmutableMap.of("batch", batch);
		final List<DistributedProcessWorkerTaskModel> tasks = flexibleSearchService
				.<DistributedProcessWorkerTaskModel>search(query, params).getResult();
		assertThat(tasks).isNotNull().hasSize(1);
		return tasks.get(0);
	}

	private DistributedProcessTransitionTaskModel expectedTransitionTask(final DistributedProcessModel process)
	{
		final String query = "select {PK} from {" + DistributedProcessTransitionTaskModel._TYPECODE + "} where {"
				+ DistributedProcessTransitionTaskModel.CONTEXTITEM + "}=?process";
		final Map<String, Object> params = ImmutableMap.of("process", process);
		final List<DistributedProcessTransitionTaskModel> tasks = flexibleSearchService
				.<DistributedProcessTransitionTaskModel>search(query, params).getResult();
		assertThat(tasks).isNotNull().hasSize(1);
		return tasks.get(0);
	}

	private BatchModel givenInputBatch(final DistributedProcessModel process)
	{
		return givenBatch(process);
	}

	private BatchModel givenBatch(final DistributedProcessModel process)
	{
		final BatchModel batch = modelService.create(BatchModel.class);

		batch.setId("BATCH_" + UUID.randomUUID());
		batch.setExecutionId(process.getCurrentExecutionId());
		batch.setType(BatchType.INPUT);
		batch.setRemainingWorkLoad(123);
		batch.setProcess(process);

		return batch;
	}

	private Controller givenController()
	{
		return new Controller(modelService, flexibleSearchService, distributedProcessScheduler)
		{
			@Override
			DistributedProcessHandler getHandler(final String handlerBeanId)
			{
				return handler;
			}
		};
	}

	private DistributedProcessModel givenProcessInState(final DistributedProcessState state)
	{
		final DistributedProcessModel process = modelService.create(DistributedProcessModel.class);

		process.setCode(UUID.randomUUID().toString());
		process.setState(state);
		process.setCurrentExecutionId("EXECUTION");

		modelService.save(process);

		return process;
	}
}

