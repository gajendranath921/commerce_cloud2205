/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceorgaddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.ProfileValidator;
import de.hybris.platform.b2b.constants.B2BConstants;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BSelectionData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUserGroupData;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceorgaddon.controllers.ControllerConstants;
import de.hybris.platform.commerceorgaddon.forms.B2BCustomerForm;
import de.hybris.platform.commerceorgaddon.forms.B2BPermissionForm;
import de.hybris.platform.commerceorgaddon.forms.CustomerResetPasswordForm;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.commerceservices.user.UserMatchingService;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller defines routes to manage Users within My Company section.
 */
@Controller
@RequestMapping("/my-company/organization-management/manage-users")
public class UserManagementPageController extends MyCompanyPageController
{
	private static final Logger LOG = Logger.getLogger(UserManagementPageController.class);

	@Resource(name = "profileValidator")
	private ProfileValidator profileValidator;
	@Resource(name = "commerceorgUserMatchingService")
	private UserMatchingService commerceorgUserMatchingService;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String manageUsers(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = B2BCustomerModel.NAME) final String sortCode, final Model model)
			throws CMSItemNotFoundException
	{
		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<CustomerData> searchPageData = b2bUserFacade.getPagedCustomers(pageableData);
		populateModel(model, searchPageData, showMode);

		final ContentPageModel myCompanyPage = getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE);
		storeCmsPageInModel(model, myCompanyPage);
		setUpMetaDataForContentPage(model, myCompanyPage);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.getBreadcrumbs(null);
		breadcrumbs.add(new Breadcrumb("/my-company/organization-management/manage-users", getMessageSource().getMessage(
				"text.company.manageUsers", null, getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUsersPage;
	}

	@Override
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	@RequireHardLogIn
	public String manageUserDetail(@RequestParam("user") final String user, final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("action", "manageUsers");
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return super.manageUserDetail(customer.getUid(), model);
	}

	@Override
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@RequireHardLogIn
	public String editUser(@RequestParam("user") final String user, final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("action", "manageUsers");
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return super.editUser(customer.getUid(), model);
	}

	@PostMapping(value = "/approvers/remove")
	@RequireHardLogIn
	public String removeApproverFromCustomer(@RequestParam("user") final String user,
			@RequestParam("approver") final String approver, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		b2bApproverFacade.removeApproverFromCustomer(customer.getUid(), approver);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.approver.removed");
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@Override
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@RequireHardLogIn
	public String editUser(@RequestParam("user") final String user, @Valid final B2BCustomerForm b2BCustomerForm,
			final BindingResult bindingResult, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		profileValidator.validate(b2BCustomerForm, bindingResult);
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return super.editUser(customer.getUid(), b2BCustomerForm, bindingResult, model, redirectModel);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@RequireHardLogIn
	public String createUser(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("action", "manageUsers");
		return super.createUser(model);
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@RequireHardLogIn
	public String createUser(@Valid final B2BCustomerForm b2BCustomerForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		profileValidator.validate(b2BCustomerForm, bindingResult);
		model.addAttribute("action", "manageUsers");
		return super.createUser(b2BCustomerForm, bindingResult, model, redirectModel);
	}

	@RequestMapping(value = "/disable", method = RequestMethod.GET)
	@RequireHardLogIn
	public String disableUserConfirmation(@RequestParam("user") final String user, final Model model)
			throws CMSItemNotFoundException
	{
		final ContentPageModel organizationManagementPage = getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE);
		storeCmsPageInModel(model, organizationManagementPage);
		setUpMetaDataForContentPage(model, organizationManagementPage);

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(user);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/disable?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manage.units.disable.breadcrumb", new Object[]
		{ user }, "Disable {0} Customer", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		final CustomerData customerData = b2bUserFacade.getCustomerForUid(customer.getUid());
		model.addAttribute("customerData", customerData);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserDisbaleConfirmPage;
	}

	@RequestMapping(value = "/disable", method = RequestMethod.POST)
	@RequireHardLogIn
	public String disableUser(@RequestParam("user") final String user, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		final ContentPageModel organizationManagementPage = getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE);
		storeCmsPageInModel(model, organizationManagementPage);
		setUpMetaDataForContentPage(model, organizationManagementPage);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUnitsDetailsBreadcrumbs(user);
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/disable?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manageusers.disable.breadcrumb", new Object[]
		{ user }, "Disable {0}  Customer ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		b2bUserFacade.disableCustomer(customer.getUid());
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.user.disable");

		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@RequestMapping(value = "/enable", method = RequestMethod.POST)
	@RequireHardLogIn
	public String enableUser(@RequestParam("user") final String user, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		b2bUserFacade.enableCustomer(customer.getUid());
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.user.enable");
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
	@RequireHardLogIn
	public String updatePassword(@RequestParam("user") final String user, final Model model) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);

		if (!model.containsAttribute("customerResetPasswordForm"))
		{
			final CustomerResetPasswordForm customerResetPasswordForm = new CustomerResetPasswordForm();
			customerResetPasswordForm.setUid(user);
			model.addAttribute("customerResetPasswordForm", customerResetPasswordForm);
		}
		final ContentPageModel organizationManagementPage = getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE);
		storeCmsPageInModel(model, organizationManagementPage);
		setUpMetaDataForContentPage(model, organizationManagementPage);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(customer.getUid());
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/restpassword?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manageusers.restpassword.breadcrumb", new Object[]
		{ customer.getUid() }, "Reset Password {0}  User ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserResetPasswordPage;
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	@RequireHardLogIn
	public String updatePassword(@RequestParam("user") final String user,
			@Valid final CustomerResetPasswordForm customerResetPasswordForm, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		final String userId = StringUtils.isNotBlank(customer.getCustomerID()) ? customer.getCustomerID() : customer.getUid();

		if (bindingResult.hasErrors())
		{
			model.addAttribute(customerResetPasswordForm);
			GlobalMessages.addErrorMessage(model, "form.global.error");
			return updatePassword(userId, model);
		}

		if (customerResetPasswordForm.getNewPassword().equals(customerResetPasswordForm.getCheckNewPassword()))
		{
			b2bUserFacade.resetCustomerPassword(customer.getUid(), customerResetPasswordForm.getNewPassword());
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.password.updated");
		}
		else
		{
			model.addAttribute(customerResetPasswordForm);
			bindingResult.rejectValue("checkNewPassword", "validation.checkPwd.equals", new Object[] {},
					"validation.checkPwd.equals");
			GlobalMessages.addErrorMessage(model, "form.global.error");
			return updatePassword(userId, model);
		}

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder
				.createManageUnitsDetailsBreadcrumbs(customerResetPasswordForm.getUid());
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/restpassword?user=%s",
				urlEncode(userId)), getMessageSource().getMessage(
				"text.company.manageusers.restpassword.breadcrumb", new Object[]
				{ customerResetPasswordForm.getUid() }, "Reset Password {0}  Customer ", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(userId));
	}

	@RequestMapping(value = "/approvers", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedApproversForCustomer(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("user") final String user, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		final ContentPageModel myCompanyPage = getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE);
		storeCmsPageInModel(model, myCompanyPage);
		setUpMetaDataForContentPage(model, myCompanyPage);

		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(customer.getUid());
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/approvers?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manageUsers.approvers.breadcrumb", new Object[]
		{ customer.getUid() }, "Customer {0} Approvers", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<CustomerData> searchPageData = b2bApproverFacade.getPagedApproversForCustomer(pageableData, customer.getUid());
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "approvers");
		model.addAttribute("baseUrl", "/my-company/organization-management/manage-users");
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserCustomersPage;
	}

	@ResponseBody
	@PostMapping(value = "/approvers/select")
	@RequireHardLogIn
	public B2BSelectionData selectApproverForCustomer(@RequestParam("user") final String user,
			@RequestParam("approver") final String approver) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return populateDisplayNamesForRoles(b2bApproverFacade.addApproverForCustomer(customer.getUid(), approver));
	}

	@ResponseBody
	@PostMapping(value = "/approvers/deselect")
	@RequireHardLogIn
	public B2BSelectionData deselectApproverForCustomer(@RequestParam("user") final String user,
			@RequestParam("approver") final String approver) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return populateDisplayNamesForRoles(b2bApproverFacade.removeApproverFromCustomer(customer.getUid(), approver));
	}

	@RequestMapping(value = "/permissions", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedPermissionsForCustomer(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("user") final String user, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		final ContentPageModel myCompanyPage = getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE);
		storeCmsPageInModel(model, myCompanyPage);
		setUpMetaDataForContentPage(model, myCompanyPage);

		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(customer.getUid());
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/permissions?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manage.units.permissions.breadcrumb", new Object[]
		{ customer.getUid() }, "Customer {0} Permissions", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<B2BPermissionData> searchPageData = b2bPermissionFacade.getPagedPermissionsForCustomer(pageableData, customer.getUid());
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "permissions");
		model.addAttribute("baseUrl", "/my-company/organization-management/manage-users");
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserPermissionsPage;
	}

	@ResponseBody
	@PostMapping(value = "/permissions/select")
	@RequireHardLogIn
	public B2BSelectionData selectPermissionForCustomer(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return b2bPermissionFacade.addPermissionToCustomer(customer.getUid(), permission);
	}

	@ResponseBody
	@PostMapping(value = "/permissions/deselect")
	@RequireHardLogIn
	public B2BSelectionData deselectPermissionForCustomer(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return b2bPermissionFacade.removePermissionFromCustomer(customer.getUid(), permission);
	}

	@PostMapping(value = "/permissions/remove")
	@RequireHardLogIn
	public String removeCustomersPermission(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		b2bPermissionFacade.removePermissionFromCustomer(customer.getUid(), permission);
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.permission.removed");
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@RequestMapping(value = "/permissions/confirm/remove", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String confirmRemovePermissionFromUser(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		final ContentPageModel organizationManagementPage = getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE);
		storeCmsPageInModel(model, organizationManagementPage);
		setUpMetaDataForContentPage(model, organizationManagementPage);

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb("#", getMessageSource().getMessage("text.company.users.remove.permission.confirmation",
				new Object[]
				{ permission }, "Remove Permission {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("arguments", String.format("%s, %s", permission, user));
		model.addAttribute("page", "users");
		model.addAttribute("role", "permission");
		model.addAttribute("disableUrl", String.format(request.getContextPath()
				+ "/my-company/organization-management/manage-users/permissions/remove/?user=%s&permission=%s", urlEncode(user),
				urlEncode(permission)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyRemoveDisableConfirmationPage;
	}

	@RequestMapping(value = "/approvers/confirm/remove", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String confirmRemoveApproverFromUser(@RequestParam("user") final String user,
			@RequestParam("approver") final String approver, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		final ContentPageModel organizationManagementPage = getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE);
		storeCmsPageInModel(model, organizationManagementPage);
		setUpMetaDataForContentPage(model, organizationManagementPage);

		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb("#", getMessageSource().getMessage(
				String.format("text.company.users.remove.%s.confirmation", B2BConstants.B2BAPPROVERGROUP), new Object[]
				{ approver }, "Remove B2B Approver {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("arguments", String.format("%s, %s", approver, user));
		model.addAttribute("page", "users");
		model.addAttribute("role", B2BConstants.B2BAPPROVERGROUP);
		model.addAttribute("disableUrl", String.format(request.getContextPath()
				+ "/my-company/organization-management/manage-users/approvers/remove/?user=%s&approver=%s", urlEncode(user),
				urlEncode(approver)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyRemoveDisableConfirmationPage;
	}

	@RequestMapping(value = "/usergroups", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getPagedB2BUserGroupsForCustomer(@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final AbstractSearchPageController.ShowMode showMode,
			@RequestParam(value = "sort", defaultValue = UserModel.NAME) final String sortCode,
			@RequestParam("user") final String user, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		final ContentPageModel myCompanyPage = getContentPageForLabelOrId(MY_COMPANY_CMS_PAGE);
		storeCmsPageInModel(model, myCompanyPage);
		setUpMetaDataForContentPage(model, myCompanyPage);

		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(customer.getUid());
		breadcrumbs.add(new Breadcrumb(String.format("/my-company/organization-management/manage-users/usergroups?user=%s",
				urlEncode(user)), getMessageSource().getMessage("text.company.manageUsers.usergroups.breadcrumb", new Object[]
		{ customer.getUid() }, "Customer {0} User Groups", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);

		// Handle paged search results
		final PageableData pageableData = createPageableData(page, getSearchPageSize(), sortCode, showMode);
		final SearchPageData<B2BUserGroupData> searchPageData = b2bUserFacade.getPagedB2BUserGroupsForCustomer(pageableData, customer.getUid());
		populateModel(model, searchPageData, showMode);
		model.addAttribute("action", "usergroups");
		model.addAttribute("baseUrl", "/my-company/organization-management/manage-users");
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyManageUserB2BUserGroupsPage;
	}

	@ResponseBody
	@PostMapping(value = "/usergroups/select")
	@RequireHardLogIn
	public B2BSelectionData selectB2BUserGroupForCustomer(@RequestParam("user") final String user,
			@RequestParam("usergroup") final String usergroup) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return b2bUserFacade.addB2BUserGroupToCustomer(customer.getUid(), usergroup);
	}

	@ResponseBody
	@PostMapping(value = "/usergroups/deselect")
	@RequireHardLogIn
	public B2BSelectionData deselectB2BUserGroupForCustomer(@RequestParam("user") final String user,
			@RequestParam("usergroup") final String usergroup) throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		return b2bUserFacade.deselectB2BUserGroupFromCustomer(customer.getUid(), usergroup);
	}

	@RequestMapping(value = "/usergroups/confirm/remove", method =
	{ RequestMethod.GET })
	@RequireHardLogIn
	public String confirmRemoveUserGroupFromUser(@RequestParam("user") final String user,
			@RequestParam("usergroup") final String usergroup, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		final ContentPageModel organizationManagementPage = getContentPageForLabelOrId(ORGANIZATION_MANAGEMENT_CMS_PAGE);
		storeCmsPageInModel(model, organizationManagementPage);
		setUpMetaDataForContentPage(model, organizationManagementPage);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(user);
		breadcrumbs.add(new Breadcrumb("#", getMessageSource().getMessage("text.company.users.remove.usergroup.confirmation",
				new Object[]
				{ usergroup }, "Remove User group {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		model.addAttribute("arguments", String.format("%s, %s", user, usergroup));
		model.addAttribute("page", "users");
		model.addAttribute("role", "usergroup");
		model.addAttribute("disableUrl", String.format(request.getContextPath()
				+ "/my-company/organization-management/manage-users/usergroups/remove/?user=%s&usergroup=%s", urlEncode(user),
				urlEncode(usergroup)));
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		return ControllerConstants.Views.Pages.MyCompany.MyCompanyRemoveDisableConfirmationPage;
	}

	@PostMapping(value = "/usergroups/remove")
	@RequireHardLogIn
	public String removeCustomersUserGroup(@RequestParam("user") final String user,
			@RequestParam("usergroup") final String usergroup, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		try
		{
			b2bUserFacade.removeB2BUserGroupFromCustomerGroups(customer.getUid(), usergroup);
			GlobalMessages
					.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "text.confirmation.usergroup.removed");
		}
		catch (final UnknownIdentifierException e)
		{
			if (LOG.isDebugEnabled())
			{
				LOG.debug("can not remove b2b user '" + user + "' from group '" + usergroup + "' due to, " + e.getMessage(), e);
			}
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "usergroup.notfound");
		}
		return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
	}

	@RequestMapping(value = "/edit-permission", method = RequestMethod.GET)
	@RequireHardLogIn
	public String editUsersPermission(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission, final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException
	{
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(
				"saveUrl",
				String.format("%s/my-company/organization-management/manage-users/edit-permission?user=%s&permission=%s",
						request.getContextPath(), urlEncode(user), urlEncode(permission)));

		final String editPermissionUrl = editPermission(permission, model);

		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(customer.getUid());
		breadcrumbs.add(new Breadcrumb(String.format(
				"/my-company/organization-management/manage-users/edit-permission?user=%s&permission=%s", urlEncode(user),
				urlEncode(permission)), getMessageSource().getMessage("text.company.manageusers.permission.edit", new Object[]
		{ permission }, "Edit Permission {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		return editPermissionUrl;
	}

	@RequestMapping(value = "/edit-permission", method = RequestMethod.POST)
	@RequireHardLogIn
	public String editUsersPermission(@RequestParam("user") final String user,
			@RequestParam("permission") final String permission, @Valid final B2BPermissionForm b2BPermissionForm,
			final BindingResult bindingResult, final Model model, final HttpServletRequest request,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException, ParseException
	{
		model.addAttribute("cancelUrl", getCancelUrl(MANAGE_USER_DETAILS_URL, request.getContextPath(), user));
		model.addAttribute(
				"saveUrl",
				String.format("%s/my-company/organization-management/manage-users/edit-permission?user=%s&permission=%s",
						request.getContextPath(), urlEncode(user), urlEncode(permission)));

		final String editPermissionUrl = editPermission(b2BPermissionForm, bindingResult, model, redirectModel);
		final CustomerModel customer = commerceorgUserMatchingService.getUserByProperty(user, CustomerModel.class);
		final List<Breadcrumb> breadcrumbs = myCompanyBreadcrumbBuilder.createManageUserDetailsBreadcrumb(customer.getUid());
		breadcrumbs.add(new Breadcrumb(String.format(
				"/my-company/organization-management/manage-users/edit-permission?user=%s&permission=%s", urlEncode(user),
				urlEncode(permission)), getMessageSource().getMessage("text.company.manageusers.permission.edit", new Object[]
		{ permission }, "Edit Permission {0}", getI18nService().getCurrentLocale()), null));
		model.addAttribute("breadcrumbs", breadcrumbs);
		if (bindingResult.hasErrors())
		{
			return editPermissionUrl;
		}
		else
		{
			return String.format(REDIRECT_TO_USER_DETAILS, urlEncode(user));
		}
	}
}
