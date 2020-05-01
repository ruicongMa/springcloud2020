package com.mark.factory.abstractfactory;

/**
 * @author Mark
 * @date 2020/4/28 14:10
 */
public class PythonCourseFactory extends CourseAbstractFactory {
    @Override
    protected IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }

    @Override
    protected INote createNote() {
        super.init();
        return new PythonNote();
    }
}
