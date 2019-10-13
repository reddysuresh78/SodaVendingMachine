package com.mho.sodavendingmachine.domain;

public enum Coin {

	QUARTER(0.25f);
	
	private float denomination;

	private Coin(float denomination) {
		this.denomination = denomination;
	}

	public float getDenomination() {
		return denomination;
	}

}
