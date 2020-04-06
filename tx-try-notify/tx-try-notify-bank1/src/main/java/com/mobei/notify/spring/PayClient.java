package com.mobei.notify.spring;

import com.mobei.notify.entity.AccountPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用pay充值系统
 */
@FeignClient(value = "dtx-notifymsg-demo-pay",fallback = PayFallback.class)
public interface PayClient {

    /**
     * 远程调用充值系统的接口查询充值结果
     * @param txNo
     * @return
     */
    @GetMapping(value = "/pay/payresult/{txNo}")
    AccountPay payresult(@PathVariable("txNo") String txNo);
}
