/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:11 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.comments;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Object of the comment, which can be used to add a comment.
 */
@ApiModel(value="CreateComment", description="Object of the comment, which can be used to add a comment.")
public  class CreateCommentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Text of the comment.<br/><br/><i>Generated property</i> for <code>CreateCommentWsDTO.text</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="text", value="Text of the comment.", required=true, example="Text of the comment") 	
	private String text;
	
	public CreateCommentWsDTO()
	{
		// default constructor
	}
	
	public void setText(final String text)
	{
		this.text = text;
	}

	public String getText() 
	{
		return text;
	}
	

}