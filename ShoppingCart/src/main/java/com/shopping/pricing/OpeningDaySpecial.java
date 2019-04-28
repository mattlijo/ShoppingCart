package com.shopping.pricing;

import java.util.ArrayList;

import com.shopping.product.InvalidProductException;
import com.shopping.product.Product;
import com.shopping.product.ProductCatalogue;

public class OpeningDaySpecial implements PricingRules {

	@Override
	public double calculate(ArrayList<Product> cart) {
		double total;

		try {

			long atv = cart.stream().filter(p -> p.getItemSku().equalsIgnoreCase("atv")).count();

			int atvAfterDiscount = (int) (atv - atv / 3);

			total = atvAfterDiscount * ProductCatalogue.getPriceForProduct("atv");

			long ipd = cart.stream().filter(p -> p.getItemSku().equalsIgnoreCase("ipd")).count();

			if (ipd > 4) {
				total += 499.99 * ipd;

			} else {
				total += ipd * ProductCatalogue.getPriceForProduct("ipd");
			}

			long mbp = cart.stream().filter(p -> p.getItemSku().equalsIgnoreCase("mbp")).count();

			total += mbp * ProductCatalogue.getPriceForProduct("mbp");

			long vga = cart.stream().filter(p -> p.getItemSku().equalsIgnoreCase("vga")).count();

			if (mbp >= vga) {
				vga = mbp - vga;
			}

			total += vga * ProductCatalogue.getPriceForProduct("vga");

			return total;

		} catch (InvalidProductException e) {
			e.printStackTrace();

		}
		return 0;
	}

}
