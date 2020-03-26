package com.mrc.springcloud.service;

import com.mrc.springcloud.entities.Payment;

public interface PaymentService {

    int save(Payment payment);

    Payment getById(Long id);
}
