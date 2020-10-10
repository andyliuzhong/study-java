package com.dayeliu.javadesignmode.builder;

/**
 * @author liuch
 * @date 2020/10/5 - 15:35
 */
public class HouseBuilder extends AbstractHouseBuilder {
    @Override
    public void buidBase() {
        System.out.println("打地基");
    }

    @Override
    public void buidWall() {
        System.out.println("砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("登顶");
    }
}
