package com.test.locks;

import java.util.concurrent.*;

/**
 * @author liuch
 * @date 2020/7/21 - 23:15
 * throw exception
 * return value
 */

class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("================= coming in");
//        int i = 1/0;
        TimeUnit.SECONDS.sleep(2);
        System.out.println("===================end");
        return 102400;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());

        Thread thread = new Thread(futureTask,"AA");
        thread.start();
//        while (!futureTask.isDone()){
//            System.out.println("===================in progress");
//        }
//        System.out.println(futureTask.get());//futureTask.get() 阻塞 ,放到方法最后
        System.out.println(futureTask.get(1L,TimeUnit.SECONDS));//futureTask.get() 阻塞 ,放到方法最后
        System.out.println("main==================");

    }
}
