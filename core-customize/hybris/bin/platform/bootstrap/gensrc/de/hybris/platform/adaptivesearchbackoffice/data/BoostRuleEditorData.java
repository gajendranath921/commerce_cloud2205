/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsBoostRuleConfiguration;
import de.hybris.platform.adaptivesearch.enums.AsBoostType;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractBoostRuleConfigurationEditorData;


import java.util.Objects;
public  class BoostRuleEditorData extends AbstractBoostRuleConfigurationEditorData 

{



	/** <i>Generated property</i> for <code>BoostRuleEditorData.indexProperty</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String indexProperty;

	/** <i>Generated property</i> for <code>BoostRuleEditorData.boostType</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AsBoostType boostType;

	/** <i>Generated property</i> for <code>BoostRuleEditorData.boostTypeSymbol</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String boostTypeSymbol;

	/** <i>Generated property</i> for <code>BoostRuleEditorData.boost</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private Float boost;

	/** <i>Generated property</i> for <code>BoostRuleEditorData.boostRuleConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private AbstractAsBoostRuleConfiguration boostRuleConfiguration;
	
	public BoostRuleEditorData()
	{
		// default constructor
	}
	
	public void setIndexProperty(final String indexProperty)
	{
		this.indexProperty = indexProperty;
	}

	public String getIndexProperty() 
	{
		return indexProperty;
	}
	
	public void setBoostType(final AsBoostType boostType)
	{
		this.boostType = boostType;
	}

	public AsBoostType getBoostType() 
	{
		return boostType;
	}
	
	public void setBoostTypeSymbol(final String boostTypeSymbol)
	{
		this.boostTypeSymbol = boostTypeSymbol;
	}

	public String getBoostTypeSymbol() 
	{
		return boostTypeSymbol;
	}
	
	public void setBoost(final Float boost)
	{
		this.boost = boost;
	}

	public Float getBoost() 
	{
		return boost;
	}
	
	public void setBoostRuleConfiguration(final AbstractAsBoostRuleConfiguration boostRuleConfiguration)
	{
		this.boostRuleConfiguration = boostRuleConfiguration;
	}

	public AbstractAsBoostRuleConfiguration getBoostRuleConfiguration() 
	{
		return boostRuleConfiguration;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final BoostRuleEditorData other = (BoostRuleEditorData) o;
		return Objects.equals(getIndexProperty(), other.getIndexProperty())

			&& Objects.equals(getBoostType(), other.getBoostType())

			&& Objects.equals(getBoostTypeSymbol(), other.getBoostTypeSymbol())

			&& Objects.equals(getBoost(), other.getBoost());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = indexProperty;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = boostType;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = boostTypeSymbol;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());
		attribute = boost;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}