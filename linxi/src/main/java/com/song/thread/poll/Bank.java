package com.song.thread.poll;

/**
 * 如果是自己写俩个人同时取一份钱，以不同的方式
 *
 * @author songfeng
 * @date 2020/12/14
 */
public  class Bank {

  //保证资源的独一份
  static Integer money = 1000;


  private void ATM(Integer money) {
    Bank.money -= money;
    System.out.println("ATM 成功取出" + money + "元,还剩" + Bank.money + "元");
  }

  private void Banki(Integer money) {
    Bank.money -= money;
    System.out.println("Bank 成功取出" + money + "元,还剩" + Bank.money + "元");
  }

  /**
   * @param module 取钱哪一种方式
   * @param money  取钱多少
   * @return
   */
  public synchronized void getMoney(String module, Integer money) {

    if (Bank.money < money) {
      System.out.println("从" + module + "取钱失败 ， 余额还有" + Bank.money + "元");
    }
    if (module.equals("ATM")) {
      ATM(money);
    }
    if (module.equals("Bank")) {
      Banki(money);
    }
  }
}
