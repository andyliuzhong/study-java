package com.dayeliu.javadesignmode.prototype.deepclone;

import java.io.*;

/**
 * @author liuch
 * @date 2020/10/5 - 13:35
 */
public class DeepCloneable implements Serializable,Cloneable {
    public String name;
    public DeepCloneableTarget deepCloneableTarget;

    public DeepCloneable() {
    }

    /**
     * clone 方法实现深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected DeepCloneable clone() throws CloneNotSupportedException {
        DeepCloneable deepCloneable = (DeepCloneable) super.clone();
        deepCloneable.deepCloneableTarget = deepCloneableTarget.clone();
        return deepCloneable;
    }

    /**
     * 序列化方式 深拷贝  推荐
     * @return
     */
    public DeepCloneable deepCloneable() throws IOException {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        DeepCloneable cloneable = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            cloneable = (DeepCloneable) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            bos.close();
            bis.close();
            oos.close();
            ois.close();
        }
        return cloneable;
    }

    @Override
    public String toString() {
        return "DeepCloneable{" +
                "name='" + name + '\'' +
                ", deepCloneableTarget=" + deepCloneableTarget +
                '}';
    }
}
