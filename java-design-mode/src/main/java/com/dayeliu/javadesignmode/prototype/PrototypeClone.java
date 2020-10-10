package com.dayeliu.javadesignmode.prototype;

/**
 * @author liuch
 * @date 2020/10/5 - 12:49
 * 原型模式  克隆羊问题
 */
public class PrototypeClone implements  Cloneable{
    private int age;
    private String name;

    private PrototypeClone friend; //如果属性中含有对象  克隆时此属性指向同一个地址  -> 浅拷贝

    public void setFriend(PrototypeClone friend) {
        this.friend = friend;
    }

    public PrototypeClone getFriend() {
        return friend;
    }

    @Override
    public String toString() {
        return "PrototypeClone{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public PrototypeClone(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected PrototypeClone clone() throws CloneNotSupportedException {
        PrototypeClone sheep = (PrototypeClone) super.clone();
        return sheep;
    }
}
