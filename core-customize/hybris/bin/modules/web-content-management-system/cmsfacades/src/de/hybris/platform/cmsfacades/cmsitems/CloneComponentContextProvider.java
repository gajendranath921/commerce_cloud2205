/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems;

import java.util.Map.Entry;


/**
 * Interface responsible for storing (in a stack-like data structure) context information per transaction when cloning a
 * component.
 *
 * The provider will store information using the following keys:
 * <ul>
 * <li>{@link de.hybris.platform.cmsfacades.constants.CmsfacadesConstants#SESSION_CLONE_COMPONENT_CLONE_MODEL}
 * 	<ul>
 * 		<li>Used to store the clone component Model representation
 * 	</ul>
 * <li>{@link de.hybris.platform.cmsfacades.constants.CmsfacadesConstants#SESSION_CLONE_COMPONENT_SOURCE_MAP}
 * 	<ul>
 * 		<li>Used to store the source component {@code Map} representation
 * 	</ul>
 * <li>{@link de.hybris.platform.cmsfacades.constants.CmsfacadesConstants#SESSION_CLONE_COMPONENT_SOURCE_ATTRIBUTE}
 * 	<ul>
 * 		<li>Used to store the source component attribute value or {@code Map} representation
 * 	</ul>
 * <li>{@link de.hybris.platform.cmsfacades.constants.CmsfacadesConstants#SESSION_CLONE_COMPONENT_LOCALE}
 * 	<ul>
 * 		<li>Used to store the current {@code Locale} when processing a localized attribute
 * 	</ul>
 * </ul>
 */
public interface CloneComponentContextProvider extends CMSItemContextProvider<Entry<String, Object>>
{
	/**
	 * Read value from {@link Entry} without removing it from the stack
	 *
	 * @param key
	 *           the key of the {@link Entry}
	 * @return the value associated to the given key in the {@link Entry}; can be <tt>null</tt> when the key is not found
	 */
	Object findItemForKey(String key);

	/**
	 * Verify that the clone component operation is being executed by checking if some clone component information has
	 * been saved in the session.
	 *
	 * @return <tt>TRUE</tt> when clone component information was stored in session; <tt>FALSE</tt> otherwise
	 */
	boolean isInitialized();

}
