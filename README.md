# ShoppingCart
Shopping Cart application allows products to be scaned and calculate the cart value based on the pricingrules. The pricing rules must be dynamic and can change in the future. Hence the pricing rules must be provided for each checkout.

# Contents

Basic code for Shopping cart application, six test cases using Junit framework. The entry point for this application is through Junit. Feel free to write a testcase and validate your hypothesis. 

# Design

Product Catalogue is created in runtime and hardcoded to load the products and the corresponding price when the class is refered for the first time. 

Checkout class scans the "sku" and loads appropriate product from catalogue to the cart. In case of an invalid product sku product catalogue throws InvalidProductException. As of now InvalidProductException is being handled by scan() method.

On completion of scaning user can go for total() and the price are calculated as per Pricing Rule provided to the checkout class. For test i have created two pricingrules "NoDiscountDay" and "OpeningDaySpecial" (Feel free to create another pricing rule for test). 


# Assumption

1) There is no relationship between deals and the product catalogue. Hence the pricing rules have to fetch the price from the catalogue.

2) There will be only pricingrule applicable for a perticular checkout.

3) PricingRules must be provided for each checkout. 

3) The time complexity of the shopping cart application for calculating the price is O(m*n) m= number of distinct type of products and n= number of items in the cart. (It can be done in order of n, just that it wont be very understandable)


# Test Cases

I started with three acceptance test cases already provided with the problem. Then added three more tests including tests for "NoDiscountDay" pricingRule and a Negative test case.









