/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.NavigationNodeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available navigation nodes.
 */
@ApiModel(value="NavigationNodeListData", description="Specifies a list of available navigation nodes.")
public  class NavigationNodeListData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationNodeListData.navigationNodes</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="navigationNodes") 	
	private List<NavigationNodeData> navigationNodes;
	
	public NavigationNodeListData()
	{
		// default constructor
	}
	
	public void setNavigationNodes(final List<NavigationNodeData> navigationNodes)
	{
		this.navigationNodes = navigationNodes;
	}

	public List<NavigationNodeData> getNavigationNodes() 
	{
		return navigationNodes;
	}
	

}