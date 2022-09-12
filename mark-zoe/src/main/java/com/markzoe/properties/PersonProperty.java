package com.markzoe.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Mark
 * @date 2021/7/27 11:02
 */
// @Component
@ConfigurationProperties(prefix = "person")
// @PropertySource(value = "classpath:conf/person.properties")
@Data
public class PersonProperty {

    private String name;
    private Integer age;
}
