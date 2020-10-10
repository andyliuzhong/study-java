package com.dayeliu.javadesignmode.sigleton;

/**
 * @author liuch
 * @date 2020/9/22 - 22:58
 * 线程安全  防止反序列化
 */
public enum  EnumSingleTon {
    INSTANCE;

    public void test(){
        System.out.println("1213");
    }
}

//EnumSingleTon.INSTANCE.say();
