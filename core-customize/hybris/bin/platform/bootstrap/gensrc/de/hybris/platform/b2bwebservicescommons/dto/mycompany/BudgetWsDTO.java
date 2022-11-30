/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bwebservicescommons.dto.mycompany;

import de.hybris.platform.b2bwebservicescommons.dto.company.B2BCostCenterWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.company.B2BUnitWsDTO;
import de.hybris.platform.b2bwebservicescommons.dto.mycompany.BudgetBaseWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Request body fields required and optional to operate on Budget data.
		This bean may have relationships to other Org Unit WsDTO, whose type are WsDTO beans as well.
 */
@ApiModel(value="Budget", description="Request body fields required and optional to operate on Budget data. This bean may have relationships to other Org Unit WsDTO, whose type are WsDTO beans as well.")
public  class BudgetWsDTO extends BudgetBaseWsDTO 

{



	/** The unit of the Budget<br/><br/><i>Generated property</i> for <code>BudgetWsDTO.orgUnit</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="orgUnit", value="The unit of the Budget", example="Rustic") 	
	private B2BUnitWsDTO orgUnit;

	/** List of Cost Centers<br/><br/><i>Generated property</i> for <code>BudgetWsDTO.costCenters</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="costCenters", value="List of Cost Centers") 	
	private List<B2BCostCenterWsDTO> costCenters;
	
	public BudgetWsDTO()
	{
		// default constructor
	}
	
	public void setOrgUnit(final B2BUnitWsDTO orgUnit)
	{
		this.orgUnit = orgUnit;
	}

	public B2BUnitWsDTO getOrgUnit() 
	{
		return orgUnit;
	}
	
	public void setCostCenters(final List<B2BCostCenterWsDTO> costCenters)
	{
		this.costCenters = costCenters;
	}

	public List<B2BCostCenterWsDTO> getCostCenters() 
	{
		return costCenters;
	}
	

}