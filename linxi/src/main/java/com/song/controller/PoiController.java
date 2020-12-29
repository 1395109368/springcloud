//package com.song.controller;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//
///**
// * @Version 1.0
// * @Author 宋锋
// * @Date 2020/8/30
// * @Content poi 得实现类
// */
//@Api("这是一个请求层")
//@Controller
//public class PoiController {
//
//  @ApiOperation(value = "", notes = "")
//  @RequestMapping("/poi")
//  public String poiSet(HttpServletRequest request, HttpServletResponse response) {
//    System.out.println("哈哈66，进来了");
//    try {
//      Workbook workbook = new XSSFWorkbook();
//
//      Sheet sheet = workbook.createSheet();
//      Sheet sheet2 = workbook.createSheet();
//      // 表单名
//      workbook.setSheetName(0, "你是我的爱");
//      workbook.setSheetName(1, "完美世界");
//      //创建第一行
//      Row headRow = sheet.createRow(0);
//      //创建第一行
//      Row headRow2 = sheet2.createRow(0);
//      //创建第一行的第一个单元格
//      Cell headCell = headRow.createCell(0);
//      //创建第一行的第一个单元格
//      Cell headCell2 = headRow2.createCell(0);
//      headCell.setCellValue("单元格的内容");
//      headCell2.setCellValue("哈哈");
//      // 设置列宽
//      sheet.setColumnWidth(1, headCell.getStringCellValue().getBytes().length * 256);
//      sheet2.setColumnWidth(1, headCell2.getStringCellValue().getBytes().length * 256);
//      // 合并表头 四个参数按顺序释义分别为：要合并的开始行索引、结束行索引、开始列索引、结束列索引
//      sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
//      sheet2.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
//      // 设置行高度
//      headRow.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));
//      // 设置行高度
//      headRow2.setHeightInPoints((2 * sheet2.getDefaultRowHeightInPoints()));
//      // 提示下载文件
//      File file = new File(System.getProperty("java.io.tmpdir") + File.separator + "文件名" + ".xlsx");
//      OutputStream out = new FileOutputStream(file);
//      workbook.write(out);
//      out.flush();
//      out.close();
//      return "ok";
//    } catch (Exception e) {
//      e.printStackTrace();
//      System.out.println("生成表单失败");
//    }
//
//    return "ok";
//  }
//
//}
