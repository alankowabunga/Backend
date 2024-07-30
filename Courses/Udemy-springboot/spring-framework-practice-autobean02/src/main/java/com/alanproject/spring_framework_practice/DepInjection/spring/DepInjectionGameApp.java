package com.alanproject.spring_framework_practice.DepInjection.spring;

import com.alanproject.spring_framework_practice.game.GameRunner;
import com.alanproject.spring_framework_practice.game.GamingConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*

Types of dependency injections
@ComponentScan 預設會搜尋當前檔案的 Beans (@Component)
* */
@Component
class BusinessLogic {

    /* 1. Field Injection
    @Autowired
    Dependency1 dependency1;
    @Autowired
    Dependency2 dependency2;
    * */
    Dependency1 dependency1;
    Dependency2 dependency2;

    /* 2. Setter Injection
    @Autowired
    public void d1setter(Dependency1 d1){
        this.dependency1 = d1;
    }
    @Autowired
    public void d2setter(Dependency2 d2){
        this.dependency2 = d2;
    }*/

    // 3. Constructor Injection (recommanded, ready when initilized )
    @Autowired
    public BusinessLogic(Dependency1 d1, Dependency2 d2) {
        super();
        this.dependency1 = d1;
        this.dependency2 = d2;
    }

    public String toString() {
        return "@ d1 :" + dependency1 + "， d2 :" + dependency2;
    }

}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan()
public class DepInjectionGameApp {

    public static void main(String[] args) {
        //create spring context w/ config class
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjectionGameApp.class)) {

//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessLogic.class));
        }
    }
}
