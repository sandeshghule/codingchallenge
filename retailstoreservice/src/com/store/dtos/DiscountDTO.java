package com.store.dtos;

public class DiscountDTO {
	
	private double amountToBeConsidered;
	private double discountPercentage;
	private double amountAfterDiscount;
	
	public double getAmountToBeConsidered() {
		return amountToBeConsidered;
	}
	public void setAmountToBeConsidered(double amountToBeConsidered) {
		this.amountToBeConsidered = amountToBeConsidered;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public double getAmountAfterDiscount() {
		return amountAfterDiscount;
	}
	public void setAmountAfterDiscount(double amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}
	
	
}
