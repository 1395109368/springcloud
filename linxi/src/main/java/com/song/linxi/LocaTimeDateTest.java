package com.song.linxi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author songfeng
 * @date 2020/11/13
 */

public class LocaTimeDateTest {

  public static void main(String[] args) {

    Calendar begin = Calendar.getInstance();// 得到一个Calendar的实例
    begin.setTime(new Date()); // 设置时间为当前时间
    begin.set(Calendar.HOUR_OF_DAY, 0);
    begin.set(Calendar.MINUTE, 0);

    begin.add(Calendar.YEAR, -1);// 月份减1

    begin.add(Calendar.DATE, +0);// 日期加1
    Date result = begin.getTime();
    Calendar end = Calendar.getInstance();
    Long startTime = begin.getTimeInMillis();
    Long endTime = end.getTimeInMillis();
    Long oneDay = 1000 * 60 * 60 * 24L;// 一天的时间转化为ms
    List dates = new ArrayList<>();
    Long time = startTime;
    int i = 0;
    while (time <= endTime) {

      LocalDateTime localDate = new Date(time).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();


      System.out.println("时间 :"+localDate);
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   //   dates.add(i, df.format(d));
      i++;
      time += oneDay;
    }
    for (int j = 0; j < dates.size(); j++) {
      System.err.println(dates.get(j));
    }
  }
}