package com.mho.sodavendingmachine.state;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Soda;

public interface VendingMachineState{

  public float insertCoin(float currentBalance, Coin coin);
  
  public float removeCoin(float currentBalance, Coin coin);
  
  public float chooseProduct(float currentBalance, Soda soda);

  public void dispenseProduct();

}