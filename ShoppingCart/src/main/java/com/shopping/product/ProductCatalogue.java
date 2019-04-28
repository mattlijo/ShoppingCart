package com.shopping.product;

import java.util.ArrayList;
import java.util.Optional;

public class ProductCatalogue {

	private static final ArrayList<Product> ProductsList;

	static {
		ProductsList = new ArrayList<Product>();

		ProductsList.add(new Product("ipd", "super ipad", 549.99));
		ProductsList.add(new Product("mbp", "MacBook Prod", 1399.99));
		ProductsList.add(new Product("atv", "Apple TV", 109.50));
		ProductsList.add(new Product("vga", "VGA adapter", 30.00));
	}

	public static Product getProduct(String sku) throws InvalidProductException {

		Optional<Product> product = ProductCatalogue.ProductsList.stream()
				.filter(p -> p.getItemSku().equalsIgnoreCase(sku)).findFirst();

		if (product.isPresent()) {
			Product p = (Product) product.get();

			return (Product) p.copy();
		} else {
			throw new InvalidProductException("Invalid product: " + sku);
		}
	}

	public static double getPriceForProduct(String sku) throws InvalidProductException {

		Optional<Product> product = ProductCatalogue.ProductsList.stream()
				.filter(p -> p.getItemSku().equalsIgnoreCase(sku)).findFirst();

		if (product.isPresent()) {
			Product p = (Product) product.get();

			return p.getItemPrice();
		} else {
			throw new InvalidProductException("Invalid product: " + sku);
		}
	}
}
