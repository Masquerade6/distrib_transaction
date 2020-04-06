package com.mobei.msg.service;

import com.mobei.msg.model.AccountChangeEvent;

public interface AccountInfoService {

    /**
     * 向mq发送转账消息
     * @param accountChangeEvent
     */
    void sendUpdateAccountBalance(AccountChangeEvent accountChangeEvent);

    /**
     * 更新账户，扣减金额
     * @param accountChangeEvent
     */
    void doUpdateAccountBalance(AccountChangeEvent accountChangeEvent);

}
