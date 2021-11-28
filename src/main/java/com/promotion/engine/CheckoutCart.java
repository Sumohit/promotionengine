package com.promotion.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckoutCart {


	public double totalPayment(List<CheckoutItems> checkOutItemsList, List<Promotions>  promoList) {
		double totalPrice = 0.0;
		if(checkOutItemsList.isEmpty()) {
			System.out.println("The checkout cart is empty");
		}else {
			// going for the promotion/discount check

			// filter only A & B items from the item list
			//List<CheckoutItems> multipleList = (List<CheckoutItems>) checkOutItemsList.stream().filter(item -> item.getSku().equalsIgnoreCase("A") || item.getSku().equalsIgnoreCase("B")).collect(Collectors.toList());

			// filter only C & D items from the item list
			//List<CheckoutItems> bundleList = (List<CheckoutItems>) checkOutItemsList.stream().filter(item -> item.getSku().equalsIgnoreCase("C") || item.getSku().equalsIgnoreCase("D")).collect(Collectors.toList());

			//List<Promotions> multiplePromoList = (List<Promotions>) promoList.stream().filter(promotions -> promotions.getPromoType().equalsIgnoreCase("mul")).collect(Collectors.toList());

			double priceOnMultipleItems = calcualatePriceForMultiplePromoItems(checkOutItemsList.stream().filter(item -> item.getSku().equalsIgnoreCase("A") || item.getSku().equalsIgnoreCase("B")).collect(Collectors.toList()),promoList.stream().filter(promotions -> promotions.getPromoType().equalsIgnoreCase("mul")).collect(Collectors.toList()));
			double priceOnBundleItems = calcualatePriceForBundlePromoItems(checkOutItemsList.stream().filter(item -> item.getSku().equalsIgnoreCase("C") || item.getSku().equalsIgnoreCase("D")).collect(Collectors.toList()));
			//System.out.println("Total price is: " + totalPrice);

			totalPrice = priceOnMultipleItems + priceOnBundleItems;
		}


		return totalPrice;
	}

	//buy 'n' items of a SKU for a fixed price (3 A's for 130)
	private double calcualatePriceForMultiplePromoItems(List<CheckoutItems> multipleList,List<Promotions> multiplePromoList) {
		double finalPriceAfterDiscount = 0.0;
		for(CheckoutItems item: multipleList) {
			for(Promotions promotions : multiplePromoList) {
				if(item.getSku().equalsIgnoreCase(promotions.getSku()) && promotions.getPromoType().equalsIgnoreCase("mul")) {
					if(item.getQuantity() < promotions.discountQuantity) {
						double totalprice1 = item.quantity * getUnitPrice(item.getSku());
						finalPriceAfterDiscount =   finalPriceAfterDiscount + totalprice1;
						System.out.println(item.getSku() + ": " + totalprice1);
					}else{

						double discountRemainder = item.getQuantity() %  promotions.discountQuantity;		    
						double discountDiff = item.getQuantity() - (item.getQuantity() %  promotions.discountQuantity);		    
						double count = discountDiff/promotions.discountQuantity;		    
						double totalprice2 = 0.0;
						double totalprice3 = 0.0;
						if(discountRemainder > 0) {
							totalprice2 =  discountRemainder * getUnitPrice(item.getSku());
						}

						if(count > 0) {
							double totalprice = promotions.discountQuantity  * getUnitPrice(item.getSku());
							double discountPrice = promotions.discountQuantity * getUnitPrice(item.getSku()) * promotions.getDiscount()/100;
							totalprice3 = count * (totalprice - discountPrice);
							
						}			
						finalPriceAfterDiscount =  finalPriceAfterDiscount + totalprice2 + totalprice3;
						System.out.println(item.getSku() + ": " + Math.round(totalprice2 + totalprice3));
					}
				}
			}			
		}

		return Math.round(finalPriceAfterDiscount);
	}

	//buy SKU 1 & SKU 2 for a fixed price ( C + D = 30 )
	private double calcualatePriceForBundlePromoItems(List<CheckoutItems> bundleList) {
		double totalPrice = 0.0;
		if(bundleList.size() > 1) {
			int cQuantity = 0;
			int dQuantity = 0;
			for(CheckoutItems item: bundleList) {
				if(item.getSku().equalsIgnoreCase("C")) {
					cQuantity = item.getQuantity();
				}else if(item.getSku().equalsIgnoreCase("D")){
					dQuantity = item.getQuantity();
				}
			}
			if(cQuantity > dQuantity) {
				int diff = cQuantity - dQuantity;
				totalPrice = totalPrice + diff  * getUnitPrice(bundleList.get(0).getSku());	
				System.out.println(bundleList.get(0).getSku() + ": " + totalPrice);
				totalPrice = totalPrice + dQuantity * 30;
				System.out.println(bundleList.get(0).getSku()+ "+" +bundleList.get(1).getSku() + ": " + dQuantity * 30);

			}else {
				int diff = dQuantity - cQuantity;
				totalPrice = totalPrice + diff  * getUnitPrice(bundleList.get(1).getSku());
				System.out.println(bundleList.get(1).getSku() + ": " + totalPrice);
				totalPrice = totalPrice + cQuantity * 30;
				System.out.println(bundleList.get(0).getSku()+ "+" +bundleList.get(1).getSku() + ": " + cQuantity * 30);
			}
		}else {
			totalPrice = totalPrice + bundleList.get(0).getQuantity() * getUnitPrice(bundleList.get(0).getSku());
			System.out.println(bundleList.get(0).getSku() + ": " + totalPrice);
		}
		return Math.round(totalPrice);
	}

	//This method is used get the unit price of each Items present in the cart.
	public int getUnitPrice(String unitName){
		Map<String,Integer> unitPrice = new HashMap<String,Integer>();
		unitPrice.put("A", 50);
		unitPrice.put("B", 30);
		unitPrice.put("C", 20);
		unitPrice.put("D", 15);
		return unitPrice.get(unitName);
	}

	//Converting fixed Prices into percentage
	//Math formula => discount = ((actualPrice - sellingPrice)/actualPrice) * 100;		
	public double convertFixedPriceToDiscount(double sellingPrice, String sku, int quantity) {
		double discount = (((quantity * getUnitPrice(sku)) - sellingPrice)/(quantity * getUnitPrice(sku)) * 100);
		return discount;
	}
}
