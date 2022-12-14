/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.integrationservices.model.impl;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.integrationservices.model.DescriptorFactory;
import de.hybris.platform.integrationservices.model.IntegrationObjectDescriptor;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.integrationservices.model.IntegrationObjectModel;
import de.hybris.platform.integrationservices.model.TypeDescriptor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

/**
 * Default implementation of {@link IntegrationObjectDescriptor} based on {@link IntegrationObjectModel} data structure.
 */
public class DefaultIntegrationObjectDescriptor extends AbstractDescriptor implements IntegrationObjectDescriptor
{
	private final IntegrationObjectModel integrationObjectModel;
	private Set<TypeDescriptor> integrationObjectItems;

	DefaultIntegrationObjectDescriptor(final IntegrationObjectModel model, final DescriptorFactory factory)
	{
		super(factory);
		Preconditions.checkArgument(model != null, "IntegrationObjectModel is required");
		integrationObjectModel = model;
	}

	@Override
	public String getCode()
	{
		return integrationObjectModel.getCode();
	}

	@Override
	public Set<TypeDescriptor> getItemTypeDescriptors()
	{
		if (integrationObjectItems == null)
		{
			integrationObjectItems = integrationObjectModel.getItems().stream()
			                                               .map(item -> getFactory().createItemTypeDescriptor(item))
			                                               .collect(Collectors.toSet());
		}
		return new HashSet<>(integrationObjectItems);
	}

	@Override
	public Optional<TypeDescriptor> getItemTypeDescriptor(final ItemModel item)
	{
		if (item == null)
		{
			return Optional.empty();
		}
		final Optional<TypeDescriptor> exactMatch = findMatchingTypeDescriptor(
				d -> d.getTypeCode().equals(deriveItemTypeCode(item)));
		return exactMatch.isPresent()
				? exactMatch
				: findMatchingTypeDescriptor(type -> type.isInstance(item));
	}

	private String deriveItemTypeCode(final ItemModel item)
	{
		return item instanceof ComposedTypeModel ? ((ComposedTypeModel) item).getCode() : item.getItemtype();
	}

	private Optional<TypeDescriptor> findMatchingTypeDescriptor(final Predicate<TypeDescriptor> predicate)
	{
		return getItemTypeDescriptors().stream()
		                               .filter(predicate)
		                               .findAny();
	}

	@Override
	public Optional<TypeDescriptor> getRootItemType()
	{
		final IntegrationObjectItemModel rootItem = integrationObjectModel.getRootItem();
		return Optional.ofNullable(rootItem)
		               .map(model -> getFactory().createItemTypeDescriptor(model));
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		final DefaultIntegrationObjectDescriptor that = (DefaultIntegrationObjectDescriptor) o;

		return integrationObjectModel.getCode().equals(that.integrationObjectModel.getCode());
	}

	@Override
	public int hashCode()
	{
		return integrationObjectModel.getCode().hashCode();
	}

	@Override
	public String toString()
	{
		return "IntegrationObject{" +
				"code=" + integrationObjectModel.getCode() +
				'}';
	}
}
