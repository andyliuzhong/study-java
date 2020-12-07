package com.daye.liu.service;

import com.daye.liu.bean.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuch
 * @date 2020/12/2 - 22:23
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserService userService;
    /**
     * 初始化订单
     * @param userId
     */
    @Override
    public void initOrder(String userId) {
        //调用user service 查询收货地址
        List<UserAddress> addrs = userService.getUserAddrsById(userId);
        addrs.forEach(address -> System.out.println(address.toString()));
        System.out.println(addrs);

    }
}
