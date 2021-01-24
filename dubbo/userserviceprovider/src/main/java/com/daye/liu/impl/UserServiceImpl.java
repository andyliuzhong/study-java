package com.daye.liu.impl;


import com.daye.liu.bean.UserAddress;
import com.daye.liu.service.UserService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuch
 * @date 2020/12/2 - 22:24
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddrsById(String s) {
        System.out.println("=======================call userService date:" + LocalDateTime.now());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserAddress address1 = new UserAddress();
        address1.setUserAddress("tian fu street");
        address1.setPhoneNo("15982873604");
        address1.setIsDefault("Y");
        address1.setId(1);
        address1.setConsignee("andy");
        UserAddress address2 = new UserAddress();
        address2.setUserAddress("jian nan street");
        address2.setPhoneNo("15982873604");
        address2.setIsDefault("N");
        address2.setId(2);
        address2.setConsignee("andy");
        return Arrays.asList(address1,address2);
    }
}
