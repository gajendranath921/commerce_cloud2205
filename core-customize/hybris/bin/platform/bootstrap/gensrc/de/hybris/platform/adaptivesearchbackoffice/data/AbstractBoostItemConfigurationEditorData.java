/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsBoostItemConfiguration;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractEditorData;
import de.hybris.platform.core.PK;


import java.util.Objects;
public  class AbstractBoostItemConfigurationEditorData extends AbstractEditorData 

{



	/** <i>Generated property</i> for <code>AbstractBoostItemConfigurationEditorData.itemPk</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private PK itemPk;

	/** <i>Generated property</i> for <code>AbstractBoostItemConfigurationEditorData.boostItemConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AbstractAsBoostItemConfiguration boostItemConfiguration;
	
	public AbstractBoostItemConfigurationEditorData()
	{
		// default constructor
	}
	
	public void setItemPk(final PK itemPk)
	{
		this.itemPk = itemPk;
	}

	public PK getItemPk() 
	{
		return itemPk;
	}
	
	public void setBoostItemConfiguration(final AbstractAsBoostItemConfiguration boostItemConfiguration)
	{
		this.boostItemConfiguration = boostItemConfiguration;
	}

	public AbstractAsBoostItemConfiguration getBoostItemConfiguration() 
	{
		return boostItemConfiguration;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final AbstractBoostItemConfigurationEditorData other = (AbstractBoostItemConfigurationEditorData) o;
		return Objects.equals(getItemPk(), other.getItemPk());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = itemPk;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}