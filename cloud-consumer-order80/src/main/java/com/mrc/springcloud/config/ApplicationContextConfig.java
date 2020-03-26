package com.mrc.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mark
 * @date 2020/3/26 12:09
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
