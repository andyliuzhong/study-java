package com.dayeliu.sort;

import java.util.Arrays;

/**
 * @author liuch
 * @date 2021/1/2 - 23:34
 * 归并排序  时间复杂度 线性
 * 合并次数  n-1
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,3,1,2,0,19};
        int tem[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tem);
        System.out.println("合并后:" + Arrays.toString(arr));
        System.out.println("合并后 tmp:" + Arrays.toString(tem));
    }

    public static void mergeSort(int arr[],int left,int right,int temp[]){
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(arr, left, mid, temp);
            //向右递归
            mergeSort(arr, mid + 1, right, temp);

            //合并
            merge(arr, left, mid, right, temp);
        }
    }
    /**
     * 合并方法
     * @param arr  排序数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param tmp 中转的数组
     */
    public static void merge(int arr[],int left,int mid,int right,int[] tmp){
        //左边有序序列的初始索引
        int i = left;
        //右边有序序列的初始索引
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;

        //1
        //将左右两边的数组(已经有序)按规则添加到temp
        //直到左右两边的数据有一边处理完

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[t] = arr[i];
                t +=1;
                i +=1;
            }else {
                tmp[t] = arr[j];
                j +=1;
                t +=1;
            }
        }
        //2
        //把有剩余的一边的数据依次填充到temp数组
        while (i <= mid){ //左边还有剩余元素
            tmp[t] = arr[i];
            t +=1;
            i +=1;
        }
        while (j <= right){ //右边还有剩余元素
            tmp[t] = arr[j];
            t +=1;
            j +=1;
        }

        //3
        //将temp的数组元素拷贝到arr
        //并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = tmp[t];
            t +=1;
            tempLeft +=1;
        }

    }
}
