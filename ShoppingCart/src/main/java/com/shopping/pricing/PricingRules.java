package com.shopping.pricing;

import java.util.ArrayList;

import com.shopping.product.Product;

public interface PricingRules {
	
	public double calculate(ArrayList<Product> cart);

}
