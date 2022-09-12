package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Mark
 * @date 2022/5/7 12:51
 */
@Component
public class TestInit implements InitializingBean {

    private String beanName;

    public TestInit() {
        System.out.println("xxxooo");
    }

    public TestInit(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet.....");
    }
}
