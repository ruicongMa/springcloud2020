package com.mark.factory.abstractfactory;

/**
 * @author Mark
 * @date 2020/4/28 13:56
 */
public abstract class CourseAbstractFactory {

    public void init() {
        System.out.println("初始化基础数据");
    }

    protected abstract IVideo createVideo();

    protected abstract INote createNote();
}
