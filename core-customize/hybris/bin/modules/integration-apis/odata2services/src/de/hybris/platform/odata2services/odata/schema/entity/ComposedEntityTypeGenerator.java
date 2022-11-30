/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.odata.schema.entity;

import de.hybris.platform.integrationservices.model.DescriptorFactory;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.integrationservices.model.TypeDescriptor;
import de.hybris.platform.odata2services.odata.schema.navigation.NavigationPropertyListGeneratorRegistry;

import java.util.Collections;
import java.util.List;

import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.springframework.beans.factory.annotation.Required;

public class ComposedEntityTypeGenerator extends SingleEntityTypeGenerator
{
	private NavigationPropertyListGeneratorRegistry registry;
	private DescriptorFactory descriptorFactory;

	@Override
	protected EntityType generateEntityType(final IntegrationObjectItemModel item)
	{
		final List<NavigationProperty> navigationProperties = generateNavigationProperties(getDescriptorFactory().createItemTypeDescriptor(item));

		return super.generateEntityType(item)
		            .setNavigationProperties(navigationProperties);
	}

	private List<NavigationProperty> generateNavigationProperties(final TypeDescriptor itemTypeDescriptor)
	{
		return itemTypeDescriptor == null ? Collections.emptyList() : getRegistry().generate(itemTypeDescriptor);
	}

	@Override
	protected boolean isApplicable(final IntegrationObjectItemModel item)
	{
		return true;
	}

	@Override
	protected String generateEntityTypeName(final IntegrationObjectItemModel item)
	{
		return item.getCode();
	}

	protected NavigationPropertyListGeneratorRegistry getRegistry()
	{
		return registry;
	}

	@Required
	public void setRegistry(final NavigationPropertyListGeneratorRegistry registry)
	{
		this.registry = registry;
	}

	protected DescriptorFactory getDescriptorFactory()
	{
		return descriptorFactory;
	}

	@Required
	public void setDescriptorFactory(final DescriptorFactory descriptorFactory)
	{
		this.descriptorFactory = descriptorFactory;
	}
}


