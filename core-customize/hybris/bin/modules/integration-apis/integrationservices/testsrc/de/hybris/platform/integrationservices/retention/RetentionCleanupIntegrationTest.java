/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationservices.retention;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.impex.jalo.ImpExException;
import de.hybris.platform.integrationservices.model.IntegrationApiMediaModel;
import de.hybris.platform.integrationservices.util.IntegrationTestUtil;
import de.hybris.platform.integrationservices.util.Log;
import de.hybris.platform.integrationservices.util.impex.IntegrationServicesEssentialData;
import de.hybris.platform.integrationservices.util.impex.ModuleEssentialData;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.cronjob.CronJobService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;

import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;

@IntegrationTest
public class RetentionCleanupIntegrationTest extends ServicelayerTest
{
	private static final String TEST_NAME = "RetentionCleanup";
	private static final String MEDIA_CODE = TEST_NAME + "_integrationApiMedia";
	private static final Logger LOG = Log.getLogger(RetentionCleanupIntegrationTest.class);
	private static final String INTEGRATION_API_MEDIA_CLEANUP_CRON_JOB_NAME = "integrationApiMediaCleanupCronJob";
	private static final int DAYS_PAST_RETENTION_PERIOD = 8;

	@ClassRule
	public static ModuleEssentialData essentialData = IntegrationServicesEssentialData.integrationServicesEssentialData();

	@Resource
	private CronJobService cronJobService;

	@Test
	public void testCleanupRuleCleansUpIntegrationApiMediaOlderThanRetentionPeriod() throws ImpExException
	{
		final LocalDateTime oneWeekAgo = LocalDateTime.now().minusDays(DAYS_PAST_RETENTION_PERIOD);
		final var oneWeekAgoString = oneWeekAgo.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
		IntegrationTestUtil.importImpEx(
				"$mediaCode=" + MEDIA_CODE,
				"INSERT_UPDATE IntegrationApiMedia; code[unique=true]; creationtime[dateformat=dd.MM.yyyy HH:mm]",
				"                                 ; $mediaCode       ; " + oneWeekAgoString
		);
		assertThat(createdIntegrationApiMedia()).isNotNull();

		executeMediaCleanupCronJob();

		assertThat(createdIntegrationApiMedia()).isNull();
	}

	private void executeMediaCleanupCronJob()
	{
		final CronJobModel cronJob = cronJobService.getCronJob(INTEGRATION_API_MEDIA_CLEANUP_CRON_JOB_NAME);
		LOG.info("Performing cronJob {} synchronously", cronJob.getCode());
		cronJobService.performCronJob(cronJob, true);
		LOG.info("CronJob completed with status {}", cronJob.getStatus());
	}

	private IntegrationApiMediaModel createdIntegrationApiMedia()
	{
		final IntegrationApiMediaModel mediaModel = IntegrationTestUtil.findAny(IntegrationApiMediaModel.class,
				m -> MEDIA_CODE.equals(m.getCode())).orElse(null);
		if (mediaModel == null)
		{
			LOG.info("Did not find media with code {}", MEDIA_CODE);
		}
		else
		{
			LOG.info("Found media with code {} created at {}", MEDIA_CODE, mediaModel.getCreationtime().toInstant());
		}
		return mediaModel;
	}
}
