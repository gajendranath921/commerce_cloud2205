/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 30-Nov-2022, 4:57:10 pm
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.ordermanagementwebservices.dto.workflow;

import java.io.Serializable;
import de.hybris.platform.ordermanagementwebservices.dto.workflow.WorkflowActionAttachmentItemData;
import java.util.Date;
import java.util.List;


import java.util.Objects;
public  class WorkflowActionWsDto  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WorkflowActionWsDto.code</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String code;

	/** <i>Generated property</i> for <code>WorkflowActionWsDto.name</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String name;

	/** <i>Generated property</i> for <code>WorkflowActionWsDto.comment</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String comment;

	/** <i>Generated property</i> for <code>WorkflowActionWsDto.description</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String description;

	/** <i>Generated property</i> for <code>WorkflowActionWsDto.creationTime</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private Date creationTime;

	/** <i>Generated property</i> for <code>WorkflowActionWsDto.workflowCode</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private String workflowCode;

	/** <i>Generated property</i> for <code>WorkflowActionWsDto.attachmentItems</code> property defined at extension <code>ordermanagementwebservices</code>. */
	
	private List<WorkflowActionAttachmentItemData> attachmentItems;
	
	public WorkflowActionWsDto()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setCreationTime(final Date creationTime)
	{
		this.creationTime = creationTime;
	}

	public Date getCreationTime() 
	{
		return creationTime;
	}
	
	public void setWorkflowCode(final String workflowCode)
	{
		this.workflowCode = workflowCode;
	}

	public String getWorkflowCode() 
	{
		return workflowCode;
	}
	
	public void setAttachmentItems(final List<WorkflowActionAttachmentItemData> attachmentItems)
	{
		this.attachmentItems = attachmentItems;
	}

	public List<WorkflowActionAttachmentItemData> getAttachmentItems() 
	{
		return attachmentItems;
	}
	

}