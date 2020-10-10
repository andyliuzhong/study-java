package com.dayeliu.queue;

import java.util.Scanner;

/**
 * @author liuch
 * @date 2020/9/15 - 20:55
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 获取数据");
            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    try {
                        queue.showAllData();
                    }catch (Exception e){
                        System.out.println(e.getMessage());

                    }
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int data = scanner.nextInt();
                    queue.add(data);
                    break;
                case 'g':
                    try {
                        int i = queue.get();
                        System.out.println("取出的数据 " + i);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("head数据 "+queue.headQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                 default:
                     break;
            }
        }
        System.out.println("退出程序");

    }
}

class ArrayQueue{
    int maxSize; //最大size
    int front; //front 指针
    int rear; //rear 指针
    int arr[];

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1; //指向对列首的前一个位置
        rear = -1; //指向对尾的数据(包含)
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     * @return
     */
    private boolean isFull(){
        return rear == maxSize -1;
    }
    //判断队列是否为空
    private boolean isEmpty(){
        return front == rear;
    }

    //添加数据
    public void add(int data){
        if (isFull()) {
            System.out.println("队列已满,不能添加");
            return;
        }
        arr[++rear] = data; //rear指针后移
    }
    //取数据
    public int get(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        return arr[++front]; //front 后移
    }
    //显示队列所有数据
    public void showAllData(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,不能取数据");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }
    //显示对首数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,不能取数据");
        }
        return arr[front + 1]; // +1 :front 指向队列前一个位置
    }
}

