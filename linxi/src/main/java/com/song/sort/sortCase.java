package com.song.sort;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: sf
 * @Date: 2020/8/21
 * @version: 1.0
 */
public class sortCase {

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        // String c = sc.nextLine();

        String  c  ="nhrwlbcc8m7c5hih9mhalw98k0322wf2jjm47kk3ntm9snfrflzzundn7d608usy049asxalzjk7izj6amcqhr8uubc04g52mcjboj2fmge2l6iarizfu4yve5o4i3srf5zgqbg82ckcotdeqp760mc9gzei5dzk5gj9x9yj05o3hle0ii64krkkp5i7blh7nbu3gu5vgi2scyn4yqx3z4vcjbyzhnqkh887izotjkg2l0mit0k14vyn39\n" +
                "t";

        String[] p = c.toUpperCase().split("");
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<p.length;i++){

            if(p[i].equals("A")){


                if(map.containsKey("A")){
                    map.put("A",map.get("A")+1);
                }else{
                    System.out.println("不存在");


                    map.put("A",1);
                }
            }

        }

        System.out.println(map.get("A"));






        int[]  array = {5,69,8,9,2};

//      for (int i = 0;i<array.length;i++){
//          for (int j = 0;j<array.length-1-i;j++){
//
//              if(array[j]>array[j+1]){
//                  int a = array[j];
//                  array[j] = array[j+1];
//                  array[j+1]=a;
//              }
//
//
//          }
//
//      }

    //      System.out.println(Arrays.toString(array));


    }

}


//public class Main {
//
//    public static void main(String[] args) {
//
//
//
//
//    }
//
//}