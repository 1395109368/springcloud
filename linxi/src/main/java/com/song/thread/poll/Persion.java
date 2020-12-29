package com.song.thread.poll;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class Persion extends Thread {

  private Bank bank;

  Persion(Bank bank) {
    this.bank = bank;
  }


  @Override
  public void run() {
    while (Bank.money >=50) {
      bank.getMoney("Bank", 50);
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Bank bank = new Bank();
    //同一份实例
    Persion persion = new Persion(bank);
    Atm a = new Atm(bank);
    persion.start();
    a.start();
  }
}
