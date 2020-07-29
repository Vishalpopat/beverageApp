package com.beverage.BeverageService;

import java.util.Scanner;

public class App {

	BeverageService beverageService;

	public BeverageService getBeverageService() {
		return beverageService;
	}

	public void setBeverageService(BeverageService beverageService) {
		this.beverageService = beverageService;
	}

	public App(BeverageService beverageService) {
		this.beverageService = beverageService;
	}

	public static void main(String[] args) {
		
		
		BeverageService beverageService = new BeverageService();
		App app = new App(beverageService);
				
		Scanner sc = new Scanner(System.in);
		while(true) {
		String input = sc.nextLine();
			double totalPrice = beverageService.calculateTotalPrice(input);
			System.out.println("Total Price: "+totalPrice);
		}
		
	}

}
