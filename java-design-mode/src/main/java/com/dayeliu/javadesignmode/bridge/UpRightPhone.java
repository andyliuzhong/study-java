package com.dayeliu.javadesignmode.bridge;

/**
 * @author liuch
 * @date 2020/10/10 - 17:05
 * 直立手机
 */
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("直立手机");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("直立手机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("直立手机");
    }
}
