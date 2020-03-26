package com.mrc.springcloud.service.impl;

import com.mrc.springcloud.dao.PaymentDao;
import com.mrc.springcloud.entities.Payment;
import com.mrc.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mark
 * @date 2020/3/26 10:18
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    @Transactional
    public int save(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
