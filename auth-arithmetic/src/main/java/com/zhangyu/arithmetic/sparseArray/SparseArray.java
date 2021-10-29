package com.zhangyu.arithmetic.sparseArray;

/**
 * @Author zhangyu
 * @Description 稀疏数组
 * @Date 14:43 2021/10/25
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] array = new int[11][11];
        //0：表示没有棋子；1：表示黑棋子；2：表示蓝棋子
        array[1][2] = 1;
        array[2][3] = 2;


        System.out.println("原始的二维数组");
        for(int[] a : array){
            for (int item : a){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        System.out.println("稀疏数组");
        int[][] sparseArray = getSparseArray(array);
        for(int[] a : sparseArray){
            for (int item : a){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }

    /**
     * @Author zhangyu
     * @Description 获取指定二维数组对应的稀疏数组
     * @Date 15:05 2021/10/25
     */
    public static int[][] getSparseArray(int[][] array){
        int sum = 0;
        int rows = 0;
        int col = 0;
        for(int[] a : array){
            for (int item : a){
                col++;
                if (item != 0){
                    sum++;
                }

            }
            rows++;
        }
        col = col / rows;
        int[][] result = new int[sum + 1][3];
        result[0][0]=rows;
        result[0][1]=col;
        result[0][2]=sum;
        int r = 1;
        for (int i = 0;i<array.length;i++){
            for (int j = 0;j < col;j++){
                int temp = array[i][j];
                if (temp ==0){
                    continue;
                }
                result[r][0] = i ;
                result[r][1] = j;
                result[r][2] =temp;
                r++;
            }
        }
        return result;
    }


    /**
     * @Author zhangyu
     * @Description 根据稀疏数组获取该稀疏数组的原始二维数组
     * @Date 15:15 2021/10/25
     *
     */
    public static int[][] getRowArrayFromSparseArray(int[][] array){
        int sum = 0;
        int rows = 0;
        int col = 0;
        for(int[] a : array){
            for (int item : a){
                col++;
                if (item != 0){
                    sum++;
                }

            }
            rows++;
        }
        col = col / rows;
        int[][] result = new int[sum + 1][3];
        result[0][0]=rows;
        result[0][1]=col;
        result[0][2]=sum;
        int r = 1;
        for (int i = 0;i<array.length;i++){
            for (int j = 0;j < col;j++){
                int temp = array[i][j];
                if (temp ==0){
                    continue;
                }
                result[r][0] = i ;
                result[r][1] = j;
                result[r][2] =temp;
                r++;
            }
        }
        return result;
    }
}
