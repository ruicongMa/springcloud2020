package com.mrc.springcloud.controller;

import com.example.demo.SayService;
import com.mrc.springcloud.entities.CommonResult;
import com.mrc.springcloud.entities.Payment;
import com.mrc.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mark
 * @date 2020/3/26 12:05
 */
@RestController
public class OrderController {

    private static final String PAYMENT_SERVICE = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private HelloService helloService;

    @Autowired
    private SayService sayService;

    @GetMapping("/hello")
    public Object hello() {
        System.out.println(helloService);
        System.out.println(sayService);
        return "ok";
    }

    // @Autowired
    // private RestTemplate restTemplate;
    //
    // @GetMapping("/consumer/payment/create")
    // public CommonResult<Payment> create(Payment payment) {
    //     return restTemplate.postForObject(PAYMENT_SERVICE + "/payment/create", payment, CommonResult.class);
    // }
    //
    // @GetMapping("/consumer/payment/get/{id}")
    // public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
    //     return restTemplate.getForObject(PAYMENT_SERVICE + "/payment/get/" + id, CommonResult.class);
    // }
    //
    // // ====================> zipkin+sleuth
    // @GetMapping("/consumer/payment/zipkin")
    // public String paymentZipkin() {
    //     String result = restTemplate.getForObject(PAYMENT_SERVICE + "/payment/zipkin/", String.class);
    //     return result;
    // }
}
