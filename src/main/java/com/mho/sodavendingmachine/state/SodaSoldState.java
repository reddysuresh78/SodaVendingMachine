package com.mho.sodavendingmachine.state;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Inventory;
import com.mho.sodavendingmachine.domain.Soda;
import com.mho.sodavendingmachine.exception.DispensePendingException;

public class SodaSoldState extends AbstractVendingMachineState {
 	 
	public SodaSoldState(Inventory<Coin> cashInventory, Inventory<Soda> itemInventory) {
		super(cashInventory, itemInventory);
	}

	public float insertCoin(float currentBalance, Coin coin) {
		throw new DispensePendingException("Complete dispensing chosen product before proceeding");
	}

	public float removeCoin(float currentBalance, Coin coin) {
		throw new DispensePendingException("Complete dispensing chosen product before proceeding");
	}

	public float chooseProduct(float currentBalance, Soda soda) {
		throw new DispensePendingException("Complete dispensing chosen product before proceeding");
	}

	public void dispenseProduct() {
		
	}
}
