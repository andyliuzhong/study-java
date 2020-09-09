package com.test.ref;

import java.util.Collections;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author liuch
 * @date 2020/8/30 - 15:05
 */
public class WeakHashMapT {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("==================");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "myWeakHashMap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }

    private static void myHashMap() {
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hashmap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }
}
