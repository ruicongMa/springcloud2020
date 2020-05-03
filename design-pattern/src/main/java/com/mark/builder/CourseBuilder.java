package com.mark.builder;

import lombok.Data;

/**
 * @author Mark
 * @date 2020/5/3 11:58
 */
public class CourseBuilder {
    private Course course = new Course();

    public CourseBuilder addName(String name) {
        this.course.setName(name);
        return this;
    }

    public CourseBuilder addPPT(String ppt) {
        this.course.setPpt(ppt);
        return this;
    }

    public CourseBuilder addVideo(String video) {
        this.course.setVideo(video);
        return this;
    }

    public CourseBuilder addNote(String note) {
        this.course.setNote(note);
        return this;
    }

    public CourseBuilder addHomework(String homework) {
        this.course.setHomework(homework);
        return this;
    }

    public Course builder() {
        return this.course;
    }

    @Data
    public class Course {
        private String name;
        private String ppt;
        private String video;
        private String note;
        private String homework;
    }
}
