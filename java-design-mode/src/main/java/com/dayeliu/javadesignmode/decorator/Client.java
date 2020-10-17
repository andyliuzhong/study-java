package com.dayeliu.javadesignmode.decorator;

/**
 * @author liuch
 * @date 2020/10/13 - 21:32
 * 装饰器模式
 *
 * 动态的将新功能加上, 扩展容易,  增加新品咖啡或配料时很容易
 */
public class Client {
    public static void main(String[] args) {
        //一份back咖啡fee cost:6.0
        Drink blackCoffee = new BlackCoffee();
        System.out.println("blackCoffee cost:" +blackCoffee.cost());
        //一份back咖啡fee cost:6.0 + 一份糖
        Drink sugar = new Sugar(blackCoffee);
        System.out.println("一份blackcoffee + 一份糖,cost:" + sugar.cost());
        //在再一份糖
        sugar = new Sugar(sugar);
        System.out.println("一份blackcoffee + 一份糖,cost:" + sugar.cost());
        sugar = new Sugar(sugar);
        System.out.println("一份blackcoffee + 一份糖,cost:" + sugar.cost());
        //在加一份milk
        sugar = new Milk(sugar);
        System.out.println("一份blackcoffee + 2份糖 + 1 份milk,cost:" + sugar.cost());
    }
}
