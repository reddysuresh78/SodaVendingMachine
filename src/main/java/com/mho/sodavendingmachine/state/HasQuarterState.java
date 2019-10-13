package com.mho.sodavendingmachine.state;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Inventory;
import com.mho.sodavendingmachine.domain.Soda;
import com.mho.sodavendingmachine.exception.NoProductChosenException;
import com.mho.sodavendingmachine.exception.NoSufficientCashException;

public class HasQuarterState extends AbstractVendingMachineState {
 	  
	public HasQuarterState(Inventory<Coin> cashInventory, Inventory<Soda> itemInventory) {
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
		if(soda.getPrice() <= currentBalance && itemInventory.getQuantity(soda) > 0 ){
			currentBalance -= soda.getPrice();
			//This needs to be revisited when there are more denominations
			int noOfCoins = (int) (soda.getPrice()/Coin.QUARTER.getDenomination());
			for(int i=0; i<noOfCoins;i++) {
				cashInventory.deduct(Coin.QUARTER);
			}
			itemInventory.deduct(soda);
			return currentBalance;
		}
		throw new NoSufficientCashException("No sufficient cash available");
	}

	public void dispenseProduct() {
		throw new NoProductChosenException("No product chosen to dispense product");
	}
}
