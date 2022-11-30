/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;


import java.util.Objects;
/**
 * Example of DTO with map
 */
@ApiModel(value="testMap", description="Example of DTO with map")
public  class TestMapWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TestMapWsDTO.stringMap</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="stringMap") 	
	private Map<String,String> stringMap;

	/** <i>Generated property</i> for <code>TestMapWsDTO.integerMap</code> property defined at extension <code>ywebservices</code>. */
@ApiModelProperty(name="integerMap") 	
	private Map<String,Integer> integerMap;
	
	public TestMapWsDTO()
	{
		// default constructor
	}
	
	public void setStringMap(final Map<String,String> stringMap)
	{
		this.stringMap = stringMap;
	}

	public Map<String,String> getStringMap() 
	{
		return stringMap;
	}
	
	public void setIntegerMap(final Map<String,Integer> integerMap)
	{
		this.integerMap = integerMap;
	}

	public Map<String,Integer> getIntegerMap() 
	{
		return integerMap;
	}
	

}