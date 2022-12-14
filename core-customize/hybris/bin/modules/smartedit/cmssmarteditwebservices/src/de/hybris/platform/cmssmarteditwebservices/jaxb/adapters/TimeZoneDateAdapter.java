/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.jaxb.adapters;

import java.text.ParseException;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * DateAdapter is used by JAXB to convert Dates to String and vice versa using the UTC Time Zone.
 */
public class TimeZoneDateAdapter extends XmlAdapter<String, Date>
{
	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

	private static final String DATE_TIME_ZONE_ID = "UTC";

	private static final DateTimeZone DATE_TIME_ZONE = DateTimeZone.forID(DATE_TIME_ZONE_ID);

	private static final DateTimeFormatter dateFormat = DateTimeFormat.forPattern(DATE_FORMAT).withZone(DATE_TIME_ZONE);

	@Override
	public String marshal(final Date d)
	{
		if (d == null)
		{
			return null;
		}
		return dateFormat.print(d.getTime());
	}

	@Override
	public Date unmarshal(final String d) throws ParseException
	{
		if (d == null)
		{
			return null;
		}
		return dateFormat.parseDateTime(d).toDate();
	}
}
