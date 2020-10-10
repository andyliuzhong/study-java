package com.dayeliu.javadesignmode.sigleton;

/**
 * @author liuch
 * @date 2020/9/22 - 22:53
 */
public class StaticClassSingleTon {
    private StaticClassSingleTon(){

    }

    //静态内部类在外部类被加载时不会立即实例化
    //类的静态属性只会在第一次加载类的时候初始化
    private static class SingleTonDemo{
        private static final StaticClassSingleTon INSTANCE = new StaticClassSingleTon();

    }
    public static StaticClassSingleTon getInstance(){
        return SingleTonDemo.INSTANCE;
    }
}
