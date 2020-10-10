package com.dayeliu.javadesignmode.prototype;

/**
 * @author liuch
 * @date 2020/10/5 - 12:51
 */
public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeClone sheep1 = new PrototypeClone(99,"andy");
        sheep1.setFriend(new PrototypeClone(100, "Jack"));
        PrototypeClone sheep2 = sheep1.clone();
        PrototypeClone sheep3 = sheep1.clone();
        PrototypeClone sheep5 = sheep1.clone();
        sheep1.setName("sheep");
        System.out.println("sheep1:" + sheep1 + ",sheep1.hashcode:" + sheep1.getFriend().hashCode());//浅拷贝

        System.out.println("sheep2:" + sheep2 + ",sheep2.hashcode:" + sheep2.getFriend().hashCode());
        System.out.println("sheep3:" + sheep3 + ",sheep3.hashcode:" + sheep3.getFriend().hashCode());
        System.out.println("sheep5:" + sheep5 + ",sheep5.hashcode:" + sheep5.getFriend().hashCode());
    }
}
