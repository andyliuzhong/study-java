package com.dayeliu.javadesignmode.factory.simplefactory;

/**
 * @author liuch
 * @date 2020/9/27 - 21:22
 * 简单工厂模式
 * 封装在factory中，在新增加品类时不用修改客户端
 */
public class SimpleFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if ("pepper".equals(type)) {
            pizza = new PepperPizza();
        }else if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        return pizza;
    }
}
