package com.mobei.tx.service.impl;

import com.mobei.tx.dao.AccountInfoDao;
import com.mobei.tx.service.AccountInfoService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {
    @Autowired
    AccountInfoDao accountInfoDao;

    /**
     * 张三已经开启了全局事务,这里就不用再开了
     * @param accountNo
     * @param amount
     */
//    @Transactional
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
        log.info("bank2 service begin,XID：{}", RootContext.getXID());
        //李四增加金额
        accountInfoDao.updateAccountBalance(accountNo, amount);
        if (amount == 3) {
            //人为制造异常
            throw new RuntimeException("bank2 make exception..");
        }
    }
}
