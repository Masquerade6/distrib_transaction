package com.mobei.tx.service;

public interface AccountInfoService {
    /**
     * 李四增加金额
     * @param accountNo
     * @param amount
     */
    void updateAccountBalance(String accountNo, Double amount);
}
