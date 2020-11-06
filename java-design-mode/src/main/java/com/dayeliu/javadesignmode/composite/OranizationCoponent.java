package com.dayeliu.javadesignmode.composite;

/**
 * @author liuch
 * @date 2020/10/23 - 21:57
 *
 */
public abstract class OranizationCoponent {
    private String name;
    private String desc;

    public OranizationCoponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void add(OranizationCoponent oranizationCoponent){
        throw new  UnsupportedOperationException();

    }

    public void remove(OranizationCoponent oranizationCoponent){
        throw new  UnsupportedOperationException();
    }

    public abstract void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
