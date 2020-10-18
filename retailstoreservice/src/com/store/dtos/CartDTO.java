package com.store.dtos;

import java.util.List;

public class CartDTO {
	private String customerType;
	private double totalAmount;
	private double totalDiscountAmount;
	private double amountAfterDiscount;
	private List<DiscountDTO> discountList;
	
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getTotalDiscountAmount() {
		return totalDiscountAmount;
	}
	public void setTotalDiscountAmount(double totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}
	public double getAmountAfterDiscount() {
		return amountAfterDiscount;
	}
	public void setAmountAfterDiscount(double amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}
	public List<DiscountDTO> getDiscountList() {
		return discountList;
	}
	public void setDiscountList(List<DiscountDTO> discountList) {
		this.discountList = discountList;
	}
}
