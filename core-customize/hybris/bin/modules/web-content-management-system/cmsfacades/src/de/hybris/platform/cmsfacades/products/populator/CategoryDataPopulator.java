/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.products.populator;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cmsfacades.common.populator.LocalizedPopulator;
import de.hybris.platform.cmsfacades.data.CategoryData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Required;

/**
 * Populates a {@link CategoryData} instance from the {@link CategoryModel} source data model. 
 */
public class CategoryDataPopulator implements Populator<CategoryModel, CategoryData>
{
	private LocalizedPopulator localizedPopulator;
	
	@Override
	public void populate(final CategoryModel source, final CategoryData target) throws ConversionException
	{
		target.setCode(source.getCode());

		final Map<String, String> nameMap = Optional.ofNullable(target.getName()).orElseGet(() -> getNewNameMap(target));
		getLocalizedPopulator().populate( //
				(locale, value) -> nameMap.put(getLocalizedPopulator().getLanguage(locale), value), //
				(locale) -> source.getName(locale));

		final Map<String, String> descriptionMap = Optional.ofNullable(target.getDescription()).orElseGet(() -> getNewDescriptionMap(target));
		getLocalizedPopulator().populate( //
				(locale, value) -> descriptionMap.put(getLocalizedPopulator().getLanguage(locale), value), //
				(locale) -> source.getDescription(locale));

		Optional.ofNullable(source.getCatalogVersion()).ifPresent(catalogVersionModel -> {
			target.setCatalogId(catalogVersionModel.getCatalog().getId());
			target.setCatalogVersion(catalogVersionModel.getVersion());	
		});
		Optional.ofNullable(source.getThumbnail()).ifPresent(mediaModel -> target.setThumbnailMediaCode(mediaModel.getCode()));
	}

	protected Map<String, String> getNewNameMap(final CategoryData target)
	{
		target.setName(new LinkedHashMap<>());
		return target.getName();
	}
	
	protected Map<String, String> getNewDescriptionMap(final CategoryData target)
	{
		target.setDescription(new LinkedHashMap<>());
		return target.getDescription();
	}

	protected LocalizedPopulator getLocalizedPopulator()
	{
		return localizedPopulator;
	}

	@Required
	public void setLocalizedPopulator(final LocalizedPopulator localizedPopulator)
	{
		this.localizedPopulator = localizedPopulator;
	}
}
