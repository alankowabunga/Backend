package com.alan.springboot.learn_spring_boot;

public class Course {

    private Long id;
    private String course;

    public Course(Long id, String course) {
        this.id = id;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course='" + course + '\'' +
                '}';
    }
}
