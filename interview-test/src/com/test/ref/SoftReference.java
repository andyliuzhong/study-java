package com.test.ref;

/**
 * @author liuch
 * @date 2020/8/30 - 14:28
 * 内存不够时回收
 */
public class SoftReference {
    public static void main(String[] args) {
//        memory_enough();
        memory_not_eough();
    }


    private static void memory_enough(){
        Object o1 = new Object();
        Object o2 = o1;
        java.lang.ref.SoftReference<Object> softReference = new java.lang.ref.SoftReference<>(o1);

        o1 = null;

        System.gc();
        System.out.println(softReference.get());
    }
    private static void memory_not_eough(){
        Object o1 = new Object();
        java.lang.ref.SoftReference<Object> softReference = new java.lang.ref.SoftReference<>(o1);

        o1 = null;
        try {
            //-Xms50m -Xmx50m
            Byte[] bytes = new Byte[1024  * 1024 * 50];
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(softReference.get());
        }
    }
}
