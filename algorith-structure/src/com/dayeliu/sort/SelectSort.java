package com.dayeliu.sort;

import java.util.Arrays;

/**
 * @author liuch
 * @date 2020/10/17 - 23:43
 * 选择排序
 *  共进行 数组length减一轮  O(n^2)
 *  第一轮从找到[1-arr.length] 找到最小的数与arr[0]交换
 *  第一轮从找到[2-arr.length] 找到最小的数与arr[1]交换
 *  。。。以此类推
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {3,-1,9,-2,20,10,-5,3};
//        int[] arr = {1,2,3,4,5,6};
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000);

        }
        //性能
        long begin = System.currentTimeMillis();
        arr = selectSort(arr);
        System.out.println("耗时:"+ (System.currentTimeMillis() - begin) / 1000 + "s");
//        System.out.println("排序后:" + Arrays.toString(arr));
    }

    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //假设最小的index为i
            int minValue = arr[i]; //最小值为arr[minIndex]
            for (int j = i + 1; j < arr.length; j++) { //每轮结束后,下一轮从 i开始找最小的
                if (minValue > arr[j]) { //满足就交换
                    minValue = arr[j];
                    arr[j] = arr[i];
                    arr[i] = minValue;
                }
            }
        }
        return arr;
    }
}
