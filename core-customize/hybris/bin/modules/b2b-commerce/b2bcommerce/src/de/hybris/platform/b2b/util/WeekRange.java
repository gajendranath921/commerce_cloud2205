/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.util;

import java.util.Calendar;

/**
 * The Class B2BWeekRange.
 * 
 * 
 */
public class WeekRange implements TimeRange
{
	/**
	 * @see TimeRange#getEndOfRange(Calendar)
	 */
	public Calendar getEndOfRange(final Calendar calendar)
	{
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.HOUR, 11);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.AM_PM, Calendar.PM);
		calendar.setTimeInMillis(getLastDayOfWeek(calendar).getTimeInMillis());
		return calendar;
	}

	/**
	 * @see TimeRange#getStartOfRange(Calendar)
	 */
	public Calendar getStartOfRange(final Calendar calendar)
	{
		final Integer days = Integer.valueOf((calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek()));
		calendar.add(Calendar.DAY_OF_MONTH, -days.intValue());
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		return calendar;
	}

	/**
	 * Gets the last day of week as Calendar object.
	 * 
	 * @param cal
	 *           the cal
	 * @return the last day of week
	 */
	protected Calendar getLastDayOfWeek(final Calendar cal)
	{
		cal.add(Calendar.DAY_OF_YEAR, 8 - cal.get(Calendar.DAY_OF_WEEK));
		return cal;
	}
}
