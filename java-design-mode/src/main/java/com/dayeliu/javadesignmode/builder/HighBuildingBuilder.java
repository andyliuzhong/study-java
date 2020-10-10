package com.dayeliu.javadesignmode.builder;

/**
 * @author liuch
 * @date 2020/10/5 - 15:40
 * 高楼建造者
 */
public class HighBuildingBuilder extends AbstractHouseBuilder {
    @Override
    public void buidBase() {
        System.out.println("高楼打地基");
    }

    @Override
    public void buidWall() {
        System.out.println("高楼砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("高楼登顶");
    }
}
