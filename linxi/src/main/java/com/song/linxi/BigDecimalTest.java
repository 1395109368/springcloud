package com.song.linxi;

import java.util.Arrays;
import java.util.List;

/**
 * @author songfeng
 * @date 2020/10/20
 */
public class BigDecimalTest {

  public static void main(String[] args) {


    System.out.println(getTableColumn("2018"));

//    BigDecimal b1 = new BigDecimal("1");
//    BigDecimal b2 = new BigDecimal("3");
//    System.out.println(b1.divide(b2, 8, BigDecimal.ROUND_HALF_UP).doubleValue());



  }

  public static List<TableColumn> getTableColumn(String year) {

    //全市法院办案情况表头
    List<TableColumn> qsfybaqk = Arrays
        .asList(new TableColumn("法院", "fy",
                Arrays.asList(new TableColumn("", "fyName"), new TableColumn("", "fyType"))),
            new TableColumn("案件总数", "anzs",
                Arrays.asList(new TableColumn(year, "anzs"), new TableColumn("同比", "anzs-tb"))),
            new TableColumn("旧存", "jc",
                Arrays.asList(new TableColumn(year, "jc"), new TableColumn("同比", "jc-tb"))),
            new TableColumn("新收案", "xsa",
                Arrays.asList(new TableColumn(year, "xsa"), new TableColumn("同比", "xsa-tb"))),
            new TableColumn("结案总数", "jazs",
                Arrays.asList(new TableColumn(year, "jazs"), new TableColumn("同比", "jazs-tb"))),
            new TableColumn("当前未结案件数", "dq",
                Arrays.asList(new TableColumn(year, "dq"), new TableColumn("同比", "dq-tb"))),
            new TableColumn("结收案比", "jsab",
                Arrays.asList(new TableColumn(year, "jsab"), new TableColumn("同比", "jsab-tb"))),
            new TableColumn("结案率", "jal",
                Arrays.asList(new TableColumn(year, "jal"), new TableColumn("同比", "jal-tb"))),
            new TableColumn("员额法官人均结案数(件)", "yefg")
        );
    return qsfybaqk;
  }





}