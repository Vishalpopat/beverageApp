package com.beverage.BeverageService;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeverageServiceTest {
	
	BeverageService beverageService = new BeverageService();

	@Test
	public void positiveTest() {
		double calculateTotalPrice = beverageService.calculateTotalPrice("Chai, -sugar");
		assertEquals(3.5, calculateTotalPrice, 0.0);
	}
	
	@Test
	public void positiveListTest() {
		double calculateTotalPrice = beverageService.calculateTotalPrice("[\"Chai, -sugar\", \"Chai\", \"Coffee, -milk\"]");
		assertEquals(11.5, calculateTotalPrice, 0.0);
	}
	
	@Test
	public void duplicateIngredientTest() {
		try {
			beverageService.calculateTotalPrice("[\"Chai, -sugar, -sugar\", \"Chai\", \"Coffee, -milk, -milk\"]");
		} catch (IllegalArgumentException e) {
			assertEquals("Given ingredient is already removed: sugar", e.getMessage());
		}
	}
	
	@Test
	public void ingredientNotUsedInItemTest() {
		try {
			beverageService.calculateTotalPrice("[\"Chai, -sugar\", \"Chai\", \"Coffee, -milk, -mint\"]");
		} catch (IllegalArgumentException e) {
			assertEquals("Given ingredient is not used in item: mint", e.getMessage());
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidItemNametest() {
		beverageService.calculateTotalPrice("Random, -sugar");
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidIngredientNametest() {
		beverageService.calculateTotalPrice("Chai, -random");
	}
	
	

}
