package com.test.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liuch
 * @date 2020/7/6 - 22:21
 * 实现自旋锁demo
 */
public class SpinLockDemo {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.lock();
            try {
                Thread.sleep(5000);
                spinLockDemo.unLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            spinLockDemo.lock();
            spinLockDemo.unLock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " come in");
        //自旋
        while (!atomicReference.compareAndSet(null, thread)){
            System.out.println(thread.getName() + " spinning");
        }

    }

    public void unLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " unLock");
        atomicReference.compareAndSet(thread, null);
    }
}
