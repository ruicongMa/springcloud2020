package com.mark.iterator.eg;

/**
 * @author Mark
 * @date 2020/5/20 10:21
 */
public class Test {

    public static void main(String[] args) {
        Course java = new Course("Java架构");
        Course javaBase = new Course("Java基础");
        Course design = new Course("Java设计模式");
        Course ai = new Course("人工智能");

        CourseAggregate courseAggregate = new CourseAggregateImpl();
        courseAggregate.add(java);
        courseAggregate.add(javaBase);
        courseAggregate.add(design);
        courseAggregate.add(ai);

        System.out.println("----------课程列表------------");
        printCourses(courseAggregate);
    }

    private static void printCourses(CourseAggregate courseAggregate) {
        Iterator<Course> iterator = courseAggregate.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            System.out.println("《" + course.getName() + "》");
        }
    }
}
