package com.daye.liu.service;

import com.daye.liu.bean.UserAddress;

import java.util.List;

/**
 * @author liuch
 * @date 2020/12/2 - 22:39
 */
public interface UserService {

    public List<UserAddress> getUserAddrsById(String userId);
}
