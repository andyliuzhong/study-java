package com.test.ref;

import java.lang.ref.WeakReference;

/**
 * @author liuch
 * @date 2020/8/30 - 14:46
 * 只要GC就会被回收
 */
public class WeakReferenceT {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();

        System.out.println("===================");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
