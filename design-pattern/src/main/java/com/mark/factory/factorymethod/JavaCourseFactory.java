package com.mark.factory.factorymethod;

import com.mark.factory.ICourse;
import com.mark.factory.JavaCourse;

/**
 * @author Mark
 * @date 2020/4/28 13:18
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
