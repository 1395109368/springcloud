package com.song.linxi;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author songfeng
 * @date 2020/11/11
 */
public class LocalDateTimeTest {

  public static void main(String[] args) {

    LocalDateTime now = LocalDateTime.now();
    LocalDateTime zeroDay = LocalDateTime.of(now.toLocalDate(), LocalTime.MIN);

    System.out.println(zeroDay);
  }
}