package com.song.excel;

import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  excel导出表格测试类
 * @author songfeng
 * @date 2020/09/24
 */
@RestController
@RequestMapping("/excel")
public class ExcelText {

  @RequestMapping("demo/infoinfo")
  public void ss(HttpServletRequest request, HttpServletResponse response) {

    HSSFWorkbook wb = new HSSFWorkbook();
    // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
    HSSFSheet sheet = wb.createSheet("学生表一");
   // HSSFSheet sheet2 = wb.createSheet("学生表二");
    // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
  //  HSSFRow row = sheet.createRow((int) 0);
  //  HSSFRow row2 = sheet.createRow((int) 1);

    HSSFRow row0 = sheet.createRow((int) 0);
    HSSFCell cell0 = row0.createCell((short) 0);
    cell0.setCellValue("2020年1-3月中院审判质效主要指标统计表");



    HSSFRow row1 = sheet.createRow((int) 1);
    int columnIndex = 0;
    row1.createCell(columnIndex).setCellValue("对象名称");
    row1.createCell(++columnIndex).setCellValue("人均结案数");
    row1.createCell(++columnIndex).setCellValue("一审判决案件被改判发回重审数");
    row1.createCell(++columnIndex).setCellValue("一审判决案件被改判发回重审率");
    row1.createCell(++columnIndex).setCellValue("一审服判息速率");
    row1.createCell(++columnIndex).setCellValue("民事调撤率");
    row1.createCell(++columnIndex).setCellValue("法定正常审核内结案");


//
//    HSSFCellStyle style = wb.createCellStyle();
//    // 创建一个居中格式
//    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//
//    HSSFCell cell33 = row.createCell((short) 0);
//
//    cell33.setCellValue("2020年1-3月中院审判质效主要指标统计表");
//    cell33.setCellStyle(style);
//    // 创建第二行
//    HSSFCell cell22 = row2.createCell((short) 0);
//    cell22.setCellValue("对象名称");
//    cell22.setCellStyle(style);
//
//    HSSFCell cell = row2.createCell((short) 1);
//
//    //第一行第二个单元格
//    cell22 = row2.createCell((short) 2);
//    cell22.setCellValue("姓名");
//    cell22.setCellStyle(style);
//    cell22 = row2.createCell((short) 3);
//    cell22.setCellValue("年龄");
//    cell22.setCellStyle(style);
//    cell22 = row2.createCell((short) 4);
//    cell22.setCellValue("生日");
//    cell22.setCellStyle(style);
//
//    // 第四步，创建单元格，并设置值表头 设置表头居中
//
//    //第一行第一个单元格
//    Member a = new Member();
//    a.setCode(1);
//    a.setAge(1);
//    a.setBirth(new Date());
//    a.setCode(123);
//    a.setName("你好啊");
//    // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
//    List<Member> list = new ArrayList<Member>();
//    list.add(a);
//    list.add(a);
//    list.add(a);
//    for (int i = 0; i < list.size(); i++) {
//      row = sheet.createRow((int) i + 2);
//      Member stu = (Member) list.get(i);
//      // 第四步，创建单元格，并设置值
//      row.createCell((short) 0).setCellValue((double) stu.getCode());
//      row.createCell((short) 1).setCellValue(stu.getName());
//      row.createCell((short) 2).setCellValue((double) stu.getAge());
//      row.createCell((short) 3)
//          .setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
//    }
    // 合并表头 四个参数按顺序释义分别为：要合并的开始行索引、结束行索引、开始列索引、结束列索引
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
    OutputStream out = null;
    try {
      out = response.getOutputStream();

      String fileName = "苍天大地.xls";// 文件名
      response.setHeader("Content-Disposition", "attachment; filename="
          + URLEncoder.encode(fileName, "UTF-8"));
      response.setContentType("application/vnd.ms-excel;charset=UTF-8");
      wb.write(out);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        out.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    //        response.setContentType("application/x-msdownload");
  }


}