package com.markzoe.compent;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Mark
 * @date 2021/7/28 13:40
 */
@Component
public class TestInit implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("==============ok===============");
    }
}
