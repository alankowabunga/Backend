package com.alan.springboot.learn_spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DataController {

    @RequestMapping("/courses")
    public List<Course> getAllCourse(){
        return Arrays.asList(
                new Course(1L,"springboot"),
                new Course(2L,"devop"),
                new Course(3L,"backend")
        );
    }
}
