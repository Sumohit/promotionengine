package com.promotion.engine.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.promotion.engine.CheckoutCart;
import com.promotion.engine.CheckoutItems;
import com.promotion.engine.Promotions;

public class PromotionEngineApplicationTest {

	private CheckoutCart cart;

	
	/*
	 * Given Senario A
	 *  A : 1
	 *  B : 1
	 *  C : 1
	 *  D : 1
	 */
	@Test
	public void promotionEngineTestwithSenarioA() {
		cart = new CheckoutCart();

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
		
		Assert.assertEquals(110, cart.totalPayment(checkOutItemsList, promoList), 0.0);

	}
	
	/*
	 * Given Senario B
	 *  A : 1
	 *  B : 1
	 *  C : 1
	 *  D : 0
	 */
	@Test
	public void promotionEngineTestwithSenarioB() {
		cart = new CheckoutCart();

		//Creating checkout items list		
		List<CheckoutItems> checkOutItemsList = new ArrayList<CheckoutItems>();		
		checkOutItemsList.add(new CheckoutItems("A",1));
		checkOutItemsList.add(new CheckoutItems("B",1));
		checkOutItemsList.add(new CheckoutItems("C",1));
		//checkOutItemsList.add(new CheckoutItems("D",1));

		//Creating Promotion
		List<Promotions>  promoList = new ArrayList<Promotions>();	
		promoList.add(new Promotions("A",3,cart.convertFixedPriceToDiscount(130, "A", 3),"mul", "3 A's for 130"));
		promoList.add(new Promotions("B",2,cart.convertFixedPriceToDiscount(45, "B", 2),"mul","2 B's for 45"));
		promoList.add(new Promotions("C",1,30,"add", "C+D for 30"));
		promoList.add(new Promotions("D",1,30,"add", "C+D for 30"));
		
		Assert.assertEquals(100, cart.totalPayment(checkOutItemsList, promoList), 0.0);

	}
	
	
	/*
	 * Given Senario C
	 *  A : 5
	 *  B : 3
	 *  C : 2
	 *  D : 1
	 */
	@Test
	public void promotionEngineTestwithSenarioC() {
		cart = new CheckoutCart();

		//Creating checkout items list		
		List<CheckoutItems> checkOutItemsList = new ArrayList<CheckoutItems>();		
		checkOutItemsList.add(new CheckoutItems("A",5));
		checkOutItemsList.add(new CheckoutItems("B",3));
		checkOutItemsList.add(new CheckoutItems("C",2));
		checkOutItemsList.add(new CheckoutItems("D",1));

		//Creating Promotion
		List<Promotions>  promoList = new ArrayList<Promotions>();	
		promoList.add(new Promotions("A",3,cart.convertFixedPriceToDiscount(130, "A", 3),"mul", "3 A's for 130"));
		promoList.add(new Promotions("B",2,cart.convertFixedPriceToDiscount(45, "B", 2),"mul","2 B's for 45"));
		promoList.add(new Promotions("C",1,30,"add", "C+D for 30"));
		promoList.add(new Promotions("D",1,30,"add", "C+D for 30"));
		
		Assert.assertEquals(355, cart.totalPayment(checkOutItemsList, promoList), 0.0);

	}
	
	/*
	 * Given Senario D
	 *  A : 1
	 *  B : 1
	 *  C : 2
	 *  D : 3
	 */
	@Test
	public void promotionEngineTestwithSenarioD() {
		cart = new CheckoutCart();

		//Creating checkout items list		
		List<CheckoutItems> checkOutItemsList = new ArrayList<CheckoutItems>();		
		checkOutItemsList.add(new CheckoutItems("A",1));
		checkOutItemsList.add(new CheckoutItems("B",1));
		checkOutItemsList.add(new CheckoutItems("C",2));
		checkOutItemsList.add(new CheckoutItems("D",3));

		//Creating Promotion
		List<Promotions>  promoList = new ArrayList<Promotions>();	
		promoList.add(new Promotions("A",3,cart.convertFixedPriceToDiscount(130, "A", 3),"mul", "3 A's for 130"));
		promoList.add(new Promotions("B",2,cart.convertFixedPriceToDiscount(45, "B", 2),"mul","2 B's for 45"));
		promoList.add(new Promotions("C",1,30,"add", "C+D for 30"));
		promoList.add(new Promotions("D",1,30,"add", "C+D for 30"));
		
		Assert.assertEquals(155, cart.totalPayment(checkOutItemsList, promoList), 0.0);

	}
	
	
	/*
	 * Given Senario E
	 *  A : 5
	 *  B : 5
	 *  C : 5
	 *  D : 5
	 */
	@Test
	public void promotionEngineTestwithSenarioE() {
		cart = new CheckoutCart();

		//Creating checkout items list		
		List<CheckoutItems> checkOutItemsList = new ArrayList<CheckoutItems>();		
		checkOutItemsList.add(new CheckoutItems("A",5));
		checkOutItemsList.add(new CheckoutItems("B",5));
		checkOutItemsList.add(new CheckoutItems("C",5));
		checkOutItemsList.add(new CheckoutItems("D",5));

		//Creating Promotion
		List<Promotions>  promoList = new ArrayList<Promotions>();	
		promoList.add(new Promotions("A",3,cart.convertFixedPriceToDiscount(130, "A", 3),"mul", "3 A's for 130"));
		promoList.add(new Promotions("B",2,cart.convertFixedPriceToDiscount(45, "B", 2),"mul","2 B's for 45"));
		promoList.add(new Promotions("C",1,30,"add", "C+D for 30"));
		promoList.add(new Promotions("D",1,30,"add", "C+D for 30"));
		
		Assert.assertEquals(500, cart.totalPayment(checkOutItemsList, promoList), 0.0);

	}

}
