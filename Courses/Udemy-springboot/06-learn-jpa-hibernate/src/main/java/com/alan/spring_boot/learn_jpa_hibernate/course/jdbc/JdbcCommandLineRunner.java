//package com.alan.spring_boot.learn_jpa_hibernate.course.jdbc;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JdbcCommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    private JdbcRepo jdbcRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        jdbcRepo.insert(new Course(1L,"jdbc","you"));
//        jdbcRepo.insert(new Course(2L,"jpa","you too"));
//        jdbcRepo.insert(new Course(3L,"hibernate","you again"));
//
//        jdbcRepo.deleteById(2L);
//
//        System.out.println("id 3 :"+jdbcRepo.findById(3L));;
//    }
//}
