package com.test.oom;

import java.util.Random;

/**
 * @author liuch
 * @date 2020/8/31 - 21:39
 */
public class HeapSpaceOOMT {
    public static void main(String[] args) {
        String tt = "abc";
        System.out.println(new Random().nextInt(22));
        while (true) {
            tt = tt + new Random().nextInt(11111) + new Random().nextInt(22222);
            tt.intern();
        }
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
