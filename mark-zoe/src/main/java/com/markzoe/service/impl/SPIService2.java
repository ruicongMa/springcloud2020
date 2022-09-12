package com.markzoe.service.impl;

import com.markzoe.service.SPITest;

/**
 * @author Mark
 * @date 2021/8/4 23:32
 */
public class SPIService2 implements SPITest {

    @Override
    public void say() {
        System.out.println("spi service two...");
    }
}
