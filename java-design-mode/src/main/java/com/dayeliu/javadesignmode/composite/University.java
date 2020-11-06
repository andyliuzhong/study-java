package com.dayeliu.javadesignmode.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuch
 * @date 2020/10/23 - 22:04
 */
public class University extends OranizationCoponent {
    //学校可以有多个院系
    List<OranizationCoponent> oranizationCoponents = new ArrayList<>();

    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void remove(OranizationCoponent oranizationCoponent) {
        oranizationCoponents.remove(oranizationCoponent);
    }

    @Override
    public void add(OranizationCoponent oranizationCoponent) {
        oranizationCoponents.add(oranizationCoponent);
    }

    @Override
    public void print() {
        System.out.println("================" + getName() +"====================");
        for(OranizationCoponent oranizationCoponent:oranizationCoponents){
            oranizationCoponent.print();
        }
    }
}
