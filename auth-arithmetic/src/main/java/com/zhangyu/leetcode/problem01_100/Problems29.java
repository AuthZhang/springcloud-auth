package com.zhangyu.leetcode.problem01_100;


/**
 * @description:
 * @author: zhangyu122
 * @date: 2021/8/10 3:52 下午
 */
public class Problems29 {

    public static void main(String[] args) {
        int i = 1;
        i |= 0;
        System.out.println(i);
        System.out.println(divide(-2147483648,1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        long x = dividend, y = divisor;
        boolean isNeg = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) isNeg = true;
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        long result = 0;
        long temp = x;
        while ( temp >= y){
            temp = temp-y;
            result++;
        }
        long ans = isNeg ? -result : result;
        if (ans >= Integer.MAX_VALUE || ans <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)ans;
    }

    /**
     * @description:
     * 答案
     * @author: zhangyu122
     * @date: 2021/8/10 5:03 下午
     */
    public static int divide1(int dividend, int divisor) {
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;

        long aa = Math.abs((long)dividend);
        long bb = Math.abs((long)divisor);
        // 除数需要左移几位才可以大于被除数
        int time_bit_cnt = 0;
        while (aa >= bb)
        {
            time_bit_cnt ++;
            bb <<= 1;
        }

        long time = 0;
        while (time_bit_cnt > 0)
        {
            time_bit_cnt --;
            bb >>= 1;
            if (aa >= bb)
            {
                aa -= bb;
                time += (1L << time_bit_cnt);
            }
        }
        if (sign < 0)
            time = 0 - time;
        return -(1L << 31) <= time && time <= (1L << 31) - 1 ? (int)time : (int)((1L << 31) - 1);
    }


    public static int majorityElement3(int[] nums) {
        int major = 0;
        int length = nums.length;
        //在java中int类型是32位，我们遍历每一位
        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
            //bitCounts表示所有数字在当前位置1的个数。比如当i=0
            //的时候，我们可以认为他表示的是所有数字在二进制位
            //中最右边1的总数。
            int bitCounts = 0;
            for (int j = 0; j < length; j++) {
                //判断数字nums[j]的第i（i从0开始）个位置是否为1，
                //如果是1，bitCounts就加1
                if ((nums[j] & mask) == mask) {
                    bitCounts++;
                }
                //如果bitCounts大于数组的一半，那么这个众数在
                //这个位置肯定是1，然后通过 major |= mask运算
                //把这个位置变为1，后面不需要再判断了，直接终止
                //内层循环
                if (bitCounts > length / 2) {
                    major |= mask;
                    break;
                }
            }
        }
        return major;
    }

}
