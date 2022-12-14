/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.media.validator;

import de.hybris.platform.cmsfacades.constants.CmsfacadesConstants;
import de.hybris.platform.cmsfacades.dto.MediaFileDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Validates DTO for creating a new media.
 *
 * <p>
 * Rules:</br>
 * <ul>
 * <li>file not null</li>
 * <li>fileType is not supported</li>
 * </ul>
 * </p>
 */
public class CreateMediaFileValidator implements Validator
{
	protected static final String INPUT_STREAM = "inputStream";
	protected static final String MIME = "mime";

	private Predicate<String> validFileTypePredicate;

	@Override
	public boolean supports(final Class<?> clazz)
	{
		return MediaFileDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors)
	{
		final MediaFileDto target = (MediaFileDto) obj;

		ValidationUtils.rejectIfEmpty(errors, INPUT_STREAM, CmsfacadesConstants.FIELD_REQUIRED);

		if (!Objects.isNull(target.getInputStream()))
		{
			try
			{
				/*
				 * this should throws an IOException if the InputStream is closed; but it depends on the InputStream
				 * subclass implementation!
				 */
				final InputStream inputStream = target.getInputStream();
				inputStream.available();
			}
			catch (final IOException e)
			{
				errors.rejectValue(INPUT_STREAM, CmsfacadesConstants.MEDIA_INPUT_STREAM_CLOSED);
			}
		}

		if (!Objects.isNull(target.getMime()) && !getValidFileTypePredicate().test(target.getMime()))
		{
			errors.rejectValue(MIME, CmsfacadesConstants.FIELD_FORMAT_INVALID);
		}

	}

	protected Predicate<String> getValidFileTypePredicate()
	{
		return validFileTypePredicate;
	}

	@Required
	public void setValidFileTypePredicate(final Predicate<String> validFileTypePredicate)
	{
		this.validFileTypePredicate = validFileTypePredicate;
	}

}
