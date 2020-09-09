package com.test.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author liuch
 * @date 2020/8/30 - 16:07
 */
public class PhantomReferenceT {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue();
        PhantomReference<Object> weakReference = new PhantomReference(o1,queue);
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
