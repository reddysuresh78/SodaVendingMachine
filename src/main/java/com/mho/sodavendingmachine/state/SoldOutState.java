package com.mho.sodavendingmachine.state;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Inventory;
import com.mho.sodavendingmachine.domain.Soda;
import com.mho.sodavendingmachine.exception.NoSufficientCashException;
import com.mho.sodavendingmachine.exception.SoldOutException;

public class SoldOutState extends AbstractVendingMachineState {
	 
	public SoldOutState(Inventory<Coin> cashInventory, Inventory<Soda> itemInventory) {
		super(cashInventory, itemInventory);
	}

	public float insertCoin(float currentBalance, Coin coin) {
		cashInventory.add(coin);
		return currentBalance + coin.getDenomination();
	}

	public float removeCoin(float currentBalance, Coin coin) {
		if(currentBalance >= coin.getDenomination()){
			cashInventory.deduct(coin);
			return currentBalance - coin.getDenomination();
		}
		throw new NoSufficientCashException("No sufficient cash available to eject");
	}

	public float chooseProduct(float currentBalance, Soda soda) {
		throw new SoldOutException("All sodas are sold out");
	}

	public void dispenseProduct() {
		throw new SoldOutException("All sodas are sold out");
	}
}
