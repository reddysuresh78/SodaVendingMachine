package com.mho.sodavendingmachine;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Soda;
import com.mho.sodavendingmachine.exception.OperationFailedException;
import com.mho.sodavendingmachine.service.VendingMachineServiceImpl;

public class VendingMachineTest {
	private VendingMachineServiceImpl vm;

	@Before
	public void setUp() {
		vm = new VendingMachineServiceImpl();
	}

	@After
	public void tearDown() {
		vm = null;
	}

	@Test
	public void testBuyItemWithEnoughMoney() {
		
		vm.insertCoin(Coin.QUARTER);
		vm.chooseProduct(Soda.COKE);
		vm.dispenseProduct();
		
		assertTrue(vm.getCurrentBalance() == 0.0f);
		 
	}
	
	@Test(expected=OperationFailedException.class)
	public void testBuyItemWithoutEnoughMoney() {
		
		vm.insertCoin(Coin.QUARTER);
		vm.chooseProduct(Soda.SPRITE);
		vm.dispenseProduct();
		  
	}
	
	@Test(expected=OperationFailedException.class)
	public void testBuyItemWithoutEnoughInventory() {
		
		vm.insertCoin(Coin.QUARTER);
		vm.insertCoin(Coin.QUARTER);
		vm.insertCoin(Coin.QUARTER);
		vm.insertCoin(Coin.QUARTER);
		
		vm.chooseProduct(Soda.COKE);
		vm.dispenseProduct();
		
		vm.chooseProduct(Soda.COKE);
		vm.dispenseProduct();
		
		//This will cause exception since there is not enough cokes
		vm.chooseProduct(Soda.COKE);
		vm.dispenseProduct();
		  
	}
	
	@Test
	public void testRemoveMoney() {
		
		vm.insertCoin(Coin.QUARTER);
		vm.insertCoin(Coin.QUARTER);
		vm.chooseProduct(Soda.COKE);
		vm.dispenseProduct();
		
		assertTrue(vm.getCurrentBalance() == 0.25f);
		vm.removeCoin(Coin.QUARTER);
		
		assertTrue(vm.getCurrentBalance() == 0.0f);
	}
 
 
}