package com.rocksdb;

import org.rocksdb.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author liuch
 * @date 2021/1/24 - 13:58
 */
public class RocksDBUtils {
    private static final String dbPath = "./rocksdb-data/";
    private static RocksDB rocksDB;
    private static ColumnFamilyOptions cfOpts = new ColumnFamilyOptions().optimizeUniversalStyleCompaction();
    private static HashMap<String, ColumnFamilyHandle> handleHashMap = new HashMap<>();

    static {
        List<ColumnFamilyDescriptor> cfDescriptors = Arrays.asList(
                new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpts),
                new ColumnFamilyDescriptor("cf1".getBytes(), cfOpts),
                new ColumnFamilyDescriptor("cf2".getBytes(), cfOpts));
        List<ColumnFamilyHandle> cfHandles = new ArrayList<>();
        DBOptions dbOptions = new DBOptions().setCreateIfMissing(true).setCreateMissingColumnFamilies(true);
        dbOptions.setAllowConcurrentMemtableWrite(true);
//        dbOptions.enableWriteThreadAdaptiveYield();
        try {
            rocksDB = RocksDB.open(dbOptions, dbPath, cfDescriptors, cfHandles);
            cfHandles.forEach(
                    columnFamilyHandle -> {
                        try {
                            handleHashMap.put(new String(columnFamilyHandle.getName()), columnFamilyHandle);
                        } catch (RocksDBException e) {
                            e.printStackTrace();
                        }
                    }
            );
        } catch (RocksDBException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws RocksDBException, InterruptedException {
//        rocksDB.put(handleHashMap.get("cf1"), "test-19".getBytes(), "121213131".getBytes());
//        rocksDB.put(handleHashMap.get("cf1"), "test-02".getBytes(), "121213131".getBytes());
//        rocksDB.put(handleHashMap.get("cf1"), "test-00".getBytes(), "121213131".getBytes());
        putSingle();
        get();
//        conTest();
    }

    private static void putSingle() throws RocksDBException {
        long startT = System.currentTimeMillis();
        List<String> list = Arrays.asList("tes", "test%%", "Album-","tie-");
        for (int i = 0; i < 10; i++) {
            rocksDB.put(handleHashMap.get("cf1"), (list.get((int)(Math.random() * 4)) + i).getBytes(), "12345678999999999999".getBytes());
        }
        System.out.println("cost " + (System.currentTimeMillis() - startT) + "ms");
    }
    private static void testConc(String suffix) throws RocksDBException {
        long startT = System.currentTimeMillis();
        String value = "12345678999999999999";
        for (int i = 0; i < 1000000; i++) {
            rocksDB.put(handleHashMap.get("cf1"), (suffix + i).getBytes(), value.getBytes());
        }
        System.out.println(Thread.currentThread().getName() + " cost " + (System.currentTimeMillis() - startT) + "ms");
    }
    private static void get(){
        int i = 0;
        long startT = System.currentTimeMillis();
        RocksIterator rocksIterator = rocksDB.newIterator(handleHashMap.get("cf1"));
        //seek 前缀搜索, 会搜索出test-及后面全部的
//        for (rocksIterator.seekToFirst(); rocksIterator.isValid(); rocksIterator.next()) {
        for (rocksIterator.seek("test%%".getBytes()); rocksIterator.isValid(); rocksIterator.next()) {
            System.out.println("iterator:" + new String(rocksIterator.key()) + ":" + new String(rocksIterator.value()));
            i++;
        }
        System.out.println("============== count:" + i);
        System.out.println( " get cost " + (System.currentTimeMillis() - startT) + "ms");
    }

    private static void conTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        long startT = System.currentTimeMillis();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(
                    () -> {
                        try {
                            testConc("contest" + list.get(finalI));
                            countDownLatch.countDown();
                        } catch (RocksDBException e) {
                            e.printStackTrace();
                        }
                    }
                    ,"Thread-" + i).start();
        }
        countDownLatch.await();
        System.out.println( " get cost " + (System.currentTimeMillis() - startT) + "ms");
    }
}
