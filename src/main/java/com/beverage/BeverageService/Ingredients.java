package com.beverage.BeverageService;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Ingredients {
	MILK("milk", 1), 
	SUGAR("sugar", 0.5), 
	SODA("soda",0.5), 
	MINT("mint", 0.5),
	WATER("water", 0.5);

	Ingredients(final String name, final double value) {
		this.name = name;
		this.value = value;
	}

	private final String name;
	private final double value;

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	static final Map<String, Ingredients> names = Arrays.stream(Ingredients.values())
			.collect(Collectors.toMap(Ingredients::getName, Function.identity()));

	public static Ingredients fromName(final String name) {
		if(!names.containsKey(name.toLowerCase())) {
			throw new IllegalArgumentException("Invalid ingredient name");
		}
		return names.get(name.toLowerCase());
	}

}
