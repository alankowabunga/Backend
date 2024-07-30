package com.alan.springboot.course_first_webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.alan.springboot.course_first_webapp")
public class CourseFirstWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseFirstWebappApplication.class, args);
	}

}
