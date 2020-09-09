package com.test.oom;

/**
 * @author liuch
 * @date 2020/9/1 - 22:06
 */
public class UnableToCreateNewNativeThreadT {
    public static void main(String[] args) throws InterruptedException {
        //创建线程超过系统上线
        //linux 系统默认 单个进程上线1024线程(非root) -> 减少程序创建的线程  配置提高系统支持线程上线
        //ulimit -u 查看当前用户支持
        Thread.sleep(Integer.MAX_VALUE);
        for (int i = 0; ; i++){
            System.out.println("==================="+i);
            new Thread(
                    () -> {
                        try {
                            Thread.sleep(Integer.MAX_VALUE);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            ).start();
        }
    }
}
