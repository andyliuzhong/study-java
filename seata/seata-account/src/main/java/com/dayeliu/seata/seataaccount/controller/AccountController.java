package com.dayeliu.seata.seataaccount.controller;

import com.dayeliu.seata.seataaccount.service.AccountService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author liuch
 * @date 2020/10/10 - 23:30
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String debit(@RequestParam("userId")String userId, @RequestParam("orderMoney") BigDecimal orderMoney){
        System.out.println("account XID " + RootContext.getXID());
        accountService.debit(userId , orderMoney);
       return RootContext.getXID();
    }
}
