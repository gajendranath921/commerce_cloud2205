/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.company;

import java.io.Serializable;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitNodeWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Representation of an organizational unit node list
 */
@ApiModel(value="B2BUnitNodeList", description="Representation of an organizational unit node list")
public  class B2BUnitNodeListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** List of Unit Nodes<br/><br/><i>Generated property</i> for <code>B2BUnitNodeListWsDTO.unitNodes</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="unitNodes", value="List of Unit Nodes", required=true) 	
	private List<B2BUnitNodeWsDTO> unitNodes;
	
	public B2BUnitNodeListWsDTO()
	{
		// default constructor
	}
	
	public void setUnitNodes(final List<B2BUnitNodeWsDTO> unitNodes)
	{
		this.unitNodes = unitNodes;
	}

	public List<B2BUnitNodeWsDTO> getUnitNodes() 
	{
		return unitNodes;
	}
	

}