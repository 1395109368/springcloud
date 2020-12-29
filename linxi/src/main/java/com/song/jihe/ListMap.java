package com.song.jihe;

import java.util.*;

/**
 * @Auther: sf
 * @Date: 2020/8/4
 * @version: 1.0
 */
public class ListMap {

    public static void main(String[] args) {

        TreeSet<String> tree = new TreeSet<String>();
        Set<String> synSet = Collections.synchronizedSet(new HashSet<>());
        List<String> c=  Collections.synchronizedList(new ArrayList<>());
        String a = "123";
    }
}
