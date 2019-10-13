package com.mho.sodavendingmachine.service;

import com.mho.sodavendingmachine.domain.Inventory;
import com.mho.sodavendingmachine.domain.Soda;

public interface InventoryService {

	public Inventory<Soda> getInventory();
	public void recordPurchase(Soda soda);
	 
}
