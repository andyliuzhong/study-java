package com.dayeliu.sort;


/**
 * @author liuch
 * @date 2020/10/17 - 23:43
 * 冒泡排序
 *  共进行 数组length减一轮  O(n^2)
 *  第一轮找到最大的放到最后一位  第二轮找到第二大的放到倒数第二位 ...
 *  外层没循环一次 ,内层就少一次
 */
public class BubbleSort {
    static int count;
    public static void main(String[] args) {
//        int[] arr = {3,-1,9,-2,20,10};
//        int[] arr = {1,2,3,4,5,6};
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000);

        }
        //性能
        long begin = System.currentTimeMillis();
        arr = bubbleSort(arr);
        System.out.println("耗时:"+ (System.currentTimeMillis() - begin) / 1000 + "s");
//        System.out.println("共交换："+count+"次,排序后:" + Arrays.toString(arr));
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false; //优化, 当某轮没有交换时,说明当前数组是有序的
            int tem;
            count++;
            for (int j = 0;j < arr.length - 1 -i;j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    //交换
                    tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j +1] = tem;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }
}
