package com.test.oom;

import sun.misc.VM;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author liuch
 * @date 2020/9/1 - 21:42
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("配置的MaxDirectMemory大小:" + VM.maxDirectMemory()/1024/1024 + "MB");

        TimeUnit.SECONDS.sleep(2);
        ByteBuffer buffer = ByteBuffer.allocateDirect(6 * 1024 *1024);
        //[Metaspace: 3303K->3303K(1056768K)]
        //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
    }
}
