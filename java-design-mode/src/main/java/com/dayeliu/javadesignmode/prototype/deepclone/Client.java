package com.dayeliu.javadesignmode.prototype.deepclone;

import java.io.IOException;

/**
 * @author liuch
 * @date 2020/10/5 - 13:39
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        DeepCloneable clone = new DeepCloneable();
        clone.deepCloneableTarget = new DeepCloneableTarget("test", "testC");
        clone.name = "sheep";

//        DeepCloneable clone1 = clone.clone();
//        DeepCloneable clone2 = clone.clone();
//        System.out.println("clone1:" + clone1.toString() + clone1.deepCloneableTarget.hashCode());
//        System.out.println("clone2:" + clone2.toString() + clone2.deepCloneableTarget.hashCode());

        //序列化完成深拷贝
        DeepCloneable clone1 = clone.deepCloneable();
        DeepCloneable clone2 = clone.deepCloneable();
        System.out.println("clone1:" + clone1.toString() + clone1.deepCloneableTarget.hashCode());
        System.out.println("clone2:" + clone2.toString() + clone2.deepCloneableTarget.hashCode());



    }
}
