package com.mobei.notify.spring;

import com.mobei.notify.entity.AccountPay;
import org.springframework.stereotype.Component;

@Component
public class PayFallback implements PayClient {
    @Override
    public AccountPay payresult(String txNo) {
        AccountPay accountPay = new AccountPay();
        accountPay.setResult("fail");
        return accountPay;
    }
}
