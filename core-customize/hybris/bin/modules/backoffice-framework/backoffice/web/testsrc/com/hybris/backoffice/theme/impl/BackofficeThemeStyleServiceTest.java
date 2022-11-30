 /*
  * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
  */
 package com.hybris.backoffice.theme.impl;

 import com.hybris.backoffice.model.ThemeModel;
 import com.hybris.backoffice.widgets.branding.customthemes.themes.Util;

 import de.hybris.platform.core.model.media.MediaModel;

 import java.util.HashMap;
 import java.util.Map;

 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.mockito.InjectMocks;
 import org.mockito.Mock;
 import org.mockito.Spy;
 import org.mockito.junit.MockitoJUnitRunner;

 import static org.assertj.core.api.Assertions.assertThat;
 import static org.mockito.Mockito.verify;
 import static org.mockito.Mockito.when;


 @RunWith(MockitoJUnitRunner.class)
 public class BackofficeThemeStyleServiceTest
 {
	 @Mock
	 private DefaultBackofficeThemeService defaultBackofficeThemeService;
	 @Mock
	 private ThemeModel theme;
	 @Mock
	 private MediaModel themeStyle;
	 @Mock
	 private ThemeModel defaultTheme;
	 @Mock
	 private MediaModel defaultThemeStyle;
	 @Mock
	 private Util customThemeUtil;

	 @Spy
	 @InjectMocks
	 private BackofficeThemeStyleService themeService;

	 @Test
	 public void getCurrentThemeStyleShouldGetDefaultWhenNoStyle()
	 {
		 //given
		 when(defaultBackofficeThemeService.getCurrentTheme()).thenReturn(theme);
		 when(defaultBackofficeThemeService.getDefaultTheme()).thenReturn(defaultTheme);
		 when(theme.getStyle()).thenReturn(null);
		 when(defaultTheme.getStyle()).thenReturn(defaultThemeStyle);
		 when(defaultThemeStyle.getURL()).thenReturn("defaulturl");

		 //then
		 assertThat(themeService.getCurrentThemeStyle()).isEqualTo("defaulturl");
	 }

	 @Test
	 public void getCurrentThemeStyleShouldSuccess()
	 {
		 //given
		 when(defaultBackofficeThemeService.getCurrentTheme()).thenReturn(theme);
		 when(theme.getStyle()).thenReturn(themeStyle);
		 when(themeStyle.getURL()).thenReturn("url");

		 //then
		 assertThat(themeService.getCurrentThemeStyle()).isEqualTo("url");
	 }

	 @Test
	 public void shouldGetCurrentThemeId()
	 {
		 //given
		 when(defaultBackofficeThemeService.getCurrentTheme()).thenReturn(theme);
		 when(theme.getCode()).thenReturn("theme1");

		 //then
		 assertThat(themeService.getCurrentThemeId()).isEqualTo("theme1");
	 }

	 @Test
	 public void shouldReturnCurrentThemeStyleMapSuccess()
	 {
		 //given
		 final Map<String, String> currentStyleMap = new HashMap<>();
		 when(defaultBackofficeThemeService.getCurrentTheme()).thenReturn(theme);
		 when(theme.getStyle()).thenReturn(themeStyle);
		 when(customThemeUtil.convertStyleMediaToVariableMap(themeStyle)).thenReturn(currentStyleMap);

		 //when
		 themeService.getCurrentThemeStyleMap();

		 //then
		 verify(customThemeUtil).convertStyleMediaToVariableMap(themeStyle);
	 }
 }

