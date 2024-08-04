package com.rvvsupermarket.discount;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class TillDiscountCalculator {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		int noOfItems = Integer.parseInt(scanner.nextLine());
		
		List<Item> items = new ArrayList<>();
		double originalTotal = 0.0;
		double totalSaved = 0.0;
		
		for (int i=1; i <= noOfItems ; i++)
		{
			String entry = scanner.nextLine();
			String[] segments = entry.split(" at ");
			String name = segments[0];
			double originalPrice = Double.parseDouble(segments[1]);
			boolean isClearance = name.contains("clearance");
			
			Item item = new Item(name, originalPrice, isClearance);
			items.add(item);
			originalTotal = originalTotal + item.discountedPrice;
			totalSaved = totalSaved + item.calculateAmountSaved();
			
		}
		
		for (Item item: items)
		{
			System.out.println(item.name + " at " + df.format(item.discountedPrice));
		}
		
		System.out.println("Total: " + df.format(originalTotal));
		System.out.println("You saved: " + df.format(totalSaved));
		
		scanner.close();
		


	}

}
