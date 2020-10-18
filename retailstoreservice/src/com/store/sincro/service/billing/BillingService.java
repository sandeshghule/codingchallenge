package com.store.sincro.service.billing;

import java.util.List;

import com.store.dtos.DiscountDTO;

public interface BillingService {

	List<DiscountDTO> getDiscounts(final String type, final Double amount);

}
