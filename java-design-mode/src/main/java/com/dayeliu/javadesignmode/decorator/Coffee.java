package com.dayeliu.javadesignmode.decorator;

/**
 * @author liuch
 * @date 2020/10/13 - 21:35
 */
public class Coffee extends Drink {
    public Coffee(String desc,float price){
        super.setDesc(desc);
        super.setPrice(price);
    }
    @Override
    public float cost() {
        return super.getPrice();
    }
}
