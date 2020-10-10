package com.dayeliu.javadesignmode.factory.simplefactory;

/**
 * @author liuch
 * @date 2020/9/27 - 21:23
 */
public abstract class Pizza {

    public abstract void prepare();

    public void bake(){
        System.out.println("pizza is baking");
    }
}
