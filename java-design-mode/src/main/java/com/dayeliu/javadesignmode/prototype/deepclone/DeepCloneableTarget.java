package com.dayeliu.javadesignmode.prototype.deepclone;

import java.io.Serializable;

/**
 * @author liuch
 * @date 2020/10/5 - 13:33
 * 深拷贝
 */
public class DeepCloneableTarget implements Serializable,Cloneable {
    public String name;
    public String className;

    public DeepCloneableTarget(String name, String className) {
        this.name = name;
        this.className = className;
    }

    @Override
    protected DeepCloneableTarget clone() throws CloneNotSupportedException {
        DeepCloneableTarget deepCloneableTarget = (DeepCloneableTarget) super.clone();
        return deepCloneableTarget;
    }
}
