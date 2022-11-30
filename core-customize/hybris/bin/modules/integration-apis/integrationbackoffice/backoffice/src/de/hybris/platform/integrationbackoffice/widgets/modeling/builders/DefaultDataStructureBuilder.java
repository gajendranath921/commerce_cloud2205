/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationbackoffice.widgets.modeling.builders;

import static de.hybris.platform.integrationbackoffice.widgets.modeling.utility.EditorUtils.getListItemStructureType;
import static de.hybris.platform.integrationbackoffice.widgets.modeling.utility.EditorUtils.updateDTOs;

import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.integrationbackoffice.widgets.modeling.data.IntegrationObjectDefinition;
import de.hybris.platform.integrationbackoffice.widgets.modeling.data.SubtypeData;
import de.hybris.platform.integrationbackoffice.widgets.modeling.data.dto.AbstractListItemDTO;
import de.hybris.platform.integrationbackoffice.widgets.modeling.data.dto.AttributeTypeDTO;
import de.hybris.platform.integrationbackoffice.widgets.modeling.data.dto.IntegrationMapKeyDTO;
import de.hybris.platform.integrationbackoffice.widgets.modeling.data.dto.ListItemAttributeDTO;
import de.hybris.platform.integrationbackoffice.widgets.modeling.data.dto.ListItemStructureType;
import de.hybris.platform.integrationbackoffice.widgets.modeling.services.ReadService;
import de.hybris.platform.integrationbackoffice.widgets.modeling.utility.EditorAttributesFilteringService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.zkoss.zk.ui.select.annotation.WireVariable;

/**
 * Default implementation of DataStructure builder
 * Utilizes the EditorAttributeFilterService and ReadService beans
 */
public class DefaultDataStructureBuilder implements DataStructureBuilder
{
	@WireVariable
	private final EditorAttributesFilteringService editorAttrFilterService;
	@WireVariable
	private final ReadService readService;

	public DefaultDataStructureBuilder(final ReadService r, final EditorAttributesFilteringService e)
	{
		this.readService = r;
		this.editorAttrFilterService = e;

	}

	@Override
	public Map<ComposedTypeModel, List<AbstractListItemDTO>> populateAttributesMap(final ComposedTypeModel typeModel,
	                                                                               final Map<ComposedTypeModel, List<AbstractListItemDTO>> currAttrMap)
	{
		if (currAttrMap.get(typeModel) == null)
		{
			final List<AbstractListItemDTO> dtoList = new ArrayList<>();
			final Set<AttributeDescriptorModel> filteredAttributes = editorAttrFilterService.filterAttributesForAttributesMap(
					typeModel);
			filteredAttributes.forEach(attribute -> {
				final boolean selected = Optional.ofNullable(attribute.getUnique()).orElse(false)
						&& Optional.ofNullable(attribute.getOptional()).map(value -> !value).orElse(false);
				final ListItemStructureType structureType = getListItemStructureType(readService, attribute);
				final AttributeTypeDTO attributeTypeDTO = AttributeTypeDTO.builder(attribute)
				                                                          .withStructureType(structureType)
				                                                          .build();
				final ListItemAttributeDTO dto = ListItemAttributeDTO.builder(attributeTypeDTO)
				                                                     .withSelected(selected)
				                                                     .build();
				dtoList.add(dto);
			});
			currAttrMap.put(typeModel, dtoList);
		}

		return currAttrMap;
	}

	@Override
	public IntegrationObjectDefinition populateAttributesMap(final IntegrationMapKeyDTO mapKeyDTO,
	                                                         final IntegrationObjectDefinition currAttrMap)
	{
		if (currAttrMap.getAttributesByKey(mapKeyDTO).isEmpty())
		{
			final List<AbstractListItemDTO> dtoList = new ArrayList<>();
			final Set<AttributeDescriptorModel> filteredAttributes = editorAttrFilterService.filterAttributesForAttributesMap(
					mapKeyDTO.getType());
			filteredAttributes.forEach(attribute -> {
				final boolean selected = Optional.ofNullable(attribute.getUnique()).orElse(false)
						&& Optional.ofNullable(!attribute.getOptional()).orElse(false);
				final ListItemStructureType structureType = getListItemStructureType(readService, attribute);
				final AttributeTypeDTO attributeTypeDTO = AttributeTypeDTO.builder(attribute)
				                                                          .withStructureType(structureType)
				                                                          .build();
				final ListItemAttributeDTO dto = ListItemAttributeDTO.builder(attributeTypeDTO)
				                                                     .withSelected(selected)
				                                                     .build();
				dtoList.add(dto);
			});
			currAttrMap.setAttributesByKey(mapKeyDTO, dtoList);
		}

		return currAttrMap;
	}

	@Override
	public Map<ComposedTypeModel, List<AbstractListItemDTO>> loadExistingDefinitions(final Map<ComposedTypeModel, List<AbstractListItemDTO>> existingDefinitions,
	                                                                                 final Map<ComposedTypeModel, List<AbstractListItemDTO>> currAttrMap)
	{
		existingDefinitions.forEach((key, value) -> currAttrMap.forEach((key2, value2) -> {
			if (key2.equals(key))
			{
				currAttrMap.replace(key2, updateDTOs(value2, value));
			}
		}));
		return currAttrMap;
	}

	@Override
	public IntegrationObjectDefinition loadExistingDefinitions(final IntegrationObjectDefinition existingDefinitions,
	                                                           final IntegrationObjectDefinition currAttrMap)
	{
		existingDefinitions.getDefinitionMap().forEach((key, value) -> currAttrMap.getDefinitionMap().forEach((key2, value2) -> {
			if (key2.equals(key))
			{
				currAttrMap.replace(key2, updateDTOs(value2, value));
			}
		}));
		return currAttrMap;
	}

	@Override
	public Set<SubtypeData> compileSubtypeDataSet(final Map<ComposedTypeModel, List<AbstractListItemDTO>> existingDefinitions,
	                                              final Set<SubtypeData> subtypeDataSet)
	{
		final var mapWithKeys = existingDefinitions.entrySet().stream()
				.collect(Collectors.toMap(e -> new IntegrationMapKeyDTO(e.getKey()), Map.Entry::getValue));
		final var io = new IntegrationObjectDefinition(mapWithKeys);
		return compileSubtypeDataSet(io, subtypeDataSet);
	}

	@Override
	public Set<SubtypeData> compileSubtypeDataSet(final IntegrationObjectDefinition existingDefinitions,
	                                              final Set<SubtypeData> subtypeDataSet)
	{
		existingDefinitions.getDefinitionMap().forEach((key, value) -> value.stream()
		                                                                    .filter(ListItemAttributeDTO.class::isInstance)
		                                                                    .map(ListItemAttributeDTO.class::cast)
		                                                                    .filter(ListItemAttributeDTO::isSubType)
		                                                                    .map(dto -> new SubtypeData(key, dto))
		                                                                    .forEach(subtypeDataSet::add));

		return subtypeDataSet;
	}

	@Override
	public ComposedTypeModel findSubtypeMatch(final ComposedTypeModel parentType,
	                                          final String attributeQualifier,
	                                          final ComposedTypeModel attributeType,
	                                          final Set<SubtypeData> subtypeDataSet)
	{
		final var parentKey = new IntegrationMapKeyDTO(parentType);
		return findSubtypeMatch(parentKey, attributeQualifier, attributeType, subtypeDataSet);
	}

	@Override
	public ComposedTypeModel findSubtypeMatch(final IntegrationMapKeyDTO parentKey, final String attributeQualifier,
	                                          final ComposedTypeModel attributeType,
	                                          final Set<SubtypeData> subtypeDataSet)
	{
		final ComposedTypeModel attributeSubtype;
		final Optional<SubtypeData> data = subtypeDataSet.stream().filter(p -> p.getParentNodeKey().equals(parentKey)
				&& p.getBaseType().equals(attributeType) && attributeQualifier.equals(p.getAttributeQualifier())).findFirst();
		attributeSubtype = data.map(subtypeData -> readService.getComposedTypeModelFromTypeModel(subtypeData.getSubtype()))
		                       .orElse(null);
		return attributeSubtype;
	}
}
