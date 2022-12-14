/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.licence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import de.hybris.platform.jdbcwrapper.HybrisDataSource;
import de.hybris.platform.licence.internal.HybrisLicenceDAO;
import de.hybris.platform.licence.internal.HybrisLicenceValidator;
import de.hybris.platform.licence.internal.ValidationResult;

import java.util.Date;
import java.util.Properties;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HybrisLicenceValidatorTest
{
	public static final String TENANT_PREFIX = "junit_";
	private HybrisLicenceValidator validator;
	@Mock
	private Licence licence;
	@Mock
	private HybrisLicenceDAO hybrisLicenceDAO;
	@Mock
	private HybrisDataSource dataSource;
	@Mock
	private Properties properties;

	@Before
	public void setUp() throws Exception
	{
		Mockito.lenient().when(Boolean.valueOf(licence.isDemoOrDevelopLicence())).thenReturn(Boolean.TRUE);
		Mockito.lenient().when(dataSource.getTablePrefix()).thenReturn(TENANT_PREFIX);

		setupValidatorInstances();
	}

	private void setupValidatorInstances()
	{
		validator = new HybrisLicenceValidator()
		{
			@Override
			protected HybrisLicenceDAO getHybrisLicenceDAO()
			{
				return hybrisLicenceDAO;
			}
		};
	}

	@Test
	public void licenceShouldNotBeValidWhenItIsNull() throws Exception
	{
		// given
		final Licence licence = null;

		// when
		final ValidationResult result = validator.checkLicence(licence);

		// then
		assertThat(result.isValid()).isFalse();
	}

	@Test
	public void licenceShouldNotBeValidWhenSignatureIsWrong() throws Exception
	{
		// given
		Mockito.lenient().when(licence.getSignature()).thenReturn("not-valid".getBytes());
		Mockito.lenient().when(licence.getLicenceProperties()).thenReturn(properties);

		// when
		final ValidationResult result = validator.checkLicence(licence);

		// then
		assertThat(result.isValid()).isFalse();
	}

	@Test
	public void licenceShouldNotBeValidWhenItIsExpired() throws Exception
	{
		// given
		Mockito.lenient().when(licence.getSignature()).thenReturn("not-valid".getBytes());
		Mockito.lenient().when(licence.getLicenceProperties()).thenReturn(properties);

		// when
		final ValidationResult result = validator.checkLicence(licence);

		// then
		assertThat(result.isValid()).isFalse();
	}

	@Test
	public void licenseShouldNotBeExpiredIfCurrentDateIsBeforeExpirationDate() throws Exception
	{
		// given
		final Date date = DateTime.now().minusDays(10).toDate();
		given(hybrisLicenceDAO.getStartingPointDateForPlatformInstance(dataSource)).willReturn(date);

		// when
		final boolean expired = validator.isLicenceExpiredIfDemoLicence(licence, dataSource);

		// then
		assertThat(expired).isFalse();
	}

	@Test
	public void licenseShouldNotBeExpiredIfCurrentDateIsThirtyDaysAfterStartingPoint() throws Exception
	{
		// given
		final Date date = DateTime.now().minusDays(30).toDate();
		given(hybrisLicenceDAO.getStartingPointDateForPlatformInstance(dataSource)).willReturn(date);

		// when
		final boolean expired = validator.isLicenceExpiredIfDemoLicence(licence, dataSource);

		// then
		assertThat(expired).isFalse();
	}

	@Test
	public void licenseShouldBeExpiredIfCurrentDateIsMoreThanThirtyDaysAfterStartingPoint() throws Exception
	{
		// given
		final Date date = DateTime.now().minusDays(31).toDate();
		given(hybrisLicenceDAO.getStartingPointDateForPlatformInstance(dataSource)).willReturn(date);

		// when
		final boolean expired = validator.isLicenceExpiredIfDemoLicence(licence, dataSource);

		// then
		assertThat(expired).isTrue();
	}

	@Test
	public void shouldReturnMinusOneDayLeftIfStartingPointDateIs31DaysBackFromNow() throws Exception
	{
		// given
		final Date date = DateTime.now().minusDays(31).toDate();
		given(hybrisLicenceDAO.getStartingPointDateForPlatformInstance(dataSource)).willReturn(date);

		// when
		final Integer daysLeft = validator.getDaysLeft(licence, dataSource);

		// then
		assertThat(daysLeft).isNotNull().isEqualTo(-1);
	}

	@Test
	public void shouldReturnZeroDaysLeftIfStartingPointDateIs30DaysBackFromNow() throws Exception
	{
		// given
		final Date date = DateTime.now().minusDays(30).toDate();
		given(hybrisLicenceDAO.getStartingPointDateForPlatformInstance(dataSource)).willReturn(date);

		// when
		final Integer daysLeft = validator.getDaysLeft(licence, dataSource);

		// then
		assertThat(daysLeft).isNotNull().isEqualTo(0);
	}

	@Test
	public void shouldReturnOneDayLeftIfStartingPointDateIs29DaysBackFromNow() throws Exception
	{
		// given
		final Date date = DateTime.now().minusDays(29).toDate();
		given(hybrisLicenceDAO.getStartingPointDateForPlatformInstance(dataSource)).willReturn(date);

		// when
		final Integer daysLeft = validator.getDaysLeft(licence, dataSource);

		// then
		assertThat(daysLeft).isNotNull().isEqualTo(1);
	}

	@Test
	public void shouldReturn30DaysLeftIfStartingPointDateIsNow() throws Exception
	{
		// given
		final Date date = DateTime.now().toDate();
		given(hybrisLicenceDAO.getStartingPointDateForPlatformInstance(dataSource)).willReturn(date);

		// when
		final Integer daysLeft = validator.getDaysLeft(licence, dataSource);

		// then
		assertThat(daysLeft).isNotNull().isEqualTo(30);
	}

	@Test
	public void shouldReturnNullAsDaysLeftIfPassedLicenceIsNotDemoOrDevelop() throws Exception
	{
		// given
		given(Boolean.valueOf(licence.isDemoOrDevelopLicence())).willReturn(Boolean.FALSE);

		// when
		final Integer daysLeft = validator.getDaysLeft(licence, dataSource);

		// then
		assertThat(daysLeft).isNull();
	}
}
