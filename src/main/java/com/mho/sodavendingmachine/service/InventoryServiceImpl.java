package com.mho.sodavendingmachine.service;

import com.mho.sodavendingmachine.domain.Inventory;
import com.mho.sodavendingmachine.domain.Soda;

public class InventoryServiceImpl implements InventoryService {

	public Inventory<Soda> getInventory() {
		
		//This should be typically a WS call to obtain data from server.
		Inventory<Soda> itemInventory = new Inventory<Soda>();  
		
		for(Soda i : Soda.values()){
            itemInventory.put(i, 2);
        }
		
		return itemInventory;
	}

	public void recordPurchase(Soda soda) {
		//This should be typically a WS call to record this on server.
		//So that the reports could be generated out of this data.
		System.out.println("Recorded purchase of " + soda); 
	}

}
