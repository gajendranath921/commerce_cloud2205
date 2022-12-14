/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.attributeconverters;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class DateAttributeToDataAttributeContentConverterTest
{
	private DateAttributeToDataContentConverter converter = new DateAttributeToDataContentConverter();

	@Test
	public void whenConvertNullValueReturnsNull()
	{
		assertThat(converter.convert(null), nullValue());
	}

	@Test
	public void whenConvertSimpleDateValueReturnsValidStringDateFormat()
	{
		final LocalDateTime localDateTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0);
		final Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
		Date source = Date.from(instant);
		assertThat(converter.convert(source), is("2000-01-01T00:00:00+0000"));
	}
	
	@Test
	public void whenConvertSimpleDateValueReturnsValidStringDateFormatEvenWithDifferentTimeZone()
	{
		final LocalDateTime localDateTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0);
		final Instant instant = localDateTime.toInstant(ZoneOffset.ofHoursMinutes(-4, 0));
		Date source = Date.from(instant);
		assertThat(converter.convert(source), is("2000-01-01T04:00:00+0000"));
	}
}
