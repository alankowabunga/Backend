package com.alan.spring_boot.learn_jpa_hibernate.course.spring_data_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringJpaCommandLineRunner implements CommandLineRunner {
        @Autowired
        private SpringJpaRepo springJpaRepo;

        @Override
        public void run(String... args) throws Exception {
            springJpaRepo.save(new Course(1L,"jdbc","you"));
            springJpaRepo.save(new Course(2L,"jpa","you too"));
            springJpaRepo.save(new Course(3L,"hibernate","you again"));

            springJpaRepo.deleteById(2L);
            System.out.println("======= Spring Data Jpa===========");
//            System.out.println("id 3 :"+springJpaRepo.findById(3L));;
            System.out.println("@ data quantity:"+springJpaRepo.count());
            System.out.println("@ author is you :"+springJpaRepo.findByAuthor("you"));
    }

}
