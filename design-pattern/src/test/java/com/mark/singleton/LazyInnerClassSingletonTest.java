package com.mark.singleton;

import com.mark.singleton.innerclass.LazyInnerClassSingleton;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author Mark
 * @date 2020/4/29 17:19
 */
public class LazyInnerClassSingletonTest {

    @Test
    public void test() {
        try {
            //在很无聊的情况下，进行破坏
            Class clazz = LazyInnerClassSingleton.class;

            //通过反射获取私有构造方法
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);

            //暴力初始化
            //调用了两次构造方法，相当于new了两次，犯了原则性错误
            Object o1 = constructor.newInstance();
            Object o2 = constructor.newInstance();

            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
