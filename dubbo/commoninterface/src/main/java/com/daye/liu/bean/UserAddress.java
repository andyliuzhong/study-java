package com.daye.liu.bean;

import java.io.Serializable;

/**
 * @author liuch
 * @date 2020/12/2 - 22:10
 */
public class UserAddress implements Serializable {
    private Integer id;
    private String userAddress;
    private String userId;
    private String consignee;

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userAddress='" + userAddress + '\'' +
                ", userId='" + userId + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    private String phoneNo;
    private String isDefault;

    public UserAddress() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNo, String isDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNo = phoneNo;
        this.isDefault = isDefault;
    }
}
