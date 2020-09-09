package com.test.demo;

/**
 * @author liuch
 * @date 2020/7/16 - 22:24
 * BlockingQueue 是是实现生产消费
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 资源类
 */
class Source{
    private volatile boolean flag = true;//判断标识
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;  //传入接口,适配所有实现

    public Source(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void produce() throws InterruptedException {
        String data = null;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            boolean result = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (result){
                System.out.println(Thread.currentThread().getName() + "插入队列 "+ data + "成功" );
            }else {
                System.out.println(Thread.currentThread().getName() + "插入队列 "+ data + "失败" );
            }
            TimeUnit.SECONDS.sleep(1L);
        }
        System.out.println(Thread.currentThread().getName() + " 标识改变停止生产 " + "flag:" + flag);
    }
    public void consumer() throws InterruptedException {
        while (flag){
            String result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equals("")){
                flag = false;
                System.out.println(Thread.currentThread().getName() + "超过两秒没有消费,退出消费");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "队列消费成功" +result+ "成功");
        }
    }
    public void stop(){
        flag = false;
    }
}

public class Produce_BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Source source = new Source(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println("生产线程启动==========");
            System.out.println();
            System.out.println();
            try {
                source.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"producer").start();
        new Thread(() -> {
            System.out.println("消费线程启动==========");
            System.out.println();
            System.out.println();
            try {
                source.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        System.out.println("5秒后停止");
        TimeUnit.SECONDS.sleep(5);
        source.stop();

    }
}
