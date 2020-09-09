package com.test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuch
 * @date 2020/6/28 - 21:40
 */
public class interview {
    public static void main(String[] args) throws InterruptedException {
        List<String> strings = Collections.synchronizedList(Arrays.asList("1"));
        List<String> copyOn = new CopyOnWriteArrayList<>();

        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        Set<Object> copySet = new CopyOnWriteArraySet<>();
        Lock lock = new ReentrantLock();
//        lock.newCondition().signal();
        lock.newCondition().await();
        Map map = Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        getAvailablePro();
    }

    /**
     * 查看cpu 核数 (windows Linux)
     * @return
     */
    public static int getAvailablePro(){
        System.out.println(Runtime.getRuntime().availableProcessors());
        Executors.newSingleThreadExecutor();
        return Runtime.getRuntime().availableProcessors();

    }
}
