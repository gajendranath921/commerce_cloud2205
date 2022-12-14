/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesepspwechatpay.controllers.misc;

import de.hybris.platform.addonsupport.controllers.AbstractAddOnController;
import de.hybris.platform.chinesepspwechatpayservices.data.WeChatRawDirectPayNotification;
import de.hybris.platform.chinesepspwechatpayservices.notifications.WeChatPayNotificationService;
import de.hybris.platform.chinesepspwechatpayservices.processors.impl.SignVerificationProcessor;
import de.hybris.platform.chinesepspwechatpayservices.wechatpay.WeChatPayConfiguration;
import de.hybris.platform.chinesepspwechatpayservices.wechatpay.WeChatPayUtils;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xml.sax.SAXException;

import com.sap.security.core.server.csi.XSSEncoder;

import groovy.util.Node;
import groovy.util.XmlParser;


@Controller
@Scope("tenant")
@RequestMapping("/checkout/multi/summary/wechat")
public class ChineseWeChatPayResponseController extends AbstractAddOnController
{
	private static final Logger LOG = Logger.getLogger(ChineseWeChatPayResponseController.class);
	private static final int BUFF_SIZE = 128;

	@Resource(name = "weChatPayConfiguration")
	private WeChatPayConfiguration weChatPayConfiguration;

	@Resource(name = "weChatPayNotificationService")
	private WeChatPayNotificationService weChatPayNotificationService;

	@RequestMapping(value = "/paymentresponse/notify", method = RequestMethod.POST)
	public void handlePaymentResponse(final HttpServletRequest request, final HttpServletResponse response)
			throws CMSItemNotFoundException, IOException
	{
		final String requestBody = getPostRequestBody(request);
		if (requestBody.isEmpty())
		{
			LOG.error("Notify body is empty");
		}
		else
		{
			final Map<String, String> unifyResponseMap;
			try
			{
				final Node notifyXml = new XmlParser().parseText(requestBody);
				unifyResponseMap = (Map<String, String>) notifyXml.children().stream()
						.collect(Collectors.toMap(k -> ((Node) k).name(), k -> ((Node) k).children().get(0).toString()));
				final SignVerificationProcessor signVerificationProcessor = new SignVerificationProcessor(weChatPayConfiguration,
						unifyResponseMap);
				if (!signVerificationProcessor.process().booleanValue())
				{
					LOG.warn("Invalid notify from WeChatPay");
					response.setContentType("text/xml");
					response.getWriter().write(XSSEncoder.encodeXML("FAIL"));
				}
				final WeChatRawDirectPayNotification weChatPayNotification = new WeChatRawDirectPayNotification();
				final Map<String, String> camelCaseMap = WeChatPayUtils.convertKey2CamelCase(unifyResponseMap);
				BeanUtils.populate(weChatPayNotification, camelCaseMap);
				weChatPayNotificationService.handleWeChatPayPaymentResponse(weChatPayNotification);
				response.setContentType("text/xml");
				response.getWriter().write(XSSEncoder.encodeXML("SUCCESS"));
			}
			catch (IOException | SAXException | ParserConfigurationException | IllegalAccessException | InvocationTargetException e)
			{
				LOG.error("Problem in handling WeChatPay's notify message");
			}

		}
	}

	public String getPostRequestBody(final HttpServletRequest req)
	{
		if (RequestMethod.POST.name().equalsIgnoreCase(req.getMethod()))
		{
			final StringBuilder sb = new StringBuilder();
			try (BufferedReader br = req.getReader())
			{
				final char[] charBuffer = new char[BUFF_SIZE];
				int bytesRead;
				while ((bytesRead = br.read(charBuffer)) != -1)
				{
					sb.append(charBuffer, 0, bytesRead);
				}
			}
			catch (final IOException e)
			{
				LOG.warn("failed to read request body");
			}
			return sb.toString();
		}
		return "";
	}

}
