package com.test.locks;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuch
 * @date 2020/7/7 - 23:15
 * 做加法
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + " 计数器减一");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 主线程 最后退出");
    }
}
