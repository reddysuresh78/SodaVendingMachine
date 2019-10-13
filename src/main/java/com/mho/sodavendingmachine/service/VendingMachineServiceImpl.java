package com.mho.sodavendingmachine.service;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Inventory;
import com.mho.sodavendingmachine.domain.Soda;
import com.mho.sodavendingmachine.exception.OperationFailedException;
import com.mho.sodavendingmachine.exception.SoldOutException;
import com.mho.sodavendingmachine.state.HasQuarterState;
import com.mho.sodavendingmachine.state.NoQuarterState;
import com.mho.sodavendingmachine.state.SodaSoldState;
import com.mho.sodavendingmachine.state.SoldOutState;
import com.mho.sodavendingmachine.state.VendingMachineState;

public class VendingMachineServiceImpl implements VendingMachineState, VendingMachineService{
	
	private float availableBalance;
	
	private VendingMachineState currentState;
	private InventoryService inventoryService;
	 
	private final VendingMachineState hasQuarterState;
	private final VendingMachineState noQuarterState;
	private final VendingMachineState sodaSoldState;
	private final VendingMachineState soldOutState;
	
	private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Soda> itemInventory;  
	
	public VendingMachineServiceImpl(){
		inventoryService = new InventoryServiceImpl();
		itemInventory = inventoryService.getInventory();
		
		for(Coin c : Coin.values()){
            cashInventory.put(c, 0);
        }
 		
		hasQuarterState = new HasQuarterState(cashInventory, itemInventory);
		noQuarterState = new NoQuarterState(cashInventory, itemInventory);
		sodaSoldState = new SodaSoldState(cashInventory, itemInventory);
		soldOutState = new SoldOutState(cashInventory, itemInventory);
		
		currentState = noQuarterState;
		availableBalance = 0.0f;
	}
	 
	public VendingMachineState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(VendingMachineState currentState) {
		this.currentState = currentState;
	}

	public float insertCoin(float currentBalance, Coin coin) {
		
		try{
			availableBalance = currentState.insertCoin(currentBalance, coin);
		}catch(Exception e){
			throw new OperationFailedException(e.getMessage());
		}
		
		setCurrentState(hasQuarterState);
		
		return availableBalance;
	}

	public float removeCoin(float currentBalance, Coin coin) {
		try{
			availableBalance = currentState.removeCoin(currentBalance, coin);
		}catch(Exception e){
			throw new OperationFailedException(e.getMessage());
		}

		if(availableBalance == 0){
			setCurrentState(noQuarterState);
		}
		return availableBalance;
	}

	public float chooseProduct(float currentBalance, Soda soda) {
		try{
			availableBalance = currentState.chooseProduct(currentBalance, soda);
			setCurrentState(sodaSoldState);
			inventoryService.recordPurchase(soda);
		}catch(SoldOutException e){
			setCurrentState(soldOutState);
		}catch(Exception e){
			throw new OperationFailedException(e.getMessage());
		}
		return availableBalance;
	}

	public void dispenseProduct() {
		try{
			currentState.dispenseProduct();
		}catch(Exception e){
			throw new OperationFailedException(e.getMessage());
		}
		if(availableBalance == 0){
			setCurrentState(noQuarterState);
		}else{
			setCurrentState(hasQuarterState);
		}
	}

	public void insertCoin(Coin coin) {
		insertCoin(availableBalance, coin);
	}

	public void removeCoin(Coin coin) {
		removeCoin(availableBalance, coin);
	}

	public void chooseProduct(Soda soda) {
		chooseProduct(availableBalance, soda);
	}

	public float getCurrentBalance() {
		return availableBalance;
	}

}
