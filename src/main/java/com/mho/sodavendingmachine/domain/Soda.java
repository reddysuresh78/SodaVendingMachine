package com.mho.sodavendingmachine.domain;

public enum Soda {

	COKE("Coke", 0.25f), PEPSI("Pepsi", 0.25f), SPRITE("Sprite", 0.50f);
	
	private String name;
	private float price;

	private Soda(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

}
