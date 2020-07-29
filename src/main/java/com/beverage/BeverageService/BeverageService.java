package com.beverage.BeverageService;

public class BeverageService {

	public double calculateTotalPrice(String input) {
		double cost = 0;
		try {
		String[] items = input.replaceAll("[\"\\[\\]]", "").split(",");
		
		for(int i=0; i<items.length; i++) {
			if(items[i].trim().startsWith("-")) {
				cost -= Ingredients.fromName(items[i].trim().substring(1)).getValue();
			}else {
				cost += Items.fromName(items[i].trim()).getValue();
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return cost;
	}
	

}
