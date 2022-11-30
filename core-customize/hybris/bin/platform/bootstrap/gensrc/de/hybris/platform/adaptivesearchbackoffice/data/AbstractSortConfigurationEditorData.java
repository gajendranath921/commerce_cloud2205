/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:07 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsSortConfiguration;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractEditorData;
import java.util.Map;


import java.util.Objects;
public  class AbstractSortConfigurationEditorData extends AbstractEditorData 

{



	/** <i>Generated property</i> for <code>AbstractSortConfigurationEditorData.code</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>AbstractSortConfigurationEditorData.name</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>AbstractSortConfigurationEditorData.priority</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private Integer priority;

	/** <i>Generated property</i> for <code>AbstractSortConfigurationEditorData.sortConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AbstractAsSortConfiguration sortConfiguration;
	
	public AbstractSortConfigurationEditorData()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

	public Map<String,String> getName() 
	{
		return name;
	}
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

	public Integer getPriority() 
	{
		return priority;
	}
	
	public void setSortConfiguration(final AbstractAsSortConfiguration sortConfiguration)
	{
		this.sortConfiguration = sortConfiguration;
	}

	public AbstractAsSortConfiguration getSortConfiguration() 
	{
		return sortConfiguration;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final AbstractSortConfigurationEditorData other = (AbstractSortConfigurationEditorData) o;
		return Objects.equals(getCode(), other.getCode())

			&& Objects.equals(getName(), other.getName())

			&& Objects.equals(getPriority(), other.getPriority());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = code;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = name;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = priority;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}