/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.util.models;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.model.relations.ContentSlotForPageModel;
import de.hybris.platform.cms2.model.relations.ContentSlotForTemplateModel;
import de.hybris.platform.cmsfacades.util.builder.ContentSlotForPageModelBuilder;
import de.hybris.platform.cmsfacades.util.builder.ContentSlotForTemplateModelBuilder;
import de.hybris.platform.cmsfacades.util.dao.impl.ContentSlotForTemplateDao;

import org.springframework.beans.factory.annotation.Required;


public class ContentSlotForTemplateModelMother extends AbstractModelMother<ContentSlotForTemplateModel>
{
	public static final String UID_HEADER_HOMEPAGE = "uid-header-homepage-template-relation";
	public static final String UID_FOOTER_HOMEPAGE = "uid-footer-homepage-template-relation";
	public static final String UID_FOOTER_SEARCH_PAGE = "uid-footer-search-template-relation";

	private ContentSlotForTemplateDao contentSlotForTemplateDao;
	private ContentSlotModelMother contentSlotModelMother;
	private PageTemplateModelMother pageTemplateModelMother;

	public ContentSlotForTemplateModel FooterHomepage(final CatalogVersionModel catalogVersion)
	{
		return getOrSaveAndReturn( //
				() -> contentSlotForTemplateDao.getByUidAndCatalogVersion(UID_FOOTER_HOMEPAGE, catalogVersion), //
				() -> ContentSlotForTemplateModelBuilder.aModel() //
				.withUid(UID_FOOTER_HOMEPAGE) //
				.withCatalogVersion(catalogVersion) //
				.withAllowOverwrite(Boolean.TRUE) //
				.withContentSlot(contentSlotModelMother.createFooterEmptySlot(catalogVersion)) //
				.withPageTemplate(pageTemplateModelMother.homepageTemplate(catalogVersion)) //
				.withPosition(ContentSlotNameModelMother.NAME_FOOTER) //
				.build());
	}

	public ContentSlotForTemplateModel FooterHomepage_ParagraphOnly(final CatalogVersionModel catalogVersion)
	{
		return getOrSaveAndReturn( //
				() -> contentSlotForTemplateDao.getByUidAndCatalogVersion(UID_FOOTER_HOMEPAGE, catalogVersion), //
				() -> ContentSlotForTemplateModelBuilder.aModel() //
						.withUid(UID_FOOTER_HOMEPAGE) //
						.withCatalogVersion(catalogVersion) //
						.withAllowOverwrite(Boolean.TRUE) //
						.withContentSlot(getContentSlotModelMother().createFooterSlotWithParagraph(catalogVersion)) //
						.withPageTemplate(pageTemplateModelMother.homepageTemplate(catalogVersion)) //
						.withPosition(ContentSlotNameModelMother.NAME_FOOTER) //
						.build());
	}

	public ContentSlotForTemplateModel FooterHomepage_SharedParagraphOnly(final CatalogVersionModel catalogVersion)
	{
		return getOrSaveAndReturn( //
				() -> contentSlotForTemplateDao.getByUidAndCatalogVersion(UID_FOOTER_HOMEPAGE, catalogVersion), //
				() -> ContentSlotForTemplateModelBuilder.aModel() //
						.withUid(UID_FOOTER_HOMEPAGE) //
						.withCatalogVersion(catalogVersion) //
						.withAllowOverwrite(Boolean.TRUE) //
						.withContentSlot(getContentSlotModelMother().createFooterSlotWithSharedParagraph(catalogVersion)) //
						.withPageTemplate(pageTemplateModelMother.homepageTemplate(catalogVersion)) //
						.withPosition(ContentSlotNameModelMother.NAME_FOOTER) //
						.build());
	}

	public ContentSlotForTemplateModel FooterSearchPage(final CatalogVersionModel catalogVersion)
	{
		return getOrSaveAndReturn( //
				() -> contentSlotForTemplateDao.getByUidAndCatalogVersion(UID_FOOTER_SEARCH_PAGE, catalogVersion), //
				() -> ContentSlotForTemplateModelBuilder.aModel() //
				.withUid(UID_FOOTER_SEARCH_PAGE) //
				.withCatalogVersion(catalogVersion) //
				.withAllowOverwrite(Boolean.TRUE) //
				.withContentSlot(contentSlotModelMother.createFooterEmptySlot(catalogVersion)) //
				.withPageTemplate(pageTemplateModelMother.searchPageTemplate(catalogVersion)) //
				.withPosition(ContentSlotNameModelMother.NAME_FOOTER) //
				.build());
	}

	protected ContentSlotForTemplateDao getContentSlotForTemplateDao()
	{
		return contentSlotForTemplateDao;
	}

	@Required
	public void setContentSlotForTemplateDao(final ContentSlotForTemplateDao contentSlotForTemplateDao)
	{
		this.contentSlotForTemplateDao = contentSlotForTemplateDao;
	}

	protected ContentSlotModelMother getContentSlotModelMother()
	{
		return contentSlotModelMother;
	}

	@Required
	public void setContentSlotModelMother(final ContentSlotModelMother contentSlotModelMother)
	{
		this.contentSlotModelMother = contentSlotModelMother;
	}

	protected PageTemplateModelMother getPageTemplateModelMother()
	{
		return pageTemplateModelMother;
	}

	@Required
	public void setPageTemplateModelMother(final PageTemplateModelMother pageTemplateModelMother)
	{
		this.pageTemplateModelMother = pageTemplateModelMother;
	}

}
