package com.mark.factory.simplefactory;

import com.mark.factory.ICourse;
import com.mark.factory.PythonCourse;
import org.junit.Test;

/**
 * @author Mark
 * @date 2020/4/28 12:00
 */
public class SimpleFactoryTest {

    @Test
    public void test() {
        ICourse course = CourseFactory.create(PythonCourse.class);
        course.record();
    }

    // @Test
    // public void test() {
    //     ICourse course = CourseFactory.create("com.mark.factory.simple.JavaCourse");
    //     course.record();
    // }

    // @Test
    // public void test() {
    //     ICourse course = CourseFactory.create("python");
    //     course.record();
    // }

    // @Test
    // public void test() {
    //     ICourse course = new JavaCourse();
    //     course.record();
    // }
}
