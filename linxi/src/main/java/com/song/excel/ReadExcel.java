package com.song.excel;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author songfeng
 * @date 2020/10/30
 */
public class ReadExcel {

  public static void main(String[] args) throws IOException {
    User user = new User();
    user.set哈哈("哈哈");
    user.setAge(7);
    user.setBirthday("22222222");
    User user1 = new User();
    user1.set哈哈("呵呵");
    user1.setAge(7483874);
    user1.setBirthday("22222222");
    ArrayList<User> users = new ArrayList<>();
    users.add(user);
    users.add(user1);
    System.out.println(users.toString());




  }

}