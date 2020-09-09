package com.test.oom;

/**
 * @author liuch
 * @date 2020/8/31 - 21:34
 */
public class StackOverFLowErrorT {
    public static void main(String[] args) {
        stackOverFlowErrorM();//栈深度
    }

    private static void stackOverFlowErrorM() {
        stackOverFlowErrorM();//java.lang.StackOverflowError
    }
}
