package com.test.blockingQueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liuch
 * @date 2020/7/13 - 22:31
 * SynchronousQueueDemo 不存储元素 每个插入必须等到另一个线程调用移除操作
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue();
        new Thread(() -> {
            try {
                synchronousQueue.put("ee");
                System.out.println(Thread.currentThread().getName() + " put 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                synchronousQueue.put("ff");
                System.out.println(Thread.currentThread().getName() + " put 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                synchronousQueue.put("gg");
                System.out.println(Thread.currentThread().getName() + " put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                String take = synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + " take 1 " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(5);
                String take = synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + " take 2 " +take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(5);
                String take = synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + " take 3" +take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
    public synchronized  void test(){
        Object oo = new Object();
    }
}

