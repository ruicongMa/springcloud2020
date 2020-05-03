package com.mark.builder;

import org.junit.Test;

/**
 * @author Mark
 * @date 2020/5/3 12:03
 */
public class BuilderTest {

    @Test
    public void test() {
        CourseBuilder builder = new CourseBuilder();
        builder.addName("建造者设计模式")
                .addPPT("【PPT课件】")
                .addVideo("【回放视频】")
                .addNote("【课后作业】");
        System.out.println(builder.builder());
    }

    // @Test
    // public void test() {
    //     CourseBuilder builder = new CourseBuilder();
    //     builder.addName("建造者设计模式");
    //     builder.addPPT("【PPT课件】");
    //     builder.addVideo("【回放视频】");
    //     builder.addNote("【课后作业】");
    //     System.out.println(builder.builder());
    // }
}
