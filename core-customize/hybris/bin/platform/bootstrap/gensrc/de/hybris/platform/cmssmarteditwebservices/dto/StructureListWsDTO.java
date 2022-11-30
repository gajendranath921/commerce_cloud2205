/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:12 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.StructureWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * The list of structures for a type code.
 *
 * @deprecated no longer needed
 */
@ApiModel(value="StructureListWsDTO", description="The list of structures for a type code.")
@Deprecated(since = "1811", forRemoval = true)
public  class StructureListWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StructureListWsDTO.structures</code> property defined at extension <code>cmssmarteditwebservices</code>. */
@ApiModelProperty(name="structures") 	
	private List<StructureWsDTO> structures;
	
	public StructureListWsDTO()
	{
		// default constructor
	}
	
	public void setStructures(final List<StructureWsDTO> structures)
	{
		this.structures = structures;
	}

	public List<StructureWsDTO> getStructures() 
	{
		return structures;
	}
	

}