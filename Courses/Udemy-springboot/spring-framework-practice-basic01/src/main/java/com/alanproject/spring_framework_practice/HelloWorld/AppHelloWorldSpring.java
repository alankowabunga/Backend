package com.alanproject.spring_framework_practice.HelloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppHelloWorldSpring {
    public static void main(String[] args){


        //1. launch a spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);


        //2. configure what we want spring to manage - @Configuraion
        System.out.println(context.getBean("methodCallPerson"));

//        System.out.println(context.getBean("address2"));
//        System.out.println(Address.class);

        // print all beans' difinition name
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
