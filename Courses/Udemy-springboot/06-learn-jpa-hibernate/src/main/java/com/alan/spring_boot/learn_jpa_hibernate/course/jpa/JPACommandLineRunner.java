//package com.alan.spring_boot.learn_jpa_hibernate.course.jpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JPACommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    private JpaRepo jpaRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        jpaRepo.insert(new Course(1L,"jdbc","you"));
//        jpaRepo.insert(new Course(2L,"jpa","you too"));
//        jpaRepo.insert(new Course(3L,"hibernate","you again"));
//
//        jpaRepo.deleteById(2L);
//
//        System.out.println("id 3 :"+jpaRepo.findById(3L));;
//    }
//}
