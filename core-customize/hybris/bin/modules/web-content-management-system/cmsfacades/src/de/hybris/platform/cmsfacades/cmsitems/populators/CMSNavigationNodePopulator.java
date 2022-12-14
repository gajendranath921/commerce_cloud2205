/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.populators;

import java.util.Map;

import de.hybris.platform.cms2.model.navigation.CMSNavigationNodeModel;
import de.hybris.platform.cms2.servicelayer.services.CMSNavigationService;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.beans.factory.annotation.Required;

/**
 * CMS Navigation node model populator.
 */
public class CMSNavigationNodePopulator implements Populator<Map<String, Object>, CMSNavigationNodeModel>
{

    private CMSNavigationService cmsNavigationService;

    @Override
    public void populate(final Map<String, Object> source, final CMSNavigationNodeModel cmsNavigationNode) throws ConversionException
    {
        if (cmsNavigationNode == null)
        {
            throw new ConversionException("CMSNavigationNodeModel used in the populator should not be null.");
        }

        setSuperRootNode(cmsNavigationNode);
    }

    /**
     * Populates the super root node if no parent is provided.
     * @param cmsNavigationNode the node to populate
     */
    protected void setSuperRootNode(final CMSNavigationNodeModel cmsNavigationNode)
    {
        if (cmsNavigationNode.getParent() != null ||
                getCmsNavigationService().isSuperRootNavigationNode(cmsNavigationNode)) {
            return;
        }

        getCmsNavigationService()
                .setSuperRootNodeOnNavigationNode(cmsNavigationNode, cmsNavigationNode.getCatalogVersion());
    }

    protected CMSNavigationService getCmsNavigationService()
    {
        return cmsNavigationService;
    }

    @Required
    public void setCmsNavigationService(final CMSNavigationService cmsNavigationService)
    {
        this.cmsNavigationService = cmsNavigationService;
    }

}
