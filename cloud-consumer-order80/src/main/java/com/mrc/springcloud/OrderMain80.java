package com.mrc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2020/3/26 11:48
 */
@SpringBootApplication(scanBasePackages = {"com.mrc.springcloud", "com.example.demo"})
// @ComponentScan({"com.mrc.springcloud"})
// @EnableEurekaClient
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);

        // Timer timer = new Timer();
        // timer.schedule(new TimerTask() {
        //     @Override
        //     public void run() {
        //         System.out.println("ok");
        //     }
        // }, 2000, 5000);
    }
}
