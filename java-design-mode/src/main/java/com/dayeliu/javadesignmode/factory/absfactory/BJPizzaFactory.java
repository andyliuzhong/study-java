package com.dayeliu.javadesignmode.factory.absfactory;

/**
 * @author liuch
 * @date 2020/9/29 - 21:23
 */
public class BJPizzaFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("BJCH")){
            pizza = new BJCheesePizza();
        }else if (orderType.equals("BJPP")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
