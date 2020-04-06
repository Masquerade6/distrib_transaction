package com.mobei.msg.service;

import com.mobei.msg.model.AccountChangeEvent;

public interface AccountInfoService {

    /**
     * 更新账户，增加金额
     * @param accountChangeEvent
     */
    void addAccountInfoBalance(AccountChangeEvent accountChangeEvent);
}
