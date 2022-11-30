/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:08 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservicescommons.dto.comments;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


import java.util.Objects;
/**
 * Object of the comment, which can be added to any Item in the commerce suite.
 */
@ApiModel(value="Comment", description="Object of the comment, which can be added to any Item in the commerce suite.")
public  class CommentWsDTO  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** Text of the comment.<br/><br/><i>Generated property</i> for <code>CommentWsDTO.text</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="text", value="Text of the comment.", required=true, example="Text of the comment") 	
	private String text;

	/** Date when the comment was created.<br/><br/><i>Generated property</i> for <code>CommentWsDTO.creationDate</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="creationDate", value="Date when the comment was created.", required=true, example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date creationDate;

	/** Author of the comment.<br/><br/><i>Generated property</i> for <code>CommentWsDTO.author</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="author", value="Author of the comment.") 	
	private PrincipalWsDTO author;

	/** Flag showing if the current customer was the author of the comment.<br/><br/><i>Generated property</i> for <code>CommentWsDTO.fromCustomer</code> property defined at extension <code>b2bwebservicescommons</code>. */
@ApiModelProperty(name="fromCustomer", value="Flag showing if the current customer was the author of the comment.", required=true, example="true") 	
	private Boolean fromCustomer;
	
	public CommentWsDTO()
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
	
	public void setCreationDate(final Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public Date getCreationDate() 
	{
		return creationDate;
	}
	
	public void setAuthor(final PrincipalWsDTO author)
	{
		this.author = author;
	}

	public PrincipalWsDTO getAuthor() 
	{
		return author;
	}
	
	public void setFromCustomer(final Boolean fromCustomer)
	{
		this.fromCustomer = fromCustomer;
	}

	public Boolean getFromCustomer() 
	{
		return fromCustomer;
	}
	

}