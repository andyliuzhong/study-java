package com.dayeliu.javadesignmode.factory.absfactory;

/**
 * @author liuch
 * @date 2020/9/29 - 21:23
 */
public class LDPizzaFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("LDCH")){
            pizza = new LDCheesePizza();
        }else if (orderType.equals("LDPP")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
