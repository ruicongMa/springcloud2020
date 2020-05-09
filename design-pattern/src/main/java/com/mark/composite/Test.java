package com.mark.composite;

/**
 * @author Mark
 * @date 2020/5/9 20:05
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("==============透明组合模式==============");
        CourseComponent javaBean = new Course("Java入门课程", 666);
        CourseComponent ai = new Course("人工智能", 888);

        CourseComponent coursePackage = new CoursePackage("Java架构师课程", 2);
        CourseComponent design = new Course("Java设计模式", 1500);
        CourseComponent source = new Course("源码分析", 2000);
        CourseComponent softKill = new Course("软技能", 3000);

        coursePackage.addChild(design);
        coursePackage.addChild(source);
        coursePackage.addChild(softKill);

        CourseComponent catalog = new CoursePackage("课程主目录", 1);
        catalog.addChild(javaBean);
        catalog.addChild(ai);
        catalog.addChild(coursePackage);

        catalog.print();
    }
}
