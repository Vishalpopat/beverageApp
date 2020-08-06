package com.beverage.BeverageService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeverageService {

	private static Map<Items, List<Ingredients>> itemIngredientsMap = new HashMap<Items, List<Ingredients>>() {
		{
			put(Items.COFFEE, new ArrayList(Arrays.asList(Ingredients.MILK, Ingredients.SUGAR, Ingredients.WATER)));
			put(Items.CHAI, new ArrayList(Arrays.asList(Ingredients.MILK, Ingredients.SUGAR, Ingredients.WATER)));
			put(Items.BANANA_SMOOTHIE,	new ArrayList(Arrays.asList(Ingredients.MILK, Ingredients.SUGAR, Ingredients.WATER)));
			put(Items.STRABERRY_SHAKE, new ArrayList(Arrays.asList(Ingredients.MILK, Ingredients.SUGAR, Ingredients.WATER)));
			put(Items.MOJITO, new ArrayList(Arrays.asList(Ingredients.SUGAR, Ingredients.WATER, Ingredients.SODA, Ingredients.MINT)));
		}
	};

	public double calculateTotalPrice(String input) {
		double cost = 0;
		try {
			String[] items = input.replaceAll("[\"\\[\\]]", "").split(",");
			Items item = null;
			List<Ingredients> ingredients = null;
			for (int i = 0; i < items.length; i++) {
				
				if (items[i].trim().startsWith("-")) {
					Ingredients ingredient = Ingredients.valueOf(items[i].trim().substring(1).toUpperCase());
					if (ingredients.contains(ingredient)) {
						cost -= Ingredients.fromName(items[i].trim().substring(1)).getValue();
						ingredients.remove(ingredient);
					}
				} else {
					cost += Items.fromName(items[i].trim()).getValue();
					item = Items.valueOf(items[i].trim().toUpperCase());
					ingredients = new ArrayList<>(itemIngredientsMap.get(item));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return cost;
	}

}
