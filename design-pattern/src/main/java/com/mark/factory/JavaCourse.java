package com.mark.factory;

/**
 * @author Mark
 * @date 2020/4/28 11:57
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
