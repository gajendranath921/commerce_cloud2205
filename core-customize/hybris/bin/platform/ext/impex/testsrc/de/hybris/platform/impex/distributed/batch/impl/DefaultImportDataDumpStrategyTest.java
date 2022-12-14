/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.impex.distributed.batch.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.impex.distributed.batch.ImportDataDumpStrategy;
import de.hybris.platform.impex.jalo.header.HeaderDescriptor;
import de.hybris.platform.impex.jalo.imp.ValueLine;
import de.hybris.platform.util.CSVWriter;

import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultImportDataDumpStrategyTest
{
	private ImportDataDumpStrategy strategy;
	@Mock
	private ValueLine valueLine1, valueLine2, valueLine3;
	@Mock
	private HeaderDescriptor header1, header2, header3;
	@Mock
	private BatchData batchData1, batchData2, batchData3;
	private BatchData.ImportData importData1, importData2, importData3;

	@Before
	public void setUp() throws Exception
	{
		strategy = new DefaultImportDataDumpStrategy()
		{
			@Override
			CSVWriter getCsvWriter(final StringWriter writer)
			{
				return new CSVWriter(writer)
				{

					@Override
					protected char getDefaultFieldSeparator()
					{
						return ';';
					}

					@Override
					protected char getDefaultTextSeparator()
					{
						return '"';
					}

					@Override
					protected String getDefaultLineBreak()
					{
						return "\n";
					}

					@Override
					protected String[] getDefaultLineSeparators()
					{
						return new String[]
								{ "\n" };
					}
				};
			}
		};
		Mockito.lenient().when(header1.dump()).thenReturn(getDumpLine("code", "name[lang=en]", "name[lang=de]"));
		Mockito.lenient().when(header2.dump()).thenReturn(getDumpLine("code", "name[lang=en]", "name[lang=de]"));
		Mockito.lenient().when(header3.dump()).thenReturn(getDumpLine("code", "name[lang=en]", "name[lang=de]"));

		given(valueLine1.dump()).willReturn(getDumpLine("foo1", "bar1", "baz1"));
		given(valueLine2.dump()).willReturn(getDumpLine("foo2", "bar2", "baz2"));
		given(valueLine3.dump()).willReturn(getDumpLine("foo3", "bar3", "baz3"));

		Mockito.lenient().when(valueLine1.getHeader()).thenReturn(header1);
		Mockito.lenient().when(valueLine2.getHeader()).thenReturn(header2);
		Mockito.lenient().when(valueLine3.getHeader()).thenReturn(header3);

		importData1 = new BatchData.ImportData(batchData1, valueLine1, Collections.emptySet(), Collections.emptySortedMap(),
				Collections.emptyMap());
		importData2 = new BatchData.ImportData(batchData2, valueLine2, Collections.emptySet(), Collections.emptySortedMap(),
				Collections.emptyMap());
		importData3 = new BatchData.ImportData(batchData3, valueLine3, Collections.emptySet(), Collections.emptySortedMap(),
				Collections.emptyMap());
	}

	private Map<Integer, String> getDumpLine(final String... values)
	{
		final ImmutableMap.Builder<Integer, String> builder = ImmutableMap.<Integer, String>builder();
		int idx = 1;
		for (final String value : values)
		{
			builder.put(Integer.valueOf(idx), value);
			idx++;
		}
		return builder.build();
	}

	@Test
	public void shouldDumpToString() throws Exception
	{
		// given
		final List<BatchData.ImportData> importDatas = Lists.newArrayList(importData1, importData2, importData3);

		// when
		final String dump = strategy
				.dump(importDatas.stream().map(BatchData.ImportData::getValueLine).collect(Collectors.toList()));

		// then
		assertThat(dump)
				.isEqualTo(";foo1;bar1;baz1\n" + ";foo2;bar2;baz2\n" + ";foo3;bar3;baz3\n");
	}
}
