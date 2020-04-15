package com.mobei.tx.service.impl;

import com.mobei.tx.dao.AccountInfoDao;
import com.mobei.tx.dao.LocalTxDao;
import com.mobei.tx.service.AccountInfoService;
import com.mobei.tx.spring.Bank2Client;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    AccountInfoDao accountInfoDao;

    @Autowired
    LocalTxDao localTxDao;

    @Autowired
    Bank2Client bank2Client;

    /**
     * 张三给李四转账:扣减张三账户金额
     * "@Transactional": 方法也需要控制本地事务
     * "@GlobalTransactional":
     *      开启全局事务,GlobalTransactionalInterceptor会拦截@GlobalTransactional注解的方法生成全局事务ID(XID),
     *      XID会在整个分布式事务中传递.在远程调用时,spring-cloud-alibaba-seata会拦截Feign调用将XID传递到下游服务
     *
     * @param accountNo
     * @param amount
     */
//    @Transactional
    @GlobalTransactional
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
        log.info("bank1 service begin,XID：{}", RootContext.getXID());
        //扣减张三的金额
        accountInfoDao.updateAccountBalance(accountNo,amount * -1);
        localTxDao.insert(amount + "");
//        int i = 1 / 0;
        //调用李四微服务，转账
        String transfer = bank2Client.transfer(amount);
        if("fallback".equals(transfer)){
            //调用李四微服务异常
            throw new RuntimeException("调用李四微服务异常");
        }
        if(amount == 2){
            //人为制造异常
            throw new RuntimeException("bank1 make exception..");
        }
    }
}
