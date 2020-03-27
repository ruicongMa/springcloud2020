package com.mrc.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mark
 * @date 2020/3/27 17:11
 */
@RestController
public class OrderConsulController {

    public static final String INVOME_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentConsul() {
        return restTemplate.getForObject(INVOME_URL + "/payment/consul", String.class);
    }
}
