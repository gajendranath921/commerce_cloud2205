/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.order.interceptors;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.AttributeNotSupportedException;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PersistenceOperation;
import de.hybris.platform.servicelayer.interceptor.impl.OrphanedPartOfCleanupPrepareInterceptor;
import de.hybris.platform.servicelayer.internal.converter.ConverterRegistry;
import de.hybris.platform.servicelayer.internal.converter.ModelConverter;
import de.hybris.platform.servicelayer.internal.model.extractor.impl.DefaultPersistenceTypeService;
import de.hybris.platform.servicelayer.internal.model.impl.DefaultModelService;
import de.hybris.platform.servicelayer.model.AbstractItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.util.Config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

import com.google.common.collect.Sets;

@IntegrationTest
public class OrphanedPartOfCleanupPrepareInterceptorTest extends ServicelayerBaseTest
{
	MockitoSession mockito;

	@Mock
	DefaultModelService defaultModelServiceMock;

	@Mock
	ConverterRegistry converterRegistryMock;

	@Mock
	ModelConverter modelConverterMock;

	@Mock
	TypeService typeServiceMock;

	@Mock
	InterceptorContext interceptorContextMock;

	@Mock
	AbstractOrderModel modelMock;

	@Mock
	ItemModelContext itemModelContextImplMock;

	private static final String PART_OF_ATTRIBUTE = "partofattr";

	private UnitModel foo;
	private UnitModel oldFoo;

	final OrphanedPartOfCleanupPrepareInterceptor interceptor = new OrphanedPartOfCleanupPrepareInterceptor();

	protected String persistenceModeBefore;
	protected boolean persistenceModeSaved = false;

	@Before
	public void setUp()
	{
		mockito = Mockito.mockitoSession().initMocks(this).startMocking();

		enableDirectMode();

		initCurrentAndOriginalValues();

		interceptor.setTypeService(typeServiceMock);

		when(interceptorContextMock.getModelService()).thenReturn(defaultModelServiceMock);
		when(interceptorContextMock.isModified(modelMock)).thenReturn(true);
		when(interceptorContextMock.isNew(modelMock)).thenReturn(false);
		when(interceptorContextMock.isRemoved(modelMock)).thenReturn(false);

		when(defaultModelServiceMock.getConverterRegistry()).thenReturn(converterRegistryMock);
		when(converterRegistryMock.getModelConverterBySourceType(null)).thenReturn(modelConverterMock);
		when(modelConverterMock.getWritablePartOfAttributes(typeServiceMock)).thenReturn(Sets.newHashSet(PART_OF_ATTRIBUTE));

		when(modelMock.getItemModelContext()).thenReturn(itemModelContextImplMock);
	}

	@After
	public void tearDown()
	{
		mockito.finishMocking();
		if (persistenceModeSaved)
		{
			Config.setParameter(DefaultPersistenceTypeService.PERSISTENCE_LEGACY_MODE, persistenceModeBefore);
			persistenceModeSaved = false;
			persistenceModeBefore = null;
		}
	}

	private void enableDirectMode()
	{
		if (!persistenceModeSaved)
		{
			persistenceModeBefore = Config.getParameter(DefaultPersistenceTypeService.PERSISTENCE_LEGACY_MODE);
			persistenceModeSaved = true;
		}
		Config.setParameter(DefaultPersistenceTypeService.PERSISTENCE_LEGACY_MODE, "false");

	}

	private void initCurrentAndOriginalValues()
	{
		foo = new UnitModel();
		foo.setCode("foo");
		foo.setUnitType("foo");

		oldFoo = new UnitModel();
		oldFoo.setCode("old_foo");
		oldFoo.setUnitType("old_foo");
	}


	@Test
	public void notModifiedAttrShouldNotGetAttributeFromDB() throws InterceptorException
	{
		interceptor.onPrepare(modelMock, interceptorContextMock);

		verifyModelServiceGetAttributeInvocations(0);
	}

	@Test
	public void modifiedAttrShouldGetAttributeFromDB() throws InterceptorException
	{
		mockCurrentAndOriginalAttrValues(foo, foo);

		mockPartOfAttributeDirty(null);

		interceptor.onPrepare(modelMock, interceptorContextMock);
		verifyModelServiceGetAttributeInvocations(1);
	}

	@Test
	public void modifiedLocalizedAttrShouldGetAttributeFromDB() throws InterceptorException
	{
		when(itemModelContextImplMock.getOriginalValue(PART_OF_ATTRIBUTE, Locale.ENGLISH)).thenReturn(foo);
		when(defaultModelServiceMock.getAttributeValue(modelMock, PART_OF_ATTRIBUTE, Locale.ENGLISH)).thenReturn(foo);
		mockPartOfAttributeDirty(Locale.ENGLISH);

		interceptor.onPrepare(modelMock, interceptorContextMock);
		verifyModelServiceGetAttributeInvocations(0);
		verifyModelServiceGetLocalizedAttributeInvokedOnce();
	}

	@Test
	public void attrThatThrowsExShouldBeSkipped() throws InterceptorException
	{

		when(defaultModelServiceMock.getAttributeValue(modelMock, PART_OF_ATTRIBUTE)).thenReturn(foo);
		mockPartOfAttributeDirty(null);
		when(defaultModelServiceMock.getAttributeValue(modelMock, PART_OF_ATTRIBUTE)).thenThrow(
				new AttributeNotSupportedException("foo", PART_OF_ATTRIBUTE));

		final OrphanedPartOfCleanupPrepareInterceptor interceptor = new OrphanedPartOfCleanupPrepareInterceptor()
		{
			@Override
			protected Object getOriginalValue(final AbstractItemModel model, final String partOfQualifier)
			{
				fail("not supported attribute should be skipped - shouldn't call getOriginalValue()!");
				return null;
			}
		};
		interceptor.setTypeService(typeServiceMock);
		interceptor.onPrepare(modelMock, interceptorContextMock);
	}


	@Test
	public void attrWithDifferentValueShouldBeRegisteredForDeletion() throws InterceptorException
	{
		mockCurrentAndOriginalAttrValues(foo, oldFoo);

		mockPartOfAttributeDirty(null);

		interceptor.onPrepare(modelMock, interceptorContextMock);

		verify(interceptorContextMock, times(1)).registerElementFor(oldFoo, PersistenceOperation.DELETE);
	}

	private void mockCurrentAndOriginalAttrValues(final AbstractItemModel currentVal, final AbstractItemModel originalVal)
	{
		when(itemModelContextImplMock.getOriginalValue(PART_OF_ATTRIBUTE)).thenReturn(originalVal);
		when(defaultModelServiceMock.getAttributeValue(modelMock, PART_OF_ATTRIBUTE)).thenReturn(currentVal);
	}

	private void mockPartOfAttributeDirty(final Locale loc)
	{
		final Map<String, Set<Locale>> dirtyAttributes = new HashMap<>();
		dirtyAttributes.put(OrphanedPartOfCleanupPrepareInterceptorTest.PART_OF_ATTRIBUTE,
				loc != null ? Sets.newHashSet(loc) : null);
		when(interceptorContextMock.getDirtyAttributes(modelMock)).thenReturn(dirtyAttributes);
	}

	private void verifyModelServiceGetAttributeInvocations(final int invocationsNumber)
	{
		verify(defaultModelServiceMock, times(invocationsNumber)).getAttributeValue(modelMock, PART_OF_ATTRIBUTE);
	}

	private void verifyModelServiceGetLocalizedAttributeInvokedOnce()
	{
		verify(defaultModelServiceMock, times(1)).getAttributeValue(modelMock, PART_OF_ATTRIBUTE, Locale.ENGLISH);
	}
}
