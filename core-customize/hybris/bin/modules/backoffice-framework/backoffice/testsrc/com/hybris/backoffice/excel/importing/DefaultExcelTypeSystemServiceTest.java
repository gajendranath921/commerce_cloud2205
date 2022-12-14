/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.excel.importing;

import static com.hybris.backoffice.excel.template.ExcelTemplateConstants.UtilitySheet.TYPE_SYSTEM;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.i18n.impl.DefaultCommonI18NService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Sets;
import com.hybris.backoffice.excel.template.CollectionFormatter;
import com.hybris.backoffice.excel.template.cell.ExcelCellService;
import com.hybris.backoffice.excel.template.populator.typesheet.TypeSystemRow;


@RunWith(MockitoJUnitRunner.class)
public class DefaultExcelTypeSystemServiceTest
{

	@Mock
	private Workbook workbook;

	@Mock
	private Sheet typeSystemSheet;

	@Mock
	private ExcelCellService cellService;

	@Mock
	private DefaultCommonI18NService commonI18NService;

	@Mock
	private CollectionFormatter collectionFormatter;

	@InjectMocks
	private ExcelAttributeTypeSystemService service;

	@Before
	public void setUp()
	{
		given(workbook.getSheet(TYPE_SYSTEM.getSheetName())).willReturn(typeSystemSheet);
		given(typeSystemSheet.getLastRowNum()).willReturn(1);
	}

	@Test
	public void shouldCreateTypeSystemRow()
	{
		// given
		mockTypeSystemRow("code", "Article Number", "FALSE", "", "{Article Number*^}");
		given(collectionFormatter.formatToCollection("{Article Number*^}")).willReturn(Sets.newHashSet("Article Number*^"));

		// when
		final ExcelAttributeTypeSystemService.ExcelTypeSystem typeSystem = service.loadTypeSystem(workbook);

		// then
		assertTypeSystemRow(typeSystem, "Article Number*^", "code", "Article Number", "", false);
	}

	@Test
	public void shouldCreateTypeSystemRowForEachLanguageOfLocalizedAttribute()
	{
		// given
		mockTypeSystemRow("name", "Identifier", "TRUE", "{en},{de}", "{Identifier[en]},{Identifier[de]}");
		given(collectionFormatter.formatToCollection("{Identifier[en]},{Identifier[de]}"))
				.willReturn(Sets.newHashSet("Identifier[en]", "Identifier[de]"));

		mockLanguage();

		// when
		final ExcelAttributeTypeSystemService.ExcelTypeSystem typeSystem = service.loadTypeSystem(workbook);

		// then
		assertTypeSystemRow(typeSystem, "Identifier[en]", "name", "Identifier", "en", true);
		assertTypeSystemRow(typeSystem, "Identifier[de]", "name", "Identifier", "de", true);
	}

	@Test
	public void shouldCreateTypeSystemRowForNoneSupportLanguageOfLocalizedAttribute()
	{
		// given
		mockTypeSystemRow("name", "Identifier", "TRUE", "", "{Identifier[test]}");
		given(collectionFormatter.formatToCollection("{Identifier[test]}")).willReturn(Sets.newHashSet("Identifier[test]"));

		mockLanguage();

		// when
		final ExcelAttributeTypeSystemService.ExcelTypeSystem typeSystem = service.loadTypeSystem(workbook);

		// then
		assertTypeSystemRow(typeSystem, "Identifier[test]", "name", "Identifier", "", true);
	}

	private Row mockTypeSystemRow(final String attrQualifier, final String attrName, final String attrLocalized,
			final String attrLocLang, final String attrDisplayedName)
	{
		final Row row = mock(Row.class);
		given(typeSystemSheet.getRow(1)).willReturn(row);
		mockCell(row, 0, "{Product}");
		mockCell(row, 1, "Product");
		mockCell(row, 2, attrQualifier);
		mockCell(row, 3, attrName);
		mockCell(row, 4, "FALSE");
		mockCell(row, 5, "java.lang.String");
		mockCell(row, 6, "Product");
		mockCell(row, 7, attrLocalized);
		mockCell(row, 8, attrLocLang);
		mockCell(row, 9, attrDisplayedName);
		mockCell(row, 10, "TRUE");
		mockCell(row, 11, "");
		return row;
	}

	private void mockCell(final Row row, final int index, final String cellValue)
	{
		final Cell cell = mock(Cell.class);
		given(row.getCell(index)).willReturn(cell);
		given(cellService.getCellValue(cell)).willReturn(cellValue);
	}

	private void mockLanguage()
	{
		final LanguageModel en = new LanguageModel();
		en.setIsocode("en");
		final LanguageModel de = new LanguageModel();
		de.setIsocode("de");
		final List<LanguageModel> allLanguages = Arrays.asList(en, de);

		given(commonI18NService.getAllLanguages()).willReturn(allLanguages);
	}

	protected void assertTypeSystemRow(final ExcelAttributeTypeSystemService.ExcelTypeSystem typeSystem,
			final String attrDisplayName, final String attrQualifier, final String attrName, final String attrLocLang,
			final boolean attrLocalized)
	{
		final Optional<TypeSystemRow> optionalRow = typeSystem.findRow(attrDisplayName);
		assertThat(optionalRow).isPresent();
		final TypeSystemRow row = optionalRow.get();
		assertThat(row.getTypeCode()).isEqualTo("{Product}");
		assertThat(row.getTypeName()).isEqualTo("Product");
		assertThat(row.getAttrQualifier()).isEqualTo(attrQualifier);
		assertThat(row.getAttrName()).isEqualTo(attrName);
		assertThat(row.getAttrOptional()).isFalse();
		assertThat(row.getAttrTypeCode()).isEqualTo("java.lang.String");
		assertThat(row.getAttrTypeItemType()).isEqualTo("Product");
		assertThat(row.getAttrLocalized()).isEqualTo(attrLocalized);
		assertThat(row.getAttrLocLang()).isEqualTo(attrLocLang);
		assertThat(row.getAttrDisplayName()).isEqualTo(attrDisplayName);
		assertThat(row.getAttrUnique()).isTrue();
		assertThat(row.getAttrReferenceFormat()).isEqualTo("");
	}
}
