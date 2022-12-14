/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.hybris.yprofile.consent.filters;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hybris.yprofile.consent.services.ConsentService;
import com.hybris.yprofile.constants.ProfileservicesConstants;
import com.hybris.yprofile.services.ProfileConfigurationService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@UnitTest
public class ConsentLayerFilterTest {

    private static final String REQUESTEDURL = "http://mySite.profile.com";
    private static final String SERVLET_PATH = "/c/584";
    private static final String EXCLUDEDURL_PATTERN = "*asm=true*";

    private ConsentLayerFilter consentLayerFilter;

    @Mock
    private ProfileConfigurationService profileConfigurationService;

    @Mock
    private ConsentService consentService;

    @Mock
    private SessionService sessionService;

    @Mock
    private UserService userService;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private FilterChain filterChain;

    @Mock
    private Cookie cookie;

    @Mock
    private UserModel userModel;

    private AutoCloseable closeable;


    @Before
    public void setUp() throws Exception {

        closeable = MockitoAnnotations.openMocks(this);
        consentLayerFilter = new ConsentLayerFilter();
        consentLayerFilter.setProfileConfigurationService(profileConfigurationService);
        consentLayerFilter.setConsentService(consentService);
        consentLayerFilter.setEnabled(false);
        consentLayerFilter.setExcludeUrlPatterns(EXCLUDEDURL_PATTERN);
        consentLayerFilter.setSessionService(sessionService);
        consentLayerFilter.setUserService(userService);

        final StringBuffer requestUrlSb = new StringBuffer();
        requestUrlSb.append(REQUESTEDURL);
        when(httpServletRequest.getRequestURL()).thenReturn(requestUrlSb);
        when(httpServletRequest.getRequestURI()).thenReturn(requestUrlSb.toString());
        when(httpServletRequest.getServletPath()).thenReturn(SERVLET_PATH);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void shouldStopProcessingIfFilterWasAlreadyInvoked() throws ServletException, IOException {

        when(httpServletRequest.getAttribute(anyString())).thenReturn(Boolean.TRUE);

        consentLayerFilter.doFilterInternal(httpServletRequest,httpServletResponse, filterChain);

        verify(profileConfigurationService, never()).setProfileTrackingPauseValue(anyBoolean());
        verify(consentService, never()).saveConsentReferenceInSessionAndConsentModel(any(HttpServletRequest.class));
        verify(consentService, never()).removeConsentReferenceInSession();
        verify(consentService, never()).setProfileConsentCookieAndSession(any(HttpServletRequest.class), any(HttpServletResponse.class), anyBoolean());
        verify(consentService, never()).setProfileIdCookie(any(HttpServletRequest.class),any(HttpServletResponse.class),anyString());
    }

    @Test
    public void shouldNotTrackWhenProfileTrackingPaused() throws ServletException, IOException {

        when(cookie.getName()).thenReturn(ProfileservicesConstants.PROFILE_TRACKING_PAUSE);
        when(httpServletRequest.getCookies()).thenReturn(new Cookie[]{cookie});

        consentLayerFilter.doFilterInternal(httpServletRequest,httpServletResponse, filterChain);

        verify(profileConfigurationService, times(1)).setProfileTrackingPauseValue(anyBoolean());
        verify(consentService, never()).saveConsentReferenceInSessionAndConsentModel(any(HttpServletRequest.class));
        verify(consentService, never()).removeConsentReferenceInSession();
        verify(consentService, never()).setProfileConsentCookieAndSession(any(HttpServletRequest.class), any(HttpServletResponse.class), anyBoolean());
        verify(consentService, never()).setProfileIdCookie(any(HttpServletRequest.class),any(HttpServletResponse.class),anyString());
    }


    @Test
    public void shouldTrackWhenProfileTrackingConsentIsGiven() throws ServletException, IOException {

        when(consentService.isProfileTrackingConsentGiven(httpServletRequest)).thenReturn(true);
        when(userService.getCurrentUser()).thenReturn(userModel);
        when(userModel.getDeactivationDate()).thenReturn(null);

        consentLayerFilter.doFilterInternal(httpServletRequest,httpServletResponse, filterChain);

        verify(profileConfigurationService, times(1)).setProfileTrackingPauseValue(anyBoolean());
        verify(consentService, times(1)).setProfileConsentCookieAndSession(any(HttpServletRequest.class), any(HttpServletResponse.class), anyBoolean());
        verify(consentService, times(1)).saveConsentReferenceInSessionAndConsentModel(any(HttpServletRequest.class));
        // since the consent reference is null in the user model, we dont set the cookie
        verify(consentService, never()).setProfileIdCookie(any(HttpServletRequest.class),any(HttpServletResponse.class),anyString());
        verify(consentService, times(1)).setProfileConsentCookieAndSession(any(HttpServletRequest.class), any(HttpServletResponse.class), anyBoolean());
    }


    @Test
    public void shouldNotTrackWhenProfileTrackingConsentIsWithdrawnAndRemoveCookie() throws ServletException, IOException {

        when(consentService.isProfileTrackingConsentGiven(httpServletRequest)).thenReturn(false);

        consentLayerFilter.doFilterInternal(httpServletRequest,httpServletResponse, filterChain);

        verify(profileConfigurationService, times(1)).setProfileTrackingPauseValue(anyBoolean());
        verify(consentService, times(1)).setProfileConsentCookieAndSession(any(HttpServletRequest.class), any(HttpServletResponse.class), anyBoolean());
        verify(consentService, never()).saveConsentReferenceInSessionAndConsentModel(any(HttpServletRequest.class));
        verify(consentService, times(1)).removeConsentReferenceInSession();
        verify(consentService, never()).setProfileIdCookie(any(HttpServletRequest.class),any(HttpServletResponse.class),anyString());
        verify(consentService, times(1)).setProfileConsentCookieAndSession(any(HttpServletRequest.class), any(HttpServletResponse.class), anyBoolean());
    }

    @Test
    public void shouldNotTrackWhenAccountIsDeactivated() throws ServletException, IOException {

        when(consentService.isProfileTrackingConsentGiven(httpServletRequest)).thenReturn(true);
        when(userService.getCurrentUser()).thenReturn(userModel);
        when(userModel.getDeactivationDate()).thenReturn(mock(Date.class));

        consentLayerFilter.doFilterInternal(httpServletRequest,httpServletResponse, filterChain);

        verify(profileConfigurationService, times(1)).setProfileTrackingPauseValue(anyBoolean());
        verify(consentService, times(1)).setProfileConsentCookieAndSession(any(HttpServletRequest.class), any(HttpServletResponse.class), anyBoolean());
        verify(consentService, never()).saveConsentReferenceInSessionAndConsentModel(any(HttpServletRequest.class));
        verify(consentService, times(1)).removeConsentReferenceInSession();
        verify(consentService, never()).setProfileIdCookie(any(HttpServletRequest.class),any(HttpServletResponse.class), anyString());
        verify(consentService, times(1)).setProfileConsentCookieAndSession(any(HttpServletRequest.class), any(HttpServletResponse.class), anyBoolean());
    }

    @Test
    public void shouldSetProfileIdCookieWhenLoginIsSuccessful() throws ServletException, IOException{
        // given
        final String consentReferenceId = "7bdc6562-abf6-4dbb-8267-c20232bdadf5";
        when(consentService.isProfileTrackingConsentGiven(httpServletRequest)).thenReturn(true);
        when(userService.getCurrentUser()).thenReturn(userModel);
        when(consentService.getConsentReferenceFromConsentModel()).thenReturn(consentReferenceId);
        // when
        consentLayerFilter.doFilterInternal(httpServletRequest,httpServletResponse, filterChain);
        // verify
        verify(consentService, times(1)).setProfileIdCookie(any(HttpServletRequest.class),any(HttpServletResponse.class), eq(consentReferenceId));
    }

    @Test
    public void shouldNotRunFilterLogicWhenRequestIsNull() {
        // when
        consentLayerFilter.runFilterLogic(null);
        // then
        verify(profileConfigurationService, never()).setProfileTrackingPauseValue(anyBoolean());
        verify(consentService, never()).isProfileTrackingConsentGiven(any(HttpServletRequest.class));
        verify(consentService, never()).saveConsentReferenceInSessionAndConsentModel(any(HttpServletRequest.class));
        verify(consentService, never()).removeConsentReferenceInSession();
    }

}
