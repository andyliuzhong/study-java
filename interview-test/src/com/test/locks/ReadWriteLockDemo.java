package com.test.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liuch
 * @date 2020/7/6 - 23:05
 * ReentrantReadWriteLock :
 *  读 共享，写互斥  读读共享  写读 读写 写写 互斥
 */

class MyCache{
    private volatile ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Map<String,Object> map = new HashMap<>();

    public void put(String key,Object vaule){
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  正在写入");
            Thread.sleep(300);
            System.out.println(Thread.currentThread().getName() + "  写入完成");
            map.put(key, vaule);
        }catch (Exception e){

        }finally {
            rwl.writeLock().unlock();
        }
    }
    public void get(String key){
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  正在读取");
            Thread.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "  读取完成:" + result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
    }

}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
           final int finalI = i;
            new Thread(() -> {
                myCache.put(finalI +"", finalI);
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
           final int finalI = i;
            new Thread(() -> {
                myCache.get(finalI +"");
            },String.valueOf(i)).start();
        }
    }
}
