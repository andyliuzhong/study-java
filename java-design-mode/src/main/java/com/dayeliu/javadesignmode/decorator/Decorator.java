package com.dayeliu.javadesignmode.decorator;

/**
 * @author liuch
 * @date 2020/10/13 - 21:45
 */
public class Decorator extends Drink {
    //聚合coffee
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();  //自己的价格加上 coffee的价格
    }
}
