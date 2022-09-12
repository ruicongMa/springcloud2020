package com.markzoe.config;

import com.markzoe.entities.User1;
import com.markzoe.properties.PersonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mark
 * @date 2021/7/27 10:58
 */
@Configuration
@EnableConfigurationProperties(PersonProperty.class)
public class TestConfig {

    // private PersonProperty personProperty;
    //
    // public TestConfig(PersonProperty personProperty){
    //     this.personProperty = personProperty;
    //     System.out.println(personProperty);
    // }

    @Bean
    // @ConfigurationProperties(prefix = "person")
    public User1 myUser(PersonProperty personProperty) {
        User1 user1 = new User1();
        user1.setId(personProperty.getAge());
        user1.setName(personProperty.getName());
        return user1;
    }
}
