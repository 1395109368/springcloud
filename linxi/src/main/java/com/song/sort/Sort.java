package com.song.sort;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: sf
 * @Date: 2020/6/20
 * @version: 1.0
 */
public class Sort {
    String c="132";
    private void pp(){
        new newService(){
            @Override
            public  void  method(String c){
                System.out.println("哈哈"+c);
            }
        }.method(c);
    }
    public static void main(String[] args) {
        //冒泡排序  写一个从大到小的排序
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        Sort cc  = new Sort();
        cc.pp();
        //跳出多层循环，在外面定义一个标记，然后就可以跳出整个循环嵌套层
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (j == 5) {
                    break ok;
                }

            }

            //确定集合不被修改
            List<String> list = new ArrayList<String>();
            Collection<String> listbak= Collections.unmodifiableCollection(list);
            //多线程调用时可以使用如下方法
            List<String> list1 = Collections.synchronizedList(list);
            ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>();




            //希尔排序
            //   xier(array);


            //归并排序
            // guibing(array);

            //插入排序
            //  charu(array);
            //选择排序,用到他的时候数据越小越好，他会记录最小元素的索引，然后替换，但是这样太耗费时间了
            //xuanze(array);
            //冒泡排序
            //  maopao( array);

        }
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void maopao ( int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int bak = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = bak;
                }
            }
        }

        System.out.println("冒泡排序" + Arrays.toString(array));
    }

    /**
     * 选择排序
     * @param array
     */
    public static void xuanze ( int[] array){
        //    int[] array  = {10,25,5,8,3,89,1};
        for (int i = 0; i < array.length - 1; i++) {  //这边减1 代表和每个数做过对比之后，最后一个不用做对比
            int index = i; //记录索引，最小值,代表当前和那个值做对比
            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[index]) { //如果第一个数小于第二个数，则记录索引，逐个比较，把最小值筛选出来
                    index = j; //把这个值最小的挑出来
                }
            }
            if (i != index) {  //防止本身
                int c = array[i]; //这是最小值
                array[i] = array[index];
                array[index] = c;
            }

        }

        System.out.println("选择排序" + Arrays.toString(array));


    }

    /**
     * 插入排序
     * @param array
     */
    public static void charu ( int[] array){

        int num;
        for (int i = 1; i < array.length; i++) {
            num = array[i];
            int j = i - 1; //已经排序好的元素个数
            while (j >= 0 && array[j] > num) {   //比出最小的一个数，从后往前排列
                //比I 的值大的  统统往后移动一个
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = num;

        }

        System.out.println("插入排序" + Arrays.toString(array));


    }

    /**
     *  归并排序
     * @param array
     */
    public static void guibing ( int[] array){
        sort(array, 0, array.length - 1);

    }

    private static void sort ( int[] array, int left, int right){
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        // 对左侧子序列进行递归排序
        sort(array, left, mid);
        // 对右侧子序列进行递归排序
        sort(array, mid + 1, right);
        // 合并
        merge(array, left, mid, right);
    }

    private static void merge ( int[] array, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= right) {
            temp[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = array[p1++];
        }
        while (p2 <= right) {
            temp[i++] = array[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }

        System.out.println("归并排序" + Arrays.toString(array));

    }


    public static void xier ( int[] array){
        int length = array.length;

        // temp为临时变量，gap增量默认是长度的一半，每次变为之前的一半，直到最终数组有序
        int temp, gap = length / 2;
        //     int[] array  = {8,9,1,7,2,3,5,4,6,0};

        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                // 将当前的数与减去增量之后位置的数进行比较，如果大于当前数，将它后移
                temp = array[i];//3   gap=4;     这个gap的值是不会变的
                //89  gap=5
                int preIndex = i - gap;//0  位置等于0
                //5
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }

                // 将当前数放到空出来的位置
                array[preIndex + gap] = temp;   //放到了前面
            }


            gap /= 2;

            System.out.println("第一次" + Arrays.toString(array));
        }
        //    System.out.println("希尔排序"+Arrays.toString(array));


    }




}
interface  newService {
    void method(String c);
}