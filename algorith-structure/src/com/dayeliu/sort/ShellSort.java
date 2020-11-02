package com.dayeliu.sort;

import java.util.Arrays;

/**
 * @author liuch
 * @date 2020/10/29 - 22:11
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr1[] = {9,3,8,6,0,5,19,2,100,77};
        int arr2[] = {9,3,8,6,0,5,19,2,100,77};
        shellSort(arr1);

        System.out.println("======================");
        otpmiseShellSort(arr2);
    }

    private static void shellSort(int[] arr) {
        //按数组长度进行分组
        int count = 0;
        for (int gap = arr.length / 2;gap > 0;gap /=2) {
            //步长gap
            for (int i = gap; i < arr.length ; i++) {
                for (int j = i - gap;j >=0;j-=gap) {
                    //如果当前元素大于 加上步长后的元素 则交换
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第" + count++ + "次后顺序为:" + Arrays.toString(arr));
        }
    }

    //希尔排序优化-> 位移法
    public static void otpmiseShellSort(int arr[]){
        int count = 0;
        for (int gap = arr.length / 2;gap > 0;gap /=2) {
            //对其所在的组直接插入
            for (int i = gap;i < arr.length;i++) {
                int j = i;
                int temp = arr[j];

                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -=gap;
                }
                arr[j] = temp;
            }
            System.out.println("第" + count++ + "次后顺序为:" + Arrays.toString(arr));
        }
    }
}
