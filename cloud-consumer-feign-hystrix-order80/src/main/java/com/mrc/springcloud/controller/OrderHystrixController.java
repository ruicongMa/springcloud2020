package com.mrc.springcloud.controller;

import com.mrc.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark
 * @date 2020/3/28 17:43
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //全局的
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String consumerInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    // @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    // })
    @GetMapping("/consumer/hystrix/timeout/{id}")
    @HystrixCommand
    public String consumerInfo_TimeOut(@PathVariable("id") Integer id) {
        System.out.println(10 / 0);
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    //兜底方法
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙或运行报错, 请稍候再试  ,id：  " + id + "\t" + "o(╥﹏╥)o";
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
