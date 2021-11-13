
import com.zhangyu.Application;
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
class ArithmeticArrayTests {


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

    /**
     * @Author zhangyu
     * @Description 最长连续递增序列
     * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，返回该子序列的长度
     *
     * 序列的下标是连续的
     * @Date 20:38 2021/9/21
     */
    @Test
    public void test10(){
        int[] arg = new int[]{1,6,8,2,7,9};
        System.out.println(zuichangdizengzixulie(arg));
    }

    /**
     * @Author zhangyu
     * @Description
     * @Date 20:39 2021/9/21
     */
    private int zuichangdizengzixulie(int[] arg){
        if (arg.length == 1){
            return 1;
        }
        int l=0,r=0;
        int result =0;
        while (r < arg.length-1){
            if (arg[r] < arg[r+1]){
                r++;
                continue;
            }
            result = Math.max(result,r-l+1);
            l = ++r;
        }
        return result;
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/

    /**
     * @Author zhangyu
     * @Description 柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为5美元，顾客排队购买你的产品，一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付5美元、10美元或20美元。必须给每个顾客正确找零
     * 如果你能给每位顾客正确找零，返回true，否则返回false
     * @Date 13:28 2021/9/22
     */
    @Test
    public void test11(){
        System.out.println(ningmenghsuizhaoling(new int[]{5,10,20,10}));
    }

    /**
     * @Author zhangyu
     * @Description 贪心算法
     * 局部最优，不影响整体结果
     * @Date 13:30 2021/9/22
     */
    private boolean ningmenghsuizhaoling(int[] arg){
        int five = 0,ten = 0;
        for(int i : arg){
            if (i == 5){
                five++;
            }else if (i == 10){
                if (five == 0){
                    return  false;
                }
                five--;
                ten ++;
            }else { // 20
                if (five > 0 && ten >0){
                    five --;
                    ten --;
                }else if(five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/

    /**
     * @Author zhangyu
     * @Description 三角形的最大周长
     * 给定一些正数（代表长度）组成的数组arr，返回由其中三个元素组成的、面积不为零的三角形的最大周长
     * 如果不能形成任何面积不为零的三角形，返回0
     * @Date 14:07 2021/9/22
     */
    @Test
    public void test12(){
        System.out.println(sanjiaoxingzuidazhouchang(new int[]{3,6,2,3}));
        System.out.println(sanjiaoxingzuidazhouchang1(new int[]{3,6,2,3}));
    }

    /**
     * @Author zhangyu
     * @Description 三个指针
     * @Date 13:30 2021/9/22
     */
    private int sanjiaoxingzuidazhouchang(int[] arg){
        int l=0,w=1,h=3;
        int sum = 0;
        while ( l <= arg.length-3 ){
            if (arg[l] + arg[w] > arg[h] && arg[l] + arg[h] > arg[w] && arg[h] + arg[w] > arg[l]){
                sum = Math.max(arg[l] + arg[w] + arg[h] ,sum);
            }
            if (l == arg.length-3){
                break;
            }
            if (w == arg.length-2){
                l++;
                w = l+1;
                h = w+1;
                continue;
            }
            if (h == arg.length-1){
                w++;
                h = w+1;
            }
        }
        return sum;
    }
    /**
     * @Author zhangyu
     * @Description 贪心算法
     * 局部最优，不影响整体结果
     * @Date 13:30 2021/9/22
     */
    private int sanjiaoxingzuidazhouchang1(int[] arg){
        Arrays.sort(arg);
        for(int i = arg.length-1;i>=2;i--){
            if (arg[i-2] + arg[i-1] > arg[i]){
                return arg[i-2] + arg[i-1] + arg[i];
            }
        }
        return 0;
    }
    
    /**
     * ********************************************************************************************************************************************
     * ****************************************************************** 分隔符 ******************************************************************
     * ********************************************************************************************************************************************
     **/
}
