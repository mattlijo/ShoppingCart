package com.shopping.pricing;

import java.util.ArrayList;

import com.shopping.product.Product;

public class NoDiscountDay implements PricingRules {

	@Override
	public double calculate(ArrayList<Product> cart) {
		
		double sum = cart.stream().mapToDouble(p -> p.getItemPrice()).sum();
				
		return sum;
	}

}
