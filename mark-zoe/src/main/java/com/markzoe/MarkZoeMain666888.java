package com.markzoe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mark
 * @date 2020/4/27 16:50
 */
@SpringBootApplication
@MapperScan("com.markzoe.dao")
public class MarkZoeMain666888 {

    public static void main(String[] args) {
        SpringApplication.run(MarkZoeMain666888.class, args);
    }
}
