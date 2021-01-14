package com.song.linxi;

import com.atguigu.springcloud.entities.Student;
import com.atguigu.springcloud.entities.Teacher;
import org.springframework.beans.BeanUtils;

/**
 * @author songfeng
 * @date 2020/09/12
 */
public class BugTest {

  public static void main(String[] args) {

    Student student = new Student();
    student.setAge("22");
    student.setName("小红");

    Teacher teacher = new Teacher();
    BeanUtils.copyProperties(student,teacher);

    System.out.println(teacher.toString());

  }
}