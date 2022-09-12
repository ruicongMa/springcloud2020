package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

// @Component
@ConfigurationProperties(prefix = "person")
// @PropertySource(value = "classpath:conf/person.properties")
@Data
public class PersonProperty {

    private String name;
    private Integer age;
}