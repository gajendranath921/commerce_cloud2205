/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.util.localization.jdbc.rx.subscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.util.localization.jdbc.LocalizableRow;
import de.hybris.platform.util.localization.jdbc.LocalizableRowsQuery;
import de.hybris.platform.util.localization.jdbc.StatementWithParams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.google.common.collect.Lists;

import rx.Observable;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class LocalizableRowsSubscriptionUnitTest
{
	private static final String SQL_QUERY = "testQuery";
	private final LocalizableRow testRow1 = testRow(1);
	private final LocalizableRow testRow2 = testRow(2);
	@Mock
	private DataSource dataSource;
	@Mock
	private ExecutorService executorService;
	@Mock
	private LocalizableRowsQuery<LocalizableRow> localizableRowsQuery;
	@Mock
	private Connection connection;
	@Mock
	private PreparedStatement statement;
	@Mock
	private ResultSet resultSet;
	@Mock
	private LocalizableRowsQuery<LocalizableRow> queryWithException;

	@Before
	public void setUp() throws SQLException
	{
		when(dataSource.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(SQL_QUERY)).thenReturn(statement);
		when(statement.executeQuery()).thenReturn(resultSet);

		doAnswer((Answer<Void>) invocation -> {
			final Runnable runnable = (Runnable) invocation.getArguments()[0];
			runnable.run();
			return null;
		}).when(executorService).execute(notNull());

		when(localizableRowsQuery.getQuery()).thenReturn(new StatementWithParams(SQL_QUERY));

		when(resultSet.next()).thenReturn(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);

		when(localizableRowsQuery.mapResultSetToRow(resultSet)).thenReturn(testRow1, testRow2);
	}

	@Test
	public void shouldReturnLocalizableRowForEachDbRowInResultSet()
	{
		//given
		final LocalizableRowsSubscription<LocalizableRow> subscription = new LocalizableRowsSubscription<>(dataSource,
				executorService,
				localizableRowsQuery);

		//when
		final Iterable<LocalizableRow> localizableRows = completeSubscription(subscription);

		//then
		assertThat(localizableRows).isNotNull().containsOnly(testRow1, testRow2);
	}

	@Test
	public void shouldPropagateExceptionFromQueryExecutionToSubscriber()
	{
		final Throwable expectedException = new RuntimeException("Expected exception");

		doThrow(expectedException).when(executorService).execute(notNull());

		final LocalizableRowsSubscription<LocalizableRow> subscription = new LocalizableRowsSubscription<>(dataSource,
				executorService,
				queryWithException);

		try
		{
			completeSubscription(subscription);
		}
		catch (final Exception exception)
		{
			assertThat(exception).isEqualTo(expectedException);
			return;
		}
		fail("Exception should be propagated.");
	}

	@Test
	public void shouldPropagateExceptionFromResultSetProcessingToSubscriber() throws SQLException
	{
		final Throwable expectedException = new RuntimeException("Expected exception");

		final LocalizableRowsQuery<LocalizableRow> queryWithException = mock(LocalizableRowsQuery.class);
		when(queryWithException.getQuery()).thenReturn(new StatementWithParams(SQL_QUERY));
		when(queryWithException.mapResultSetToRow(resultSet)).thenThrow(expectedException);

		final LocalizableRowsSubscription<LocalizableRow> subscription = new LocalizableRowsSubscription<>(dataSource,
				executorService,
				queryWithException);

		try
		{
			completeSubscription(subscription);
		}
		catch (final Exception exception)
		{
			assertThat(exception).isEqualTo(expectedException);
			return;
		}
		fail("Exception should be propagated");
	}

	@Test
	public void shouldUseExecutorToExecuteQuery()
	{
		//given
		final LocalizableRowsSubscription<LocalizableRow> subscription = new LocalizableRowsSubscription<>(dataSource,
				executorService,
				localizableRowsQuery);

		//when
		completeSubscription(subscription);

		//then
		verify(executorService).execute(notNull());
	}

	@Test
	public void shouldUseLocalizableRowsQueryToObtainQueryStatement()
	{
		//given
		final LocalizableRowsSubscription<LocalizableRow> subscription = new LocalizableRowsSubscription<>(dataSource,
				executorService,
				localizableRowsQuery);

		//when
		completeSubscription(subscription);

		//then
		verify(localizableRowsQuery).getQuery();
	}

	@Test
	public void shouldUseLocalizableRowsQueryToMapResultSetToLocalizableRow() throws SQLException
	{
		//given
		final LocalizableRowsSubscription<LocalizableRow> subscription = new LocalizableRowsSubscription<>(dataSource,
				executorService,
				localizableRowsQuery);

		//when
		completeSubscription(subscription);

		//then
		verify(localizableRowsQuery, times(2)).mapResultSetToRow(resultSet);
	}

	private Iterable<LocalizableRow> completeSubscription(final LocalizableRowsSubscription<LocalizableRow> subscription)
	{
		return Lists.newArrayList(Observable.create(subscription).toBlocking().toIterable());
	}

	private LocalizableRow testRow(final long rowPKValue)
	{
		return new LocalizableRow("TEST_TABLE", rowPKValue, 123L, null);
	}
}
