package com.song.steam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: sf
 * @Date: 2020/8/5
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  private String name;
  private Integer age;
  private String country;
  private char sex;


}
