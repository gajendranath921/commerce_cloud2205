/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.core.model.ItemModel;


import java.util.Objects;
public abstract  class AbstractEditorData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractEditorData.uid</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String uid;

	/** <i>Generated property</i> for <code>AbstractEditorData.label</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private String label;

	/** <i>Generated property</i> for <code>AbstractEditorData.valid</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean valid;

	/** <i>Generated property</i> for <code>AbstractEditorData.open</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean open;

	/** <i>Generated property</i> for <code>AbstractEditorData.fromSearchProfile</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean fromSearchProfile;

	/** <i>Generated property</i> for <code>AbstractEditorData.fromSearchConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean fromSearchConfiguration;

	/** <i>Generated property</i> for <code>AbstractEditorData.override</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean override;

	/** <i>Generated property</i> for <code>AbstractEditorData.overrideFromSearchProfile</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean overrideFromSearchProfile;

	/** <i>Generated property</i> for <code>AbstractEditorData.inSearchResult</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean inSearchResult;

	/** <i>Generated property</i> for <code>AbstractEditorData.rankUpAllowed</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean rankUpAllowed;

	/** <i>Generated property</i> for <code>AbstractEditorData.rankDownAllowed</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private boolean rankDownAllowed;

	/** <i>Generated property</i> for <code>AbstractEditorData.model</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
	
	private ItemModel model;
	
	public AbstractEditorData()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

	public String getLabel() 
	{
		return label;
	}
	
	public void setValid(final boolean valid)
	{
		this.valid = valid;
	}

	public boolean isValid() 
	{
		return valid;
	}
	
	public void setOpen(final boolean open)
	{
		this.open = open;
	}

	public boolean isOpen() 
	{
		return open;
	}
	
	public void setFromSearchProfile(final boolean fromSearchProfile)
	{
		this.fromSearchProfile = fromSearchProfile;
	}

	public boolean isFromSearchProfile() 
	{
		return fromSearchProfile;
	}
	
	public void setFromSearchConfiguration(final boolean fromSearchConfiguration)
	{
		this.fromSearchConfiguration = fromSearchConfiguration;
	}

	public boolean isFromSearchConfiguration() 
	{
		return fromSearchConfiguration;
	}
	
	public void setOverride(final boolean override)
	{
		this.override = override;
	}

	public boolean isOverride() 
	{
		return override;
	}
	
	public void setOverrideFromSearchProfile(final boolean overrideFromSearchProfile)
	{
		this.overrideFromSearchProfile = overrideFromSearchProfile;
	}

	public boolean isOverrideFromSearchProfile() 
	{
		return overrideFromSearchProfile;
	}
	
	public void setInSearchResult(final boolean inSearchResult)
	{
		this.inSearchResult = inSearchResult;
	}

	public boolean isInSearchResult() 
	{
		return inSearchResult;
	}
	
	public void setRankUpAllowed(final boolean rankUpAllowed)
	{
		this.rankUpAllowed = rankUpAllowed;
	}

	public boolean isRankUpAllowed() 
	{
		return rankUpAllowed;
	}
	
	public void setRankDownAllowed(final boolean rankDownAllowed)
	{
		this.rankDownAllowed = rankDownAllowed;
	}

	public boolean isRankDownAllowed() 
	{
		return rankDownAllowed;
	}
	
	public void setModel(final ItemModel model)
	{
		this.model = model;
	}

	public ItemModel getModel() 
	{
		return model;
	}
	

	@Override
	public boolean equals(final Object o)
	{
		if (o == null) return false;
		if (o == this) return true;

        if (getClass() != o.getClass()) return false;

		final AbstractEditorData other = (AbstractEditorData) o;
		return Objects.equals(getUid(), other.getUid());


    }

	@Override
	public int hashCode()
	{
		int result = 1;
		Object attribute;

		attribute = uid;
		result = 31 * result + (attribute == null ? 0 : attribute.hashCode());

		return result;
	}
}