package com.mark.iterator.eg;

/**
 * @author Mark
 * @date 2020/5/20 10:13
 */
public interface CourseAggregate {

    void add(Course course);

    void remove(Course course);

    Iterator<Course> iterator();
}
