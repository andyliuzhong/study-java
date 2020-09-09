package com.test.gvmgc;

import java.util.Random;

/**
 * @author liuch
 * @date 2020/9/3 - 20:43
 * 1.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC   (DefNew + Tenured)
 * 2.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC   (ParNew + Tenured)
 *  Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the Serial old collector is deprecated and will likely be removed in a future release
 * 3.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC (UseParallelOldGC)   (PSYoungGen + ParOldGen)
 * 5.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC (UseParallelOldGC)   (ParNew + CMS)
 * 6.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 */
public class GCCollectors {
    public static void main(String[] args) {
        String tt = "abc";
        while (true) {
            tt = tt +"12121213131"+ new Random().nextInt(11111) + new Random().nextInt(22222);
            tt.intern();
        }
    }
}
