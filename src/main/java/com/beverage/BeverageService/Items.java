package com.beverage.BeverageService;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Items {

	COFFEE("coffee", 5), 
	CHAI("chai", 4), 
	BANANA_SMOOTHIE("banana smoothie", 6), 
	STRABERRY_SHAKE("strawberry shake", 7),
	MOJITO("mojito", 7.5);

	Items(final String name, final double value) {
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

	static final Map<String, Items> names = Arrays.stream(Items.values())
			.collect(Collectors.toMap(Items::getName, Function.identity()));

	public static Items fromName(final String name) {
		if(!names.containsKey(name.toLowerCase())) {
			throw new IllegalArgumentException("Invalid item name");
		}
		return names.get(name.toLowerCase());
	}

}
