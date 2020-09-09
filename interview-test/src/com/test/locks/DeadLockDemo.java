package com.test.locks;

import java.util.concurrent.TimeUnit;

/**
 * @author liuch
 * @date 2020/8/11 - 22:58
 */
class ResourceClass implements Runnable{
    private String lockA;
    private String lockB;

    public ResourceClass(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println( Thread.currentThread().getName() + " 自己持有"+lockA+"锁尝试获取"+lockB+"锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(  Thread.currentThread().getName() + "自己持有"+lockB+"锁尝试获取"+lockA+"锁" );
            }
        }
    }
}

/**
 * 2个或两个以上线程争抢资源
 * A线程占有A锁获取B锁
 * B线程占有B锁获取A锁
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new ResourceClass(lockA, lockB),"ThreadAAA").start();
        new Thread(new ResourceClass(lockB, lockA),"ThreadBBB").start();
    }
}
