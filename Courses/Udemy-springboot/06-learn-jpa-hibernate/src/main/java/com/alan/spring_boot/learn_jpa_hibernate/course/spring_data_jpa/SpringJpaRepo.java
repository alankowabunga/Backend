package com.alan.spring_boot.learn_jpa_hibernate.course.spring_data_jpa;


import org.springframework.data.jpa.repository.JpaRepository;
public interface SpringJpaRepo extends JpaRepository<Course,Long> {

    public Course findByAuthor(String name);
}
