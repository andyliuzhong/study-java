package com.daye.liu.service;

import com.daye.liu.bean.UserAddress;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author liuch
 * @date 2020/12/7 - 22:28
 *
 * 本地存根 在调用远程服务是先调用本地存根 可以先做一些参数校验
 */
public class UserServiceStub implements UserService {
    private final UserService userService;

    //构造器注入远程userService 代理
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddrsById(String s) {
        System.out.println("call stub");
        if (!StringUtils.isEmpty(s)) {
            return userService.getUserAddrsById(s);
        }
        return null;
    }
}
