package com.song.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.util.StringUtils;

/**
 * @author songfeng
 * @date 2020/11/09
 */
public class ExcelJudiciialTest {

  public static void main(String[] args) {

    StringBuffer bf = new StringBuffer();
    StringBuffer beforebf = new StringBuffer();
    try {
      ExcelReader reader = ExcelUtil.getReader("D:\\111.xls");
      //解析数据
      //分为俩中情况，一种是内置标签

      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      //内置标签解析数据，按照表内容，验证每一个数据的正确性
      //解析内容
      List<JudicialInsecurityDto> list = new ArrayList<>();
      List<List<Object>> read = reader.read(2, reader.getRowCount());

      for (int i = 2; i < reader.getRowCount(); i++) {
        // 获取每一行数
        Row orCreateRow = reader.getOrCreateRow(i);
        for (int cell = 0; cell < reader.getColumnCount(); cell++) {
          JudicialInsecurityDto judicialInsecurityDto = new JudicialInsecurityDto();
          //身份证号
          judicialInsecurityDto.setCard(orCreateRow.getCell(cell).toString());
          ++cell;
          //事件发生时间
          judicialInsecurityDto
              .setHappenTime(simpleDateFormat.parse(orCreateRow.getCell(cell).toString()));
          ++cell;
          //执行单位
          judicialInsecurityDto.setExecuteUnit(orCreateRow.getCell(cell).toString());
          ++cell;
          //事件发生地点
          judicialInsecurityDto.setHappenSite(orCreateRow.getCell(cell).toString());
          ++cell;
          //内容
          judicialInsecurityDto.setContent(orCreateRow.getCell(cell).toString());
          ++cell;
          //事件执行人姓名
          judicialInsecurityDto.setExecuteName(orCreateRow.getCell(cell).toString());
          ++cell;
          //来源
          judicialInsecurityDto.setSource(orCreateRow.getCell(cell).toString());
          ++cell;
          //类别
          if(StringUtils.isEmpty(orCreateRow.getCell(cell))){
            //为空
            judicialInsecurityDto.setCategory("");
          }else {
            judicialInsecurityDto.setCategory(orCreateRow.getCell(cell).toString());
          }
          ++cell;
          //省份代码
          //.substring(0,orCreateRow.getCell(cell).toString().indexOf("."))
          judicialInsecurityDto.setProvinceCode(orCreateRow.getCell(cell).toString());
          ++cell;
          //省份
          judicialInsecurityDto.setProvinceName(orCreateRow.getCell(cell).toString());
          ++cell;
          //地市代码
          judicialInsecurityDto.setCityCode(orCreateRow.getCell(cell).toString());
          ++cell;
          //地市
          judicialInsecurityDto.setCityName(orCreateRow.getCell(cell).toString());
          ++cell;
          //区县代码
          judicialInsecurityDto.setAreaCode(orCreateRow.getCell(cell).toString());
          ++cell;
          //区县
          judicialInsecurityDto.setAreaName(orCreateRow.getCell(cell).toString());
          judicialInsecurityDto.setCreateTime(new Date());
          // judicialInsecurityDto.setCreateUser();
          list.add(judicialInsecurityDto);
        }
      }
      System.out.println(list.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}