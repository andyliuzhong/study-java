package com.dayeliu.javadesignmode.factory.absfactory;

/**
 * @author liuch
 * @date 2020/9/29 - 21:22
 * 抽象工厂模式
 * 客户端只需依赖抽象工厂
 */
public interface AbsFactory {
    public Pizza createPizza(String orderType);
}
