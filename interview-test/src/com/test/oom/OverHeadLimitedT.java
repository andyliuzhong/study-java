package com.test.oom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuch
 * @date 2020/8/31 - 22:05
 */
public class OverHeadLimitedT {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add("121312314131331"+String.valueOf(++i).intern());
                //java.lang.OutOfMemoryError: GC overhead limit exceeded
            }
        }catch (Throwable throwable){
            System.out.println(i);
            throwable.printStackTrace();
            throw  throwable;
        }

    }
}
