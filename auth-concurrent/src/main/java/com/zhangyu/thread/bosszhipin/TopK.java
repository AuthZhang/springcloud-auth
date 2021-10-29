package com.zhangyu.thread.bosszhipin;

import java.util.Random;

/**
 * @Author zhangyu
 * @Description 10亿个数字里里面找最小的10个
 * @Date 21:03 2021/10/19
 */
public class TopK {
    /**
     * 最大堆，最小堆类似，以下以最小堆为例进行讲解。
     *
     * 最小堆是满足以下条件的数据结构：
     * 1）它是一棵完全二叉树
     * 2）所有父节点的值小于或等于两个子节点的值。
     *
     * 完全二叉树：除了最后一层之外的其他每一层都被完全填充，并且所有结点都保持向左对齐。
     */

    public static void main(String[] args) {
        int[] a = new int[1000000];
        for (int i = 0;i<1000000;i++){
            Random random = new Random();
            a[i] = random.nextInt();
        }

        int[] ints = topK(a, 10);
        for (int i = 0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }

    // 从data数组中获取最大的k个数
    private static int[] topK(int[] data,int k)
    {
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k];
        for(int i = 0;i< k;i++)
        {
            topk[i] = data[i];
        }

        // 转换成最小堆
        MinHeap heap = new MinHeap(topk);

        // 从k开始，遍历data
        for(int i= k;i<data.length;i++)
        {
            int root = heap.getRoot();

            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if(data[i] > root)
            {
                heap.setRoot(data[i]);
            }
        }

        return topk;
    }

    /**
     * 最小堆
     */
    public static class MinHeap{
        private int[] data;

        public MinHeap(int[] data) {
            this.data = data;
        }

        private void build(){
            // 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
            // *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
            for (int i = (data.length) / 2 - 1; i >= 0; i--)
            {
                // 对有孩子结点的元素heapify
                heapify(i);

            }
        }

        private void heapify(int i){
            // 获取左右结点的数组下标
            int l = left(i);
            int r = right(i);
            // 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
            int smallest = i;

            // 存在左结点，且左结点的值小于根结点的值
            if (l < data.length && data[l] < data[i])
                smallest = l;

            // 存在右结点，且右结点的值小于以上比较的较小值
            if (r < data.length && data[r] < data[smallest])
                smallest = r;

            // 左右结点的值都大于根节点，直接return，不做任何操作
            if (i == smallest)
                return;

            // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
            swap(i, smallest);

            // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
            heapify(smallest);
        }
        // 获取左结点的数组下标
        private int left(int i) {
            return ((i + 1) << 1) - 1;
        }
        // 获取右结点的数组下标
        private int right(int i){
            return (i + 1) << 1;
        }
        // 交换元素位置
        private void swap(int i, int j){
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

        // 获取对中的最小的元素，根元素
        public int getRoot(){
            return data[0];
        }
        // 替换根元素，并重新heapify
        public void setRoot(int root){
            data[0] = root;
            heapify(0);
        }
    }


    /**
     * ***************************************************************************************************************************************
     * ***************************************************************************************************************************************
     * ***************************************************************************************************************************************
     */
    /**
     * 第一个解题版本
     */
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
}
