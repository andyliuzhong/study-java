package com.test.gvmgc;

/**
 * @author liuch
 * @date 2020/8/13 - 21:43
 *
 * Boolean 类型
 * -XX:+PrintGCDetails
 * jps -l
 * jinfo -flag PrintGCDetails  ==》 查看gc参数
 *
 * KV设值   -XX:MetaspaceSize=150m
 *
 *
 * jinfo -flags pid
 *
 * 查看初始:   java -XX:+PrintFlagsInitial
 * 查看更新过的参数: java -XX:+PrintFlagsFinal    = 和 :=  带冒号的有更新
 */
public class TypeBoolean {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello gc");

        //====================
        long totalMemory = Runtime.getRuntime().totalMemory();//java虚拟机的总内存
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("TOTAL MEMORY(-Xms) = " +totalMemory + "字节、" + (totalMemory/1024/1024) + "MB");
        System.out.println("MAX MEMORY(-Xmx) = " +maxMemory + "字节、" + (maxMemory/1024/1024) + "MB");
//        Thread.sleep(Integer.MAX_VALUE);
    }
}
