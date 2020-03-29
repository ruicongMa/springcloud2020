package com.mrc.springcloud.service.hystrix;

import com.mrc.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author Mark
 * @date 2020/3/29 20:02
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
