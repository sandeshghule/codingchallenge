package com.store.sincro.strategy;

import java.util.List;

import com.store.sincro.data.CartData;
import com.store.sincro.data.DiscountData;

public interface PriceAndDiscountStrategy {

	public List<DiscountData> getApplicableDiscounts(final CartData cartData);
	public void calculate(final CartData cartData);
}
