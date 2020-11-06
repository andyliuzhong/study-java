package com.dayeliu.javadesignmode.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuch
 * @date 2020/10/23 - 22:04
 */
public class Department extends OranizationCoponent {

    public Department(String name, String desc) {
        super(name, desc);
    }


    @Override
    public void print() {
        System.out.println("================department" + getName() +"====================");
    }
}
