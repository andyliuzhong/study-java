package com.dayeliu.javadesignmode.builder;

/**
 * @author liuch
 * @date 2020/10/5 - 15:36
 */
public class Director {
    private AbstractHouseBuilder builder; //聚合

    public Director(AbstractHouseBuilder builder) {
        this.builder = builder;
    }

    /**
     * 封装具体建造过程 给调用者
     * @return
     */
    public HouseProduct create(){
        builder.buidBase();
        builder.buidWall();
        builder.roofed();
        return builder.build();
    }
}
