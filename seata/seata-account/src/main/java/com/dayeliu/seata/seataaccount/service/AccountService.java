package com.dayeliu.seata.seataaccount.service;

import com.dayeliu.seata.seataaccount.entities.Account;
import com.dayeliu.seata.seataaccount.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * @author liuch
 * @date 2020/10/10 - 23:24
 */
@Service
public class AccountService {
    private static final String ERROR_USER_ID = "1002";

    @Resource
//    @Autowired
    private AccountMapper accountMapper;

    public void debit(String userId, BigDecimal orderMoney) {
        Account account = accountMapper.selectByUserId(userId);
        account.setMoney(account.getMoney().subtract(orderMoney));
        accountMapper.updateById(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
