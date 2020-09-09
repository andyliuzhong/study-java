package com.test.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuch
 * @date 2020/7/13 - 23:00
 * 传统 生产自消费者
 */

class SourceClass {
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void increment() {
        try {
            lock.lock();
            while (number != 0) { //线程判断用while
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "   " + number);
            //通知其他线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        try {
            lock.lock();
            while (number == 0) { //线程判断用while
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "  " + number);
            //通知其他线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProducerConsumer_Traditional {
    public static void main(String[] args) {
        SourceClass sourceClass = new SourceClass();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sourceClass.decrement();
            }
        }, "BBB").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sourceClass.increment();
            }
        }, "AAA").start();


    }
}
