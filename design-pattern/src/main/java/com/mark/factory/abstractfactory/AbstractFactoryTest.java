package com.mark.factory.abstractfactory;

import org.junit.Test;

/**
 * @author Mark
 * @date 2020/4/28 14:12
 */
public class AbstractFactoryTest {

    @Test
    public void test() {
        JavaCourseFactory factory = new JavaCourseFactory();
        factory.createVideo().record();
        factory.createNote().edit();
    }
}
