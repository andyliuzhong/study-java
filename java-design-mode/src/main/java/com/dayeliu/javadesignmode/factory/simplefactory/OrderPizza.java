package com.dayeliu.javadesignmode.factory.simplefactory;

/**
 * @author liuch
 * @date 2020/9/27 - 21:28
 */
public class OrderPizza {
    //聚合 SimpleFactory
    SimpleFactory simpleFactory = null;
    String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public OrderPizza(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }

    public void orderPizza(){
        Pizza pizza = simpleFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
    }
}
