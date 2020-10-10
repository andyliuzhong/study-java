package com.dayeliu.javadesignmode.builder;

import java.util.Date;

/**
 * @author liuch
 * @date 2020/10/5 - 15:32
 * 具体产品
 */

public class HouseProduct {
    private String name = "house";
    private Date createDate = new Date();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "HouseProduct{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
