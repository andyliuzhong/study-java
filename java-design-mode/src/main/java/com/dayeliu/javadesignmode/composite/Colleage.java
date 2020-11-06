package com.dayeliu.javadesignmode.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuch
 * @date 2020/10/23 - 22:04
 */
public class Colleage extends OranizationCoponent {
    //院系可以有多个Department
    List<OranizationCoponent> oranizationCoponents = new ArrayList<>();

    public Colleage(String name, String desc) {
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
