//package com.alan.spring_boot.learn_jpa_hibernate.course.jpa;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@Transactional
//public class JpaRepo {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void insert(Course course){
//        entityManager.merge(course);
//    }
//
//    public Course findById(long id){
//        return entityManager.find(Course.class,id);
//    }
//
//    public void deleteById(long id){
//        System.out.println("=== delete by jpa ===");
//        Course target = findById(id);
//        entityManager.remove(target);
//    }
//}
