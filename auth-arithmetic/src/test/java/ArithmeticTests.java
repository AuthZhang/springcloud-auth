
import com.auth.Application;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangyu
 * @Description 算法练习
 * @Date 15:31 2021/9/18
 **/
@Slf4j
@SpringBootTest(classes = Application.class)
class ArithmeticTests {

    /**
     * @Author zhangyu
     * @Description 素数个数统计
     *  统计n以内的素数的个数
     *  素数：只能被1和自身整除的自然数，0,1除外
     *  例如：输入100，输出25
     * @Date 15:34 2021/9/18
     **/
    @Test
    void test1() {
        System.out.println(suShuCount(100));
        System.out.println(suShuCount1(100));
        System.out.println(suShuCount2(100));
    }

    /**
     * @Author zhangyu
     * @Description 埃筛法
     * 先定义一个大小为n的boolean数组，用来标识各位置的状态，true代表是非素数，false代表是素数
     * @Date 15:45 2021/9/18
     **/
    private int suShuCount1(int n){
        // 默认都初始化的值是false
        boolean[] booleans = new boolean[n];
        int count = 0;
        for (int i =2;i<n;i++ ){
            if (!booleans[i]){
                count++;
                // j就是非素数的标记位，外层一层循环将i的所有倍数都置为true
                for (int j = 2*i; j<n; j+=i){
                    booleans[j] = true;
                }
            }
        }
        return count;
    }

    // 埃筛法进一步优化，减少循环
    private int suShuCount2(int n){
        // 默认都初始化的值是false
        boolean[] booleans = new boolean[n];
        int count = 0;
        for (int i =2;i<n;i++ ){
            if (!booleans[i]){
                count++;
                // 直接从i*i开始
                for (int j = i*i; j<n; j+=i){
                    booleans[j] = true;
                }
            }
        }
        return count;
    }

    /**
     * @Author zhangyu
     * @Description 暴力双循环解法
     * @Date 15:45 2021/9/18
     **/
    private int suShuCount(int n){
        if ( n<=1){
            return 0;
        }
        int count = 0;
        for (int i =2;i<n;i++ ){
            boolean flag = true;
            for (int j=2; j*j <= i; j++){
                if (i%j == 0){
                    flag = false;
                    break;
                }
            }
            count += flag ? 1 : 0;
        }
        return count;
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/

    /**
     * @Author zhangyu
     * @Description 删除排序数组中的重复项
     * 一个有序数组nums，原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度
     * 不能使用额外的数组空间，必须在原地修改输入数组。必须是O(1)的空间
     * 例如：输入：【0,1,2,2,3,3,4】
     *      输出：5
     *
     * 考察重点：双指针
     * @Date 16:53 2021/9/18
     **/
    @Test
    public void test2(){
        int[] arg = {0,1,2,2,3,3,4};
        System.out.println(newArraySize(arg));
        System.out.println(newArraySize1(arg));
    }

    private int newArraySize(int[] arg){
        int count = 0;
        for (int i = 0,j=1;j<arg.length;j++){
            if (arg[i] == arg[j]){
                count++;
            }else {
                i=j;
            }
        }
        return arg.length-count;
    }
    private int newArraySize1(int[] arg){
        int i = 0;
        for (int j=1;j<arg.length;j++){
            if (arg[i] != arg[j]){
                i++;
                arg[i]=arg[j];
            }
        }
        return i+1;
    }


    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/

    /**
     * @Author zhangyu
     * @Description 寻找数组的中心下标
     * 给定一个数组nums，请编写一个能够返回数组“中心下标”的方法
     * 中心下标是数组的一个下标，其左侧的所有元素相加的和等于右边所有元素相加的和。
     * 如果数组不存在中心下标，则返回-1.如果数组有多个中心下标，返回最左的哪一个
     * 注意：中心下标可能出现在数组的两端
     *
     * 考察重点：双指针
     * @Date 18:06 2021/9/18
     **/
    @Test
    public void test3(){
        System.out.println(findMid(new int[]{1,7,3,6,5,6}));
    }

    private int findMid(int[] arg){
        int sum = Arrays.stream(arg).sum();
        int total = 0;
        for(int i = 0;i<arg.length;i++){
            total += arg[i];
            if (total == sum){
                return i;
            }
            sum -= arg[i];
        }
        return -1;
    }


    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/

    /**
     * @Author zhangyu
     * @Description x的平方根
     * 在不使用sqrt(x)函数的情况下，得到x的平方根的整数部分
     *
     * 暴力双循环
     * 二分法
     * 牛顿迭代
     * @Date 18:19 2021/9/18
     **/
    @Test
    public void test4(){
        System.out.println(xpiengfanggen1(25));
        System.out.println(xpiengfanggen1(24));
    }

    /**
     * @Author zhangyu
     * @Description 二分法
     * @Date 18:33 2021/9/18
     **/
    private int xpiengfanggen(int arg){
        int index = -1, l = 0, r = arg;
        while (l <= r ){
            int mid = l + ((r-l) >> 1);
            if (mid*mid <= arg){
                index = mid;
                l = mid+1;
            }else {
                r = mid -1;
            }
        }
        return index;
    }

    /**
     * @Author zhangyu
     * @Description 牛顿迭代
     * x = i * i情况下求i，i = x/i
     *
     * 牛顿迭代讲的是 (i + x/i) / 2 会更比 i 或 x/i 更接近平方根
     *
     * @Date 18:33 2021/9/18
     **/
    private int xpiengfanggen1(int arg){

        return (int)sqrt(arg,arg);
    }
    private double sqrt(double i , int x){
        double res = (i + x/i) / 2;
        if (res == i){
            return i;
        }else {
            return sqrt(res,x);
        }
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/
    /**
     * @Author zhangyu
     * @Description 三个数的最大乘积
     * 整型数组nums，在数组中找到由三个数字组成的最大乘积，返回这个乘积
     * 乘积不会越界
     *
     * 整型数组nums代表有可能有负数
     * 找两组数
     * 1、最小的数，第二小的数，最大的数
     * 2、最大的数、第二大的数，第三大的数
     * 上面两组数的乘积做比较，返回即可
     * @Date 20:51 2021/9/18
     **/
    @Test
    public void test5(){
        System.out.println(maxSumThree(new int[]{1,2,3,4,5,6}));
        System.out.println(maxSumThree1(new int[]{1,2,3,4,5,6}));
    }

    /**
     * @Author zhangyu
     * @Description 排序算法
     * 时间复杂度：O( N*log(N) )
     * @Date 20:59 2021/9/18
     */
    private int maxSumThree(int[] arg){
        Arrays.sort(arg);
        int n = arg.length;
        return Math.max(arg[0]*arg[1]*arg[n-1],arg[n-1]*arg[n-2]*arg[n-3]);
    }

    /**
     * @Author zhangyu
     * @Description 线性扫描
     * @Date 22:12 2021/9/18
     */
    private int maxSumThree1(int[] arg){
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        for(int x : arg){
            if (x < min1){
                min2 = min1;
                min1 = x;
            }else if (x < min2){
                min2 = x;
            }
            if (x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            }else if (x > max3){
                max3 = x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/
    /**
     * @Author zhangyu
     * @Description 两数之和
     * 给定一个整数数组numbers，从数组中找到两个数据，满足相加之和等于目标target。
     * 返回两数的下标值，以数组形式返回
     *
     * 假设每个target都只对应唯一的答案，而且不可以重复使用相同的元素，即不可以返回{2,2}这种
     * @Date 20:12 2021/9/19
     */
    @Test
    public void test6(){
        int[] ints = twoNumSum(new int[]{1, 2, 3, 4, 5, 6}, 10);
        int[] ints2 = twoNumSum2(new int[]{1, 2, 3, 4, 5, 6}, 10);
        System.out.println(twoNumSum(new int[]{1,2,3,4,5,6},10));
    }

    /**
     * @Author zhangyu
     * @Description 空间换时间
     * @Date 20:17 2021/9/19
     */
    private int[] twoNumSum(int[] arg,int target){
        Map<Integer, Integer> flag = new HashMap<>(arg.length);
        for (int i=0;i<arg.length;i++){
            flag.put(arg[i],i);
        }
        for (int i=0;i<arg.length;i++){
            int j = target - arg[i];
            if (flag.containsKey(j)){
                return new int[]{i,flag.get(j)};
            }
        }
        return new int[]{};
    }
    /**
     * @Author zhangyu
     * @Description 一个for循环
     * @Date 20:23 2021/9/19
     */
    private int[] twoNumSum2(int[] arg,int target){
        Map<Integer, Integer> flag = new HashMap<>(arg.length);
        for (int i=0;i<arg.length;i++){
            if (flag.containsKey(target - arg[i])){
                return new int[]{i,flag.get(target - arg[i])};
            }
            flag.put(arg[i],i);
        }
        return new int[]{};
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/
    /**
     * @Author zhangyu
     * @Description 两数之和2
     * 给定一个升序排列的整数数组numbers，从数组中找到两个数据，满足相加之和等于目标target。
     * 返回两数的下标值，以数组形式返回
     *
     * 假设每个target都只对应唯一的答案，而且不可以重复使用相同的元素，即不可以返回{2,2}这种
     * @Date 20:12 2021/9/19
     */
    @Test
    public void test7(){
        int[] ints = twoNumSumSort(new int[]{1, 2, 3, 4, 5, 6}, 10);
        int[] ints2 = twoNumSumSort1(new int[]{1, 2, 3, 4, 5, 6}, 10);
        System.out.println(twoNumSum(new int[]{1,2,3,4,5,6},10));
    }

    /**
     * @Author zhangyu
     * @Description 二分法
     * @Date 14:17 2021/9/20
     */
    private int[] twoNumSumSort(int[] arg,int target){
        for (int i=0;i<arg.length;i++){
            int l = i;
            int r = arg.length-1;
            while (l <= r){
                int mid = l + ((r-l) >> 1);
                if (target == arg[i] + arg[mid]){
                    return new int[]{i,mid};
                }else if (target < arg[i] + arg[mid]){
                    r = mid -1;
                }else {
                    l = mid +1;
                }
            }
        }
        return new int[]{};
    }
    /**
     * @Author zhangyu
     * @Description 双指针
     * @Date 14:17 2021/9/20
     */
    private int[] twoNumSumSort1(int[] arg,int target){
        int l = 0;
        int r = arg.length -1;
        while ( l < r){
            if (arg[l]+arg[r] == target){
                return new int[]{l,r};
            }else if(arg[l]+arg[r] < target){
                l++;
            }else {
                r--;
            }
        }
        return new int[]{};
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/
    /**
     * @Author zhangyu
     * @Description 排列硬币
     * 总共有n枚硬币，将他们摆成一个阶梯形状，第k行就有正好k枚硬币
     * 给定一个数字n，找出可形成完整阶梯行的总行数
     * n是一个非负整数，并且在32位有符号整型的范围内
     * @Date 14:36 2021/9/20
     */
    @Test
    public void test8(){
        System.out.println(yingbi4(10));
        System.out.println(yingbi4(0));
        System.out.println(yingbi4(1));
        System.out.println(yingbi4(5));
        System.out.println(yingbi4(6));
    }

    /**
     * @Author zhangyu
     * @Description
     * @Date 14:37 2021/9/20
     */
    private int yingbi(int target){
        int row = 0,sum = 0;
        while ( sum < target){
            row++;
            sum += row;
            if (target - sum < row+1){
                return row;
            }else if (target - sum == row+1){
                return row+1;
            }
        }
        return row;
    }

    /**
     * @Author zhangyu
     * @Description
     * @Date 14:37 2021/9/20
     */
    private int yingbi3(int target){
        for ( int i = 0;i<target;i++){
            target -= i;
            if (target <= i ){
                return i;
            }
        }
        return 0;
    }
    /**
     * @Author zhangyu
     * @Description 二分
     * @Date 14:37 2021/9/20
     */
    private int yingbi2(int target){
        if (target == 0){
            return 0;
        }
        int l = 1,r = target;
        int re = 1;
        while ( l <= r){
            int mide = l + ((r-l) >>1);
            re = mide;
            int sum = mide*(1 + mide) /2;
            if (sum == target){
                return mide;
            }else if (sum < target){
                l = mide +1;
            }else {
                r = mide -1;
            }
        }
        return re;
    }

    /**
     * @Author zhangyu
     * @Description 牛顿迭代
     * 等差数列求和公式：
     * sum = n(1 +n) / 2
     * 2 * sum = n +n^2
     * 2 * sum - n = n^2  此时就可以使用牛顿迭代了
     *  n   和 (2 * sum - n) / n  都不如两数的均值更接近  n
     *
     * @Date 15:52 2021/9/20
     */
    private int yingbi4(int arg){
        if (arg == 0){
            return 0;
        }
        return (int)yingbi3sqrt(arg,arg);
    }

    private double yingbi3sqrt(double i , int x){
        // 求两数均值
        double res = (i + (2*x - i)/i) / 2;
        if (res == i){
            return i;
        }else {
            return yingbi3sqrt(res,x);
        }
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/
    /**
     * @Author zhangyu
     * @Description 子数组最大平均数
     * 给定一个整数数组，找出平均数最大且长度为k的下标连续的子数组，并输出该最大平均数
     *
     * 输入：[1, 12, -5, -6, 50, 3]
     *      k = 4
     *  输出：12.75
     *
     *  最大平均数（12-5-6=50）/ 4 = 12.75
     * @Date 11:21 2021/9/21
     */
    @Test
    public void test9(){
        int[] arg = new int[]{1, 12, -5, -6, 50, 3};
        System.out.println(zishuzuduidapingjunshu(arg,4));
        System.out.println(zishuzuduidapingjunshu1(arg,4));
    }

    /**
     * @Author zhangyu
     * @Description 滑动窗口
     * 空间复杂度：O(1)
     * 时间复杂度：O(M*K)
     * @Date 11:24 2021/9/21
     */
    private double zishuzuduidapingjunshu(int[] arg,int k){
        int result = 0;
        int s = 0;
        while ( s < arg.length-k){
            int e = s+k;
            int sum = 0;
            while (s < e){
                sum+=arg[e--];
            }
            result = Math.max(sum,result);
            s++;
        }
        return (double)result/k;
    }

    /**
     * @Author zhangyu
     * @Description 滑动窗口第二种方法
     * 空间复杂度：O(1)
     * 时间复杂度：O(M)
     * @Date 11:24 2021/9/21
     */
    private double zishuzuduidapingjunshu1(int[] arg,int k){
        int sum = 0;
        for (int i = 0 ;i<k;i++){
            sum+=arg[i];
        }
        int result = sum;
        for (int i = k;i<arg.length;i++){
            sum = sum - arg[i-k] + arg[i];
            result = Math.max(sum,result);
        }
        return (double)result/k;
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/
}
