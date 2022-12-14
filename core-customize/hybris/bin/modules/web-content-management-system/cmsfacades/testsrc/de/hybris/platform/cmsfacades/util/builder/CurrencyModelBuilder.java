/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.util.builder;

import de.hybris.platform.core.model.c2l.CurrencyModel;


public class CurrencyModelBuilder
{

	private final CurrencyModel model;

	private CurrencyModelBuilder()
	{
		model = new CurrencyModel();
	}

	private CurrencyModelBuilder(CurrencyModel model)
	{
		this.model = model;
	}

	protected CurrencyModel getModel()
	{
		return this.model;
	}

	public static CurrencyModelBuilder aModel()
	{
		return new CurrencyModelBuilder();
	}

	public static CurrencyModelBuilder fromModel(CurrencyModel model)
	{
		return new CurrencyModelBuilder(model);
	}

	public CurrencyModel build()
	{
		return this.getModel();
	}

	public CurrencyModelBuilder withActive(Boolean active)
	{
		getModel().setActive(active);
		return this;
	}

	public CurrencyModelBuilder withIsocode(String isocode)
	{
		getModel().setIsocode(isocode);
		return this;
	}

	public CurrencyModelBuilder withSymbol(String symbol)
	{
		getModel().setSymbol(symbol);
		return this;
	}
}