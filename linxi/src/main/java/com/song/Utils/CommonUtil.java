package com.song.Utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 * @author renchunpeng
 * @description 常用公共方法
 * @date 2020-11-09 4:57 下午
 */
public class CommonUtil {

  public static void main(String[] args) {
   System.out.println( CommonUtil.setDoubleScale2(CommonUtil
       .retainDecimal(Double.valueOf(-69),
           Double.valueOf(8), 4) * 100));
  }

  /**
   * 获取上一个统计周期
   *
   * @param start 开始时间
   * @return
   */
  public static Map<String, Date> preStatisticalPeriod(String start, String end) {
    DateTime preDate = DateUtil.parse(start, "yyyy-MM-dd");
    DateTime atDate = DateUtil.parse(end, "yyyy-MM-dd");
    long startTime = preDate.getTime();
    long endTime = atDate.getTime();
    long cha = endTime - startTime + 60 * 60 * 24 * 1000;
    long newStartTime = startTime - cha;
    long newEndTime = endTime - cha;
    Date newStart = new Date(newStartTime);
    Date newEnd = new Date(newEndTime);
    Map<String, Date> map = new HashMap<>(16);
    map.put("start", newStart);
    map.put("end", newEnd);
    return map;
  }

  /**
   * 获取上一个统计周期
   *
   * @param preDate 开始时间
   * @param endDate 结束时间
   * @return
   */
  public static Map<String, Date> preStatisticalPeriod(Date preDate, Date endDate) {
    long startTime = preDate.getTime();
    long endTime = endDate.getTime();
    long cha = endTime - startTime + 60 * 60 * 24 * 1000;
    long newStartTime = startTime - cha;
    long newEndTime = endTime - cha;
    Date newStart = new Date(newStartTime);
    Date newEnd = new Date(newEndTime);
    Map<String, Date> map = new HashMap<>(16);
    map.put("start", newStart);
    map.put("end", newEnd);
    return map;
  }

  public static String formatStart(String start) {
    return start + " 00:00:00";
  }

  public static String formatEnd(String end) {
    return end + " 23:59:59";
  }

  /**
   * 计算同比时间
   *
   * @param preDate 开始时间
   * @param endDate 结束时间
   * @return
   */
  public static Map<String, Date> yoyDate(Date preDate, Date endDate) {
//    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Calendar pre = Calendar.getInstance();
    pre.setTime(preDate);
    pre.add(Calendar.YEAR, -1);
    Date y = pre.getTime();

    Calendar end = Calendar.getInstance();
    end.setTime(endDate);
    end.add(Calendar.YEAR, -1);
    Date e = end.getTime();
    Map<String, Date> map = new HashMap<>(16);
    map.put("start", y);
    map.put("end", e);
    return map;
  }

  /**
   * 计算同比，返回保留两位消暑的半分比
   *
   * @param now 当前数据
   * @param pre 上一个区间的数据
   * @return
   */
  public static String countYoy(Integer now, Integer pre) {
    String yoy = "";
    if (Integer.valueOf(0).equals(pre)) {

    } else {
      BigDecimal sub = NumberUtil.sub(now, pre);
      BigDecimal div = NumberUtil.div(sub, pre);
      yoy = NumberUtil.decimalFormat("#.##%", div);
    }
    return yoy;
  }

  /**
   * 两个Double数相除，并保留scale位小数
   *
   * @param v1    double型数据
   * @param v2    double型数据
   * @param scale 精确度
   * @return Double
   */
  public static Double retainDecimal(Double v1, Double v2, int scale) {
    if (scale < 0) {
      throw new IllegalArgumentException(
          "The scale must be a positive integer or zero");
    }
    if (v2 == 0.0) {
      v2 = 1.0;
    }
    // BigDecimal.ROUND_HALF_UP
    BigDecimal b1 = new BigDecimal(v1.toString());
    BigDecimal b2 = new BigDecimal(v2.toString());
    return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
  }

  /**
   * 保留两位小数
   */
  public static Double setDoubleScale2(Double a) {
    BigDecimal bd = new BigDecimal(a);
    Double num = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    return num;
  }


  /**
   * 保留四位小数
   */
  public static Double setDoubleScale4(Double a) {
    BigDecimal bd = new BigDecimal(a);
    Double num = bd.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    return num;
  }

  /**
   * 防止精度丢失自定义计算方法
   */
  public static double multiply(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.multiply(b2).doubleValue();
  }

  /**
   * Date转LocalDate
   */
  public static LocalDate date2LocalDate(Date date) {
    if (null == date) {
      return null;
    }
    return date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDate();
  }

  /**
   * 文件下载
   *
   * @param response
   * @param inputStream
   * @param filename
   * @throws UnsupportedEncodingException
   */
  public static void getWordByInputStream(HttpServletResponse response, InputStream
      inputStream, String filename) throws IOException {
    BufferedInputStream bis = null;
    OutputStream out = null;
    // 告诉浏览器，当前响应数据要求用户干预保存到文件中，以及文件名是什么 如果文件名有中文，必须URL编码
    filename = URLEncoder.encode(filename, "UTF-8");
    // 设置response参数，可以打开下载页面
    response.setHeader("Content-Disposition", "attachment;filename=" + filename);
    try {
      out = response.getOutputStream();
      bis = new BufferedInputStream(inputStream);
      byte[] buff = new byte[1024 * 2];
      int count;
      while ((count = bis.read(buff)) != -1) {
        out.write(buff, 0, count);
      }
      out.flush();
      out.close();
    } catch (IOException e) {

    } finally {
      if (out != null) {
        out.close();
      }
    }
  }

  public static Map<String, String> checkCityOrProvince(String code) {
    Map<String, String> map = new HashMap(16);
    if (code.endsWith("0000") && code.length() == 6) {
      map.put("provinceCode", code);
    } else {
      map.put("cityCode", code);
    }

    return map;
  }

}
