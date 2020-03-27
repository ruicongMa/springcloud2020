package com.mrc.springcloud.controller;

import com.mrc.springcloud.entities.CommonResult;
import com.mrc.springcloud.entities.Payment;
import com.mrc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 以下判断代码都是伪代码，不是重点，企业里不会这么干！！！
 *
 * @author Mark
 * @date 2020/3/26 10:23
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("*****插入结果 result = {},port = {}", result, port);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功" + port, payment);
        } else {
            return new CommonResult(444, "插入数据库失败" + port, null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("*****查询结果 payment = {},port = {}", payment, port);
        if (payment != null) {
            return new CommonResult(200, "查询成功" + port, payment);
        } else {
            return new CommonResult(444, "查询为空" + port, null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service = {}", service);
        }
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            log.info("支付微服务信息，serviceId = {}, host = {}, port = {}, uri = {}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri());
        }
        return serviceInstanceList;
    }

}
