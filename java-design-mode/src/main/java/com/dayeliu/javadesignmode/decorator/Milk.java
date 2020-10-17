package com.dayeliu.javadesignmode.decorator;

/**
 * @author liuch
 * @date 2020/10/13 - 21:46
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        super.setDesc("sugar");
        super.setPrice(3.0f);
    }
}
