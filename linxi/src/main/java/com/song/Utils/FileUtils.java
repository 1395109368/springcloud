package com.song.Utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：songfeng
 * @date ：Created in 2020/9/7 10:33
 * @description：文件处理
 */
@Component
@Slf4j
public class FileUtils {


  /**
   *  上传excel表格
   * @param fileName  文件的名字
   * @param multipartFile 文件对象
   * @return
   * @throws IOException
   */
  public String saveToLocal( String fileName, MultipartFile multipartFile)
      throws IOException {
    InputStream inputStream = null;
    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
    fileName = "/" +  uuid + fileName.substring(fileName.lastIndexOf("."));
    try {
      File file = new File("D:\\" + fileName);
      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      file.createNewFile();
      inputStream = multipartFile.getInputStream();
      inputStream.available();
      OutputStream outputStream = new FileOutputStream(file);
      byte[] b = new byte[1024];
      int len;
      while ((len = inputStream.read(b)) > 0) {
        outputStream.write(b, 0, len);
      }
    } catch (IOException e) {
      log.error("异常错误===", e);
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
    }
    return fileName;
  }


  public boolean deleteFile(String path) {
    File file = new File("D:\\" + path);
    boolean delete = file.delete();
    return delete;
  }


  /**
   *  下载文件
   * @param path  路径
   * @param response 相应对象
   * @return
   */
  public HttpServletResponse download(String path, HttpServletResponse response) {
    try {
      // path是指欲下载的文件的路径。
      //  File file = new File(filePath+path);

      File file = new File("D\\" + path);
      // 取得文件名。
      String filename = file.getName();
      // 取得文件的后缀名。
      //   String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
      // 以流的形式下载文件。
      InputStream fis = new BufferedInputStream(new FileInputStream(file));
      byte[] buffer = new byte[fis.available()];
      fis.read(buffer);
      fis.close();
      // 清空response
      response.reset();
      // 设置response的Header
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
      response.addHeader("Content-Disposition",
          "attachment;filename=" + new String(filename.getBytes()));
      response.addHeader("Content-Length", "" + file.length());
      OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
      response.setContentType("application/octet-stream");
      toClient.write(buffer);
      toClient.flush();
      toClient.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return response;
  }
}
