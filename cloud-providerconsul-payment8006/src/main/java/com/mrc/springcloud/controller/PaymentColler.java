package com.mrc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Mark
 * @date 2020/3/27 17:02
 */
@RestController
public class PaymentColler {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
