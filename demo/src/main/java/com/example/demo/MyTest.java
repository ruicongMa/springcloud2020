package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Mark
 * @date 2021/9/4 13:44
 */
public class MyTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // UserService userService = applicationContext.getBean(UserService.class);
        // userService.test();

        Object testMoe = applicationContext.getBean("testZoe");
        System.out.println(testMoe);

        // UserService userService = new UserService();
        // Type genericSuperclass = userService.getClass().getGenericSuperclass();
        // ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        // Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        // for (Type actualTypeArgument : actualTypeArguments) {
        //     Class clazz = (Class) actualTypeArgument;
        //     if (clazz == OrderService.class) {
        //         System.out.println("===>" + actualTypeArgument);
        //     }
        // }
    }
}
