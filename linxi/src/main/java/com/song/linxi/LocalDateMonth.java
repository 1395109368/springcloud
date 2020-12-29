package com.song.linxi;

import java.util.Calendar;

/**
 * @author songfeng
 * @date 2020/11/17
 */
public class LocalDateMonth {

  public static void main(String[] args) {
    String[] last12Months = new String[12];
    Calendar cal = Calendar.getInstance();
    //如果当前日期大于二月份的天数28天或者29天会导致计算月份错误，会多出一个三月份，故设置一个靠前日期解决此问题
    cal.set(Calendar.DAY_OF_MONTH, 1);
    for (int i = 0; i < 12; i++) {
      last12Months[11 - i] = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
      cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
    }
    for (int i = 0; i < last12Months.length; i++) {
      System.out.println(last12Months[i]);
    }






  }
}
