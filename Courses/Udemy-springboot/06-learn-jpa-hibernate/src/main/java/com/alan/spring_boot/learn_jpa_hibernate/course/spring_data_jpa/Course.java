package com.alan.spring_boot.learn_jpa_hibernate.course.spring_data_jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {

    // jpa mapping
    @Id
    private Long id;
    @Column(name="name") // 相同名稱可忽略
    private String name;
    @Column(name = "author")
    private String author;

    public Course(){
    }
    public Course(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
