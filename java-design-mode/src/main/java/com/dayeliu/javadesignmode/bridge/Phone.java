package com.dayeliu.javadesignmode.bridge;

/**
 * @author liuch
 * @date 2020/10/10 - 17:02
 * 手机  样式
 */
public abstract class Phone {
    //聚合Brand
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }
    public void open(){
        this.brand.open();
    }
    public void close(){
        this.brand.close();
    }
    public void call(){
        this.brand.call();
    }
}
