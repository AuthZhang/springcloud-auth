package com.zhangyu.leetcode.problem01_100;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/3/24 5:22 下午
 */
@Slf4j
public class Problems66 {


    /**
     *
     * 					解答成功:
     * 					执行耗时:0 ms,击败了100.00% 的Java用户
     * 					内存消耗:37 MB,击败了45.75% 的Java用户
     *
     * @description:
     * @author: zhangyu122
     * @date: 2021/3/24 6:23 下午
     */
    public static int[] plusOne(int[] digits) {
        int overflow = 0;
        for (int i = digits.length-1; i >=0;i--){
            if (i == digits.length-1){
                int i1 = digits[i] + 1;
                if (i1>=10){
                    overflow = 1;
                    digits[i] = 0;
                }else
                    digits[i] = i1;
                continue;
            }
            int digit = digits[i];
            if (overflow != 0 ){
                int i1 = overflow + digit;
                if (i1>=10){
                    overflow = 1;
                    digits[i] = 0;
                }else{
                    digits[i] = i1;
                    overflow =0;
                }
            }else {
                digits[i] = digit;
            }
        }
        if (overflow != 0){
            int[] result = new int[digits.length+1];
            result[0] = overflow;
            for (int i = digits.length-1; i>0;i--){
                result[i] = digits[i];
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] params = new int[]{9,8,9};
        log.info(JSON.toJSONString(plusOne(params)));

        log.info("xxxx{}","ab".charAt(0));
    }

}
