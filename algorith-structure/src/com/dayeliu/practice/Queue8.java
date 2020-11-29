package com.dayeliu.practice;

/**
 * @author liuch
 * @date 2020/*10/13 - 22:13
 * 8皇后问题   8*8的方格中 放皇后 ,任意两个皇后不能再同一行 、同一列及同一斜线
 * g共92种解法
 */
public class Queue8 {
    private int maxLength = 8;
    private int count;
    //用于存储当前解法每行皇后的位置(列)
    //{0,2,3,5,6,7,4,1}  -> 即：第一行的第一列,第2行的第3列，第三行的第4列，第4行的第6列 ...
    //
    private int arr[];

    public Queue8() {
        arr = new int[8];
    }

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.execute(0);
        System.out.println("共有：" +queue8.count +"总解法");
    }


    /**
     *
     * @param n 当前皇后在第n行
     */
    public void execute(int n){
        //退出条件
        if (n==8){ //n=8说明 第8行已经成功,准备放第九行
            print();//打印当前这种解法
            return;
        } 

        //判断是否满足规则
        for (int i = 0; i < maxLength; i++) {
            arr[n] = i;  // 先放第一列
            if (judge(n)) {
                execute(n + 1); //如果满足规则，继续下一行操作
            }
            //
        }
    }

    /**
     *  任意两个皇后不能再同一行 、同一列及同一斜线
     * @param n
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //Math.abs(n - i) == Math.abs(arr[n] - arr[i])判断是否在同一斜线
            //arr[i] == arr[n]  判断是否和前面n-1个皇后在同一列
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    //每个解法走完后 打印出来
    public void print(){
        count++;
        for (int i = 0; i < 8; i++) {
            System.out.print(arr[i] +"\t");
        }
        System.out.println();
    }
}
