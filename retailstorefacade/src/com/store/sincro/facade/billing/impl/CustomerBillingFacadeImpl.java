package com.store.sincro.facade.billing.impl;

import com.store.sincro.data.CartData;
import com.store.sincro.facade.billing.CustomerBillingFacade;
import com.store.sincro.strategy.PriceAndDiscountStrategy;
import com.store.sincro.strategy.impl.SincroPriceAndDiscountStrategy;

public class CustomerBillingFacadeImpl implements CustomerBillingFacade {

	private PriceAndDiscountStrategy priceDiscountStrategy;
	
	@Override
	public void calculateCart(final CartData cartData) {
		getPriceDiscountStrategy().calculate(cartData);
	}

	public PriceAndDiscountStrategy getPriceDiscountStrategy() {
		return priceDiscountStrategy = new SincroPriceAndDiscountStrategy(); // Temp. Spring injection will be used to inject bean
	}

	public void setPriceDiscountStrategy(PriceAndDiscountStrategy priceDiscountStrategy) {
		this.priceDiscountStrategy = new SincroPriceAndDiscountStrategy(); // Temp. Spring injection will be used to inject bean
	}
}
