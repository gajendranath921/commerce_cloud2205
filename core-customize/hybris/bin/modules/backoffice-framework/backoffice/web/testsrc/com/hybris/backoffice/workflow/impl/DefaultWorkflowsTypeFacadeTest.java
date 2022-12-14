/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.workflow.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.platform.auditreport.model.AuditReportDataModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.hybris.cockpitng.dataaccess.facades.permissions.PermissionFacade;
import com.hybris.cockpitng.dataaccess.facades.type.DataType;
import com.hybris.cockpitng.dataaccess.facades.type.TypeFacade;
import com.hybris.cockpitng.dataaccess.facades.type.exceptions.TypeNotFoundException;
import com.hybris.cockpitng.util.type.BackofficeTypeUtils;


@RunWith(MockitoJUnitRunner.class)
public class DefaultWorkflowsTypeFacadeTest
{
	public static final String TYPE_CODE_PRODUCT = "Product";
	public static final String TYPE_CODE_CATEGORY = "Category";
	public static final String TYPE_CODE_BLACKLISTED = "AuditReportData";
	public static final String TYPE_CODE_NOT_ALLOWED = "User";
	@InjectMocks
	private DefaultWorkflowsTypeFacade facade;
	@Mock
	private TypeFacade typeFacade;
	@Mock
	private TypeService typeService;
	@Mock
	private PermissionFacade permissionFacade;
	@Mock
	private BackofficeTypeUtils backofficeTypeUtils;
	private ComposedTypeModel productComposedType;

	@Before
	public void setUp()
	{
		mockDataType(TYPE_CODE_PRODUCT, ProductModel.class);
		mockDataType(TYPE_CODE_CATEGORY, CategoryModel.class);
		mockDataType(TYPE_CODE_BLACKLISTED, AuditReportDataModel.class);
		final Set<String> typeCodes = new HashSet<>();
		typeCodes.add(TYPE_CODE_PRODUCT);
		typeCodes.add(TYPE_CODE_CATEGORY);
		typeCodes.add(TYPE_CODE_NOT_ALLOWED);
		typeCodes.add(TYPE_CODE_BLACKLISTED);
		facade.setAttachmentTypeCodes(typeCodes);
		facade.setUiBlacklistedAttachmentTypeCodes(Set.of(TYPE_CODE_BLACKLISTED));

		productComposedType = mock(ComposedTypeModel.class);
		when(typeService.getComposedTypeForCode(TYPE_CODE_PRODUCT)).thenReturn(productComposedType);
		final ComposedTypeModel categoryComposedType = mock(ComposedTypeModel.class);
		when(typeService.getComposedTypeForCode(TYPE_CODE_CATEGORY)).thenReturn(categoryComposedType);
		when(permissionFacade.canReadType(TYPE_CODE_PRODUCT)).thenReturn(true);
		when(permissionFacade.canReadType(TYPE_CODE_CATEGORY)).thenReturn(true);
		when(permissionFacade.canReadType(TYPE_CODE_BLACKLISTED)).thenReturn(true);
		when(permissionFacade.canReadType(TYPE_CODE_NOT_ALLOWED)).thenReturn(false);
	}

	@Test
	public void testClassesRefreshedAfterTypeCodesChange()
	{
		assertThat(facade.getSupportedAttachmentClassNames()).hasSize(3);
		assertThat(facade.getSupportedAttachmentClassNames()).containsOnly(ProductModel.class.getName(),
				CategoryModel.class.getName(), AuditReportDataModel.class.getName());

		mockDataType("Order", OrderModel.class);
		final Set<String> typeCodes = new HashSet<>(facade.getAttachmentTypeCodes());
		typeCodes.add("Order");
		when(permissionFacade.canReadType("Order")).thenReturn(true);
		facade.setAttachmentTypeCodes(typeCodes);

		assertThat(facade.getSupportedAttachmentClassNames()).hasSize(4);
		assertThat(facade.getSupportedAttachmentClassNames()).containsOnly(ProductModel.class.getName(),
				CategoryModel.class.getName(), OrderModel.class.getName(), AuditReportDataModel.class.getName());
	}

	@Test
	public void testGetSupportedTypeCodesVisibleForUser()
	{
		assertThat(facade.getAttachmentTypeCodes()).contains(TYPE_CODE_NOT_ALLOWED);
		assertThat(facade.getSupportedAttachmentTypeCodes()).containsOnly(TYPE_CODE_PRODUCT, TYPE_CODE_CATEGORY,
				TYPE_CODE_BLACKLISTED);
	}

	@Test
	public void shouldGetSupportedAttachmentTypesVisibleFromUiPerspective()
	{
		//given
		final ComposedTypeModel supportedComposedType = mock(ComposedTypeModel.class);
		final ComposedTypeModel blacklistedComposedType = mock(ComposedTypeModel.class);

		when(blacklistedComposedType.getCode()).thenReturn(TYPE_CODE_BLACKLISTED);
		when(supportedComposedType.getCode()).thenReturn(TYPE_CODE_PRODUCT, TYPE_CODE_CATEGORY);
		when(typeService.getComposedTypeForCode(TYPE_CODE_PRODUCT)).thenReturn(supportedComposedType);
		when(typeService.getComposedTypeForCode(TYPE_CODE_CATEGORY)).thenReturn(supportedComposedType);
		when(typeService.getComposedTypeForCode(TYPE_CODE_BLACKLISTED)).thenReturn(blacklistedComposedType);
		when(typeService.isAssignableFrom(TYPE_CODE_BLACKLISTED, TYPE_CODE_BLACKLISTED)).thenReturn(true);
		when(typeService.isAssignableFrom(TYPE_CODE_BLACKLISTED, TYPE_CODE_PRODUCT)).thenReturn(false);
		when(typeService.isAssignableFrom(TYPE_CODE_BLACKLISTED, TYPE_CODE_CATEGORY)).thenReturn(false);

		//when
		final List<ComposedTypeModel> result = facade.getSupportedAttachmentTypes();

		//then
		assertThat(result).hasSize(2);
		assertThat(result).containsOnly(supportedComposedType);
	}

	@Test
	public void testFindSupportedAttachmentType()
	{
		final ItemModel customProduct = mock(ItemModel.class);
		final ItemModel variantProduct = mock(ItemModel.class);


		final List<ItemModel> attachments = Lists.newArrayList(customProduct, variantProduct);
		when(backofficeTypeUtils.findClosestSuperType(eq(new ArrayList<>(attachments)))).thenReturn("VariantProduct");
		doReturn(Boolean.TRUE).when(typeService).isAssignableFrom(TYPE_CODE_PRODUCT, "VariantProduct");

		final Optional<ComposedTypeModel> attachmentType = facade.findCommonAttachmentType(attachments);

		assertThat(attachmentType.isPresent()).isTrue();
		assertThat(attachmentType.get()).isEqualTo(productComposedType);
	}

	protected void mockDataType(final String typeCode, final Class clazz)
	{
		final DataType dataType = mock(DataType.class);
		when(dataType.getClazz()).thenReturn(clazz);
		try
		{
			when(typeFacade.load(typeCode)).thenReturn(dataType);
		}
		catch (final TypeNotFoundException e)
		{

		}
	}

}
