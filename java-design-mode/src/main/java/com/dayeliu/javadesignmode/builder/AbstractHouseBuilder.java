package com.dayeliu.javadesignmode.builder;

/**
 * @author liuch
 * @date 2020/10/5 - 15:32
 *
 * 抽象建造者
 */
public abstract class AbstractHouseBuilder {
    protected HouseProduct houseProduct = new HouseProduct();

    //具体产品部件

    public abstract void buidBase();
    public abstract void buidWall();
    public abstract void roofed();

    public HouseProduct build(){
        return houseProduct;
    }
}
