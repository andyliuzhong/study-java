package com.dayeliu.javadesignmode.factory.simplefactory;

/**
 * @author liuch
 * @date 2020/9/27 - 21:24
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare cheesePizza");
    }
}
