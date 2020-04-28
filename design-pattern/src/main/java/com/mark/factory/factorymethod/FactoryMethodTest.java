package com.mark.factory.factorymethod;

import com.mark.factory.ICourse;
import org.junit.Test;

/**
 * @author Mark
 * @date 2020/4/28 13:21
 */
public class FactoryMethodTest {

    @Test
    public void test() {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new PythonCourseFactory();
        course = factory.create();
        course.record();
    }
}
