package com.test.ref;

import com.sun.javafx.util.WeakReferenceQueue;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author liuch
 * @date 2020/8/30 - 15:29
 */
public class WeakReferenceQueueT {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue();
        WeakReference weakReference = new WeakReference(o1,queue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());
        System.out.println("======================================");

        o1 = null;

        System.gc();

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());




    }
}
