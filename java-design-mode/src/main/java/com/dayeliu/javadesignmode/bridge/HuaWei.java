package com.dayeliu.javadesignmode.bridge;

/**
 * @author liuch
 * @date 2020/10/10 - 17:00
 * 华为手机
 */
public class HuaWei implements Brand {
    @Override
    public void open() {
        System.out.println("华为 open");

    }

    @Override
    public void close() {
        System.out.println("华为 close");
    }

    @Override
    public void call() {
        System.out.println("华为 call");
    }
}
