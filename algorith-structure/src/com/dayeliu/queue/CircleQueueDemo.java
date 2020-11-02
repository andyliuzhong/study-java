package com.dayeliu.queue;

import java.util.Scanner;

/**
 * @author liuch
 * @date 2020/9/15 - 20:55
 * front指向队列的第一个元素  默认 0
 * 指向对尾元素的后一个位置 默认 0
 * 当队列满时 (rear + 1)% maxSize = front
 * 当队列为空时 rear == front
 * 队列中有效数据个数 ：(rear + maxSize -front) %maxSize
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);//其队列的有效数据为3
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char circle = ' ';
        //环形队列测试
        while (loop){
            System.out.println("s(show1): 显示队列");
            System.out.println("e(exit): 退出");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 获取数据");
            circle = scanner.next().charAt(0);

            switch (circle){
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
                    System.out.println();
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

class CircleQueue{
    int maxSize; //最大size
    int front; //front 指针
    int rear; //rear 指针
    int arr[];

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        //指向队列的第一个元素  默认 0
        front = 0;
        //指向对尾元素的后一个位置 默认 0
        rear = 0;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     * @return
     */
    private boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        //rear指向尾部的后一个位置
        arr[rear] = data;

        //环形数组取模
        rear = (rear + 1) % maxSize;
    }
    //取数据
    public int get(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        //front指向队列的第一个元素
        int result = arr[front];
        front = (front + 1 )% maxSize;
        return result; //front 后移
    }
    //显示队列所有数据
    public void showAllData(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,不能取数据");
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    //有效数据size
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
    //显示对首数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,不能取数据");
        }
        return arr[front]; // +1 :front 指向队列前一个位置
    }
}

