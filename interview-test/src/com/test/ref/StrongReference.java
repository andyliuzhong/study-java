package com.test.ref;

/**
 * @author liuch
 * @date 2020/8/28 - 21:19
 */
public class StrongReference {
    public static void main(String[] args) {
        Object ob1 = new Object();
        Object ob2 = ob1;
        ob1 = null; //set ob1 null
        System.gc();
        System.out.println(ob2);
        System.out.println(ob1);
    }
}
