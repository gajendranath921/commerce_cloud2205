/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.persistence.flexiblesearch.typecache.impl;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.jalo.JaloItemNotFoundException;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.flexiblesearch.FlexibleSearch;
import de.hybris.platform.jalo.flexiblesearch.FlexibleSearchException;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.persistence.flexiblesearch.typecache.CachedTypeData;
import de.hybris.platform.persistence.property.PersistenceManager;
import de.hybris.platform.persistence.property.TypeInfoMap;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Sets;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class DefaultFlexibleSearchTypeCacheProviderTest
{
	@Mock
	private PersistenceManager persistenceManager;
	@SuppressWarnings("deprecation")
	@Mock
	private FlexibleSearch flexibleSearch;
	@Mock
	private C2LManager c2lManager;
	@Mock
	private TypeInfoMap typeInfoMap;
	@Mock
	private TypeManager typeManager;
	@Mock
	private Language language;


	private DefaultFlexibleSearchTypeCacheProvider fsCache;
	private final PK mainPk = PK.createFixedUUIDPK(1, 2), searchPk = PK.createFixedUUIDPK(3, 4), langPk = PK.createFixedUUIDPK(5,
			6);

	@Before
	public void setUp() throws Exception
	{
		fsCache = new DefaultFlexibleSearchTypeCacheProvider(persistenceManager, typeManager, c2lManager, flexibleSearch);
	}


	@Test
	public void shouldContainsTypePkWhenExternalTypesContainsSearchPk()
	{
		// given
		given(persistenceManager.getTypePK("fooBar")).willReturn(mainPk);
		given(persistenceManager.getExternalTableTypes(mainPk)).willReturn(Sets.newHashSet(searchPk));

		// when
		final boolean containsTypePk = fsCache.getExternalTableTypes("fooBar").contains(searchPk);

		// then
		assertThat(containsTypePk).isTrue();
	}

	@Test
	public void shouldNotContainsTypePkWhenExternalTypesReturnsEmptySet()
	{
		// given
		Mockito.lenient().when(persistenceManager.getPersistenceInfo("fooBar")).thenReturn(typeInfoMap);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		Mockito.lenient().when(persistenceManager.getExternalTableTypes(mainPk)).thenReturn(Collections.EMPTY_SET);

		// when
		final boolean containsTypePk = fsCache.getExternalTableTypes("fooBar").contains(searchPk);

		// then
		assertThat(containsTypePk).isFalse();
	}

	@Test
	public void shouldNotContainsTypePkWhenExternalTypesReturnNull()
	{
		// given
		Mockito.lenient().when(persistenceManager.getPersistenceInfo("fooBar")).thenReturn(typeInfoMap);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		Mockito.lenient().when(persistenceManager.getExternalTableTypes(mainPk)).thenReturn(null);

		// when
		final Set<PK> externalTableTypes = fsCache.getExternalTableTypes("fooBar");

		// then
		assertThat(externalTableTypes).isNotNull();
		assertThat(externalTableTypes).isEmpty();
	}


	@Test
	public void shouldHaveSubtypesWhenExternalTypesReturnsNotEmptySet()
	{
		// given
		given(persistenceManager.getTypePK("fooBar")).willReturn(mainPk);
		given(persistenceManager.getExternalTableTypes(mainPk)).willReturn(Sets.newHashSet(searchPk));

		// when
		final boolean typeHasSubtypes = fsCache.hasExternalTables("fooBar");

		// then
		assertThat(typeHasSubtypes).isTrue();
	}

	@Test
	public void shouldHaveSubtypesWhenExternalTypesReturnsEmptySet()
	{
		// given
		given(persistenceManager.getTypePK("fooBar")).willReturn(mainPk);
		given(persistenceManager.getExternalTableTypes(mainPk)).willReturn(Collections.EMPTY_SET);

		// when
		final boolean typeHasSubtypes = fsCache.hasExternalTables("fooBar");

		// then
		assertThat(typeHasSubtypes).isFalse();
	}

	@Test
	public void shouldHaveSubtypesWhenExternalTypesReturnsNull()
	{
		// given
		Mockito.lenient().when(persistenceManager.getPersistenceInfo("fooBar")).thenReturn(typeInfoMap);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		Mockito.lenient().when(persistenceManager.getExternalTableTypes(mainPk)).thenReturn(null);

		// when
		final boolean typeHasSubtypes = fsCache.hasExternalTables("fooBar");

		// then
		assertThat(typeHasSubtypes).isFalse();
	}


	@Test
	public void typeShouldBeAbstractRootTableWhenTypeIsAbstractUnlocalizedTableIsNotNullAndDoesntContainSubtypes()
	{
		// given
		given(persistenceManager.getPersistenceInfo("fooBar")).willReturn(typeInfoMap);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		given(Boolean.valueOf(typeInfoMap.isAbstract())).willReturn(Boolean.TRUE);
		Mockito.lenient().when(persistenceManager.getExternalTableTypes(mainPk)).thenReturn(Collections.EMPTY_SET);
		given(typeInfoMap.getTableName(false)).willReturn("barBaz");

		// when
		final boolean isAbstractRootTable = fsCache.isAbstractRootTable("fooBar");

		// then
		assertThat(isAbstractRootTable).isTrue();
	}

	@Test
	public void typeShouldBeNotAbstractRootTableWhenTypeIsNotAbstract()
	{
		// given
		given(persistenceManager.getPersistenceInfo("fooBar")).willReturn(typeInfoMap);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		given(Boolean.valueOf(typeInfoMap.isAbstract())).willReturn(Boolean.FALSE);

		// when
		final boolean isAbstractRootTable = fsCache.isAbstractRootTable("fooBar");

		// then
		assertThat(isAbstractRootTable).isFalse();
	}

	@Test
	public void typeShouldBeNotAbstractRootTableWhenUnlocalizedTableIsNull()
	{
		// given
		given(persistenceManager.getPersistenceInfo("fooBar")).willReturn(typeInfoMap);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		given(Boolean.valueOf(typeInfoMap.isAbstract())).willReturn(Boolean.TRUE);
		given(typeInfoMap.getTableName(false)).willReturn(null);

		// when
		final boolean isAbstractRootTable = fsCache.isAbstractRootTable("fooBar");

		// then
		assertThat(isAbstractRootTable).isFalse();
	}

	@Test
	public void typeShouldBeNotAbstractRootTableWhenContainsSubtypes()
	{
		// given
		given(persistenceManager.getPersistenceInfo("fooBar")).willReturn(typeInfoMap);
		given(persistenceManager.getTypePK("fooBar")).willReturn(mainPk);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		given(Boolean.valueOf(typeInfoMap.isAbstract())).willReturn(Boolean.TRUE);
		given(typeInfoMap.getTableName(false)).willReturn("fooBar");
		given(persistenceManager.getExternalTableTypes(mainPk)).willReturn(Sets.newHashSet(searchPk));

		// when
		final boolean isAbstractRootTable = fsCache.isAbstractRootTable("fooBar");

		// then
		assertThat(isAbstractRootTable).isFalse();
	}

	@Test
	public void typeShouldNotBeAbstractWhenTypeIsAbstractAndDoesContainSubtypes()
	{
		// given
		given(persistenceManager.getPersistenceInfo("fooBar")).willReturn(typeInfoMap);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		Mockito.lenient().when(persistenceManager.getTypePK("fooBar")).thenReturn(mainPk);
		Mockito.lenient().when(Boolean.valueOf(typeInfoMap.isAbstract())).thenReturn(Boolean.FALSE);
		Mockito.lenient().when(persistenceManager.getExternalTableTypes(mainPk)).thenReturn(Sets.newHashSet(searchPk));

		// when
		final boolean isAbstractRootTable = fsCache.isAbstractRootTable("fooBar");

		// then
		assertThat(isAbstractRootTable).isFalse();
	}

	@Test
	public void shouldReturnFalseIfGivenTypeCodeIsNotAbstractRootTable()
	{
		// given
		given(persistenceManager.getPersistenceInfo("fooBar")).willReturn(typeInfoMap);
		Mockito.lenient().when(typeInfoMap.getTypePK()).thenReturn(mainPk);
		given(Boolean.valueOf(typeInfoMap.isAbstract())).willReturn(Boolean.FALSE);
		Mockito.lenient().when(persistenceManager.getExternalTableTypes(mainPk)).thenReturn(Sets.newHashSet(searchPk));

		// when
		final boolean isAbstractRootTable = fsCache.isAbstractRootTable("fooBar");

		// then
		assertThat(isAbstractRootTable).isFalse();
	}

	@Test
	public void shouldReturnTypePersistenceDataObjectForGivenTypeCode()
	{
		// given
		given(persistenceManager.getPersistenceInfo("fooBar")).willReturn(typeInfoMap);

		// when
		final CachedTypeData typePersistenceData = fsCache.getCachedTypeData("fooBar");

		// then
		assertThat(typePersistenceData).isNotNull();
	}

	@Test
	public void shouldThrowFlexibleSearchExceptionWhenPersistenceManagerWillThrowIllegalStateException()
	{
		// given
		given(persistenceManager.getPersistenceInfo("fooBar"))
				.willThrow(new IllegalArgumentException("type code 'FooBar' invalid"));

		try
		{
			// when
			fsCache.getCachedTypeData("fooBar");
			fail("should throw FlexibleSearchException");
		}
		catch (final FlexibleSearchException e)
		{
			// then
			assertThat(e).hasMessage("type code 'FooBar' invalid");
		}
	}

	@Test
	public void shouldReturnLanguagePkFromProperIsoCode()
	{
		// given
		given(c2lManager.getLanguageByIsoCode("en")).willReturn(language);
		given(language.getPK()).willReturn(langPk);

		// when
		final PK foundLangPk = fsCache.getLanguagePkFromIsocode("en");

		// then
		assertThat(foundLangPk).isNotNull().isEqualTo(langPk);
	}

	@Test
	public void shouldReturnLanguagePkByParsingSearchStringIfC2LManagerFailed()
	{
		// given
		given(c2lManager.getLanguageByIsoCode("123456")).willThrow(new JaloItemNotFoundException("language not found", 0));

		// when
		final PK foundLangPk = fsCache.getLanguagePkFromIsocode("123456");

		// then
		assertThat(foundLangPk).isNotNull().isEqualTo(PK.parse("123456"));
	}
}
