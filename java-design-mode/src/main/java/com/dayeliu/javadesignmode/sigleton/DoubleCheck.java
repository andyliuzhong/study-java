package com.dayeliu.javadesignmode.sigleton;

/**
 * @author liuch
 * @date 2020/9/22 - 22:49
 */
public class DoubleCheck {
    private static volatile DoubleCheck singleTon = null;
    private DoubleCheck(){
    }

    public static DoubleCheck getInstance(){
        if (singleTon == null) {
            synchronized(DoubleCheck.class) {
                if (singleTon == null) {
                    singleTon = new DoubleCheck();
                }
            }
        }
        return singleTon;
    }

}
