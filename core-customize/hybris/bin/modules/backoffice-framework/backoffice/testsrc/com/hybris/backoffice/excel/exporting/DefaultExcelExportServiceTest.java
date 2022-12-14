/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.excel.exporting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.jalo.JaloObjectNoLongerValidException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.variants.model.VariantProductModel;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.hybris.backoffice.excel.data.SelectedAttribute;
import com.hybris.backoffice.excel.template.ExcelTemplateService;
import com.hybris.backoffice.excel.template.sheet.ExcelSheetService;
import com.hybris.backoffice.excel.template.workbook.ExcelWorkbookService;
import com.hybris.backoffice.excel.translators.ExcelTranslatorRegistry;
import com.hybris.backoffice.variants.BackofficeVariantsService;


@RunWith(MockitoJUnitRunner.class)
public class DefaultExcelExportServiceTest
{

	@Mock
	private ExcelExportDivider excelExportDivider;
	@Mock
	private ExcelTranslatorRegistry excelTranslatorRegistry;
	@Mock
	private ExcelTemplateService excelTemplateService;
	@Mock
	private TypeService typeService;
	@Mock
	private ModelService modelService;
	@Mock
	private BackofficeVariantsService backofficeVariantsService;
	@Mock
	private CommonI18NService commonI18NService;
	@Mock
	private ExcelSheetService excelSheetService;
	@Mock
	private ExcelWorkbookService excelWorkbookService;
	@InjectMocks
	@Spy
	private DefaultExcelExportService excelExportService;

	@Test
	public void shouldExportTemplateForTypeWithSubtypes()
	{
		// given
		final String product = "Product";
		final String shoes = "Shoes";
		final String jeans = "Jeans";

		final ComposedTypeModel productType = mock(ComposedTypeModel.class);
		when(typeService.getComposedTypeForCode(product)).thenReturn(productType);

		final ComposedTypeModel shoesSubtype = mock(ComposedTypeModel.class);
		when(shoesSubtype.getAbstract()).thenReturn(false);
		when(shoesSubtype.getCode()).thenReturn(shoes);
		final ComposedTypeModel jeansSubtype = mock(ComposedTypeModel.class);
		when(jeansSubtype.getAbstract()).thenReturn(null);
		when(jeansSubtype.getCode()).thenReturn(jeans);

		final Collection<ComposedTypeModel> subTypes = Lists.newArrayList(shoesSubtype, jeansSubtype);
		when(productType.getAllSubTypes()).thenReturn(subTypes);

		Mockito.lenient().when(excelExportDivider.groupAttributesByType(any(), any())).thenReturn(Collections.emptyMap());

		final Workbook excel = mock(Workbook.class);
		doReturn(excel).when(excelExportService).exportData(any(Map.class), any(List.class));

		// when
		final Workbook ret = excelExportService.exportTemplate(product);

		// then
		assertThat(ret).isSameAs(excel);

		final ArgumentCaptor<Map<String, Set<ItemModel>>> mapCaptor = (ArgumentCaptor) ArgumentCaptor.forClass(Map.class);
		final ArgumentCaptor<List<SelectedAttribute>> listCaptor = (ArgumentCaptor) ArgumentCaptor.forClass(List.class);
		verify(excelExportService).exportData(mapCaptor.capture(), listCaptor.capture());

		assertThat(mapCaptor.getValue()).hasSize(3);
		assertThat(mapCaptor.getValue()).containsEntry(product, Collections.emptySet());
		assertThat(mapCaptor.getValue()).containsEntry(shoes, Collections.emptySet());
		assertThat(mapCaptor.getValue()).containsEntry(jeans, Collections.emptySet());

		assertThat(listCaptor.getValue()).isEmpty();
	}

	@Test
	public void shouldFilterOutAbstractTypesWhenExportingTemplate()
	{
		// given
		final String product = "Product";
		final String variantProduct = "VariantProduct";

		final ComposedTypeModel productType = mock(ComposedTypeModel.class);
		when(typeService.getComposedTypeForCode(product)).thenReturn(productType);

		final ComposedTypeModel variantProductSubtype = mock(ComposedTypeModel.class);
		when(variantProductSubtype.getAbstract()).thenReturn(true);
		Mockito.lenient().when(variantProductSubtype.getCode()).thenReturn(variantProduct);

		final Collection<ComposedTypeModel> subTypes = Lists.newArrayList(variantProductSubtype);
		when(productType.getAllSubTypes()).thenReturn(subTypes);

		Mockito.lenient().when(excelExportDivider.groupAttributesByType(any(), any())).thenReturn(Collections.emptyMap());

		final Workbook excel = mock(Workbook.class);
		doReturn(excel).when(excelExportService).exportData(any(Map.class), any(List.class));

		// when
		final Workbook ret = excelExportService.exportTemplate(product);

		// then
		assertThat(ret).isSameAs(excel);

		final ArgumentCaptor<Map<String, Set<ItemModel>>> mapCaptor = (ArgumentCaptor) ArgumentCaptor.forClass(Map.class);
		final ArgumentCaptor<List<SelectedAttribute>> listCaptor = (ArgumentCaptor) ArgumentCaptor.forClass(List.class);
		verify(excelExportService).exportData(mapCaptor.capture(), listCaptor.capture());

		assertThat(mapCaptor.getValue()).hasSize(1);
		assertThat(mapCaptor.getValue()).containsEntry(product, Collections.emptySet());

		assertThat(listCaptor.getValue()).isEmpty();
	}

	@Test
	public void shouldRefreshItemsAndFilterOutAlreadyRemovedItems()
	{
		// given
		final ProductModel firstProduct = new ProductModel();
		final ProductModel secondProduct = new ProductModel();
		final ProductModel thirdProduct = new ProductModel();
		doThrow(JaloObjectNoLongerValidException.class).when(modelService).refresh(secondProduct);

		// when
		final List<ItemModel> refreshedItems = excelExportService
				.refreshSelectedItems(Arrays.asList(firstProduct, secondProduct, thirdProduct));

		// then
		assertThat(refreshedItems).hasSize(2);
		assertThat(refreshedItems).containsOnly(firstProduct, thirdProduct);
	}

	@Test
	public void shouldGetItemAttributeForNonVariantNonLocalizedType()
	{
		// given
		final ItemModel itemModel = mock(ItemModel.class);
		final SelectedAttribute selectedAttribute = mock(SelectedAttribute.class);
		final AttributeDescriptorModel attributeDescriptorModel = mock(AttributeDescriptorModel.class);

		given(selectedAttribute.getAttributeDescriptor()).willReturn(attributeDescriptorModel);
		given(attributeDescriptorModel.getQualifier()).willReturn("simpleAttribute");
		given(selectedAttribute.isLocalized()).willReturn(false);

		given(modelService.getAttributeValue(any(), any())).willReturn("simpleAttributeValue");

		// when
		final Object result = excelExportService.getItemAttribute(itemModel, selectedAttribute);

		// then
		assertThat(result).isEqualTo("simpleAttributeValue");
		then(modelService).should().getAttributeValue(itemModel, "simpleAttribute");
	}

	@Test
	public void shouldGetItemAttributeForNonVariantLocalizedType()
	{
		// given
		final ItemModel itemModel = mock(ItemModel.class);
		final SelectedAttribute selectedAttribute = mock(SelectedAttribute.class);
		final AttributeDescriptorModel attributeDescriptorModel = mock(AttributeDescriptorModel.class);

		given(selectedAttribute.getAttributeDescriptor()).willReturn(attributeDescriptorModel);
		given(attributeDescriptorModel.getQualifier()).willReturn("simpleLocalizedAttribute");
		given(selectedAttribute.isLocalized()).willReturn(true);
		given(selectedAttribute.getIsoCode()).willReturn("en");

		given(commonI18NService.getLocaleForIsoCode("en")).willReturn(Locale.ENGLISH);
		given(modelService.getAttributeValue(any(), any(), any())).willReturn("simpleLocalizedAttributeValue");

		// when
		final Object result = excelExportService.getItemAttribute(itemModel, selectedAttribute);

		// then
		assertThat(result).isEqualTo("simpleLocalizedAttributeValue");
		then(modelService).should().getAttributeValue(itemModel, "simpleLocalizedAttribute", Locale.ENGLISH);
	}

	@Test
	public void shouldGetItemAttributeForVariantNonLocalizedType()
	{
		// given
		final VariantProductModel itemModel = mock(VariantProductModel.class);
		final SelectedAttribute selectedAttribute = mock(SelectedAttribute.class);
		final AttributeDescriptorModel attributeDescriptorModel = mock(AttributeDescriptorModel.class);

		given(selectedAttribute.getAttributeDescriptor()).willReturn(attributeDescriptorModel);
		given(attributeDescriptorModel.getQualifier()).willReturn("variantAttribute");
		given(selectedAttribute.isLocalized()).willReturn(false);

		given(backofficeVariantsService.getVariantAttributeValue(any(), any())).willReturn("variantAttributeValue");

		// when
		final Object result = excelExportService.getItemAttribute(itemModel, selectedAttribute);

		// then
		assertThat(result).isEqualTo("variantAttributeValue");
		then(backofficeVariantsService).should().getVariantAttributeValue(itemModel, "variantAttribute");
	}

	@Test
	public void shouldGetItemAttributeForVariantLocalizedType()
	{
		// given
		final VariantProductModel itemModel = mock(VariantProductModel.class);
		final SelectedAttribute selectedAttribute = mock(SelectedAttribute.class);
		final AttributeDescriptorModel attributeDescriptorModel = mock(AttributeDescriptorModel.class);

		given(selectedAttribute.getAttributeDescriptor()).willReturn(attributeDescriptorModel);
		given(attributeDescriptorModel.getQualifier()).willReturn("variantLocalizedAttribute");
		given(selectedAttribute.isLocalized()).willReturn(true);
		given(selectedAttribute.getIsoCode()).willReturn("en");

		given(commonI18NService.getLocaleForIsoCode("en")).willReturn(Locale.ENGLISH);
		final Map<Locale, Object> locales = new HashMap<>();
		locales.put(Locale.ENGLISH, "variantLocalizedAttributeValue");
		given(backofficeVariantsService.getLocalizedVariantAttributeValue(any(), any())).willReturn(locales);

		// when
		final Object result = excelExportService.getItemAttribute(itemModel, selectedAttribute);

		// then
		assertThat(result).isEqualTo("variantLocalizedAttributeValue");
		then(backofficeVariantsService).should().getLocalizedVariantAttributeValue(itemModel, "variantLocalizedAttribute");
	}

	@Test
	public void shouldCreateCorrectTypeSheet()
	{
		//given
		excelExportService.setTypePredicates(new HashSet<>());
		final String product = "Product";
		final Workbook workbook = mock(Workbook.class);
		final Map<String, Set<SelectedAttribute>> attributesByType = new HashMap<>();
		final HashSet<SelectedAttribute> selectedAttributeHashSet = new HashSet<>();
		final Map<String, Set<ItemModel>> itemsByType = new HashMap<>();
		final HashSet<ItemModel> itemModels = new HashSet<>();
		final ProductModel productModel = mock(ProductModel.class);
		final List<SelectedAttribute> selectedAttributes = ListUtils.EMPTY_LIST;
		selectedAttributeHashSet.add(mock(SelectedAttribute.class));
		attributesByType.put(product, selectedAttributeHashSet);
		itemModels.add(productModel);
		itemsByType.put(product, itemModels);

		given(excelWorkbookService.createWorkbook(any())).willReturn(workbook);
		given(excelExportDivider.groupAttributesByType(any(Set.class), any(Collection.class))).willReturn(attributesByType);
		doReturn(mock(InputStream.class)).when(excelExportService).loadExcelTemplate();
		doNothing().when(excelExportService).addHeader(any(), any());
		doNothing().when(excelExportService).addValues(any(), any(), any(), any());

		//when
		excelExportService.exportData(itemsByType, selectedAttributes);

		//then
		verify(excelSheetService).createOrGetTypeSheet(workbook, product);
	}
}
