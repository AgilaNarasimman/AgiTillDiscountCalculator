package com.rvvsupermarket.discount;

public class Item {
	
	String name;
	double originalPrice;
	double discountedPrice;
	boolean isClearance;
	
	Item(String name, double originalPrice, boolean isClearance)
	{
		this.name = name;
		this.originalPrice = originalPrice;
		this.isClearance = isClearance;
		this.discountedPrice = calculateDiscountedPrice();
	}
	
	public double calculateDiscountedPrice()
	{
		double discount = 0.0;
		if (name.contains("book") || name.contains("food") || name.contains("drink") || name.contains("chocolate") || name.contains("wine")){
			//5% discount on books, food and drinks 
			discount = 0.05;  // (5/100) = 0.05			
		}
		else if (name.contains("cloth") || name.contains("dress") || name.contains("shirt"))
		{
			//20% discount on cloths
			discount = 0.20; // (20/100) = 0.20
		}
		else
		{
			//3% for all other items
			discount = 0.03; // (3/100) = 0.03
		}
		
		double discountedPrice = originalPrice * (1- discount);
		
		
		if (isClearance)
		{
			discountedPrice = discountedPrice*0.80; //Additional 20% discount on top discounted price for all clearance items
		}
		
		return roundedToTheNearestCent(discountedPrice);
	}
	
	public double calculateAmountSaved()
	{
		return roundedToTheNearestCent(originalPrice- discountedPrice);
	}
	
	public double roundedToTheNearestCent(double value)
	{
		return Math.round(value*100.0)/100.0;
	}
	

	
}
