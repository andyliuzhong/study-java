package com.dayeliu.javadesignmode.adapter.classadapter;

/**
 * @author liuch

 * @date 2020/10/8 - 22:47
 * 类适配模式
 * 1.缺点 使用继承   ，src的方法在Adapter中都会暴露出来
 * 2.有点 继承了SRC类 ，可以重写其方法，更灵活
 */

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
