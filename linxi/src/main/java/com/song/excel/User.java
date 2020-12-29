package com.song.excel;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author songfeng
 * @date 2020/11/03
 */
@Data
public class User {


  private Long id;
  private String 哈哈;
  private Boolean sex;
  private Integer age;
  private String birthday;

  public static void main(String[] args) {

  // System.out.println(div(50.0,120.0,2));

    Double  ac =120.0 / 10 ;
   System.out.println(ac.byteValue());


  }
  private static Double div(Double v1, Double v2, int scale) {
    if (scale < 0) {
      throw new IllegalArgumentException(
          "The scale must be a positive integer or zero");
    }
    if (v2 == 0.0) {
      v2 = 1.0;
    }
    BigDecimal b1 = new BigDecimal(v1.toString());
    BigDecimal b2 = new BigDecimal(v2.toString());

    return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
  }
}