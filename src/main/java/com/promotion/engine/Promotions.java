package com.promotion.engine;

public class Promotions {
	String sku;
	int discountQuantity;
	double discount;
	String promoType;
	String promoName;
	
	public Promotions(String sku, int discountQuantity, double discount, String promoType, String promoName) {
		this.sku = sku;
		this.discountQuantity = discountQuantity;
		this.discount = discount;
		this.promoType = promoType;
		this.promoName = promoName;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getDiscountQuantity() {
		return discountQuantity;
	}
	public void setDiscountQuantity(int discountQuantity) {
		this.discountQuantity = discountQuantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getPromoType() {
		return promoType;
	}

	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}


}
