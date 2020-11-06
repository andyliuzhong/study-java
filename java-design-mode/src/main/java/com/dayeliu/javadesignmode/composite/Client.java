package com.dayeliu.javadesignmode.composite;

/**
 * @author liuch
 * @date 2020/10/23 - 21:55
 * 组合模式 部分以及整体的结构层次
 */
public class Client {
    public static void main(String[] args) {
        OranizationCoponent university = new University("sichuan", "daxue");
        OranizationCoponent colleage1 = new Colleage("jijiang", "xueyuan");
        OranizationCoponent colleage2 = new Colleage("jincheng", "xueyuan");

        OranizationCoponent department1 = new Department("jisuanji", "zhuanye");
        OranizationCoponent department2 = new Department("yingyu", "zhuanye");
        colleage1.add(department1);
        colleage2.add(department2);

        university.add(colleage1);
        university.add(colleage2);

        university.print();


    }
}
