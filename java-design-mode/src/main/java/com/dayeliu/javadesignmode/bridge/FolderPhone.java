package com.dayeliu.javadesignmode.bridge;

/**
 * @author liuch
 * @date 2020/10/10 - 17:05
 * 翻盖手机
 */
public class FolderPhone extends Phone {

    public FolderPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("翻盖手机");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("翻盖手机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("翻盖手机");
    }
}
