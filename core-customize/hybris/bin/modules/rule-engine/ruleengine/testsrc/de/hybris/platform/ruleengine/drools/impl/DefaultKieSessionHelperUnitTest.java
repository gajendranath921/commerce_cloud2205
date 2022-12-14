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
package de.hybris.platform.ruleengine.drools.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.ruleengine.RuleEvaluationContext;
import de.hybris.platform.ruleengine.RuleExecutionCountListener;
import de.hybris.platform.ruleengine.enums.DroolsSessionType;
import de.hybris.platform.ruleengine.exception.RuleEngineRuntimeException;
import de.hybris.platform.ruleengine.impl.RuleMatchCountListener;
import de.hybris.platform.ruleengine.model.DroolsKIESessionModel;
import de.hybris.platform.ruleengine.model.DroolsRuleEngineContextModel;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionsPool;
import org.kie.api.runtime.StatelessKieSession;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultKieSessionHelperUnitTest
{

	private static final String TEST_SESSION_NAME = "TEST_SESSION_NAME";

	private DefaultKieSessionHelper kieSessionHelper;
	@Mock
	private RuleEvaluationContext context;
	@Mock
	private DroolsRuleEngineContextModel ruleEngineContext;
	@Mock
	private KieContainer kieContainer;
	@Mock
	private KieBase kieBase;
	@Mock
	private DroolsKIESessionModel droolsKieSession;
	@Mock
	private KieSession kieSession;
	@Mock
	private StatelessKieSession statelessKieSession;
	@Mock
	private KieSessionsPool kieSessionsPool;
	@Mock
	private KieContainerSessionsPool kieContainerSessionsPool;

	@Before
	public void setUp()
	{
		kieSessionHelper = new DefaultKieSessionHelper();
		Mockito.lenient().when(context.getRuleEngineContext()).thenReturn(ruleEngineContext);
		Mockito.lenient().when(ruleEngineContext.getKieSession()).thenReturn(droolsKieSession);
		Mockito.lenient().when(kieContainer.newKieSession(anyString())).thenReturn(kieSession);
		Mockito.lenient().when(kieContainer.getKieBase()).thenReturn(kieBase);
		Mockito.lenient().when(kieBase.newKieSessionsPool(anyInt())).thenReturn(kieSessionsPool);
		Mockito.lenient().when(kieContainer.newKieSessionsPool(anyInt())).thenReturn(kieContainerSessionsPool);
		Mockito.lenient().when(kieSessionsPool.newStatelessKieSession()).thenReturn(statelessKieSession);
		Mockito.lenient().when(kieContainerSessionsPool.newKieSession()).thenReturn(kieSession);
		Mockito.lenient().when(droolsKieSession.getName()).thenReturn(TEST_SESSION_NAME);
	}

	@Test
	public void testCreateRuleExecutionCounterListener()
	{
		kieSessionHelper.setRuleExecutionCounterClass(RuleExecutionCountListener.class);
		try
		{
			kieSessionHelper.createRuleExecutionCounterListener();
			fail("Exception expected");
		}
		catch (final RuleEngineRuntimeException e)
		{
			assertThat(e.getMessage(), is(not(nullValue())));
		}

		kieSessionHelper.setRuleExecutionCounterClass(RuleMatchCountListener.class);
		final RuleExecutionCountListener createRuleExecutionCounterListener = kieSessionHelper
				.createRuleExecutionCounterListener();
		assertThat(createRuleExecutionCounterListener, is(instanceOf(RuleExecutionCountListener.class)));
	}

	@Test
	public void testInitializeKieSessionInternalWrongType()
	{
		// given
		Mockito.lenient().when(droolsKieSession.getSessionType()).thenReturn(DroolsSessionType.STATELESS);

		// execute and check
		Assertions.assertThatThrownBy(() -> kieSessionHelper.initializeKieSessionInternal(context, ruleEngineContext, kieContainer))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void testInitializeStatelessKieSessionInternalWrongType()
	{
		// given
		Mockito.lenient().when(droolsKieSession.getSessionType()).thenReturn(DroolsSessionType.STATEFUL);

		// execute and check
		Assertions.assertThatThrownBy(() -> kieSessionHelper.initializeStatelessKieSessionInternal(context, ruleEngineContext, kieContainer))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void testInitializeKieSessionInternalOk()
	{
		// given
		Mockito.lenient().when(droolsKieSession.getSessionType()).thenReturn(DroolsSessionType.STATEFUL);

		// execute
		final Object session = kieSessionHelper.initializeKieSessionInternal(context, ruleEngineContext, kieContainer);

		// verify
		assertThat(session).isInstanceOf(KieSession.class);
		verify(kieContainerSessionsPool).newKieSession();
	}

	@Test
	public void testInitializeStatelessKieSessionInternalOk()
	{
		// given
		Mockito.lenient().when(droolsKieSession.getSessionType()).thenReturn(DroolsSessionType.STATELESS);

		// execute and check
		final Object session = kieSessionHelper.initializeStatelessKieSessionInternal(context, ruleEngineContext, kieContainer);

		// verify
		assertThat(session).isInstanceOf(StatelessKieSession.class);
		verify(kieSessionsPool).newStatelessKieSession();
	}

	@Test
	public void testInitializeKieSessionStatefulOk()
	{
		// given
		Mockito.lenient().when(droolsKieSession.getSessionType()).thenReturn(DroolsSessionType.STATEFUL);

		// execute and check
		final Object session = kieSessionHelper.initializeSession(KieSession.class, context, kieContainer);

		// verify
		assertThat(session).isInstanceOf(KieSession.class);
		verify(kieContainerSessionsPool).newKieSession();
	}

	@Test
	public void testInitializeKieSessionStatelessOk()
	{
		// given
		Mockito.lenient().when(droolsKieSession.getSessionType()).thenReturn(DroolsSessionType.STATELESS);

		// execute and check
		final Object session = kieSessionHelper.initializeSession(StatelessKieSession.class, context, kieContainer);

		// verify
		assertThat(session).isInstanceOf(StatelessKieSession.class);
		verify(kieSessionsPool).newStatelessKieSession();
	}

}
