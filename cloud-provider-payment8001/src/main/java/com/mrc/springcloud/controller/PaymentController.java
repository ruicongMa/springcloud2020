package com.mrc.springcloud.controller;

import com.mrc.springcloud.entities.CommonResult;
import com.mrc.springcloud.entities.Payment;
import com.mrc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 以下判断代码都是伪代码，不是重点，企业里不会这么干！！！
 *
 * @author Mark
 * @date 2020/3/26 10:23
 */
@RestController
@RequestMapping("/pay")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("*****插入结果 result = {}", result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", payment);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("*****查询结果 payment = {}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询为空", null);
        }
    }

}
