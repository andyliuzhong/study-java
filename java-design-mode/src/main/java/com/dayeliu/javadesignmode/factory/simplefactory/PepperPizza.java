package com.dayeliu.javadesignmode.factory.simplefactory;

/**
 * @author liuch
 * @date 2020/9/27 - 21:25
 */
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("Pepper pizza is prepare");
    }
}
