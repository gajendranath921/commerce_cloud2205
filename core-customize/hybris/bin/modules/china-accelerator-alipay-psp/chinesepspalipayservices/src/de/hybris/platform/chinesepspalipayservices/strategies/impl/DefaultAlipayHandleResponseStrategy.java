/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesepspalipayservices.strategies.impl;

import de.hybris.platform.chinesepspalipayservices.data.AlipayRefundData;
import de.hybris.platform.chinesepspalipayservices.data.AlipayRefundNotification;
import de.hybris.platform.chinesepspalipayservices.strategies.AlipayHandleResponseStrategy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;


public class DefaultAlipayHandleResponseStrategy implements AlipayHandleResponseStrategy
{

	private static final Logger LOG = Logger.getLogger(DefaultAlipayHandleResponseStrategy.class);
	private static final int ALIPAY_CODE_INDEX = 0;
	private static final int PAYER_REFUND_AMOUNT_INDEX = 1;
	private static final int PAYER_REFUND_STATUS_INDEX = 2;
	private static final int SELLER_EMAIL_INDEX = 0;
	private static final int SELLER_ID_INDEX = 1;
	private static final int SELLER_REFUND_AMOUNT_INDEX = 2;
	private static final int SELLER_REFUND_STATUS_INDEX = 3;

	@Override
	public Object camelCaseFormatter(final Map<String, String> responseMap, final Object directRawData)
	{
		final Map<String, String> camelCaseMap = convertKey2CamelCase(responseMap);
		try
		{
			BeanUtils.populate(directRawData, camelCaseMap);
		}
		catch (IllegalAccessException | InvocationTargetException e)
		{
			LOG.error("Problem in handling Alipay's notify message");
		}

		return directRawData;
	}

	@Override
	public List<AlipayRefundData> getAlipayRefundDataList(final AlipayRefundNotification alipayRefundNotification)
	{
		if (Integer.valueOf(alipayRefundNotification.getSuccessNum()) <= 0)
		{
			return new ArrayList<>();
		}

		final String[] refundList = alipayRefundNotification.getResultDetails().split("#");
		final List<AlipayRefundData> alipayRefundDataList = new ArrayList<>();
		for (final String refundDetail : refundList)
		{
			if (refundDetail.contains("$"))
			{
				final String[] payerInfo = (refundDetail.split("\\$"))[0].split("\\^");
				final String[] sellerInfo = (refundDetail.split("\\$"))[1].split("\\^");
				final AlipayRefundData alipayRefundData = new AlipayRefundData();
				alipayRefundData.setBatchNo(alipayRefundNotification.getBatchNo());

				alipayRefundData.setAlipayCode(payerInfo[ALIPAY_CODE_INDEX]);
				alipayRefundData.setPayerRefundAmount(Double.valueOf(payerInfo[PAYER_REFUND_AMOUNT_INDEX]));
				alipayRefundData.setPayerRefundStatus(payerInfo[PAYER_REFUND_STATUS_INDEX]);

				alipayRefundData.setSellerEmail(sellerInfo[SELLER_EMAIL_INDEX]);
				alipayRefundData.setSellerId(sellerInfo[SELLER_ID_INDEX]);
				alipayRefundData.setSellerRefundAmount(Double.valueOf(sellerInfo[SELLER_REFUND_AMOUNT_INDEX]));
				alipayRefundData.setSellerRefundStatus(sellerInfo[SELLER_REFUND_STATUS_INDEX]);

				alipayRefundDataList.add(alipayRefundData);
			}
			else
			{
				final String[] refundInfo = refundDetail.split("\\^");

				final AlipayRefundData alipayRefundData = new AlipayRefundData();
				alipayRefundData.setBatchNo(alipayRefundNotification.getBatchNo());

				alipayRefundData.setAlipayCode(refundInfo[ALIPAY_CODE_INDEX]);
				alipayRefundData.setPayerRefundAmount(Double.valueOf(refundInfo[PAYER_REFUND_AMOUNT_INDEX]));
				alipayRefundData.setPayerRefundStatus(refundInfo[PAYER_REFUND_STATUS_INDEX]);
				alipayRefundDataList.add(alipayRefundData);

			}

		}
		return alipayRefundDataList;
	}

	protected Map<String, String> convertKey2CamelCase(final Map<String, String> snakeCaseMap)
	{
		final Map<String, String> camelCaseMap = new LinkedHashMap<>();
		for (final Map.Entry<String, String> entry : snakeCaseMap.entrySet())
		{
			final String value = entry.getValue();
			final String key = entry.getKey();
			String camelKey = WordUtils.capitalizeFully(key, new char[]
			{ '_' }).replace("_", "");
			camelKey = WordUtils.uncapitalize(camelKey);
			camelCaseMap.put(camelKey, value);
		}
		return camelCaseMap;
	}

}
