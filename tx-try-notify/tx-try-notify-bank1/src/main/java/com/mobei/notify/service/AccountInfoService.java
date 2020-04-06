package com.mobei.notify.service;

import com.mobei.notify.entity.AccountPay;
import com.mobei.notify.model.AccountChangeEvent;

public interface AccountInfoService {

    /**
     * 更新账户金额
     * @param accountChange
     */
    void updateAccountBalance(AccountChangeEvent accountChange);

    /**
     * 查询充值结果（远程调用）
     * @param tx_no
     * @return
     */
    AccountPay queryPayResult(String tx_no);

}
