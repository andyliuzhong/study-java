package com.dayeliu.javadesignmode.decorator;

/**
 * @author liuch
 * @date 2020/10/13 - 21:46
 */
public class Sugar extends Decorator {
    public Sugar(Drink drink) {
        super(drink);
        super.setDesc("sugar");
        super.setPrice(2.0f);
    }
}
