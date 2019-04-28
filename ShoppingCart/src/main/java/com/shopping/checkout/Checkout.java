package com.shopping.checkout;

import java.util.ArrayList;

import com.shopping.pricing.PricingRules;
import com.shopping.product.InvalidProductException;
import com.shopping.product.Product;
import com.shopping.product.ProductCatalogue;

public class Checkout {

	private ArrayList<Product> cart;
	private PricingRules deal;

	public Checkout(PricingRules deal) {

		this.deal = deal;
		cart = new ArrayList<Product>();

	}

	public void scan(String item) {

		Product p = null;

		try {
			p = ProductCatalogue.getProduct(item);
		} catch (InvalidProductException e) {
			System.out.println("The product scaned is invalid try again");
			e.printStackTrace();
		}

		if (p != null)
			cart.add(p);

	}

	public int cartSize() {
		return cart.size();
	}

	public double total() {

		if (cart.size() == 0) {
			return 0;
		}
		return deal.calculate(cart);
		 

	}

}
