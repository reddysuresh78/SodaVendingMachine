package com.mho.sodavendingmachine.state;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Inventory;
import com.mho.sodavendingmachine.domain.Soda;

public abstract class AbstractVendingMachineState implements VendingMachineState {
	
	protected Inventory<Coin> cashInventory;
	protected Inventory<Soda> itemInventory;   
    
	public AbstractVendingMachineState(Inventory<Coin> cashInventory, Inventory<Soda> itemInventory) {
		super();
		this.cashInventory = cashInventory;
		this.itemInventory = itemInventory;
	}
 
}
