/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.masterserver.impl;

import static de.hybris.platform.masterserver.impl.ConcurrentBooleanListAssert.assertThat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.threadregistry.RegistrableThread;
import de.hybris.platform.masterserver.StatisticsPayloadEncryptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.hybris.statistics.collector.BusinessStatisticsCollector;
import com.hybris.statistics.collector.SystemStatisticsCollector;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultStatisticsGatewayTest
{
	private DefaultStatisticsGateway statGateway, statGateway2, statGateway3;
	@Mock
	private BusinessStatisticsCollector businessCollector;
	@Mock
	private SystemStatisticsCollector systemCollector;
	@Mock
	private StatisticsPayloadEncryptor encryptor;
	@Mock
	private StatisticsPayload statisticsPayload;

	private boolean generateStats = false;

	@Before
	public void setUp() throws Exception
	{
		final Set<BusinessStatisticsCollector> businessCollectors = Sets.newHashSet(businessCollector);
		final Set<SystemStatisticsCollector> systemCollectors = Sets.newHashSet(systemCollector);
		final Map<String, String> existingWebModules = new HashMap<>();
		existingWebModules.put("/hac", "hac");
		existingWebModules.put("/productcockpit", "productcockpit");

		statGateway = new DefaultStatisticsGateway(businessCollectors, systemCollectors, existingWebModules, encryptor)
		{
			@Override
			protected boolean isSendingStatsAgreedInLicense()
			{
				return true;
			}

			@Override
			protected boolean isGenerateStatsRequired()
			{
				return generateStats;
			}

			@Override
			protected PK getCurrentUserPk()
			{
				return PK.createFixedUUIDPK(0, RandomUtils.nextLong());
			}
		};

		statGateway2 = new DefaultStatisticsGateway(businessCollectors, systemCollectors, existingWebModules, encryptor)
		{
			@Override
			protected boolean isSendingStatsAgreedInLicense()
			{
				return true;
			}

			@Override
			protected boolean isGenerateStatsRequired()
			{
				return generateStats;
			}

			@Override
			protected PK getCurrentUserPk()
			{
				return null;
			}
		};
		statGateway3 = new DefaultStatisticsGateway(businessCollectors, systemCollectors, existingWebModules, encryptor)
		{
			@Override
			protected boolean isSendingStatsAgreedInLicense()
			{
				return true;
			}

			@Override
			boolean isForceDevelopmentModeFromEnv()
			{
				return true;
			}
		};

	}

	@Test
	public void shouldDontReturnPayloadIfItIsNotATime()
	{
		// given
		generateStats = false;

		// when
		final StatisticsPayload encodedStatistics = statGateway.getStatisticsPayload();

		// then
		assertThat(encodedStatistics).isNull();
	}

	@Test
	public void shouldDontReturnPayloadIfNonOfStatisticCollectorsReturnsDataAndItIsTimeToGenerateData()
	{
		// given
		generateStats = true;
		given(businessCollector.collectStatistics()).willReturn(null);
		given(systemCollector.collectStatistics()).willReturn(null);

		// when
		final StatisticsPayload encodedStatistics1 = statGateway2.getStatisticsPayload();

		// then
		assertThat(encodedStatistics1).isNull();
	}

	@Test
	public void shouldReturnPayloadWhenAtLeastOneOfStatisticCollectorsReturnDataAndItIsTimeToGenerateData()
	{
		// given
		final Map<String, Map<String, Object>> businessStats = new HashMap<>();
		businessStats.put("backOfficeUsers", new HashMap<String, Object>());
		businessStats.get("backOfficeUsers").put("employees", 5);
		businessStats.get("backOfficeUsers").put("customers", 10);

		final Map<String, Map<String, Object>> systemStats = new HashMap<>();
		systemStats.put("cpu", new HashMap<String, Object>());
		systemStats.get("cpu").put("numCPU", 8);

		generateStats = true;
		given(businessCollector.collectStatistics()).willReturn(businessStats);
		given(systemCollector.collectStatistics()).willReturn(systemStats);
		given(
				encryptor.encrypt(
						endsWith("\"system\":{\"cpu\":{\"numCPU\":8}},\"business\":{\"backOfficeUsers\":{\"customers\":10,"
								+ "\"employees\":5}}}"), anyString())).willReturn(statisticsPayload);

		// when
		final StatisticsPayload encodedStatistics1 = statGateway2.getStatisticsPayload();

		// then
		assertThat(encodedStatistics1).isNotNull();
	}

	@Test
	public void shouldUpdateLoggedInBackOfficeUsersConcurrently() throws InterruptedException
	{
		// given
		generateStats = true;
		given(businessCollector.collectStatistics()).willReturn(null);
		given(systemCollector.collectStatistics()).willReturn(null);
		given(encryptor.encrypt(endsWith("\"session\":{\"backOfficeOverallUsers\":{\"hac\":500}}}"), anyString())).willReturn(
				statisticsPayload);
		final CountDownLatch latch = new CountDownLatch(500);

		// when
		for (int i = 0; i < 500; i++)
		{
			new RegistrableThread(new Runnable()
			{

				@Override
				public void run()
				{
					try
					{
						statGateway.updateLoggedInUsersStats("/hac");
					}
					finally
					{
						latch.countDown();
					}
				}
			}).start();
		}
		latch.await();
		final StatisticsPayload encodedStatistics = statGateway.getStatisticsPayload();

		// then
		assertThat(encodedStatistics).isNotNull();
	}

	@Test
	public void shouldAllowToGenerateStatsOnlyForFirstThread() throws Exception
	{
		// given
		final List<Boolean> results = Lists.newCopyOnWriteArrayList();
		final CountDownLatch latch = new CountDownLatch(1000);

		// when
		for (int i = 0; i < 1000; i++)
		{
			new RegistrableThread(new Runnable()
			{

				@Override
				public void run()
				{
					try
					{
						results.add(statGateway3.isGenerateStatsRequired());
					}
					finally
					{
						latch.countDown();
					}
				}
			}).start();
		}
		latch.await();

		// then
		assertThat(results).hasNumberOfTrueElements(1).hasNumberOfFalseElements(999);
	}

}
