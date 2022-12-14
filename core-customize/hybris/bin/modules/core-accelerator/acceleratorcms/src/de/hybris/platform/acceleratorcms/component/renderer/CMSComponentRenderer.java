/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorcms.component.renderer;

import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

/**
 */
public interface CMSComponentRenderer<T extends AbstractCMSComponentModel>
{
	/**
	 * Render a CMS Component into the page at the current location.
	 *
	 * @param pageContext The page context to render into
	 * @param component The component to render
	 * @throws ServletException
	 * @throws IOException
	 */
	void renderComponent(PageContext pageContext, T component) throws ServletException, IOException; 
	// It is possible for this class to be extended or for methods to be used in other extensions - so no sonar added
}
