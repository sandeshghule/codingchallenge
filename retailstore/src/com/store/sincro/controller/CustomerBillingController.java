/**
*  Sincro Platform
*
* Copyright (c) 2020-2021 Sincro
* All rights reserved.
* 
**/
package com.store.sincro.controller;

import com.store.sincro.StoreConstants;
import com.store.sincro.data.CartData;
import com.store.sincro.facade.billing.CustomerBillingFacade;
import com.store.sincro.facade.billing.impl.CustomerBillingFacadeImpl;
import com.store.sincro.utils.StoreUtils;

/* 
* Controller class for Billing
* The billing Controller implements an application that
* handles customers shopping cart and prints  
* the output on the screen.
* 
* @author  Sandesh Ghule
* @version 1.0
* @since   2020-18-10
*/

public class CustomerBillingController {
	
	/* Customer Billing Facade*/
	private CustomerBillingFacade customerBillingFacade;
	
	/*
	 * The function takes customer types(Regular\Premium) and total billing amount
	 * as inputs for calculating total cart amount and delegate the request to facade
	 * 
	 *  @param customerType the type of the customer
	 *  @param billingAmount the total amount of shopping cart
	 *  @return the amount after discount
	 */
	public double calculateCartTotal(final String customerType, double billingAmount) throws Exception{
		
		CartData cartData = new CartData();
		if(validParams(customerType,billingAmount))
		{
			cartData.setCustomerType(customerType);
			cartData.setTotalAmount(billingAmount);
			getCustomerBillingFacade().calculateCart(cartData);
		}
		else
		{
			throw new Exception("Invalid Inputs: "+"Customer Type="+customerType+", Billing Amount="+billingAmount);
		}
		return cartData.getAmountAfterDiscount();
		
	}

	/*
	 * The function takes customer types(Regular\Premium) and total billing amount
	 * as inputs for calculating total cart amount and delegate the request to facade
	 * 
	 *  @param customerType the type of the customer
	 *  @param billingAmount the total amount of shopping cart
	 *  @return true if params are valid else false
	 */
	private boolean validParams(String customerType, double billingAmount) {
		
		boolean flag = true;
		if(!"REGULAR".equalsIgnoreCase(customerType) && !"PREMIUM".equalsIgnoreCase(customerType))
		{
			flag = false;
		} 
		if(billingAmount < 0)
		{
			flag = false;
		}
		return flag;
	}

	/*
	 * The function is written to take inputs from command line for calculating cart amount
	 * It prints the cart amount.
	 * 
	 */
	public void enterBillingDetails()
	{
		System.out.println(StoreConstants.Messages.STORE_WELCOME_MSG);
		
		String customerType = StoreUtils.takeUserInputAsString(StoreConstants.Messages.CUSTOMER_TYPE_MSG);
		String amountText = StoreUtils.takeUserInputAsString(StoreConstants.Messages.CUSTOMER_BILLING_AMOUNT_MSG);
		
		double billingAmount = 0.0;
		
		try
		{
			billingAmount = Double.parseDouble(amountText);
			calculateCartTotal(customerType,billingAmount);
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			System.out.println("Exception Occured="+ex.getMessage());
			System.out.println("Invalid Amount value entered, Please run program again");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Exception Occured="+ex.getMessage());
			System.out.println("Error in Billing, Please run program again");
		}
	}
	
	public CustomerBillingFacade getCustomerBillingFacade() {
		return new CustomerBillingFacadeImpl(); // Temp. Spring injection will be used to inject bean
	}

	public void setCustomerBillingFacade(CustomerBillingFacade customerBillingFacade) {
		this.customerBillingFacade = new CustomerBillingFacadeImpl(); // Temp. Spring injection will be used to inject bean
	}
	
	/*
	 * The main method to test the application as stand alone program
	 *  @param args not used
	 */
	public static void main(String[] args) {
		CustomerBillingController controller = new CustomerBillingController();
		controller.enterBillingDetails();
	}
}