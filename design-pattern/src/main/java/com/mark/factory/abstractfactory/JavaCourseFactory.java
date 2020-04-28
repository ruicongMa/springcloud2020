package com.mark.factory.abstractfactory;

/**
 * @author Mark
 * @date 2020/4/28 14:03
 */
public class JavaCourseFactory extends CourseAbstractFactory {
    @Override
    protected IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }

    @Override
    protected INote createNote() {
        super.init();
        return new JavaNote();
    }
}
