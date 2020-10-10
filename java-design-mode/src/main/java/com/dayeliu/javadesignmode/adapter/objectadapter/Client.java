package com.dayeliu.javadesignmode.adapter.objectadapter;

/**
 * @author liuch

 * @date 2020/10/8 - 22:47
 * 类适配模式
 * 1.使用聚合方式代替继承  ,更灵活
 */

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
