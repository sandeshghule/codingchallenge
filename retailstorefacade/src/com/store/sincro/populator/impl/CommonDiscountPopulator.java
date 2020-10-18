package com.store.sincro.populator.impl;

import com.store.dtos.DiscountDTO;
import com.store.sincro.data.DiscountData;
import com.store.sincro.populator.AbstractPopulator;

public class CommonDiscountPopulator<SOURCE, TARGET> extends AbstractPopulator<SOURCE, TARGET> {

	@Override
	public void populate(final SOURCE source, final TARGET target) {
		
		if(source instanceof DiscountDTO && target instanceof DiscountData)
		{
			DiscountDTO dto = (DiscountDTO)source;
			DiscountData data = (DiscountData)target;
			
			
			data.setAmountToBeConsidered(dto.getAmountToBeConsidered());
			data.setDiscountPercentage(dto.getDiscountPercentage());
			
			double amount = 0.0;
			
			if(dto.getDiscountPercentage() > 0 && dto.getDiscountPercentage() <= 100)
			{
				amount = dto.getAmountToBeConsidered() * (dto.getDiscountPercentage()/100);
			}
			
			data.setAmountAfterDiscount(amount);
		}
	}
}
