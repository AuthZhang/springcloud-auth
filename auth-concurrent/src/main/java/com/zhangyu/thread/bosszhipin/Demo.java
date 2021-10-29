package com.zhangyu.thread.bosszhipin;

import java.util.Random;

public class Demo {


    /**
     * 第二题
     SELECT
     id,
     name,
     IFNULL( v.count, 0 ) AS vacation_total
     FROM
     employe e
     LEFT JOIN ( SELECT employe_id, count( employe_id ) AS count FROM vacation GROUP BY employe_id ) v ON e.id = v.employe_id
     ORDER BY
     v.count DESC;

     * @param args
     */
    // 第一题
    public static void main(String[] args) {

    }


    // 第三道题，从1000万个数中找到最小的十个数，并顺序打印出来
//    public static void main(String[] args) {
//
//
//        for (int h = 0;h<10;h++){
//            int[] a = new int[10000000];
//            for (int i = 0;i<10000000;i++){
//                Random random = new Random();
//                while ( (a[i] = random.nextInt()) < 0){
//                }
//            }
//            long l = System.currentTimeMillis();
//            point(a);
//            long m = System.currentTimeMillis();
//            System.out.println();
//            System.out.println( "第" + h +"次"+(m - l) /10 );
//            System.out.println();
//            System.out.println();
//        }


//        int[] a = new int[]{121,32434,5454325,41,13,545,42435,4234231,6576,214687,5234,526822,673434,643,51356,34,3461,45371,444,6424};
//        int[] a = new int[]{2,5,7,1,9,5,11,3,5,8,77};
//        point(a);
//        for (int i = 0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
//    }

    public static void point(int[] array){
        // 从小到大排列
        int[] result = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        for (int i = 0;i<array.length;i++){
            int data = array[i];
            int j = getIndex(result,data);
            if (j == -1){
                continue;
            }
            move(result,data,j);
        }
        for (int i = 0;i<10;i++){
            System.out.println(result[i]);
        }
    }
    // 获取data在数组中需要被替换的下标
    public static int getIndex(int[] array,int data){
        int j = array.length-1;
        while (j>=0){
            if (j == 0 && data<array[j]){
                return 0;
            }
            if (data > array[j]){
                return j+1 > array.length-1 ? -1 : j+1;
            }
            j--;
        }
        return -1;
    }
    /**
     * @param j 需要被替换为data的元素下标
     */
    public static void move(int[] array,int data,int j){
        for (int i = array.length-1;i>j;i--){
            array[i] = array[i-1];
        }
        array[j] = data;
    }

    // 第四道笔试题
//    public static void main(String[] args) throws InterruptedException{
//        Thread a = new Thread(()->{
//            System.out.println("a");
//        });
//        Thread b = new Thread(()->{
//            try {
//                a.join();
//            }catch (InterruptedException e){
//            }
//            System.out.println("b");
//        });
//        Thread c = new Thread(()->{
//            try {
//                b.join();
//            }catch (InterruptedException e){
//            }
//            System.out.println("c");
//        });
//        c.start();
//        b.start();
//        a.start();
//    }
}
