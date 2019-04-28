package com.shopping.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.shopping.checkout.Checkout;
import com.shopping.pricing.NoDiscountDay;
import com.shopping.pricing.OpeningDaySpecial;
import com.shopping.pricing.PricingRules;
import com.shopping.product.InvalidProductException;
import com.shopping.product.ProductCatalogue;

public class ShoppingCartTest {

	
	@Test
	public void TestCase1() {
		
		PricingRules rules=new OpeningDaySpecial();
		
		Checkout co= new Checkout(rules);
		
		co.scan("atv");

		co.scan("atv");
		
		co.scan("atv");
		
		co.scan("vga");
		double total= co.total();
		assertTrue("Sum atv,atv,atv,vga expected to be 249.00, but the value returned is "+total, total==249);
		
	}
	
	@Test
	public void TestCase2() {
		
		PricingRules rules=new OpeningDaySpecial();
		
		Checkout co= new Checkout(rules);
		
		co.scan("atv");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("atv");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("ipd");

		double total= co.total();
		assertTrue("Sum atv, ipd, ipd, atv, ipd, ipd, ipd expected 2718.95\n" + 
				"\n" + 
				", but the value returned is "+total, total==2718.95);

	}
	
	@Test
	public void TestCase3() {
		
		PricingRules rules=new OpeningDaySpecial();
		
		Checkout co= new Checkout(rules);
		
		co.scan("mbp");
		co.scan("vga");
		co.scan("ipd");
		
		double total= co.total();
		assertTrue("Sum mbp, vga, ipd expected 1949.98\n" + 
				"\n" + 
				", but the value returned is "+total, total==1949.98);

	}
	
	@Test
	public void TestCase4() {
		
		PricingRules rules=new NoDiscountDay();
		
		Checkout co= new Checkout(rules);
		
		co.scan("mbp");
		co.scan("vga");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("vga");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("atv");
		co.scan("atv");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("atv");
		co.scan("atv");
		co.scan("vga");
		
		
		double total= co.total();
		assertTrue("Sum mbp, vga, ipd expected 5777.92\n" + 
				"\n" + 
				", but the value returned is "+total, total==5777.92);

	}
	//negative test case
		
	@Test (expected = com.shopping.product.InvalidProductException.class)
		public void TestCase5() throws InvalidProductException {			
			ProductCatalogue.getProduct("abc");
	}

	@Test
	public void TestCase6() {
		
		PricingRules rules=new NoDiscountDay();
		
		Checkout co= new Checkout(rules);
		
		for(int i=0;i<500000;i++) {
		co.scan("mbp");
		co.scan("vga");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("vga");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("atv");
		co.scan("atv");
		co.scan("ipd");
		co.scan("ipd");
		co.scan("atv");
		co.scan("atv");
		co.scan("vga");
		}
		
		double total= co.total();
		assertTrue("Sum mbp, vga, ipd expected 5777.92\n" + 
				"\n" + 
				", but the value returned is "+total, total==2.88896E9);

	}
		

}
