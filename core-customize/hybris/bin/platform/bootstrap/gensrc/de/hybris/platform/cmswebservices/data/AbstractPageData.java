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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.Map;


import java.util.Objects;
/**
 * Specifies properties of the page.
 *
 * @deprecated no longer needed
 */
@ApiModel(value="AbstractPageData", description="Specifies properties of the page.")
@Deprecated(since = "6.6", forRemoval = true)
public  class AbstractPageData  implements Serializable 

{

	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractPageData.uuid</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="uuid") 	
	private String uuid;

	/** <i>Generated property</i> for <code>AbstractPageData.pk</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="pk", example="8796093056052") 	
	private String pk;

	/** <i>Generated property</i> for <code>AbstractPageData.creationtime</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="creationtime", example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date creationtime;

	/** <i>Generated property</i> for <code>AbstractPageData.modifiedtime</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="modifiedtime", example="yyyy-MM-dd HH:mm:ss+0000") 	
	private Date modifiedtime;

	/** <i>Generated property</i> for <code>AbstractPageData.uid</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="uid") 	
	private String uid;

	/** <i>Generated property</i> for <code>AbstractPageData.name</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="name", example="homepage") 	
	private String name;

	/** <i>Generated property</i> for <code>AbstractPageData.title</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="title", example="{\"EN\" : \"Homepage\", \"DE\" : \"Startseite\"}") 	
	private Map<String,String> title;

	/** <i>Generated property</i> for <code>AbstractPageData.typeCode</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="typeCode", example="ContentPage") 	
	private String typeCode;

	/** <i>Generated property</i> for <code>AbstractPageData.template</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="template", example="LandingPageTemplate") 	
	private String template;

	/** <i>Generated property</i> for <code>AbstractPageData.defaultPage</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="defaultPage", example="true") 	
	private Boolean defaultPage;

	/** <i>Generated property</i> for <code>AbstractPageData.onlyOneRestrictionMustApply</code> property defined at extension <code>cmswebservices</code>. */
@ApiModelProperty(name="onlyOneRestrictionMustApply", example="false") 	
	private Boolean onlyOneRestrictionMustApply;
	
	public AbstractPageData()
	{
		// default constructor
	}
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid() 
	{
		return uuid;
	}
	
	public void setPk(final String pk)
	{
		this.pk = pk;
	}

	public String getPk() 
	{
		return pk;
	}
	
	public void setCreationtime(final Date creationtime)
	{
		this.creationtime = creationtime;
	}

	public Date getCreationtime() 
	{
		return creationtime;
	}
	
	public void setModifiedtime(final Date modifiedtime)
	{
		this.modifiedtime = modifiedtime;
	}

	public Date getModifiedtime() 
	{
		return modifiedtime;
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setTitle(final Map<String,String> title)
	{
		this.title = title;
	}

	public Map<String,String> getTitle() 
	{
		return title;
	}
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

	public String getTypeCode() 
	{
		return typeCode;
	}
	
	public void setTemplate(final String template)
	{
		this.template = template;
	}

	public String getTemplate() 
	{
		return template;
	}
	
	public void setDefaultPage(final Boolean defaultPage)
	{
		this.defaultPage = defaultPage;
	}

	public Boolean getDefaultPage() 
	{
		return defaultPage;
	}
	
	public void setOnlyOneRestrictionMustApply(final Boolean onlyOneRestrictionMustApply)
	{
		this.onlyOneRestrictionMustApply = onlyOneRestrictionMustApply;
	}

	public Boolean getOnlyOneRestrictionMustApply() 
	{
		return onlyOneRestrictionMustApply;
	}
	

}