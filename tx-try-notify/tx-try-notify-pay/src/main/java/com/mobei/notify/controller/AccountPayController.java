package com.mobei.notify.controller;

import com.mobei.notify.entity.AccountPay;
import com.mobei.notify.service.AccountPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AccountPayController {

    @Autowired
    AccountPayService accountPayService;

    /**
     * 充值
     * @param accountPay
     * @return
     */
    @GetMapping(value = "/paydo")
    public AccountPay pay(AccountPay accountPay){
        //生成事务编号
        String txNo = UUID.randomUUID().toString();
        accountPay.setId(txNo);
        return accountPayService.insertAccountPay(accountPay);
    }

    /**
     * 查询充值结果
     * @param txNo
     * @return
     */
    @GetMapping(value = "/payresult/{txNo}")
    public AccountPay payresult(@PathVariable("txNo") String txNo){
        return accountPayService.getAccountPay(txNo);
    }
}
