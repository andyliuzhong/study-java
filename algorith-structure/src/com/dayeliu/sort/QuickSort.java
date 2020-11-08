package com.dayeliu.sort;

import java.util.Arrays;

/**
 * @author liuch
 * @date 2020/11/8 - 10:32
 * 找到一个数  让其左边的全部有序且小于它 右边的大于它且有序
 * 递归
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,0,78,0,23,-567,70,0};

        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length -1)));
    }

    /**
     *
     * @param arr
     * @param left 最左边index
     * @param right 最右边index
     * @return
     */
    public static int[]  quickSort(int[] arr,int left,int right){
        int l = left; //左下标
        int r = right;//右下标

        int tmp;
        int pivot = arr[(left + right) / 2]; //中轴

        //while 循环 让比pivot小的 放到pivot左边
        //while 循环 让比pivot大的 放到pivot右边
        while (l < r) {
            //在pivot左边找比pivot大的数 才退出
            while (arr[l] < pivot) {
                l +=1;
            }
            //在pivot右边找比pivot小的数 才退出
            while (arr[r] > pivot) {
                r -=1;
            }
            if (l >= r) {
                //说明pivot左边都是小于等于pivot
                //右边都是大于等于pivot
                break;
            }

            //否则 就交换位置
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            //如果交换后 arr[l] == pivot 就 r-- 前移  可能两个相同值的pivot
            if (arr[l] == pivot) {
                r -=1;
            }
            //如果交换后 arr[r] == pivot 就 l++ 前移  可能两个相同值的pivot
            if (arr[r] == pivot) {
                l +=1;
            }

        }

        //如果r ==l ,否则栈溢出
        if(r == l){
            r -=1;
            l +=1;
        }

        //向左递归
        if (left < r){
            quickSort(arr, left,r);
        }
        //向右递归
        if (right > l){
            quickSort(arr, l,right);
        }
        return arr;
    }
}
