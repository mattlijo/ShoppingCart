package com.shopping.product;

public class Product {
	
	private String itemSku;
	private String itemName;
	private double itemPrice;
	
	public Product(String itemSku, String itemName, double itemPrice) { 
		
		this.itemSku = itemSku;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		
	}
	
	private Product(Product p) {
		
		this.itemName=p.itemName;
		this.itemPrice=p.itemPrice;
		this.itemSku=p.itemSku;
	}
	
	public void setItemSku(String itemSku) {
		
		this.itemSku=itemSku;
		
	}
	
	public String getItemSku() {
		
		return itemSku;
	}
	
	public void setItemName(String itemName) {
		
		this.itemName=itemName;
	}
	
	public String getItemName() {
		
		return itemName;
	}
	
	public double getItemPrice() {
		
		return itemPrice;
	}
	
	public void setItemPrice(double itemPrice) {
		
		this.itemPrice=itemPrice;
	}
	
	public Product copy() {
		return new Product(this);
		
	}
	
	public String toString() {
		
		return "Product Name: "+itemName;
	}

}
