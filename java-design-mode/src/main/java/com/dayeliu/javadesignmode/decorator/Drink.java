package com.dayeliu.javadesignmode.decorator;

/**
 * @author liuch
 * @date 2020/10/13 - 21:33
 */
public abstract class Drink {
    private String desc;
    private float price = 0f;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract float cost();
}
