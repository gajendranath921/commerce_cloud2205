/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.dataexport.generic.impl;

import de.hybris.platform.acceleratorservices.dataexport.generic.UploadDataProcessorService;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.CronJobDao;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.messaging.support.GenericMessage;


/**
 * Default implementation of {@link UploadDataProcessorService}.
 */
public class DefaultUploadDataProcessorService implements UploadDataProcessorService
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultUploadDataProcessorService.class);
	private CronJobDao cronJobDao;

	protected CronJobDao getCronJobDao()
	{
		return cronJobDao;
	}

	public void setCronJobDao(final CronJobDao cronJobDao)
	{
		this.cronJobDao = cronJobDao;
	}

	@Override
	public Message<List<File>> findFiles(final Message<?> message, @Header(value = "filenameRegex") final String filenameRegex,
			@Header(value = "directory") final String directory)
	{
		final File directoryPath = new File(directory);
		if (directoryPath.exists())
		{
			List<File> detectedFiles = new ArrayList<>();
			final File[] files = directoryPath.listFiles(new PatternFilenameFilter(filenameRegex));
			if(files != null)
			{
				detectedFiles = Arrays.asList(files);
			}
			LOG.info("Found {} Files in directory", detectedFiles.size());
			return new GenericMessage<>(detectedFiles);
		}
		LOG.info("No files found");
		return new GenericMessage<>(new ArrayList<>());
	}

	@Override
	public CronJobModel getUploadCronJob(final Message<File> message)
	{
		final File payload = message.getPayload();
		final String filename = payload.getName();
		final String[] filenameParts = filename.split("-");
		if (filenameParts.length > 1)
		{
			final String cronJobCode = filenameParts[0];
			final List<CronJobModel> cronJobModels = cronJobDao.findCronJobs(cronJobCode);
			if (!cronJobModels.isEmpty())
			{
				return cronJobModels.get(0);
			}
			LOG.warn("Did not find config for file: {}", filename);
		}
		return null;
	}

	@Override
	public File handlerError(final ErrorMessage message)
	{
		LOG.info("Error with file: {}", message.getPayload().getMessage());
		final Throwable payload = message.getPayload();
		if (payload instanceof MessagingException)
		{
			final MessagingException messagingException = (MessagingException) payload;
			final Message<?> failedMessage = messagingException.getFailedMessage();
			if(failedMessage == null) {
				LOG.info("failedMessage is null for MessagingException", messagingException);
				return null;
			}
			final Object failedMessagePayload = failedMessage.getPayload();
			if (failedMessagePayload instanceof File)
			{
				LOG.info("Moving {} to error folder", ((File) failedMessagePayload).getName());
				return (File) failedMessagePayload;
			}
		}
		return null;
	}

	public static class PatternFilenameFilter implements FilenameFilter
	{
		private final Pattern pattern;

		public PatternFilenameFilter(final String patternStr)
		{
			pattern = Pattern.compile(patternStr);
		}

		protected Pattern getPattern()
		{
			return pattern;
		}

		@Override
		public boolean accept(final File dir, final String fileName)
		{
			return getPattern().matcher(fileName).matches();
		}
	}
}
