/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesepaymentaddon.controllers.pages.checkout.steps;

import de.hybris.platform.acceleratorservices.enums.CheckoutPciOptionEnum;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.checkout.steps.CheckoutStep;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.PlaceOrderForm;
import de.hybris.platform.chinesepaymentaddon.constants.ControllerConstants;
import de.hybris.platform.chinesepaymentaddon.controllers.pages.checkout.steps.imported.SummaryCheckoutStepController;
import de.hybris.platform.chinesepaymentfacades.checkout.ChineseCheckoutFacade;
import de.hybris.platform.chinesepaymentservices.checkout.strategies.ChinesePaymentServicesStrategy;
import de.hybris.platform.chinesepaymentservices.payment.ChinesePaymentService;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.enums.PaymentStatus;
import de.hybris.platform.payment.AdapterException;
import de.hybris.platform.servicelayer.exceptions.BusinessException;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Scope("tenant")
@RequestMapping(value = "/checkout/multi/summary")
public class ChineseSummaryCheckoutStepController extends SummaryCheckoutStepController
{
	private static final Logger LOG = Logger.getLogger(ChineseSummaryCheckoutStepController.class);

	private static final String SUMMARY = "summary";

	private static final String REDIRECT_URL_CHINESE_ORDER_CONFIRMATION = REDIRECT_PREFIX + "/checkout/orderConfirmation/";

	private static final String REDIRECT_URL_CHINESE_HOP_PAYMENT = REDIRECT_PREFIX + "/checkout/multi/summary/hop-payment/";

	private static final String ORDER_CODE_PATH_VARIABLE_PATTERN = "{orderCode:.*}";

	private static final String PAYMENT_SERVICE_PROVIDER_PATH_VARIABLE_PATTERN = "{paymentServiceProvider}";

	@Resource(name = "chineseCheckoutFacade")
	private ChineseCheckoutFacade chineseCheckoutFacade;

	@Resource(name = "orderFacade")
	private OrderFacade orderFacade;

	@Resource(name = "chinesePaymentServicesStrategy")
	private ChinesePaymentServicesStrategy chinesePaymentServicesStrategy;

	@Override
	protected ChineseCheckoutFacade getCheckoutFacade()
	{
		return chineseCheckoutFacade;
	}


	@Override
	@RequestMapping(value = "/placeOrder")
	@RequireHardLogIn
	public String placeOrder(@ModelAttribute("placeOrderForm") final PlaceOrderForm placeOrderForm, final Model model,
			final HttpServletRequest request, final RedirectAttributes redirectModel) throws CMSItemNotFoundException,
	CommerceCartModificationException
	{
		if (validateCart(redirectModel))
		{
			return REDIRECT_PREFIX + "/cart";
		}

		if (validateOrderForm(placeOrderForm, model))
		{
			return enterStep(model, redirectModel);
		}

		// authorize, if failure occurs don't allow to place the order
		boolean isPaymentUthorized = false;
		try
		{
			isPaymentUthorized = getCheckoutFacade().authorizePayment(placeOrderForm.getSecurityCode());
		}
		catch (final AdapterException ae)
		{
			// handle a case where a wrong paymentProvider configurations on the store see getCommerceCheckoutService().getPaymentProvider()
			LOG.error("Wrong paymentProvider configurations on current store");
		}
		if (!isPaymentUthorized)
		{
			GlobalMessages.addErrorMessage(model, "checkout.error.authorization.failed");
			return enterStep(model, redirectModel);
		}

		final OrderData orderData;
		try
		{
			orderData = getCheckoutFacade().createOrder();
		}
		catch (final BusinessException e)
		{
			LOG.error("Failed to place Order");
			GlobalMessages.addErrorMessage(model, "checkout.placeOrder.failed");
			return enterStep(model, redirectModel);
		}

		model.addAttribute("orderData", orderData);
		setCheckoutStepLinksForModel(model, getCheckoutStep());
		model.addAttribute(WebConstants.BREADCRUMBS_KEY,
				getResourceBreadcrumbBuilder().getBreadcrumbs("checkout.multi.summary.breadcrumb"));
		final ContentPageModel multiCheckoutSummaryPage = getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL);
		storeCmsPageInModel(model, multiCheckoutSummaryPage);
		setUpMetaDataForContentPage(model, multiCheckoutSummaryPage);
		final ChinesePaymentService chinesePaymentService = chinesePaymentServicesStrategy.getPaymentService(orderData
				.getChinesePaymentInfo().getPaymentProvider());
		chinesePaymentService.updatePaymentInfoForPlaceOrder(orderData.getCode());
		return REDIRECT_URL_CHINESE_HOP_PAYMENT
				+ (getCheckoutCustomerStrategy().isAnonymousCheckout() ? orderData.getGuid() : orderData.getCode());
	}

	@GetMapping(value = "/hop-payment/" + ORDER_CODE_PATH_VARIABLE_PATTERN)
	@RequireHardLogIn
	public String hopPayment(@PathVariable("orderCode") final String orderCode, final Model model) throws CMSItemNotFoundException
	{
		final OrderData orderData = chineseCheckoutFacade.syncPaymentStatusForOrder(orderCode);
		if (orderData != null)
		{
			final PaymentStatus paymentStatus = orderData.getPaymentStatus();
			if (PaymentStatus.PAID.equals(paymentStatus) || !OrderStatus.CREATED.equals(orderData.getStatus()))
			{
				return redirectToOrderConfirmationPage(orderData);
			}
			model.addAttribute("orderData", orderData);
			setCheckoutStepLinksForModel(model, getCheckoutStep());
			model.addAttribute(WebConstants.BREADCRUMBS_KEY,
					getResourceBreadcrumbBuilder().getBreadcrumbs("checkout.multi.summary.breadcrumb"));
			model.addAttribute("payInNewWindow", chineseCheckoutFacade.needPayInNewWindow());

			final ContentPageModel hopPaymentPage = getContentPageForLabelOrId("hopPayment");
			storeCmsPageInModel(model, hopPaymentPage);
			setUpMetaDataForContentPage(model, hopPaymentPage);

			return getViewForPage(hopPaymentPage);
		}
		return REDIRECT_PREFIX + "/cart";
	}

	@GetMapping(value = "/payRightNow/" + ORDER_CODE_PATH_VARIABLE_PATTERN)
	@RequireHardLogIn
	public String doPayment(@PathVariable("orderCode") final String orderCode, final HttpServletRequest request,
			final HttpServletResponse response) throws CMSItemNotFoundException,
	CommerceCartModificationException, IOException
	{
		final String url = chineseCheckoutFacade.buildPaymentRequestUrl(orderCode);
		chineseCheckoutFacade.submitOrder(orderCode);
		return REDIRECT_PREFIX + url;
	}


	@GetMapping(value = "/checkPaymentResult/" + ORDER_CODE_PATH_VARIABLE_PATTERN)
	@RequireHardLogIn
	public String checkPaymentResult(final Model model, @PathVariable("orderCode") final String orderCode)
			throws CMSItemNotFoundException, CommerceCartModificationException
	{
		final OrderData orderData = chineseCheckoutFacade.syncPaymentStatusForOrder(orderCode);
		final PaymentStatus paymentstatus = orderData.getPaymentStatus();
		if (PaymentStatus.PAID.equals(paymentstatus))
		{
			return redirectToOrderConfirmationPage(orderData);
		}
		else
		{
			final ContentPageModel multiCheckoutSummaryPage = getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL);
			storeCmsPageInModel(model, multiCheckoutSummaryPage);
			setUpMetaDataForContentPage(model, multiCheckoutSummaryPage);
			model.addAttribute("isAnonymousUser", this.getUserFacade().isAnonymousUser());

			return ControllerConstants.Views.Pages.MultiStepCheckout.PaymentFailedPage;
		}
	}

	@RequestMapping(value = "/" + PAYMENT_SERVICE_PROVIDER_PATH_VARIABLE_PATTERN + "/pspasynresponse/*")
	public void handleAsynResponse(@PathVariable("paymentServiceProvider") final String paymentServiceProvider,
			final HttpServletRequest request, final HttpServletResponse response) throws CMSItemNotFoundException,
	CommerceCartModificationException, IOException
	{
		final ChinesePaymentService chinesePaymentService = chinesePaymentServicesStrategy
				.getPaymentService(paymentServiceProvider);
		chinesePaymentService.handleAsyncResponse(request, response);
	}

	@RequestMapping(value = "/" + PAYMENT_SERVICE_PROVIDER_PATH_VARIABLE_PATTERN + "/pspsyncresponse/*")
	public String handleSyncResponse(@PathVariable("paymentServiceProvider") final String paymentServiceProvider,
			final HttpServletRequest request, final HttpServletResponse response, final Model model)
					throws CMSItemNotFoundException, CommerceCartModificationException, IOException
	{
		final ChinesePaymentService chinesePaymentService = chinesePaymentServicesStrategy
				.getPaymentService(paymentServiceProvider);
		final String orderCode = chinesePaymentService.handleSyncResponse(request, response);
		if (orderCode != null)
		{
			final OrderData orderData = orderFacade.getOrderDetailsForCode(orderCode);
			final PaymentStatus paymentStatus = orderData.getPaymentStatus();
			model.addAttribute("paymentStatus", PaymentStatus.PAID.equals(paymentStatus) ? "true" : "false");
		}
		else
		{
			model.addAttribute("paymentStatus", "notFound");
		}
		final ContentPageModel multiCheckoutSummaryPage = getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL);
		storeCmsPageInModel(model, multiCheckoutSummaryPage);
		setUpMetaDataForContentPage(model, multiCheckoutSummaryPage);
		return ControllerConstants.Views.Pages.MultiStepCheckout.HopReturnPage;
	}

	/**
	 * Validates the order form before to filter out invalid order states
	 *
	 * @param placeOrderForm
	 *           The spring form of the order being submitted
	 * @param model
	 *           A spring Model
	 * @return True if the order form is invalid and false if everything is valid.
	 */
	@Override
	protected boolean validateOrderForm(final PlaceOrderForm placeOrderForm, final Model model)
	{
		final String securityCode = placeOrderForm.getSecurityCode();
		boolean invalid = false;

		if (getCheckoutFlowFacade().hasNoDeliveryAddress())
		{
			GlobalMessages.addErrorMessage(model, "checkout.deliveryAddress.notSelected");
			invalid = true;
		}

		if (getCheckoutFlowFacade().hasNoDeliveryMode())
		{
			GlobalMessages.addErrorMessage(model, "checkout.deliveryMethod.notSelected");
			invalid = true;
		}

		if (chineseCheckoutFacade.hasNoChinesePaymentInfo())
		{
			GlobalMessages.addErrorMessage(model, "checkout.paymentMethod.notSelected");
			invalid = true;
		}
		else
		{
			// Only require the Security Code to be entered on the summary page if the SubscriptionPciOption is set to Default.
			if (CheckoutPciOptionEnum.DEFAULT.equals(getCheckoutFlowFacade().getSubscriptionPciOption())
					&& StringUtils.isBlank(securityCode))
			{
				GlobalMessages.addErrorMessage(model, "checkout.paymentMethod.noSecurityCode");
				invalid = true;
			}
		}

		if (!placeOrderForm.isTermsCheck())
		{
			GlobalMessages.addErrorMessage(model, "checkout.error.terms.not.accepted");
			invalid = true;
			return invalid;
		}
		final CartData cartData = getCheckoutFacade().getCheckoutCart();

		if (!getCheckoutFacade().containsTaxValues())
		{
			LOG.error(String
					.format(
							"Cart %s does not have any tax values, which means the tax cacluation was not properly done, placement of order can't continue",
							cartData.getCode()));
			GlobalMessages.addErrorMessage(model, "checkout.error.tax.missing");
			invalid = true;
		}

		if (!cartData.isCalculated())
		{
			LOG.error(String.format("Cart %s has a calculated flag of FALSE, placement of order can't continue", cartData.getCode()));
			GlobalMessages.addErrorMessage(model, "checkout.error.cart.notcalculated");
			invalid = true;
		}

		return invalid;
	}

	@Override
	protected String redirectToOrderConfirmationPage(final OrderData orderData)
	{
		return REDIRECT_URL_CHINESE_ORDER_CONFIRMATION
				+ (getCheckoutCustomerStrategy().isAnonymousCheckout() ? orderData.getGuid() : orderData.getCode());
	}

	@Override
	protected CheckoutStep getCheckoutStep()
	{
		return getCheckoutStep(SUMMARY);
	}


}
