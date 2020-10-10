package com.dayeliu.javadesignmode.factory.absfactory;

/**
 * @author liuch
 * @date 2020/9/29 - 21:25
 */
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("LD pepper");
    }
}
