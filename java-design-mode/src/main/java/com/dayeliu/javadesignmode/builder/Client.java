package com.dayeliu.javadesignmode.builder;

/**
 * @author liuch
 * @date 2020/10/5 - 15:37
 */
public class Client {
    public static void main(String[] args) {
        HouseBuilder houseBuilder = new HouseBuilder();
        Director director = new Director(houseBuilder);
        HouseProduct houseProduct = director.create();
        System.out.println(houseProduct);

        System.out.println("=======================");
        HighBuildingBuilder highBuildingBuilder = new HighBuildingBuilder();
        Director highdirector = new Director(highBuildingBuilder);
        HouseProduct highProduct = highdirector.create();
        System.out.println(highProduct);


    }
}
