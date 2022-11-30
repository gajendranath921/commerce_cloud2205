/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.odata.schema;

import de.hybris.platform.integrationservices.exception.IntegrationAttributeException;
import de.hybris.platform.integrationservices.model.DescriptorFactory;
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel;
import de.hybris.platform.integrationservices.model.TypeDescriptor;
import de.hybris.platform.integrationservices.util.ApplicationBeans;
import de.hybris.platform.odata2services.odata.InvalidODataSchemaException;
import de.hybris.platform.odata2services.odata.OData2ServicesException;
import de.hybris.platform.odata2services.odata.schema.association.AssociationListGeneratorRegistry;
import de.hybris.platform.odata2services.odata.schema.entity.EntityContainerGenerator;
import de.hybris.platform.odata2services.odata.schema.utils.SchemaUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.springframework.beans.factory.annotation.Required;

import com.google.common.base.Preconditions;

public class DefaultSchemaGenerator implements SchemaGenerator
{
	private AssociationListGeneratorRegistry associationListGeneratorRegistry;
	private SchemaElementGenerator<List<EntityType>, Collection<IntegrationObjectItemModel>> entityTypesGenerator;
	private EntityContainerGenerator entityContainerGenerator;
	private DescriptorFactory descriptorFactory;

	public Schema generateSchema(final Collection<IntegrationObjectItemModel> allModelsForType)
	{
		try
		{
			Preconditions.checkArgument(allModelsForType != null, "Unable to generate schema for null");

			final Collection<TypeDescriptor> modelDescriptors = toDescriptors(allModelsForType);
			final List<EntityType> entityTypes = entityTypesGenerator.generate(allModelsForType);
			final List<Association> associations = associationListGeneratorRegistry.generateFor(modelDescriptors);
			return new Schema()
					.setNamespace(SchemaUtils.NAMESPACE)
					.setAnnotationAttributes(SchemaUtils.createNamespaceAnnotations())
					.setEntityTypes(entityTypes)
					.setAssociations(associations)
					.setEntityContainers(entityContainerGenerator.generate(entityTypes, associations));
		}
		catch (final OData2ServicesException | IntegrationAttributeException e)
		{
			throw e;
		}
		catch(final RuntimeException e)
		{
			throw new InvalidODataSchemaException(e);
		}
	}

	private Collection<TypeDescriptor> toDescriptors(final Collection<IntegrationObjectItemModel> models)
	{
		return models.stream()
				.map( getDescriptorFactory()::createItemTypeDescriptor)
				.collect(Collectors.toList());
	}

	@Required
	public void setEntityTypesGenerator(final SchemaElementGenerator<List<EntityType>, Collection<IntegrationObjectItemModel>> entityTypesGenerator)
	{
		this.entityTypesGenerator = entityTypesGenerator;
	}

	@Required
	public void setAssociationListGeneratorRegistry(final AssociationListGeneratorRegistry associationListGeneratorRegistry)
	{
		this.associationListGeneratorRegistry = associationListGeneratorRegistry;
	}

	@Required
	public void setEntityContainerGenerator(final EntityContainerGenerator generator)
	{
		this.entityContainerGenerator = generator;
	}

	public void setDescriptorFactory(final DescriptorFactory factory)
	{
		descriptorFactory = factory;
	}

	private DescriptorFactory getDescriptorFactory()
	{
		if(descriptorFactory == null) {
			descriptorFactory = ApplicationBeans.getBean("integrationServicesDescriptorFactory", DescriptorFactory.class);
		}
		return descriptorFactory;	}
}
