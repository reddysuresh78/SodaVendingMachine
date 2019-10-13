package com.mho.sodavendingmachine.service;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Soda;

public interface VendingMachineService {
	
	  public void insertCoin(Coin coin);
	  
	  public void removeCoin(Coin coin);
	  
	  public void chooseProduct(Soda soda);

	  public void dispenseProduct();
	  
	  public float getCurrentBalance();

}
