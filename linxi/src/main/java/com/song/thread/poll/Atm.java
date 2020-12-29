package com.song.thread.poll;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class Atm extends Thread {

 private  Bank bank;

  Atm(Bank bank){
   this.bank = bank;
  }


  @Override
  public void run() {
    while (Bank.money >=100) {
      bank.getMoney("ATM", 100);
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
