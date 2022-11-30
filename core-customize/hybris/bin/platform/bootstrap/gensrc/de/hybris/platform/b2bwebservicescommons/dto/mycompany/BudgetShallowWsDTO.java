/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.mycompany;

import de.hybris.platform.b2bwebservicescommons.dto.mycompany.BudgetBaseWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on Budget data.
		This bean is shallow, which means its potential relationship fields to other Org Unit fields are simple ids.
		No Org Unit WsDTO should be declared in this bean to avoid circular references.
 */
@ApiModel(value="BudgetShallow", description="Request body fields required and optional to operate on Budget data. This bean is shallow, which means its potential relationship fields to other Org Unit fields are simple ids. No Org Unit WsDTO should be declared in this bean to avoid circular references.")
public  class BudgetShallowWsDTO extends BudgetBaseWsDTO 

{


	
	public BudgetShallowWsDTO()
	{
		// default constructor
	}
	

}