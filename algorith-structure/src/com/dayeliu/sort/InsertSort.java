package com.dayeliu.sort;

import java.util.Arrays;

/**
 * @author liuch
 * @date 2020/10/21 - 22:24
 * 插入排序： 将元素与有序列表进行比较 将元素插入到适合的位置
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5,1,3,9,0,2,1,100,9,8,9,500,0,7,1,5,3,7,5,2};
        System.out.println(Arrays.toString(insertSort(arr)));
    }

    /**
     * 进行arr.length - 1次 排序
     * @param arr
     */
    private static int[] insertSort(int[] arr) {
        int insertValue;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            //设置insertValue
             insertValue = arr[i];
             insertIndex = i - 1; //及i前面一个下标
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                //交换
                arr[insertIndex + 1] = arr[insertIndex];

                //不断的往前比较
                insertIndex--;
            }
            //当while循环结束说明已找到插入位置
            //insertIndex == i - 1说明当前数据不用换
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertValue;
            }
            System.out.println("第" + i + "轮:" + Arrays.toString(arr));
        }
        return arr;
    }
}
