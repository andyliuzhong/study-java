package com.dayeliu.javadesignmode.adapter.interfaceadapter;

/**
 * @author liuch
 * @date 2020/10/8 - 23:36
 * 接口适配器模式
 */
public class Client {
    public static void main(String[] args) {
        AbsInterfaceAdapter absInterfaceAdapter = new AbsInterfaceAdapter() {
            //只实现m1方法
            @Override
            public void m1() {
                System.out.println("m1 method impl");
            }
        };

        absInterfaceAdapter.m1();
        System.out.println("123456".matches("^[1-9]\\d{5}"));
    }
}
