package com.song.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author songfeng
 * @date 2020/11/06
 */
public class HutoolExcelTest {
  String json = "[{\"moduleId\":18,\"moduleName\":\"小程序引导页\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":17,\"moduleName\":\"相关链接\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":15,\"moduleName\":\"案件信息\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":14,\"moduleName\":\"法律法规\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":16,\"moduleName\":\"公共服务\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":6,\"moduleName\":\"公共服务-警示教育-以案释法\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":7,\"moduleName\":\"公共服务-警示教育-典型案例\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":8,\"moduleName\":\"公共服务-警示教育-处非宣传\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":3,\"moduleName\":\"公共服务-金融知识-银行保险\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":4,\"moduleName\":\"公共服务-金融知识-证券期货\", \"fileName\":null, \"linkContent\":null},{\"moduleId\":5,\"moduleName\":\"公共服务-金融知识-地方金融\", \"fileName\":null, \"linkContent\":null}]";

  String  area = "[{\"id\":1,\"name\":\"江苏省\",\"code\":\"320000\",\"pid\":\"0\"},{\"id\":2,\"name\":\"南京市\",\"code\":\"320100\",\"pid\":\"1\"},{\"id\":3,\"name\":\"无锡市\",\"code\":\"320200\",\"pid\":\"1\"},{\"id\":4,\"name\":\"徐州市\",\"code\":\"320300\",\"pid\":\"1\"},{\"id\":5,\"name\":\"常州市\",\"code\":\"320400\",\"pid\":\"1\"},{\"id\":6,\"name\":\"苏州市\",\"code\":\"320500\",\"pid\":\"1\"},{\"id\":7,\"name\":\"南通市 \",\"code\":\"320600\",\"pid\":\"1\"},{\"id\":8,\"name\":\"连云港市 \",\"code\":\"320700\",\"pid\":\"1\"},{\"id\":9,\"name\":\"淮安市 \",\"code\":\"320800\",\"pid\":\"1\"},{\"id\":10,\"name\":\"盐城市 \",\"code\":\"320900\",\"pid\":\"1\"},{\"id\":11,\"name\":\"扬州市 \",\"code\":\"321000\",\"pid\":\"1\"},{\"id\":12,\"name\":\"镇江市 \",\"code\":\"321100\",\"pid\":\"1\"},{\"id\":13,\"name\":\"泰州市 \",\"code\":\"321200\",\"pid\":\"1\"},{\"id\":14,\"name\":\"宿迁市 \",\"code\":\"321300\",\"pid\":\"1\"}]";


  public static void main(String[] args) {

   String filePath = "D:\\司法安全隐患上传模版 .xlsx";
 //   String filePath = "D:\\111.xls";

    ExcelReader reader = ExcelUtil.getReader(filePath);
    System.out.println("--"+reader.read());

    System.out.println("每一行列数"+reader.getColumnCount());
    List<List<Object>> read = reader.read(2,Integer.MAX_VALUE);

    Row orCreateRow = reader.getOrCreateRow(2);

    System.out.println( "列数"+orCreateRow.getCell(1));

    List<Object>  list = read.get(0);


    System.out.println("哈哈"+list.toString());



    //解析数据
  //  List<Map<String, Object>> maps = reader.readAll();

    List<Map<String,Object>> maps = reader.read(1,2,Integer.MAX_VALUE);



    StringBuffer bf = new StringBuffer();
    for (int i = 0; i < maps.size(); i++) {
      bf.append("{");
      for (String key : maps.get(i).keySet()) {
   //     System.out.println(key + " = " + maps.get(i).get(key));
        bf.append("\\\""+key+"\\\":\\\""+maps.get(i).get(key)+"\\\",");
      }
      bf.deleteCharAt(bf.length() - 1);
      bf.append("},");
    }
    bf.deleteCharAt(bf.length() - 1);
    bf.append("]");

    System.out.println(bf.toString());



//    for (int i = 0; i < maps.size(); i++) {
//      int j = 0;
//         maps.get(i);
//     for(String key: maps.get(i).keySet()){
//           ++j;
//         System.out.println(key+" = "+maps.get(i).get(key));
//
//         System.out.println("列数"+j);
//     }
//
//    }

  //  List<Object> read = reader.readRow(1);

    List<Object> objects = reader.readAll(Object.class);

  //  System.out.println(objects.toString());



//  maps.stream().forEach(map -> map.entrySet().stream().forEach(
//       item -> System.out.println("Column: " + item.getKey() + " Value: " + item.getValue())));

  }


  private static boolean checkDate(String str){
    String[] dataArr =str.split("-");
    try {
      if(dataArr.length == 3){
        int x = Integer.parseInt(dataArr[0]);
        String y =  dataArr[1];
        int z = Integer.parseInt(dataArr[2]);
        if(x>0 && x<32 && z>0 && z< 10000 && y.endsWith("月")){
          return true;
        }
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }


}