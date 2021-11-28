package com.promotion.engine;

import java.util.ArrayList;
import java.util.List;

public class PromotionEngineApplciation {
	public static void main(String[] args) {
		
		// Going for final payment by checking out cart 
		CheckoutCart cart = new CheckoutCart();
		
		//Creating checkout items list		
		List<CheckoutItems> checkOutItemsList = new ArrayList<CheckoutItems>();		
		checkOutItemsList.add(new CheckoutItems("A",1));
		checkOutItemsList.add(new CheckoutItems("B",1));
		checkOutItemsList.add(new CheckoutItems("C",1));
		checkOutItemsList.add(new CheckoutItems("D",1));
		
		//Creating Promotion
		List<Promotions>  promoList = new ArrayList<Promotions>();	
		promoList.add(new Promotions("A",3,cart.convertFixedPriceToDiscount(130, "A", 3),"mul", "3 A's for 130"));
		promoList.add(new Promotions("B",2,cart.convertFixedPriceToDiscount(45, "B", 2),"mul","2 B's for 45"));
		promoList.add(new Promotions("C",1,30,"add", "C+D for 30"));
		promoList.add(new Promotions("D",1,30,"add", "C+D for 30"));
		
		double totalPrice = cart.totalPayment(checkOutItemsList, promoList);
		System.out.println("Total: " + totalPrice);
		
	}

}
