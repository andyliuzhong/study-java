package com.test.threadpool;

import java.util.concurrent.*;

/**
 * @author liuch
 * @date 2020/7/26 - 23:16
 */
public class MyThreadPoolDemo {
    /**
     * cpu 密集型 : cpu + 1
     * IO密集型 :  1. cpu *2  2.大部分线程会阻塞(数据库 redis连接) cpu /(1-阻塞系数)
     */
    public static void makeAvailabeThreads(){
        System.out.println("当前服务器核数:"+ Runtime.getRuntime().availableProcessors());
    }

    public static ThreadPoolExecutor specificThreadPool(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());//直接异常
//                new ThreadPoolExecutor.DiscardPolicy());//直接丢失数据
//                new ThreadPoolExecutor.DiscardOldestPolicy());//丢失排队最久的数据
                new ThreadPoolExecutor.CallerRunsPolicy());//返回给调用者
        return executor;
    }
    public static void main(String[] args) {
        makeAvailabeThreads();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);//固定线程数
//        ExecutorService executorService = Executors.newSingleThreadExecutor();//一个线程
//        ExecutorService executorService = Executors.newCachedThreadPool();//N个线程
        ThreadPoolExecutor executorService = specificThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 处理任务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
