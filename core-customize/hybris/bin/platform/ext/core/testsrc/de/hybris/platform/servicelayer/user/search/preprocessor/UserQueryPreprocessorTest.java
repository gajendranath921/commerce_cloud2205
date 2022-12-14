/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.user.search.preprocessor;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.preprocessor.QueryPreprocessor;
import de.hybris.platform.servicelayer.user.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class UserQueryPreprocessorTest
{
	@InjectMocks
	private final QueryPreprocessor preprocessor = new UserQueryPreprocessor();
	@Mock
	private UserService userService;
	@Mock
	private FlexibleSearchQuery query;
	@Mock
	private UserModel user;

	@Test
	public void shouldNotProcessWhenUserInQueryObjectIsNull()
	{
		// given
		given(query.getUser()).willReturn(null);

		// when
		preprocessor.process(query);

		// then
		verify(userService, times(0)).setCurrentUser((UserModel) anyObject());
	}

	@Test
	public void shouldProcessWhenThereIsUserInQueryObject()
	{
		// given
		given(query.getUser()).willReturn(user);

		// when
		preprocessor.process(query);

		// then
		verify(userService, times(1)).setCurrentUser(user);
	}

}
