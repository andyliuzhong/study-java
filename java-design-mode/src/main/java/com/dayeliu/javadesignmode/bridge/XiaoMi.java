package com.dayeliu.javadesignmode.bridge;

/**
 * @author liuch
 * @date 2020/10/10 - 17:00
 * 小米手机
 */
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println("小米 open");

    }

    @Override
    public void close() {
        System.out.println("小米 close");
    }

    @Override
    public void call() {
        System.out.println("小米 call");
    }
}
