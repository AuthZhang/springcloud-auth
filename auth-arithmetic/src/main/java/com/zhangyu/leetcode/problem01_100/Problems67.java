package com.zhangyu.leetcode.problem01_100;


import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/4/20 2:34 下午
 */
@Slf4j
public class Problems67 {

    /**
     * @description:
     *                                        解答成功:
     * 					执行耗时:8 ms,击败了8.88% 的Java用户
     * 					内存消耗:38.6 MB,击败了28.51% 的Java用户
     * @author: zhangyu122
     * @date: 2021/4/20 2:34 下午
     */
    public static String addBinary(String a, String b) {
        int maxL = Math.max(a.length(),b.length());
        StringBuilder stringBuilder = new StringBuilder();
        int temp = 0,intA =0,intB = 0;
        boolean carryFlag = false;
        for (int i = 0; i < maxL ; i++){
            intA = a.length()>i ? Integer.valueOf(a.charAt(a.length()-i-1)+"") : 0;
            intB = b.length()>i ?  Integer.valueOf(b.charAt(b.length()-i-1)+"") : 0;
            temp = carryFlag ? intA+intB+1 : intA+intB;
            if (temp/2 ==1){
                carryFlag = true;
                stringBuilder.append(temp%2);
            }else {
                carryFlag = false;
                stringBuilder.append(temp%2);
            }
            if (i==maxL-1 && carryFlag){
                stringBuilder.append("1");
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }

    /**
     * @description:
     * 参考文章：
     * https://www.huaweicloud.com/articles/6e234b7e670932a3d2bf349df690f5bf.html
     *
     * @author: zhangyu122
     * @date: 2021/4/20 2:34 下午
     */
    public static String addBinary1(String a, String b) {
        int intA = Integer.valueOf(a,2);
        int intB = Integer.valueOf(b,2);
        int i = intA + intB;
        return Integer.toBinaryString(i);
    }


}
