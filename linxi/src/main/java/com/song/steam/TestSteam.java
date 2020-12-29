package com.song.steam;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Auther: sf
 * @Date: 2020/8/5
 * @version: 1.0
 *  联系stram的操作
 */
@Slf4j
public class TestSteam {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        List<Person> personList1 = new ArrayList<>();
        personList.add(new Person("欧阳雪",18,"中国",'F'));
        personList.add(new Person("Tom",24,"美国",'M'));
        personList.add(new Person("Harley",22,"英国",'F'));
        personList.add(new Person("向天笑",20,"中国",'M'));
        personList.add(new Person("李康",22,"中国",'M'));
        personList.add(new Person("小梅",20,"中国",'F'));
        personList.add(new Person("何雪",21,"中国",'F'));
        personList.add(new Person("李康",22,"中国",'M'));
        personList.add(new Person("李康",500,"中国",'M'));

        personList.stream().filter((p)->p.getAge()>20).collect(Collectors.toList());  //给到一个集合里


        log.info(""+personList.stream().filter((f)->f.getCountry().equals("中国")).count());

  //     log.info("去重"+personList.stream().filter((p)->p.getAge().equals("22")).limit(2).distinct().forEach(System.out::println));

        personList.stream().map((p)->{
            MapTest a = new MapTest();
            a.setControy(p.getCountry());
            return a;
        }).forEach(System.out::println);


        ConcurrentHashMap<String,String> a  =new ConcurrentHashMap<String,String>();
        a.put("123","456");
        System.out.println("哈哈"+a.get("123"));

        Collections.synchronizedMap(new HashMap<>());
    }

}
