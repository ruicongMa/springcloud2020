package com.mark.factory.simplefactory;

import com.mark.factory.ICourse;

/**
 * @author Mark
 * @date 2020/4/28 12:33
 */
public class CourseFactory {

    public static ICourse create(Class<? extends ICourse> clazz) {
        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // public static ICourse create(String className) {
    //     try {
    //         if (!(null == className || "".equals(className))) {
    //             return (ICourse) Class.forName(className).newInstance();
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

    // public static ICourse create(String name) {
    //     if ("java".equalsIgnoreCase(name)) {
    //         return new JavaCourse();
    //     } else if ("python".equalsIgnoreCase(name)) {
    //         return new PythonCourse();
    //     } else {
    //         return null;
    //     }
    // }
}
