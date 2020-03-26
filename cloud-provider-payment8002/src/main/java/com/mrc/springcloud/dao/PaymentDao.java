package com.mrc.springcloud.dao;

import com.mrc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {

    int create(Payment payment);

    Payment getById(@Param("id") Long id);
}
