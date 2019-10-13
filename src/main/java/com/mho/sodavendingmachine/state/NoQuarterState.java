package com.mho.sodavendingmachine.state;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Inventory;
import com.mho.sodavendingmachine.domain.Soda;
import com.mho.sodavendingmachine.exception.NoSufficientCashException;

public class NoQuarterState extends AbstractVendingMachineState  {

	public NoQuarterState(Inventory<Coin> cashInventory, Inventory<Soda> itemInventory) {
		super(cashInventory, itemInventory);
	}

	public float insertCoin(float currentBalance, Coin coin) {
		cashInventory.add(coin);
		return currentBalance + coin.getDenomination();
	}

	public float removeCoin(float currentBalance, Coin coin) {
		throw new NoSufficientCashException("No cash available to eject");
	}

	public float chooseProduct(float currentBalance, Soda soda) {
		throw new NoSufficientCashException("No cash available to choose product");
	}

	public void dispenseProduct() {
		throw new NoSufficientCashException("No product chosen to dispense product");
	}
}
