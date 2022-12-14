/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.predicates;

import de.hybris.platform.cms2.model.contents.CMSItemModel;
import de.hybris.platform.cms2.servicelayer.services.AttributeDescriptorModelHelperService;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Required;


/**
 * Predicate to identify if an attribute type is assignable from {@link CMSItemModel} type.
 */
public class CMSItemAttributePredicate implements Predicate<AttributeDescriptorModel>
{
	private AttributeDescriptorModelHelperService attributeDescriptorModelHelperService;

	@Override
	public boolean test(final AttributeDescriptorModel attributeDescriptor)
	{
		final Predicate<Class<?>> isTypeOf = attributeClass -> CMSItemModel.class.isAssignableFrom(attributeClass);

		return isTypeOf.test(attributeDescriptorModelHelperService.getAttributeClass(attributeDescriptor));
	}

	protected AttributeDescriptorModelHelperService getAttributeDescriptorModelHelperService()
	{
		return attributeDescriptorModelHelperService;
	}

	@Required
	public void setAttributeDescriptorModelHelperService(
			AttributeDescriptorModelHelperService attributeDescriptorModelHelperService)
	{
		this.attributeDescriptorModelHelperService = attributeDescriptorModelHelperService;
	}
}
