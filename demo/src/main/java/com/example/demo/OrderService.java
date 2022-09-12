package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Mark
 * @date 2021/9/4 13:43
 */
@Component
public class OrderService implements BeanPostProcessor {

    private String beanName;

    public OrderService() {
    }

    public OrderService(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization=>" + beanName);
        return bean;
    }
}
