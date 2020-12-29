package com.song.ParentChilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author songfeng
 * @date 2020/12/22
 */
public class Child extends Parent {


  public static void main(String[] args) {

    String before = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";

    //  ^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$
    //15295793474
    String phone = "15295793474";
    String regex = "^(13[0-9]|14[01456879]|15[0-3,5-9]|16[2567]|17[0-8]|18[0-9]|19[0-3,5-9])\\d{8}$";

    String aa = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

    if (phone.length() != 11) {
      System.out.println("手机号应为11位数");
    } else {
      Pattern p = Pattern.compile(aa);
      Matcher m = p.matcher(phone);
      boolean isMatch = m.matches();
      if (isMatch) {
        System.out.println("您的手机号" + phone + "是正确格式@——@");
      } else {
        System.out.println("您的手机号" + phone + "是错误格式！！！");
      }

    }
  }
}